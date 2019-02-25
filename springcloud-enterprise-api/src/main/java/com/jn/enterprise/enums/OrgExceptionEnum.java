package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/15 11:38
 * @version： v1.0
 * @modified By:
 */
public enum OrgExceptionEnum  implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    ORG_TIME_PARSE_ERROR("5020902", "时间转换错误，请核实时间为：yyyy-MM-dd。"),
    ORG_ID_IS_NOT_NULL("5020903", "机构ID不能为空"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    OrgExceptionEnum(String code, String message) {
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
