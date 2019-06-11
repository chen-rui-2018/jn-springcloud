package org.xxpay.dal.dao.mapper.generator.reconciliation;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationIdent;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationIdentCriteria;

public interface TbPayReconciliationIdentMapper {
    long countByExample(TbPayReconciliationIdentCriteria example);

    int deleteByExample(TbPayReconciliationIdentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPayReconciliationIdent record);

    int insertSelective(TbPayReconciliationIdent record);

    List<TbPayReconciliationIdent> selectByExample(TbPayReconciliationIdentCriteria example);

    TbPayReconciliationIdent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPayReconciliationIdent record, @Param("example") TbPayReconciliationIdentCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationIdent record, @Param("example") TbPayReconciliationIdentCriteria example);

    int updateByPrimaryKeySelective(TbPayReconciliationIdent record);

    int updateByPrimaryKey(TbPayReconciliationIdent record);
}