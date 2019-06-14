package com.jn.park.attractinvest.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 项目管理入驻状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum ProjectStatusEnums implements CodeAndMsg {
    NOT_APPLY("1", "未申请"),
    PEEDING_APPLY("2", "待申请入驻"),
    APPLYING("3", "申请中"),
    PAYING("3", "企业缴费中"),
    ENTERED("5", "入驻成功"),
    ENTER_FAIL("6", "申请失败"),
    ;

    private String code;

    private String message;

    ProjectStatusEnums(String key, String message) {
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
