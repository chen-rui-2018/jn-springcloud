package com.jn.enterprise.technologyfinancial.investors.vo;

import com.jn.enterprise.technologyfinancial.investors.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/14 11:46
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorInfoDetailsVo", description = "科技金融投资人详情")
public class InvestorInfoDetailsVo implements Serializable {
    @ApiModelProperty(value = "投资人基本信息")
    private InvestorBaseInfoShow investorBaseInfoShow;
    @ApiModelProperty(value = "主投领域")
    private List<InvestorMainArea> mainAreaList;
    @ApiModelProperty(value = "主投轮次")
    private List<InvestorMainRound> mainRoundList;
    @ApiModelProperty(value = "工作经历")
    private List<InvestorWorkExperienceShow> workExperienceList;
    @ApiModelProperty(value = "教育经历")
    private List<InvestorEduExperienceShow> eduExpList;

    public InvestorBaseInfoShow getInvestorBaseInfoShow() {
        return investorBaseInfoShow;
    }

    public void setInvestorBaseInfoShow(InvestorBaseInfoShow investorBaseInfoShow) {
        this.investorBaseInfoShow = investorBaseInfoShow;
    }

    public List<InvestorMainArea> getMainAreaList() {
        return mainAreaList;
    }

    public void setMainAreaList(List<InvestorMainArea> mainAreaList) {
        this.mainAreaList = mainAreaList;
    }

    public List<InvestorMainRound> getMainRoundList() {
        return mainRoundList;
    }

    public void setMainRoundList(List<InvestorMainRound> mainRoundList) {
        this.mainRoundList = mainRoundList;
    }

    public List<InvestorWorkExperienceShow> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<InvestorWorkExperienceShow> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<InvestorEduExperienceShow> getEduExpList() {
        return eduExpList;
    }

    public void setEduExpList(List<InvestorEduExperienceShow> eduExpList) {
        this.eduExpList = eduExpList;
    }
}
