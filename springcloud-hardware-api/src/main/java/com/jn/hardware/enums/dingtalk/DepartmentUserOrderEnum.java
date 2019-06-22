package com.jn.hardware.enums.dingtalk;

/**
 * 支持分页查询，部门成员的排序规则，默认 是按自定义排序；
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 15:59
 * @Version： v1.0
 * @Modified By:
 */
public enum DepartmentUserOrderEnum {
    /**
     * 代表按照进入部门的时间升序
     */
    ORDER_ENTRY_ASC("entry_asc"),
    /**
     * 代表按照进入部门的时间降序
     */
    ORDER_ENTRY_DESC("entry_desc"),
    /**
     * modify_asc：代表按照部门信息修改时间升序
     */
    ORDER_MODIFY_ASC("modify_asc"),
    /**
     * modify_desc：代表按照部门信息修改时间降序
     */
    ORDER_MODIFY_DESC("modify_desc"),
    /**
     * custom：代表用户定义(未定义时按照拼音)排序
     */
    ORDER_CUSTOM("custom"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    DepartmentUserOrderEnum(String code) {
        this.code = code;
    }
}
