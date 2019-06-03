package org.xxpay.dal.dao.mapper.generator.reconciliation;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatchCriteria;

public interface TbPayReconciliationCheckBatchMapper {
    long countByExample(TbPayReconciliationCheckBatchCriteria example);

    int deleteByExample(TbPayReconciliationCheckBatchCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPayReconciliationCheckBatch record);

    int insertSelective(TbPayReconciliationCheckBatch record);

    List<TbPayReconciliationCheckBatch> selectByExample(TbPayReconciliationCheckBatchCriteria example);

    TbPayReconciliationCheckBatch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPayReconciliationCheckBatch record, @Param("example") TbPayReconciliationCheckBatchCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationCheckBatch record, @Param("example") TbPayReconciliationCheckBatchCriteria example);

    int updateByPrimaryKeySelective(TbPayReconciliationCheckBatch record);

    int updateByPrimaryKey(TbPayReconciliationCheckBatch record);
}