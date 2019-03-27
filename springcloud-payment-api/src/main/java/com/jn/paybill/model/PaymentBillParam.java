package com.jn.paybill.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/12 10:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PaymentBillParam", description = "账单查询入参")
public class PaymentBillParam extends Page implements Serializable {
    @ApiModelProperty(value = "账单ID",example = "d04db3c7135045608a1ba200ce10946c")
    private String billId;
    @ApiModelProperty(value = "账单编号",example = "TCJF-201903250154258")
    private String billNum;
    @ApiModelProperty(value = "账单名称",example = "湘A122JS-20190325停车费")
    private String billName;
    @ApiModelProperty(value = "账单类型",example = "005"
            ,notes = "暂定：001楼宇租金 002物业费 003水费 004电费 005停车费 006维修费 007广告费")
    private String billType;
    @ApiModelProperty(value = "账单对象ID",example = "wangsong")
    private String billObjId;
    @ApiModelProperty(value = "账单金额",example = "25.00")
    private Double billAmount;
    @ApiModelProperty(value = "账单生成开始时间[yyyy-MM-dd HH:mm:ss]",example = "2019-03-10 09:00:00")
    private String billCreateTimeBegin;
    @ApiModelProperty(value = "账单生成结束时间[yyyy-MM-dd HH:mm:ss]",example = "2019-03-11 09:00:00")
    private String billCreateTimeEnd;
    @ApiModelProperty(value = "最晚缴费开始时间[yyyy-MM-dd HH:mm:ss]",example = "2019-03-10 09:00:00")
    private String payEndTimeBegin;
    @ApiModelProperty(value = "最晚缴费结束时间[yyyy-MM-dd HH:mm:ss]",example = "2019-03-11 09:00:00")
    private String payEndTimeEnd;
    @ApiModelProperty(value = "生成操作人",example = "王松")
    private String billCreateAccount;
    @ApiModelProperty(value = "账单说明",example = "补缴停车费")
    private String billRemark;
    @ApiModelProperty(value = "账单状态[0未审核1待支付2已支付待审核3支付失败4确认支付5支付审核不通过]",example = "4")
    @Pattern(regexp = "^[0,1,3,4,5]$", message = "{billStatus:'账单状态[0、1、2、3、4、5]'}")
    private String billStatus;
    @ApiModelProperty(value = "是否已催付[0否1是]",example = "1")
    @Pattern(regexp = "^[0,1]$", message = "{isUrge:'支付方式只能为[0、1]'}")
    private String isUrge;
    @ApiModelProperty(value = "排序字段",notes = "支付方式排序：billType支付方式,billCreateTime账单生成时间,billStatus账单状态",example = "billType")
    private String orderBy;
    @ApiModelProperty(value = "搜索关键字")
    private String searchCode;
    @ApiModelProperty(value = "查询类型[1前端业务2后台业务]",notes = "前台业务和后台业务的区别为：前台用户不能查询待审核和审核失败账单，为空默认查前端业务",example = "2")
    @Pattern(regexp = "^[2,1]$", message = "{isUrge:'支付方式只能为[2、1]'}")
    private String queryType;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillObjId() {
        return billObjId;
    }

    public void setBillObjId(String billObjId) {
        this.billObjId = billObjId;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCreateTimeBegin() {
        return billCreateTimeBegin;
    }

    public void setBillCreateTimeBegin(String billCreateTimeBegin) {
        this.billCreateTimeBegin = billCreateTimeBegin;
    }

    public String getBillCreateTimeEnd() {
        return billCreateTimeEnd;
    }

    public void setBillCreateTimeEnd(String billCreateTimeEnd) {
        this.billCreateTimeEnd = billCreateTimeEnd;
    }

    public String getPayEndTimeBegin() {
        return payEndTimeBegin;
    }

    public void setPayEndTimeBegin(String payEndTimeBegin) {
        this.payEndTimeBegin = payEndTimeBegin;
    }

    public String getPayEndTimeEnd() {
        return payEndTimeEnd;
    }

    public void setPayEndTimeEnd(String payEndTimeEnd) {
        this.payEndTimeEnd = payEndTimeEnd;
    }

    public String getBillCreateAccount() {
        return billCreateAccount;
    }

    public void setBillCreateAccount(String billCreateAccount) {
        this.billCreateAccount = billCreateAccount;
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getIsUrge() {
        return isUrge;
    }

    public void setIsUrge(String isUrge) {
        this.isUrge = isUrge;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSearchCode() {
        return searchCode;
    }

    public void setSearchCode(String searchCode) {
        this.searchCode = searchCode;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
