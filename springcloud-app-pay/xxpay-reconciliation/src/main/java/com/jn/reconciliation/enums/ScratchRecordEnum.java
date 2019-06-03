
package com.jn.reconciliation.enums;

/**
 * @ClassName：差错暂存池状态枚举类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public enum ScratchRecordEnum {

	/**
	 * 交易成功
	 */
	SUCCESS("1","交易成功"),
	FAIL("0","交易失败");

	private String code;
	private String message;

	ScratchRecordEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public static ScratchRecordEnum getEnumByCode(String code) {
		ScratchRecordEnum enumBean = null;
		for (ScratchRecordEnum enumType : values()) {
			if (enumType.getCode().equals(code)) {
				//获取指定的枚举
				enumBean = enumType;
				break;
			}
		}

		return enumBean;
	}
}
