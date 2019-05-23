package com.jn.enterprise.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: huxw
 * @Date: 2019-4-1 11:06:16
 * @Version v1.0
 * @modified By:
 */
public enum RecruitDataTypeEnum implements CodeAndMsg {
    // 查询筛选
    WEEK("week","最近一周"),
    MONTH("month","最近一月"),

    // 排序条件
    TIME("time","时间"),
    HOT("hot","热度"),

    // 状态
    ALL_SHELVES("2", (byte)2,"全部"),
    ON_SHELVES("1", (byte)1, "已上架"),
    OFF_SHELVES("0", (byte)0, "已下架"),

    APPROVAL_STATUS_WAIT("0", "未审批"),
    APPROVAL_STATUS_ING("1", "审批中"),
    APPROVAL_STATUS_PASS("2", "审核通过"),
    APPROVAL_STATUS_NOT_PASS("3", "审核不通过"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    private byte value;

    RecruitDataTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    RecruitDataTypeEnum(String code, byte value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }}
