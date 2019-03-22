package com.jn.unionpay.payremind.dao;

import com.jn.unionpay.payremind.entity.TbPaymentRemind;
import com.jn.unionpay.payremind.entity.TbPaymentRemindCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaymentRemindMapper {
    long countByExample(TbPaymentRemindCriteria example);

    int deleteByExample(TbPaymentRemindCriteria example);

    int deleteByPrimaryKey(String remindId);

    int insert(TbPaymentRemind record);

    int insertSelective(TbPaymentRemind record);

    List<TbPaymentRemind> selectByExample(TbPaymentRemindCriteria example);

    TbPaymentRemind selectByPrimaryKey(String remindId);

    int updateByExampleSelective(@Param("record") TbPaymentRemind record, @Param("example") TbPaymentRemindCriteria example);

    int updateByExample(@Param("record") TbPaymentRemind record, @Param("example") TbPaymentRemindCriteria example);

    int updateByPrimaryKeySelective(TbPaymentRemind record);

    int updateByPrimaryKey(TbPaymentRemind record);
}