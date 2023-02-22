package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TOrderReceive;
import generator.service.TOrderReceiveService;
import com.person.gtech.dao.mapper.TOrderReceiveMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_order_receive(订单收件人表)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TOrderReceiveServiceImpl extends ServiceImpl<TOrderReceiveMapper, TOrderReceive>
    implements TOrderReceiveService{

}




