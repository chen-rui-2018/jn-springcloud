package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/28 9:55
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorManagementPortalParam",description = "(门户管理)专员管理入参")
public class AdvisorManagementPortalParam extends Page implements Serializable {
    @ApiModelProperty(value = "专员账号",example = "wangsong")
    private String advisorName;
    @ApiModelProperty(value = "是否认证  1:是   0：否",example = "1")
    @Pattern(regexp = "^[01]|(\\s+)$", message = "{isDefault:'默认值只允许为0,1'}")
    private String isCertification;
    @ApiModelProperty(value = "提交开始时间",example = "201901")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{submitStartTime:'提交开始时间格式错误'}")
    private String submitStartTime;
    @ApiModelProperty(value = "提交结束时间",example = "201903")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{submitStartTime:'提交结束时间格式错误'}")
    private String submitEndTime;
    @ApiModelProperty(value = "所属机构",example = "xxx机构")
    private String affiliation;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification;
    }

    public String getSubmitStartTime() {
        return submitStartTime;
    }

    public void setSubmitStartTime(String submitStartTime) {
        this.submitStartTime = submitStartTime;
    }

    public String getSubmitEndTime() {
        return submitEndTime;
    }

    public void setSubmitEndTime(String submitEndTime) {
        this.submitEndTime = submitEndTime;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    @Override
    public String toString() {
        return "AdvisorManagementPortalParam{" +
                "advisorName='" + advisorName + '\'' +
                ", isCertification='" + isCertification + '\'' +
                ", submitStartTime='" + submitStartTime + '\'' +
                ", submitEndTime='" + submitEndTime + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", needPage='" + needPage + '\'' +
                '}';
    }
}
