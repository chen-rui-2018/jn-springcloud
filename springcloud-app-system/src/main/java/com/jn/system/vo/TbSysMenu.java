package com.jn.system.vo;

import java.util.Date;

/**
 * 菜单表
 */
public class TbSysMenu {
    private String id; //菜单id

    private String menuName; //菜单名称

    private String menuUrl; //菜单路径

    private String parentId; //夫级菜单id

    private Date createTime; // 创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysMenu() {
    }

    public TbSysMenu(String id, String menuName, String menuUrl, String parentId, Date createTime, String status) {
        this.id = id;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    @Override
    public String toString() {
        return "TbSysMenu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}