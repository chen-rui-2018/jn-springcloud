package org.xxpay.dal.dao.mapper;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;

import java.util.List;

public interface PayReconciliationMistakeScratchPoolMapper {

    /**
     * 根据最大账期查询
     * @param maxDete 最大账期
    * */
    List<TbPayReconciliationMistakeScratchPool> listByMaxDate(String maxDete);


}