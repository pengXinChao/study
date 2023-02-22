package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TOrderOrder;
import generator.service.TOrderOrderService;
import com.person.gtech.dao.mapper.TOrderOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_order_order(订单表)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TOrderOrderServiceImpl extends ServiceImpl<TOrderOrderMapper, TOrderOrder>
    implements TOrderOrderService{

}




