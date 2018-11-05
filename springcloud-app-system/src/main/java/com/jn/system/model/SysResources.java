package com.jn.system.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 功能表
 *
 * @author： yuanyy
 * @date： Created on 2018/11/4 21:16
 * @version： v1.0
 * @modified By:
 */
public class SysResources implements Serializable {
    private static final long serialVersionUID = 3335508336524984508L;

    private String id;

    /**
     * 资源名称
     */
    private String resourcesName;

    /**
     * 资源URL
     */
    private String resourcesUrl;


    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
