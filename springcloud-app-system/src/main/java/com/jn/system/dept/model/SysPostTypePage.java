package com.jn.system.dept.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 岗位类型条件分页实体
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 14:15
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostTypePage", description = "岗位类型条件分页实体")
public class SysPostTypePage extends Page implements Serializable {

    private static final long serialVersionUID = 2236826545957217059L;

    @ApiModelProperty("岗位类型名称")
    private String postTypeName;

    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysPostTypePage() {
    }

    public SysPostTypePage(String postTypeName, Byte recordStatus) {
        this.postTypeName = postTypeName;
        this.recordStatus = recordStatus;
    }

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysPostTypePage{" +
                "postTypeName='" + postTypeName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
