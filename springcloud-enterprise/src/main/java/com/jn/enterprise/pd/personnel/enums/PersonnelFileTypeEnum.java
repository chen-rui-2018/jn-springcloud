package com.jn.enterprise.pd.personnel.enums;

/**
 * @author： huangbq
 * @date： Created on 2019/3/15 1:39
 * @version： v1.0
 * @modified By:
 */
public enum PersonnelFileTypeEnum {
    BUSINESS_LICENCE("营业执照");

    private String typeName;
    PersonnelFileTypeEnum(String typeName) {
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }}


