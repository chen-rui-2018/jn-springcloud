package com.jn.system.dict.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 模块编辑实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 14:37
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictModuleEdit", description = "模块编辑实体")
public class SysDictModuleEdit implements Serializable {

    private static final long serialVersionUID = -5489523529541100743L;
    @ApiModelProperty(value = "模块id")
    private String id;

    @NotNull(message = "模块编码不能为空")
    @ApiModelProperty(value = "模块编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "模块编码校验错误")
    private String moduleCode;

    @NotNull(message = "模块名称不能为空")
    @ApiModelProperty(value = "模块名称", required = true)
    @Size(max = 100, message = "模块名称不能超过100字")
    private String moduleValue;

    public SysDictModuleEdit() {
    }

    public SysDictModuleEdit(String id, String moduleCode, String moduleValue) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.moduleValue = moduleValue;
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

    @Override
    public String toString() {
        return "SysDictModuleEdit{" +
                "id='" + id + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", moduleValue='" + moduleValue + '\'' +
                '}';
    }
}
