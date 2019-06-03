package org.xxpay.dal.dao.mapper.generator.reconciliation;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPoolCriteria;

public interface TbPayReconciliationMistakeScratchPoolMapper {
    long countByExample(TbPayReconciliationMistakeScratchPoolCriteria example);

    int deleteByExample(TbPayReconciliationMistakeScratchPoolCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPayReconciliationMistakeScratchPool record);

    int insertSelective(TbPayReconciliationMistakeScratchPool record);

    List<TbPayReconciliationMistakeScratchPool> selectByExample(TbPayReconciliationMistakeScratchPoolCriteria example);

    TbPayReconciliationMistakeScratchPool selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPayReconciliationMistakeScratchPool record, @Param("example") TbPayReconciliationMistakeScratchPoolCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationMistakeScratchPool record, @Param("example") TbPayReconciliationMistakeScratchPoolCriteria example);

    int updateByPrimaryKeySelective(TbPayReconciliationMistakeScratchPool record);

    int updateByPrimaryKey(TbPayReconciliationMistakeScratchPool record);
}