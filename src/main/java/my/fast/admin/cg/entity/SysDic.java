package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SysDic implements Serializable {
    @ApiModelProperty(value = "字典表编号")
    private String id;

    @ApiModelProperty(value = "字典定义")
    private String dicdefine;

    @ApiModelProperty(value = "字典描述")
    private String dicdesc;

    @ApiModelProperty(value = "字典编码")
    private String diccode;

    @ApiModelProperty(value = "字典名称")
    private String dicname;

    @ApiModelProperty(value = "使用状态")
    private String isuse;

    @ApiModelProperty(value = "创建人")
    private String crtUser;

    @ApiModelProperty(value = "创建时间")
    private Date crtTime;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDicdefine() {
        return dicdefine;
    }

    public void setDicdefine(String dicdefine) {
        this.dicdefine = dicdefine;
    }

    public String getDicdesc() {
        return dicdesc;
    }

    public void setDicdesc(String dicdesc) {
        this.dicdesc = dicdesc;
    }

    public String getDiccode() {
        return diccode;
    }

    public void setDiccode(String diccode) {
        this.diccode = diccode;
    }

    public String getDicname() {
        return dicname;
    }

    public void setDicname(String dicname) {
        this.dicname = dicname;
    }

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dicdefine=").append(dicdefine);
        sb.append(", dicdesc=").append(dicdesc);
        sb.append(", diccode=").append(diccode);
        sb.append(", dicname=").append(dicname);
        sb.append(", isuse=").append(isuse);
        sb.append(", crtUser=").append(crtUser);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", channelId=").append(channelId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}