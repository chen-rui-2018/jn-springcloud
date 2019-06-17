package com.jn.oa.goods.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 物品管理邮箱模板枚举
 *
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum GoodsTemplateEnums implements CodeAndMsg {

    GOODS_REMIND_TEMPLATE("oaGoodsRemindTemplate", "物品管理数量提醒模板");

    private String code;

    private String message;

    GoodsTemplateEnums(String key, String message) {
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
