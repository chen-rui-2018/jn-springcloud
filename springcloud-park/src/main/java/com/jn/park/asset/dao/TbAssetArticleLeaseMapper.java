package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetArticleLease;
import com.jn.park.asset.entity.TbAssetArticleLeaseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetArticleLeaseMapper {
    long countByExample(TbAssetArticleLeaseCriteria example);

    int deleteByExample(TbAssetArticleLeaseCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAssetArticleLease record);

    int insertSelective(TbAssetArticleLease record);

    List<TbAssetArticleLease> selectByExample(TbAssetArticleLeaseCriteria example);

    TbAssetArticleLease selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAssetArticleLease record, @Param("example") TbAssetArticleLeaseCriteria example);

    int updateByExample(@Param("record") TbAssetArticleLease record, @Param("example") TbAssetArticleLeaseCriteria example);

    int updateByPrimaryKeySelective(TbAssetArticleLease record);

    int updateByPrimaryKey(TbAssetArticleLease record);
}