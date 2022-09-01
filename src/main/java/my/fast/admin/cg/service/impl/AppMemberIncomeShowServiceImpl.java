package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.fast.admin.cg.entity.AppShow;
import my.fast.admin.cg.mapper.AppShowMapper;
import my.fast.admin.cg.service.AppMemberIncomeShowService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/1 16:03
 */
@Service
public class AppMemberIncomeShowServiceImpl implements AppMemberIncomeShowService {

    @Autowired
    private AppShowMapper appShowMapper;

    @Override
    public List<AppShow> memberIncomeShow() {
        List<AppShow> appShowList = appShowMapper.selectMemberIncome();
        return appShowList;
    }
}
