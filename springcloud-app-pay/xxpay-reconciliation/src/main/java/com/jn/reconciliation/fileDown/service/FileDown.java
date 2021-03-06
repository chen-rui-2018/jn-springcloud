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
package com.jn.reconciliation.fileDown.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;

import java.io.File;
import java.io.IOException;
import java.util.Date;


/**
 * @ClassName：对账文件下载
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public interface FileDown {

	/**
	 * 对帐文件下载，获得文件输出
	 * @param reconciliationInter
	 * 			支付接口信息
	 * @param fileDate
	 *            账单日
	 * @return
	 * @throws Exception
	 */
	File fileDown(TbPayReconciliationInterface reconciliationInter, Date fileDate) throws IOException, Exception;

}
