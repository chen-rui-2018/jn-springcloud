package com.jn.enterprise.servicemarket.product.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProduct;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;
import com.jn.user.model.UserExtensionInfo;

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
     * @param operation
     * @param account
     */
    void productShelf(ProductShelfOperation operation,String account);

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
  * @param query
  * @param needPage
  * @return
  */
    PaginationData findOrgProductList(OrgProductQuery  query, Boolean needPage);

    /**
     * 机构上架常规产品时,常规产品列表
     * @param orgId
     * @return
     */
    List<ProductShelf> findShelfProductList(String orgId);

    /**
     * 服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件
     * @param productName
     * @return
     */
    List<ProductShelf> productQueryList(String productName);

    /**
     * 机构-编辑常规产品
     * @param product
     * @param account
     */
    void updateCommonProduct(OrgUpdateCommonProduct product,String account);

    /**
     * 机构-编辑特色产品
     * @param content
     * @param account
     */
    void updateFeatureProduct( OrgUpdateFeatureProduct content,String account);

    /**
     * 专员-服务产品列表
     * @param query
     * @return
     */
    PaginationData advisorProductList(AdvisorProductQuery query,Boolean needPage);

    /**
     * 服务产品信息,上架常规服务产品时展示
     * @param productId
     * @return
     */
    WebServiceProductInfo  findShelfProductInfo(String productId);

    /**
     * 查找服务产品统计信息
     * @return
     */
    ServiceStatistics  findServiceStatistics();

    /**
     * 编辑修改常规服务产品界面产品详情信息
     * @param productId
     * @return
     */
    UpdateCommonProductShow modifyCommonServiceShow(String productId);
    /**
     * 获取服务产品编号
     * @param productType
     * @return
     */
    String getProductSerialNumber(String productType);

    /**
     * 机构(查看)-服务产品列表
     * @param query
     * @param needPage
     * @return
     */
    PaginationData findOrgCountProductList(OrgCountQueryParam query,boolean needPage);

    /**
     * 判断是否已发布该模板常规产品
     * @param templateId 模板ID
     * @param orgId 机构ID
     * @param productId 产品ID
     */
    void checkTemplateProduct(String templateId, String orgId, String productId);

    /**
     * 根据账号查询是否机构账号
     * @param account 账号
     * @return
     */
    UserExtensionInfo getUserExtensionByAccount(String account);

    /**
     * 根据产品ID判断是否能修改
     * @param productId 产品ID
     * @return
     */
    TbServiceProduct getCanUpdateProduct(String productId);
}
