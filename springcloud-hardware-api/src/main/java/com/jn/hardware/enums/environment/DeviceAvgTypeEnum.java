package com.jn.hardware.enums.environment;

import com.jn.common.api.CodeAndMsg;

/**
 * 获取设备的统计数据
 * 统计时段类型   day|hour
 * @Author： cm
 * @Date： Created on 2019/6/24 16:58
 * @Version： v1.0
 * @Modified By:
 */
public enum DeviceAvgTypeEnum implements CodeAndMsg {
    DEVICE_AVG_HOUR_TYPE("hour","按小时统计时段"),
    DEVICE_AVG_DAY_TYPE("day","按天统计时段");

    private String code;
    private String message;

    DeviceAvgTypeEnum(String code, String message) {
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
