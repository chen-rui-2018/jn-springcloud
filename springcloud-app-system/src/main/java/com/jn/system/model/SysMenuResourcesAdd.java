package com.jn.system.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 菜单添加功能
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 16:51
 * @version： v1.0
 * @modified By:
 */
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

    private String status;

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
}
