package com.jn.hardware.model.electricmeter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 17:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterSwitchParam",description = "仪表开关操作入参")
public class ElectricMeterSwitchParam implements Serializable {

    private static final long serialVersionUID = 3743900952649259405L;
    @ApiModelProperty(value = "仪表编号",required = true,example = "10086")
    @NotBlank(message = "仪表编号不能为空")
    private String code;
    @ApiModelProperty(value = "开关请求操作,4-开启,5-关闭",required = true,example = "10086")
    @Pattern(regexp = "^[4-5]$",message = "开关操作 只能为 4-开启,5-关闭")
    private String flag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ElectricMeterSwitchParam{" +
                "code='" + code + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
