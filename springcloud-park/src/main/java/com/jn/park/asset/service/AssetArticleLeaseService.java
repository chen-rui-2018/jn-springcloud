package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.system.model.User;

import java.sql.Date;
import java.util.*;

/**
* 物品租赁service
* @author： zhuyz
* @date： Created on 2019/4/29 15:35
* @version： v1.0
* @modified By:
*/
public interface AssetArticleLeaseService {
    /**
     * 返回可租借的资产列表
     * @return
     */
    PaginationData<List<AssetArticleLeaseModel>> getArticleLeaseList(Page page);

   /**
     * 通过资产编号获取物品租赁详细信息
     * @param assetNumber
     * @return
     */
    AssetArticleLeaseModel getArticleLease(String assetNumber);

    /**
     * 新增租赁订单
     * @param assetNumber
     * @return
     */
    String addLeaseOrders(String assetNumber, User user);

    /**
     * 企业填写租借资料
     * @param assetNumber
     * @param leaseEnterprise
     * @param contactName
     * @param contactPhone
     * @param startTime
     * @param endTime
     * @return
     */
    void leaseWriter(String assetNumber, String leaseEnterprise, String contactName, String contactPhone, Date startTime, Date endTime);

}
