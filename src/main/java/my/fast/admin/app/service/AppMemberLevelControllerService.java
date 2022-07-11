package my.fast.admin.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.app.entity.AppMemberLevel;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:34
 */
public interface AppMemberLevelControllerService {

    /**
     * 获取所有会员等级信息
     */
    List<AppMemberLevel> listAll();

    /**
     * 获取所有会员等级信息列表
     */
    List<AppMemberLevel> listLevels(Integer pageNum, Integer pageSize);

    /**
     * 删除会员等级
     */
    int deleteLevels(Long id);

    /**
     * 更新会员等级
     */
    @Transactional
    int updateLevels(Long id, AppMemberLevel appMemberLevel);

    /**
     * 新增会员等级
     */
    int createLevels(AppMemberLevel appMemberLevel);
}
