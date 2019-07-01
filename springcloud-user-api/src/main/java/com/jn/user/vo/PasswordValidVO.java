package com.jn.user.vo;

import java.io.Serializable;

/**
 * 密码校验返回
 * @author： huxw
 * @date： Created on 2019-7-1 14:18:30
 * @version： v1.0
 * @modified By:
 */
public class PasswordValidVO implements Serializable {

    private boolean isValid;
    private String message;

    public PasswordValidVO() {
        this.isValid = false;
        this.message = "密码规则获取失败";
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PasswordRuleVO{" +
                "isValid=" + isValid +
                ", message='" + message + '\'' +
                '}';
    }
}
