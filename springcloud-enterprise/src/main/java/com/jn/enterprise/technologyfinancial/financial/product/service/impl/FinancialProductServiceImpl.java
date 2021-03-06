package com.jn.enterprise.technologyfinancial.financial.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.common.config.IBPSDefIdConfig;
import com.jn.enterprise.enums.FinancialProductExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductAssureTypeMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductLoanTypeMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.*;
import com.jn.enterprise.servicemarket.product.enums.ProductConstantEnum;
import com.jn.enterprise.servicemarket.product.model.CommonServiceShelf;
import com.jn.enterprise.servicemarket.product.model.WebAddFeatureProduct;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.enterprise.technologyfinancial.financial.product.dao.FinancialProductMapper;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/18 19:36
 * @Version v1.0
 * @modified By:
 */
@Service
public class FinancialProductServiceImpl implements FinancialProductService {
    /**
     * ????????????
     */
    private static Logger logger = LoggerFactory.getLogger(FinancialProductServiceImpl.class);

    @Autowired
    private FinancialProductMapper financialProductMapper;

    @Autowired
    private TbServiceProductMapper tbServiceProductMapper;

    @Autowired
    private TbServiceProductLoanTypeMapper tbServiceProductLoanTypeMapper;

    @Autowired
    private TbServiceProductAssureTypeMapper tbServiceProductAssureTypeMapper;

    @Autowired
    private TbServiceInvestorMapper tbServiceInvestorMapper;

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    @Autowired
    private ServiceProductService serviceProductService;

    @Autowired
    private IBPSDefIdConfig ibpsDefIdConfig;

    /**
     * ???????????? 0????????????   1?????????
     */
    private static final byte RECORD_STATUS=1;

    /**
     * ????????????:????????????
     */
    private static final String BUSINESS_AREA="technology_finance";

    /**
     * ????????????????????????
     * @param financialProductListParam ????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public PaginationData getFinancialProductList(FinancialProductListParam financialProductListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(financialProductListParam.getNeedPage())){
            //???????????????1??????15?????????
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam,BUSINESS_AREA);
            return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
        }
        //??????????????????
        String isPage="1";
        if(isPage.equals(financialProductListParam.getNeedPage())){
            objects = PageHelper.startPage(financialProductListParam.getPage(),
                    financialProductListParam.getRows() == 0 ? 15 : financialProductListParam.getRows(), true);
        }
        List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam,BUSINESS_AREA);

        // ??????????????????
        if (financialProductList != null && !financialProductList.isEmpty()) {
            for (FinancialProductListInfo product : financialProductList) {
                if (StringUtils.isNotBlank(product.getPictureUrl())) {
                    product.setPictureUrl(IBPSFileUtils.getFilePath(product.getPictureUrl()));
                }
            }
        }
        return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * ??????????????????
     * @param productId ??????id
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    @Override
    public FinancialProductDetails getFinancialProductDetails(String productId) {
        FinancialProductDetails financialProductDetails = financialProductMapper.getFinancialProductDetails(productId, BUSINESS_AREA);
        if(financialProductDetails==null){
            return null;
        }
        //??????????????????
        updateProductViewNum(productId);

        // ??????????????????
        if (StringUtils.isNotBlank(financialProductDetails.getPictureUrl())) {
            financialProductDetails.setPictureUrl(IBPSFileUtils.getFilePath(financialProductDetails.getPictureUrl()));
        }
        return financialProductDetails;
    }

    /**
     * ????????????????????????
     * @param productId
     */
    @ServiceLog(doAction = "????????????????????????")
    private void updateProductViewNum(String productId) {
        TbServiceProductCriteria example=new TbServiceProductCriteria();
        example.createCriteria().andProductIdEqualTo(productId).andSignoryIdEqualTo(BUSINESS_AREA).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceProduct> tbServiceProductList = tbServiceProductMapper.selectByExample(example);
        if(tbServiceProductList.isEmpty()){
            logger.info("?????????????????????????????????????????????[id:{}]?????????????????????",productId);
            throw new JnSpringCloudException(FinancialProductExceptionEnum.PRODUCT_NOT_EXIST);
        }
        Integer viewCount = tbServiceProductList.get(0).getViewCount();
        int viewNum=viewCount==null?0:viewCount+1;
        TbServiceProduct tbServiceProduct=new TbServiceProduct();
        tbServiceProduct.setViewCount(viewNum);
        tbServiceProductMapper.updateByExampleSelective(tbServiceProduct,example );
    }

