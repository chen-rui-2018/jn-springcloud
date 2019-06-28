package com.jn.oa.message.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 手机验证码实体
 *
 * @author： yuanyy
 * @date： Created on 2019/6/27 14:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MessageCode", description = "手机验证码实体")
public class MessageCode implements Serializable {
    private static final long serialVersionUID = -5671809054725364213L;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "手机号不能为空")
    private String[] phones;

    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "验证码不能为空")
    private String messageCode;

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
