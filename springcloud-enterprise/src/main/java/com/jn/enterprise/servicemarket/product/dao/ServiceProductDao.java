package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;
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
    WebServiceProductInfo findWebProductDetails(String productId);

    /**
     * web前台服务产品列表
     * @param conditions
     * @return
     */
    List<WebServiceProductInfo> findWebProductList  (ProductQueryConditions conditions);

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
    List<ProductShelf> findShelfProductList(@Param("orgId") String orgId);

    /**
     * 服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件
     * @param productName
     * @return
     */
    List<ProductShelf>  productQueryList(@Param("productName") String productName);

    /**
     * 服务产品信息,上架常规服务产品时展示
     * @param productId
     * @return
     */
    WebServiceProductInfo findShelfProductInfo(@Param("productId") String productId);

    /**
     * 服务产品列表统计信息界面
     * @return
     */
   ServiceStatistics findServiceStatistics();
    /**
     * 编辑修改常规服务产品界面产品详情信息
     * @param productId
     * @return
     */
    UpdateCommonProductShow modifyCommonServiceShow(String productId);


}
