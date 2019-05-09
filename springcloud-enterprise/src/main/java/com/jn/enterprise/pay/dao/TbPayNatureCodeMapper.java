package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayNatureCode;
import com.jn.enterprise.pay.entity.TbPayNatureCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayNatureCodeMapper {
    long countByExample(TbPayNatureCodeCriteria example);

    int deleteByExample(TbPayNatureCodeCriteria example);

    int deleteByPrimaryKey(String natureCode);

    int insert(TbPayNatureCode record);

    int insertSelective(TbPayNatureCode record);

    List<TbPayNatureCode> selectByExample(TbPayNatureCodeCriteria example);

    TbPayNatureCode selectByPrimaryKey(String natureCode);

    int updateByExampleSelective(@Param("record") TbPayNatureCode record, @Param("example") TbPayNatureCodeCriteria example);

    int updateByExample(@Param("record") TbPayNatureCode record, @Param("example") TbPayNatureCodeCriteria example);

    int updateByPrimaryKeySelective(TbPayNatureCode record);

    int updateByPrimaryKey(TbPayNatureCode record);
}