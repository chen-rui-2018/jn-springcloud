package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayBill;
import com.jn.enterprise.pay.entity.TbPayBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayBillMapper {
    long countByExample(TbPayBillCriteria example);

    int deleteByExample(TbPayBillCriteria example);

    int deleteByPrimaryKey(String billId);

    int insert(TbPayBill record);

    int insertSelective(TbPayBill record);

    List<TbPayBill> selectByExample(TbPayBillCriteria example);

    TbPayBill selectByPrimaryKey(String billId);

    int updateByExampleSelective(@Param("record") TbPayBill record, @Param("example") TbPayBillCriteria example);

    int updateByExample(@Param("record") TbPayBill record, @Param("example") TbPayBillCriteria example);

    int updateByPrimaryKeySelective(TbPayBill record);

    int updateByPrimaryKey(TbPayBill record);
}