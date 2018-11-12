package com.jn.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;
import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/12 16:34
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentVO" ,description = "根据层级关系获取部门信息")
public class SysDepartmentVO implements Serializable {
    private static final long serialVersionUID = 8857934360566700442L;

    @ApiModelProperty("部门id")
    private String departmentId;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("子部门的集合")
    private List<SysDepartmentVO> sysChildrenDepartmentList;

    public SysDepartmentVO() {
    }

    public SysDepartmentVO(String departmentId, String departmentName, List<SysDepartmentVO> sysChildrenDepartmentList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.sysChildrenDepartmentList = sysChildrenDepartmentList;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<SysDepartmentVO> getSysChildrenDepartmentList() {
        return sysChildrenDepartmentList;
    }

    public void setSysChildrenDepartmentList(List<SysDepartmentVO> sysChildrenDepartmentList) {
        this.sysChildrenDepartmentList = sysChildrenDepartmentList;
    }

    @Override
    public String toString() {
        return "SysDepartmentVO{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", sysChildrenDepartmentList=" + sysChildrenDepartmentList +
                '}';
    }
}
