package com.jn.park.asset.dao;

import com.jn.park.asset.model.AssetArticleLeaseModel;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
* 物品租赁dao
* @author： zhuyz
* @date： Created on 2019/4/29 16:04
* @version： v1.0
* @modified By:
*/
public interface AssetArticleLeaseDao {
    /**
     * 返回可租借的资产列表
     * @return
     */
    List<AssetArticleLeaseModel> getArticleLeaseList();

    /**
     * 通过资产编号获取物品租赁详细信息
     * @param assetNumber
     * @return
     */
    AssetArticleLeaseModel getArticleLease(String assetNumber);

    /**
     * 更改资产的租借状态
     */
    void updateStatus(Map<String,Object> map);


}
