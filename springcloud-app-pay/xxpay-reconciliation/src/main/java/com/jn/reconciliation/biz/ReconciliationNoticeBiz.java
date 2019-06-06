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

import com.jn.common.channel.MessageSource;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.reconciliation.enums.BatchStatusEnum;
import com.jn.reconciliation.service.PayReconciliationCheckBatchService;
import com.jn.reconciliation.service.PayReconciliationMistakeService;
import com.jn.reconciliation.service.ReconciliationNoticeUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.xxpay.common.enumm.MessageNoticesTemplateEnums;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationNoticeUser;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName：对账结果通知.
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Component("reconciliationNoticeBiz")
@EnableBinding(value = {MessageSource.class})
public class ReconciliationNoticeBiz {

	private static Logger logger = LoggerFactory.getLogger(ReconciliationNoticeBiz.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ReconciliationNoticeUserService reconciliationNoticeUserService;

	@Autowired
	private PayReconciliationCheckBatchService payReconciliationCheckBatchService;

	@Autowired
	private PayReconciliationMistakeService payReconciliationMistakeService;




	/**
	 * 短信通知对账结果
	 * @param billDateStr 账单日期
	* */
	public void messageNotice(String billDateStr){
		logger.info("[对账通知] ====通知开始==== ");
		//日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDateStr = sdf.format(new Date());

		/**step 1 获取通知的用户号码  **/
		//查询出需要通知的用户号码
		String[] Mobiles;
		List<TbPayReconciliationNoticeUser> userList = reconciliationNoticeUserService.getEffectiveUserList();
		if(null != userList && userList.size() > 0) {
			Mobiles = new String[userList.size()];
			for (int i = 0; i < userList.size(); i++) {
				Mobiles[i] = userList.get(i).getPhone();
			}

			logger.info("本次对账通知的号码为：{}" , Arrays.toString(Mobiles));
		}else{
			logger.info("没有可通知的对象 userList isNull" );
			logger.info("[对账通知] ====通知结束====");
			return ;
		}

		/**step 2 获取短信内容  **/
		// 平台交易总金额
		BigDecimal platTradeAmount = BigDecimal.ZERO;
		// 平台实际交易总金额(扣除手续费)
		BigDecimal platTradeActualAmount = BigDecimal.ZERO;
		// 平台总手续费
		BigDecimal platFee = BigDecimal.ZERO;
		// 商户交易总金额
		BigDecimal bankAmount = BigDecimal.ZERO;
		// 商户实际收到总金额(扣除手续费)
		BigDecimal bankActualAmount = BigDecimal.ZERO;
		// 商户总手续费
		BigDecimal bankFee = BigDecimal.ZERO;
		//差错记录数(异常订单数)
		Long mistakeNum = 0L;

		//根据对账日期获取成功的对账批次实体
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("billDate",billDateStr);
		paramMap.put("inStatus",BatchStatusEnum.SUCCESS.getCode());
		List<TbPayReconciliationCheckBatch> batchList = payReconciliationCheckBatchService.listByCondition(paramMap);
		if (batchList.isEmpty()) {
			logger.info("账单日期为：{} 没有成功的对账批次实体 " ,billDateStr);
			logger.info("[对账通知] ====通知结束====");
			return ;
		}else{
			//循环计算出金额
			for(TbPayReconciliationCheckBatch batch: batchList ){
				platTradeAmount = platTradeAmount.add(batch.getTradeAmount());
				platFee = platFee.add(batch.getFee());
				platTradeActualAmount = platTradeAmount.subtract(platFee);
				bankAmount = bankAmount.add(batch.getBankTradeAmount());
				bankFee = bankFee.add(batch.getBankFee());
				bankActualAmount = bankAmount.subtract(bankFee);
			}
		}

		//查询当天差错记录数
		mistakeNum = payReconciliationMistakeService.getMistakeNumByDate(nowDateStr);

		/**step 3 发送短信  **/
		//短信通知
		SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
		smsTemplateVo.setTemplateId(MessageNoticesTemplateEnums.RECONCILIATION_TEMPLATE.getCode());
		smsTemplateVo.setMobiles(Mobiles);
		//1.账单日期，2.平台总金额 3.平台总手续费 4.商户应收到金额  5.商户实际收到金额 6.商户总手续费 7.异常订单数
		String[] t = {billDateStr,platTradeAmount.toString(),platFee.toString(),bankAmount.toString()
				,bankActualAmount.toString(),bankFee.toString(),mistakeNum.toString()};
		smsTemplateVo.setContents(t);
		messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
		logger.info("[对账通知] 通知对账结果,Contents: {}", Arrays.toString(t));
		logger.info("[对账通知] ====通知结束==== ");
	}
}
