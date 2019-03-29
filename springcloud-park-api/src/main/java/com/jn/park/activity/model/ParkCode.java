package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 园区字典
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 10:52
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkCode", description = "园区字典")
public class ParkCode extends Page implements Serializable {
    @ApiModelProperty(value = "字典id")
    private String id;
    @ApiModelProperty(value = "字典类型编号",notes = "parkName:园区名称")
    private String groupId;
    @ApiModelProperty(value = "字典类型名称",notes = "parkName:园区名称")
    private String groupName;
    @ApiModelProperty(value = "字典值",notes = "前台取该值传给对应的业务")
    private String codeValue;
    @ApiModelProperty(value = "点评值名称",notes = "前台取该值展示")
    private String codeName;
    @ApiModelProperty(value = "创建人")
    private String createAccount;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改人")
    private String updateAccount;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
