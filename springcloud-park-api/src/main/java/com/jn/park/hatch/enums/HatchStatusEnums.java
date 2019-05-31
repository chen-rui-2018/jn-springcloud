package com.jn.park.hatch.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 孵化企业状态枚举
 *
 * @author： wzy
 * @date： Created on 2019/4/17 16:05
 * @version： v1.0
 * @modified By:
 */
public enum HatchStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "正常"),
    DELETED("0","删除"),
    HATCH_TARGET_TAX_REVENUE("1910dbddede34103b22b5d8c6c2f85cf","缴纳税收总额"),
    HATCH_TARGET_REVENUE("755314419f344430b86daa64a73b0743","营业收入"),
    HATCH_TARGET_INVESTMENT_AMOUNT("d1be27ab233b42e1a9fbe923c91dced3","固定资产投资额"),
    HATCH_GRADUATE_STATUS_1("1","可毕业"),
    HATCH_GRADUATE_STATUS_2("2","已毕业"),
    HATCH_GRADUATE_STATUS_3("3","孵化中"),
    HATCH_GRADUATE_COND_1("1","满足企业注册时间超过6年"),
    HATCH_GRADUATE_COND_2("2","满足连续两年营收额达到500万"),
    ;
    private String code;

    private String message;

    HatchStatusEnums(String code, String message) {
        this.code = code;
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

