package com.jn.enterprise.recruit.enums;

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
    ALL_SHELVES("2","全部"),
    ON_SHELVES("1","已上架"),
    OFF_SHELVES("0","已下架"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    RecruitDataTypeEnum(String code, String message) {
        this.code = code;
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
}
