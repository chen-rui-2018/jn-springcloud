package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单权限
 *
 * @author： yuanyy
 * @date： Created on 2018/11/4 21:05
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysMenuPermission", description = "菜单权限实体")
public class SysMenuPermission implements Serializable {
    private static final long serialVersionUID = 8438573945382865137L;
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private String permissionId;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private String menuId;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    /**
     * 菜单层级
     */
    @ApiModelProperty(value = "菜单层级")
    private String level;

    public SysMenuPermission() {
    }

    public SysMenuPermission(String id, String permissionId, String menuId, String creatorAccount,
                             Date createdTime, Byte recordStatus, String level) {
        this.id = id;
        this.permissionId = permissionId;
        this.menuId = menuId;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SysMenuPermission{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", level='" + level + '\'' +
                '}';
    }
}
