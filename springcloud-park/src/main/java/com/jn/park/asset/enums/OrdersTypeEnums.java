package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;
/**
* 账单类型枚举
* @author： zhuyz
* @date： Created on 2019/4/29 21:16
* @version： v1.0
* @modified By:
*/
public enum OrdersTypeEnums implements CodeAndMsg{
    ARTICLE("1","物品租赁"),
    ROOM("2","房间租赁");

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

    OrdersTypeEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
