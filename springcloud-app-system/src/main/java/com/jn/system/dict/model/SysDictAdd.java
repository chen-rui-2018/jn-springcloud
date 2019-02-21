package com.jn.system.dict.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 数据字典添加实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/24 16:21
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictAdd", description = "数据字典添加实体")
public class SysDictAdd implements Serializable {
    private static final long serialVersionUID = 3013911241697543636L;

    @NotNull(message = "模块编码不能为空")
    @ApiModelProperty(value = "模块编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "模块编码校验错误")
    private String moduleCode;

    @NotNull(message = "父分组编码不能为空")
    @ApiModelProperty(value = "父分组编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "父分组编码校验错误")
    private String parentGroupCode;

    @NotNull(message = "分组编码不能为空")
    @ApiModelProperty(value = "分组编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "分组编码校验错误")
    private String groupCode;

    @NotNull(message = "数据字典键不能为空")
    @ApiModelProperty(value = "数据字典键", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "数据字典键校验错误")
    private String dictKey;

    @NotNull(message = "数据字典值不能为空")
    @ApiModelProperty(value = "数据字典值", required = true)
    @Size(max = 100, message = "数据字典值不能超过100字")
    private String dictValue;

    @ApiModelProperty(value = "描述")
    @Size(max = 100, message = "描述字符不能超过100字")
    private String dictDescribe;

    public SysDictAdd() {
    }

    public SysDictAdd(String moduleCode, String parentGroupCode, String groupCode, String dictKey,
                      String dictValue, String dictDescribe) {
        this.moduleCode = moduleCode;
        this.parentGroupCode = parentGroupCode;
        this.groupCode = groupCode;
        this.dictKey = dictKey;
        this.dictValue = dictValue;
        this.dictDescribe = dictDescribe;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getParentGroupCode() {
        return parentGroupCode;
    }

    public void setParentGroupCode(String parentGroupCode) {
        this.parentGroupCode = parentGroupCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDescribe() {
        return dictDescribe;
    }

    public void setDictDescribe(String dictDescribe) {
        this.dictDescribe = dictDescribe;
    }
}
