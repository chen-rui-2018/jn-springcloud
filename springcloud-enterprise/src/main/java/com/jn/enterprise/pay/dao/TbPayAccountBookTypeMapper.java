package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayAccountBookType;
import com.jn.enterprise.pay.entity.TbPayAccountBookTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayAccountBookTypeMapper {
    long countByExample(TbPayAccountBookTypeCriteria example);

    int deleteByExample(TbPayAccountBookTypeCriteria example);

    int deleteByPrimaryKey(String acBookType);

    int insert(TbPayAccountBookType record);

    int insertSelective(TbPayAccountBookType record);

    List<TbPayAccountBookType> selectByExample(TbPayAccountBookTypeCriteria example);

    TbPayAccountBookType selectByPrimaryKey(String acBookType);

    int updateByExampleSelective(@Param("record") TbPayAccountBookType record, @Param("example") TbPayAccountBookTypeCriteria example);

    int updateByExample(@Param("record") TbPayAccountBookType record, @Param("example") TbPayAccountBookTypeCriteria example);

    int updateByPrimaryKeySelective(TbPayAccountBookType record);

    int updateByPrimaryKey(TbPayAccountBookType record);
}