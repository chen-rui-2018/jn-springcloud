package com.jn.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @ClassName：缴费类型枚举类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/7 11:15
 * @Version： v1.0
 * @Modified By:
 */
public enum MchIdEnum implements CodeAndMsg {
    //目前只有一个商户  后期可能存在多个
    MCH_BASE("10000000", "智慧园区-通用缴费");

    private String code;
    private String message;

    MchIdEnum(String code, String message) {
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


    public static MchIdEnum getCode(String channelId) {
        MchIdEnum channelIdEnum = null;
        for (MchIdEnum channelType : values()) {
            if (channelType.getCode() == channelId) {
                //获取指定的枚举
                channelIdEnum = channelType;
                break;
            }
        }

        return channelIdEnum;
    }
}
