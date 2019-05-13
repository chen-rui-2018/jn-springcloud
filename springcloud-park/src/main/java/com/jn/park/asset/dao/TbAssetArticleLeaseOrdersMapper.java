package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetArticleLeaseOrders;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrdersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetArticleLeaseOrdersMapper {
    long countByExample(TbAssetArticleLeaseOrdersCriteria example);

    int deleteByExample(TbAssetArticleLeaseOrdersCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAssetArticleLeaseOrders record);

    int insertSelective(TbAssetArticleLeaseOrders record);

    List<TbAssetArticleLeaseOrders> selectByExample(TbAssetArticleLeaseOrdersCriteria example);

    TbAssetArticleLeaseOrders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAssetArticleLeaseOrders record, @Param("example") TbAssetArticleLeaseOrdersCriteria example);

    int updateByExample(@Param("record") TbAssetArticleLeaseOrders record, @Param("example") TbAssetArticleLeaseOrdersCriteria example);

    int updateByPrimaryKeySelective(TbAssetArticleLeaseOrders record);

    int updateByPrimaryKey(TbAssetArticleLeaseOrders record);
}