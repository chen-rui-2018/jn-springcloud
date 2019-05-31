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

import com.jn.reconciliation.enums.MistakeHandleStatusEnum;
import com.jn.reconciliation.enums.ReconciliationMistakeTypeEnum;
import com.jn.reconciliation.enums.TradeStatusEnum;
import com.jn.reconciliation.service.PayOrderService;
import com.jn.reconciliation.service.PayReconciliationMistakeScratchPoolService;
import com.jn.reconciliation.service.ReconciliationTransactionService;
import com.jn.reconciliation.vo.ReconciliationEntityVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.AmountUtil;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;
import org.xxpay.dal.dao.model.PayOrder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 对账的核心业务biz.
 *
 * 龙果学院：www.roncoo.com
 * 
 * @author：shenjialong
 */
@Component("reconciliationCheckBiz")
public class ReconciliationCheckBiz {

	private static final Log LOG = LogFactory.getLog(ReconciliationCheckBiz.class);

	@Autowired
	private PayReconciliationMistakeScratchPoolService payReconciliationMistakeScratchPoolService;
	@Autowired
	private ReconciliationTransactionService reconciliationTransactionService;

	@Autowired
	private PayOrderService payOrderService;



	/**
	 * 对账核心方法
	 * 
	 * @param bankList
	 *            对账文件解析出来的数据
	 * @param interfaceCode
	 *            支付渠道
	 * @param batch
	 *            对账批次记录
	 */
	public void check(List<ReconciliationEntityVo> bankList, String interfaceCode, TbPayReconciliationCheckBatch batch) {
		// 判断bankList是否为空
		if (bankList == null) {
			bankList = new ArrayList<ReconciliationEntityVo>();
		}
		//账期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = sdf.format(batch.getBillDate());

		// 查询平台bill_date,interfaceCode成功的交易
		List<PayOrder> platSucessDateList = payOrderService.getPaySuccessOrderByDate(billDate, interfaceCode);

		// 查询平台bill_date,interfaceCode所有的交易
		List<PayOrder> platAllDateList = payOrderService.getAllPayOrderByDate(billDate, interfaceCode);

		// 查询平台缓冲池中所有的数据
		List<TbPayReconciliationMistakeScratchPool> platScreatchRecordList = payReconciliationMistakeScratchPoolService.listScratchPoolRecord();

		// 差错list
		List<TbPayReconciliationMistake> mistakeList = new ArrayList<TbPayReconciliationMistake >();

		// 需要放入缓冲池中平台长款list
		List<TbPayReconciliationMistakeScratchPool> insertScreatchRecordList = new ArrayList<TbPayReconciliationMistakeScratchPool>();

		// 需要从缓冲池中移除的数据
		List<TbPayReconciliationMistakeScratchPool> removeScreatchRecordList = new ArrayList<TbPayReconciliationMistakeScratchPool>();

		LOG.info("  开始以平台的数据为准对账,平台长款记入缓冲池");
		baseOnPaltForm(platSucessDateList, bankList, mistakeList, insertScreatchRecordList, batch);
		LOG.info("结束以平台的数据为准对账");

		LOG.info("  开始以银行通道的数据为准对账");
		baseOnBank(platAllDateList, bankList, platScreatchRecordList, mistakeList, batch, removeScreatchRecordList);
		LOG.info(" 结束以银行通道的数据为准对账");

		// 保存数据
		reconciliationTransactionService.saveDatasaveDate(batch, mistakeList, insertScreatchRecordList, removeScreatchRecordList);

	}

