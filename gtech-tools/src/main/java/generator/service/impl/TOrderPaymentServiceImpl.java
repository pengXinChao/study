package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TOrderPayment;
import generator.service.TOrderPaymentService;
import com.person.gtech.dao.mapper.TOrderPaymentMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_order_payment('test_order_db.sw_report' is not BASE TABLE)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TOrderPaymentServiceImpl extends ServiceImpl<TOrderPaymentMapper, TOrderPayment>
    implements TOrderPaymentService{

}




