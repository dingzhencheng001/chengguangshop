package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppPicture implements Serializable {
    private Long id;

    @ApiModelProperty(value = "图片类型 1.首页banner 2.合作伙伴 3.介绍"  )
    private Integer pictureType;

    @ApiModelProperty(value = "文字说明")
    private String content;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "最后编辑")
    private String lastEdit;

    @ApiModelProperty(value = "展示类型 1.app展示 2.app不展示")
    private Integer showType;

    @ApiModelProperty(value = "图片文件id")
    private String pictureId;

    @ApiModelProperty(value = "图片名称")
    private String pictureName;

    @ApiModelProperty(value = "图片路径")
    private String picturePath;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "标题")
    private String title;

    
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPictureType() {
        return pictureType;
    }

    public void setPictureType(Integer pictureType) {
        this.pictureType = pictureType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(String lastEdit) {
        this.lastEdit = lastEdit;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pictureType=").append(pictureType);
        sb.append(", content=").append(content);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", lastEdit=").append(lastEdit);
        sb.append(", showType=").append(showType);
        sb.append(", pictureId=").append(pictureId);
        sb.append(", pictureName=").append(pictureName);
        sb.append(", picturePath=").append(picturePath);
        sb.append(", channelId=").append(channelId);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}