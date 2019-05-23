package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
* 维保厂家model
* @author： zhuyz
* @date： Created on 2019/5/10 11:41
* @version： v1.0
* @modified By:
*/
public class AssetMaintainCompanyModel implements Serializable {
    private static final long serialVersionUID = -749580036990838845L;

    @ApiModelProperty(value = "主键",example = "575786950632407040")
    private String id;

    @ApiModelProperty(value = "厂家名称",example = "格力空调厂家")
    private String name;

    @ApiModelProperty(value = "联系人姓名",example = "黄工")
    private String contactName;

    @ApiModelProperty(value = "联系人电话",example = "18888888888")
    private String contactPhone;

    @ApiModelProperty(value = "联系人邮箱",example = "harl2513@qq.com")
    private String contactEmail;

    @ApiModelProperty(value = "厂家地址",example = "办公地址A：南京市汉中门大街145号；")
    private String address;

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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
