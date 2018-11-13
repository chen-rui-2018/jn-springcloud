package com.jn.system.vo;

import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.SysRolePermission;
import com.jn.system.model.SysUserRole;
import com.jn.common.util.enums.EnumUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 角色vo实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
public class SysRoleVO implements Serializable{
	private static final long serialVersionUID = -3511056564542238821L;


	/**
	 * 角色id
	 */
	private String roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 创建时间
	 */

	private Date createTime;
	/**
	 * 角色状态 1：有效，0：无效，-1：删除(默认有效)
	 */
	private String status =SysStatusEnums.EFFECTIVE.getKey();

	/**
	 * 角色状态描述
	 */
	private String statusDesc;

	/**
	 * 角色权限列表
	 */
	private List<SysRolePermission> sysRolePermissions;

	/**
	 * 用户角色
	 */
	private List<SysUserRole> sysUserRoles;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public List<SysRolePermission> getSysRolePermissions() {
		return sysRolePermissions;
	}

	public void setSysRolePermissions(List<SysRolePermission> sysRolePermissions) {
		this.sysRolePermissions = sysRolePermissions;
	}

	public List<SysUserRole> getSysUserRoles() {
		return sysUserRoles;
	}

	public void setSysUserRoles(List<SysUserRole> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

	public String getStatusDesc() {
		return EnumUtil.getByKey(status,SysStatusEnums.class).getValue();
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
}
