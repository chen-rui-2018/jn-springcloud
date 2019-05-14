package com.jn.enterprise.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.enums.CompanyExceptionEnum;
import com.jn.company.model.*;
import com.jn.enterprise.common.config.IBPSDefIdConfig;
import com.jn.enterprise.company.dao.CompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyProImgMapper;
import com.jn.enterprise.company.entity.*;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.model.CompanyUpdateParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.enums.JoinParkExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.api.CareClient;
import com.jn.park.api.CommentClient;
import com.jn.park.care.model.CareParam;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private CommentClient commentClient;
    @Autowired
    private StaffService staffService;
    @Autowired
    private CareClient careClient;
    @Autowired
    private IBPSDefIdConfig ibpsDefIdConfig;

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
        TbServiceCompanyCriteria.Criteria criteria = companyCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
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
        if(StringUtils.isNotEmpty(companyParam.getAffiliatedPark())){
            criteria.andAffiliatedParkEqualTo(companyParam.getAffiliatedPark());
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
        List<String> comPropertys = new ArrayList<>(16);
        List<TbServicePrefer> tbServicePrefers = tbServicePreferMapper.selectByExample(preferCriteria);
        if(StringUtils.isNotEmpty(tbServiceCompany.getComProperty())){
            String[] comProperty = tbServiceCompany.getComProperty().split(",");

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

        //TODO 企业员工


        return company;
    }

    @ServiceLog(doAction = "根据用户账号查询企业信息（用户为企业管理员）,携带当前登录用户")
    @Override
    public  ServiceCompany getCompanyDetailByAccountOrId(String account,String currentAccount){
        ServiceCompany companyDetailByAccountOrId = this.getCompanyDetailByAccountOrId(account);
        CareParam careParam = new CareParam();
        careParam.setAccount(account);
        careParam.setCurrentAccount(currentAccount);
        Result companyCareInfo = careClient.findCompanyCareInfo(careParam);
        if(null !=companyCareInfo && null != companyCareInfo.getData()){
            CareUserDetails data = (CareUserDetails)companyCareInfo.getData();
            companyDetailByAccountOrId.setCareUserDetails(data);
        }
        return companyDetailByAccountOrId;
    }

    @Override
    @ServiceLog(doAction = "编辑企业信息")
    public Integer updateCompanyInfo(CompanyUpdateParam companyUpdateParam, String account, String phone) {
        // 判断当前用户是否为企业管理员
        ServiceCompany company = getCompanyDetailByAccountOrId(account);

        String code = (String)userExtensionClient.getSendCodeByPhone(phone).getData();
        if(!StringUtils.equals(code,companyUpdateParam.getCheckCode())){
            //验证码有误
            throw new JnSpringCloudException(JoinParkExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }

        // 如果有数据且正在审核中抛出异常
        TbServiceCompanyModify companyModify = companyMapper.getLastModify(company.getId());
        if (companyModify != null && companyModify.getCheckStatus().equals(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode())) {
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.COMPANY_CHECK_ING);
        }

        // 封装ibps数据
        companyUpdateParam.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());
        companyUpdateParam.setComId(company.getId());
        companyUpdateParam.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyUpdateParam.setCreatorAccount(account);
        companyUpdateParam.setRecordStatus(CompanyDataEnum.RECORD_STATUS_VALID.getCode());

        String bpmnDefId = ibpsDefIdConfig.getUpdateCompanyInfo();
        IBPSResult ibpsResult = IBPSUtils.sendRequest(bpmnDefId, account, companyUpdateParam);

        // ibps启动流程失败
        if (ibpsResult == null || ibpsResult.getState().equals("-1")) {
            logger.warn("[编辑企业信息] 启动ibps流程出错，错误信息：{}", ibpsResult != null ? ibpsResult.getMessage() : "");
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.COMPANY_CHECK_ERROR);
        }
        logger.info("[编辑企业信息] " + ibpsResult.getMessage());
        return 1;
    }


    @ServiceLog(doAction = "获取评论信息")
    @Override
    public Result<PaginationData<List<Comment>>> getCommentInfo(ActivityPagingParam activityPagingParam){
        return commentClient.getCommentInfo(activityPagingParam);
    }

    @ServiceLog(doAction = "保存评论")
    @Override
    public Result<Boolean> saveComment(CommentAddParam commentAddParam){
        return commentClient.commentActivity(commentAddParam);
    }

}
