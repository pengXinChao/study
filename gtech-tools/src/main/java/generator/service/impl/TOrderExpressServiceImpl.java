package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TOrderExpress;
import generator.service.TOrderExpressService;
import com.person.gtech.dao.mapper.TOrderExpressMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_order_express(t_order_express（订单快递表）)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TOrderExpressServiceImpl extends ServiceImpl<TOrderExpressMapper, TOrderExpress>
    implements TOrderExpressService{

}




