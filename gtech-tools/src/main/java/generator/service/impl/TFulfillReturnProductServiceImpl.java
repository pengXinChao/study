package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TFulfillReturnProduct;
import generator.service.TFulfillReturnProductService;
import com.person.gtech.dao.mapper.TFulfillReturnProductMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_fulfill_return_product(t_fulfill_return_product（退换货处理商品表）)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TFulfillReturnProductServiceImpl extends ServiceImpl<TFulfillReturnProductMapper, TFulfillReturnProduct>
    implements TFulfillReturnProductService{

}




