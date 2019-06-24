package com.jn.enterprise.joinpark.org.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 机构特性类型枚举
 * @Author: yangph
 * @Date: 2019/6/22 16:40
 * @Version v1.0
 * @modified By:
 */
public enum OrgTraitTypeEnum implements CodeAndMsg {
    //特性类型(1业务擅长  2 行业领域    3 发展阶段   4 企业性质)
    BUSINESS_GOOD_AT("1","业务擅长"),
    INDUSTRY("2","行业领域"),
    DEVELOP_STAGE("3","发展阶段"),
    NATURE_OF_BUSINESS("4","企业性质"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    OrgTraitTypeEnum(String code, String message) {
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
