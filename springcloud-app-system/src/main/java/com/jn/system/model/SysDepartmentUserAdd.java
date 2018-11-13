package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * 部门增加用户
 *
 * @author： shaobao
 * @date： Created on 2018/11/7 20:43
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentUserAdd", description = "部门添加用户")
public class SysDepartmentUserAdd implements Serializable {

    private static final long serialVersionUID = 1823985722724564067L;
    @NotBlank(message = "部门id不能为空")
    @ApiModelProperty("部门id ")
    private String departmentId;

    @ApiModelProperty("用户id数组 ")
    private List<SysUserPostAdd> userPostAddList;

    public SysDepartmentUserAdd() {
    }

    public SysDepartmentUserAdd(String departmentId, List<SysUserPostAdd> userPostAddList) {
        this.departmentId = departmentId;
        this.userPostAddList = userPostAddList;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<SysUserPostAdd> getUserPostAddList() {
        return userPostAddList;
    }

    public void setUserPostAddList(List<SysUserPostAdd> userPostAddList) {
        this.userPostAddList = userPostAddList;
    }

    @Override
    public String toString() {
        return "SysDepartmentUserAdd{" +
                "departmentId='" + departmentId + '\'' +
                ", userPostAddList=" + userPostAddList +
                '}';
    }
}
