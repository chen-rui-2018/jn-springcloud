package com.jn.portals.activity.dao;

import com.jn.portals.activity.entity.TbActivityFile;
import com.jn.portals.activity.entity.TbActivityFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbActivityFileMapper {
    long countByExample(TbActivityFileCriteria example);

    int deleteByExample(TbActivityFileCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbActivityFile record);

    int insertSelective(TbActivityFile record);

    List<TbActivityFile> selectByExample(TbActivityFileCriteria example);

    TbActivityFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbActivityFile record, @Param("example") TbActivityFileCriteria example);

    int updateByExample(@Param("record") TbActivityFile record, @Param("example") TbActivityFileCriteria example);

    int updateByPrimaryKeySelective(TbActivityFile record);

    int updateByPrimaryKey(TbActivityFile record);
}