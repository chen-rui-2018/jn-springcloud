package com.jn.system.model;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 菜单
 *
 * @author： yuanyy
 * @date： Created on 2018/11/4 20:50
 * @version： v1.0
 * @modified By:
 */

public class SysMenu implements Serializable {

    private static final long serialVersionUID = 3668352539116946388L;

    private String id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * 父级菜单ID
     */
    private String parentId;

    /**
     * 排序
     */
    private String sort;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
