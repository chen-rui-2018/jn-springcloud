package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/9 17:36
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorInfoListShow", description = "科技金融投资人列表展示出参")
public class InvestorInfoListShow implements Serializable {
    @ApiModelProperty(value = "投资人账号")
    private String investorAccount;
    @ApiModelProperty(value = "投资人姓名")
    private String investorName;
    @ApiModelProperty(value = "投资人头像")
    private String avatar;
    @ApiModelProperty(value = "所属单位")
    private String orgName;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "主投领域")
    private String mainAreaList;

    public String getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount) {
        this.investorAccount = investorAccount;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMainAreaList() {
        return mainAreaList;
    }

    public void setMainAreaList(String mainAreaList) {
        this.mainAreaList = mainAreaList;
    }

    @Override
    public String toString() {
        return "InvestorInfoListShow{" +
                "investorAccount='" + investorAccount + '\'' +
                ", investorName='" + investorName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", orgName='" + orgName + '\'' +
                ", position='" + position + '\'' +
                ", mainAreaList='" + mainAreaList + '\'' +
                '}';
    }
}
