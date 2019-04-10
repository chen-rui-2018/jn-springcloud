package com.jn.park.sp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 22:04
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SpDictDepartModel",description = "实施部门")
public class SpDictDepartModel implements Serializable {
    private static final long serialVersionUID = -7934109504049426567L;
    @ApiModelProperty(value = "主键",example = "10")
    private String id;

    @ApiModelProperty(value = "实施部门名称",example = "秦淮区教育局")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
