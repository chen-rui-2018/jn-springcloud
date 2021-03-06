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
package com.jn.reconciliation;

import com.jn.reconciliation.biz.*;
import com.jn.reconciliation.enums.BatchStatusEnum;
import com.jn.reconciliation.service.PayReconciliationCheckBatchService;
import com.jn.reconciliation.service.ReconciliationInterfaceService;
import com.jn.reconciliation.service.impl.ReconciliationInterface;
import com.jn.reconciliation.utils.DateUtil;
import com.jn.reconciliation.vo.ReconciliationEntityVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xxpay.common.util.MySeq;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName：对账处理(包括下载对账文件、转换对账文件、对账) .
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class ReconciliationTask {

	private static final Log logger = LogFactory.getLog(ReconciliationTask.class);

	@Autowired
	private ReconciliationFileDownBiz fileDownBiz;
	@Autowired
	private ReconciliationFileParserBiz parserBiz;
	@Autowired
	private ReconciliationCheckBiz checkBiz;
	@Autowired
	private ReconciliationValidateBiz validateBiz;
	@Autowired
	private PayReconciliationCheckBatchService batchService;
	@Autowired
	private ReconciliationNoticeBiz reconciliationNoticeBiz;
	@Autowired
	private ReconciliationInterfaceService reconciliationInterfaceService;


	@Scheduled(cron = "0 15 10 * * ?")
	public void taskRun() {
		//日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 获取需要对账的对账单时间(前一天时间)
		Date billDate = DateUtil.addDay(new Date(), -1);
		//是否发送对账通知
		boolean sendMsg = false;
		try {


			@SuppressWarnings("rawtypes")
			// 获取全部有效的对账接口
			List<TbPayReconciliationInterface> reconciliationInterList  = reconciliationInterfaceService.getEffectiveList();

			// 根据不同的渠道发起对账
			for (int num = 0; num < reconciliationInterList.size(); num++) {
				// 判断接口是否正确
				TbPayReconciliationInterface reconciliationInter = (TbPayReconciliationInterface) reconciliationInterList.get(num);
				if (reconciliationInter == null) {
					logger.info("对账接口信息" + reconciliationInter + "为空");
					continue;
				}

				// 获取对账渠道
				String interfaceCode = reconciliationInter.getInterfaceCode();

				/** step1:判断是否对过账 **/
				TbPayReconciliationCheckBatch batch = new TbPayReconciliationCheckBatch();
				Boolean checked = validateBiz.isChecked(interfaceCode, billDate);
				if (checked) {
					logger.info("账单日[" + sdf.format(billDate) + "],支付方式[" + interfaceCode + "],已经对过账，不能再次发起自动对账。");
					continue;
				}
				// 创建对账批次
				batch.setCreater("reconciliationSystem");
				batch.setCreateTime(new Date());
				batch.setBillDate(billDate);
				batch.setBatchNo(MySeq.getReconciliation());
				batch.setBankType(interfaceCode);

				/** step2:对账文件下载 **/
				File file = null;
				try {
					logger.info("ReconciliationFileDownBiz,对账文件下载开始");
					file = fileDownBiz.downReconciliationFile(reconciliationInter, billDate);
					if (file == null) {
						continue;
					}
					logger.info("对账文件下载结束");
				} catch (Exception e) {
					logger.error("对账文件下载异常:", e);
					batch.setStatus(BatchStatusEnum.FAIL.getCode());
					batch.setRemark("对账文件下载异常");
					batchService.saveData(batch);
					continue;
				}

				/** step3:解析对账文件 **/
				List<ReconciliationEntityVo> bankList = null;
				try {
					logger.info("=ReconciliationFileParserBiz=>对账文件解析开始>>>");

					// 解析文件
					bankList = parserBiz.parser(batch, file, billDate, interfaceCode);
					// 如果下载文件异常，退出
					if (BatchStatusEnum.ERROR.getCode().equals(batch.getStatus())) {
						continue;
					}
					logger.info("对账文件解析结束");
				} catch (Exception e) {
					logger.error("对账文件解析异常:", e);
					batch.setStatus(BatchStatusEnum.FAIL.getCode());
					batch.setRemark("对账文件解析异常");
					batchService.saveData(batch);
					continue;
				}

				/** step4:对账流程 **/
				try {
					checkBiz.check(bankList, interfaceCode, batch);
				} catch (Exception e) {
					logger.error("对账异常:", e);
					batch.setStatus(BatchStatusEnum.FAIL.getCode());
					batch.setRemark("对账异常");
					batchService.saveData(batch);
					continue;
				}

				//只要有一次 对账渠道流程没异常则发送短信,邮箱通知
				sendMsg = true;
			}

			/** step5:清理缓冲池 **/
			// 如果缓冲池中有三天前的数据就清理掉并记录差错
			validateBiz.validateScratchPool();

			/** step6:发送短信通知 **/
			if(sendMsg){
				reconciliationNoticeBiz.messageNotice(sdf.format(billDate));
			}


		} catch (Exception e) {
			logger.error("对账流程异常  error:", e);
		}

	}
}
