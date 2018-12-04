package com.jn.system.dept.vo;

import com.jn.system.user.model.SysTUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 部门VO
 * @author： shaobao
 * @date： Created on 2018/11/7 19:15
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentUserVO",description = "部门VO")
public class SysDepartmentUserVO implements Serializable {

    private static final long serialVersionUID = 8857934360566700442L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private String status;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("用户集合")
    private List<SysTUser> sysTUserList;

    public SysDepartmentUserVO() {
    }

    public SysDepartmentUserVO(String id, String departmentName, Date createTime, String status,
                               String parentId, List<SysTUser> sysTUserList) {
        this.id = id;
        this.departmentName = departmentName;
        this.createTime = createTime;
        this.status = status;
        this.parentId = parentId;
        this.sysTUserList = sysTUserList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<SysTUser> getSysTUserList() {
        return sysTUserList;
    }

    public void setSysTUserList(List<SysTUser> sysTUserList) {
        this.sysTUserList = sysTUserList;
    }

    @Override
    public String toString() {
        return "SysDepartmentUserVO{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", parentId='" + parentId + '\'' +
                ", sysTUserList=" + sysTUserList +
                '}';
    }
}
