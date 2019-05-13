package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 账单详情实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/2 16:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillDetails" ,description = "账单详情实体类")
public class PayBillDetails implements Serializable {
    private static final long serialVersionUID = 9133457186116223879L;

    @ApiModelProperty(value="详情ID",example = "20190001")
    private String detailsId;

    @ApiModelProperty(value="账单编号[关联创建的账单编号]",example = "201905090000001")
    private String billId;

    @ApiModelProperty(value="费用详情名称",example = "房间号")
    private String costName;

    @ApiModelProperty(value="费用详情对应值",example = "607")
    private String costValue;

    @ApiModelProperty(value="创建人",example = "wangsong")
    private String creatorAccount;

    @ApiModelProperty(value="创建时间",example = "2019-05-07 12:12:12")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="记录状态   0标记删除，1正常",example = "1")
    private String recordStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostValue() {
        return costValue;
    }

    public void setCostValue(String costValue) {
        this.costValue = costValue;
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

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }
}
