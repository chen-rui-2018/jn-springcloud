package com.jn.park.park.dao;

import com.jn.park.park.entity.TbPark;
import com.jn.park.park.entity.TbParkCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkMapper {
    long countByExample(TbParkCriteria example);

    int deleteByExample(TbParkCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPark record);

    int insertSelective(TbPark record);

    List<TbPark> selectByExampleWithBLOBs(TbParkCriteria example);

    List<TbPark> selectByExample(TbParkCriteria example);

    TbPark selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPark record, @Param("example") TbParkCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPark record, @Param("example") TbParkCriteria example);

    int updateByExample(@Param("record") TbPark record, @Param("example") TbParkCriteria example);

    int updateByPrimaryKeySelective(TbPark record);

    int updateByPrimaryKeyWithBLOBs(TbPark record);

    int updateByPrimaryKey(TbPark record);
}