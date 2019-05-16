package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.asset.model.AssetArticleLeaseOrdersModel;
import com.jn.park.asset.model.LeaseOrdersModel;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;

import java.util.List;
/**
* 物品租赁订单service
* @author： zhuyz
* @date： Created on 2019/5/4 18:23
* @version： v1.0
* @modified By:
*/
public interface AssetArticleLeaseOrdersService {

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
     * @param id
     */
    void returnArticle(String id);

    /**
     * 确认交付
     * @param id
     */
    void deliveryArticle(String id);

    /**
     * 归还
     * @param id
     */
    void giveBack(String id);

    /**
     * 返回物品租赁历史列表
     * @param account
     * @param page
     * @return
     */
    PaginationData<List<AssetArticleLeaseOrdersModel>> getArticleLeaseOrdersList(String account, Page page);

    /**
     * 发起支付
     * @param id
     * @return
     */
    Result startPayment(String id);
}
