package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
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
@ApiModel(value = "SysResourcesPermission" ,description = "功能分页实体")
public class SysResourcesPermission implements Serializable {
    private static final long serialVersionUID = -1818556420963076451L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id" )
    private String permissionId;

    /**
     * 资源id
     */
    @ApiModelProperty(value = "资源id" )
    private String resourcesId;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人" )
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty(value = "状态 1:有效 0:无效 -1:删除" )
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysResourcesPermission() {
    }

    public SysResourcesPermission(String id, String permissionId, String resourcesId,
                                  String creator, Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.resourcesId = resourcesId;
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

    @Override
    public String toString() {
        return "SysResourcesPermission{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", resourcesId='" + resourcesId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}