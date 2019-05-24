package com.jn.pay.enums;/**
 * @author： huangbq
 * @date： Created on 2019/5/23 16:32
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.api.CodeAndMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *缴费类型
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/23
 *</pre>
 */
public enum  PayTypeEnums implements CodeAndMsg {
    ELECTRIC("1","电费"),
    PROPERTY("2","物业费"),
    REPAIR("3","维修费"),
    ROOM_LEASE("4","房租费"),
    GOODS_LEASE("5","物品租赁费"),
    TEMPORARY_PARKING("6","停车费"),
    PARKING_LEASE("7","车位费"),
    WATER("8","水费"),
    PROMOTION("9","宣传费"),
    HEALTH("10","体检费"),
    ELECTRIC_RECHARGE("11","预缴充值电费");

    @ApiModelProperty(value = "类型编码",example = "2")
    private String code;
    @ApiModelProperty(value = "类型名称",example = "物业费")
    private String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    PayTypeEnums(String code, String name) {
        this.code = code;
        this.message = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
