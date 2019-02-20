package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.model.HotProducts;
import com.jn.enterprise.servicemarket.product.model.ServiceProductDetail;
import com.jn.enterprise.servicemarket.product.model.ServiceProductManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2019/2/14 15:34
 * @version： v1.0
 * @modified By:
 */
public interface ServiceProductDao {
    /**
     * 查询服务产品管理,服务列表
     * @param map
     * @return
     */
     List<ServiceProductManage> findServiceList(Map<String,String> map);

    /**
     * 特色服务产品发布,服务列表
     * @param map
     * @return
     */
     List<ServiceProductManage> featuredProductRelease(Map<String,String> map);

    /**
     * 查询服务产品详情
     * @param productId
     * @return
     */
    ServiceProductDetail findServiceDetail(String productId);

    /**
     * 审批特色服务产品
     * @param productId
     * @param status
     * @param approvalComments
     * @param account
     */

    default void productApproval(@Param("productId") String productId, @Param("status") String status, @Param("approvalComments") String approvalComments, @Param("account") String account) {

    }

    /**
     * 上架/下架产品
     * @param productId
     * @param status
     * @param account
     */
   void  productShelf(@Param("productId") String productId,@Param("status") String status,@Param("account")String account);

    /**
     * 服务超市首页,热门产品列表
     * @return
     */
    List<HotProducts> findHotProducts();
}
