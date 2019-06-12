/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jn.reconciliation.enums;

/**
 * @ClassName：对账差错类型枚举
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public enum ReconciliationMistakeTypeEnum {
	// 银行不存在该订单
	BANK_MISS("1","银行漏单"),
	// 平台不存在该订单
	PLATFORM_MISS("2","平台漏单"),
	// 银行支付成功，平台支付不成功（比较常见）
	PLATFORM_SHORT_STATUS_MISMATCH("3","平台短款，状态不符"),
	// 平台需支付金额比银行实际支付金额少（基本不会出现）
	PLATFORM_SHORT_CASH_MISMATCH("4","平台短款，金额不符"),
	// 银行实际支付金额比平台需支付金额少
	PLATFORM_OVER_CASH_MISMATCH("5","平台长款,金额不符"),
	// 平台支付成功，银行支付不成功（基本不会出现）
	PLATFORM_OVER_STATUS_MISMATCH("6","平台长款,状态不符"),
	FEE_MISMATCH("7","手续费不匹配");

	private String code;
	private String message;

	ReconciliationMistakeTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public static ReconciliationMistakeTypeEnum getEnumByCode(String code) {
		ReconciliationMistakeTypeEnum enumBean = null;
		for (ReconciliationMistakeTypeEnum enumType : values()) {
			if (enumType.getCode().equals(code)) {
				//获取指定的枚举
				enumBean = enumType;
				break;
			}
		}

		return enumBean;
	}
}
