package org.xxpay.dal.dao.entity.reconciliation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPayReconciliationCheckBatch implements Serializable {
    private Integer id;

    private Integer version;

    private Date createTime;

    private String editor;

    private String creater;

    private Date editTime;

    private String status;

    private String remark;

    private String batchNo;

    private Date billDate;

    private String billType;

    private String handleStatus;

    private String bankType;

    private Integer mistakeCount;

    private Integer unhandleMistakeCount;

    private Integer tradeCount;

    private Integer bankTradeCount;

    private BigDecimal tradeAmount;

    private BigDecimal bankTradeAmount;

    private BigDecimal refundAmount;

    private BigDecimal bankRefundAmount;

    private BigDecimal bankFee;

    private String orgCheckFilePath;

    private String releaseCheckFilePath;

    private String releaseStatus;

    private String checkFailMsg;

    private String bankErrMsg;

    private BigDecimal fee;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus == null ? null : handleStatus.trim();
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    public Integer getMistakeCount() {
        return mistakeCount;
    }

    public void setMistakeCount(Integer mistakeCount) {
        this.mistakeCount = mistakeCount;
    }

    public Integer getUnhandleMistakeCount() {
        return unhandleMistakeCount;
    }

    public void setUnhandleMistakeCount(Integer unhandleMistakeCount) {
        this.unhandleMistakeCount = unhandleMistakeCount;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    public Integer getBankTradeCount() {
        return bankTradeCount;
    }

    public void setBankTradeCount(Integer bankTradeCount) {
        this.bankTradeCount = bankTradeCount;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public BigDecimal getBankTradeAmount() {
        return bankTradeAmount;
    }

    public void setBankTradeAmount(BigDecimal bankTradeAmount) {
        this.bankTradeAmount = bankTradeAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getBankRefundAmount() {
        return bankRefundAmount;
    }

    public void setBankRefundAmount(BigDecimal bankRefundAmount) {
        this.bankRefundAmount = bankRefundAmount;
    }

    public BigDecimal getBankFee() {
        return bankFee;
    }

    public void setBankFee(BigDecimal bankFee) {
        this.bankFee = bankFee;
    }

    public String getOrgCheckFilePath() {
        return orgCheckFilePath;
    }

    public void setOrgCheckFilePath(String orgCheckFilePath) {
        this.orgCheckFilePath = orgCheckFilePath == null ? null : orgCheckFilePath.trim();
    }

    public String getReleaseCheckFilePath() {
        return releaseCheckFilePath;
    }

    public void setReleaseCheckFilePath(String releaseCheckFilePath) {
        this.releaseCheckFilePath = releaseCheckFilePath == null ? null : releaseCheckFilePath.trim();
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus == null ? null : releaseStatus.trim();
    }

    public String getCheckFailMsg() {
        return checkFailMsg;
    }

    public void setCheckFailMsg(String checkFailMsg) {
        this.checkFailMsg = checkFailMsg == null ? null : checkFailMsg.trim();
    }

    public String getBankErrMsg() {
        return bankErrMsg;
    }

    public void setBankErrMsg(String bankErrMsg) {
        this.bankErrMsg = bankErrMsg == null ? null : bankErrMsg.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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
        TbPayReconciliationCheckBatch other = (TbPayReconciliationCheckBatch) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getEditTime() == null ? other.getEditTime() == null : this.getEditTime().equals(other.getEditTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getHandleStatus() == null ? other.getHandleStatus() == null : this.getHandleStatus().equals(other.getHandleStatus()))
            && (this.getBankType() == null ? other.getBankType() == null : this.getBankType().equals(other.getBankType()))
            && (this.getMistakeCount() == null ? other.getMistakeCount() == null : this.getMistakeCount().equals(other.getMistakeCount()))
            && (this.getUnhandleMistakeCount() == null ? other.getUnhandleMistakeCount() == null : this.getUnhandleMistakeCount().equals(other.getUnhandleMistakeCount()))
            && (this.getTradeCount() == null ? other.getTradeCount() == null : this.getTradeCount().equals(other.getTradeCount()))
            && (this.getBankTradeCount() == null ? other.getBankTradeCount() == null : this.getBankTradeCount().equals(other.getBankTradeCount()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getBankTradeAmount() == null ? other.getBankTradeAmount() == null : this.getBankTradeAmount().equals(other.getBankTradeAmount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getBankRefundAmount() == null ? other.getBankRefundAmount() == null : this.getBankRefundAmount().equals(other.getBankRefundAmount()))
            && (this.getBankFee() == null ? other.getBankFee() == null : this.getBankFee().equals(other.getBankFee()))
            && (this.getOrgCheckFilePath() == null ? other.getOrgCheckFilePath() == null : this.getOrgCheckFilePath().equals(other.getOrgCheckFilePath()))
            && (this.getReleaseCheckFilePath() == null ? other.getReleaseCheckFilePath() == null : this.getReleaseCheckFilePath().equals(other.getReleaseCheckFilePath()))
            && (this.getReleaseStatus() == null ? other.getReleaseStatus() == null : this.getReleaseStatus().equals(other.getReleaseStatus()))
            && (this.getCheckFailMsg() == null ? other.getCheckFailMsg() == null : this.getCheckFailMsg().equals(other.getCheckFailMsg()))
            && (this.getBankErrMsg() == null ? other.getBankErrMsg() == null : this.getBankErrMsg().equals(other.getBankErrMsg()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEditor() == null) ? 0 : getEditor().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getEditTime() == null) ? 0 : getEditTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getHandleStatus() == null) ? 0 : getHandleStatus().hashCode());
        result = prime * result + ((getBankType() == null) ? 0 : getBankType().hashCode());
        result = prime * result + ((getMistakeCount() == null) ? 0 : getMistakeCount().hashCode());
        result = prime * result + ((getUnhandleMistakeCount() == null) ? 0 : getUnhandleMistakeCount().hashCode());
        result = prime * result + ((getTradeCount() == null) ? 0 : getTradeCount().hashCode());
        result = prime * result + ((getBankTradeCount() == null) ? 0 : getBankTradeCount().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getBankTradeAmount() == null) ? 0 : getBankTradeAmount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getBankRefundAmount() == null) ? 0 : getBankRefundAmount().hashCode());
        result = prime * result + ((getBankFee() == null) ? 0 : getBankFee().hashCode());
        result = prime * result + ((getOrgCheckFilePath() == null) ? 0 : getOrgCheckFilePath().hashCode());
        result = prime * result + ((getReleaseCheckFilePath() == null) ? 0 : getReleaseCheckFilePath().hashCode());
        result = prime * result + ((getReleaseStatus() == null) ? 0 : getReleaseStatus().hashCode());
        result = prime * result + ((getCheckFailMsg() == null) ? 0 : getCheckFailMsg().hashCode());
        result = prime * result + ((getBankErrMsg() == null) ? 0 : getBankErrMsg().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", editor=").append(editor);
        sb.append(", creater=").append(creater);
        sb.append(", editTime=").append(editTime);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", billDate=").append(billDate);
        sb.append(", billType=").append(billType);
        sb.append(", handleStatus=").append(handleStatus);
        sb.append(", bankType=").append(bankType);
        sb.append(", mistakeCount=").append(mistakeCount);
        sb.append(", unhandleMistakeCount=").append(unhandleMistakeCount);
        sb.append(", tradeCount=").append(tradeCount);
        sb.append(", bankTradeCount=").append(bankTradeCount);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", bankTradeAmount=").append(bankTradeAmount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", bankRefundAmount=").append(bankRefundAmount);
        sb.append(", bankFee=").append(bankFee);
        sb.append(", orgCheckFilePath=").append(orgCheckFilePath);
        sb.append(", releaseCheckFilePath=").append(releaseCheckFilePath);
        sb.append(", releaseStatus=").append(releaseStatus);
        sb.append(", checkFailMsg=").append(checkFailMsg);
        sb.append(", bankErrMsg=").append(bankErrMsg);
        sb.append(", fee=").append(fee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}