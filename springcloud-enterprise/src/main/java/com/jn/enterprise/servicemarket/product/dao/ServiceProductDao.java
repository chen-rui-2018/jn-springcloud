package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.model.*;
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
     void productApproval(@Param("productId") String productId, @Param("status") String status, @Param("approvalComments") String approvalComments, @Param("account") String account);


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

    /**
     * web前台服务产品详情
     * @param productId
     * @return
     */
    WebServiceProductDetails findWebProductDetails(String productId);

    /**
     * web前台服务产品列表
     * @param conditions
     * @return
     */
    List<WebServiceProductDetails> findWebProductList  (ProductQueryConditions conditions);

    /**
     * 查询机构的服务产品列表
     * @param productName
     * @param orgId
     * @param productType
     * @param status
     * @return
     */
    List<ServiceProductManage> findOrgProductList(@Param("productName") String productName, @Param("orgId") String orgId,@Param("productType")String productType, @Param("status") String status);

    /**
     * 机构 上架服务产品页面,服务产品列表
     * @param orgId
     * @return
     */
    List<CommonServiceShelf>  findShelfProductList(@Param("orgId") String orgId);
}
