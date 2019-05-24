package com.jn.unionpay.paybill.dao;

import com.jn.unionpay.paybill.entity.TbPaymentPayLog;
import com.jn.unionpay.paybill.entity.TbPaymentPayLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaymentPayLogMapper {
    long countByExample(TbPaymentPayLogCriteria example);

    int deleteByExample(TbPaymentPayLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPaymentPayLog record);

    int insertSelective(TbPaymentPayLog record);

    List<TbPaymentPayLog> selectByExample(TbPaymentPayLogCriteria example);

    TbPaymentPayLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPaymentPayLog record, @Param("example") TbPaymentPayLogCriteria example);

    int updateByExample(@Param("record") TbPaymentPayLog record, @Param("example") TbPaymentPayLogCriteria example);

    int updateByPrimaryKeySelective(TbPaymentPayLog record);

    int updateByPrimaryKey(TbPaymentPayLog record);
}