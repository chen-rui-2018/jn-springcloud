package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 升级企业审核回调入参
 * @author： jiangyl
 * @date： Created on 2019/3/5 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyCheckCallBackParam",description = "升级企业审核回调入参")
public class CompanyCheckCallBackParam implements Serializable {
    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID",required = true,example = "8afabb60045d40e485e1d4ac04666e8a")
    private String id;
    @ApiModelProperty(value = "企业名称",example = "***公司")
    private String comName;
    @NotNull(message = "审核人不能为空")
    @ApiModelProperty(value = "审核人",required = true,example = "zhangsan")
    private String checkAccount;
    @NotNull(message = "审核状态不能为空")
    @ApiModelProperty(value = "审核状态[1:通过 0:审核中 -1:不通过]",required = true,example = "1")
    private String status;

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

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CompanyCheckCallBackParam{" +
                "id='" + id + '\'' +
                ", comName='" + comName + '\'' +
                ", checkAccount='" + checkAccount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
