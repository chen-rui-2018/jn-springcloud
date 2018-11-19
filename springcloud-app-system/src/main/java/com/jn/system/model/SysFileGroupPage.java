package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件组分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileGroupPage" ,description = "文件组分页实体")
public class SysFileGroupPage extends Page implements Serializable {

    private static final long serialVersionUID = 1964622157773498642L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 文件组名称
     */
    @ApiModelProperty(value = "文件组名称" )
    private String fileGroupName;

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



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileGroupName() {
        return fileGroupName;
    }

    public void setFileGroupName(String fileGroupName) {
        this.fileGroupName = fileGroupName == null ? null : fileGroupName.trim();
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

}
