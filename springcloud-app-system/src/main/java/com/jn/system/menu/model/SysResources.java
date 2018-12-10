package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 功能表
 *
 * @author： yuanyy
 * @date： Created on 2018/11/4 21:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysResources" ,description = "功能信息")
public class SysResources implements Serializable {
    private static final long serialVersionUID = 3335508336524984508L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称" )
    @NotBlank(message = "功能名称不能为空！")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "功能名称校验失败")
    private String resourcesName;

    /**
     * 权限界面,返回功能名称是方面菜单树解析,使用lable返回功能名称
     */
    @ApiModelProperty(value = "功能名称" )
    private String label;

    /**
     * 功能URL
     */
    @ApiModelProperty(value = "功能路径" )
    @NotBlank(message = "功能路径不能为空！")
    @Size(max = 50,message = "页面功能路径长度不能超度50字")
    private String resourcesUrl;


    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id" )
    @NotBlank(message = "菜单id不能为空！")
    private String menuId;

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

    public SysResources() {
    }

    public SysResources(String id, String resourcesName, String label, String resourcesUrl,
                        String menuId, String creator, Date createTime, String status) {
        this.id = id;
        this.resourcesName = resourcesName;
        this.label = label;
        this.resourcesUrl = resourcesUrl;
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

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    @Override
    public String toString() {
        return "SysResources{" +
                "id='" + id + '\'' +
                ", resourcesName='" + resourcesName + '\'' +
                ", label='" + label + '\'' +
                ", resourcesUrl='" + resourcesUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
