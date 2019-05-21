package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetMaintainCompany;
import com.jn.park.asset.entity.TbAssetMaintainCompanyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetMaintainCompanyMapper {
    long countByExample(TbAssetMaintainCompanyCriteria example);

    int deleteByExample(TbAssetMaintainCompanyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAssetMaintainCompany record);

    int insertSelective(TbAssetMaintainCompany record);

    List<TbAssetMaintainCompany> selectByExample(TbAssetMaintainCompanyCriteria example);

    TbAssetMaintainCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAssetMaintainCompany record, @Param("example") TbAssetMaintainCompanyCriteria example);

    int updateByExample(@Param("record") TbAssetMaintainCompany record, @Param("example") TbAssetMaintainCompanyCriteria example);

    int updateByPrimaryKeySelective(TbAssetMaintainCompany record);

    int updateByPrimaryKey(TbAssetMaintainCompany record);
}