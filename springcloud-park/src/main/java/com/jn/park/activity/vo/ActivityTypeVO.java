package com.jn.park.activity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

/**
 * 活动类型信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:25
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityTypeVO", description = "活动类型")
public class ActivityTypeVO implements Serializable {
    @ApiModelProperty(value = "类型ID")
    private String typeId;
    @ApiModelProperty(value = "类型名称")
    private String typeName;
    @ApiModelProperty(value = "创建人ID")
    private String createAccount;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    @ApiModelProperty(value = "更新用户ID")
    private String updateAccount;
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;
    @ApiModelProperty(value = "状态(0：无效，1：有效，-1：删除)")
    private String status;
    @ApiModelProperty(value = "活动类型模板列表")
    private List<String> templateList;
    @ApiModelProperty(value = "拥有模板数量")
    private String  fileTotal;
    private static final long serialVersionUID = 1L;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount;
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<String> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<String> templateList) {
        this.templateList = templateList;
    }

    public String getFileTotal() {
        return fileTotal;
    }

    public void setFileTotal(String fileTotal) {
        this.fileTotal = fileTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ActivityTypeVO{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", createAccount='" + createAccount + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateAccount='" + updateAccount + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", status='" + status + '\'' +
                ", templateList=" + templateList +
                ", fileTotal='" + fileTotal + '\'' +
                '}';
    }
}