package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;

/**
* 房间申请状态枚举
* @author： zhuyz
* @date： Created on 2019/5/8 14:14
* @version： v1.0
* @modified By:
*/
public enum RoomApplyStatusEnums implements CodeAndMsg {
    SUCCEED("2","申请成功"),
    APPLY("1","申请中"),
    FAILURE("0","申请失败");
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

    RoomApplyStatusEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
