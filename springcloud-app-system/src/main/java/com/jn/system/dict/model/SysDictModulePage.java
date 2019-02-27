package com.jn.system.dict.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 模块分页实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/29 9:11
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictModulePage", description = "模块分页实体")
public class SysDictModulePage extends Page implements Serializable {

    private static final long serialVersionUID = -2608615327698175796L;

    @ApiModelProperty(value = "模块编码")
    private String moduleCode;
    @ApiModelProperty(value = "模块名称")
    private String moduleValue;

    public SysDictModulePage() {
    }

    public SysDictModulePage(String moduleCode, String moduleValue) {
        this.moduleCode = moduleCode;
        this.moduleValue = moduleValue;
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

    @Override
    public String toString() {
        return "SysDictModulePage{" +
                "moduleCode='" + moduleCode + '\'' +
                ", moduleValue='" + moduleValue + '\'' +
                '}';
    }
}
