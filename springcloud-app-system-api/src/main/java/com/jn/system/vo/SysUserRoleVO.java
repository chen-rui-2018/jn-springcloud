package com.jn.system.vo;

import com.jn.system.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户修改角色信息实体
 *
 * @author： shaobao
 * @date： Created on 2019/4/11 17:06
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserRoleVO", description = "用户修改角色信息实体")
public class SysUserRoleVO implements Serializable {

    private static final long serialVersionUID = -1578058185371114077L;

    @ApiModelProperty("用户对象,传账号id都可以,都传,优先使用id操作")
    private User user;

    @ApiModelProperty("删除的角色id集合,不删除集合传空集合")
    private Set<String> deleRoleIds;

    @ApiModelProperty("新增的角色id集合,不新增集合传空集合")
    private Set<String> addRoleId;

    public SysUserRoleVO() {
    }

    public SysUserRoleVO(User user, Set<String> deleRoleIds, Set<String> addRoleId) {
        this.user = user;
        this.deleRoleIds = deleRoleIds;
        this.addRoleId = addRoleId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<String> getDeleRoleIds() {
        return deleRoleIds;
    }

    public void setDeleRoleIds(Set<String> deleRoleIds) {
        this.deleRoleIds = deleRoleIds;
    }

    public Set<String> getAddRoleId() {
        return addRoleId;
    }

    public void setAddRoleId(Set<String> addRoleId) {
        this.addRoleId = addRoleId;
    }

    @Override
    public String toString() {
        return "SysUserRoleVO{" +
                "user=" + user +
                ", deleRoleIds=" + deleRoleIds +
                ", addRoleId=" + addRoleId +
                '}';
    }
}
