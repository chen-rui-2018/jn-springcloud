package com.jn.system.dict.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 数据字典修改实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/24 16:21
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictEdit", description = "数据字典修改实体")
public class SysDictEdit implements Serializable {

    private static final long serialVersionUID = 2751124977437051921L;
    @NotNull(message = "数据字典id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "模块编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "模块编码校验错误")
    private String moduleCode;

    @ApiModelProperty(value = "父分组编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "父分组编码校验错误")
    private String parentGroupCode;

    @ApiModelProperty(value = "分组编码", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "分组编码校验错误")
    private String groupCode;

    @ApiModelProperty(value = "数据字典键", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9][-_a-zA-Z0-9]{0,99}$", message = "数据字典键校验错误")
    private String dictKey;

    @ApiModelProperty(value = "数据字典值", required = true)
    @Size(max = 100, message = "数据字典值不能超过100字")
    private String dictValue;

    @ApiModelProperty(value = "描述")
    @Size(max = 100, message = "描述字符不能超过100字")
    private String dictDescribe;

    @ApiModelProperty(value = "排序")
    private Integer sort;


    public SysDictEdit() {
    }

    public SysDictEdit(String id, String moduleCode, String parentGroupCode, String groupCode, String dictKey,
                       String dictValue, String dictDescribe, Integer sort) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.parentGroupCode = parentGroupCode;
        this.groupCode = groupCode;
        this.dictKey = dictKey;
        this.dictValue = dictValue;
        this.dictDescribe = dictDescribe;
        this.sort = sort;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
