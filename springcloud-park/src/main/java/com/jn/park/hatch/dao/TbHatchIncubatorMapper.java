package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchIncubator;
import com.jn.park.hatch.entity.TbHatchIncubatorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchIncubatorMapper {
    long countByExample(TbHatchIncubatorCriteria example);

    int deleteByExample(TbHatchIncubatorCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbHatchIncubator record);

    int insertSelective(TbHatchIncubator record);

    List<TbHatchIncubator> selectByExample(TbHatchIncubatorCriteria example);

    TbHatchIncubator selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbHatchIncubator record, @Param("example") TbHatchIncubatorCriteria example);

    int updateByExample(@Param("record") TbHatchIncubator record, @Param("example") TbHatchIncubatorCriteria example);

    int updateByPrimaryKeySelective(TbHatchIncubator record);

    int updateByPrimaryKey(TbHatchIncubator record);
}