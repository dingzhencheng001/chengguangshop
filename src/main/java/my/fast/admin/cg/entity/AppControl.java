package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class AppControl implements Serializable {
    private Long id;

    @ApiModelProperty(value = "TRC20地址")
    private String trc;

    @ApiModelProperty(value = "ERC20地址")
    private String erc;

    @ApiModelProperty(value = "USDT")
    private String usdt;

    @ApiModelProperty(value = "交易所需余额")
    private BigDecimal dealAmount;

    @ApiModelProperty(value = "未支付订单支付等待时长s")
    private Integer wait;

    @ApiModelProperty(value = "起始范围")
    private Integer startRang;

    @ApiModelProperty(value = "起始范围")
    private Integer endRang;

    @ApiModelProperty(value = "当日交易次数限制")
    private Integer tradeNum;

    @ApiModelProperty(value = "奖励交易次数")
    private Integer rewardNum;

    @ApiModelProperty(value = "普通会员佣金")
    private BigDecimal generalCommission;

    @ApiModelProperty(value = "上一级会员佣金")
    private BigDecimal upOneCommission;

    @ApiModelProperty(value = "上二级级会员佣金")
    private BigDecimal upTwoCommission;

    @ApiModelProperty(value = "上三级级会员佣金")
    private BigDecimal upThreeCommission;

    @ApiModelProperty(value = "上四级级会员佣金")
    private BigDecimal upFourCommission;

    @ApiModelProperty(value = "上五级级会员佣金")
    private BigDecimal upFiveCommission;

    @ApiModelProperty(value = "冻结时间")
    private Integer freeze;

    @ApiModelProperty(value = "允许违规次数")
    private Integer violate;

    @ApiModelProperty(value = "主机分配时间")
    private Integer distributeTime;

    @ApiModelProperty(value = "等待商家响应时间")
    private Integer responseTime;

    @ApiModelProperty(value = "下载地址")
    private String appAdress;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "提现起始时间")
    private String startWithdraw;

    @ApiModelProperty(value = "提现起始时间")
    private String endWithdraw;

    @ApiModelProperty(value = "充值起始时间")
    private String startDeposit;

    @ApiModelProperty(value = "充值起始时间")
    private String endDeposit;

    @ApiModelProperty(value = "抢单起始时间")
    private String startConvey;

    @ApiModelProperty(value = "抢单起始时间")
    private String endConvey;

    @ApiModelProperty(value = "商城开启状态1开启0关闭")
    private Integer shopStatus;

    @ApiModelProperty(value = "渠道编号")
    private String channelId;

    @ApiModelProperty(value = "备注")
    private String remank;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrc() {
        return trc;
    }

    public void setTrc(String trc) {
        this.trc = trc;
    }

    public String getErc() {
        return erc;
    }

    public void setErc(String erc) {
        this.erc = erc;
    }

    public String getUsdt() {
        return usdt;
    }

    public void setUsdt(String usdt) {
        this.usdt = usdt;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    public Integer getWait() {
        return wait;
    }

    public void setWait(Integer wait) {
        this.wait = wait;
    }

    public Integer getStartRang() {
        return startRang;
    }

    public void setStartRang(Integer startRang) {
        this.startRang = startRang;
    }

    public Integer getEndRang() {
        return endRang;
    }

    public void setEndRang(Integer endRang) {
        this.endRang = endRang;
    }

    public Integer getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(Integer tradeNum) {
        this.tradeNum = tradeNum;
    }

    public Integer getRewardNum() {
        return rewardNum;
    }

    public void setRewardNum(Integer rewardNum) {
        this.rewardNum = rewardNum;
    }

    public BigDecimal getGeneralCommission() {
        return generalCommission;
    }

    public void setGeneralCommission(BigDecimal generalCommission) {
        this.generalCommission = generalCommission;
    }

    public BigDecimal getUpOneCommission() {
        return upOneCommission;
    }

    public void setUpOneCommission(BigDecimal upOneCommission) {
        this.upOneCommission = upOneCommission;
    }

    public BigDecimal getUpTwoCommission() {
        return upTwoCommission;
    }

    public void setUpTwoCommission(BigDecimal upTwoCommission) {
        this.upTwoCommission = upTwoCommission;
    }

    public BigDecimal getUpThreeCommission() {
        return upThreeCommission;
    }

    public void setUpThreeCommission(BigDecimal upThreeCommission) {
        this.upThreeCommission = upThreeCommission;
    }

    public BigDecimal getUpFourCommission() {
        return upFourCommission;
    }

    public void setUpFourCommission(BigDecimal upFourCommission) {
        this.upFourCommission = upFourCommission;
    }

    public BigDecimal getUpFiveCommission() {
        return upFiveCommission;
    }

    public void setUpFiveCommission(BigDecimal upFiveCommission) {
        this.upFiveCommission = upFiveCommission;
    }

    public Integer getFreeze() {
        return freeze;
    }

    public void setFreeze(Integer freeze) {
        this.freeze = freeze;
    }

    public Integer getViolate() {
        return violate;
    }

    public void setViolate(Integer violate) {
        this.violate = violate;
    }

    public Integer getDistributeTime() {
        return distributeTime;
    }

    public void setDistributeTime(Integer distributeTime) {
        this.distributeTime = distributeTime;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public String getAppAdress() {
        return appAdress;
    }

    public void setAppAdress(String appAdress) {
        this.appAdress = appAdress;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStartWithdraw() {
        return startWithdraw;
    }

    public void setStartWithdraw(String startWithdraw) {
        this.startWithdraw = startWithdraw;
    }

    public String getEndWithdraw() {
        return endWithdraw;
    }

    public void setEndWithdraw(String endWithdraw) {
        this.endWithdraw = endWithdraw;
    }

    public String getStartDeposit() {
        return startDeposit;
    }

    public void setStartDeposit(String startDeposit) {
        this.startDeposit = startDeposit;
    }

    public String getEndDeposit() {
        return endDeposit;
    }

    public void setEndDeposit(String endDeposit) {
        this.endDeposit = endDeposit;
    }

    public String getStartConvey() {
        return startConvey;
    }

    public void setStartConvey(String startConvey) {
        this.startConvey = startConvey;
    }

    public String getEndConvey() {
        return endConvey;
    }

    public void setEndConvey(String endConvey) {
        this.endConvey = endConvey;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getRemank() {
        return remank;
    }

    public void setRemank(String remank) {
        this.remank = remank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trc=").append(trc);
        sb.append(", erc=").append(erc);
        sb.append(", usdt=").append(usdt);
        sb.append(", dealAmount=").append(dealAmount);
        sb.append(", wait=").append(wait);
        sb.append(", startRang=").append(startRang);
        sb.append(", endRang=").append(endRang);
        sb.append(", tradeNum=").append(tradeNum);
        sb.append(", rewardNum=").append(rewardNum);
        sb.append(", generalCommission=").append(generalCommission);
        sb.append(", upOneCommission=").append(upOneCommission);
        sb.append(", upTwoCommission=").append(upTwoCommission);
        sb.append(", upThreeCommission=").append(upThreeCommission);
        sb.append(", upFourCommission=").append(upFourCommission);
        sb.append(", upFiveCommission=").append(upFiveCommission);
        sb.append(", freeze=").append(freeze);
        sb.append(", violate=").append(violate);
        sb.append(", distributeTime=").append(distributeTime);
        sb.append(", responseTime=").append(responseTime);
        sb.append(", appAdress=").append(appAdress);
        sb.append(", version=").append(version);
        sb.append(", startWithdraw=").append(startWithdraw);
        sb.append(", endWithdraw=").append(endWithdraw);
        sb.append(", startDeposit=").append(startDeposit);
        sb.append(", endDeposit=").append(endDeposit);
        sb.append(", startConvey=").append(startConvey);
        sb.append(", endConvey=").append(endConvey);
        sb.append(", shopStatus=").append(shopStatus);
        sb.append(", channelId=").append(channelId);
        sb.append(", remank=").append(remank);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}