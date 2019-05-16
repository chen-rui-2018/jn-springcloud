package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchIncubatorEnterprise;
import com.jn.park.hatch.entity.TbHatchIncubatorEnterpriseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchIncubatorEnterpriseMapper {
    long countByExample(TbHatchIncubatorEnterpriseCriteria example);

    int deleteByExample(TbHatchIncubatorEnterpriseCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbHatchIncubatorEnterprise record);

    int insertSelective(TbHatchIncubatorEnterprise record);

    List<TbHatchIncubatorEnterprise> selectByExample(TbHatchIncubatorEnterpriseCriteria example);

    TbHatchIncubatorEnterprise selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbHatchIncubatorEnterprise record, @Param("example") TbHatchIncubatorEnterpriseCriteria example);

    int updateByExample(@Param("record") TbHatchIncubatorEnterprise record, @Param("example") TbHatchIncubatorEnterpriseCriteria example);

    int updateByPrimaryKeySelective(TbHatchIncubatorEnterprise record);

    int updateByPrimaryKey(TbHatchIncubatorEnterprise record);
}