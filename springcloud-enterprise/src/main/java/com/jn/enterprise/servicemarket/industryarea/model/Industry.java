package com.jn.enterprise.servicemarket.industryarea.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/27 11:45
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Industry",description = "业务领域")
public class Industry {

    @ApiModelProperty(value = "领域ID")
    private String id;
    @ApiModelProperty(value = "领域值")
    private String preValue;
    @ApiModelProperty(value = "领域类型",notes = "0业务领域1行业领域2发展阶段3企业性质")
    private String preType;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    private String createdTime;
    @ApiModelProperty(value = "服务机构数量")
    private String orgNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public String getPreType() {
        return preType;
    }

    public void setPreType(String preType) {
        this.preType = preType;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }
}
