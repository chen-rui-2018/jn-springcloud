package com.jn.enterprise.servicemarket.require.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/5 18:00
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "HandleRequireParam", description = "对接需求入参")
public class HandleRequireParam implements Serializable {
    @ApiModelProperty(value = "需求单号",required = true,example = "xq-0001")
    @NotNull(message = "需求单号不能为空")
    private String reqNum;
    @ApiModelProperty(value = "合同总金额",example = "10")
    @Pattern(regexp ="[0-9]*|(\\s*)",message = "合同总金额只能输入数字")
    private String contractAmount;
    @ApiModelProperty(value = "对接结果(1:对接成功  2:对接失败  3:企业需求撤销)",example = "1")
    @Pattern(regexp = "^[123]|(\\s*)$", message = "{对接结果:'默认值只允许为1,2,3'}")
    private String handleResult;
    @ApiModelProperty(value = "结果描述",example = "xxx描述")
    private String resultDetail;
    @ApiModelProperty(value = "实际贷款金额（万元）",example = "20")
    @Pattern(regexp ="[0-9]*|(\\s*)",message = "实际贷款金额只能输入数字")
    private String actualLoanAmount;
    @ApiModelProperty(value = "合同首页",example = "xxx/home.jpg")
    private String contractHomePage;
    @ApiModelProperty(value = "合同尾页",example = "xxx/end.jpg")
    private String contractEndPage;
    @ApiModelProperty(value = "是否科技金融类:0:非科技金融类  1：是科技金融类",required = true,example = "1")
    @NotNull(message = "是否科技金融类不能为空")
    @Pattern(regexp = "^[01]$", message = "{isTechnology:'默认值只允许为0,1'}")
    private String isTechnology;
    public String getReqNum() {
        return reqNum;
    }

    public void setReqNum(String reqNum) {
        this.reqNum = reqNum;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
    }

    public String getContractHomePage() {
        return contractHomePage;
    }

    public void setContractHomePage(String contractHomePage) {
        this.contractHomePage = contractHomePage;
    }

    public String getContractEndPage() {
        return contractEndPage;
    }

    public void setContractEndPage(String contractEndPage) {
        this.contractEndPage = contractEndPage;
    }

    public String getIsTechnology() {
        return isTechnology;
    }

    public void setIsTechnology(String isTechnology) {
        this.isTechnology = isTechnology;
    }
}
