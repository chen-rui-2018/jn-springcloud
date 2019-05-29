package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;

import java.util.List;
import java.util.Map;

/**
 * @ClassName：对账批次接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 21:13
 * @Version： v1.0
 * @Modified By:
 */
public interface PayReconciliationCheckBatchService {

    /**
     * 保存
     * @param reconciliationBatch  对账批次实体类
     */
    void saveData(TbPayReconciliationCheckBatch reconciliationBatch);


    /**
     * 根据条件查询实体
     *
     * @param paramMap
     */
     List<TbPayReconciliationCheckBatch> listByCondition(Map<String, Object> paramMap);
}
