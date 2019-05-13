package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayCheckReminder;
import com.jn.enterprise.pay.entity.TbPayCheckReminderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayCheckReminderMapper {
    long countByExample(TbPayCheckReminderCriteria example);

    int deleteByExample(TbPayCheckReminderCriteria example);

    int deleteByPrimaryKey(String paymentId);

    int insert(TbPayCheckReminder record);

    int insertSelective(TbPayCheckReminder record);

    List<TbPayCheckReminder> selectByExample(TbPayCheckReminderCriteria example);

    TbPayCheckReminder selectByPrimaryKey(String paymentId);

    int updateByExampleSelective(@Param("record") TbPayCheckReminder record, @Param("example") TbPayCheckReminderCriteria example);

    int updateByExample(@Param("record") TbPayCheckReminder record, @Param("example") TbPayCheckReminderCriteria example);

    int updateByPrimaryKeySelective(TbPayCheckReminder record);

    int updateByPrimaryKey(TbPayCheckReminder record);
}