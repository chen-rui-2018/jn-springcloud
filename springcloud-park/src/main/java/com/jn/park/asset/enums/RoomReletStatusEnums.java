package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;

public enum RoomReletStatusEnums implements CodeAndMsg {
    YES("1","是续租订单"),
    NO("0","不是续租订单");
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    RoomReletStatusEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
