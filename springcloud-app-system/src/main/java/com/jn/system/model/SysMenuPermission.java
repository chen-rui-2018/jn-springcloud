package com.jn.system.model;

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
@ApiModel(value = "SysMenuPermission" ,description = "菜单权限实体")
public class SysMenuPermission implements Serializable {
    private static final long serialVersionUID = 8438573945382865137L;
    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id" )
    private String permissionId;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id" )
    private String menuId;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人" )
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty(value = "状态 1:有效 0:无效 -1:删除" )
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    /**
     * 菜单层级
     */
    @ApiModelProperty(value = "菜单层级" )
    private String level;


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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
