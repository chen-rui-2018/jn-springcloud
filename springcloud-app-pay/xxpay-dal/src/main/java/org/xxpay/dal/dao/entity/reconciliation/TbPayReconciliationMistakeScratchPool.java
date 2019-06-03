package org.xxpay.dal.dao.entity.reconciliation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPayReconciliationMistakeScratchPool implements Serializable {
    private Integer id;

    private Integer version;

    private Date createTime;

    private String editor;

    private String creater;

    private Date editTime;

    private String productName;

    private String merchantOrderNo;

    private String trxNo;

    private String bankOrderNo;

    private String bankTrxNo;

    private BigDecimal orderAmount;

    private BigDecimal platIncome;

    private BigDecimal feeRate;

    private BigDecimal platCost;

    private BigDecimal platProfit;

    private String status;

    private String payWayCode;

    private String payWayName;

    private Date paySuccessTime;

    private Date completeTime;

    private String isRefund;

    private Short refundTimes;

    private BigDecimal successRefundAmount;

    private String remark;

    private String batchNo;

    private Date billDate;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    public String getTrxNo() {
        return trxNo;
    }

    public void setTrxNo(String trxNo) {
        this.trxNo = trxNo == null ? null : trxNo.trim();
    }

    public String getBankOrderNo() {
        return bankOrderNo;
    }

    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo == null ? null : bankOrderNo.trim();
    }

    public String getBankTrxNo() {
        return bankTrxNo;
    }

    public void setBankTrxNo(String bankTrxNo) {
        this.bankTrxNo = bankTrxNo == null ? null : bankTrxNo.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPlatIncome() {
        return platIncome;
    }

    public void setPlatIncome(BigDecimal platIncome) {
        this.platIncome = platIncome;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public BigDecimal getPlatCost() {
        return platCost;
    }

    public void setPlatCost(BigDecimal platCost) {
        this.platCost = platCost;
    }

    public BigDecimal getPlatProfit() {
        return platProfit;
    }

    public void setPlatProfit(BigDecimal platProfit) {
        this.platProfit = platProfit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayWayCode() {
        return payWayCode;
    }

    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode == null ? null : payWayCode.trim();
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName == null ? null : payWayName.trim();
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund == null ? null : isRefund.trim();
    }

    public Short getRefundTimes() {
        return refundTimes;
    }

    public void setRefundTimes(Short refundTimes) {
        this.refundTimes = refundTimes;
    }

    public BigDecimal getSuccessRefundAmount() {
        return successRefundAmount;
    }

    public void setSuccessRefundAmount(BigDecimal successRefundAmount) {
        this.successRefundAmount = successRefundAmount;
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
        TbPayReconciliationMistakeScratchPool other = (TbPayReconciliationMistakeScratchPool) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getEditTime() == null ? other.getEditTime() == null : this.getEditTime().equals(other.getEditTime()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getTrxNo() == null ? other.getTrxNo() == null : this.getTrxNo().equals(other.getTrxNo()))
            && (this.getBankOrderNo() == null ? other.getBankOrderNo() == null : this.getBankOrderNo().equals(other.getBankOrderNo()))
            && (this.getBankTrxNo() == null ? other.getBankTrxNo() == null : this.getBankTrxNo().equals(other.getBankTrxNo()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getPlatIncome() == null ? other.getPlatIncome() == null : this.getPlatIncome().equals(other.getPlatIncome()))
            && (this.getFeeRate() == null ? other.getFeeRate() == null : this.getFeeRate().equals(other.getFeeRate()))
            && (this.getPlatCost() == null ? other.getPlatCost() == null : this.getPlatCost().equals(other.getPlatCost()))
            && (this.getPlatProfit() == null ? other.getPlatProfit() == null : this.getPlatProfit().equals(other.getPlatProfit()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayWayCode() == null ? other.getPayWayCode() == null : this.getPayWayCode().equals(other.getPayWayCode()))
            && (this.getPayWayName() == null ? other.getPayWayName() == null : this.getPayWayName().equals(other.getPayWayName()))
            && (this.getPaySuccessTime() == null ? other.getPaySuccessTime() == null : this.getPaySuccessTime().equals(other.getPaySuccessTime()))
            && (this.getCompleteTime() == null ? other.getCompleteTime() == null : this.getCompleteTime().equals(other.getCompleteTime()))
            && (this.getIsRefund() == null ? other.getIsRefund() == null : this.getIsRefund().equals(other.getIsRefund()))
            && (this.getRefundTimes() == null ? other.getRefundTimes() == null : this.getRefundTimes().equals(other.getRefundTimes()))
            && (this.getSuccessRefundAmount() == null ? other.getSuccessRefundAmount() == null : this.getSuccessRefundAmount().equals(other.getSuccessRefundAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()));
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
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getTrxNo() == null) ? 0 : getTrxNo().hashCode());
        result = prime * result + ((getBankOrderNo() == null) ? 0 : getBankOrderNo().hashCode());
        result = prime * result + ((getBankTrxNo() == null) ? 0 : getBankTrxNo().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getPlatIncome() == null) ? 0 : getPlatIncome().hashCode());
        result = prime * result + ((getFeeRate() == null) ? 0 : getFeeRate().hashCode());
        result = prime * result + ((getPlatCost() == null) ? 0 : getPlatCost().hashCode());
        result = prime * result + ((getPlatProfit() == null) ? 0 : getPlatProfit().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayWayCode() == null) ? 0 : getPayWayCode().hashCode());
        result = prime * result + ((getPayWayName() == null) ? 0 : getPayWayName().hashCode());
        result = prime * result + ((getPaySuccessTime() == null) ? 0 : getPaySuccessTime().hashCode());
        result = prime * result + ((getCompleteTime() == null) ? 0 : getCompleteTime().hashCode());
        result = prime * result + ((getIsRefund() == null) ? 0 : getIsRefund().hashCode());
        result = prime * result + ((getRefundTimes() == null) ? 0 : getRefundTimes().hashCode());
        result = prime * result + ((getSuccessRefundAmount() == null) ? 0 : getSuccessRefundAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
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
        sb.append(", productName=").append(productName);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", trxNo=").append(trxNo);
        sb.append(", bankOrderNo=").append(bankOrderNo);
        sb.append(", bankTrxNo=").append(bankTrxNo);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", platIncome=").append(platIncome);
        sb.append(", feeRate=").append(feeRate);
        sb.append(", platCost=").append(platCost);
        sb.append(", platProfit=").append(platProfit);
        sb.append(", status=").append(status);
        sb.append(", payWayCode=").append(payWayCode);
        sb.append(", payWayName=").append(payWayName);
        sb.append(", paySuccessTime=").append(paySuccessTime);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", isRefund=").append(isRefund);
        sb.append(", refundTimes=").append(refundTimes);
        sb.append(", successRefundAmount=").append(successRefundAmount);
        sb.append(", remark=").append(remark);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", billDate=").append(billDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}