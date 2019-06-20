package com.jn.enterprise.data.enums;
/**
 * @author： yangh
 * @date： Created on 2019/4/15 11:06
 * @version： v1.0
 * @modified By:
 */
public enum TabColumnTypeEnum {

    LAST_MONTH("0","上月填报值"),
    THIS_MONTH_LAST_YEAR("1","上年同期值"),
    LAST_MONTH_LAST_YEAR("2","上月上年同期值"),
    AMPLIFICATION("3","增幅");

    private String desc;
    private String code;
    TabColumnTypeEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
