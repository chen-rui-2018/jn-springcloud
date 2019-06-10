package com.jn.enterprise.servicemarket.org;

import com.jn.common.api.CodeAndMsg;

/**
 * 机构特性枚举
 * @Author: yangph
 * @Date: 2019/6/10 16:55
 * @Version v1.0
 * @modified By:
 */
public enum  TraitTypeEnum implements CodeAndMsg {
    BUSINESS_EXPERTISE("businessExpertise","1","业务擅长"),
    INDUSTRY_FIELDS("industryFields","2","行业领域"),
    STAGE_OF_DEVELOP("stageOfDevelop","3","发展阶段"),
    NATURE_OF_ENTERPRISE("natureOfEnterprise","4","企业性质"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 状态值
     */
    private String value;
    /**
     * 信息
     */
    private String message;


    TraitTypeEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
