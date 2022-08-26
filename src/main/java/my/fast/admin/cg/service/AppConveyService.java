package my.fast.admin.cg.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.model.AppConveyParam;
import my.fast.admin.cg.vo.AppConveyDto;
import my.fast.admin.cg.vo.AppConveyVo;

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
    List<AppConveyVo> listConvey(AppConveyParam appConveyParam);

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
    @Transactional(rollbackFor = Exception.class)
    int updateConvey(Long id,AppConvey appConvey);
    
    
}
