package org.xxpay.dal.dao.mapper.generator.reconciliation;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterfaceCriteria;

public interface TbPayReconciliationInterfaceMapper {
    long countByExample(TbPayReconciliationInterfaceCriteria example);

    int deleteByExample(TbPayReconciliationInterfaceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPayReconciliationInterface record);

    int insertSelective(TbPayReconciliationInterface record);

    List<TbPayReconciliationInterface> selectByExample(TbPayReconciliationInterfaceCriteria example);

    TbPayReconciliationInterface selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPayReconciliationInterface record, @Param("example") TbPayReconciliationInterfaceCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationInterface record, @Param("example") TbPayReconciliationInterfaceCriteria example);

    int updateByPrimaryKeySelective(TbPayReconciliationInterface record);

    int updateByPrimaryKey(TbPayReconciliationInterface record);
}