package com.jn.system.dao;

import com.jn.system.entity.TbSysPost;
import com.jn.system.entity.TbSysPostCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPostMapper {
    long countByExample(TbSysPostCriteria example);

    int deleteByExample(TbSysPostCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPost record);

    int insertSelective(TbSysPost record);

    List<TbSysPost> selectByExample(TbSysPostCriteria example);

    TbSysPost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPost record, @Param("example") TbSysPostCriteria example);

    int updateByExample(@Param("record") TbSysPost record, @Param("example") TbSysPostCriteria example);

    int updateByPrimaryKeySelective(TbSysPost record);

    int updateByPrimaryKey(TbSysPost record);
}