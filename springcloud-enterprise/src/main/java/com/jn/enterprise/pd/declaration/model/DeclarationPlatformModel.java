package com.jn.enterprise.pd.declaration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 申报平台管理实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/10 17:16
 * @version： v1.0
 * @modified By:
 */
    @ApiModel(value = "DeclarationPlatformModel", description = "申报平台管理实体类")
    public class DeclarationPlatformModel extends Page implements Serializable {

    @ApiModelProperty(value="唯一标识符")
    private String id;

    @ApiModelProperty(value="平台标题")
    private String platformTitle;

    @ApiModelProperty(value="链接地址")
    private String linkAddress;

    @ApiModelProperty(value="备注")
    private String remark;

    @ApiModelProperty(value="业务咨询")
    private String businessConsult;

    @ApiModelProperty(value="系统支持")
    private String systemSupport;

    @ApiModelProperty(value="所属平台名称")
    private String subordinatePlatformName;

    @ApiModelProperty(value = "是否属于人才服务（1：是，2：否）")
    private String isTalentService;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value="状态（1：草稿，2：已发布，3：已下架）")
    private Byte status;

    @ApiModelProperty(value="是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value="创建人")
    private String creatorAccount;

    @ApiModelProperty(value="创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value="最新更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value="账户密码（备忘录）")
    private String accountAndPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformTitle() {
        return platformTitle;
    }

    public void setPlatformTitle(String platformTitle) {
        this.platformTitle = platformTitle;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusinessConsult() {
        return businessConsult;
    }

    public void setBusinessConsult(String businessConsult) {
        this.businessConsult = businessConsult;
    }

    public String getSystemSupport() {
        return systemSupport;
    }

    public void setSystemSupport(String systemSupport) {
        this.systemSupport = systemSupport;
    }

    public String getSubordinatePlatformName() {
        return subordinatePlatformName;
    }

    public void setSubordinatePlatformName(String subordinatePlatformName) {
        this.subordinatePlatformName = subordinatePlatformName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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

    public String getAccountAndPassword() {
        return accountAndPassword;
    }

    public void setAccountAndPassword(String accountAndPassword) {
        this.accountAndPassword = accountAndPassword;
    }

    public String getIsTalentService() {
        return isTalentService;
    }

    public void setIsTalentService(String isTalentService) {
        this.isTalentService = isTalentService;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "DeclarationPlatformModel{" +
                "id='" + id + '\'' +
                ", platformTitle='" + platformTitle + '\'' +
                ", linkAddress='" + linkAddress + '\'' +
                ", remark='" + remark + '\'' +
                ", businessConsult='" + businessConsult + '\'' +
                ", systemSupport='" + systemSupport + '\'' +
                ", subordinatePlatformName='" + subordinatePlatformName + '\'' +
                ", isTalentService='" + isTalentService + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", accountAndPassword='" + accountAndPassword + '\'' +
                '}';
    }
}
