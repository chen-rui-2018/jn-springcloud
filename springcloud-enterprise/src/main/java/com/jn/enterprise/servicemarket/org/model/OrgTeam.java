package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 机构服务团队
 * @author： jiangyl
 * @date： Created on 2019/2/14 16:19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgTeam",description = "机构服务团队")
public class OrgTeam implements Serializable {
    @ApiModelProperty(value = "机构ID[APP入参前端不需要传ID]")
    private String orgId;

    @ApiModelProperty(value = "人员姓名",required = true,example = "张三")
    @NotNull(message = "人员姓名不能为空")
    private String conName;

    @ApiModelProperty(value = "职务",example = "项目经理")
    private String conPosition;

    @ApiModelProperty(value = "资质",example = "一级项目管理证书")
    private String conQuali;

    @ApiModelProperty(value = "从业起始时间yyyy-MM-dd",example = "2017-01-01")
    private String conTime;

    @ApiModelProperty(value = "业务特长",example = "项目成本管理")
    private String conSpeciality;

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
