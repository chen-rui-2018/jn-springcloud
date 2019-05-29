package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;

import java.util.List;

/**
 * @ClassName：对账数据事务一致性service.
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/21 11:12
 * @Version： v1.0
 * @Modified By:
 */
public interface ReconciliationTransactionService {

    /**
     * 保存
     * @param batch 对账批次
     * @param mistakeList 差错数据
     * @param insertScreatchRecordList 需要保存的错误暂存池
     * @param removeScreatchRecordList 需要清理的错误暂存池
     */
    void saveDatasaveDate(TbPayReconciliationCheckBatch batch
            , List<TbPayReconciliationMistake> mistakeList
            , List<TbPayReconciliationMistakeScratchPool> insertScreatchRecordList
            , List<TbPayReconciliationMistakeScratchPool> removeScreatchRecordList);

    /**
     * 移除暂存池数据
     * @param list  差错暂存池
     * @param mistakeList 差错池
     */
    void removeDateFromPool(List<TbPayReconciliationMistakeScratchPool> list
            , List<TbPayReconciliationMistake > mistakeList);


}
