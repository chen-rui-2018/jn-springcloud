package com.jn.park.gamtopic.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/16 14:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CareDetailsQueryParam",description = "关注详情入参")
public class CareDetailsQueryParam extends Page implements Serializable {
    @ApiModelProperty(value="目标账号",required = true,example = "wangsong")
    @NotBlank(message = "目标账号不能为空")
    private String paramAccount;

    public String getParamAccount() {
        return paramAccount;
    }

    public void setParamAccount(String paramAccount) {
        this.paramAccount = paramAccount;
    }
}