    /**
     * ????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public List<FinancialProductLoanType> getFinancialProductLoanType() {
        TbServiceProductLoanTypeCriteria example=new TbServiceProductLoanTypeCriteria();
        example.createCriteria().andLoanCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceProductLoanType> tbServiceProductLoanTypeList = tbServiceProductLoanTypeMapper.selectByExample(example);
        if(tbServiceProductLoanTypeList.isEmpty()){
            return null;
        }else{
            List<FinancialProductLoanType> resultList=new ArrayList<>(16);
            for(TbServiceProductLoanType loanType:tbServiceProductLoanTypeList){
                FinancialProductLoanType financialProductLoanType =new FinancialProductLoanType();
                financialProductLoanType.setLoanCode(loanType.getLoanCode());
                financialProductLoanType.setLoanName(loanType.getLoanName());
                resultList.add(financialProductLoanType);
            }
            return resultList;
        }
    }

    /**
     * ????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public List<FinancialProductAssureType> getFinancialProductAssureType() {
        TbServiceProductAssureTypeCriteria example=new TbServiceProductAssureTypeCriteria();
        example.createCriteria().andAssureCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceProductAssureType> tbServiceProductAssureTypeList = tbServiceProductAssureTypeMapper.selectByExample(example);
        if(tbServiceProductAssureTypeList.isEmpty()){
            return null;
        }else{
            List<FinancialProductAssureType> resultList=new ArrayList<>(16);
            for(TbServiceProductAssureType loanType:tbServiceProductAssureTypeList){
                FinancialProductAssureType financialProductAssureType =new FinancialProductAssureType();
                financialProductAssureType.setAssureCode(loanType.getAssureCode());
                financialProductAssureType.setAssureName(loanType.getAssureName());
                resultList.add(financialProductAssureType);
            }
            return resultList;
        }
    }

    /**
     * ??????????????????????????????????????????????????????????????????
     * @return
     */
    @ServiceLog(doAction = "??????????????????????????????????????????????????????????????????")
    @Override
    public TechnologyInfoNum getTechnologyInfoNum() {
        TechnologyInfoNum technologyInfoNum=new TechnologyInfoNum();
        //???????????????
        technologyInfoNum.setInvestorsNum(getInvestorNum());
        //???????????????
        technologyInfoNum.setFinancialProductNum(getFinancialProductNum());
        //???????????????
        technologyInfoNum.setFinancialOrgNum(getFinancialOrgNum());
        return technologyInfoNum;
    }

    /**
     * ?????????????????????
     * @return
     */
    @ServiceLog(doAction = "?????????????????????")
    private long getFinancialOrgNum() {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        //??????????????????????????????id????????????
        String status="1";
        example.createCriteria().andOrgIdIsNotNull().andBusinessTypeEqualTo(BUSINESS_AREA)
                .andOrgStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceOrgMapper.countByExample(example);
    }

    /**
     * ?????????????????????
     * @return
     */
    @ServiceLog(doAction = "?????????????????????")
    private long getFinancialProductNum() {
        TbServiceProductCriteria example=new TbServiceProductCriteria();
        //????????????????????????id????????????
        String status="1";
        example.createCriteria().andSignoryIdEqualTo(BUSINESS_AREA).andOrgIdIsNotNull().andOrgIdNotEqualTo("")
                .andStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceProductMapper.countByExample(example);
    }

    /**
     * ?????????????????????
     * @return
     */
    @ServiceLog(doAction = "?????????????????????")
    private long getInvestorNum() {
        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        //?????????????????????????????????????????????
        String status="1";
        example.createCriteria().andInvestorAccountIsNotNull().andStatusEqualTo(status)
                .andApprovalStatusEqualTo(ApprovalStatusEnum.APPROVED.getValue()).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceInvestorMapper.countByExample(example);
    }

