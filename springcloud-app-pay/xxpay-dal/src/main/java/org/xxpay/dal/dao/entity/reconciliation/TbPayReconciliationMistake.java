package org.xxpay.dal.dao.entity.reconciliation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPayReconciliationMistake implements Serializable {
    private Integer id;

    private Integer version;

    private Date createTime;

    private String editor;

    private String creater;

    private Date editTime;

    private String status;

    private String remark;

    private String accountCheckBatchNo;

    private Date billDate;

    private String bankType;

    private Date orderTime;

    private String merchantName;

    private String merchantNo;

    private String orderNo;

    private Date tradeTime;

    private String trxNo;

    private BigDecimal orderAmount;

    private BigDecimal refundAmount;

    private String tradeStatus;

    private BigDecimal fee;

    private Date bankTradeTime;

    private String bankOrderNo;

    private String bankTrxNo;

    private String bankTradeStatus;

    private BigDecimal bankAmount;

    private BigDecimal bankRefundAmount;

    private BigDecimal bankFee;

    private String errType;

    private String handleStatus;

    private String handleValue;

    private String handleRemark;

    private String operatorName;

    private String operatorAccountNo;

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

    public String getAccountCheckBatchNo() {
        return accountCheckBatchNo;
    }

    public void setAccountCheckBatchNo(String accountCheckBatchNo) {
        this.accountCheckBatchNo = accountCheckBatchNo == null ? null : accountCheckBatchNo.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTrxNo() {
        return trxNo;
    }

    public void setTrxNo(String trxNo) {
        this.trxNo = trxNo == null ? null : trxNo.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getBankTradeTime() {
        return bankTradeTime;
    }

    public void setBankTradeTime(Date bankTradeTime) {
        this.bankTradeTime = bankTradeTime;
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

    public String getBankTradeStatus() {
        return bankTradeStatus;
    }

    public void setBankTradeStatus(String bankTradeStatus) {
        this.bankTradeStatus = bankTradeStatus == null ? null : bankTradeStatus.trim();
    }

    public BigDecimal getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(BigDecimal bankAmount) {
        this.bankAmount = bankAmount;
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

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType == null ? null : errType.trim();
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus == null ? null : handleStatus.trim();
    }

    public String getHandleValue() {
        return handleValue;
    }

    public void setHandleValue(String handleValue) {
        this.handleValue = handleValue == null ? null : handleValue.trim();
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark == null ? null : handleRemark.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatorAccountNo() {
        return operatorAccountNo;
    }

    public void setOperatorAccountNo(String operatorAccountNo) {
        this.operatorAccountNo = operatorAccountNo == null ? null : operatorAccountNo.trim();
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
        TbPayReconciliationMistake other = (TbPayReconciliationMistake) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getEditTime() == null ? other.getEditTime() == null : this.getEditTime().equals(other.getEditTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccountCheckBatchNo() == null ? other.getAccountCheckBatchNo() == null : this.getAccountCheckBatchNo().equals(other.getAccountCheckBatchNo()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getBankType() == null ? other.getBankType() == null : this.getBankType().equals(other.getBankType()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getMerchantName() == null ? other.getMerchantName() == null : this.getMerchantName().equals(other.getMerchantName()))
            && (this.getMerchantNo() == null ? other.getMerchantNo() == null : this.getMerchantNo().equals(other.getMerchantNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getTradeTime() == null ? other.getTradeTime() == null : this.getTradeTime().equals(other.getTradeTime()))
            && (this.getTrxNo() == null ? other.getTrxNo() == null : this.getTrxNo().equals(other.getTrxNo()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getTradeStatus() == null ? other.getTradeStatus() == null : this.getTradeStatus().equals(other.getTradeStatus()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getBankTradeTime() == null ? other.getBankTradeTime() == null : this.getBankTradeTime().equals(other.getBankTradeTime()))
            && (this.getBankOrderNo() == null ? other.getBankOrderNo() == null : this.getBankOrderNo().equals(other.getBankOrderNo()))
            && (this.getBankTrxNo() == null ? other.getBankTrxNo() == null : this.getBankTrxNo().equals(other.getBankTrxNo()))
            && (this.getBankTradeStatus() == null ? other.getBankTradeStatus() == null : this.getBankTradeStatus().equals(other.getBankTradeStatus()))
            && (this.getBankAmount() == null ? other.getBankAmount() == null : this.getBankAmount().equals(other.getBankAmount()))
            && (this.getBankRefundAmount() == null ? other.getBankRefundAmount() == null : this.getBankRefundAmount().equals(other.getBankRefundAmount()))
            && (this.getBankFee() == null ? other.getBankFee() == null : this.getBankFee().equals(other.getBankFee()))
            && (this.getErrType() == null ? other.getErrType() == null : this.getErrType().equals(other.getErrType()))
            && (this.getHandleStatus() == null ? other.getHandleStatus() == null : this.getHandleStatus().equals(other.getHandleStatus()))
            && (this.getHandleValue() == null ? other.getHandleValue() == null : this.getHandleValue().equals(other.getHandleValue()))
            && (this.getHandleRemark() == null ? other.getHandleRemark() == null : this.getHandleRemark().equals(other.getHandleRemark()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getOperatorAccountNo() == null ? other.getOperatorAccountNo() == null : this.getOperatorAccountNo().equals(other.getOperatorAccountNo()));
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
        result = prime * result + ((getAccountCheckBatchNo() == null) ? 0 : getAccountCheckBatchNo().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getBankType() == null) ? 0 : getBankType().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getMerchantName() == null) ? 0 : getMerchantName().hashCode());
        result = prime * result + ((getMerchantNo() == null) ? 0 : getMerchantNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getTradeTime() == null) ? 0 : getTradeTime().hashCode());
        result = prime * result + ((getTrxNo() == null) ? 0 : getTrxNo().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getTradeStatus() == null) ? 0 : getTradeStatus().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getBankTradeTime() == null) ? 0 : getBankTradeTime().hashCode());
        result = prime * result + ((getBankOrderNo() == null) ? 0 : getBankOrderNo().hashCode());
        result = prime * result + ((getBankTrxNo() == null) ? 0 : getBankTrxNo().hashCode());
        result = prime * result + ((getBankTradeStatus() == null) ? 0 : getBankTradeStatus().hashCode());
        result = prime * result + ((getBankAmount() == null) ? 0 : getBankAmount().hashCode());
        result = prime * result + ((getBankRefundAmount() == null) ? 0 : getBankRefundAmount().hashCode());
        result = prime * result + ((getBankFee() == null) ? 0 : getBankFee().hashCode());
        result = prime * result + ((getErrType() == null) ? 0 : getErrType().hashCode());
        result = prime * result + ((getHandleStatus() == null) ? 0 : getHandleStatus().hashCode());
        result = prime * result + ((getHandleValue() == null) ? 0 : getHandleValue().hashCode());
        result = prime * result + ((getHandleRemark() == null) ? 0 : getHandleRemark().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getOperatorAccountNo() == null) ? 0 : getOperatorAccountNo().hashCode());
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
        sb.append(", accountCheckBatchNo=").append(accountCheckBatchNo);
        sb.append(", billDate=").append(billDate);
        sb.append(", bankType=").append(bankType);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", merchantNo=").append(merchantNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", trxNo=").append(trxNo);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", tradeStatus=").append(tradeStatus);
        sb.append(", fee=").append(fee);
        sb.append(", bankTradeTime=").append(bankTradeTime);
        sb.append(", bankOrderNo=").append(bankOrderNo);
        sb.append(", bankTrxNo=").append(bankTrxNo);
        sb.append(", bankTradeStatus=").append(bankTradeStatus);
        sb.append(", bankAmount=").append(bankAmount);
        sb.append(", bankRefundAmount=").append(bankRefundAmount);
        sb.append(", bankFee=").append(bankFee);
        sb.append(", errType=").append(errType);
        sb.append(", handleStatus=").append(handleStatus);
        sb.append(", handleValue=").append(handleValue);
        sb.append(", handleRemark=").append(handleRemark);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", operatorAccountNo=").append(operatorAccountNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}