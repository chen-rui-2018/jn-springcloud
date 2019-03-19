package com.jn.enterprise.technologyfinancial.financial.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductAssureTypeMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductLoanTypeMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.*;
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

import java.util.ArrayList;
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
        if(financialProductListParam==null || StringUtils.isBlank(financialProductListParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam);
            return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(financialProductListParam.getNeedPage())){
            objects = PageHelper.startPage(financialProductListParam.getPage(),
                    financialProductListParam.getRows() == 0 ? 15 : financialProductListParam.getRows(), true);
        }
        List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam);
        return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 金融产品详情
     * @param productId 产品id
     * @return
     */
    @ServiceLog(doAction = "金融产品详情")
    @Override
    public FinacialProductDetails getFinancialProductDetails(String productId) {
        TbServiceProductCriteria example=new TbServiceProductCriteria();
        example.createCriteria().andProductIdEqualTo(productId).andStatusEqualTo("1")
                .andSignoryIdEqualTo(BUSINESS_AREA).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceProduct> tbServiceProductList = tbServiceProductMapper.selectByExample(example);
        if(tbServiceProductList.isEmpty()){
            return null;
        }
        TbServiceProduct tbServiceProduct = tbServiceProductList.get(0);
        FinacialProductDetails finacialProductDetails=new FinacialProductDetails();
        BeanUtils.copyProperties(tbServiceProduct, finacialProductDetails);
        return finacialProductDetails;
    }

    /**
     * 金融产品贷款类别
     * @return
     */
    @Override
    public List<FinacialProductLoanType> getFinancialProductLoanType() {
        TbServiceProductLoanTypeCriteria example=new TbServiceProductLoanTypeCriteria();
        example.createCriteria().andLoanCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceProductLoanType> tbServiceProductLoanTypeList = tbServiceProductLoanTypeMapper.selectByExample(example);
        if(tbServiceProductLoanTypeList.isEmpty()){
            return null;
        }else{
            List<FinacialProductLoanType> resultList=new ArrayList<>(16);
            for(TbServiceProductLoanType loanType:tbServiceProductLoanTypeList){
                FinacialProductLoanType finacialProductLoanType=new FinacialProductLoanType();
                finacialProductLoanType.setLoanCode(loanType.getLoanCode());
                finacialProductLoanType.setLoanName(loanType.getLoanName());
                resultList.add(finacialProductLoanType);
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
        technologyInfoNum.setInvestorsNum(getInvestorNum()+"");
        //金融产品数
        technologyInfoNum.setFinancialProductNum(getFinancialProductNum()+"");
        //金融机构数
        technologyInfoNum.setFinancialOrgNum(getFinancialOrgNum()+"");
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
        example.createCriteria().andOrgIdIsNotNull().andBusinessSTypeEqualTo(BUSINESS_AREA)
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
        String approvalStatus="1";
        example.createCriteria().andInvestorAccountIsNotNull().andStatusEqualTo(status)
                .andApprovalStatusEqualTo(approvalStatus).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceInvestorMapper.countByExample(example);
    }
}
