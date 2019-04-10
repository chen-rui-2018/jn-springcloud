package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpPowerBusi;
import com.jn.park.sp.entity.TbSpPowerBusiCriteria;
import com.jn.park.sp.entity.TbSpPowerBusiWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpPowerBusiMapper {
    long countByExample(TbSpPowerBusiCriteria example);

    int deleteByExample(TbSpPowerBusiCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSpPowerBusiWithBLOBs record);

    int insertSelective(TbSpPowerBusiWithBLOBs record);

    List<TbSpPowerBusiWithBLOBs> selectByExampleWithBLOBs(TbSpPowerBusiCriteria example);

    List<TbSpPowerBusi> selectByExample(TbSpPowerBusiCriteria example);

    TbSpPowerBusiWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSpPowerBusiWithBLOBs record, @Param("example") TbSpPowerBusiCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbSpPowerBusiWithBLOBs record, @Param("example") TbSpPowerBusiCriteria example);

    int updateByExample(@Param("record") TbSpPowerBusi record, @Param("example") TbSpPowerBusiCriteria example);

    int updateByPrimaryKeySelective(TbSpPowerBusiWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbSpPowerBusiWithBLOBs record);

    int updateByPrimaryKey(TbSpPowerBusi record);
}