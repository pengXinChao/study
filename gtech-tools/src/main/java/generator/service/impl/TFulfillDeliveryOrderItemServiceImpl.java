package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TFulfillDeliveryOrderItem;
import generator.service.TFulfillDeliveryOrderItemService;
import com.person.gtech.dao.mapper.TFulfillDeliveryOrderItemMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_fulfill_delivery_order_item(t_fulfill_delivery_order_item（发货单行表）)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:12
*/
@Service
public class TFulfillDeliveryOrderItemServiceImpl extends ServiceImpl<TFulfillDeliveryOrderItemMapper, TFulfillDeliveryOrderItem>
    implements TFulfillDeliveryOrderItemService{

}




