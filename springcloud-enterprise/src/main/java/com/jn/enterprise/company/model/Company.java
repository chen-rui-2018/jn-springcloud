package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 公司企业
 * @author： jiangyl
 * @date： Created on 2019/3/5 19:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Company",description = "公司企业")
public class Company implements Serializable {

    @ApiModelProperty(value = "企业ID")
    private String id;

    @ApiModelProperty(value = "企业名称")
    private String comName;

    @ApiModelProperty(value = "企业logo")
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", comName='" + comName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
