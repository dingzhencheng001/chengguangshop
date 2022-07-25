package my.fast.admin.cg.model;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/13 15:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberBalancePram {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "佣金")
    private BigDecimal grabCommission;

    @ApiModelProperty(value = "会员等级id列表")
    private List<Long> memberLevelId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGrabCommission() {
        return grabCommission;
    }

    public void setGrabCommission(BigDecimal grabCommission) {
        this.grabCommission = grabCommission;
    }

    public List<Long> getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(List<Long> memberLevelId) {
        this.memberLevelId = memberLevelId;
    }
}
