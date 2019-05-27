package org.xxpay.dal.dao.mapper.generator.reconciliation;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeCriteria;

public interface TbPayReconciliationMistakeMapper {
    long countByExample(TbPayReconciliationMistakeCriteria example);

    int deleteByExample(TbPayReconciliationMistakeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPayReconciliationMistake record);

    int insertSelective(TbPayReconciliationMistake record);

    List<TbPayReconciliationMistake> selectByExample(TbPayReconciliationMistakeCriteria example);

    TbPayReconciliationMistake selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPayReconciliationMistake record, @Param("example") TbPayReconciliationMistakeCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationMistake record, @Param("example") TbPayReconciliationMistakeCriteria example);

    int updateByPrimaryKeySelective(TbPayReconciliationMistake record);

    int updateByPrimaryKey(TbPayReconciliationMistake record);
}