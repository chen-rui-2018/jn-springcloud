package com.jn.system.model;

import java.io.Serializable;

/**
 * 菜单、功能
 *
 * @author： shenph
 * @date： Created on 2018/11/08 15:31
 * @version： v1.0
 * @modified By:
 */
public class MenuResources implements Serializable {
    private static final long serialVersionUID = 4125580367922291000L;
    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 菜单URL
     */
    private String menuUrl;
    /**
     * 功能ID
     */
    private String resourcesId;
    /**
     * 功能URL
     */
    private String resourcesUrl;

    public MenuResources(String menuId, String menuUrl, String resourcesId, String resourcesUrl) {
        this.menuId = menuId;
        this.menuUrl = menuUrl;
        this.resourcesId = resourcesId;
        this.resourcesUrl = resourcesUrl;
    }
    public MenuResources() {
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getResourcesUrl() {
        return resourcesUrl;
    }

    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
    }

    @Override
    public String toString() {
        return "MenuResources{" +
                "menuId='" + menuId + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", resourcesId='" + resourcesId + '\'' +
                ", resourcesUrl='" + resourcesUrl + '\'' +
                '}';
    }
}