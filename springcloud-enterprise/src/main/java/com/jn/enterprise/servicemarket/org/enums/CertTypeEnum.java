package com.jn.enterprise.servicemarket.org.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 机构证书类型枚举
 * @Author: yangph
 * @Date: 2019/6/11 17:45
 * @Version v1.0
 * @modified By:
 */
public enum  CertTypeEnum implements CodeAndMsg {
    LICENSE("license","1","营业执照"),
    PRACTISING_QUALIFICATION("practisingQualification","2","执业资质"),
    OTHERS("others","3","其他"),
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


    CertTypeEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
