package com.jn.enterprise.technologyfinancial.investors.vo;

import com.jn.enterprise.technologyfinancial.investors.entity.*;
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
    private TbServiceInvestor tbServiceInvestor;
    @ApiModelProperty(value = "主投领域")
    private List<TbServiceInvestorMainArea> mainAreaList;
    @ApiModelProperty(value = "主投轮次")
    private List<TbServiceInvestorMainRound> mainRoundList;
    @ApiModelProperty(value = "工作经历")
    private List<TbServiceInvestorWorkExp> workExpList;
    @ApiModelProperty(value = "教育经历")
    private List<TbServiceInvestorEduExp> eduExpList;

    public TbServiceInvestor getTbServiceInvestor() {
        return tbServiceInvestor;
    }

    public void setTbServiceInvestor(TbServiceInvestor tbServiceInvestor) {
        this.tbServiceInvestor = tbServiceInvestor;
    }

    public List<TbServiceInvestorMainArea> getMainAreaList() {
        return mainAreaList;
    }

    public void setMainAreaList(List<TbServiceInvestorMainArea> mainAreaList) {
        this.mainAreaList = mainAreaList;
    }

    public List<TbServiceInvestorMainRound> getMainRoundList() {
        return mainRoundList;
    }

    public void setMainRoundList(List<TbServiceInvestorMainRound> mainRoundList) {
        this.mainRoundList = mainRoundList;
    }

    public List<TbServiceInvestorWorkExp> getWorkExpList() {
        return workExpList;
    }

    public void setWorkExpList(List<TbServiceInvestorWorkExp> workExpList) {
        this.workExpList = workExpList;
    }

    public List<TbServiceInvestorEduExp> getEduExpList() {
        return eduExpList;
    }

    public void setEduExpList(List<TbServiceInvestorEduExp> eduExpList) {
        this.eduExpList = eduExpList;
    }
}
