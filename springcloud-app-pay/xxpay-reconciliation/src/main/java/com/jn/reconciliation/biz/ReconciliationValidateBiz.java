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
package com.jn.reconciliation.biz;

import com.jn.reconciliation.enums.BatchStatusEnum;
import com.jn.reconciliation.enums.MistakeHandleStatusEnum;
import com.jn.reconciliation.enums.ReconciliationMistakeTypeEnum;
import com.jn.reconciliation.service.PayReconciliationCheckBatchService;
import com.jn.reconciliation.service.PayReconciliationMistakeScratchPoolService;
import com.jn.reconciliation.service.ReconciliationTransactionService;
import com.jn.reconciliation.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName：对账验证biz，(检查是否已经对过账)..
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Component("reconciliationValidateBiz")
public class ReconciliationValidateBiz {

	private static final Log LOG = LogFactory.getLog(ReconciliationValidateBiz.class);

	@Autowired
	private PayReconciliationCheckBatchService payReconciliationCheckBatchService;
	@Autowired
	private ReconciliationTransactionService reconciliationTransactionService;
	@Autowired
	private PayReconciliationMistakeScratchPoolService payReconciliationMistakeScratchPoolService;

	/**
	 * 判断某支付方式某天是否对过账，避免重复对账
	 * 
	 * @param interfaceCode
	 *            支付方式
	 * @param billDate
	 *            账单日
	 * @return
	 */
	public Boolean isChecked(String interfaceCode, Date billDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String billDateStr = sdf.format(billDate);
		LOG.info("检查,支付方式[" + interfaceCode + "],订单日期[" + billDateStr + "]");

		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 除非对账错误或者对账异常才可以发起第二次对账
		String notInStatus = BatchStatusEnum.ERROR.getCode() + "," + BatchStatusEnum.FAIL.getCode();
		paramMap.put("billDate",billDateStr);
		paramMap.put("interfaceCode",interfaceCode);
		paramMap.put("inStatus",BatchStatusEnum.SUCCESS.getCode());
		List<TbPayReconciliationCheckBatch> list = payReconciliationCheckBatchService.listByCondition(paramMap);
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 如果缓冲池中有三天前的数据就清理掉并记录差错
	 */
	public void validateScratchPool() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(DateUtil.addDay(new Date(), -3));
		// 查询是否有创建时间是三天前的数据
		List<TbPayReconciliationMistakeScratchPool> list = payReconciliationMistakeScratchPoolService.listByMaxDate(dateStr);
		List<TbPayReconciliationMistake> mistakeList = null;
		// 如果有数据
		if (!list.isEmpty()) {
			mistakeList = new ArrayList<TbPayReconciliationMistake>();
			for (TbPayReconciliationMistakeScratchPool scratchRecord : list) {
				// 创建差错记录
				TbPayReconciliationMistake mistake = new TbPayReconciliationMistake();
				mistake.setAccountCheckBatchNo(scratchRecord.getBatchNo());
				mistake.setBillDate(scratchRecord.getBillDate());
				mistake.setErrType(ReconciliationMistakeTypeEnum.BANK_MISS.getCode());
				mistake.setHandleStatus(MistakeHandleStatusEnum.NOHANDLE.getCode());
				mistake.setBankType(scratchRecord.getPayWayCode());

				mistake.setOrderNo(scratchRecord.getMerchantOrderNo());
				mistake.setTradeTime(scratchRecord.getPaySuccessTime());
				mistake.setTrxNo(scratchRecord.getTrxNo());
				mistake.setOrderAmount(scratchRecord.getOrderAmount());
				mistake.setRefundAmount(scratchRecord.getSuccessRefundAmount());
				mistake.setTradeStatus(scratchRecord.getStatus());
				mistake.setFee(scratchRecord.getPlatCost());
				mistakeList.add(mistake);
			}

			reconciliationTransactionService.removeDateFromPool(list, mistakeList);

		}

	}
}
