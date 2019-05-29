package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayBillItem;
import com.jn.park.pmpaybill.entity.TbPmPayBillItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPayBillItemMapper {
    long countByExample(TbPmPayBillItemCriteria example);

    int deleteByExample(TbPmPayBillItemCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPayBillItem record);

    int insertSelective(TbPmPayBillItem record);

    List<TbPmPayBillItem> selectByExample(TbPmPayBillItemCriteria example);

    TbPmPayBillItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPayBillItem record, @Param("example") TbPmPayBillItemCriteria example);

    int updateByExample(@Param("record") TbPmPayBillItem record, @Param("example") TbPmPayBillItemCriteria example);

    int updateByPrimaryKeySelective(TbPmPayBillItem record);

    int updateByPrimaryKey(TbPmPayBillItem record);
}