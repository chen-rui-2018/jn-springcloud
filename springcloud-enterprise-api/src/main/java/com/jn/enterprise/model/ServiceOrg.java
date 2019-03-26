package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务机构
 * @author： jiangyl
 * @date： Created on 2019/2/13 15:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceOrg", description = "服务机构")
public class ServiceOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "机构ID")
    private String orgId;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    @ApiModelProperty(value = "机构注册时间 yyyy-MM-dd")
    private String orgRegisterTime;

    @ApiModelProperty(value = "是否认证(0未认证1已认证)")
    private String isApprove;

    @ApiModelProperty(value = "机构类型(1普通机构2会员机构) ")
    private String orgType;

    @ApiModelProperty(value = "机构咨询电话")
    private String orgPhone;

    @ApiModelProperty(value = "机构地址")
    private String orgAddress;

    @ApiModelProperty(value = "机构LOGO")
    private String orgLogo;

    @ApiModelProperty(value = "服务评分")
    private String attitudeScore;

    @ApiModelProperty(value = "浏览量（人气）")
    private Integer pageviews;
    @ApiModelProperty(value = "累计交易次数（服务量）")
    private Integer transactionNum;
    @ApiModelProperty(value = "评价次数")
    private Integer evaluationNum;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgRegisterTime() {
        return orgRegisterTime;
    }

    public void setOrgRegisterTime(String orgRegisterTime) {
        this.orgRegisterTime = orgRegisterTime;
    }

    public String getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(String attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public Integer getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(Integer transactionNum) {
        this.transactionNum = transactionNum;
    }

    public Integer getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(Integer evaluationNum) {
        this.evaluationNum = evaluationNum;
    }
}
