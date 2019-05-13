package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetMaintainRecord;
import com.jn.park.asset.entity.TbAssetMaintainRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetMaintainRecordMapper {
    long countByExample(TbAssetMaintainRecordCriteria example);

    int deleteByExample(TbAssetMaintainRecordCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAssetMaintainRecord record);

    int insertSelective(TbAssetMaintainRecord record);

    List<TbAssetMaintainRecord> selectByExample(TbAssetMaintainRecordCriteria example);

    TbAssetMaintainRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAssetMaintainRecord record, @Param("example") TbAssetMaintainRecordCriteria example);

    int updateByExample(@Param("record") TbAssetMaintainRecord record, @Param("example") TbAssetMaintainRecordCriteria example);

    int updateByPrimaryKeySelective(TbAssetMaintainRecord record);

    int updateByPrimaryKey(TbAssetMaintainRecord record);
}