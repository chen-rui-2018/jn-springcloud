package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 停车场异常枚举
 *
 * @Author: jiangyl
 * @Date: 2019/04/18 20:02
 * @Version v1.0
 * @modified By:
 */
public enum ParkingExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    PARKING_AREA_ID_IS_NOT_NULL("4020201","停车场ID不能为空"),
    PARKING_SPACE_ID_IS_NOT_NULL("4020202","停车位ID不能为空"),
    PARKING_AREA_IS_NOT_EXIST("4020203","停车场不存在"),
    USER_LOGIN_INVALID("4020204","登录已失效，请重新登录"),
    CAR_LICENSE_IS_NOT_NULL("4020205","车牌号不能为空"),
    USER_CAR_IS_NOT_EXIT("4020206","车辆不存在"),
    USER_CAR_CANT_DELETE_OTHER_CAR("4020207","不能删除非本人车辆"),
    PARKING_PREFERENTIAL_IS_NOT_EXIST("4020208","优惠不存在"),
    START_TIME_NOT_AFTER_END_TIME("4020209","开始时间不能小于结束时间"),
    DAY_INTERVAL_ERROR("4020210","时间转换错误，请核实时间类容"),
    REND_ID_IS_NOT_NULL("4020211","租赁记录不能空"),
    PARKING_REND_IS_NOT_EXIST("4020212","租赁记录不存在"),
    PARKING_CAR_NOT_EXIT_EFFECTIVE_DATA("4020213","不存在有效停车数据"),
    PARKING_RECODE_IS_NOT_EXIST("40202014","停车记录不存在"),
    PARKING_MONTHLY_NOT_PAYMENT("40202015","月租卡不需要缴费"),

    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ParkingExceptionEnum(String code, String message) {
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
