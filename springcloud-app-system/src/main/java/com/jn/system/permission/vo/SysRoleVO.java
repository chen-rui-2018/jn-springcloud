package com.jn.system.permission.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(value = "SysRoleVO",description = "角色vo实体")
public class SysRoleVO implements Serializable{
	private static final long serialVersionUID = -3511056564542238821L;


	@ApiModelProperty("角色id")
	private String roleId;

	@ApiModelProperty("角色名称")
	private String roleName;

	@ApiModelProperty("创建时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty("状态")
	private Byte recordStatus;

	@ApiModelProperty("角色状态描述")
	private String statusDesc;

	@ApiModelProperty("角色权限名称列表")
	private List<String> sysRolePermissions;

	@ApiModelProperty("角色用户名称列表")
	private List<String> sysUserRoles;

	public SysRoleVO() {
	}

	public SysRoleVO(String roleId, String roleName, Date createdTime, Byte recordStatus, String statusDesc,
					 List<String> sysRolePermissions, List<String> sysUserRoles) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.createdTime = createdTime;
		this.recordStatus = recordStatus;
		this.statusDesc = statusDesc;
		this.sysRolePermissions = sysRolePermissions;
		this.sysUserRoles = sysUserRoles;
	}

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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Byte getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public List<String> getSysRolePermissions() {
		return sysRolePermissions;
	}

	public void setSysRolePermissions(List<String> sysRolePermissions) {
		this.sysRolePermissions = sysRolePermissions;
	}

	public List<String> getSysUserRoles() {
		return sysUserRoles;
	}

	public void setSysUserRoles(List<String> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

	@Override
	public String toString() {
		return "SysRoleVO{" +
				"roleId='" + roleId + '\'' +
				", roleName='" + roleName + '\'' +
				", createdTime=" + createdTime +
				", recordStatus=" + recordStatus +
				", statusDesc='" + statusDesc + '\'' +
				", sysRolePermissions=" + sysRolePermissions +
				", sysUserRoles=" + sysUserRoles +
				'}';
	}
}