	/**
	 * 以平台的数据为准对账
	 * 
	 * @param platformDateList
	 *            平台dilldate的成功数据
	 * @param bankList
	 *            银行成功对账单数据
	 * 
	 * @param misTakeList
	 *            差错list
	 * @param screatchRecordList
	 *            需要放入缓冲池中平台长款list
	 * 
	 * @param batch
	 *            对账批次
	 */
	private void baseOnPaltForm(List<PayOrder> platformDateList, List<ReconciliationEntityVo> bankList, List<TbPayReconciliationMistake > misTakeList, List<TbPayReconciliationMistakeScratchPool> screatchRecordList, TbPayReconciliationCheckBatch batch) {
		// 平台交易总金额
		BigDecimal platTradeAmount = BigDecimal.ZERO;
		// 平台总手续费
		BigDecimal platFee = BigDecimal.ZERO;
		// 平台订单总数
		Integer tradeCount = 0;
		Integer mistakeCount = 0;

		for (PayOrder payOrder : platformDateList) {
			//订单金额(转元)
			BigDecimal  payAmount = new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
			//订单手续费(转元)
			BigDecimal  platCost = new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getPlatCost().toString()));
			// 用于标记是否有匹配
			Boolean flag = false;
			// 累计平台交易总金额和总手续费
			platTradeAmount = platTradeAmount.add(payAmount);
			platFee = platFee.add(platCost == null ? BigDecimal.ZERO : platCost);
			tradeCount++;
			for (ReconciliationEntityVo bankRecord : bankList) {
				// 如果银行账单中有匹配数据：进行金额，手续费校验
				if (payOrder.getPayOrderId().equalsIgnoreCase(bankRecord.getBankOrderNo())) {
					// 标记已经找到匹配
					flag = true;

					/** step1:匹配订单金额 **/
					// 平台金额多
					if (payAmount.compareTo(bankRecord.getBankAmount()) == 1) {
						// 金额不匹配，创建差错记录
						TbPayReconciliationMistake  misktake = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_OVER_CASH_MISMATCH, batch);
						misTakeList.add(misktake);
						mistakeCount++;
						break;
					}
					// 平台金额少
					else if (payAmount.compareTo(bankRecord.getBankAmount()) == -1) {
						// 金额不匹配，创建差错记录
						TbPayReconciliationMistake  misktake = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_SHORT_CASH_MISMATCH, batch);
						misTakeList.add(misktake);
						mistakeCount++;
						break;
					}

