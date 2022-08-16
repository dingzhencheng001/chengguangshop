package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import io.swagger.annotations.ApiModelProperty;

public class AppGoods implements Serializable {
    @ExcelIgnore
    private Long id;

    @ExcelProperty("商店名称")
    @ColumnWidth(20)
    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ExcelProperty("商品名称")
    @ColumnWidth(20)
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ExcelProperty("商品描述")
    @ColumnWidth(50)
    @ApiModelProperty(value = "商品描述")
    private String goodsInfo;

    @ExcelProperty("商品价格")
    @ColumnWidth(10)
    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ExcelProperty("商品展示图片")
    @ColumnWidth(20)
    @ApiModelProperty(value = "商品展示图片")
    private String goodsPic;

    @ColumnWidth(20)
    @ExcelProperty("商品添加时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ApiModelProperty(value = "商品添加时间")
    private Date goodsAddTime;

    @ExcelProperty("上架状态")
    @ColumnWidth(10)
    @ApiModelProperty(value = "上架状态 0不上架 1上架")
    private Integer status;

    @ExcelProperty("商品分类id")
    @ColumnWidth(20)
    @ApiModelProperty(value = "商品分类id")
    private Long goodsSortId;

    @ExcelProperty("渠道id")
    @ColumnWidth(20)
    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ExcelProperty("任务组")
    @ColumnWidth(20)
    @ApiModelProperty(value = "任务组")
    private Integer taskGroup;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Date getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(Date goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGoodsSortId() {
        return goodsSortId;
    }

    public void setGoodsSortId(Long goodsSortId) {
        this.goodsSortId = goodsSortId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(Integer taskGroup) {
        this.taskGroup = taskGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopName=").append(shopName);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsInfo=").append(goodsInfo);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsPic=").append(goodsPic);
        sb.append(", goodsAddTime=").append(goodsAddTime);
        sb.append(", status=").append(status);
        sb.append(", goodsSortId=").append(goodsSortId);
        sb.append(", channelId=").append(channelId);
        sb.append(", taskGroup=").append(taskGroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}