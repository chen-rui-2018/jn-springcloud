package com.jn.park.pmpaybill.vo;

import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 物业单价实体vo
 *
 * @author： shaobao
 * @date： Created on 2019/6/10 15:39
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "PmPriceRuleVo", description = "物业单价实体vo")
public class PmPriceRuleVo implements Serializable {
    private static final long serialVersionUID = -2975504647309104764L;
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "公司id")
    private String companyId;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "定价方式")
    private String pricingWay;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "状态（0无效，1有效）")
    private Byte recordStatus;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "最新修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "最新修改时间")
    private Date modifiedTime;
    @ApiModelProperty(value = "物业费规则明细")
    private List<TbPmPriceRuleDeatils> tbPmPriceRuleDeatilsList;

    public PmPriceRuleVo() {
    }

    public PmPriceRuleVo(String id, String companyId, String companyName, String pricingWay, String remark,
                         Byte recordStatus, String creatorAccount, Date createdTime, String modifierAccount,
                         Date modifiedTime, List<TbPmPriceRuleDeatils> tbPmPriceRuleDeatilsList) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.pricingWay = pricingWay;
        this.remark = remark;
        this.recordStatus = recordStatus;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.modifierAccount = modifierAccount;
        this.modifiedTime = modifiedTime;
        this.tbPmPriceRuleDeatilsList = tbPmPriceRuleDeatilsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPricingWay() {
        return pricingWay;
    }

    public void setPricingWay(String pricingWay) {
        this.pricingWay = pricingWay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<TbPmPriceRuleDeatils> getTbPmPriceRuleDeatilsList() {
        return tbPmPriceRuleDeatilsList;
    }

    public void setTbPmPriceRuleDeatilsList(List<TbPmPriceRuleDeatils> tbPmPriceRuleDeatilsList) {
        this.tbPmPriceRuleDeatilsList = tbPmPriceRuleDeatilsList;
    }

    @Override
    public String toString() {
        return "PmPriceRuleVo{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", pricingWay='" + pricingWay + '\'' +
                ", remark='" + remark + '\'' +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", tbPmPriceRuleDeatilsList=" + tbPmPriceRuleDeatilsList +
                '}';
    }
}