					/** step2:匹配订单手续费 **/
					if (platCost.compareTo(bankRecord.getBankFee()) != 0) {
						// 金额不匹配，创建差错记录
						TbPayReconciliationMistake  misktake = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.FEE_MISMATCH, batch);
						misTakeList.add(misktake);
						mistakeCount++;
						break;
					}

				}
			}
			// 没有找到匹配的记录，把这个订单记录到缓冲池中
			if (!flag) {
				TbPayReconciliationMistakeScratchPool screatchRecord = getScratchRecord(payOrder, batch);
				screatchRecordList.add(screatchRecord);
			}
		}

		// 统计数据保存
		batch.setTradeAmount(platTradeAmount);
		batch.setTradeCount(tradeCount);
		batch.setFee(platFee);
		batch.setMistakeCount(mistakeCount);
	}

	/**
	 * 以银行的数据为准对账
	 * 
	 * @param bankList
	 *            银行对账单数据
	 * 
	 * @param misTakeList
	 *            差错list
	 * 
	 * @param platScreatchRecordList
	 *            平台缓冲池中的数据
	 * 
	 * @param batch
	 *            对账批次
	 */
	private void baseOnBank(List<PayOrder> platAllDateList
			, List<ReconciliationEntityVo> bankList
			, List<TbPayReconciliationMistakeScratchPool> platScreatchRecordList
			, List<TbPayReconciliationMistake > misTakeList
			, TbPayReconciliationCheckBatch batch
			, List<TbPayReconciliationMistakeScratchPool> removeScreatchRecordList) {
		// 平台交易总金额
		BigDecimal platTradeAmount = BigDecimal.ZERO;
		// 平台总手续费
		BigDecimal platFee = BigDecimal.ZERO;
		// 平台订单总数
		Integer tradeCount = 0;
		Integer mistakeCount = 0;
		// 拿银行数据去对账
		for (ReconciliationEntityVo bankRecord : bankList) {

			boolean flag = false;// 用于标记是否有匹配
			for (PayOrder payOrder : platAllDateList) {

				//订单金额(转元)
				BigDecimal  payAmount = new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
				//订单手续费(转元)
				BigDecimal  platCost = new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getPlatCost().toString()));

				/** step1 检查有匹配的数据 **/
				if (bankRecord.getBankOrderNo().equals(payOrder.getPayOrderId())) {
					flag = true;
					/** step2： 判断平台状态是否匹配 **/
					/** 注意：状态匹配不需要做金额和手续费验证，以平台数据为基准对账已经做了验证 **/
					// 不匹配记录差错。
					if ((payOrder.getStatus() != PayConstant.PAY_STATUS_SUCCESS) && (payOrder.getStatus() != PayConstant.PAY_STATUS_COMPLETE)) {
						TbPayReconciliationMistake  misktake1 = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_SHORT_STATUS_MISMATCH, batch);
						misTakeList.add(misktake1);
						mistakeCount++;
						// break;

						/** 订单状态不匹配验证完之后，在验证金额和手续费，差错处理必须先处理状态不符的情况 **/
						// 验证金额和手续费
						/** step1:匹配订单金额 **/
						// 平台金额多
						if (payAmount.compareTo(bankRecord.getBankAmount()) == 1) {
							// 金额不匹配，创建差错记录
							TbPayReconciliationMistake  misktake = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_OVER_CASH_MISMATCH, batch);
							misTakeList.add(misktake);
							mistakeCount++;
							break;
						}
						// 平台金额少
						else if (payAmount.compareTo(bankRecord.getBankAmount()) == -1) {
							// 金额不匹配，创建差错记录
							TbPayReconciliationMistake  misktake = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_SHORT_CASH_MISMATCH, batch);
							misTakeList.add(misktake);
							mistakeCount++;
							break;
						}

						/** step2:匹配订单手续费 **/
						if (platCost.compareTo(bankRecord.getBankFee()) != 0) {
							// 金额不匹配，创建差错记录
							TbPayReconciliationMistake  misktake = createMisktake(null, payOrder, bankRecord, ReconciliationMistakeTypeEnum.FEE_MISMATCH, batch);
							misTakeList.add(misktake);
							mistakeCount++;
							break;
						}

					}
				}
			}

			/** step3： 如果没有匹配的数据，去缓冲池中查找对账，如果没有记录差错 **/
			if (!flag) {
				// 去缓冲池中查找对账(前提是缓冲池里面有数据)
				if (platScreatchRecordList != null) {
					for (TbPayReconciliationMistakeScratchPool scratchRecord : platScreatchRecordList) {

						// 找到匹配的
						if (scratchRecord.getBankOrderNo().equals(bankRecord.getBankOrderNo())) {
							// 累计平台交易总金额和总手续费
							platTradeAmount = platTradeAmount.add(scratchRecord.getOrderAmount());
							platFee = platFee.add(scratchRecord.getPlatCost() == null ? BigDecimal.ZERO : scratchRecord.getPlatCost());
							tradeCount++;
							flag = true;

							// 验证金额和手续费
							/** step1:匹配订单金额 **/
							// 平台金额多
							if (scratchRecord.getOrderAmount().compareTo(bankRecord.getBankAmount()) == 1) {
								// 金额不匹配，创建差错记录
								TbPayReconciliationMistake misktake = createMisktake(scratchRecord, null, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_OVER_CASH_MISMATCH, batch);
								misTakeList.add(misktake);
								mistakeCount++;
								break;
							}
							// 平台金额少
							else if (scratchRecord.getOrderAmount().compareTo(bankRecord.getBankAmount()) == -1) {
								// 金额不匹配，创建差错记录
								TbPayReconciliationMistake  misktake = createMisktake(scratchRecord, null, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_SHORT_CASH_MISMATCH, batch);
								misTakeList.add(misktake);
								mistakeCount++;
								break;
							}

							/** step2:匹配订单手续费 **/
							if (scratchRecord.getPlatCost().compareTo(bankRecord.getBankFee()) != 0) {
								// 金额不匹配，创建差错记录
								TbPayReconciliationMistake   misktake = createMisktake(scratchRecord, null, bankRecord, ReconciliationMistakeTypeEnum.FEE_MISMATCH, batch);
								misTakeList.add(misktake);
								mistakeCount++;
								break;
							}

							/** step3:把缓存池中匹配的记录删除掉 **/
							removeScreatchRecordList.add(scratchRecord);
						}
					}
				}
			}

			// 缓冲池中还是没有这条记录,直接记录差错，差错类型为 PLATFORM_MISS("平台漏单")
			if (!flag) {
				TbPayReconciliationMistake misktake = createMisktake(null, null, bankRecord, ReconciliationMistakeTypeEnum.PLATFORM_MISS, batch);
				misTakeList.add(misktake);
				mistakeCount++;
			}
		}

		// 统计数据保存
		batch.setTradeAmount(batch.getTradeAmount().add(platTradeAmount));
		batch.setTradeCount(batch.getTradeCount() + tradeCount);
		batch.setFee(batch.getFee().add(platFee));
		batch.setMistakeCount(batch.getMistakeCount() + mistakeCount);
	}

	/**
	 * 创建差错记录
	 * 
	 * @param scratchRecord
	 *            平台缓冲池中的订单记录
	 * @param payOrder
	 *            支付订单
	 * @param bankRecord
	 *            银行账单记录
	 * @param mistakeType
	 *            差错类型
	 * @return 注意：scratchRecord和record 至少有一个为空
	 */
	private TbPayReconciliationMistake  createMisktake(TbPayReconciliationMistakeScratchPool scratchRecord, PayOrder payOrder, ReconciliationEntityVo bankRecord, ReconciliationMistakeTypeEnum mistakeType, TbPayReconciliationCheckBatch batch) {

		TbPayReconciliationMistake  mistake = new TbPayReconciliationMistake ();
		mistake.setAccountCheckBatchNo(batch.getBatchNo());
		mistake.setBillDate(batch.getBillDate());
		mistake.setErrType(mistakeType.name());
		mistake.setHandleStatus(MistakeHandleStatusEnum.NOHANDLE.name());
		mistake.setBankType(batch.getBankType());
		if (payOrder != null) {
			mistake.setMerchantName(payOrder.getBody());
			mistake.setMerchantNo(payOrder.getMchId());
			mistake.setOrderNo(payOrder.getPayOrderId());
			mistake.setTradeTime(payOrder.getCreateTime());
			mistake.setTrxNo(payOrder.getChannelOrderNo());
			mistake.setOrderAmount(new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString())));
			mistake.setTradeStatus(payOrder.getStatus().toString());
			mistake.setFee(new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getPlatCost().toString())));
		}

		if (scratchRecord != null) {
			mistake.setOrderNo(scratchRecord.getMerchantOrderNo());
			mistake.setTradeTime(scratchRecord.getPaySuccessTime());
			mistake.setTrxNo(scratchRecord.getTrxNo());
			mistake.setOrderAmount(scratchRecord.getOrderAmount());
			mistake.setRefundAmount(scratchRecord.getSuccessRefundAmount());
			mistake.setTradeStatus(scratchRecord.getStatus());
			mistake.setFee(scratchRecord.getPlatCost());
		}

		if (bankRecord != null) {
			mistake.setBankAmount(bankRecord.getBankAmount());
			mistake.setBankFee(bankRecord.getBankFee());
			mistake.setBankOrderNo(bankRecord.getBankOrderNo());
			mistake.setBankRefundAmount(bankRecord.getBankRefundAmount());
			mistake.setBankTradeStatus(bankRecord.getBankTradeStatus());
			mistake.setBankTradeTime(bankRecord.getBankTradeTime());
			mistake.setBankTrxNo(bankRecord.getBankTrxNo());
		}
		return mistake;

	}

	/**
	 * 得到缓存记录：用于放入缓冲池
	 * 
	 * @param payOrder
	 *            支付订单表
	 * @param batch
	 *            对账批次记录
	 * @return
	 */
	private TbPayReconciliationMistakeScratchPool getScratchRecord(PayOrder payOrder, TbPayReconciliationCheckBatch batch) {

		TbPayReconciliationMistakeScratchPool scratchRecord = new TbPayReconciliationMistakeScratchPool();
		scratchRecord.setBankOrderNo(payOrder.getPayOrderId());
		scratchRecord.setBankTrxNo(payOrder.getChannelOrderNo());
		//scratchRecord.setCompleteTime();
		//scratchRecord.setPaySuccessTime(record.getPaySuccessTime());
		scratchRecord.setMerchantOrderNo(payOrder.getMchOrderNo());
		scratchRecord.setOrderAmount(new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString())));
		scratchRecord.setPlatCost(new BigDecimal(AmountUtil.convertCent2Dollar(payOrder.getPlatCost().toString())));
		scratchRecord.setPayWayCode(payOrder.getChannelId());
		scratchRecord.setTrxNo(payOrder.getChannelOrderNo());
		scratchRecord.setStatus(TradeStatusEnum.SUCCESS.name());
		scratchRecord.setBatchNo(batch.getBatchNo());
		scratchRecord.setBillDate(batch.getBillDate());
		return scratchRecord;
	}
}
