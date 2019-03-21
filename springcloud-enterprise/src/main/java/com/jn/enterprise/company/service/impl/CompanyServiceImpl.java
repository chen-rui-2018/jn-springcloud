package com.jn.enterprise.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.enums.CompanyExceptionEnum;
import com.jn.company.model.CompanyProImg;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyProImgMapper;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.company.entity.TbServiceCompanyProImg;
import com.jn.enterprise.company.entity.TbServiceCompanyProImgCriteria;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 企业信息Service
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:52
 * @version： v1.0
 * @modified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private static Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;
    @Autowired
    private TbServicePreferMapper tbServicePreferMapper;
    @Autowired
    private TbServiceCompanyProImgMapper tbServiceCompanyProImgMapper;
    /**
     * 数据状态 1有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    private static final String PATTERN="yyyy-MM-dd";
    private static final String PATTERN_DETAIL="yyyy-MM-dd HH:mm:ss";

    @Override
    @ServiceLog(doAction = "查询企业列表")
    public PaginationData<List<ServiceCompany>> getCompanyList(ServiceCompanyParam companyParam){
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        TbServiceCompanyCriteria.Criteria criteria = companyCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        if(StringUtils.isNotEmpty(companyParam.getComName())){
            criteria.andComNameLike("%"+companyParam.getComName()+"%");
        }
        if(StringUtils.isNotEmpty(companyParam.getParkBuildId())){
            criteria.andParkBuildIdLike("%"+companyParam.getParkBuildId()+"%");
        }
        if(StringUtils.isNotEmpty(companyParam.getParkBuildName())){
            criteria.andParkBuildNameLike("%"+companyParam.getParkBuildName()+"%");
        }
        if(StringUtils.isNotEmpty(companyParam.getIsJoinActivity())){
            criteria.andIsJoinActivityEqualTo(companyParam.getIsJoinActivity());
        }
        if(StringUtils.isNotEmpty(companyParam.getComSource())){
            criteria.andComSourceEqualTo(companyParam.getComSource());
        }
        if(StringUtils.isNotEmpty(companyParam.getCheckStatus())){
            criteria.andCheckStatusEqualTo(companyParam.getCheckStatus());
        }
        if(StringUtils.isNotEmpty(companyParam.getComAdmin())){
            criteria.andComAdminEqualTo(companyParam.getComAdmin());
        }
        if(StringUtils.isNotEmpty(companyParam.getComType())){
            criteria.andComTypeEqualTo(companyParam.getComType());
        }
        Page<Object> objects = PageHelper.startPage(companyParam.getPage(), companyParam.getRows() == 0 ? 15 : companyParam.getRows());
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        List<ServiceCompany> companies = new ArrayList<>(16);
        for (TbServiceCompany t:tbServiceCompanies) {
            ServiceCompany company = new ServiceCompany();
            BeanUtils.copyProperties(t,company);
            companies.add(company);
        }
        PaginationData<List<ServiceCompany>> data = new PaginationData(companies, objects.getTotal());
        return data;
    }


    @Override
    @ServiceLog(doAction = "根据用户账号查询企业信息（用户为企业管理员）")
    public ServiceCompany getCompanyDetailByAccountOrId(String accountOrId){
        if(StringUtils.isEmpty(accountOrId)){
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_ID_INFO_NOT_NULL);
        }
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andComAdminEqualTo(accountOrId);
        TbServiceCompanyCriteria companyCriteria1 = new TbServiceCompanyCriteria();
        TbServiceCompanyCriteria.Criteria criteria = companyCriteria1.createCriteria().andIdEqualTo(accountOrId);
        companyCriteria.or(criteria);
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        if(null == tbServiceCompanies || tbServiceCompanies.size() == 0){
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_INFO_NOT_EXIST);
        }
        TbServiceCompany tbServiceCompany = tbServiceCompanies.get(0);
        ServiceCompany company = new ServiceCompany();
        BeanUtils.copyProperties(tbServiceCompany, company);

        //查询企业字段数据
        TbServicePreferCriteria preferCriteria = new TbServicePreferCriteria();
        List<TbServicePrefer> tbServicePrefers = tbServicePreferMapper.selectByExample(preferCriteria);
        String[] comProperty = tbServiceCompany.getComProperty().split(",");
        List<String> comPropertys = new ArrayList<>(16);
        company.setComPropertys(comProperty);
        for (TbServicePrefer prefer: tbServicePrefers
             ) {
            // 行业领域
            if(StringUtils.equals(prefer.getId(),tbServiceCompany.getInduType())){
                company.setInduTypeName(prefer.getPreValue());
            }
            // 企业性质
            for (String s: comProperty
                 ) {
                if(StringUtils.equals(s,prefer.getId())){
                    comPropertys.add(prefer.getPreValue());
                }
            }
        }
        if(null != tbServiceCompany.getFoundingTime()){
            company.setFoundingTime(DateUtils.formatDate(tbServiceCompany.getFoundingTime(),PATTERN));
        }
        if(null != tbServiceCompany.getRunTime()){
            company.setRunTime(DateUtils.formatDate(tbServiceCompany.getRunTime(),PATTERN));
        }
        if(null != tbServiceCompany.getLicStarttime()){
            company.setLicStarttime(DateUtils.formatDate(tbServiceCompany.getLicStarttime(),PATTERN));
        }
        if(null != tbServiceCompany.getLicEndtime()){
            company.setLicEndtime(DateUtils.formatDate(tbServiceCompany.getLicEndtime(),PATTERN));
        }
        if(null != tbServiceCompany.getCheckTime()){
            company.setCheckTime(DateUtils.formatDate(tbServiceCompany.getCheckTime(),PATTERN_DETAIL));
        }
        if(null != tbServiceCompany.getCreatedTime()){
            company.setCreatedTime(DateUtils.formatDate(tbServiceCompany.getCreatedTime(),PATTERN_DETAIL));
        }
        if(null != tbServiceCompany.getModifiedTime()){
            company.setModifiedTime(DateUtils.formatDate(tbServiceCompany.getModifiedTime(),PATTERN_DETAIL));
        }
        if(null != comPropertys && comPropertys.size()>0){
            company.setComPropertyNames(comPropertys.toArray(new String[comPropertys.size()]));
        }

        TbServiceCompanyProImgCriteria imgCriteria = new TbServiceCompanyProImgCriteria();
        imgCriteria.createCriteria().andComIdEqualTo(tbServiceCompany.getId());
        List<TbServiceCompanyProImg> tbServiceCompanyProImgs = tbServiceCompanyProImgMapper.selectByExample(imgCriteria);
        List<CompanyProImg> imgs = new ArrayList<>(16);
        for (TbServiceCompanyProImg img:tbServiceCompanyProImgs
             ) {
            CompanyProImg proImg = new CompanyProImg();
            BeanUtils.copyProperties(img,proImg);
            imgs.add(proImg);
        }
        company.setProImgs(imgs);
        return company;
    }

}
