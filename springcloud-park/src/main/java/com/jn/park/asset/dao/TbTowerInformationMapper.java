package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbTowerInformation;
import com.jn.park.asset.entity.TbTowerInformationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTowerInformationMapper {
    long countByExample(TbTowerInformationCriteria example);

    int deleteByExample(TbTowerInformationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbTowerInformation record);

    int insertSelective(TbTowerInformation record);

    List<TbTowerInformation> selectByExample(TbTowerInformationCriteria example);

    TbTowerInformation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbTowerInformation record, @Param("example") TbTowerInformationCriteria example);

    int updateByExample(@Param("record") TbTowerInformation record, @Param("example") TbTowerInformationCriteria example);

    int updateByPrimaryKeySelective(TbTowerInformation record);

    int updateByPrimaryKey(TbTowerInformation record);
}