package com.jn.enterprise.servicemarket.advisor.vo;

import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
import com.jn.enterprise.servicemarket.product.model.AdvisorProductInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 服务顾问详情
 * @Author: yangph
 * @Date: 2019/2/14 16:28
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorDetailsVo", description = "服务顾问详情")
public class AdvisorDetailsVo implements Serializable {
    @ApiModelProperty(value = "顾问详情简介)")
    private AdvisorIntroduction advisorIntroduction;
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
    @ApiModelProperty(value = "服务产品列表")
    private List<AdvisorProductInfo> advisorProductInfoList;
    @ApiModelProperty(value = "好评数")
    private int praiseNum;
    @ApiModelProperty(value = "中评数")
    private int averageNum;
    @ApiModelProperty(value = "差评数")
    private int badReviewNum;
    @ApiModelProperty(value = "评价总数")
    private int evaluationTotal;


    private static final long serialVersionUID = 1L;

    public AdvisorIntroduction getAdvisorIntroduction() {
        return advisorIntroduction;
    }

    public void setAdvisorIntroduction(AdvisorIntroduction advisorIntroduction) {
        this.advisorIntroduction = advisorIntroduction;
    }

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

    public List<AdvisorProductInfo> getAdvisorProductInfoList() {
        return advisorProductInfoList;
    }

    public void setAdvisorProductInfoList(List<AdvisorProductInfo> advisorProductInfoList) {
        this.advisorProductInfoList = advisorProductInfoList;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }

    public int getAverageNum() {
        return averageNum;
    }

    public void setAverageNum(int averageNum) {
        this.averageNum = averageNum;
    }

    public int getBadReviewNum() {
        return badReviewNum;
    }

    public void setBadReviewNum(int badReviewNum) {
        this.badReviewNum = badReviewNum;
    }

    public int getEvaluationTotal() {
        return evaluationTotal;
    }

    public void setEvaluationTotal(int evaluationTotal) {
        this.evaluationTotal = evaluationTotal;
    }
}
