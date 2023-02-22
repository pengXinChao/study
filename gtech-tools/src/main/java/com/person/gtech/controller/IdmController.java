package com.person.gtech.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.person.gtech.dto.UserAccount;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.util.Assert;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭心潮
 * @date 2023/2/10 10:57
 */
@RestController
@Slf4j
public class IdmController {

    public static void main(String[] args) throws Exception {
        new IdmController().createIdmAccount();
    }

    @Resource
    private RestTemplate restTemplate;


    @PostMapping("/createAccount")
    public void createIdmAccount() throws Exception {
        File file = new File("D:\\Person Develop\\study\\gtech-tools\\src\\main\\resources\\OMS账号申请表第二批-0209.xlsx");
        String orgCode = "10000055";
        if (!file.exists()){
            throw new Exception("文件不存在!");
        }
        InputStream in = new FileInputStream(file);

        // 读取整个Excel
        XSSFWorkbook sheets = new XSSFWorkbook(in);
        // 获取第一个表单Sheet
        XSSFSheet sheetAt = sheets.getSheetAt(0);

        //默认第一行为标题行，i = 0
        XSSFRow titleRow = sheetAt.getRow(0);
        List<UserAccount> userAccountList = new ArrayList<>();
        // 循环获取每一行数据
        for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheetAt.getRow(i);
            // 读取每一格内容
            String name = row.getCell(0).getStringCellValue();
            XSSFCell cell = row.getCell(1);
            cell.setCellType(CellType.STRING);
            String telephone = cell.getStringCellValue();
            String email = row.getCell(2).getStringCellValue();
            String role = row.getCell(3).getStringCellValue();
            String roleCode = "";
            if (StringUtils.equals(role, "客服主管")) {
                roleCode = "SERVICE_MANAGER";
            } else if (StringUtils.equals(role, "售后主管")) {
                roleCode = "RO000002";
            } else if (StringUtils.equals(role, "客服")) {
                roleCode = "NORMAL_SERVICE";
            }

            UserAccount userAccount = new UserAccount();
            userAccount.setDomainCode("DC0005");
            userAccount.setTenantCode("200005");
            userAccount.setAccount(StringUtils.trim(email));
            userAccount.setEmail(StringUtils.trim(email));
            userAccount.setEmailVerified("0");
            userAccount.setFirstName(StringUtils.substring(name, 0, 1));
            userAccount.setLastName(StringUtils.substring(name, 1, name.length()));
            userAccount.setRoleCodeList(Arrays.asList(roleCode));
            userAccount.setMobile(telephone);
            userAccount.setOrgCode(orgCode);
            userAccount.setPassword(StringUtils.substring(email, 0, StringUtils.indexOf(email, "@")));
            userAccount.setUserType("3");
            userAccountList.add(userAccount);
        }
        System.out.println(JSON.toJSONString(userAccountList));

        for (UserAccount userAccount : userAccountList) {
            this.createAccount(userAccount);
        }
    }

    private void createAccount(UserAccount userAccount) {
        String url = "https://oms-gateway-stg.underarmour.cn/api/idm/userAccount/createUserAccount";
//        String url = "https://oms-gateway.underarmour.cn/api/idm/userAccount/createUserAccount";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String result = this.restTemplate.postForObject(url, new HttpEntity<>(userAccount, httpHeaders), String.class);
        JSONObject resultJson = JSONObject.parseObject(result);
        Boolean success = resultJson.getBoolean("success");
        log.info("账号创建结果：{}", result);
    }
}
