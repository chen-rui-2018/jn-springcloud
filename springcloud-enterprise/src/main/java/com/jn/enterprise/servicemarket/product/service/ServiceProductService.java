package com.jn.enterprise.servicemarket.product.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.product.model.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

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
     * @return
     */
   String  addServiceProduct(ServiceContent content, String account);

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
     * @param constraint
     * @return
     */
    PaginationData findWebProductList(ServiceSelectConstraint constraint);
}
