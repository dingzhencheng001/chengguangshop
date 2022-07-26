package my.fast.admin.cg.vo;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 15:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberDto {

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "账号冻结金额")
    private BigDecimal freezeBalance;

    @ApiModelProperty(value = "日充值金额")
    private BigDecimal rechargeNum;

    @ApiModelProperty(value = "日提现金额")
    private BigDecimal depositNum;

    @ApiModelProperty(value = "扣除金额")
    private BigDecimal deductionNum;

    @ApiModelProperty(value = "JSON下单规则")
    private String matching;

    @ApiModelProperty(value = "上级关联ID(如果该用户不是可登录后台的真代理,该项必填)")
    private Long parentUserId;

    @ApiModelProperty(value = "上级伪代理用户名称或上级真实代理用户昵称")
    private String parentUserName;

    @ApiModelProperty(value = "代理账号标识（0代理账号[新增时候维护tb_app_user和sys_user] 1普通管理员账号[新增时候维护sys_user]）【0:真实代理 1:伪代理,不可登录后台】")
    private Integer isAgent;

    @ApiModelProperty(value = "字典项 代理等级")
    private Integer agentLevel;

    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "删除标志（1代表存在 2代表删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "最后登录IP")
    private String loginIp;

    @ApiModelProperty(value = "最后登录时间")
    private Date loginDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "机构id")
    private Long companyId;

    @ApiModelProperty(value = "邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "会员注册时间")
    private Date registrationTime;

    @ApiModelProperty(value = "会员状态:1.真人2.假人")
    private Integer memberStatus;

    @ApiModelProperty(value = "注册ip")
    private String registerIp;

    @ApiModelProperty(value = "注册国家")
    private String registerCountry;

    @ApiModelProperty(value = "会员个人总佣金")
    private BigDecimal totalCommission;

    @ApiModelProperty(value = "会员名称")
    private String membersName;

    @ApiModelProperty(value = "接单限制")
    private Integer orderNum;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;

    @ApiModelProperty(value = "注册时间")
    private Date registerTime;

    @ApiModelProperty(value = "佣金比例")
    private BigDecimal commission;

    @ApiModelProperty(value = "会员等级")
    private Integer membersLevel;

    @ApiModelProperty(value = "提现次数")
    private Integer withdrawalTimes;

    @ApiModelProperty(value = "提现最小金额")
    private Integer withdrawalMin;

    @ApiModelProperty(value = "提现最大金额")
    private Integer withdrawalMax;

    @ApiModelProperty(value = "最小余额")
    private Integer numMin;

    @ApiModelProperty(value = "提现最少完成订单数")
    private Integer withdrawalNimOrder;

    @ApiModelProperty(value = "自动升级vip需要邀请的人数")
    private Integer autoVipXuNum;

    @ApiModelProperty(value = "提现手续费")
    private BigDecimal serviceCharge;

    @ApiModelProperty(value = "抢单次数")
    private Long lastQiang;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;
}
