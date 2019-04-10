package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:35:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRecruitUnderParam", description = "上/下架招聘信息入参")
public class ServiceRecruitUnderParam implements Serializable {
    @ApiModelProperty(value = "招聘id", required = true)
    @NotNull
    private String id;
    @ApiModelProperty(value = "状态（直接传当前status状态）", required = true)
    @NotNull
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
