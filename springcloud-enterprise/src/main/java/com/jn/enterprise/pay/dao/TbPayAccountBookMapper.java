package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayAccountBook;
import com.jn.enterprise.pay.entity.TbPayAccountBookCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayAccountBookMapper {
    long countByExample(TbPayAccountBookCriteria example);

    int deleteByExample(TbPayAccountBookCriteria example);

    int deleteByPrimaryKey(String acBookId);

    int insert(TbPayAccountBook record);

    int insertSelective(TbPayAccountBook record);

    List<TbPayAccountBook> selectByExample(TbPayAccountBookCriteria example);

    TbPayAccountBook selectByPrimaryKey(String acBookId);

    int updateByExampleSelective(@Param("record") TbPayAccountBook record, @Param("example") TbPayAccountBookCriteria example);

    int updateByExample(@Param("record") TbPayAccountBook record, @Param("example") TbPayAccountBookCriteria example);

    int updateByPrimaryKeySelective(TbPayAccountBook record);

    int updateByPrimaryKey(TbPayAccountBook record);
}