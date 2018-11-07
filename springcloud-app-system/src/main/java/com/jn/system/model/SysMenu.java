package com.jn.system.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单
 *
 * @author： yuanyy
 * @date： Created on 2018/11/4 20:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysMenu" ,description = "菜单信息")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 3668352539116946388L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称" )
    @NotBlank(message = "菜单名称不能为空！")
    private String menuName;

    /**
     * 菜单URL
     */
    @ApiModelProperty(value = "菜单URL" )
    @NotBlank(message = "菜单名称不能为空！")
    private String menuUrl;

    /**
     * 父级菜单ID
     */
    @ApiModelProperty(value = "父级菜单ID" )
    @NotBlank(message = "父级菜单ID不能为空！")
    private String parentId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序" )
    private String sort;

    /**
     * 是否目录 1:目录 0:文件
     */
    @ApiModelProperty(value = "是否目录 1:目录 0:文件" )
    private String isDir;

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
    @NotBlank(message = "状态不能为空！")
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

    public String getIsDir() {
        return isDir;
    }

    public void setIsDir(String isDir) {
        this.isDir = isDir;
    }
}
