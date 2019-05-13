package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;

/**
 *状态枚举
 *
 * @author： zhuyz
 * @date： Created on 2019/3/27 19:11
 * @version： v1.0
 * @modified By:
 */
public enum AssetStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "有效"),
    DELETED("0","已删除");


    private String code;

    private String message;

    AssetStatusEnums(String code, String message) {
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
