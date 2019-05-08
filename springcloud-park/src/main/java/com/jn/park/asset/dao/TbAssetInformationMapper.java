package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetInformation;
import com.jn.park.asset.entity.TbAssetInformationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetInformationMapper {
    long countByExample(TbAssetInformationCriteria example);

    int deleteByExample(TbAssetInformationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAssetInformation record);

    int insertSelective(TbAssetInformation record);

    List<TbAssetInformation> selectByExample(TbAssetInformationCriteria example);

    TbAssetInformation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAssetInformation record, @Param("example") TbAssetInformationCriteria example);

    int updateByExample(@Param("record") TbAssetInformation record, @Param("example") TbAssetInformationCriteria example);

    int updateByPrimaryKeySelective(TbAssetInformation record);

    int updateByPrimaryKey(TbAssetInformation record);
}