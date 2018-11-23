package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 菜单添加功能
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 16:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysMenuResourcesAdd" ,description = "菜单添加功能实体")
public class SysMenuResourcesAdd implements Serializable {

    private static final long serialVersionUID = -6923429557226417911L;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id" )
    private String menuId;

    /**
     * 功能id
     */
    @ApiModelProperty(value = "功能id" )
    private String[] resourcesId;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称" )

    private String resourcesName;

    /**
     * 功能URL
     */
    @ApiModelProperty(value = "功能路径" )
    private String resourcesUrl;


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

    public SysMenuResourcesAdd() {
    }

    public SysMenuResourcesAdd(String menuId, String[] resourcesId, String resourcesName,
                               String resourcesUrl, String status, String level) {
        this.menuId = menuId;
        this.resourcesId = resourcesId;
        this.resourcesName = resourcesName;
        this.resourcesUrl = resourcesUrl;
        this.status = status;
        this.level = level;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String[] getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String[] resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public String getResourcesUrl() {
        return resourcesUrl;
    }

    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
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

    @Override
    public String toString() {
        return "SysMenuResourcesAdd{" +
                "menuId='" + menuId + '\'' +
                ", resourcesId=" + Arrays.toString(resourcesId) +
                ", resourcesName='" + resourcesName + '\'' +
                ", resourcesUrl='" + resourcesUrl + '\'' +
                ", status='" + status + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
