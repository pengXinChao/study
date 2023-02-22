package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.gtech.dao.entity.TFulfillReturn;
import generator.service.TFulfillReturnService;
import com.person.gtech.dao.mapper.TFulfillReturnMapper;
import org.springframework.stereotype.Service;

/**
* @author pxc16
* @description 针对表【t_fulfill_return(t_fulfill_return（退换货单主表）)】的数据库操作Service实现
* @createDate 2022-12-15 20:04:13
*/
@Service
public class TFulfillReturnServiceImpl extends ServiceImpl<TFulfillReturnMapper, TFulfillReturn>
    implements TFulfillReturnService{

}




