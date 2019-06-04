package org.xxpay.dal.dao.mapper.generator.reconciliation;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationNoticeUser;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationNoticeUserCriteria;

public interface TbPayReconciliationNoticeUserMapper {
    long countByExample(TbPayReconciliationNoticeUserCriteria example);

    int deleteByExample(TbPayReconciliationNoticeUserCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPayReconciliationNoticeUser record);

    int insertSelective(TbPayReconciliationNoticeUser record);

    List<TbPayReconciliationNoticeUser> selectByExample(TbPayReconciliationNoticeUserCriteria example);

    TbPayReconciliationNoticeUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPayReconciliationNoticeUser record, @Param("example") TbPayReconciliationNoticeUserCriteria example);

    int updateByExample(@Param("record") TbPayReconciliationNoticeUser record, @Param("example") TbPayReconciliationNoticeUserCriteria example);

    int updateByPrimaryKeySelective(TbPayReconciliationNoticeUser record);

    int updateByPrimaryKey(TbPayReconciliationNoticeUser record);
}