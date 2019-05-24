package com.jn.park.electricmeter.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： yangh
 * @date： Created on 2019/5/17 16:08
 * @version： v1.0
 * @modified By:
 */

public enum MeterExceptionEnums implements CodeAndMsg {
    COLLECTION_DATA_DEAL_FAIL("4010201","采集数据处理失败"),
    COLLECTION_DATA_DEAL_SUCCESS("4010202","采集数据处理成功"),
    COLLECTION_DATA_ISNOT_EXIST("4010203","采集数据不存在"),
    FAIL_LOG_ISNOT_EXIST("4010204","错误日志不存在"),
    NOTICE_TIME_PARSE_DEFAULT("4010205","日期解析错误"),
    COLLECTION_DATA_ISNOT_SUCCESS("4010206","采集数据不成功"),
    PRICE_RULE_WRONG("4010207","计价规则错误"),
    PRICE_RULE_IS_NULL("4010208","计价规则是空的"),
    PRICE_RULE_ISNOT_EXIST("4010209","计价规则不存在"),
    DAY_FORMATE_WRONG("4010210","日期转换错误"),
    COMPANY_NO_CONTACT_TEL("4010211","企业没有维护联系人电话"),
    COMPANY_NOT_FOUND("4010212","未找到当前企业"),
    CANT_GET_TWO_RULE("4010213","不能重复设置计价规则"),
    CANT_REPEAT_DEAL("4010214","当日的企业计价已经正确处理了，不允许重复处理"),
    COMPANY_NO_METER("4010215","指定的企业在指定的日期上没有关联电表"),
    METER_NO_CODE("4010216","电表的code不能为空"),
    METER_INFO_EXIST("4010217","电表信息已经存在")
            ;


    private String  code;
    private String message;

    MeterExceptionEnums(String code,String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
