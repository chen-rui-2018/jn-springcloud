package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchIncubatorType;
import com.jn.park.hatch.entity.TbHatchIncubatorTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchIncubatorTypeMapper {
    long countByExample(TbHatchIncubatorTypeCriteria example);

    int deleteByExample(TbHatchIncubatorTypeCriteria example);

    int deleteByPrimaryKey(String incubatorCode);

    int insert(TbHatchIncubatorType record);

    int insertSelective(TbHatchIncubatorType record);

    List<TbHatchIncubatorType> selectByExample(TbHatchIncubatorTypeCriteria example);

    TbHatchIncubatorType selectByPrimaryKey(String incubatorCode);

    int updateByExampleSelective(@Param("record") TbHatchIncubatorType record, @Param("example") TbHatchIncubatorTypeCriteria example);

    int updateByExample(@Param("record") TbHatchIncubatorType record, @Param("example") TbHatchIncubatorTypeCriteria example);

    int updateByPrimaryKeySelective(TbHatchIncubatorType record);

    int updateByPrimaryKey(TbHatchIncubatorType record);
}