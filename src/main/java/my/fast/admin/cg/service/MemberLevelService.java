package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppMemberLevel;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 10:09
 */
public interface MemberLevelService {

    /**
     * 获取会员等级信息列表
     */
    List<AppMemberLevel> listLevels(Integer pageNum, Integer pageSize, Long channelId);

    /**
     * 删除会员等级
     */
    int deleteLevels(Long id);

    /**
     * 更新会员等级
     */
    @Transactional(rollbackFor = Exception.class)
    int updateLevels(Long id, AppMemberLevel appMemberLevel);

    /**
     * 新增会员等级
     */
    int createLevels(AppMemberLevel appMemberLevel, Long channelId);

}
