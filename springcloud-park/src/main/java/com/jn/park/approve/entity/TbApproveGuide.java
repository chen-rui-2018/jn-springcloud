package com.jn.park.approve.entity;

import java.io.Serializable;
import java.util.Date;

public class TbApproveGuide implements Serializable {
    /*@ApiModelProperty("主键")*/
    private Integer id;

    /*@ApiModelProperty("审批指南名称")*/
    private String name;

    /*@ApiModelProperty("父分类ID")*/
    private Integer parentId;

    /*@ApiModelProperty("权力名称（冗余字段，保存根节点的名称）")*/
    private String rootName;

    /*@ApiModelProperty("分类树的层级，0代表根节点（权力分类）")*/
    private Byte level;

    /*@ApiModelProperty("是否为内容页（0分类页，代表还有下级内容；1内容页，为叶子节点，没有子节点了，会跟content表关联）")*/
    private Byte isPage;

    /*@ApiModelProperty("分类编码")*/
    private String code;

    /*@ApiModelProperty("默认排序(asc)")*/
    private Integer defaultSort;

    /*@ApiModelProperty("分类图片地址（一级分类才有）")*/
    private String typeImageUrl;

    /*@ApiModelProperty("首页排序(在门户首页的顺序asc)")*/
    private Integer homeSort;

    /*@ApiModelProperty("置顶顺序(在行政审批中心首页的顺序asc）")*/
    private Integer topSort;

    /*@ApiModelProperty("显示状态（草稿，已发布，下线）")*/
    private String showStatus;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName == null ? null : rootName.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getIsPage() {
        return isPage;
    }

    public void setIsPage(Byte isPage) {
        this.isPage = isPage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(Integer defaultSort) {
        this.defaultSort = defaultSort;
    }

    public String getTypeImageUrl() {
        return typeImageUrl;
    }

    public void setTypeImageUrl(String typeImageUrl) {
        this.typeImageUrl = typeImageUrl == null ? null : typeImageUrl.trim();
    }

    public Integer getHomeSort() {
        return homeSort;
    }

    public void setHomeSort(Integer homeSort) {
        this.homeSort = homeSort;
    }

    public Integer getTopSort() {
        return topSort;
    }

    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus == null ? null : showStatus.trim();
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
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbApproveGuide other = (TbApproveGuide) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getRootName() == null ? other.getRootName() == null : this.getRootName().equals(other.getRootName()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getIsPage() == null ? other.getIsPage() == null : this.getIsPage().equals(other.getIsPage()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDefaultSort() == null ? other.getDefaultSort() == null : this.getDefaultSort().equals(other.getDefaultSort()))
            && (this.getTypeImageUrl() == null ? other.getTypeImageUrl() == null : this.getTypeImageUrl().equals(other.getTypeImageUrl()))
            && (this.getHomeSort() == null ? other.getHomeSort() == null : this.getHomeSort().equals(other.getHomeSort()))
            && (this.getTopSort() == null ? other.getTopSort() == null : this.getTopSort().equals(other.getTopSort()))
            && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getRootName() == null) ? 0 : getRootName().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getIsPage() == null) ? 0 : getIsPage().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDefaultSort() == null) ? 0 : getDefaultSort().hashCode());
        result = prime * result + ((getTypeImageUrl() == null) ? 0 : getTypeImageUrl().hashCode());
        result = prime * result + ((getHomeSort() == null) ? 0 : getHomeSort().hashCode());
        result = prime * result + ((getTopSort() == null) ? 0 : getTopSort().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", rootName=").append(rootName);
        sb.append(", level=").append(level);
        sb.append(", isPage=").append(isPage);
        sb.append(", code=").append(code);
        sb.append(", defaultSort=").append(defaultSort);
        sb.append(", typeImageUrl=").append(typeImageUrl);
        sb.append(", homeSort=").append(homeSort);
        sb.append(", topSort=").append(topSort);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}