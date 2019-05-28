package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayBill;
import com.jn.park.pmpaybill.entity.TbPmPayBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPayBillMapper {
    long countByExample(TbPmPayBillCriteria example);

    int deleteByExample(TbPmPayBillCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPayBill record);

    int insertSelective(TbPmPayBill record);

    List<TbPmPayBill> selectByExample(TbPmPayBillCriteria example);

    TbPmPayBill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPayBill record, @Param("example") TbPmPayBillCriteria example);

    int updateByExample(@Param("record") TbPmPayBill record, @Param("example") TbPmPayBillCriteria example);

    int updateByPrimaryKeySelective(TbPmPayBill record);

    int updateByPrimaryKey(TbPmPayBill record);
}