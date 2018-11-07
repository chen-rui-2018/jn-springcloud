package com.jn.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.util.enums.EnumUtil;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.SysMenu;

import java.io.Serializable;
import java.util.Date;


/**
 * 功能菜单
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 16:51
 * @version： v1.0
 * @modified By:
 */
public class SysResourcesVO implements Serializable {
    private static final long serialVersionUID = -4766803278902458039L;
    private String resourcesId;

    /**
     * 功能名称
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
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;

    /**
     * 状态描述
     */
    private String statusDesc;

    /**
     * 菜单
     */
    private SysMenu sysMenu;

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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

    public String getStatusDesc() {
        return EnumUtil.getByKey(status,SysStatusEnums.class).getValue();
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }
}
