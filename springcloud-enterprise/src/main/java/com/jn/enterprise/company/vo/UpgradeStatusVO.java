package com.jn.enterprise.company.vo;

import com.jn.enterprise.company.enums.UpgradeStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 认证状态返回
 * @author： huxw
 * @date： Created on 2019-6-19 16:41:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UpgradeStatusVO",description = "认证状态返回")
public class UpgradeStatusVO implements Serializable {

    @ApiModelProperty(value = "编码（0：允许认证 1：正在认证企业中 2：正在认证员工中 3：正在认证机构中 4：正在认证投资人中 5：正在认证专员中）")
    private String code;

    @ApiModelProperty(value = "消息")
    private String  message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UpgradeStatusVO() {

    }

    public UpgradeStatusVO(UpgradeStatusEnum upgradeStatusEnum) {
        this.code = upgradeStatusEnum.getCode();
        this.message = upgradeStatusEnum.getMessage();
    }

    @Override
    public String toString() {
        return "UpgradeStatusVO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
