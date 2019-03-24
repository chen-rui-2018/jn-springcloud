package com.jn.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 活动类型信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:25
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityType", description = "活动类型")
public class ActivityType implements Serializable {
    @ApiModelProperty(value = "类型ID")
    private String typeId;
    @ApiModelProperty(value = "类型名称")
    private String typeName;
    @ApiModelProperty(value = "创建人账号")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "更新人账号")
    private String modifierAccount;
    @ApiModelProperty(value = "更新时间")
    private String  modifiedTime;
    @ApiModelProperty(value = "状态(0：无效，1：有效)")
    private String typeStatus;
    @ApiModelProperty(value = "活动类型模板列表")
    private List<String> templateList;
    @ApiModelProperty(value = "拥有模板数量")
    private String  fileTotal;

    private static final long serialVersionUID = 1L;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }

    public List<String> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<String> templateList) {
        this.templateList = templateList;
    }

    public String getFileTotal() {
        return fileTotal;
    }

    public void setFileTotal(String fileTotal) {
        this.fileTotal = fileTotal;
    }
}