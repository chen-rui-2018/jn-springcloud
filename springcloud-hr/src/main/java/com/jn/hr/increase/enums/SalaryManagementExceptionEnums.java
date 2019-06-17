package com.jn.hr.increase.enums;

import com.jn.common.api.CodeAndMsg;

public enum SalaryManagementExceptionEnums implements CodeAndMsg{
    NOT_EXIST_ERROR("900001","薪资信息不存在"),
    EXIST_SALARYINFO("900005","薪资信息已存在"),
	FILE_EMPTY("900002","文件为空"),
	DOWNLOAD_EXCEL_TEMPLATE_FAIL("900007","导入薪资表模块异常"),
	SCHEME_USING("900004","方案有人使用"),
	INSURED_RECORD_EXISTS("900003","参保记录已存在"),
	SCHEME_DETAILD_NOT_EXIST("900006","方案明细不存在")
	;
	
	private String code;

    private String message;
    SalaryManagementExceptionEnums(String code, String message){
    	this.code = code;
        this.message = message;
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
