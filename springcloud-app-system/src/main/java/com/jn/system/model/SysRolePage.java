package com.jn.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
public class SysRolePage extends Page implements Serializable {

    private static final long serialVersionUID = -514084002440259994L;

    private String id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 角色状态 1：有效，0：无效，-1：删除
     */
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        this.status = status == null ? null : status.trim();
    }
}
