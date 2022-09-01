package my.fast.admin.cg.service;

import java.util.List;

import my.fast.admin.cg.entity.AppShow;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/1 15:58
 */
public interface AppMemberIncomeShowService {
    /**
     * 随机展示
     * @return
     */
    List<AppShow> memberIncomeShow();

}
