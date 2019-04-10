package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:35:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRecruitPublishParam", description = "发布企业招聘入参")
public class ServiceRecruitPublishParam implements Serializable {
    @ApiModelProperty(value = "编号", example = "GDNJ-20180707001")
    private String recruitNo;
    @ApiModelProperty(value = "招聘岗位", required = true, example = "java程序员")
    private String post;
    @ApiModelProperty(value = "薪资待遇编码（请调用[企业服务-公共：码表-数据列表]获取数据，传值为groupId=recruitSalary）", required = true, example = "face_face")
    private String salary;
    @ApiModelProperty(value = "招聘人数", required = true, example = "5")
    private Integer num;
    @ApiModelProperty(value = "招聘类型编码（请调用[企业服务-公共：码表-数据列表]获取数据，传值为groupId=recruitType）", required = true, example = "full_time")
    private String type;
    @ApiModelProperty(value = "招聘详情", required = true, example = "1.精通spring")
    private String details;

    public String getRecruitNo() {
        return recruitNo;
    }

    public void setRecruitNo(String recruitNo) {
        this.recruitNo = recruitNo;
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
