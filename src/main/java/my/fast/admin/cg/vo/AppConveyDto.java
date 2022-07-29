package my.fast.admin.cg.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppConveyDto implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "下单时间")
    private Date addtime;

    @ApiModelProperty(value = "完成交易时间")
    private Date endtime;

    @ApiModelProperty(value = "订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结")
    private String status;

    @ApiModelProperty(value = "佣金")
    private BigDecimal commission;

    @ApiModelProperty(value = "佣金发放状态 0未发放 1已发放 2账号冻结")
    private String cStatus;

    @ApiModelProperty(value = "会员收货地址id")
    private Long addId;

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "商品数量")
    private String goodsCount;

    @ApiModelProperty(value = "0显示1隐藏")
    private String hid;

    @ApiModelProperty(value = "抢单数")
    private Long qiang;

    @ApiModelProperty(value = "订单号")
    private String lno;

    @ApiModelProperty(value = "最小价")
    private BigDecimal min;

    @ApiModelProperty(value = "最大价")
    private BigDecimal max;

    @ApiModelProperty(value = "0不卡卡1卡单")
    private String sign;

    @ApiModelProperty(value = "商品NAME")
    private String goodsName;
    
    @ApiModelProperty(value = "商品名称")
    private String shopName;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;



    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    private static final long serialVersionUID = 1L;

    public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public Long getQiang() {
        return qiang;
    }

    public void setQiang(Long qiang) {
        this.qiang = qiang;
    }

    public String getLno() {
        return lno;
    }

    public void setLno(String lno) {
        this.lno = lno;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "AppConveyDto{" + "id=" + id + ", memberId=" + memberId + ", amount=" + amount + ", addtime=" + addtime
            + ", endtime=" + endtime + ", status='" + status + '\'' + ", commission=" + commission + ", cStatus='"
            + cStatus + '\'' + ", addId=" + addId + ", goodsId=" + goodsId + ", goodsCount='" + goodsCount + '\''
            + ", hid='" + hid + '\'' + ", qiang=" + qiang + ", lno='" + lno + '\'' + ", min=" + min + ", max=" + max
            + ", sign='" + sign + '\'' + ", goodsName='" + goodsName + '\'' + ", shopName='" + shopName + '\''
            + ", channelId=" + channelId + '}';
    }
}