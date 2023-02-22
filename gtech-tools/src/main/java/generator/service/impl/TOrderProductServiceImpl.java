package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TOrderProduct;
import generator.service.TOrderProductService;
import com.person.gtech.dao.mapper.TOrderProductMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_order_product(订单商品明细表)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TOrderProductServiceImpl extends ServiceImpl<TOrderProductMapper, TOrderProduct>
    implements TOrderProductService{

}




