package com.jn.enterprise.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 用户认证状态枚举
 * @Author: huxw
 * @Date: 2019-6-20 09:12:44
 * @Version v1.0
 * @modified By:
 */
public enum UpgradeStatusEnum implements CodeAndMsg {

    UPGRADE_OK("0","允许认证"),
    UPGRADE_COMPANY("1","您的账号已认证企业"),
    UPGRADE_STAFF("2","您的账号已认证员工"),
    UPGRADE_ORG("3","您的账号已认证机构"),
    UPGRADE_INVESTOR("4","您的账号已认证投资人"),
    UPGRADE_ADVISOR("5","您的账号已认证专员"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    UpgradeStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
