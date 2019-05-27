package org.xxpay.dal.dao.mapper.generator.reconciliation;

import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPoolCriteria;

import java.util.List;

public interface TbPayReconciliationMistakeScratchPoolMapper {
    long countByExample(TbPayReconciliationMistakeScratchPoolCriteria example);

    int deleteByExample(TbPayReconciliationMistakeScratchPoolCriteria example);

    int insert(TbPayReconciliationMistakeScratchPool record);

    int insertSelective(TbPayReconciliationMistakeScratchPool record);

    List<TbPayReconciliationMistakeScratchPool> selectByExample(TbPayReconciliationMistakeScratchPoolCriteria example);

    int updateByExampleSelective(@Param("record") TbPayReconciliationMistakeScratchPool record, @Param("example") TbPayReconciliationMistakeScratchPoolCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationMistakeScratchPool record, @Param("example") TbPayReconciliationMistakeScratchPoolCriteria example);
}