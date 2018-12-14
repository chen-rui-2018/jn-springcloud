package com.jn.system.file.model;

import com.jn.system.common.enums.SysStatusEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件组实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileGroup" ,description = "文件组信息")
public class SysFileGroup implements Serializable {

    private static final long serialVersionUID = 3190737665694460176L;
    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 文件组名称
     */
    @ApiModelProperty(value = "文件组名称" )
    @NotBlank(message = "文件组名称不能为空！")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "文件组名称校验失败")
    private String fileGroupName;

    /**
     * 文件组名称
     */
    @ApiModelProperty(value = "文件组描述" )
    @Size(max = 150, message = "文件组描述,字数不能超过150个字")
    private String fileGroupDescribe;

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
    @NotBlank(message = "文件组状态不能为空！")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status=SysStatusEnums.EFFECTIVE.getCode();

    public SysFileGroup() {
    }

    public SysFileGroup(String id, String fileGroupName, String fileGroupDescribe, String creator,
                        Date createTime, String status) {
        this.id = id;
        this.fileGroupName = fileGroupName;
        this.fileGroupDescribe = fileGroupDescribe;
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

    public String getFileGroupName() {
        return fileGroupName;
    }

    public void setFileGroupName(String fileGroupName) {
        this.fileGroupName = fileGroupName;
    }

    public String getFileGroupDescribe() {
        return fileGroupDescribe;
    }

    public void setFileGroupDescribe(String fileGroupDescribe) {
        this.fileGroupDescribe = fileGroupDescribe;
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
        return "SysFileGroup{" +
                "id='" + id + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                ", fileGroupDescribe='" + fileGroupDescribe + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}