package com.jn.enterprise.joinpark.usermanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 升级企业入参Bean
 * @author： jiangyl
 * @date： Created on 2019/3/5 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "StaffCheckParam",description = "升级员工入参")
public class StaffCheckParam implements Serializable {
    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID",required = true,example = "8afabb60045d40e485e1d4ac04666e8a")
    private String comId;
    @NotNull(message = "企业名称不能为空")
    @ApiModelProperty(value = "企业名称",required = true,example = "左元有限公司")
    private String comName;
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码",required = true,example = "1234")
    private String checkCode;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
