package com.jn.system.vo;

import java.util.Date;

/**
 * 功能表
 */
public class TbSysReources {
    private String id;

    private String reourcesName; //资源名称

    private String reourcesUrl; // 资源路径

    private String menuId; //菜单id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysReources() {
    }

    public TbSysReources(String id, String reourcesName, String reourcesUrl,
                         String menuId, Date createTime, String status) {
        this.id = id;
        this.reourcesName = reourcesName;
        this.reourcesUrl = reourcesUrl;
        this.menuId = menuId;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReourcesName() {
        return reourcesName;
    }

    public void setReourcesName(String reourcesName) {
        this.reourcesName = reourcesName;
    }

    public String getReourcesUrl() {
        return reourcesUrl;
    }

    public void setReourcesUrl(String reourcesUrl) {
        this.reourcesUrl = reourcesUrl;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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
        return "TbSysReources{" +
                "id='" + id + '\'' +
                ", reourcesName='" + reourcesName + '\'' +
                ", reourcesUrl='" + reourcesUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}