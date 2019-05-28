package com.jn.oa.attendance.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 经纬度枚举
 *
 * @author： yuanyy
 * @date： Created on 2019/5/27 19:04
 * @version： v1.0
 * @modified By:
 */
public enum AttendanceLocationEnums implements CodeAndMsg {
    LONGITUDE_MODULE_CODE("springcloud-oa", "模块编码"),
    LONGITUDE_PARENT_GROUP_CODE("common", "父分组编码"),
    LONGITUDE_GROUP_CODE("location", "分组编码"),
    LONGITUDE_KEY("longitude", "经度数据字典的键"),
    LATITUDE_KEY("latitude", "纬度数据字典的键"),
    DISTANCE_KEY("distance", "距离数据字典的键"),

     ;

    private String code;

    private String message;

    AttendanceLocationEnums(String key, String message) {
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