package com.jn.enterprise.servicemarket.product.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;

import java.util.List;

/**
 * 服务产品
 * @Author: chenr
 * @Date: 2019/2/12 16:37
 * @Version v1.0
 * @modified By:
 */
public interface ServiceProductService {
    /**
     * 新增服务
     * @param content
     * @param account
     * @param templateId
     * @return
     */
   String  addServiceProduct(ServiceContent content, String account,String templateId);

    /**
     * 根据条件返回后台服务管理页面的服务列表
     * @param constraint
     * @return
     */
   PaginationData findServiceList(ServiceSelectConstraint constraint);

    /**
     * 机构上架常规产品
     * @param commonService
     * @param account
     */
   void  upShelfCommonService(CommonServiceShelf commonService,String account);

    /**
     * 查询服务产品详情
     * @param productId
     * @return
     */
    ServiceProductDetail findServiceDetail(String productId);

    /**
     * 特色服务产品审核
     * @param approval
     */
    void productApproval( ServiceProductApproval approval,String account);

    /**
     * 产品上架下架
     * @param approval
     * @param account
     */
    void productShelf(ServiceProductApproval approval,String account);

    /**
     * 特色服务产品发布,产品列表
     * @param constraint
     * @return
     */
    PaginationData featuredProductRelease(ServiceSelectConstraint constraint);

    /**
     * 编辑常规服务产品
     * @param content
     * @param account
     */
    void modifyCommonService(ServiceContent content,String account);

    /**
     * 前台热门产品列表
     * @param page
     * @return
     */
    PaginationData  findHotProducts(Page page);

    /**
     * 前台服务产品详情
     * @param productId
     * @return
     */
    WebServiceProductDetails findWebProductDetails(String productId);

    /**
     * 前台服务产品列表
     * @param info
     * @param needPage
     * @return
     */
    PaginationData findWebProductList(ProductInquiryInfo  info, Boolean needPage);

 /**
  * 机构-服务产品列表
  * @param info
  * @param needPage
  * @return
  */
    PaginationData findOrgProductList(ProductInquiryInfo  info, Boolean needPage);

    /**
     * 机构上架常规产品时,常规产品列表
     * @param orgId
     * @return
     */
    List<CommonServiceShelf> findShelfProductList(String orgId);

    /**
     * 服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件
     * @param productName
     * @return
     */
    List<CommonServiceShelf> productQueryList(String productName);

    /**
     * 机构-编辑常规产品
     * @param product
     * @param account
     */
    void updateCommonProduct(CommonServiceShelf product,String account);

    /**
     * 机构-编辑特色产品
     * @param content
     * @param account
     */
    void updateFeatureProduct( ServiceContent content,String account);

    /**
     * 顾问-服务产品列表
     * @param query
     * @return
     */
    PaginationData advisorProductList(AdvisorProductQuery query,Boolean needPage);
}
