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
package com.jn.reconciliation.service.impl;

import org.xxpay.common.enumm.PayWayEnum;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName：对账接口实体
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public class ReconciliationInterface {

	/** 接口名称 */
	private String interfaceName;

	/** 接口代码 */
	private String interfaceCode;

	/** 接口描述 */
	private String interfaceDesc;

	/** 是否有效 PublicStatusEnum */
	private String status;

	/** 对账单周期 **/
	private int billDay;

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getInterfaceDesc() {
		return interfaceDesc;
	}

	public void setInterfaceDesc(String interfaceDesc) {
		this.interfaceDesc = interfaceDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBillDay() {
		return billDay;
	}

	public void setBillDay(int billDay) {
		this.billDay = billDay;
	}

	public static List<ReconciliationInterface> getInterface() {
		List<ReconciliationInterface> list = new ArrayList<ReconciliationInterface>();

		// 微信支付
		ReconciliationInterface weixin = new ReconciliationInterface();
		weixin.setInterfaceCode(PayWayEnum.WX.getCode());
		weixin.setInterfaceName(PayWayEnum.WX.getMessage());
		list.add(weixin);

		//TODO 支付宝还没有商户号可以测试,后期需要加上
		// 支付宝
		ReconciliationInterface alipay = new ReconciliationInterface();
		alipay.setInterfaceCode(PayWayEnum.ALIPAY.getCode());
		alipay.setInterfaceName(PayWayEnum.ALIPAY.getMessage());
		list.add(alipay);
		return list;

	}
}
