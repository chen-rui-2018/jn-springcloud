package org.xxpay.dal.dao.mapper;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;

import java.util.List;
import java.util.Map;

public interface PayReconciliationCheckBatchMapper {

    /**
     * 根据条件查询对账批次
     * @param paramMap
    * */
    List<TbPayReconciliationCheckBatch> listByCondition(Map paramMap);
}