package com.jn.park.sp.vo;

import com.jn.park.sp.model.SpPowerBusiModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 22:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SpPowerDetailVo",description = "权力明细")
public class SpPowerDetailVo extends SpPowerVo implements Serializable {
    private static final long serialVersionUID = -4442252254493162760L;

    @ApiModelProperty(value = "权力对应的所有业务列表")
    private List<SpPowerBusiModel> busiModelList;

    @ApiModelProperty(value = "实施部门ID",example = "1")
    private String departId;

    @ApiModelProperty(value = "实施部门名称",example = "秦淮区安监局")
    private String departName;

    @ApiModelProperty("实施依据")
    private String settingBasis;

    @ApiModelProperty(value = "权力类型（1行政许可）",example = "1")
    private String type;

    @ApiModelProperty(value = "权力编码",example = "0100381002")
    private String code;

    @ApiModelProperty(value = "是否区权(1是，0否)",example = "0")
    private Integer isArea;

    @ApiModelProperty(value = "宁政发[2018]68号权限",example = "1")
    private Integer isNingzhengfa;

    @ApiModelProperty(value = "秦政发[2018]160号权限",example = "1")
    private Integer isQinzhengfa;

    @ApiModelProperty(value = "区编办拟下放权限",example = "1")
    private Integer isQubianban;

    @ApiModelProperty("备注")
    private String notes;
    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getSettingBasis() {
        return settingBasis;
    }

    public void setSettingBasis(String settingBasis) {
        this.settingBasis = settingBasis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsArea() {
        return isArea;
    }

    public void setIsArea(Integer isArea) {
        this.isArea = isArea;
    }

    public Integer getIsNingzhengfa() {
        return isNingzhengfa;
    }

    public void setIsNingzhengfa(Integer isNingzhengfa) {
        this.isNingzhengfa = isNingzhengfa;
    }

    public Integer getIsQinzhengfa() {
        return isQinzhengfa;
    }

    public void setIsQinzhengfa(Integer isQinzhengfa) {
        this.isQinzhengfa = isQinzhengfa;
    }

    public Integer getIsQubianban() {
        return isQubianban;
    }

    public void setIsQubianban(Integer isQubianban) {
        this.isQubianban = isQubianban;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<SpPowerBusiModel> getBusiModelList() {
        return busiModelList;
    }

    public void setBusiModelList(List<SpPowerBusiModel> busiModelList) {
        this.busiModelList = busiModelList;
    }
}
