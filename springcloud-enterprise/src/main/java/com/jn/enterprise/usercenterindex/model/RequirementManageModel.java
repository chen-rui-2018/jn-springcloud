package com.jn.enterprise.usercenterindex.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/4 19:24
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequirementManageModel", description = "需求管理")
public class RequirementManageModel implements Serializable {

    @ApiModelProperty(value = "总数")
    private String total;

    @ApiModelProperty(value = "未审批")
    private String undispose;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUndispose() {
        return undispose;
    }

    public void setUndispose(String undispose) {
        this.undispose = undispose;
    }

    @Override
    public String toString() {
        return "RequirementManageModel{" +
                "total='" + total + '\'' +
                ", undispose='" + undispose + '\'' +
                '}';
    }
}
