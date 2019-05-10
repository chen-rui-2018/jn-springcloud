package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayAccountBookMoneyRecord;
import com.jn.enterprise.pay.entity.TbPayAccountBookMoneyRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayAccountBookMoneyRecordMapper {
    long countByExample(TbPayAccountBookMoneyRecordCriteria example);

    int deleteByExample(TbPayAccountBookMoneyRecordCriteria example);

    int deleteByPrimaryKey(String deductionId);

    int insert(TbPayAccountBookMoneyRecord record);

    int insertSelective(TbPayAccountBookMoneyRecord record);

    List<TbPayAccountBookMoneyRecord> selectByExample(TbPayAccountBookMoneyRecordCriteria example);

    TbPayAccountBookMoneyRecord selectByPrimaryKey(String deductionId);

    int updateByExampleSelective(@Param("record") TbPayAccountBookMoneyRecord record, @Param("example") TbPayAccountBookMoneyRecordCriteria example);

    int updateByExample(@Param("record") TbPayAccountBookMoneyRecord record, @Param("example") TbPayAccountBookMoneyRecordCriteria example);

    int updateByPrimaryKeySelective(TbPayAccountBookMoneyRecord record);

    int updateByPrimaryKey(TbPayAccountBookMoneyRecord record);
}