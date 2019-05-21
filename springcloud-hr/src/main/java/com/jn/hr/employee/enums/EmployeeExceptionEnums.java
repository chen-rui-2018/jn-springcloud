package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author dt
 * @create 2019-04-15 下午 1:13
 */
public enum EmployeeExceptionEnums implements CodeAndMsg {
    ResumeDatabase_NOT_EXISTS("7000001", "修改简历不存在"),
    GET_ResumeDatabase_ERROR("7000002", "简历不存在,或已被删除"),
    FILE_NOT_EMPTY("7000003", "文件为空"),
    DOWNLOAD_EXCEL_TEMPLATE_FAIL("7000004", "下载EXCEL模板文件失败"),
    EmployeeFileClass_NOT_EXISTS("7000005", "修改员工档案分类不存在"),
    EmployeeFile_NOT_EXISTS("7000006", "员工档案不存在,或已被删除"),
    File_NOT_EXISTS("7000007", "附件不存在"),
    EmployeeBasicInfo_NOT_EXISTS("7000008", "员工花名册不存在"),
    EmployeeDEPARTMENT_NOT_EXISTS("7000009", "部门不存在"),
    HOLIDAY_RULE_ERROR("7000010", "假期规则不符合要求"),
    QUERYDICT_ERROR("7000011", "查询字典表错误"),
    ADD_USER_ERROR("7000012", "新增用户接口调用错误")
    ;
    private String code;

    private String message;

    EmployeeExceptionEnums(String code, String message) {
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
}
