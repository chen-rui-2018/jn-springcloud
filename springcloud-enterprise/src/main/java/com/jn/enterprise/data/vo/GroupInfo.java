package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupInfo",description = "群组详细信息")
public class GroupInfo implements Serializable {
    @ApiModelProperty(value = "群组ID")
    private String groupId;
    @ApiModelProperty(value = "群主名称")
    private String groupName;
    @ApiModelProperty(value = "群组说明")
    private String groupComment;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private String recordStatus;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty(value = "最新更新时间")
    private String modifiedTime;

    @ApiModelProperty(value = "选中的公司列表")
    private List<CompanyList> companyListList;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupComment() {
        return groupComment;
    }

    public void setGroupComment(String groupComment) {
        this.groupComment = groupComment;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
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

    public List<CompanyList> getCompanyListList() {
        return companyListList;
    }

    public void setCompanyListList(List<CompanyList> companyListList) {
        this.companyListList = companyListList;
    }
}
