package com.jn.reconciliation.service;

import com.jn.reconciliation.ReconciliationTask;
import com.jn.reconciliation.biz.*;
import com.jn.reconciliation.enums.BatchStatusEnum;
import com.jn.reconciliation.utils.DateUtil;
import com.jn.reconciliation.vo.ReconciliationEntityVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xxpay.common.util.MySeq;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReconciliationTest {

    @Autowired
    private ReconciliationTask  reconciliationTask;


    private static final Log logger = LogFactory.getLog(ReconciliationTest.class);

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

    /**
     * 对账功能
    * */
    @Test
    public void reconciliationTaskTest() {

        //reconciliationTask.taskRun();

        //日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取需要对账的对账单时间(前一天时间)
        Date billDate = DateUtil.addDay(new Date(), -2);
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
