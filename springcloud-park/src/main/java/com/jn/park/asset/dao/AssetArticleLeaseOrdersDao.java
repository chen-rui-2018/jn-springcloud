package com.jn.park.asset.dao;

import com.jn.park.asset.model.AssetArticleLeaseOrdersModel;
import com.jn.park.asset.model.LeaseOrdersModel;

import java.util.List;
import java.util.Map;

/**
* 物品租赁订单dao
* @author： zhuyz
* @date： Created on 2019/5/4 18:41
* @version： v1.0
* @modified By:
*/
public interface AssetArticleLeaseOrdersDao {

    /**
     * 返回物品租赁历史列表
     * @return
     */
    List<AssetArticleLeaseOrdersModel> getArticleLeaseList();

    /**
     * 根据订单编号查询租借详情
     * @param id
     * @return
     */
    AssetArticleLeaseOrdersModel getLeaseOrders(String id);

    /**
     * 返回支付订单详情
     * @param id
     * @return
     */
    LeaseOrdersModel getPayOrders(String id);

    /**
     * 确认归还
     * @param map
     */
    void updateStatus(Map<String,Object> map);
}
