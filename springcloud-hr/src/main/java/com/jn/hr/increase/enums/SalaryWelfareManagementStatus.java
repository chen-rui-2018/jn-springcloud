package com.jn.hr.increase.enums;

import com.jn.common.api.CodeAndMsg;

public enum SalaryWelfareManagementStatus implements CodeAndMsg{
	    EFFECTIVE("1","有效"),
	    INVALID("2","无效"),
	    DELETE("0","标记删除"),
	    NORMAL("1","正常")
	    ;
		private String code;

	    private String message;
	    SalaryWelfareManagementStatus(String code, String message){
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
