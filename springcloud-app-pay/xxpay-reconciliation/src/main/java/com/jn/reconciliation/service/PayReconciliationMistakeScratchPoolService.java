package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;

import java.util.List;

/**
 * @ClassName：对账暂存池接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 21:13
 * @Version： v1.0
 * @Modified By:
 */
public interface PayReconciliationMistakeScratchPoolService {


    /**
     * 批量保存记录
     *
     * @param scratchPoolList
     */
     void savaListDate(List<TbPayReconciliationMistakeScratchPool> scratchPoolList);

    /**
     * 根据最大账期查询暂存池信息
     *
     * @param maxDate 最大账期
     */
     List<TbPayReconciliationMistakeScratchPool> listByMaxDate(String maxDate);

    /**
     * 从缓冲池中删除数据
     *
     * @param scratchPoolList
     */
    void deleteFromPool(List<TbPayReconciliationMistakeScratchPool> scratchPoolList);

    /**
     * 查询出缓存池中所有的数据
     *
     * @return
     */
    List<TbPayReconciliationMistakeScratchPool> listScratchPoolRecord();

}
