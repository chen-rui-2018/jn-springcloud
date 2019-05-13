package com.jn.park.parking.enums;

import com.jn.common.api.CodeAndMsg;

/**
 *智慧停车枚举
 *
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:51
 * @version： v1.0
 * @modified By:
 */
public enum ParkingEnums implements CodeAndMsg {
    EFFECTIVE("1", "有效"),
    DELETED("0","已删除"),
    NEED_PAGE("1","需要分页"),
    PARKING_AREA_EFFECTIVE("1","停车场有效"),
    FREE_PARKING_TIME("15","免费停车时间15分钟"),
    PARKING_AREA_DELETED("0","停车场无效"),
    PARKING_SPACE_DELETED("0","停车位无效"),
    PARKING_SPACE_NOT_RENTED("1","停车位未出租"),
    PARKING_USER_CAR_INFO_EFFECTIVE("1","用户车辆有效"),
    PARKING_USER_CAR_INFO_DELETED("0","用户车辆无效"),
    DATE_TIME_FORMAT("yyyy-MM-dd HH:mm:ss","时间格式 yyyy-MM-dd HH:mm:ss"),
    DATE_TIME_FORMAT_DATE("yyyy-MM-dd","时间格式 yyyy-MM-dd"),
    DATE_TIME_FORMAT_DATE_NUM("yyyyMMddHHmmss","时间格式 yyyyMMddHHmmss"),
    PARKING_USER_APPLY_WAIT_CHECK("0","车位申请待审核"),
    PARKING_USER_APPLY_PAYED("6","车位已支付"),
    PARKING_BILL_IS_WAIT_PAY("1","车位申请待审核"),
    PARKING_MONTH_BILL_TYPE("parking_month","停车月卡缴费类型"),
    PARKING_MONTH_BILL_TYPE_NAME("停车缴费月卡","停车缴费月卡"),
    PARKING_TEMPORARY_BILL_TYPE_NAME("临时车缴费","临时车缴费"),
    PARKING_TEMPORARY_BILL_TYPE("parking_fee","临时车缴费类型"),
    PARKING_DISCHAR_PASS("1","放行"),
    PARKING_DISCHAR_UNPASS("0","不放行"),
    PARKING_IS_RENTAL("1","月租卡"),
    PARKING_IS_UNRENTAL("0","非月租卡"),
    PARKING_PAYMENT_IS_INITIATE("1","账单创建成功"),
    PARKING_PAYMENT_IS_NOT("2","账单创建失败，月租卡不需要支付"),
    PARKING_PAYMENT_IS_NOT_PAY("3","缴费金额为0无需支付"),
    CAR_IS_IN_PARKING("1","车辆已入场"),
    CAR_IS_NOT_IN_PARKING("0","车辆已离场"),
    PARKING_SPACE_RENTAL_IS_PAYED("6","租赁服务已支付"),
    PARKING_YEAR_FIXED_DISCOUNT("1","固定金额优惠"),
    PARKING_YEAR_PROPORTIONAL_DISCOUNT("2","比例优惠"),
    PARKING_RESPONSE_SUCCESS("0000","响应成功"),




    ;
    private String code;

    private String message;

    ParkingEnums(String code, String message) {
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
    }}