    /**
     * author:chenr
     * @param info
     */
    @ServiceLog(doAction = "???????????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addFinancialProduct(FinancialProductAddInfo info,String account) {
        //????????????
        Byte recordStatus =  RecordStatusEnum.EFFECTIVE.getValue();
        //????????????(??????)
        String normalStatus =ProductConstantEnum.PRODUCT_STATUS_EFFECTIVE.getCode();
        //????????????(?????????)
        String approvalStatus =ProductConstantEnum.PRODUCT_STATUS_APPROVAL.getCode();
        //????????????(????????????)
        String featureType = ProductConstantEnum.PRODUCT_FEATURE_TYPE.getCode();
        //????????????????????????,?????????????????????????????????(??????????????????????????????)
        if(featureType.equals(info.getProductType()) || info.getTemplateId() ==null) {
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductNameEqualTo(info.getProductName());
            List<TbServiceProduct> productList = tbServiceProductMapper.selectByExample(criteria);
            if (productList != null && productList.size() > 0) {
                logger.warn("[??????????????????]?????????????????????{}???????????????productName: {},??????????????????{}????????????!");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE);
            }
        }
        //??????bean?????????
        TbServiceProduct product = new TbServiceProduct();
        BeanUtils.copyProperties(info,product);
        if(info.getRefRateMin()!=null && info.getRefRateMax()!=null ){
            product.setRefRateMin(Double.valueOf(info.getRefRateMin()));
            product.setRefRateMax(Double.valueOf(info.getRefRateMax()));
        }
        if(info.getLoanAmountMin()!= null && info.getLoanAmountMax()!=null){
            product.setLoanAmountMin(Double.valueOf(info.getLoanAmountMin()));
            product.setLoanAmountMax(Double.valueOf(info.getLoanAmountMax()));
        }
        if(info.getLoanTermMin()!= null && info.getLoanTermMax()!=null){
            product.setLoanTermMax(Integer.valueOf(info.getLoanTermMax()));
            product.setLoanTermMin(Integer.valueOf(info.getLoanTermMin()));
        }
        product.setCreatedTime(new Date());
        product.setCreatorAccount(account);
        product.setRecordStatus(recordStatus);
        product.setReleaseTime(product.getCreatedTime());
        //??????????????????????????????????????????
        if(StringUtils.isNotBlank(product.getOrgId())){
            product.setStatus(approvalStatus);
        }else{
            product.setStatus(normalStatus);
        }
        tbServiceProductMapper.insertSelective(product);

    }

    public String addWebFinancialProduct(FinancialProductAddInfo info, String account) {
        //????????????
        Byte recordStatus =  RecordStatusEnum.EFFECTIVE.getValue();
        //????????????(????????????)
        String featureType = ProductConstantEnum.PRODUCT_FEATURE_TYPE.getCode();

        //????????????????????????,???????????????????????????
        if(featureType.equals(info.getProductType()) && StringUtils.isBlank(info.getProductId())) {
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductNameEqualTo(info.getProductName()).andRecordStatusEqualTo(recordStatus)
                    .andStatusNotEqualTo(ProductConstantEnum.PRODUCT_STATUS_APPROVAL_NOT_PASS.getCode());
            List<TbServiceProduct> productList = tbServiceProductMapper.selectByExample(criteria);
            if (productList != null && productList.size() > 0) {
                logger.warn("[??????????????????]?????????????????????{}???????????????productName: {},??????????????????{}????????????!");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE);
            }
        }

        //??????bean?????????
        WebAddFeatureProduct product = new WebAddFeatureProduct();
        BeanUtils.copyProperties(info,product);
        product.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        product.setCreatorAccount(account);
        product.setRecordStatus(recordStatus.toString());
        product.setStatus(ProductConstantEnum.PRODUCT_STATUS_APPROVAL.getCode());
        product.setSignoryId("technology_finance");
        product.setSignoryName("????????????");
        product.setProductId("");

        if (StringUtils.isNotBlank(info.getCreatedTime())) {
            product.setModifiedTime(info.getCreatedTime());
            product.setModifierAccount(info.getCreatorAccount());
        }
        if (StringUtils.isBlank(product.getViewCount())) {
            product.setViewCount("0");
        }

        // ??????????????????
        product.setPictureUrl(IBPSFileUtils.uploadFile2Json(account, product.getPictureUrl()));

        // ??????IBPS??????
        String bpmnDefId = ibpsDefIdConfig.getTechnologyProduct();
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(bpmnDefId, account, product);

        // ibps??????????????????
        if (ibpsResult == null || !ibpsResult.getState().equals("200")) {
            logger.warn("[????????????????????????] ??????ibps??????????????????????????????{}", ibpsResult != null ? ibpsResult.getMessage() : "");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_SUBMIT_IBPS_ERROR);
        }
        logger.info("[????????????????????????] " + ibpsResult.getMessage());

        return ibpsResult.getState();

    }

    /**
     * author chenr
     * @param commonService
     * @param account
     */
    @ServiceLog(doAction = "???????????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void upShelfCommonProduct(CommonServiceShelf commonService, String account) {
        // ??????????????????????????????
        UserExtensionInfo userExtension = serviceProductService.getUserExtensionByAccount(account);
        String orgId = userExtension.getAffiliateCode();

        String templateId = commonService.getTemplateId();
        serviceProductService.checkTemplateProduct(templateId, orgId, commonService.getProductId());

        TbServiceProduct product = tbServiceProductMapper.selectByPrimaryKey(templateId);
        // ????????????????????????
        if (product == null) {
            logger.warn("[???????????????????????????????????????] ??????{}??????", templateId);
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_TEMPLATE_NOT_EXIST);
        }

        FinancialProductAddInfo info = new FinancialProductAddInfo();
        BeanUtils.copyProperties(product,info);
        info.setOrgId(orgId);
        info.setOrgName(userExtension.getAffiliateName());
        info.setTemplateId(templateId);
        info.setProductId(commonService.getProductId());
        if(product.getRefRateMin()!=null && product.getRefRateMax()!=null ) {
            info.setRefRateMin(String.valueOf(product.getRefRateMin()));
            info.setRefRateMax(String.valueOf(product.getRefRateMax()));
        }
        if(product.getLoanAmountMin()!= null && product.getLoanAmountMax()!=null){
            info.setLoanAmountMin(String.valueOf(product.getLoanAmountMin()));
            info.setLoanAmountMax(String.valueOf(product.getLoanAmountMax()));
        }
        if(product.getLoanTermMin()!= null && product.getLoanTermMax()!=null){
            info.setLoanTermMax(String.valueOf(product.getLoanTermMax()));
            info.setLoanTermMin(String.valueOf(product.getLoanTermMin()));
        }
        addWebFinancialProduct(info,account);
    }

    /**
     * author chenr
     * @param info
     * @param account
     */
    @ServiceLog(doAction = "???????????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void upShelfFeatureProduct(FinancialProductAddInfo info, String account) {
        // ??????????????????????????????
        UserExtensionInfo userExtension = serviceProductService.getUserExtensionByAccount(account);
        String orgId = userExtension.getAffiliateCode();
        info.setOrgId(orgId);
        info.setOrgName(userExtension.getAffiliateName());
        info.setProductType(ProductConstantEnum.PRODUCT_FEATURE_TYPE.getCode());
        info.setViewCount("0");
        addWebFinancialProduct(info, account);
    }

    @ServiceLog(doAction = "????????????????????????")
    @Override
    public int modifyFeatureProduct(FinancialProductModifyParam product, String account) {
        TbServiceProduct tbServiceProduct = serviceProductService.getCanUpdateProduct(product.getProductId());

        // ??????????????????????????????
        UserExtensionInfo userExtension = serviceProductService.getUserExtensionByAccount(account);
        String orgId = userExtension.getAffiliateCode();

        FinancialProductAddInfo info = new FinancialProductAddInfo();
        BeanUtils.copyProperties(tbServiceProduct, info);
        info.setOrgId(orgId);
        info.setOrgName(userExtension.getAffiliateName());
        info.setProductType(ProductConstantEnum.PRODUCT_FEATURE_TYPE.getCode());
        BeanUtils.copyProperties(product, info);
        info.setViewCount(tbServiceProduct.getViewCount().toString());
        info.setCreatedTime(DateUtils.formatDate(tbServiceProduct.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
        info.setCreatorAccount(tbServiceProduct.getCreatorAccount());
        String state = addWebFinancialProduct(info, account);

        // ibps????????????????????????
        if ("200".equals(state)) {
            tbServiceProduct.setRecordStatus(RecordStatusEnum.DELETE.getValue());
            tbServiceProductMapper.updateByPrimaryKeySelective(tbServiceProduct);
        } else {
            logger.warn("????????????????????????");
            throw new JnSpringCloudException(ServiceProductExceptionEnum.PRODUCT_SEND_ERROR);
        }
        return 1;
    }
    @ServiceLog(doAction = "?????????????????????????????????")
    @Override
    public PaginationData getOrgFinancialProductList(FinancialOrgProductParam financialOrgProductParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(financialOrgProductParam.getNeedPage())){
            //???????????????1??????15?????????
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<FinancialProductListInfo> financialProductList = financialProductMapper.getOrgFinancialProductList(financialOrgProductParam,BUSINESS_AREA);
            return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
        }
        //??????????????????
        String isPage="1";
        if(isPage.equals(financialOrgProductParam.getNeedPage())){
            objects = PageHelper.startPage(financialOrgProductParam.getPage(),
                    financialOrgProductParam.getRows() == 0 ? 15 : financialOrgProductParam.getRows(), true);
        }
        List<FinancialProductListInfo> financialProductList = financialProductMapper.getOrgFinancialProductList(financialOrgProductParam,BUSINESS_AREA);

        // ??????????????????
        if (financialProductList != null && !financialProductList.isEmpty()) {
            for (FinancialProductListInfo product : financialProductList) {
                if (StringUtils.isNotBlank(product.getPictureUrl())) {
                    product.setPictureUrl(IBPSFileUtils.getFilePath(product.getPictureUrl()));
                }
            }
        }
        return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
    }

}
