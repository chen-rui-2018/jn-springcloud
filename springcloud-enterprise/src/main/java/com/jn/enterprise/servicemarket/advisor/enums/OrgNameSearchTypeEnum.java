package com.jn.enterprise.servicemarket.advisor.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 机构名称查询类型枚举
 * @Author: yangph
 * @Date: 2019/6/17 15:32
 * @Version v1.0
 * @modified By:
 */
public enum OrgNameSearchTypeEnum implements CodeAndMsg {
    SEARCH_type_ADD("add","机构认证（新增页面传值）"),
    SEARCH_TYPE_UPDATE("update","机构认证（修改页面传值）"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    OrgNameSearchTypeEnum(String code, String message) {
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
