package com.jn.system.dict.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 数据字典分页实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 13:26
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictPage", description = "数据字典分页实体")
public class SysDictPage extends Page implements Serializable {

    private static final long serialVersionUID = -2733644141177049350L;
    @ApiModelProperty(value = "模块编码")
    private String moduleCode;
    @ApiModelProperty(value = "分组编码")
    private String groupCode;
    @ApiModelProperty(value = "数据字典键")
    private String dictKey;
    @ApiModelProperty(value = "数据字典值")
    private String dictValue;

    public SysDictPage() {
    }

    public SysDictPage(String moduleCode, String groupCode, String dictKey, String dictValue) {
        this.moduleCode = moduleCode;
        this.groupCode = groupCode;
        this.dictKey = dictKey;
        this.dictValue = dictValue;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
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

    @Override
    public String toString() {
        return "SysDictPage{" +
                "moduleCode='" + moduleCode + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", dictKey='" + dictKey + '\'' +
                ", dictValue='" + dictValue + '\'' +
                '}';
    }
}
