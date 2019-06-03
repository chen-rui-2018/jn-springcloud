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
package org.xxpay.common.enumm;


/**
 * @ClassName：支付方式枚举
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/29 19:15
 * @Version： v1.0
 * @Modified By:
 */
public enum PayWayEnum {

	WX("WX","微信"),
	ALIPAY("ALIPAY","支付宝");

	private String code;
	private String message;

	PayWayEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public static PayWayEnum getEnumByCode(String code) {
		PayWayEnum enumBean = null;
		for (PayWayEnum enumType : values()) {
			if (enumType.getCode().equals(code)) {
				//获取指定的枚举
				enumBean = enumType;
				break;
			}
		}

		return enumBean;
	}
}
