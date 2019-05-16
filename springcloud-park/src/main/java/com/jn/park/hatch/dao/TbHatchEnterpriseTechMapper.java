package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchEnterpriseTech;
import com.jn.park.hatch.entity.TbHatchEnterpriseTechCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchEnterpriseTechMapper {
    long countByExample(TbHatchEnterpriseTechCriteria example);

    int deleteByExample(TbHatchEnterpriseTechCriteria example);

    int deleteByPrimaryKey(String enterpriseTechId);

    int insert(TbHatchEnterpriseTech record);

    int insertSelective(TbHatchEnterpriseTech record);

    List<TbHatchEnterpriseTech> selectByExample(TbHatchEnterpriseTechCriteria example);

    TbHatchEnterpriseTech selectByPrimaryKey(String enterpriseTechId);

    int updateByExampleSelective(@Param("record") TbHatchEnterpriseTech record, @Param("example") TbHatchEnterpriseTechCriteria example);

    int updateByExample(@Param("record") TbHatchEnterpriseTech record, @Param("example") TbHatchEnterpriseTechCriteria example);

    int updateByPrimaryKeySelective(TbHatchEnterpriseTech record);

    int updateByPrimaryKey(TbHatchEnterpriseTech record);
}