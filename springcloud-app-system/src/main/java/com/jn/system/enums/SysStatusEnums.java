package com.jn.system.enums;

import com.jn.common.enums.CodeEnum;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum SysStatusEnums implements CodeEnum {
    EFFECTIVE("1", "有效"),
    INVALID("0", "失效"),
    DELETED("-1","已删除");

    private String key;

    private String value;

    SysStatusEnums(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
