package my.fast.admin.app.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import my.fast.admin.app.entity.AppConvey;
import my.fast.admin.app.vo.AppConveyDto;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:38
 */
public interface AppConveyService {

    /**
     * 获取所有交易订单
     */
    List<AppConvey> listAll();

    /**
     * 分页查询
     */
    List<AppConveyDto> listConvey(AppConvey appConvey, Integer pageNum, Integer pageSize);

    /**
     * 删除订单
     */
    int deleteConveyById(Long id);

    /**
     * 创建订单
     */
    int createConvey(AppConvey appConvey);

    /**
     * 修改订单
     */
    @Transactional
    int updateConvey(Long id,AppConvey appConvey);
    
    
}
