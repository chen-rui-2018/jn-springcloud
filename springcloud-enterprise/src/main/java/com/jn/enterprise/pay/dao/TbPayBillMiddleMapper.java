package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayBillMiddle;
import com.jn.enterprise.pay.entity.TbPayBillMiddleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayBillMiddleMapper {
    long countByExample(TbPayBillMiddleCriteria example);

    int deleteByExample(TbPayBillMiddleCriteria example);

    int deleteByPrimaryKey(String orderNumber);

    int insert(TbPayBillMiddle record);

    int insertSelective(TbPayBillMiddle record);

    List<TbPayBillMiddle> selectByExample(TbPayBillMiddleCriteria example);

    TbPayBillMiddle selectByPrimaryKey(String orderNumber);

    int updateByExampleSelective(@Param("record") TbPayBillMiddle record, @Param("example") TbPayBillMiddleCriteria example);

    int updateByExample(@Param("record") TbPayBillMiddle record, @Param("example") TbPayBillMiddleCriteria example);

    int updateByPrimaryKeySelective(TbPayBillMiddle record);

    int updateByPrimaryKey(TbPayBillMiddle record);
}