package com.jn.enterprise.servicemarket.product.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.servicemarket.advisor.enums.ServiceSortTypeEnum;
import com.jn.enterprise.enums.ServiceProductException;
import com.jn.enterprise.servicemarket.product.dao.ServiceAdvisorDao;
import com.jn.enterprise.servicemarket.product.dao.ServiceProductDao;
import com.jn.enterprise.servicemarket.product.dao.TbServiceDetailsMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.*;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 服务产品
 *
 * @Author: chenr
 * @Date: 2019/2/12 16:37
 * @Version v1.0
 * @modified By:
 */
@Service
public class ServiceProductServiceImpl implements ServiceProductService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ServiceProductServiceImpl.class);
    @Autowired
    private TbServiceProductMapper tbServiceProductMapper;
    @Autowired
    private TbServiceDetailsMapper tbServiceDetailsMapper;
    @Autowired
    private ServiceProductDao productDao;
    @Autowired
    private ServiceAdvisorDao advisorDao;


    @ServiceLog(doAction = "添加服务产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addServiceProduct(ServiceContent content, String account) {

        String productId = UUID.randomUUID().toString().replaceAll("-", "");
        String  productType = "1";
        // 如果有机构id则表示为机构上架常规产品或者添加特色产品 需要进行审批;
        String status = content.getProductType().equals(productType) ? "0":"1";

        Byte recordStatus = 1;
        if(productType.equals(content.getProductType())){

             if(StringUtils.isBlank(content.getOrgId())){
                logger.warn("[服务产品新增]，特色服务产品机构id{}不能为空：orgId: {},特色服务产品的机构id不能为空!");
                throw new JnSpringCloudException(ServiceProductException.SERVICE_PRODUCT_ORG_ID_EMPTY);
            }
        }
        if (content.getReferPrice() != null) {
              checkReferPrice(content.getReferPrice());
        }
        TbServiceProduct tbServiceProduct = new TbServiceProduct();
        tbServiceProduct.setTemplateId(content.getProductId());
        BeanUtils.copyProperties(content, tbServiceProduct);
        tbServiceProduct.setProductId(productId);
        tbServiceProduct.setCreatedTime(new Date());
        tbServiceProduct.setReleaseTime(tbServiceProduct.getCreatedTime());
        tbServiceProduct.setCreatorAccount(account);
        tbServiceProduct.setStatus(status);
        tbServiceProduct.setRecordStatus(recordStatus);
        //保存服务产品的基本信息
        tbServiceProductMapper.insertSelective(tbServiceProduct);
        //服务产品描述不为空则 插入详情;
        if (StringUtils.isNotBlank(content.getServiceDetails())) {
            TbServiceDetails details = new TbServiceDetails();
            details.setProductId(productId);
            details.setServiceDetails(content.getServiceDetails().getBytes());
            tbServiceDetailsMapper.insertSelective(details);
        }
        //保存顾问和服务间关系
        if(StringUtils.isNotBlank(content.getAdvisorAccount())){
            String [] accounts = content.getAdvisorAccount().split(",");
            List<TbServiceAndAdvisor> advisorList = new ArrayList<>();
            for(String advisorAccount : accounts){
                TbServiceAndAdvisor advisor = new TbServiceAndAdvisor();
                advisor.setProductId(productId);
                advisor.setAdvisorAccount(advisorAccount);
                advisorList.add(advisor);
            }
            advisorDao.addServiceAdvisor(advisorList);
        }
        return productId;
    }


    @ServiceLog(doAction = "后台服务产品管理-服务产品列表")
    @Override
    public PaginationData findServiceList(ServiceSelectConstraint constraint) {
        Map<String,String>  map = new HashMap<>(10);
        if(constraint != null){
            map= constraintToMap(constraint);
        }
        int pageSize = constraint.getRows() == 0 ? 15 : constraint.getRows();
        int pageNumber= constraint.getPage();
        Page<Object>  object = PageHelper.startPage(pageNumber,pageSize,true);
        List<ServiceProductManage> productList = productDao.findServiceList(map);
        return new PaginationData(productList,object==null?0:object.getTotal());
    }


    @ServiceLog(doAction = "上架常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void  upShelfCommonService(CommonServiceShelf commonService,String account) {
        if(StringUtils.isBlank(commonService.getProductId())){
            logger.warn("[上架常规服务产品]，服务产品ID{}不能为空：productId: {}上架常规服务产品时,服务产品Id不能为空!");
            throw new JnSpringCloudException(ServiceProductException.SERVICE_PRODUCT_ID_EMPTY);
        }
        if(StringUtils.isBlank(commonService.getOrgId())){
            logger.warn("[上架常规服务产品]，机构Id{}不能为空：orgId: {}上架常规服务产品时,机构Id不能为空!");
            throw new JnSpringCloudException(ServiceProductException.SERVICE_PRODUCT_ORG_ID_EMPTY);
        }
        TbServiceProductCriteria criteria = new TbServiceProductCriteria();
        TbServiceProduct product =  tbServiceProductMapper.selectByPrimaryKey(commonService.getProductId());
        ServiceContent content = new ServiceContent();
        BeanUtils.copyProperties(product,content);
        content.setOrgId(commonService.getOrgId());
        content.setAdvisorAccount(commonService.getAdvisorAccount());
        addServiceProduct(content,account);
    }


    @ServiceLog(doAction = "查询服务产品详情")
    @Override
    public ServiceProductDetail findServiceDetail(String productId) {
        ServiceProductDetail detail =  productDao.findServiceDetail(productId);
        return detail;
    }


    @ServiceLog(doAction = "服务产品审核")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void productApproval(ServiceProductApproval approval,String account) {
        //审批不通过时,必须要填写审批意见;
        String status = "2";
        if(status.equals(approval.getStatus())){
            if(StringUtils.isBlank(approval.getApprovalComments())){
                logger.warn("[审批特色服务产品]，审批意见{}不能为空：approvalComments: {}!审批不通过时,审批意见不能为空");
                throw new JnSpringCloudException(ServiceProductException.SERVICE_PRODUCT_APPROVALCOMMENTS_EMPTY);
            }
        }
        productDao.productApproval(approval.getProductId(),approval.getStatus(),approval.getApprovalComments(),account);
    }


    @ServiceLog(doAction = "服务产品上下架")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void productShelf(ServiceProductApproval approval, String account) {
        productDao.productShelf(approval.getProductId(),approval.getStatus(),account);
    }


    @ServiceLog(doAction = "特色服务产品发布,产品列表")
    @Override
    public PaginationData featuredProductRelease(ServiceSelectConstraint constraint) {

        Map<String,String>  map = new HashMap<>(10);
        if(constraint != null){
            map= constraintToMap(constraint);
        }
        int pageSize = constraint.getRows() == 0 ? 15 : constraint.getRows();
        int pageNumber= constraint.getPage();
        Page<Object>  object = PageHelper.startPage(pageNumber,pageSize,true);
        List<ServiceProductManage> productList =  productDao.featuredProductRelease(map);
        return new PaginationData(productList,object==null?0:object.getTotal());

    }


    @ServiceLog(doAction = "编辑常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void modifyCommonService(ServiceContent content, String account) {
        if (content.getReferPrice() != null) {
            checkReferPrice(content.getReferPrice());
        }
        TbServiceProduct product = new TbServiceProduct();
        BeanUtils.copyProperties(content,product);
        product.setModifierAccount(account);
        product.setModifiedTime(new Date());
        tbServiceProductMapper.updateByPrimaryKeySelective(product);
        if (StringUtils.isNotBlank(content.getServiceDetails())){
            TbServiceDetailsCriteria criteria = new TbServiceDetailsCriteria();
            criteria.createCriteria().andProductIdEqualTo(content.getProductId());
            TbServiceDetails details = new TbServiceDetails();
            details.setServiceDetails(content.getServiceDetails().getBytes());
            tbServiceDetailsMapper.updateByExample(details,criteria);
        }
    }
    @ServiceLog(doAction = "服务超市首页,热门服务产品列表")
    @Override
    public PaginationData findHotProducts(com.jn.common.model.Page page) {
        //首次查询,返回5条
        if(page.getRows()==0){
            page.setRows(5);
        }
        Page<Object> object = PageHelper.startPage(page.getPage(),page.getRows());
       List<HotProducts> products =  productDao.findHotProducts();
        return new PaginationData(products,object==null?0:object.getTotal());
    }
    @ServiceLog(doAction = "web前台服务产品详情")
    @Override
    public WebServiceProductDetails findWebProductDetails(String productId) {
        WebServiceProductDetails details= productDao.findWebProductDetails(productId);
        return details;
    }
    @ServiceLog(doAction = "web前台服务产品列表")
    @Override
    public PaginationData findWebProductList(ProductInquiryInfo  info,Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(info.getPage(), info.getRows() == 0 ? 15 : info.getRows(), true);
        }
        ProductQueryConditions conditions = new ProductQueryConditions();
        BeanUtils.copyProperties(info,conditions);
        if(StringUtils.isBlank(info.getSortTypes()) ){
            //默认综合排序
            conditions.setSortTypes(ServiceSortTypeEnum.INTEGRATE.getCode());
        }
        if(ServiceSortTypeEnum.INTEGRATE.getCode().equals(conditions.getSortTypes())) {
            //todo：从数据字典表获取综合排序各个因素的权重并给相应元素赋值  chenr
        }
         List<WebServiceProductDetails> data= productDao.findWebProductList(conditions);
        return new PaginationData(data,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "机构-前台服务产品列表")
    @Override
    public PaginationData findOrgProductList(ProductInquiryInfo info, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(info.getPage(), info.getRows() == 0 ? 15 : info.getRows(), true);
        }
         List<ServiceProductManage>  data = productDao.findOrgProductList(info.getKeyWords(), info.getOrgId(), info.getProductType(),info.getProductStatus());
        return new PaginationData(data,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于机构上架常规服务产品")
    @Override
    public List<CommonServiceShelf> findShelfProductList(String orgId){
        List<CommonServiceShelf> data = null;
        if(StringUtils.isNotBlank(orgId)){
            data=productDao.findShelfProductList(orgId);
        }
        return data;
    }


    private void checkReferPrice(String referPrice){
        int max = 0;
        int min = 0;
        String reg = "^[0-9]+-?[0-9]+$";
        if (!referPrice.matches(reg)) {
            logger.warn("[服务产品新增]，参考价格{}格式错误：referPrice: " + referPrice + "{},格式错误,只能为纯数字或数字范围'min-max'");
            throw new JnSpringCloudException(ServiceProductException.SERVICE_PRODUCT_REFER_PRICE_WRONG_FORMAT);
        }
        String[] prices = referPrice.split("-");
        int length = 2;
        if (prices.length == length) {
            min = Integer.parseInt(referPrice.substring(0, referPrice.indexOf("-")));
            max = Integer.parseInt(referPrice.substring(referPrice.indexOf("-") + 1));
            if (max < min) {
                logger.warn("[服务产品新增]，参考价格{}格式错误：referPrice: " + referPrice + "{},格式错误,'-'后面的价格值应大于前面的价格值");
                throw new JnSpringCloudException(ServiceProductException.SERVICE_PRODUCT_REFER_PRICE_NUMBER_EXCEPTION);
            }
        }
    }
    private Map<String,String> constraintToMap(ServiceSelectConstraint constraint){
       Map<String,String>  map = new HashMap<>(10);
       if(constraint != null){
           map.put("productName",constraint.getProductName());
           map.put("productType",constraint.getProductType());
           map.put("orgName",constraint.getOrgName());
           map.put("signoryName",constraint.getSignoryName());
           map.put("status",constraint.getStatus());
           map.put("startTime",constraint.getStartTime());
           map.put("endTime", constraint.getEndTime());
           map.put("orgType",constraint.getOrgType());
       }
       return map;
    }
}
