package com.jn.enterprise.data.vo;

import com.jn.enterprise.data.model.CompanyModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupInfoVO",description = "群组详细信息")
public class GroupInfoVO implements Serializable {
    @ApiModelProperty(value = "群组ID" ,example = "001")
    private String groupId;
    @ApiModelProperty(value = "群组名称",example = "A群组")
    private String groupName;
    @ApiModelProperty(value = "群组说明",example = "A群组用于。。。。")
    private String groupComment;
    @ApiModelProperty(value = "创建者账号",example = "zhansan")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间",example = "2018-21-12")
    private Date createTime;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）",example = "0")
    private String recordStatus;
    @ApiModelProperty(value = "最新更新者账号",example = "lishi")
    private String modifierAccount;
    @ApiModelProperty(value = "最新更新时间",example = "2018-21-12")
    private Date modifiedTime;

    @ApiModelProperty(value = "选中的公司列表",example = "公司列表")
    private List<CompanyModel> companyListList;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<CompanyModel> getCompanyListList() {
        return companyListList;
    }

    public void setCompanyListList(List<CompanyModel> companyListList) {
        this.companyListList = companyListList;
    }
}
