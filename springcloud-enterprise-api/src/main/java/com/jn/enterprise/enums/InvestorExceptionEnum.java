package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 投资人异常枚举
 * @Author: yangph
 * @Date: 2019/02/14 10:02
 * @Version v1.0
 * @modified By:
 */
public enum InvestorExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    INVESTOR_ACCOUNT_NOT_NULL("5020521","投资人账号不能为空"),
    INVESTOR_INFO_NOT_EXIST("5020522","当前投资人信息不存在"),
    AFFILIATION_NAME("5020523","所属单位名称不能为空"),
    INVESTOR_INFO_NOT_NULL("5020524","投资人认证信息不能为空"),
    INVESTOR_MAIN_AREA_NOT_NULL("5020525","投资人主投领域不能为空"),
    INVESTOR_MAIN_ROUND_NOT_NULL("5020526","投资人主投轮次不能为空"),
    INVESTOR_WORK_START_TIME_LATER_END_TIME("5020527","投资人认证工作经历中数据开始时间晚于结束时间"),
    INVESTOR_EDU_START_TIME_LATER_END_TIME("5020528","投资人认证教育经历中数据开始时间晚于结束时间"),
    MAIN_AREA_INFO_NOT_EXIST("5020529","系统中主投领域信息不存在"),
    MAIN_ROUND_INFO_NOT_EXIST("5020530","系统中主投轮次信息不存在"),
    INVESTOR_INFO_EXIST("5020531","当前投资人认证信息已存在"),
    START_TIME_MORE_THAN_END_TIME("5020532","投资日期开始时间晚于投资日期结束时间"),
    CURRENT_INVESTOR_HAVE_UP("5020533","当前投资人已上架,请勿重复操作"),
    CURRENT_INVESTOR_HAVE_DOWN("5020534","当前投资人已下架,请勿重复操作"),
    INVESTOR_ACCOUNT_NOT_EXIST("5020535","当前投资人账号在系统中不存在或已失效"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    InvestorExceptionEnum(String code, String message) {
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
