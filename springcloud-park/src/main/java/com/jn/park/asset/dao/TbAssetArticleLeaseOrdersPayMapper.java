package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbAssetArticleLeaseOrdersPay;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrdersPayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetArticleLeaseOrdersPayMapper {
    long countByExample(TbAssetArticleLeaseOrdersPayCriteria example);

    int deleteByExample(TbAssetArticleLeaseOrdersPayCriteria example);

    int deleteByPrimaryKey(String payId);

    int insert(TbAssetArticleLeaseOrdersPay record);

    int insertSelective(TbAssetArticleLeaseOrdersPay record);

    List<TbAssetArticleLeaseOrdersPay> selectByExample(TbAssetArticleLeaseOrdersPayCriteria example);

    TbAssetArticleLeaseOrdersPay selectByPrimaryKey(String payId);

    int updateByExampleSelective(@Param("record") TbAssetArticleLeaseOrdersPay record, @Param("example") TbAssetArticleLeaseOrdersPayCriteria example);

    int updateByExample(@Param("record") TbAssetArticleLeaseOrdersPay record, @Param("example") TbAssetArticleLeaseOrdersPayCriteria example);

    int updateByPrimaryKeySelective(TbAssetArticleLeaseOrdersPay record);

    int updateByPrimaryKey(TbAssetArticleLeaseOrdersPay record);
}