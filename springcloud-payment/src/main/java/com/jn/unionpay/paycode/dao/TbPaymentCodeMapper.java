package com.jn.unionpay.paycode.dao;

import com.jn.unionpay.paycode.entity.TbPaymentCode;
import com.jn.unionpay.paycode.entity.TbPaymentCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaymentCodeMapper {
    long countByExample(TbPaymentCodeCriteria example);

    int deleteByExample(TbPaymentCodeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPaymentCode record);

    int insertSelective(TbPaymentCode record);

    List<TbPaymentCode> selectByExample(TbPaymentCodeCriteria example);

    TbPaymentCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPaymentCode record, @Param("example") TbPaymentCodeCriteria example);

    int updateByExample(@Param("record") TbPaymentCode record, @Param("example") TbPaymentCodeCriteria example);

    int updateByPrimaryKeySelective(TbPaymentCode record);

    int updateByPrimaryKey(TbPaymentCode record);
}