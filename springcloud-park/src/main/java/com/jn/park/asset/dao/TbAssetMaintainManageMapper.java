package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetMaintainManage;
import com.jn.park.asset.entity.TbAssetMaintainManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetMaintainManageMapper {
    long countByExample(TbAssetMaintainManageCriteria example);

    int deleteByExample(TbAssetMaintainManageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAssetMaintainManage record);

    int insertSelective(TbAssetMaintainManage record);

    List<TbAssetMaintainManage> selectByExample(TbAssetMaintainManageCriteria example);

    TbAssetMaintainManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAssetMaintainManage record, @Param("example") TbAssetMaintainManageCriteria example);

    int updateByExample(@Param("record") TbAssetMaintainManage record, @Param("example") TbAssetMaintainManageCriteria example);

    int updateByPrimaryKeySelective(TbAssetMaintainManage record);

    int updateByPrimaryKey(TbAssetMaintainManage record);
}