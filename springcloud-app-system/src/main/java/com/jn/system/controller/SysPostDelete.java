package com.jn.system.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author： shaobao
 * @date： Created on 2018/11/12 20:24
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostDelete",description = "岗位删除实体")
public class SysPostDelete implements Serializable {
    private static final long serialVersionUID = -1954167320374720228L;
    @ApiModelProperty("岗位id数组")
    private String[] postIds;

    public SysPostDelete() {
    }

    public SysPostDelete(String[] postIds) {
        this.postIds = postIds;
    }

    public String[] getPostIds() {
        return postIds;
    }

    public void setPostIds(String[] postIds) {
        this.postIds = postIds;
    }

    @Override
    public String toString() {
        return "SysPostDelete{" +
                "postIds=" + Arrays.toString(postIds) +
                '}';
    }
}
