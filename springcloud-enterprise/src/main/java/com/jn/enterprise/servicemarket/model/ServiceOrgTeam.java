package com.jn.enterprise.servicemarket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 机构服务团队
 * @author： jiangyl
 * @date： Created on 2019/2/14 16:19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceOrgTeam",description = "服务机构标签")
public class ServiceOrgTeam {

    @ApiModelProperty(value = "人员ID")
    private String id;

    @ApiModelProperty(value = "机构ID")
    private String orgId;

    @ApiModelProperty(value = "人员姓名")
    private String conName;

    @ApiModelProperty(value = "职务")
    private String conPosition;

    @ApiModelProperty(value = "资质")
    private String conQuali;

    @ApiModelProperty(value = "从业起始时间")
    private String conTime;

    @ApiModelProperty(value = "业务特长")
    private String conSpeciality;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConPosition() {
        return conPosition;
    }

    public void setConPosition(String conPosition) {
        this.conPosition = conPosition;
    }

    public String getConQuali() {
        return conQuali;
    }

    public void setConQuali(String conQuali) {
        this.conQuali = conQuali;
    }

    public String getConTime() {
        return conTime;
    }

    public void setConTime(String conTime) {
        this.conTime = conTime;
    }

    public String getConSpeciality() {
        return conSpeciality;
    }

    public void setConSpeciality(String conSpeciality) {
        this.conSpeciality = conSpeciality;
    }
}
