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
@ApiModel(value = "ServiceRecruitEditParam", description = "编辑企业招聘入参")
public class ServiceRecruitEditParam implements Serializable {
    @ApiModelProperty(value = "招聘id", required = true)
    @NotNull(message = "招聘ID不能为空")
    private String id;
    @ApiModelProperty(value = "招聘岗位", example = "java程序员")
    private String post;
    @ApiModelProperty(value = "薪资待遇编码（请调用[企业服务-公共：码表-数据列表]获取数据，传值为groupId=recruitSalary）", example = "face_face")
    private String salary;
    @ApiModelProperty(value = "招聘人数", example = "5")
    private Integer num;
    @ApiModelProperty(value = "招聘类型编码（请调用[企业服务-公共：码表-数据列表]获取数据，传值为groupId=recruitType）", example = "full_time")
    private String type;
    @ApiModelProperty(value = "招聘详情", example = "1.精通spring")
    private String details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ServiceRecruitEditParam{" +
                "id='" + id + '\'' +
                ", post='" + post + '\'' +
                ", salary='" + salary + '\'' +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
