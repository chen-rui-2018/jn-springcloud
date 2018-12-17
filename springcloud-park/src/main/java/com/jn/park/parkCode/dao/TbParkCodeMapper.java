package com.jn.park.parkCode.dao;

import com.jn.park.parkCode.entity.TbParkCode;
import com.jn.park.parkCode.entity.TbParkCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkCodeMapper {
    long countByExample(TbParkCodeCriteria example);

    int deleteByExample(TbParkCodeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbParkCode record);

    int insertSelective(TbParkCode record);

    List<TbParkCode> selectByExample(TbParkCodeCriteria example);

    TbParkCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbParkCode record, @Param("example") TbParkCodeCriteria example);

    int updateByExample(@Param("record") TbParkCode record, @Param("example") TbParkCodeCriteria example);

    int updateByPrimaryKeySelective(TbParkCode record);

    int updateByPrimaryKey(TbParkCode record);
}