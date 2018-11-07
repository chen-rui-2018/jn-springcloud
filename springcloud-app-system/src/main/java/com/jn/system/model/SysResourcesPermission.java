package com.jn.system.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限资源
 *
 * @author： yuanyy
 * @date： Created on 2018/11/4 21:28
 * @version： v1.0
 * @modified By:
 */
public class SysResourcesPermission implements Serializable {
    private static final long serialVersionUID = -1818556420963076451L;

    private String id;

    /**
     * 权限id
     */
    private String permissionId;

    /**
     * 资源id
     */
    private String resourcesId;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
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
