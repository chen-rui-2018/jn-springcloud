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
@ApiModel(value = "SysResources", description = "功能信息")
public class SysResources implements Serializable {
    private static final long serialVersionUID = 3335508336524984508L;

    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称")
    @NotBlank(message = "功能名称不能为空！")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "功能名称校验失败")
    private String resourcesName;

    /**
     * 权限界面,返回功能名称是方面菜单树解析,使用lable返回功能名称
     */
    @ApiModelProperty(value = "功能名称")
    private String label;

    /**
     * 功能URL
     */
    @ApiModelProperty(value = "功能路径")
    @NotBlank(message = "功能路径不能为空！")
    @Size(max = 150, message = "页面功能路径长度不能超度150字")
    private String resourcesUrl;


    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    @NotBlank(message = "菜单id不能为空！")
    private String menuId;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysResources() {
    }

    public SysResources(String id, String resourcesName, String label, String resourcesUrl, String menuId,
                        String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.resourcesName = resourcesName;
        this.label = label;
        this.resourcesUrl = resourcesUrl;
        this.menuId = menuId;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysResources{" +
                "id='" + id + '\'' +
                ", resourcesName='" + resourcesName + '\'' +
                ", label='" + label + '\'' +
                ", resourcesUrl='" + resourcesUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
