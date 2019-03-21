package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/2/25 15:53
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AcceptOrgInvitation", description = "接受机构邀请入参")
public class AcceptOrgInvitation implements Serializable {
    @ApiModelProperty(value = "顾问基本信息)")
    private AdvisorServiceInfo advisorServiceInfo;
    @ApiModelProperty(value = "顾问荣誉资质)")
    private List<ServiceHonor> serviceHonorList;
    @ApiModelProperty(value = "顾问服务经历)")
    private List<ServiceExperience> serviceExperienceList;
    @ApiModelProperty(value = "顾问项目经验)")
    private List<ServiceProjectExperience> serviceProjectExperienceList;
    @ApiModelProperty(value = "服务评价)")
    private List<ServiceRating> serviceRatingList;

    public AdvisorServiceInfo getAdvisorServiceInfo() {
        return advisorServiceInfo;
    }

    public void setAdvisorServiceInfo(AdvisorServiceInfo advisorServiceInfo) {
        this.advisorServiceInfo = advisorServiceInfo;
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

    public List<ServiceRating> getServiceRatingList() {
        return serviceRatingList;
    }

    public void setServiceRatingList(List<ServiceRating> serviceRatingList) {
        this.serviceRatingList = serviceRatingList;
    }
}
