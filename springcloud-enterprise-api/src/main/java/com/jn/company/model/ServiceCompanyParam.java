package com.jn.company.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:56
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceCompanyParam", description = "企业查询入参")
public class ServiceCompanyParam extends Page implements Serializable {
    @ApiModelProperty(value = "企业名称[模糊搜索]",example = "君南")
    private String comName;
    @ApiModelProperty(value = "楼宇ID[模糊搜索]",example = "e23i****22j")
    private String parkBuildId;
    @ApiModelProperty(value = "楼宇名称[模糊搜索]",example = "楼宇1")
    private String parkBuildName;
    @ApiModelProperty(value = "是否参加园区活动[0否1是]",example = "0")
    private String isJoinActivity;
    @ApiModelProperty(value = "企业来源[1人才企业2招商企业]]",example = "1")
    private String comSource;
    @ApiModelProperty(value = "审核状态 1:通过 0:审核中 -1:不通过",example = "0")
    private String checkStatus;
    @ApiModelProperty(value = "所属园区(传园区的id)",example = "12486")
    private String affiliatedPark;
    @ApiModelProperty(value = "企业管理员账号Account",example = "wangsong")
    private String comAdmin;
    @ApiModelProperty(value = "企业类型 企业字典表type=1的，即企业类型。数据从【服务超市-机构字典】接口获取(id)",notes = "",example = "guoyouqiye")
    private String comType;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getParkBuildId() {
        return parkBuildId;
    }

    public void setParkBuildId(String parkBuildId) {
        this.parkBuildId = parkBuildId;
    }

    public String getParkBuildName() {
        return parkBuildName;
    }

    public void setParkBuildName(String parkBuildName) {
        this.parkBuildName = parkBuildName;
    }

    public String getIsJoinActivity() {
        return isJoinActivity;
    }

    public void setIsJoinActivity(String isJoinActivity) {
        this.isJoinActivity = isJoinActivity;
    }

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark;
    }
}
