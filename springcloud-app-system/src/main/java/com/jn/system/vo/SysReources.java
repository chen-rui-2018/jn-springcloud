package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:功能实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysReources implements Serializable {
    private static final long serialVersionUID = -7263243251545835107L;
    /**
     * id
     */
    private String id;
    /**
     * 资源名称
     */
    private String reourcesName;
    /**
     * 资源路径
     */
    private String reourcesUrl;
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1删除
     */
    private String status;

    public SysReources() {
    }

    public SysReources(String id, String reourcesName, String reourcesUrl, String menuId,
                       String creator, Date createTime, String status) {
        this.id = id;
        this.reourcesName = reourcesName;
        this.reourcesUrl = reourcesUrl;
        this.menuId = menuId;
        this.creator = creator;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysReources{" +
                "id='" + id + '\'' +
                ", reourcesName='" + reourcesName + '\'' +
                ", reourcesUrl='" + reourcesUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}