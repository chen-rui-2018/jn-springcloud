package com.jn.enterprise.technologyfinancial.financial.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.FinancialProductExceptionEnum;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductAssureTypeMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductLoanTypeMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.*;
import com.jn.enterprise.servicemarket.product.enums.ProductConstantEnum;
import com.jn.enterprise.servicemarket.product.model.CommonServiceShelf;
import com.jn.enterprise.technologyfinancial.financial.product.dao.FinancialProductMapper;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.system.log.annotation.ServiceLog;
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
     * 日志组件
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

    /**
     * 数据状态 0：已删除   1：有效
     */
    private static final byte RECORD_STATUS=1;

    /**
     * 业务领域:科技金融
     */
    private static final String BUSINESS_AREA="technology_finance";

    /**
     * 金融产品列表查询
     * @param financialProductListParam 查询条件
     * @return
     */
    @ServiceLog(doAction = "金融产品列表查询")
    @Override
    public PaginationData getFinancialProductList(FinancialProductListParam financialProductListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(financialProductListParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam,BUSINESS_AREA);
            return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(financialProductListParam.getNeedPage())){
            objects = PageHelper.startPage(financialProductListParam.getPage(),
                    financialProductListParam.getRows() == 0 ? 15 : financialProductListParam.getRows(), true);
        }
        List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam,BUSINESS_AREA);
        return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 金融产品详情
     * @param productId 产品id
     * @return
     */
    @ServiceLog(doAction = "金融产品详情")
    @Override
    public FinancialProductDetails getFinancialProductDetails(String productId) {
        FinancialProductDetails financialProductDetails = financialProductMapper.getFinancialProductDetails(productId, BUSINESS_AREA);
        if(financialProductDetails==null){
            return null;
        }
        //更新浏览次数
        updateProductViewNum(productId);
        return financialProductDetails;
    }

    /**
     * 更新产品浏览次数
     * @param productId
     */
    @ServiceLog(doAction = "更新产品浏览次数")
    private void updateProductViewNum(String productId) {
        TbServiceProductCriteria example=new TbServiceProductCriteria();
        example.createCriteria().andProductIdEqualTo(productId).andSignoryIdEqualTo(BUSINESS_AREA).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceProduct> tbServiceProductList = tbServiceProductMapper.selectByExample(example);
        if(tbServiceProductList.isEmpty()){
            logger.info("金融产品详情获取失败，当前产品[id:{}]在系统中不存在",productId);
            throw new JnSpringCloudException(FinancialProductExceptionEnum.PRODUCT_NOT_EXIST);
        }
        Integer viewCount = tbServiceProductList.get(0).getViewCount();
        int viewNum=viewCount==null?0:viewCount+1;
        TbServiceProduct tbServiceProduct=new TbServiceProduct();
        tbServiceProduct.setViewCount(viewNum);
        tbServiceProductMapper.updateByExampleSelective(tbServiceProduct,example );
    }

    /**
     * 金融产品贷款类别
     * @return
     */
    @ServiceLog(doAction = "金融产品贷款类别")
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
     * 金融产品担保方式
     * @return
     */
    @ServiceLog(doAction = "金融产品担保方式")
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
     * 科技金融首页投资人数，金融产品数，金融机构数
     * @return
     */
    @ServiceLog(doAction = "科技金融首页投资人数，金融产品数，金融机构数")
    @Override
    public TechnologyInfoNum getTechnologyInfoNum() {
        TechnologyInfoNum technologyInfoNum=new TechnologyInfoNum();
        //投资人个数
        technologyInfoNum.setInvestorsNum(getInvestorNum());
        //金融产品数
        technologyInfoNum.setFinancialProductNum(getFinancialProductNum());
        //金融机构数
        technologyInfoNum.setFinancialOrgNum(getFinancialOrgNum());
        return technologyInfoNum;
    }

    /**
     * 获取金融机构数
     * @return
     */
    @ServiceLog(doAction = "获取金融机构数")
    private long getFinancialOrgNum() {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        //状态为审核通过，机构id不为空，
        String status="1";
        example.createCriteria().andOrgIdIsNotNull().andBusinessTypeEqualTo(BUSINESS_AREA)
                .andOrgStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceOrgMapper.countByExample(example);
    }

    /**
     * 获取金融产品数
     * @return
     */
    @ServiceLog(doAction = "获取金融产品数")
    private long getFinancialProductNum() {
        TbServiceProductCriteria example=new TbServiceProductCriteria();
        //状态为有效，机构id不为空，
        String status="1";
        example.createCriteria().andSignoryIdEqualTo(BUSINESS_AREA).andOrgIdIsNotNull()
                .andStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceProductMapper.countByExample(example);
    }

    /**
     * 获取投资人个数
     * @return
     */
    @ServiceLog(doAction = "获取投资人个数")
    private long getInvestorNum() {
        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        //状态为有效，审批状态为审批通过
        String status="1";
        example.createCriteria().andInvestorAccountIsNotNull().andStatusEqualTo(status)
                .andApprovalStatusEqualTo(ApprovalStatusEnum.APPROVED.getValue()).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceInvestorMapper.countByExample(example);
    }

    /**
     * author:chenr
     * @param info
     */
    @ServiceLog(doAction = "新增科技金融产品的常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addFinancialProduct(FinancialProductAddInfo info,String account) {
        //记录状态
        Byte recordStatus =  new Byte(ProductConstantEnum.RECORD_STATUS_EFFECTIVE.getCode());
        //产品状态(正常)
        String normalStatus =ProductConstantEnum.PRODUCT_STATUS_EFFECTIVE.getCode();
        //产品状态(待审核)
        String approvalStatus =ProductConstantEnum.PRODUCT_STATUS_APPROVAL.getCode();
        //产品类型(特色产品)
        String featureType = ProductConstantEnum.PRODUCT_FEATURE_TYPE.getCode();
        //如果添加特色产品,常规产品则添加重名校验(上架常规产品则不校验)
        if(featureType.equals(info.getProductType()) || info.getTemplateId() ==null) {
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductNameEqualTo(info.getProductName());
            List<TbServiceProduct> productList = tbServiceProductMapper.selectByExample(criteria);
            if (productList != null && productList.size() > 0) {
                logger.warn("[服务产品新增]，服务产品名称{}不能重复：productName: {},服务产品名称{}不能重复!");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE);
            }
        }
        //补充bean的信息
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
        //根据机构上架产品则要进行审核
        if(StringUtils.isNotBlank(product.getOrgId())){
            product.setStatus(approvalStatus);
        }else{
            product.setStatus(normalStatus);
        }
        tbServiceProductMapper.insertSelective(product);

    }

    /**
     * author chenr
     * @param commonService
     * @param account
     */
    @ServiceLog(doAction = "上架科技金融产品的常规产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void upShelfCommonProduct(CommonServiceShelf commonService, String account) {
        Byte recordStatus = 1;
        String templateId = commonService.getTemplateId();
        //同机构不能再上架已上架产品
        TbServiceProductCriteria criteria = new TbServiceProductCriteria();
        criteria.createCriteria().andTemplateIdEqualTo(templateId).andRecordStatusEqualTo(recordStatus);
        List<TbServiceProduct> productList=tbServiceProductMapper.selectByExample(criteria);
        for(TbServiceProduct product : productList){
             if(commonService.getOrgId().equals(product.getOrgId())){
                 throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_OWNED_PRODUCT);
             }
         }
        TbServiceProduct product= tbServiceProductMapper.selectByPrimaryKey(templateId);
        FinancialProductAddInfo info = new FinancialProductAddInfo();
        BeanUtils.copyProperties(product,info);
        info.setOrgId(commonService.getOrgId());
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
        //设置机构名称
        if (StringUtils.isNotBlank(commonService.getOrgId())){
            TbServiceOrg org= tbServiceOrgMapper.selectByPrimaryKey(commonService.getOrgId());
            if(org!=null){
                info.setOrgName(org.getOrgName());
            }
        }
        addFinancialProduct(info,account);
    }

    /**
     * author chenr
     * @param info
     * @param account
     */
    @ServiceLog(doAction = "上架科技金融产品的特色产品")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void upShelfFeatureProduct(FinancialProductAddInfo info, String account) {
        //设置机构名称
        if (StringUtils.isNotBlank(info.getOrgId())){
            TbServiceOrg org= tbServiceOrgMapper.selectByPrimaryKey(info.getOrgId());
            if(org!=null){
                info.setOrgName(org.getOrgName());
            }
        }
        info.setTemplateId(info.getProductId());
        addFinancialProduct(info,account);
    }
    @ServiceLog(doAction = "更新科技金融产品")
    @Override
    public int modifyFeatureProduct(FinancialProductModifyParam product, String account) {
        TbServiceProduct product1 = tbServiceProductMapper.selectByPrimaryKey(product.getProductId());
        // 若名字修改则进行 重名校验
        if(!product1.getProductName().equals(product.getProductName())) {
            TbServiceProductCriteria criteria = new TbServiceProductCriteria();
            criteria.createCriteria().andProductNameEqualTo(product.getProductName());
            List<TbServiceProduct> productList = tbServiceProductMapper.selectByExample(criteria);
            if (productList != null && productList.size() > 1) {
                logger.warn("[服务产品新增]，服务产品名称{}不能重复：productName: {},服务产品名称{}不能重复!");
                throw new JnSpringCloudException(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE);
            }
        }
        TbServiceProduct tbServiceProduct = new TbServiceProduct();
        BeanUtils.copyProperties(product,tbServiceProduct);
        if(product.getRefRateMin()!=null && product.getRefRateMax()!=null ) {
            tbServiceProduct.setRefRateMin(Double.valueOf(product.getRefRateMin()));
            tbServiceProduct.setRefRateMax(Double.valueOf(product.getRefRateMax()));
        }
        if(product.getLoanAmountMin()!= null && product.getLoanAmountMax()!=null){
            tbServiceProduct.setLoanAmountMin(Double.valueOf(product.getLoanAmountMin()));
            tbServiceProduct.setLoanAmountMax(Double.valueOf(product.getLoanAmountMax()));
        }
        if(product.getLoanTermMin()!= null && product.getLoanTermMax()!=null){
            tbServiceProduct.setLoanTermMax(Integer.valueOf(product.getLoanTermMax()));
            tbServiceProduct.setLoanTermMin(Integer.valueOf(product.getLoanTermMin()));
        }
        tbServiceProduct.setModifierAccount(account);
        tbServiceProduct.setModifiedTime(new Date());
        int i =tbServiceProductMapper.updateByPrimaryKeySelective(tbServiceProduct);
        return i;
    }
}
