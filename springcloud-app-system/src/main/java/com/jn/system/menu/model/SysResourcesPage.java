package com.jn.system.menu.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 功能分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysResourcesPage" ,description = "功能分页实体")
public class SysResourcesPage extends Page implements Serializable {


    private static final long serialVersionUID = -514084002440259994L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称" )
    private String resourcesName;

    /**
     * 功能URL
     */
    @ApiModelProperty(value = "功能路径" )
    private String resourcesUrl;


    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id" )
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
    private String status;

    public SysResourcesPage() {
    }

    public SysResourcesPage(String id, String resourcesName, String resourcesUrl,
                            String menuId, String creator, Date createTime, String status) {
        this.id = id;
        this.resourcesName = resourcesName;
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
        this.id = id == null ? null : id.trim();
    }


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        this.status = status == null ? null : status.trim();
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

    @Override
    public String toString() {
        return "SysResourcesPage{" +
                "id='" + id + '\'' +
                ", resourcesName='" + resourcesName + '\'' +
                ", resourcesUrl='" + resourcesUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}