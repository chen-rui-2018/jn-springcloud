package com.jn.park.index.dao;

import com.jn.park.index.entity.TbImportantNews;
import com.jn.park.index.entity.TbImportantNewsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImportantNewsMapper {
    long countByExample(TbImportantNewsCriteria example);

    int deleteByExample(TbImportantNewsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbImportantNews record);

    int insertSelective(TbImportantNews record);

    List<TbImportantNews> selectByExample(TbImportantNewsCriteria example);

    TbImportantNews selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbImportantNews record, @Param("example") TbImportantNewsCriteria example);

    int updateByExample(@Param("record") TbImportantNews record, @Param("example") TbImportantNewsCriteria example);

    int updateByPrimaryKeySelective(TbImportantNews record);

    int updateByPrimaryKey(TbImportantNews record);
}