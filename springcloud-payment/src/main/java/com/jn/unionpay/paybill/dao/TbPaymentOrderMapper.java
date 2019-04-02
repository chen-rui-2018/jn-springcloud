package com.jn.unionpay.paybill.dao;

import com.jn.unionpay.paybill.entity.TbPaymentOrder;
import com.jn.unionpay.paybill.entity.TbPaymentOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaymentOrderMapper {
    long countByExample(TbPaymentOrderCriteria example);

    int deleteByExample(TbPaymentOrderCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPaymentOrder record);

    int insertSelective(TbPaymentOrder record);

    List<TbPaymentOrder> selectByExample(TbPaymentOrderCriteria example);

    TbPaymentOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPaymentOrder record, @Param("example") TbPaymentOrderCriteria example);

    int updateByExample(@Param("record") TbPaymentOrder record, @Param("example") TbPaymentOrderCriteria example);

    int updateByPrimaryKeySelective(TbPaymentOrder record);

    int updateByPrimaryKey(TbPaymentOrder record);
}