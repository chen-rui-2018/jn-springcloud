package com.jn.hardware.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/18 9:23
 * @Version： v1.0
 * @Modified By:
 */
public enum ParkingCompanyEnum implements CodeAndMsg {

    DOOR_COMPANY("1", "道尔公司"),
    FUSHI_COMPANY("2", "富士公司"),
    ALL_COMPANY("9", "全部");

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ParkingCompanyEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
