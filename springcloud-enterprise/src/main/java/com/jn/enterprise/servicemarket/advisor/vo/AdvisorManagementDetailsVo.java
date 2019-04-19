package com.jn.enterprise.servicemarket.advisor.vo;

import com.jn.enterprise.servicemarket.advisor.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/2/28 15:34
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorManagementDetailsVo", description = "服务顾问详情(后台门户管理)")
public class AdvisorManagementDetailsVo implements Serializable {
    @ApiModelProperty(value = "顾问详情简介)")
    private AdvisorServiceManagementInfo advisorIntroduction;
    @ApiModelProperty(value = "顾问基本信息)")
    private AdvisorBaseInfoParam advisorBaseInfoParam;
    @ApiModelProperty(value = "顾问荣誉资质)")
    private List<ServiceHonor> serviceHonorList;
    @ApiModelProperty(value = "顾问服务经历)")
    private List<ServiceExperience> serviceExperienceList;
    @ApiModelProperty(value = "顾问项目经验)")
    private List<ServiceProjectExperience> serviceProjectExperienceList;

    public AdvisorServiceManagementInfo getAdvisorIntroduction() {
        return advisorIntroduction;
    }

    public void setAdvisorIntroduction(AdvisorServiceManagementInfo advisorIntroduction) {
        this.advisorIntroduction = advisorIntroduction;
    }

    public AdvisorBaseInfoParam getAdvisorBaseInfoParam() {
        return advisorBaseInfoParam;
    }

    public void setAdvisorBaseInfoParam(AdvisorBaseInfoParam advisorBaseInfoParam) {
        this.advisorBaseInfoParam = advisorBaseInfoParam;
    }

    public List<ServiceHonor> getServiceHonorList() {
        return serviceHonorList;
    }

    public void setServiceHonorList(List<ServiceHonor> serviceHonorList) {
        this.serviceHonorList = serviceHonorList;
    }

    public List<ServiceExperience> getServiceExperienceList() {
        return serviceExperienceList;
    }

    public void setServiceExperienceList(List<ServiceExperience> serviceExperienceList) {
        this.serviceExperienceList = serviceExperienceList;
    }

    public List<ServiceProjectExperience> getServiceProjectExperienceList() {
        return serviceProjectExperienceList;
    }

    public void setServiceProjectExperienceList(List<ServiceProjectExperience> serviceProjectExperienceList) {
        this.serviceProjectExperienceList = serviceProjectExperienceList;
    }
}
