package com.jn.system.dict.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 模块实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 15:18
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictModuleMapper", description = "模块实体")
public class SysDictModule implements Serializable {

    @ApiModelProperty(value = "模块id")
    private String id;
    @ApiModelProperty(value = "模块编码")
    private String moduleCode;
    @ApiModelProperty(value = "模块名称")
    private String moduleValue;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    public SysDictModule() {
    }

    public SysDictModule(String id, String moduleCode, String moduleValue, Date createdTime) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.moduleValue = moduleValue;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "SysDictModuleMapper{" +
                "id='" + id + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", moduleValue='" + moduleValue + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
