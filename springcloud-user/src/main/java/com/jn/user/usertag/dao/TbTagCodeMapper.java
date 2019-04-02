package com.jn.user.usertag.dao;

import com.jn.user.usertag.entity.TbTagCode;
import com.jn.user.usertag.entity.TbTagCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTagCodeMapper {
    long countByExample(TbTagCodeCriteria example);

    int deleteByExample(TbTagCodeCriteria example);

    int deleteByPrimaryKey(String tagId);

    int insert(TbTagCode record);

    int insertSelective(TbTagCode record);

    List<TbTagCode> selectByExample(TbTagCodeCriteria example);

    TbTagCode selectByPrimaryKey(String tagId);

    int updateByExampleSelective(@Param("record") TbTagCode record, @Param("example") TbTagCodeCriteria example);

    int updateByExample(@Param("record") TbTagCode record, @Param("example") TbTagCodeCriteria example);

    int updateByPrimaryKeySelective(TbTagCode record);

    int updateByPrimaryKey(TbTagCode record);
}