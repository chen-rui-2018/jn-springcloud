package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用于页面返回User数据
 * @author： shaobao
 * @date： Created on 2018/11/7 19:11
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysTUser",description = "用于页面返回User数据")
public class SysTUser implements Serializable {
    private static final long serialVersionUID = -2166141953477485674L;
    @ApiModelProperty("用户id")
    private String id;
    @ApiModelProperty("用户名称")
    private String name;

    public SysTUser() {
    }

    public SysTUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "SysTUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
