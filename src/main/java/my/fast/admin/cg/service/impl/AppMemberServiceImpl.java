package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.common.constant.UserConstants;
import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberExample;
import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.mapper.AppConveyMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.mapper.SysOperateLogMapper;
import my.fast.admin.cg.model.AppMemberParam;
import my.fast.admin.cg.model.MemberParams;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.vo.AppMemberDto;
import my.fast.admin.cg.vo.AppMemberIncomeVo;
import my.fast.admin.cg.vo.AppMemberVo;
import my.fast.admin.framework.utils.CommonUtils;
import my.fast.admin.framework.utils.DateFormat;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppMemberServiceImpl implements AppMemberService {

    @Autowired
    private SysOperateLogMapper sysOperateLogMapper;

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Autowired
    private AppConveyMapper appConveyMapper;

    @Override
    public List<AppMember> listAll() {
        return appMemberMapper.selectByExample(new AppMemberExample());
    }

    @Override
    public List<AppMemberVo> listMember(Long channelId, MemberParams memberParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return appMemberMapper.selectPage(channelId, memberParams);
    }

    @Override
    public int deleteMemberById(Long id) {
        return appMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createMember(AppMember appMemberParam) {
        AppMember appMember = new AppMember();
        BeanUtils.copyProperties(appMemberParam, appMember);
        return appMemberMapper.insertSelective(appMember);
    }

    @Override
    public int updateMember(Long id, AppMember appMemberParam) {
        SysOperateLog operateLog = new SysOperateLog();
        AppMember appMember = new AppMember();
        BeanUtils.copyProperties(appMemberParam, appMember);
        appMember.setId(id);

        //操作记录
        operateLog.setChannelId(appMember.getChannelId());
        operateLog.setTitle("会员信息修改");
        operateLog.setOperateContent(
            "账号为：" + appMember.getUserAccount() + " 的会员，在" + DateFormat.getNowDate() + "被修改了信息。");
        operateLog.setCreateBy("admin");
        operateLog.setCreateTime(DateFormat.getNowDate());
        operateLog.setRemark("会员ID为" + id);
        sysOperateLogMapper.insertSelective(operateLog);

        return appMemberMapper.updateByPrimaryKeySelective(appMember);

    }

    @Override
    public AppMember selectAppMemberByUserId(Long id) {
        return appMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public AppMember selectAppMemberByUserAccount(String userAccount) {
        return appMemberMapper.selectAppMemberByUserAccount(userAccount);
    }

    @Override
    public AppMember selectAppMemberByCode(String code) {

        return appMemberMapper.selectAppMemberByCode(code);
    }

    /**
     * 校验用户名是否唯一
     */
    @Override
    public String checkUserNameUnique(AppMember user) {
        AppMemberParam appMemberParam = new AppMemberParam();
        BeanUtils.copyProperties(user, appMemberParam);
        int count = appMemberMapper.checkUserNameUnique(appMemberParam);
        if (count > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验手机号是否唯一
     */
    @Override
    public String checkPhoneUnique(AppMember user) {
        Long userId = CommonUtils.isNull(user.getId()) ? -1L : user.getId();
        AppMemberParam appMemberParam = new AppMemberParam();
        BeanUtils.copyProperties(user, appMemberParam);
        AppMember info = appMemberMapper.checkPhoneUnique(appMemberParam);
        if (CommonUtils.isNotNull(info) && info.getId()
            .longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验邮箱是否唯一
     */
    @Override
    public String checkEmailUnique(AppMember user) {
        Long userId = CommonUtils.isNull(user.getId()) ? -1L : user.getId();
        AppMember info = appMemberMapper.checkEmailUnique(user.getEmail());
        if (CommonUtils.isNotNull(info) && info.getId()
            .longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public AppMemberDto selectAppMemberCountByPrimary(Long memberId, Long channelId) {
        AppMemberDto memberDto = appMemberMapper.selectAppMemberCountByPrimary(memberId);
        List<AppConvey> appConveys = appConveyMapper.selectConvey(memberId, channelId);
        Long qiang = appConveys.stream()
            .map(e -> e.getQiang())
            .reduce(Long::max)
            .get();
        memberDto.setLastQiang(qiang);
        return memberDto;
    }

    @Override
    public int selectMemberLevel(Long memberId, Long channelId) {
        return appMemberMapper.selectMemberLevel(memberId, channelId);
    }

    @Override
    public int getMemberOrderNum(Long memberId, Long channelId) {
        List<AppConvey> appConveys = appConveyMapper.selectConvey(memberId, channelId);
        if (appConveys.size() > 0) {
            Long qiang = appConveys.stream()
                .map(e -> e.getQiang())
                .reduce(Long::max)
                .get();
            return qiang.intValue();
        }
        return 0;
    }

    @Override
    public AppMemberIncomeVo selectMemberIncome(Long memberId, Long channelId) {
        AppMemberIncomeVo appMemberIncomeVo = appMemberMapper.selectMemberIncome(memberId, channelId);
        BigDecimal todayCommission = appConveyMapper.selectTodayCommission(memberId, channelId);
        if (todayCommission==null){
            appMemberIncomeVo.setTodayCommission(new BigDecimal(0));
        }
        appMemberIncomeVo.setTodayCommission(todayCommission);
        return appMemberIncomeVo;
    }

    @Override
    public AppMember selectAppMemberByUserPhone(AppMember appMember) {
        AppMemberParam appMemberParam = new AppMemberParam();
        BeanUtils.copyProperties(appMember, appMemberParam);
        AppMember info = appMemberMapper.selectAppMemberByUserPhone(appMemberParam);
        return info;
    }

}