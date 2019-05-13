package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/9 9:28
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorMainRoundWorkFlow", description = "科技金融投资人主投轮次工作流传参")
public class InvestorMainRoundWorkFlow implements Serializable {
    @ApiModelProperty(value = "投资人账号")
    private String investorAccount;
    @ApiModelProperty(value = "主投轮次编码")
    private String mainRoundCode;
    @ApiModelProperty(value = "主投轮次名称")
    private String mainRoundName;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private String modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "是否删除 0：已删除   1：有效")
    private Byte recordStatus;

    public String getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount) {
        this.investorAccount = investorAccount;
    }

    public String getMainRoundCode() {
        return mainRoundCode;
    }

    public void setMainRoundCode(String mainRoundCode) {
        this.mainRoundCode = mainRoundCode;
    }

    public String getMainRoundName() {
        return mainRoundName;
    }

    public void setMainRoundName(String mainRoundName) {
        this.mainRoundName = mainRoundName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
}
