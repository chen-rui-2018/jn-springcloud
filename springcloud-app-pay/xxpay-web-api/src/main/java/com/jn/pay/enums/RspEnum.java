package com.jn.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @ClassName:  响应枚举类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/7 10:15
 * @Version： v1.0
 * @Modified By:
 */
public enum RspEnum implements CodeAndMsg {

    SUCCESS("success", "成功"),
    FAIL("fail", "失败");


    private String code;
    private String message;

    RspEnum(String code, String message) {
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


    public static RspEnum getCode(String channelId) {
        RspEnum channelIdEnum = null;
        for (RspEnum channelType : values()) {
            if (channelType.getCode() == channelId) {
                //获取指定的枚举
                channelIdEnum = channelType;
                break;
            }
        }

        return channelIdEnum;
    }
}
