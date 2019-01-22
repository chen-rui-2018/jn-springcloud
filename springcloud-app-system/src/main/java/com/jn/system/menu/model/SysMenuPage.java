package com.jn.system.menu.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysMenuPage" ,description = "菜单分页实体")
public class SysMenuPage extends Page implements Serializable {


    private static final long serialVersionUID = -514084002440259994L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称" )
    private String menuName;

    /**
     * 菜单URL
     */
    @ApiModelProperty(value = "菜单URL" )
    private String menuUrl;

    /**
     * 父级菜单ID
     */
    @ApiModelProperty(value = "父级菜单ID" )
    private String parentId;

    /**
     * 是否目录 1:目录 0:文件
     */
    @ApiModelProperty(value = "是否目录 1:目录 0:文件" )
    private String isDir;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序" )
    private Integer sort;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人" )
    private String creatorAccount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间" )
    private Date createdTime;
    /**
     * 状态 1:有效 2:无效 0:删除
     */
    @ApiModelProperty(value = "状态 1:有效 2:无效 0:删除" )
    private Byte recordStatus;

    /**
     * 菜单层级
     */
    @ApiModelProperty(value = "菜单层级" )
    private String level;

    public SysMenuPage() {
    }

    public SysMenuPage(String id, String menuName, String menuUrl, String parentId, String isDir,
                       Integer sort, String creatorAccount, Date createdTime, Byte recordStatus, String level) {
        this.id = id;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        this.isDir = isDir;
        this.sort = sort;
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

    public String getIsDir() {
        return isDir;
    }

    public void setIsDir(String isDir) {
        this.isDir = isDir;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        return "SysMenuPage{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                ", isDir='" + isDir + '\'' +
                ", sort=" + sort +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", level='" + level + '\'' +
                '}';
    }
}
