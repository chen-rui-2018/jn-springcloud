package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 15:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupCompanyList" ,description = "企业群组列表")
public class GroupCompanyList implements Serializable {

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "操作时间")
    private String createTime;

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
