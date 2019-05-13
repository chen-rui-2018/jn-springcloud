package com.jn.enterprise.servicemarket.product.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.enums.ServiceSortTypeEnum;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.product.dao.*;
import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisor;
import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisorCriteria;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProduct;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductCriteria;
import com.jn.enterprise.servicemarket.product.enums.ProductConstantEnum;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
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
    private TbServiceAndAdvisorMapper tbServiceAndAdvisorMapper;
    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private ServiceProductDao productDao;
    @Autowired
    private ServiceAdvisorDao advisorDao;
    @Autowired
    private ServiceOrgDao serviceOrgDao;
    @Autowired
    private UserExtensionClient userExtensionClient;


    @ServiceLog(doAction = "添加服务产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addServiceProduct(ServiceContent content, String account,String templateId) {

        if(ProductConstantEnum.PRODUCT_FEATURE_TYPE.getCode().equals(content.getProductType())){
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductNameEqualTo(content.getProductName()).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                    .andStatusNotEqualTo(ProductConstantEnum.PRODUCT_STATUS_APPROVAL_NOT_PASS.getCode());
            List<TbServiceProduct> products= tbServiceProductMapper.selectByExample(criteria);
            if(products!=null && products.size()>0){
                logger.warn("[服务超市产品]，特色服务产品名称{}不能重复：productName: {},特色服务产品名称{}不能重复!");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE);
            }
        }
        if (content.getReferPrice() != null) {
            checkReferPrice(content.getReferPrice());
        }

        //设置机构名称
        UserExtensionInfo userExtension = getUserExtensionByAccount(account);
        String orgId = userExtension.getAffiliateCode();

        // 常规产品添加模板ID并判断是否已发布模板
        if (content.getProductType().equals(ProductConstantEnum.PRODUCT_COMMENT_TYPE.getCode())) {
            if (StringUtils.isEmpty(templateId)) {
                logger.warn("[服务超市产品] 常规产品模板ID为空");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_TEMPLE_ID_EMPTY);
            }
            checkTemplateProduct(templateId, orgId, content.getProductId());
            content.setTemplateId(templateId);
        }

        // 封装IBPS表单数据
        content.setProductId("");
        content.setRecordStatus(ProductConstantEnum.RECORD_STATUS_EFFECTIVE.getCode());
        content.setCreatorAccount(account);
        content.setStatus(ProductConstantEnum.PRODUCT_STATUS_APPROVAL.getCode());
        content.setCreatedTime(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        content.setOrgId(orgId);
        content.setOrgName(userExtension.getAffiliateName());

        //设置服务顾问
        List<TbServiceAndAdvisor> tb_service_and_advisor = new ArrayList<>();
        if (StringUtils.isNotBlank(content.getAdvisorAccount())){
            String[] advisorArr = content.getAdvisorAccount().split(",");
            for (int i = 0; i < advisorArr.length; i++){
                if(StringUtils.isNotEmpty(advisorArr[i])) {
                    TbServiceAndAdvisor tbServiceAndAdvisor = new TbServiceAndAdvisor();
                    tbServiceAndAdvisor.setAdvisorAccount(advisorArr[i]);
                    tb_service_and_advisor.add(tbServiceAndAdvisor);
                }
            }
        }
        content.setTb_service_and_advisor(tb_service_and_advisor);

        // 启动IBPS流程
        String bpmnDefId = "572370953367977984";
        IBPSResult ibpsResult = IBPSUtils.sendRequest(bpmnDefId, account, content);

        // ibps启动流程失败
        if (ibpsResult == null || !ibpsResult.getState().equals("200")) {
            logger.warn("[服务超市产品] 启动ibps流程出错，错误信息：" + ibpsResult.getMessage());
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_SUBMIT_IBPS_ERROR);
        }
        logger.info("[服务超市产品] " + ibpsResult.getMessage());

        return ibpsResult.getState();
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
    public void upShelfCommonService(CommonServiceShelf commonService,String account) {
        if(StringUtils.isBlank(commonService.getTemplateId())){
            logger.warn("[上架常规服务产品]，服务产品模板Id{}不能为空：productId: {}上架常规服务产品时,服务产品模板Id不能为空!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
        }
        TbServiceProduct product = tbServiceProductMapper.selectByPrimaryKey(commonService.getTemplateId());

        // 判断模板是否有效
        if (product == null) {
            logger.warn("[上架常规服务产品] 产品模板无效,未找到相关模板");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_TEMPLATE_NOT_EXIST);
        }

        ServiceContent content = new ServiceContent();
        BeanUtils.copyProperties(product,content);
        content.setOrgId(commonService.getOrgId());
        content.setProductId(commonService.getProductId());
        content.setAdvisorAccount(commonService.getAdvisorAccount());
        addServiceProduct(content, account, commonService.getTemplateId());
    }


    @ServiceLog(doAction = "查询服务产品详情")
    @Override
    public ServiceProductDetail findServiceDetail(String productId) {
        if(StringUtils.isBlank(productId)){
            logger.warn("[服务产品详情查看]，服务产品详情查看{}服务产品Id不能为空：productId: {}查看服务产品详情时,服务产品Id不能为空!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
        }
        ServiceProductDetail detail =  productDao.findServiceDetail(productId);
        if(detail == null){
            return detail;
        }
        if(detail!=null){
            ServiceContent content= detail.getContent();
            if (content!=null){
                 content.setProductDetails(content.getServiceDetails());
                 content.setServiceDetails(null);
                 content.setServiceDetails(null);
                 detail.setContent(content);
                }
            }
        //添加产品浏览数
        TbServiceProduct product =tbServiceProductMapper.selectByPrimaryKey(productId);
        TbServiceProduct productUpdate = new TbServiceProduct();
        int viewCount = product.getViewCount()==null?0:Integer.valueOf(product.getViewCount());
        productUpdate.setViewCount(viewCount+1);
        productUpdate.setProductId(productId);
        tbServiceProductMapper.updateByPrimaryKeySelective(productUpdate);
        return detail;
    }
    @ServiceLog(doAction = "服务产品审核")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void productApproval(ServiceProductApproval approval,String account) {
        //审批不通过时,必须要填写审批意见;
        String status = ProductConstantEnum.PRODUCT_STATUS_APPROVAL_NOT_PASS.getCode();
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
    public void productShelf(ProductShelfOperation operation , String account) {
        //如果进行上架操作,则需要进行审核,修改状态为待审核
        String productStatus = operation.getStatus();
        if(ProductConstantEnum.PRODUCT_STATUS_EFFECTIVE.getCode().equals(productStatus)){
            productStatus = ProductConstantEnum.PRODUCT_STATUS_APPROVAL.getCode();
        }
        productDao.productShelf(operation.getProductId(),productStatus,account);
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
        TbServiceProductCriteria criteria1 = new TbServiceProductCriteria();
        criteria1.createCriteria().andTemplateIdEqualTo(content.getProductId());
        List<TbServiceProduct> productList =tbServiceProductMapper.selectByExample(criteria1);
        if(productList!=null && productList.size()>0){
            logger.warn("[编辑常规产品]，编辑常规产品{}产品已有机构上架,不能修改：productId: {}编辑常规产品,产品已有机构上架,不能修改!");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_PRODUCT_SHELF);
        }

        if (content.getReferPrice() != null) {
            checkReferPrice(content.getReferPrice());
        }
        TbServiceProduct product = new TbServiceProduct();
        BeanUtils.copyProperties(content,product);
        product.setModifierAccount(account);
        product.setModifiedTime(new Date());
        product.setProductDetails(content.getProductDetails());
        tbServiceProductMapper.updateByPrimaryKeySelective(product);

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
        //产品详情
        info.setProductDetails(info.getServiceDetails());
        info.setServiceDetails(null);
        ProductQueryConditions conditions = new ProductQueryConditions();
        conditions.setSignoryId(info.getSignoryId());
        List<WebServiceProductInfo> infoList= productDao.findWebProductList(conditions);
        WebServiceProductDetails details = new WebServiceProductDetails();
        details.setInfo(info);
        details.setInfoList(infoList);
        //添加产品浏览数
        TbServiceProduct product =tbServiceProductMapper.selectByPrimaryKey(productId);
        TbServiceProduct productUpdate = new TbServiceProduct();

        productUpdate.setViewCount(product.getViewCount()==null?1:(product.getViewCount()+1));
        productUpdate.setProductId(productId);
        tbServiceProductMapper.updateByPrimaryKeySelective(productUpdate);
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
    public PaginationData findOrgProductList(OrgProductQuery query, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(query.getPage(), query.getRows() == 0 ? 15 : query.getRows(), true);
        }
         List<ServiceProductManage>  data = productDao.findOrgProductList(query.getKeyWords(), query.getOrgId(), query.getProductType(),query.getProductStatus());
        return new PaginationData(data,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于机构上架常规服务产品")
    @Override
    public List<ProductShelf> findShelfProductList(String orgId){
        List<ProductShelf> data = null;
        if(StringUtils.isNotBlank(orgId)){
            data=productDao.findShelfProductList(orgId);
        }
        return data;
    }
    @ServiceLog(doAction = "服务产品信息,上架常规服务产品时展示")
    @Override
    public WebServiceProductInfo findShelfProductInfo(String productId)  {
        WebServiceProductInfo data =   productDao.findShelfProductInfo(productId);
        data.setProductDetails(data.getServiceDetails());
        data.setServiceDetails(null);
        return data;
    }

    @ServiceLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件")
    @Override
    public List<ProductShelf> productQueryList(String productName) {
        List<ProductShelf> data=productDao.productQueryList(productName);
        return data;
    }

    @ServiceLog(doAction = "机构-编辑常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCommonProduct(OrgUpdateCommonProduct product,String account) {
        if (StringUtils.isEmpty(product.getProductId())) {
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
        }

        TbServiceProduct tbServiceProduct = getCanUpdateProduct(product.getProductId());

        ServiceContent content = new ServiceContent();
        BeanUtils.copyProperties(tbServiceProduct, content);
        content.setAdvisorAccount(product.getAdvisorAccount());
        startProductIbps(content, account, tbServiceProduct.getTemplateId(), tbServiceProduct);
    }

    @ServiceLog(doAction = "机构编辑特色服务产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateFeatureProduct(OrgUpdateFeatureProduct product, String account) {
        if (StringUtils.isEmpty(product.getProductId())) {
            throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY);
        }

        ServiceContent content = new ServiceContent();
        TbServiceProduct tbServiceProduct = getCanUpdateProduct(product.getProductId());
        BeanUtils.copyProperties(tbServiceProduct,content);
        BeanUtils.copyProperties(product,content);
        if (StringUtils.isNotEmpty(product.getAdvisorAccount())) {
            content.setAdvisorAccount(product.getAdvisorAccount());
        }

        startProductIbps(content, account, tbServiceProduct.getTemplateId(), tbServiceProduct);
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
    @ServiceLog(doAction = "机构(查看)-服务产品列表")
    @Override
    public PaginationData findOrgCountProductList(OrgCountQueryParam query, boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(query.getPage(), query.getRows() == 0 ? 15 : query.getRows(), true);
        }
        List<OrgCountProductInfo> data =  serviceOrgDao.findOrgCountProductList(query.getOrgd(),query.getProductType(),query.getPraise());

        return new PaginationData(data,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "服务产品列表界面的统计信息")
    @Override
    public ServiceStatistics findServiceStatistics() {
        ServiceStatistics serviceStatistics =   productDao.findServiceStatistics();
        return serviceStatistics;
    }
    @ServiceLog(doAction = "编辑修改常规服务产品界面产品详情信息")
    @Override
    public UpdateCommonProductShow modifyCommonServiceShow(String productId) {
        UpdateCommonProductShow show = productDao.modifyCommonServiceShow(productId);
        show.setProductDetails(show.getServiceDetails());
        show.setServiceDetails(null);
        return  show;
    }

    @ServiceLog(doAction = "获取服务产品编号")
    @Override
    public String getProductSerialNumber(String productType){
        //产品编号
        String serialNumber = "";
        String commentsType = ProductConstantEnum.PRODUCT_COMMENT_TYPE.getCode();
        String featureType = ProductConstantEnum.PRODUCT_FEATURE_TYPE.getMessage();
        Date date = new Date();
        String dataStr = DateUtils.formatDate(date,"yyyyMMddHHmmss");
        if(productType.equals(featureType)){
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductTypeEqualTo(featureType);
            long number = tbServiceProductMapper .countByExample(criteria);
            serialNumber = "TS00"+number+dataStr+(int)((Math.random()*9+1)*1000);
        }else {
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductTypeEqualTo(commentsType);
            long number = tbServiceProductMapper .countByExample(criteria);
            serialNumber = "CG00"+number+dataStr+(int)((Math.random()*9+1)*1000);
        }
        return serialNumber;
    }

    /**
     * 判断是否已发布该模板常规产品
     * @param templateId 模板ID
     * @param orgId 机构ID
     * @return
     */
    @Override
    @ServiceLog(doAction = "判断是否已发布该模板常规产品")
    public void checkTemplateProduct(String templateId, String orgId, String productId){
        TbServiceProductCriteria criteria = new TbServiceProductCriteria();
        criteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andOrgIdEqualTo(orgId).andTemplateIdEqualTo(templateId);

        criteria.setOrderByClause("created_time DESC");
        List<TbServiceProduct> tbServiceProducts = tbServiceProductMapper.selectByExample(criteria);

        // 最新数据审核状态非审核不通过则抛出异常
        if (tbServiceProducts != null && !tbServiceProducts.isEmpty() && !tbServiceProducts.get(0).getStatus().equals(ProductConstantEnum.PRODUCT_STATUS_APPROVAL_NOT_PASS.getCode())) {
            if (StringUtils.isNotEmpty(productId)) {
                if (!tbServiceProducts.get(0).getProductId().equals(productId)) {
                    logger.warn("{} 机构已上架常规模板为 {} 的产品", orgId, templateId);
                    throw new JnSpringCloudException(ServiceProductExceptionEnum.CURRENT_ORG_PUBLISH_PRODUCT);
                }
            } else {
                logger.warn("{} 机构已上架常规模板为 {} 的产品", orgId, templateId);
                throw new JnSpringCloudException(ServiceProductExceptionEnum.CURRENT_ORG_PUBLISH_PRODUCT);
            }
        }
    }

    /**
     * 根据账号查询是否机构账号
     * @param account
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据账号查询是否机构账号")
    public UserExtensionInfo getUserExtensionByAccount(String account){
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if (userExtension == null || userExtension.getData() == null
                || StringUtils.isEmpty(userExtension.getData().getAffiliateCode())) {
            logger.warn("[根据账号查询是否机构账号] {}不是机构用户", account);
            throw new JnSpringCloudException(ServiceProductExceptionEnum.CURRENT_ACCOUNT_NOT_ORG_USER);
        }
        return userExtension.getData();
    }

    @Override
    @ServiceLog(doAction = "根据产品ID判断是否能修改")
    public TbServiceProduct getCanUpdateProduct(String productId) {
        TbServiceProductCriteria criteria = new TbServiceProductCriteria();
        TbServiceProductCriteria downCriteria = new TbServiceProductCriteria();
        TbServiceProductCriteria.Criteria criteria1 = downCriteria.createCriteria();
        criteria.createCriteria().andProductIdEqualTo(productId)
                .andStatusEqualTo(ProductConstantEnum.PRODUCT_STATUS_EFFECTIVE.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());

        criteria1.andProductIdEqualTo(productId)
                .andStatusEqualTo(ProductConstantEnum.PRODUCT_STATUS_INVALID.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        criteria.or(criteria1);

        List<TbServiceProduct> tbServiceProducts = tbServiceProductMapper.selectByExample(criteria);
        if (tbServiceProducts == null || tbServiceProducts.isEmpty()) {
            logger.warn("查询的产品不存在或未通过审核，productId:", productId);
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_NOT_EXIST);
        }
        return tbServiceProducts.get(0);
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
            String uuid= UUID.randomUUID().toString().replaceAll("-","");
            TbServiceAndAdvisor advisor = new TbServiceAndAdvisor();
            advisor.setId(uuid);
            advisor.setProductId(productId);
            advisor.setAdvisorAccount(advisorAccount);
            advisorList.add(advisor);
        }
        advisorDao.addServiceAdvisor(advisorList);
    }

    /**
     * 编辑产品并启动IBPS
     * @param content 入参
     * @param account 账号
     * @param templateId 模板ID
     * @param tbServiceProduct 需要删除的产品
     */
    public void startProductIbps(ServiceContent content, String account, String templateId, TbServiceProduct tbServiceProduct){
        String state = addServiceProduct(content, account, templateId);

        // ibps启动成功删除数据
        if ("200".equals(state)) {
            tbServiceProduct.setRecordStatus(RecordStatusEnum.DELETE.getValue());
            tbServiceProductMapper.updateByPrimaryKeySelective(tbServiceProduct);

            TbServiceAndAdvisorCriteria tbServiceAndAdvisorCriteria = new TbServiceAndAdvisorCriteria();
            tbServiceAndAdvisorCriteria.createCriteria().andProductIdEqualTo(tbServiceProduct.getProductId());
            tbServiceAndAdvisorMapper.deleteByExample(tbServiceAndAdvisorCriteria);
        } else {
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_SEND_ERROR);
        }
    }
}
