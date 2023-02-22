package com.person.gtech.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.person.gtech.dao.entity.BaseReceiver;
import com.person.gtech.dao.entity.OrderSecretConfig;
import com.person.gtech.dao.entity.TFulfillExchange;
import com.person.gtech.dao.entity.TMasterdataDistrict;
import com.person.gtech.dao.entity.TOrderReceive;
import com.person.gtech.dao.mapper.TFulfillExchangeMapper;
import com.person.gtech.dao.mapper.TMasterdataDistrictMapper;
import com.person.gtech.dao.mapper.TOrderReceiveMapper;
import com.person.gtech.dto.CreateOrderDTO;
import com.person.gtech.service.OrderService;
import com.person.gtech.utils.EncryptUtils;
import com.person.gtech.utils.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 彭心潮
 * @date 2022/12/4 23:29
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private TOrderReceiveMapper orderReceiveMapper;

    @Resource
    private TMasterdataDistrictMapper masterdataDistrictMapper;

    @Resource
    private TFulfillExchangeMapper fULfillExchangeMapper;

    private static final Pattern ADDRESS_COMPILE = Pattern.compile("[\\d一二三四五六七八九十]");

    private static final ThreadPoolExecutor HANDLE_TASK_POOL_EXECUTOR;

    static {
        ThreadFactory handleTaskThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("handle-task-pool-%d")
                .build();
        HANDLE_TASK_POOL_EXECUTOR = new ThreadPoolExecutor(4, 20,
                120L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), handleTaskThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }


    @PostMapping("/create")
    public void createOrder(@RequestBody CreateOrderDTO createParam) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        List<String> orderCodes = this.getOrderCodes(createParam.getCreateQty());
        JSONObject orderIn = createParam.getOrderIn();
        long startTime = System.currentTimeMillis();
        for (String orderCode : orderCodes) {
            orderIn.put("orderCode", orderCode);
            this.orderService.createOrder(orderIn);
        }
        log.info("发送{}个创单MQ消息耗时:{}ms", createParam.getCreateQty(), System.currentTimeMillis() - startTime);
    }

    @PostMapping("/convertOrderReceiver")
    public void convertOrderReceiver() {
        OrderSecretConfig config = OrderSecretConfig.init();
        List<TMasterdataDistrict> allDistrict = this.queryAllDistrict();
        List<TMasterdataDistrict> provinceList = allDistrict.stream().filter(e -> e.getLevel().equals(0)).collect(Collectors.toList());
        List<TMasterdataDistrict> cityList = allDistrict.stream().filter(e -> e.getLevel().equals(1)).collect(Collectors.toList());
        List<TMasterdataDistrict> districtList = allDistrict.stream().filter(e -> e.getLevel().equals(2)).collect(Collectors.toList());
        int pageNo = 1;
        int pageSize = 10000000;
        int total = 0;
        Page<TOrderReceive> page = new Page<>(pageNo, pageSize, Boolean.FALSE);
        do {
            int startIdx = (pageNo - 1) * pageSize;
            page.setPages(pageNo);
            List<TOrderReceive> receiverList = this.orderReceiveMapper.queryList(startIdx, pageSize);
            if (CollectionUtils.isEmpty(receiverList)) {
                break;
            }
            List<List<TOrderReceive>> receiverGroup = ListUtil.splitList(receiverList, 1000);
            for (List<TOrderReceive> tOrderReceives : receiverGroup) {
                HANDLE_TASK_POOL_EXECUTOR.execute(() -> {
                    for (TOrderReceive receive : tOrderReceives) {
                        this.orderReceiverDataUpdate(receive, config, provinceList, cityList, districtList);
                    }
                    log.info("当前线程处理结束.....");
                });
            }

            total = total + receiverList.size();
            log.info("数据处理结束, pageNo:{}, totals:{}", pageNo, total);
            pageNo++;
        } while (true);
        log.info("数据处理结束-------------");
    }

    @PostMapping("/convertExchangeReceiver")
    public void convertExchangeReceiver() {
        OrderSecretConfig config = OrderSecretConfig.init();
        List<TMasterdataDistrict> allDistrict = this.queryAllDistrict();
        List<TMasterdataDistrict> provinceList = allDistrict.stream().filter(e -> e.getLevel().equals(0)).collect(Collectors.toList());
        List<TMasterdataDistrict> cityList = allDistrict.stream().filter(e -> e.getLevel().equals(1)).collect(Collectors.toList());
        List<TMasterdataDistrict> districtList = allDistrict.stream().filter(e -> e.getLevel().equals(2)).collect(Collectors.toList());

        int pageNo = 1;
        int pageSize = 100000000;
        int total = 0;
        Page<TFulfillExchange> page = new Page<>(pageNo, pageSize, Boolean.FALSE);
        do {
            int startIdx = (pageNo - 1) * pageSize;
            page.setPages(pageNo);
            List<TFulfillExchange> receiverList = this.fULfillExchangeMapper.queryList(startIdx, pageSize);
            if (CollectionUtils.isEmpty(receiverList)) {
                break;
            }
            List<List<TFulfillExchange>> lists = ListUtil.splitListByGroupNumber(receiverList, 1000);
            for (List<TFulfillExchange> list : lists) {
                HANDLE_TASK_POOL_EXECUTOR.execute(() -> {
                    for (TFulfillExchange receive : list) {
                        this.orderReceiverDataUpdate(receive, config, provinceList, cityList, districtList);
                    }
                    log.info("当前线程处理结束.....");
                });
            }

            total = total + receiverList.size();
            log.info("数据处理结束, pageNo:{}, totals:{}", pageNo, total);
            pageNo++;
        } while (true);
        log.info("数据处理结束-------------");
    }

    private void orderReceiverDataUpdate(TOrderReceive receive, OrderSecretConfig config, List<TMasterdataDistrict> provinceList, List<TMasterdataDistrict> cityList, List<TMasterdataDistrict> districtList) {
        BaseReceiver baseReceiver = new BaseReceiver();
        baseReceiver.setName(receive.getName());
        baseReceiver.setMail(receive.getMail());
        baseReceiver.setTelephone(receive.getTelephone());
        baseReceiver.setMobile(receive.getMobile());
        baseReceiver.setAddress(receive.getAddress());
        baseReceiver.setDesensitizationName(receive.getDesensitizationName());
        baseReceiver.setDesensitizationMobile(receive.getDesensitizationMobile());
        baseReceiver.setDesensitizationTelephone(receive.getDesensitizationTelephone());
        baseReceiver.setDesensitizationAddress(receive.getDesensitizationAddress());

        boolean canDecrypt = EncryptUtils.sha256Decrypt(receive.getName(), config.getSecret());
        boolean addressHasMapping = StringUtils.isNotBlank(receive.getProvince());
        if (addressHasMapping) {
            return;
        }
        if (canDecrypt) {
            return;
        }
        this.receiverEncrypt(baseReceiver, config);

        receive.setName(baseReceiver.getName());
        receive.setMail(baseReceiver.getMail());
        receive.setTelephone(baseReceiver.getTelephone());
        receive.setMobile(baseReceiver.getMobile());
        receive.setAddress(baseReceiver.getAddress());
        receive.setDesensitizationName(baseReceiver.getDesensitizationName());
        receive.setDesensitizationMobile(baseReceiver.getDesensitizationMobile());
        receive.setDesensitizationTelephone(baseReceiver.getDesensitizationTelephone());
        receive.setDesensitizationAddress(baseReceiver.getDesensitizationAddress());

        if (StringUtils.isBlank(receive.getCountryName())) {
            receive.setCountryName("中国");
        }
        receive.setCountry("1");


        String provinceName = receive.getProvinceName();
        provinceName = StringUtils.removeEnd(provinceName, "省");
        provinceName = StringUtils.removeEnd(provinceName, "市");
        provinceName = StringUtils.removeEnd(provinceName, "区");

        for (TMasterdataDistrict province : provinceList) {
            if (province.getDistrictName().contains(provinceName) || provinceName.contains(province.getDistrictName())) {
                receive.setProvince(province.getDistrictCode());
                break;
            }
        }

        String cityName = receive.getCityName();
        cityName = StringUtils.removeEnd(cityName, "省");
        cityName = StringUtils.removeEnd(cityName, "市");
        cityName = StringUtils.removeEnd(cityName, "区");
        for (TMasterdataDistrict city : cityList) {
            if (city.getDistrictName().contains(cityName) || cityName.contains(city.getDistrictName())) {
                receive.setCity(city.getDistrictCode());
                break;
            }
        }

        String districtName = receive.getDistrictName();
        districtName = StringUtils.removeEnd(districtName, "省");
        districtName = StringUtils.removeEnd(districtName, "市");
        districtName = StringUtils.removeEnd(districtName, "区");
        for (TMasterdataDistrict district : districtList) {
            if (district.getDistrictName().contains(districtName) || districtName.contains(district.getDistrictName())) {
                receive.setDistrict(district.getDistrictCode());
                break;
            }
        }

        this.orderReceiveMapper.updateReceive(receive);
    }

    private void orderReceiverDataUpdate(TFulfillExchange receive, OrderSecretConfig config, List<TMasterdataDistrict> provinceList, List<TMasterdataDistrict> cityList, List<TMasterdataDistrict> districtList) {
        BaseReceiver baseReceiver = new BaseReceiver();
        baseReceiver.setName(receive.getName());
        baseReceiver.setMail(receive.getMail());
        baseReceiver.setTelephone(receive.getTelephone());
        baseReceiver.setMobile(receive.getMobile());
        baseReceiver.setAddress(receive.getAddress());
        baseReceiver.setDesensitizationName(receive.getDesensitizationName());
        baseReceiver.setDesensitizationMobile(receive.getDesensitizationMobile());
        baseReceiver.setDesensitizationTelephone(receive.getDesensitizationTelephone());
        baseReceiver.setDesensitizationAddress(receive.getDesensitizationAddress());

        boolean canDecrypt = EncryptUtils.sha256Decrypt(receive.getName(), config.getSecret());
        if (canDecrypt) {
            return;
        }
        this.receiverEncrypt(baseReceiver, config);

        receive.setName(baseReceiver.getName());
        receive.setMail(baseReceiver.getMail());
        receive.setTelephone(baseReceiver.getTelephone());
        receive.setMobile(baseReceiver.getMobile());
        receive.setAddress(baseReceiver.getAddress());
        receive.setDesensitizationName(baseReceiver.getDesensitizationName());
        receive.setDesensitizationMobile(baseReceiver.getDesensitizationMobile());
        receive.setDesensitizationTelephone(baseReceiver.getDesensitizationTelephone());
        receive.setDesensitizationAddress(baseReceiver.getDesensitizationAddress());

        if (StringUtils.isBlank(receive.getCountryName())) {
            receive.setCountryName("中国");
        }
        receive.setCountry("1");


        String provinceName = receive.getProvinceName();
        provinceName = StringUtils.removeEnd(provinceName, "省");
        provinceName = StringUtils.removeEnd(provinceName, "市");
        provinceName = StringUtils.removeEnd(provinceName, "区");

        for (TMasterdataDistrict province : provinceList) {
            if (province.getDistrictName().contains(provinceName) || provinceName.contains(province.getDistrictName())) {
                receive.setProvince(province.getDistrictCode());
                break;
            }
        }

        String cityName = receive.getCityName();
        cityName = StringUtils.removeEnd(cityName, "省");
        cityName = StringUtils.removeEnd(cityName, "市");
        cityName = StringUtils.removeEnd(cityName, "区");
        for (TMasterdataDistrict city : cityList) {
            if (city.getDistrictName().contains(cityName) || cityName.contains(city.getDistrictName())) {
                receive.setCity(city.getDistrictCode());
                break;
            }
        }

        String districtName = receive.getDistrictName();
        districtName = StringUtils.removeEnd(districtName, "省");
        districtName = StringUtils.removeEnd(districtName, "市");
        districtName = StringUtils.removeEnd(districtName, "区");
        for (TMasterdataDistrict district : districtList) {
            if (district.getDistrictName().contains(districtName) || districtName.contains(district.getDistrictName())) {
                receive.setDistrict(district.getDistrictCode());
                break;
            }
        }

        this.fULfillExchangeMapper.updateReceive(receive);
    }

    public List<TMasterdataDistrict> queryAllDistrict() {
        return this.masterdataDistrictMapper.queryAll();
    }

    public void receiverEncrypt(BaseReceiver receiver, OrderSecretConfig secretConfig) {
        if (receiver == null) {
            return;
        }

        // Step2: 数据脱敏
        this.receiverDesensitization(receiver);

        // Step3: 数据加密
        this.doEncrypt(receiver, secretConfig);
    }

    private void doEncrypt(@NotNull BaseReceiver receiver, @NotNull OrderSecretConfig secretConfig) {
        String secret = secretConfig.getSecret();
        String encryptedName = EncryptUtils.sha256Encrypt(receiver.getName(), secret);
        String encryptedTelephone = EncryptUtils.sha256Encrypt(receiver.getTelephone(), secret);
        String encryptedMobile = EncryptUtils.sha256Encrypt(receiver.getMobile(), secret);
        String encryptedEmail = EncryptUtils.sha256Encrypt(receiver.getMail(), secret);
        String encryptedAddress = EncryptUtils.sha256Encrypt(receiver.getAddress(), secret);

        receiver.setName(encryptedName);
        receiver.setMobile(encryptedMobile);
        receiver.setTelephone(encryptedTelephone);
        receiver.setMail(encryptedEmail);
        receiver.setAddress(encryptedAddress);
    }

    private void receiverDesensitization(BaseReceiver receiver) {
        this.receiverNameDesensitization(receiver);
        this.receiverMobileDesensitization(receiver);
        this.receiverEmailDesensitization(receiver);
        this.receiverAddressDesensitization(receiver);
    }


    /**
     * 收件人名称脱敏。
     * 脱敏规则: 名称长度小于等于1时, 不需要脱敏， 长度超过1时, 对首个字符脱敏
     *
     * @param receiver com.gtech.ecomm.order.entity.BaseReceiver
     */
    private void receiverNameDesensitization(BaseReceiver receiver) {
        String desensitizationName = receiver.getDesensitizationName();
        String fullName = receiver.getName();
        if (StringUtils.isNotBlank(desensitizationName)) {
            return;
        }
        if (fullName == null) {
            desensitizationName = null;
        } else if (StringUtils.isNotBlank(fullName) && StringUtils.length(fullName) > 1) {
            String firstName = StringUtils.left(fullName, 1);
            desensitizationName = firstName + "**";
        } else {
            desensitizationName = fullName;
        }
        receiver.setDesensitizationName(desensitizationName);
    }

    /**
     * 收件人手机电话脱敏
     *
     * @param receiver com.gtech.ecomm.order.entity.BaseReceiver
     */
    private void receiverMobileDesensitization(BaseReceiver receiver) {
        String desensitizationMobile = this.mobileDesensitization(receiver.getMobile(), receiver.getDesensitizationMobile());
        receiver.setDesensitizationMobile(desensitizationMobile);
        String desensitizationTelephone = this.mobileDesensitization(receiver.getTelephone(), receiver.getDesensitizationTelephone());
        receiver.setDesensitizationTelephone(desensitizationTelephone);
    }

    /**
     * 收件人地址脱敏
     *
     * @param receiver 收件人信息
     */
    private void receiverAddressDesensitization(BaseReceiver receiver) {
        String desensitizationAddress = receiver.getDesensitizationAddress();
        if (StringUtils.isNotBlank(desensitizationAddress)) {
            return;
        }
        String address = receiver.getAddress();
        desensitizationAddress = "";
        if (address == null) {
            desensitizationAddress = null;
        } else if (StringUtils.isNotBlank(address)) {
            desensitizationAddress = RegExUtils.replaceAll(address, ADDRESS_COMPILE, "*");
        }
        receiver.setDesensitizationAddress(desensitizationAddress);
    }

    /**
     * 收件人邮箱脱敏
     * 脱敏规则:
     * 1. 正常邮箱号(包含@), @符号前全部脱敏，替换为4位*， @符号后保留4位字符, 保留字符后的字符全部脱敏
     * 2. 非正常邮箱号(不包含@), 保留最后4位字符
     *
     * @param receiver com.gtech.ecomm.order.entity.BaseReceiver
     */
    private void receiverEmailDesensitization(BaseReceiver receiver) {
        String desensitizationEmail = receiver.getDesensitizationEmail();
        String email = receiver.getMail();
        if (StringUtils.isNotBlank(desensitizationEmail)) {
            return;
        }
        desensitizationEmail = "";
        if (email == null) {
            desensitizationEmail = null;
        }
        if (StringUtils.isNotBlank(email)) {
            if (StringUtils.contains(email, "@")) {
                desensitizationEmail = RegExUtils.replaceAll(email, "(.*)(.{4})@(\\w*)", "$1****@$3");
            } else {
                desensitizationEmail = RegExUtils.replaceAll(email, "(.*)(\\w{4})", "****$2");
            }
        }
        receiver.setDesensitizationEmail(desensitizationEmail);
    }

    /**
     * 手机号/电话号脱敏
     * 脱敏规则:
     * 1. 外部传入脱敏值, 使用外部脱敏值
     * 2. 外部未传入脱敏值：
     * 2.1:  号码为空值时， 脱敏值为空值
     * 2.2:  号码长度为1-4时， 脱敏值为****
     * 2.3:  号码长度大于4时， 保留最后4位电话号, 前面的位数替换为7位*号
     *
     * @param mobile                电话号码
     * @param desensitizationMobile 外部电话号码
     * @return 脱敏电话号码
     */
    private String mobileDesensitization(String mobile, String desensitizationMobile) {
        if (StringUtils.isNotBlank(desensitizationMobile)) {
            return desensitizationMobile;
        }
        desensitizationMobile = "";
        if (mobile == null) {
            desensitizationMobile = null;
        } else if (StringUtils.isNotBlank(mobile)) {
            // 保留后4位, 前面的替换为7位*
            desensitizationMobile = RegExUtils.replaceAll(mobile, "(.*)(\\w{4})", "*******$2");
        }
        return desensitizationMobile;
    }

    private List<String> getOrderCodes(int qty) {
        long timestamp = System.currentTimeMillis();
        List<String> result = new ArrayList<>(qty);
        for (int i = 0; i < qty; i++) {
            timestamp = timestamp + 1;
            result.add(timestamp + "");
        }
        return result;
    }
}
