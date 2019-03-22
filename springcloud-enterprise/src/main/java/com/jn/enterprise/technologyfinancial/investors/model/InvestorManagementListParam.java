package com.jn.enterprise.technologyfinancial.investors.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/21 15:00
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorManagementListParam", description = "科技金融管理投资人管理列表查询入参")
public class InvestorManagementListParam extends Page implements Serializable {
    @ApiModelProperty(value = "状态(0：无效   1：有效)")
    @Pattern(regexp="^[01]$",message="{status:'状态值只允许为0,1'}")
    private String status;
    @ApiModelProperty(value = "姓名")
    private String investorName;
    @ApiModelProperty(value = "所属单位")
    private String affiliationUnit;
    @ApiModelProperty(value = "手机号码")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;
    @ApiModelProperty(value = "申请日期开始时间(格式：201903)")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{applyStartTime:'申请日期开始时间格式错误'}")
    private String applyStartTime;
    @ApiModelProperty(value = "申请日期结束时间(格式：201903)")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{applyEndTime:'申请日期结束时间格式错误'}")
    private String applyEndTime;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页",required = true)
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getAffiliationUnit() {
        return affiliationUnit;
    }

    public void setAffiliationUnit(String affiliationUnit) {
        this.affiliationUnit = affiliationUnit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(String applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public String getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(String applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
