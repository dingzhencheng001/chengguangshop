package my.fast.admin.cg.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.AppMemberDepositExample;
import my.fast.admin.cg.mapper.AppMemberDepositMapper;
import my.fast.admin.cg.service.MemberDepositService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 11:52
 */
@Service
public class MemberDepositServiceImpl implements MemberDepositService {

    @Autowired
    private AppMemberDepositMapper depositMapper;


    @Override
    public List<AppMemberDeposit> listDeposit(AppMemberDeposit deposit, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberDepositExample  listExample = new AppMemberDepositExample();
        AppMemberDepositExample.Criteria criteria = listExample.createCriteria();
        criteria.andChannelIdEqualTo(deposit.getChannelId());
        return depositMapper.selectByExample(listExample);
    }

    @Override
    public int deleteDepositById(Long id) {
        return depositMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createDeposit(AppMemberDeposit deposit) {
        return depositMapper.insertSelective(deposit);
    }

   
}
