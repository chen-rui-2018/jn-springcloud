package com.jn.system.user.model;

import com.jn.system.dept.model.SysDepartmentPost;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * 用户添加部门岗位实体
 * @author： shaobao
 * @date： Created on 2018/11/8 1:01
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserDepartmentPostAdd",description = "用户添加部门岗位实体")
public class SysUserDepartmentPostAdd implements Serializable {
    private static final long serialVersionUID = 7361217970856264730L;
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空！")
    private String userId;
    @ApiModelProperty("部门岗位id集合")
    private List<SysDepartmentPost> sysDepartmentPostList;

    public SysUserDepartmentPostAdd() {
    }

    public SysUserDepartmentPostAdd(String userId, List<SysDepartmentPost> sysDepartmentPostList) {
        this.userId = userId;
        this.sysDepartmentPostList = sysDepartmentPostList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SysDepartmentPost> getSysDepartmentPostList() {
        return sysDepartmentPostList;
    }

    public void setSysDepartmentPostList(List<SysDepartmentPost> sysDepartmentPostList) {
        this.sysDepartmentPostList = sysDepartmentPostList;
    }

    @Override
    public String toString() {
        return "SysUserDepartmentPostAdd{" +
                "userId='" + userId + '\'' +
                ", sysDepartmentPostList=" + sysDepartmentPostList +
                '}';
    }
}
