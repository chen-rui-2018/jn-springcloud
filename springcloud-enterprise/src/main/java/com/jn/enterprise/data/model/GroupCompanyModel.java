package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 15:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupCompanyModel" ,description = "企业群组列表")
public class GroupCompanyModel implements Serializable {

    @ApiModelProperty(value = "企业名称" ,example = "XXXXX企业")
    private String companyName;

    @ApiModelProperty(value = "操作时间",example = "2018-12-21 20:20:20")
    private String createTime;

    @ApiModelProperty(value = "数据状态",example = "1")
    private String recordStatus;

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
