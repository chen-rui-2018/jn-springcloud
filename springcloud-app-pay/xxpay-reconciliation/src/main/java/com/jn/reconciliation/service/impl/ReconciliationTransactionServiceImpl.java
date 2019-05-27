package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.enums.BatchStatusEnum;
import com.jn.reconciliation.service.PayReconciliationCheckBatchService;
import com.jn.reconciliation.service.PayReconciliationMistakeScratchPoolService;
import com.jn.reconciliation.service.PayReconciliationMistakeService;
import com.jn.reconciliation.service.ReconciliationTransactionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;

import java.util.List;

/**
 * @ClassName：对账数据事务一致性service
 * 
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/21 11:34
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ReconciliationTransactionServiceImpl implements ReconciliationTransactionService {

    private static final Log logger = LogFactory.getLog(ReconciliationTransactionServiceImpl.class);

    @Autowired
    private PayReconciliationCheckBatchService payReconciliationCheckBatchService;
    @Autowired
    private PayReconciliationMistakeService payReconciliationMistakeService;
    @Autowired
    private PayReconciliationMistakeScratchPoolService payReconciliationMistakeScratchPoolService;


    /**
     * 保存
     * @param batch 对账批次
     * @param mistakeList 差错数据
     * @param insertScreatchRecordList 需要保存的错误暂存池
     * @param removeScreatchRecordList 需要清理的错误暂存池
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveDatasaveDate(TbPayReconciliationCheckBatch batch
            , List<TbPayReconciliationMistake> mistakeList
            , List<TbPayReconciliationMistakeScratchPool> insertScreatchRecordList
            , List<TbPayReconciliationMistakeScratchPool> removeScreatchRecordList) {
        logger.info("========>  对完数据后业务数据处理开始=========>");

        logger.info("===> step1:保存批次记录====");
        if (batch.getStatus() == null) {
            batch.setStatus(BatchStatusEnum.SUCCESS.name());
        }
        payReconciliationCheckBatchService.saveData(batch);

        logger.info("===> step2:保存差错记录====总共[" + mistakeList.size() + "]条");
        payReconciliationMistakeService.saveListDate(mistakeList);

        logger.info("===> step3:保存记录到缓存池中====总共[" + insertScreatchRecordList.size() + "]条");
        payReconciliationMistakeScratchPoolService.savaListDate(insertScreatchRecordList);

        logger.info("===> step4:从缓存池中删除已匹配记录====总共[" + removeScreatchRecordList.size() + "]条");
        payReconciliationMistakeScratchPoolService.deleteFromPool(removeScreatchRecordList);

        logger.info("<========  对完数据后业务数据处理结束<=========");
    }

    /**
     * 移除暂存池数据
     * @param list  差错暂存池
     * @param mistakeList 差错池
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeDateFromPool(List<TbPayReconciliationMistakeScratchPool> list
            , List<TbPayReconciliationMistake > mistakeList) {
        logger.info("========>  清理缓冲池中没有对账的数据，记录差错=========>");

        logger.info("===> step1:保存差错记录====总共[" + mistakeList.size() + "]条");
        payReconciliationMistakeService.saveListDate(mistakeList);

        logger.info("===> step2:从缓存池中删除已匹配记录====总共[" + list.size() + "]条");
        payReconciliationMistakeScratchPoolService.deleteFromPool(list);

        logger.info("<========  清理缓冲池中没有对账的数据，记录差错结束<=========");
    }

}
