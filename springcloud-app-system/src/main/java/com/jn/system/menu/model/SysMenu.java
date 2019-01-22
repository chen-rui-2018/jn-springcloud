package com.jn.system.menu.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "菜单名称校验失败")
    private String menuName;

    /**
     * 菜单URL
     */
    @ApiModelProperty(value = "菜单URL" )
    @NotBlank(message = "菜单路径不能为空！")
    @Size(max = 150,message = "菜单路径长度不能超度150字")
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
    private Integer sort;

    /**
     * 是否目录 1:目录 0:文件
     */
    @ApiModelProperty(value = "是否目录 1:目录 0:文件" )
    private String isDir;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间" )
    private Date createdTime;
    /**
     * 状态 1:有效 02:无效 0:删除
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    /**
     * 菜单层级
     */
    @ApiModelProperty(value = "菜单层级" )
    private String level;

    public SysMenu() {
    }

    public SysMenu(String id, String menuName, String menuUrl, String parentId, Integer sort, String isDir,
                   String creatorAccount, Date createdTime, Byte recordStatus, String level) {
        this.id = id;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        this.sort = sort;
        this.isDir = isDir;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.level = level;
    }

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsDir() {
        return isDir;
    }

    public void setIsDir(String isDir) {
        this.isDir = isDir;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                ", sort=" + sort +
                ", isDir='" + isDir + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", level='" + level + '\'' +
                '}';
    }
}
