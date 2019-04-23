package com.jn.task.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 事项任务model
 *
 * @author： yuanyy
 * @date： Created on 2019/4/18 17:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "WorkflowTaskAdd", description = "事项任务")
public class WorkflowTaskAdd implements Serializable {

    private static final long serialVersionUID = -5671809054725364233L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "创建人账号")
    private String creatorAccount;

    @ApiModelProperty(value = "修改人账号")
    private String modifierAccount;

    @ApiModelProperty(value = "事项分类：1：数据上报、2：综合缴费、3：综合租赁")
    private String type;

    @ApiModelProperty(value = "主题")
    private String title;

    @ApiModelProperty(value = "事项截止时间")
    private Date endTime;

    @ApiModelProperty(value = "链接类型：1：h5、2:原生app链接")
    private String linkType;

    @ApiModelProperty(value = "链接地址")
    private String linkUrl;

    @ApiModelProperty(value = "事项描述")
    private String describes;

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
