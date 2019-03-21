package com.jn.enterprise.servicemarket.product.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.enums.ServiceSortTypeEnum;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.product.dao.*;
import com.jn.enterprise.servicemarket.product.entity.*;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
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
    private TbServiceAndAdvisorMapper tbServiceAndAdvisorMapper;
    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private ServiceProductDao productDao;
    @Autowired
    private ServiceAdvisorDao advisorDao;


    @ServiceLog(doAction = "添加服务产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addServiceProduct(ServiceContent content, String account,String templateId) {
        //服务产品类型 -1(无效/下架),0(待审核),1(上架/有效/审核通过).2(审核不通过)
        String  productType = "1";
        // 如果为特色产品则需要进行审批,
        String status = content.getProductType().equals(productType) ? "0":"1";
        //数据记录状态
        Byte recordStatus = 1;
        //产品编号
        String serialNumber = null;
        if(productType.equals(content.getProductType())){
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductTypeEqualTo(productType).andOrgIdEqualTo(content.getOrgId());
            long number = tbServiceProductMapper .countByExample(criteria);
            serialNumber = "TS000"+(content.getOrgId()==null?"":content.getOrgId())+number+((Math.random()*9+1)*1000);
        }else
        {
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductTypeEqualTo("0");
            long number = tbServiceProductMapper .countByExample(criteria);
            serialNumber = "CG000"+(content.getOrgId()==null?"":content.getOrgId())+number+((Math.random()*9+1)*1000);
        }
        if(productType.equals(content.getProductType())){
             if(StringUtils.isBlank(content.getOrgId())){
                logger.warn("[服务产品新增]，特色服务产品机构id{}不能为空：orgId: {},特色服务产品的机构id不能为空!");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY);
            }
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
             criteria.createCriteria().andProductNameEqualTo(content.getProductName());
             List<TbServiceProduct> products= tbServiceProductMapper.selectByExample(criteria);
             if(products!=null && products.size()>0){
                 logger.warn("[服务产品新增]，特色服务产品名称{}不能重复：productName: {},特色服务产品名称{}不能重复!");
                 throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE);
             }
        }
        if (content.getReferPrice() != null) {
              checkReferPrice(content.getReferPrice());
        }
        TbServiceProduct tbServiceProduct = new TbServiceProduct();
        tbServiceProduct.setTemplateId(templateId);
        BeanUtils.copyProperties(content, tbServiceProduct);
        tbServiceProduct.setCreatedTime(new Date());
        tbServiceProduct.setReleaseTime(tbServiceProduct.getCreatedTime());
        tbServiceProduct.setCreatorAccount(account);
        tbServiceProduct.setStatus(status);
        tbServiceProduct.setRecordStatus(recordStatus);
        tbServiceProduct.setSerialNumber(serialNumber);
        //设置机构名称
        if (StringUtils.isNotBlank(content.getOrgId())){
            TbServiceOrg org= tbServiceOrgMapper.selectByPrimaryKey(content.getOrgId());
            if(org!=null){
                tbServiceProduct.setOrgName(org.getOrgName());
            }
        }
        //保存服务产品的基本信息
        tbServiceProductMapper.insertSelective(tbServiceProduct);
        //服务产品描述不为空则 插入详情;
        if (StringUtils.isNotBlank(content.getServiceDetails())) {
            TbServiceDetails details = new TbServiceDetails();
            details.setProductId(content.getProductId());
            try{
                details.setServiceDetails(content.getServiceDetails().getBytes("UTF-8"));
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
                logger.info("服务产品详情描述,不支持的字符集"+e.getMessage());
            }
            tbServiceDetailsMapper.insertSelective(details);
        }
        //保存顾问和服务间关系
        if(StringUtils.isNotBlank(content.getAdvisorAccount())){
            addAdvisor(content.getAdvisorAccount(),content.getProductId());
        }
        return content.getProductId();
    }


    @ServiceLog(doAction = "后台服务产品管理-服务产品列表")
    @Override
    public PaginationData findServiceList(ServiceSelectConstraint constraint) {
        Map<String,String>  map = new HashMap<>(10);
        com.github.pagehelper.Page<Object> objects = null;
        int page = 0;
        int rows = 15;
        if(constraint != null){
            map= constraintToMap(constraint);
            page = constraint.getPage();
            rows = constraint.getRows();
        }
        objects = PageHelper.startPage(page,rows==0?15:rows,true);
        List<ServiceProductManage> productList = productDao.findServiceList(map);
        return new PaginationData(productList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "上架常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void  upShelfCommonService(CommonServiceShelf commonService,String account) {
        if(StringUtils.isBlank(commonService.getTemplateId())){
            logger.warn("[上架常规服务产品]，服务产品模板Id{}不能为空：productId: {}上架常规服务产品时,服务产品模板Id不能为空!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
        }
        if(StringUtils.isBlank(commonService.getOrgId())){
            logger.warn("[上架常规服务产品]，机构Id{}不能为空：orgId: {}上架常规服务产品时,机构Id不能为空!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY);
        }
        TbServiceProduct product =  tbServiceProductMapper.selectByPrimaryKey(commonService.getTemplateId());
        ServiceContent content = new ServiceContent();
        BeanUtils.copyProperties(product,content);
        content.setOrgId(commonService.getOrgId());
        content.setProductId(commonService.getProductId());
        content.setAdvisorAccount(commonService.getAdvisorAccount());
        addServiceProduct(content,account,commonService.getTemplateId());
    }


    @ServiceLog(doAction = "查询服务产品详情")
    @Override
    public ServiceProductDetail findServiceDetail(String productId) {
        if(StringUtils.isBlank(productId)){
            logger.warn("[服务产品详情查看]，服务产品详情查看{}服务产品Id不能为空：productId: {}查看服务产品详情时,服务产品Id不能为空!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
        }
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
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_APPROVALCOMMENTS_EMPTY);
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
        com.github.pagehelper.Page<Object> objects = null;
        int page = 0;
        int rows = 15;
        if(constraint != null){
            map= constraintToMap(constraint);
            page = constraint.getPage();
            rows = constraint.getRows();
        }
        objects = PageHelper.startPage(page,rows==0?15:rows,true);
        List<ServiceProductManage> productList =  productDao.featuredProductRelease(map);
        return new PaginationData(productList,objects==null?0:objects.getTotal());

    }

    @ServiceLog(doAction = "编辑常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void modifyCommonService(ServiceContent content, String account){
        if (content.getReferPrice() != null) {
            checkReferPrice(content.getReferPrice());
        }
        if(StringUtils.isBlank(content.getProductId())){
            logger.warn("[编辑常规产品]，编辑常规产品{}服务产品Id不能为空：productId: {}编辑常规产品,服务产品Id不能为空!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
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
            try{
                details.setServiceDetails(content.getServiceDetails().getBytes("UTF-8"));
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
                logger.info("服务产品详情描述,不支持的字符集"+e.getMessage());
            }
            tbServiceDetailsMapper.updateByExample(details,criteria);
        }
    }
    @ServiceLog(doAction = "服务超市首页,热门服务产品列表")
    @Override
    public PaginationData findHotProducts(com.jn.common.model.Page page) {
        Page<Object> object= null;
        //首次查询,返回5条
        if(page.getRows()==0){
            page.setRows(5);
        }
       object = PageHelper.startPage(page.getPage(),page.getRows());
       List<HotProducts> products =  productDao.findHotProducts();
        return new PaginationData(products,object==null?0:object.getTotal());
    }
    @ServiceLog(doAction = "web前台服务产品详情")
    @Override
    public WebServiceProductDetails findWebProductDetails(String productId) {
        WebServiceProductInfo info= productDao.findWebProductDetails(productId);
        if(info== null){
            return null;
        }
        ProductQueryConditions conditions = new ProductQueryConditions();
        conditions.setSignoryId(info.getSignoryId());
        List<WebServiceProductInfo> infoList= productDao.findWebProductList(conditions);
        WebServiceProductDetails details = new WebServiceProductDetails();
        details.setInfo(info);
        details.setInfoList(infoList);
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
         List<WebServiceProductInfo> data= productDao.findWebProductList(conditions);
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
    @ServiceLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件")
    @Override
    public List<CommonServiceShelf> productQueryList(String productName) {
        List<CommonServiceShelf> data=productDao.productQueryList(productName);
        return data;
    }
    @ServiceLog(doAction = "机构-编辑常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCommonProduct(CommonServiceShelf product,String account) {
        //更新产品表中信息
        TbServiceProduct tbServiceProduct = new TbServiceProduct();
        tbServiceProduct.setProductId(product.getProductId());
        tbServiceProduct.setModifiedTime(new Date());
        tbServiceProduct.setModifierAccount(account);
        tbServiceProductMapper.updateByPrimaryKeySelective(tbServiceProduct);
        //更新顾问信息
        if(StringUtils.isNotBlank(product.getAdvisorAccount())){
            addAdvisor(product.getAdvisorAccount(),product.getProductId());
        }
    }
    @ServiceLog(doAction = "机构编辑特色服务产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateFeatureProduct(ServiceContent content, String account) {
       //修改后需要进行审核
        String status = "0";
        TbServiceProduct tbServiceProduct = new TbServiceProduct();
        BeanUtils.copyProperties(content,tbServiceProduct);
        tbServiceProduct.setModifierAccount(account);
        tbServiceProduct.setModifiedTime(new Date());
        tbServiceProduct.setStatus(status);
        if (content.getReferPrice() != null) {
            checkReferPrice(content.getReferPrice());
        }
        tbServiceProductMapper.updateByPrimaryKeySelective(tbServiceProduct);
        // 更新顾问信息
        if(StringUtils.isNotBlank(content.getAdvisorAccount())){
            addAdvisor(content.getAdvisorAccount(),content.getProductId());
        }
    }
    @ServiceLog(doAction = "顾问-服务产品列表")
    @Override
    public PaginationData advisorProductList(AdvisorProductQuery query,Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(query.getPage(), query.getRows() == 0 ? 15 : query.getRows(), true);
        }
          List<AdvisorProductInfo> data =  advisorDao.advisorProductList(query.getAdvisorAccount(),query.getProductType(),query.getPraise());

        return new PaginationData(data,objects==null?0:objects.getTotal());
    }

    /**
     * 校验新增产品时传入的价格字段
     * @param referPrice
     */
    private void checkReferPrice(String referPrice){
        int max = 0;
        int min = 0;
        String reg = "^[0-9]+-?[0-9]+$";
        if (!referPrice.matches(reg)) {
            logger.warn("[服务产品新增]，参考价格{}格式错误：referPrice: " + referPrice + "{},格式错误,只能为纯数字或数字范围'min-max'");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_REFER_PRICE_WRONG_FORMAT);
        }
        String[] prices = referPrice.split("-");
        int length = 2;
        if (prices.length == length) {
            min = Integer.parseInt(referPrice.substring(0, referPrice.indexOf("-")));
            max = Integer.parseInt(referPrice.substring(referPrice.indexOf("-") + 1));
            if (max < min) {
                logger.warn("[服务产品新增]，参考价格{}格式错误：referPrice: " + referPrice + "{},格式错误,'-'后面的价格值应大于前面的价格值");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_REFER_PRICE_NUMBER_EXCEPTION);
            }
        }
    }

    /**
     * 参数转map
     * @param constraint
     * @return
     */
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

    /**
     * 添加顾问信息
     * @param account
     * @param productId
     */
    private void  addAdvisor(String account,String productId){
        TbServiceAndAdvisorCriteria criteria = new TbServiceAndAdvisorCriteria();
        criteria.createCriteria().andProductIdEqualTo(productId);
        tbServiceAndAdvisorMapper.deleteByExample(criteria);
        String [] accounts = account.split(",");
        List<TbServiceAndAdvisor> advisorList = new ArrayList<>();
        for(String advisorAccount : accounts){
            TbServiceAndAdvisor advisor = new TbServiceAndAdvisor();
            advisor.setProductId(productId);
            advisor.setAdvisorAccount(advisorAccount);
            advisorList.add(advisor);
        }
        advisorDao.addServiceAdvisor(advisorList);
    }
}
