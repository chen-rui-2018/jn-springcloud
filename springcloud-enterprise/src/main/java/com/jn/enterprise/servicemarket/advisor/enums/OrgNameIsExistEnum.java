package com.jn.enterprise.servicemarket.advisor.enums;

import com.jn.common.api.CodeAndMsg;
import com.lorne.core.framework.Code;

/**
 * 机构名称是否存在枚举
 * @Author: yangph
 * @Date: 2019/6/17 15:00
 * @Version v1.0
 * @modified By:
 */
public enum  OrgNameIsExistEnum implements CodeAndMsg {
    ORG_NAME_EXIST("orgNameExist","机构名称已存在"),
    ORG_NAME_NOT_EXIST("orgNameNotExist","机构名称不存在"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    OrgNameIsExistEnum(String code, String message) {
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
