package com.jn.enterprise.recruit.model;

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
@ApiModel(value = "ServiceRecruitEditParam", description = "编辑企业招聘入参")
public class ServiceRecruitEditParam implements Serializable {
    @ApiModelProperty(value = "招聘id", required = true)
    @NotNull
    private String id;
    @ApiModelProperty(value = "招聘岗位", example = "java程序员")
    private String post;
    @ApiModelProperty(value = "薪资待遇编码（码表）", example = "face_face")
    private String salary;
    @ApiModelProperty(value = "招聘人数", example = "5")
    private Integer num;
    @ApiModelProperty(value = "招聘类型编码（码表）", example = "full_time")
    private String type;
    @ApiModelProperty(value = "招聘详情", example = "1.精通spring")
    private String details;
    @ApiModelProperty(value = "状态（1：已上架 0：已下架）", example = "1")
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
