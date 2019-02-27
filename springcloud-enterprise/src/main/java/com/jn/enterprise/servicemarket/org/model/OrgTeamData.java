package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 机构团队信息
 * @author： jiangyl
 * @date： Created on 2019/2/18 15:11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgTeamData",description = "机构团队信息")
public class OrgTeamData {
    @ApiModelProperty(value = "人员结构ID")
    private String id;

    @ApiModelProperty(value = "机构ID")
    private String orgId;

    @ApiModelProperty(value = "员工总人数")
    @NotNull(message = "员工总人数不能为空")
    private Integer staffCount;

    @ApiModelProperty(value = "执业人员人数")
    private Integer professionNum;

    @ApiModelProperty(value = "本科学历人数")
    private Integer bachelorNum;

    @ApiModelProperty(value = "硕士学历人数")
    private Integer masterNum;

    @ApiModelProperty(value = "博士学历人数")
    private Integer doctorNum;

    @ApiModelProperty(value = "海归员工人数")
    private Integer returneeNum;

    @ApiModelProperty(value = "团队人员列表")
    private List<OrgTeam> orgTeams;

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

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getProfessionNum() {
        return professionNum;
    }

    public void setProfessionNum(Integer professionNum) {
        this.professionNum = professionNum;
    }

    public Integer getBachelorNum() {
        return bachelorNum;
    }

    public void setBachelorNum(Integer bachelorNum) {
        this.bachelorNum = bachelorNum;
    }

    public Integer getMasterNum() {
        return masterNum;
    }

    public void setMasterNum(Integer masterNum) {
        this.masterNum = masterNum;
    }

    public Integer getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(Integer doctorNum) {
        this.doctorNum = doctorNum;
    }

    public Integer getReturneeNum() {
        return returneeNum;
    }

    public void setReturneeNum(Integer returneeNum) {
        this.returneeNum = returneeNum;
    }

    public List<OrgTeam> getOrgTeams() {
        return orgTeams;
    }

    public void setOrgTeams(List<OrgTeam> orgTeams) {
        this.orgTeams = orgTeams;
    }
}
