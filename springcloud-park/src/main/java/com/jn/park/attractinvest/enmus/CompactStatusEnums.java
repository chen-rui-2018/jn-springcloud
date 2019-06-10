package com.jn.park.attractinvest.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 项目管理拟制合同状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum CompactStatusEnums implements CodeAndMsg {
    NORMAL("1", "正常"),
    UNNOMAL("0", "超过3天不正常状态"),
    ABNORMALITY("2", "超过5天不正常状态"),
    ;

    private String code;

    private String message;

    CompactStatusEnums(String key, String message) {
        this.code = key;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }

}
