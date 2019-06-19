package com.jn.enterprise.pd.declaration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * 在线预约bean
 *
 * @author： wzy
 * @date： Created on 2019/4/17 15:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DeclarationOnlineReservationManageModel", description = "在线预约实体类")
public class DeclarationOnlineReservationManageModel extends Page implements Serializable {
    private static final long serialVersionUID = -8834962157864530660L;

    @ApiModelProperty(value = "唯一标识符")
    private String id;

    @ApiModelProperty(value = "预约项ID（关联公告ID）" ,required = true,example = "关联的公告ID，自动回显填充")
    private String appointmentItemId;

    @ApiModelProperty(value = "预约项名称",required = true,example = "关联的公告标题名称，自动回显填充")
    private String appointmentItemName;

    @ApiModelProperty(value = "企业联系人",required = true,example = "测试")
    private String contactName;

    @ApiModelProperty(value = "联系电话",required = true,example = "13212344321")
    private String contactPhone;

    @ApiModelProperty(value = "电子邮箱",required = true,example = "123@qq.com")
    private String email;

    @ApiModelProperty(value = "附件，需有附件说明")
    private String fileUrl;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "申报企业", required = true, example = "敏捷科技公司")
    private String declareEnterprise;

    @ApiModelProperty(value = "申报项目", required = true, example = "高企意向申报")
    private String declareItem;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppointmentItemId() {
        return appointmentItemId;
    }

    public void setAppointmentItemId(String appointmentItemId) {
        this.appointmentItemId = appointmentItemId;
    }

    public String getAppointmentItemName() {
        return appointmentItemName;
    }

    public void setAppointmentItemName(String appointmentItemName) {
        this.appointmentItemName = appointmentItemName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeclareEnterprise() {
        return declareEnterprise;
    }

    public void setDeclareEnterprise(String declareEnterprise) {
        this.declareEnterprise = declareEnterprise;
    }

    public String getDeclareItem() {
        return declareItem;
    }

    public void setDeclareItem(String declareItem) {
        this.declareItem = declareItem;
    }
}
