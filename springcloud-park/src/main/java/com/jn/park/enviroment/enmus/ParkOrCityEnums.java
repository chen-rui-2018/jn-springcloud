package com.jn.park.enviroment.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 园区或市区枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum ParkOrCityEnums implements CodeAndMsg {
    PARK("1", "园区"),
    CITY("2", "市区");

    private String code;

    private String message;

    ParkOrCityEnums(String key, String message) {
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
