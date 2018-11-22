package com.jn.system.menu.vo;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


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
    private List<String> menuName;

    public SysResourcesVO() {
    }

    public SysResourcesVO(String resourcesId, String resourcesName, String resourcesUrl, String menuId,
                          String creator, Date createTime, String status, String statusDesc, List<String> menuName) {
        this.resourcesId = resourcesId;
        this.resourcesName = resourcesName;
        this.resourcesUrl = resourcesUrl;
        this.menuId = menuId;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
        this.statusDesc = statusDesc;
        this.menuName = menuName;
    }

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
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public List<String> getMenuName() {
        return menuName;
    }

    public void setMenuName(List<String> menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "SysResourcesVO{" +
                "resourcesId='" + resourcesId + '\'' +
                ", resourcesName='" + resourcesName + '\'' +
                ", resourcesUrl='" + resourcesUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", menuName=" + menuName +
                '}';
    }
}
