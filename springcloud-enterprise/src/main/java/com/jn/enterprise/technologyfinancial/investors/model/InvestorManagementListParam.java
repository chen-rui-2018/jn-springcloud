package com.jn.enterprise.technologyfinancial.investors.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/21 15:00
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorManagementListParam", description = "科技金融管理投资人管理列表查询入参")
public class InvestorManagementListParam extends Page implements Serializable {
    @ApiModelProperty(value = "状态(0：无效   1：有效)",example = "1")
    @Pattern(regexp="^[01]$",message="{status:'状态值只允许为0,1'}")
    private String status;
    @ApiModelProperty(value = "姓名",example = "王松")
    private String investorName;
    @ApiModelProperty(value = "所属单位",example = "xxx单位")
    private String affiliationUnit;
    @ApiModelProperty(value = "手机号码",example = "18088888888")
    @Pattern(regexp = "^[0-9]*$",
            message = "{phone:'手机号只能是数字'}")
    @Size(max=11,message = "手机号码最多为11位")
    private String phone;
    @ApiModelProperty(value = "申请日期开始时间",example = "201903")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{applyStartTime:'申请日期开始时间格式错误'}")
    private String applyStartTime;
    @ApiModelProperty(value = "申请日期结束时间",example = "201904")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{applyEndTime:'申请日期结束时间格式错误'}")
    private String applyEndTime;
    @ApiModelProperty(value = "职务",example = "xxx职务")
    private String position;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
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
