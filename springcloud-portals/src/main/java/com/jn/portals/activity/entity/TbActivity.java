package com.jn.portals.activity.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbActivity implements Serializable {
    private String id;

    private String actiType;

    private String actiName;

    private Date actiStartTime;

    private Date actiEndTime;

    private Date applyStartTime;

    private Date applyEndTime;

    private Date mesSendTime;

    private String actiAddress;

    private BigDecimal actiCost;

    private String actiOrganizer;

    private Integer actiNumber;

    private String actiPosterUrl;

    private String state;

    private Date createTime;

    private String createAccount;

    private Date updateTime;

    private String updateAccount;

    private Integer actiViews;

    private Integer actiLike;

    private Integer applyNum;

    private Integer particNum;

    private String isTop;

    private Date topTime;

    private String isApply;

    private Integer actiOrder;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActiType() {
        return actiType;
    }

    public void setActiType(String actiType) {
        this.actiType = actiType == null ? null : actiType.trim();
    }

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName == null ? null : actiName.trim();
    }

    public Date getActiStartTime() {
        return actiStartTime;
    }

    public void setActiStartTime(Date actiStartTime) {
        this.actiStartTime = actiStartTime;
    }

    public Date getActiEndTime() {
        return actiEndTime;
    }

    public void setActiEndTime(Date actiEndTime) {
        this.actiEndTime = actiEndTime;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Date getMesSendTime() {
        return mesSendTime;
    }

    public void setMesSendTime(Date mesSendTime) {
        this.mesSendTime = mesSendTime;
    }

    public String getActiAddress() {
        return actiAddress;
    }

    public void setActiAddress(String actiAddress) {
        this.actiAddress = actiAddress == null ? null : actiAddress.trim();
    }

    public BigDecimal getActiCost() {
        return actiCost;
    }

    public void setActiCost(BigDecimal actiCost) {
        this.actiCost = actiCost;
    }

    public String getActiOrganizer() {
        return actiOrganizer;
    }

    public void setActiOrganizer(String actiOrganizer) {
        this.actiOrganizer = actiOrganizer == null ? null : actiOrganizer.trim();
    }

    public Integer getActiNumber() {
        return actiNumber;
    }

    public void setActiNumber(Integer actiNumber) {
        this.actiNumber = actiNumber;
    }

    public String getActiPosterUrl() {
        return actiPosterUrl;
    }

    public void setActiPosterUrl(String actiPosterUrl) {
        this.actiPosterUrl = actiPosterUrl == null ? null : actiPosterUrl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount == null ? null : createAccount.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount == null ? null : updateAccount.trim();
    }

    public Integer getActiViews() {
        return actiViews;
    }

    public void setActiViews(Integer actiViews) {
        this.actiViews = actiViews;
    }

    public Integer getActiLike() {
        return actiLike;
    }

    public void setActiLike(Integer actiLike) {
        this.actiLike = actiLike;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public Integer getParticNum() {
        return particNum;
    }

    public void setParticNum(Integer particNum) {
        this.particNum = particNum;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop == null ? null : isTop.trim();
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public String getIsApply() {
        return isApply;
    }

    public void setIsApply(String isApply) {
        this.isApply = isApply == null ? null : isApply.trim();
    }

    public Integer getActiOrder() {
        return actiOrder;
    }

    public void setActiOrder(Integer actiOrder) {
        this.actiOrder = actiOrder;
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
        TbActivity other = (TbActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActiType() == null ? other.getActiType() == null : this.getActiType().equals(other.getActiType()))
            && (this.getActiName() == null ? other.getActiName() == null : this.getActiName().equals(other.getActiName()))
            && (this.getActiStartTime() == null ? other.getActiStartTime() == null : this.getActiStartTime().equals(other.getActiStartTime()))
            && (this.getActiEndTime() == null ? other.getActiEndTime() == null : this.getActiEndTime().equals(other.getActiEndTime()))
            && (this.getApplyStartTime() == null ? other.getApplyStartTime() == null : this.getApplyStartTime().equals(other.getApplyStartTime()))
            && (this.getApplyEndTime() == null ? other.getApplyEndTime() == null : this.getApplyEndTime().equals(other.getApplyEndTime()))
            && (this.getMesSendTime() == null ? other.getMesSendTime() == null : this.getMesSendTime().equals(other.getMesSendTime()))
            && (this.getActiAddress() == null ? other.getActiAddress() == null : this.getActiAddress().equals(other.getActiAddress()))
            && (this.getActiCost() == null ? other.getActiCost() == null : this.getActiCost().equals(other.getActiCost()))
            && (this.getActiOrganizer() == null ? other.getActiOrganizer() == null : this.getActiOrganizer().equals(other.getActiOrganizer()))
            && (this.getActiNumber() == null ? other.getActiNumber() == null : this.getActiNumber().equals(other.getActiNumber()))
            && (this.getActiPosterUrl() == null ? other.getActiPosterUrl() == null : this.getActiPosterUrl().equals(other.getActiPosterUrl()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateAccount() == null ? other.getCreateAccount() == null : this.getCreateAccount().equals(other.getCreateAccount()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateAccount() == null ? other.getUpdateAccount() == null : this.getUpdateAccount().equals(other.getUpdateAccount()))
            && (this.getActiViews() == null ? other.getActiViews() == null : this.getActiViews().equals(other.getActiViews()))
            && (this.getActiLike() == null ? other.getActiLike() == null : this.getActiLike().equals(other.getActiLike()))
            && (this.getApplyNum() == null ? other.getApplyNum() == null : this.getApplyNum().equals(other.getApplyNum()))
            && (this.getParticNum() == null ? other.getParticNum() == null : this.getParticNum().equals(other.getParticNum()))
            && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
            && (this.getTopTime() == null ? other.getTopTime() == null : this.getTopTime().equals(other.getTopTime()))
            && (this.getIsApply() == null ? other.getIsApply() == null : this.getIsApply().equals(other.getIsApply()))
            && (this.getActiOrder() == null ? other.getActiOrder() == null : this.getActiOrder().equals(other.getActiOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActiType() == null) ? 0 : getActiType().hashCode());
        result = prime * result + ((getActiName() == null) ? 0 : getActiName().hashCode());
        result = prime * result + ((getActiStartTime() == null) ? 0 : getActiStartTime().hashCode());
        result = prime * result + ((getActiEndTime() == null) ? 0 : getActiEndTime().hashCode());
        result = prime * result + ((getApplyStartTime() == null) ? 0 : getApplyStartTime().hashCode());
        result = prime * result + ((getApplyEndTime() == null) ? 0 : getApplyEndTime().hashCode());
        result = prime * result + ((getMesSendTime() == null) ? 0 : getMesSendTime().hashCode());
        result = prime * result + ((getActiAddress() == null) ? 0 : getActiAddress().hashCode());
        result = prime * result + ((getActiCost() == null) ? 0 : getActiCost().hashCode());
        result = prime * result + ((getActiOrganizer() == null) ? 0 : getActiOrganizer().hashCode());
        result = prime * result + ((getActiNumber() == null) ? 0 : getActiNumber().hashCode());
        result = prime * result + ((getActiPosterUrl() == null) ? 0 : getActiPosterUrl().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateAccount() == null) ? 0 : getCreateAccount().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateAccount() == null) ? 0 : getUpdateAccount().hashCode());
        result = prime * result + ((getActiViews() == null) ? 0 : getActiViews().hashCode());
        result = prime * result + ((getActiLike() == null) ? 0 : getActiLike().hashCode());
        result = prime * result + ((getApplyNum() == null) ? 0 : getApplyNum().hashCode());
        result = prime * result + ((getParticNum() == null) ? 0 : getParticNum().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getTopTime() == null) ? 0 : getTopTime().hashCode());
        result = prime * result + ((getIsApply() == null) ? 0 : getIsApply().hashCode());
        result = prime * result + ((getActiOrder() == null) ? 0 : getActiOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actiType=").append(actiType);
        sb.append(", actiName=").append(actiName);
        sb.append(", actiStartTime=").append(actiStartTime);
        sb.append(", actiEndTime=").append(actiEndTime);
        sb.append(", applyStartTime=").append(applyStartTime);
        sb.append(", applyEndTime=").append(applyEndTime);
        sb.append(", mesSendTime=").append(mesSendTime);
        sb.append(", actiAddress=").append(actiAddress);
        sb.append(", actiCost=").append(actiCost);
        sb.append(", actiOrganizer=").append(actiOrganizer);
        sb.append(", actiNumber=").append(actiNumber);
        sb.append(", actiPosterUrl=").append(actiPosterUrl);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", createAccount=").append(createAccount);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateAccount=").append(updateAccount);
        sb.append(", actiViews=").append(actiViews);
        sb.append(", actiLike=").append(actiLike);
        sb.append(", applyNum=").append(applyNum);
        sb.append(", particNum=").append(particNum);
        sb.append(", isTop=").append(isTop);
        sb.append(", topTime=").append(topTime);
        sb.append(", isApply=").append(isApply);
        sb.append(", actiOrder=").append(actiOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}