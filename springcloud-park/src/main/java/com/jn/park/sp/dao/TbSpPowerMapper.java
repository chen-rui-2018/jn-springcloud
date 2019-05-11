package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpPower;
import com.jn.park.sp.entity.TbSpPowerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpPowerMapper {
    long countByExample(TbSpPowerCriteria example);

    int deleteByExample(TbSpPowerCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSpPower record);

    int insertSelective(TbSpPower record);

    List<TbSpPower> selectByExample(TbSpPowerCriteria example);

    TbSpPower selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSpPower record, @Param("example") TbSpPowerCriteria example);

    int updateByExample(@Param("record") TbSpPower record, @Param("example") TbSpPowerCriteria example);

    int updateByPrimaryKeySelective(TbSpPower record);

    int updateByPrimaryKey(TbSpPower record);
}