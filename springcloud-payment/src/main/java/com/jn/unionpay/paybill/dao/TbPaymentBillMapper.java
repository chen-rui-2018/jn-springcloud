package com.jn.unionpay.paybill.dao;

import com.jn.unionpay.paybill.entity.TbPaymentBill;
import com.jn.unionpay.paybill.entity.TbPaymentBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaymentBillMapper {
    long countByExample(TbPaymentBillCriteria example);

    int deleteByExample(TbPaymentBillCriteria example);

    int deleteByPrimaryKey(String billId);

    int insert(TbPaymentBill record);

    int insertSelective(TbPaymentBill record);

    List<TbPaymentBill> selectByExample(TbPaymentBillCriteria example);

    TbPaymentBill selectByPrimaryKey(String billId);

    int updateByExampleSelective(@Param("record") TbPaymentBill record, @Param("example") TbPaymentBillCriteria example);

    int updateByExample(@Param("record") TbPaymentBill record, @Param("example") TbPaymentBillCriteria example);

    int updateByPrimaryKeySelective(TbPaymentBill record);

    int updateByPrimaryKey(TbPaymentBill record);
}