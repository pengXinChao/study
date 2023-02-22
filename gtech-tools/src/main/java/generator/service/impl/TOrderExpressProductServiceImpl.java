package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TOrderExpressProduct;
import generator.service.TOrderExpressProductService;
import com.person.gtech.dao.mapper.TOrderExpressProductMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_order_express_product(t_order_express_product（快递对应的包裹明细）)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TOrderExpressProductServiceImpl extends ServiceImpl<TOrderExpressProductMapper, TOrderExpressProduct>
    implements TOrderExpressProductService{

}




