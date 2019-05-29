package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayBillItemPmList;
import com.jn.park.pmpaybill.entity.TbPmPayBillItemPmListCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPayBillItemPmListMapper {
    long countByExample(TbPmPayBillItemPmListCriteria example);

    int deleteByExample(TbPmPayBillItemPmListCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPayBillItemPmList record);

    int insertSelective(TbPmPayBillItemPmList record);

    List<TbPmPayBillItemPmList> selectByExample(TbPmPayBillItemPmListCriteria example);

    TbPmPayBillItemPmList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPayBillItemPmList record, @Param("example") TbPmPayBillItemPmListCriteria example);

    int updateByExample(@Param("record") TbPmPayBillItemPmList record, @Param("example") TbPmPayBillItemPmListCriteria example);

    int updateByPrimaryKeySelective(TbPmPayBillItemPmList record);

    int updateByPrimaryKey(TbPmPayBillItemPmList record);
}