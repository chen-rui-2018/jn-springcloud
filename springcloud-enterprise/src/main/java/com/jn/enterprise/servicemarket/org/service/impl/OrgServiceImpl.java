package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.enterprise.servicemarket.org.vo.*;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductCriteria;
import com.jn.enterprise.servicemarket.require.dao.TbServiceRequireMapper;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequire;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequireCriteria;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.park.api.ActivityClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * 服务机构
 * @author： jiangyl
 * @date： 2019/2/13 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class OrgServiceImpl implements OrgService {

    private static Logger logger = LoggerFactory.getLogger(OrgServiceImpl.class);

    @Autowired
    private OrgMapper orgMapper;
    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private TbServiceOrgTraitMapper tbServiceOrgTraitMapper;
    @Autowired
    private OrgTraitMapper orgTraitMapper;
    @Autowired
    private OrgLicenseMapper orgLicenseMapper;
    @Autowired
    private TbServiceOrgLicenseMapper tbServiceOrgLicenseMapper;
    @Autowired
    private TbServiceOrgElementMapper tbServiceOrgElementMapper;
    @Autowired
    private TbServiceOrgTeamMapper tbServiceOrgTeamMapper;
    @Autowired
    private OrgTeamMapper orgTeamMapper;
    @Autowired
    private TbServiceOrgInfoMapper tbServiceOrgInfoMapper;
    @Autowired
    private UserExtensionClient userClient;
    @Autowired
    private TbServicePreferMapper tbServicePreferMapper;
    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;
    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;
    @Autowired
    private TbServiceInvestorMapper tbServiceInvestorMapper;
    @Autowired
    private ActivityClient activityClient;
    @Autowired
    private TbServiceProductMapper tbServiceProductMapper;
    @Autowired
    private TbServiceRequireMapper tbServiceRequireMapper;

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";
    /**
     * 机构、企业、投资人审核通过{有效}
     */
    private final static String STATUS_EFFECTIVE = "1";
    /**
     * 顾问审核通过
     */
    private final static String ADVISOR_STATUS_EFFECTIVE = "2";
    /**
     * 需求对接成功
     */
    private final static String REQUIRE_HANDLE_RESULT_SUCCESS = "1";

    @ServiceLog(doAction = "查询服务机构列表")
    @Override
    public PaginationData<List<ServiceOrg>> selectServiceOrgList(OrgParameter orgParameter){
        Page<Object> objects = PageHelper.startPage(orgParameter.getPage(), orgParameter.getRows() == 0 ? 15 : orgParameter.getRows());
        List<String> sList = new ArrayList<>(16);
        if(null!=orgParameter.getCompanyNature()&&orgParameter.getCompanyNature().length>0){
            sList.addAll(Arrays.asList(orgParameter.getCompanyNature()));
        }
        if(null!=orgParameter.getDevelopmentStage()&&orgParameter.getDevelopmentStage().length>0){
            sList.addAll(Arrays.asList(orgParameter.getDevelopmentStage()));
        }
        if(null!=orgParameter.getIndustrySector()&&orgParameter.getIndustrySector().length>0){
            sList.addAll(Arrays.asList(orgParameter.getIndustrySector()));
        }
        orgParameter.setCompanyList(sList);
        List<ServiceOrg> serviceOrg = orgMapper.selectServiceOrgList(orgParameter);
        PaginationData<List<ServiceOrg>> data = new PaginationData(serviceOrg, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "根据机构ID查询机构详情")
    @Override
    public OrgDetailVo getServiceOrgDetail(String orgId){
        OrgDetailVo serviceOrgDetailVo = orgMapper.getServiceOrgDetail(orgId);
        if(null == serviceOrgDetailVo){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_IS_NOT_EXIT);
        }
        return serviceOrgDetailVo;
    }

    @ServiceLog(doAction = "保存服务机构基本信息(id为空时为新增)")
    @Override
    public String saveOrUpdateOrgBasicData(OrgBasicData orgBasicData, String account){
        String r = "";
        TbServiceOrg tbServiceOrg = new TbServiceOrg();
        BeanUtils.copyProperties(orgBasicData,tbServiceOrg);

        tbServiceOrg.setRecordStatus(new Byte(RECORD_STATUS_VALID));

        if(null != orgBasicData.getIndustrySector()&&orgBasicData.getIndustrySector().length>0){
            List<String> hobby = new ArrayList<>(16);
            hobby.addAll(Arrays.asList(orgBasicData.getIndustrySector()));
            TbServicePreferCriteria preferCriteria = new TbServicePreferCriteria();
            preferCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            List<TbServicePrefer> tbServicePrefers = tbServicePreferMapper.selectByExample(preferCriteria);
            StringBuffer sbSpeciality = new StringBuffer();
            StringBuffer sbHobby = new StringBuffer();
            String businessTypeStr = "";
            for (TbServicePrefer prefer:tbServicePrefers) {
                for (String sp:orgBasicData.getOrgSpeciality()) {
                    if(StringUtils.equals(sp,prefer.getId())){
                        sbSpeciality.append(prefer.getPreValue()+",");
                    }
                }
                for (String shobby :hobby) {
                    if(StringUtils.equals(shobby,prefer.getId())){
                        sbHobby.append(prefer.getPreValue()+",");
                    }
                }
            }
            tbServiceOrg.setOrgSpeciality(sbSpeciality.toString().substring(0, sbSpeciality.toString().length() - 1));
            tbServiceOrg.setOrgHobby(sbHobby.toString().substring(0, sbHobby.toString().length() - 1));
        }

        try {
            tbServiceOrg.setOrgRegisterTime(DateUtils.parseDate(orgBasicData.getOrgRegisterTime(),"yyyy-MM-dd"));
        } catch (ParseException e) {
            logger.info("保存/修改服务机构基本信息。失败原因：时间转换异常{}", e.getMessage(), e);
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_TIME_PARSE_ERROR);
        }

        if(StringUtils.isEmpty(orgBasicData.getOrgId())){
            //新增，设置状态为待审核
            tbServiceOrg.setOrgStatus("0");
            tbServiceOrg.setOrgId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbServiceOrg.setCreatedTime(new Date());
            tbServiceOrg.setCreatorAccount(account);
            tbServiceOrg.setOrgAccount(account);
            tbServiceOrgMapper.insert(tbServiceOrg);
        }else{
            tbServiceOrg.setModifiedTime(new Date());
            tbServiceOrg.setModifierAccount(account);
            tbServiceOrgMapper.updateByPrimaryKeySelective(tbServiceOrg);
        }
        r = tbServiceOrg.getOrgId();
        //处理机构特性列表
        List<TbServiceOrgTrait> traits = new ArrayList<>();
        TbServiceOrgTraitCriteria traitCriteria = new TbServiceOrgTraitCriteria();
        TbServiceOrgTraitCriteria.Criteria criteria = traitCriteria.createCriteria().andOrgIdEqualTo(tbServiceOrg.getOrgId());
        //trait_type : 特性类型(1业务擅长2行业领域3发展阶段4企业性质)
        if(null != orgBasicData.getOrgSpeciality() && orgBasicData.getOrgSpeciality().length>0){
            criteria.andTraitTypeEqualTo("1");
            tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
            traits.addAll(setTraitBean(orgBasicData.getOrgSpeciality(),"1",tbServiceOrg.getOrgId(),account));
        }
        if(null != orgBasicData.getIndustrySector() && orgBasicData.getIndustrySector().length>0){
            criteria.andTraitTypeEqualTo("2");
            tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
            traits.addAll(setTraitBean(orgBasicData.getIndustrySector(),"2",tbServiceOrg.getOrgId(),account));
        }
        if(null != orgBasicData.getDevelopmentStage() && orgBasicData.getDevelopmentStage().length>0){
            criteria.andTraitTypeEqualTo("3");
            tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
            traits.addAll(setTraitBean(orgBasicData.getDevelopmentStage(),"3",tbServiceOrg.getOrgId(),account));
        }
        if(null != orgBasicData.getCompanyNature() && orgBasicData.getCompanyNature().length>0){
            criteria.andTraitTypeEqualTo("4");
            tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
            traits.addAll(setTraitBean(orgBasicData.getCompanyNature(),"4",tbServiceOrg.getOrgId(),account));
        }
        if(traits.size()>0){
            Map<String,Object> map = new HashMap<>(4);
            map.put("list",traits);
            orgTraitMapper.insertTraitList(map);
        }
        return r;
    }

    /**
     * 封装机构特性TbServiceOrgTraitList
     * @param sectorList
     * @param traitType
     * @param serviceOrgId
     * @param account
     * @return
     */
    public List<TbServiceOrgTrait> setTraitBean(String[] sectorList,String traitType,String serviceOrgId,String account){
        List<TbServiceOrgTrait> traitsList = new ArrayList<>();
        if(null != sectorList){
            for (String sector:sectorList) {
                TbServiceOrgTrait serviceOrgTrait = new TbServiceOrgTrait();
                serviceOrgTrait.setOrgId(serviceOrgId);
                serviceOrgTrait.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                serviceOrgTrait.setCreatedTime(new Date());
                serviceOrgTrait.setCreatorAccount(account);
                serviceOrgTrait.setStatus("1");
                serviceOrgTrait.setTraitValue(sector);
                serviceOrgTrait.setRecordStatus(new Byte(RECORD_STATUS_VALID));
                serviceOrgTrait.setTraitType(traitType);
                traitsList.add(serviceOrgTrait);
            }
        }
        return traitsList;
    }

    @ServiceLog(doAction = "保存服务机构资质信息")
    @Override
    public int saveOrgLicenseData(OrgLicenseData orgLicenseData,String account){
        TbServiceOrg org = new TbServiceOrg();
        BeanUtils.copyProperties(orgLicenseData,org);
        TbServiceOrgLicenseCriteria licenseCriteria = new TbServiceOrgLicenseCriteria();
        licenseCriteria.createCriteria().andOrgIdEqualTo(orgLicenseData.getOrgId());
        tbServiceOrgLicenseMapper.deleteByExample(licenseCriteria);
        List<OrgLicense> licenses = orgLicenseData.getLicenses();
        List<TbServiceOrgLicense> orgLicenses = new ArrayList<>();
        for (OrgLicense orgLicense :licenses) {
            TbServiceOrgLicense tbServiceOrgLicense = new TbServiceOrgLicense();
            BeanUtils.copyProperties(orgLicense,tbServiceOrgLicense);
            try {
                tbServiceOrgLicense.setAwardTime(DateUtils.parseDate(orgLicense.getAwardTime(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                logger.info("保存服务机构资质信息时间转换失败。失败原因{}", e.getMessage(), e);
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_TIME_PARSE_ERROR);
            }
            tbServiceOrgLicense.setCreatedTime(new Date());
            tbServiceOrgLicense.setCreatorAccount(account);
            tbServiceOrgLicense.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            tbServiceOrgLicense.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbServiceOrgLicense.setOrgId(orgLicenseData.getOrgId());
            orgLicenses.add(tbServiceOrgLicense);
        }
        orgLicenseMapper.insertLicenseList(orgLicenses);
        org.setModifiedTime(new Date());
        org.setModifierAccount(account);
        return tbServiceOrgMapper.updateByPrimaryKeySelective(org);
    }

    @ServiceLog(doAction = "保存服务机构团队信息")
    @Override
    public int saveOrUpdateOrgTeamData(OrgTeamData orgTeamData,String account){
        TbServiceOrgElement serviceOrgElement = new TbServiceOrgElement();
        BeanUtils.copyProperties(orgTeamData,serviceOrgElement);

        List<OrgTeam> orgTeams = orgTeamData.getOrgTeams();
        List<TbServiceOrgTeam> orgTeamList = new ArrayList<>(8);
        for (OrgTeam team: orgTeams) {
            TbServiceOrgTeam serviceOrgTeam = new TbServiceOrgTeam();
            BeanUtils.copyProperties(team,serviceOrgTeam);
            serviceOrgTeam.setOrgId(orgTeamData.getOrgId());
            serviceOrgTeam.setId(UUID.randomUUID().toString().replaceAll("-",""));
            serviceOrgTeam.setCreatedTime(new Date());
            serviceOrgTeam.setCreatorAccount(account);
            serviceOrgTeam.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            orgTeamList.add(serviceOrgTeam);
        }
        TbServiceOrgTeamCriteria orgTeamCriteria = new TbServiceOrgTeamCriteria();
        orgTeamCriteria.createCriteria().andOrgIdEqualTo(orgTeamData.getOrgId());
        int i = tbServiceOrgTeamMapper.deleteByExample(orgTeamCriteria);
        logger.info("保存机构核心服务团队信息，删除历史数据{}条",i);
        int i1 = orgTeamMapper.insertTeamList(orgTeamList);
        logger.info("保存机构核心服务团队信息，添加数据{}条",i1);

        TbServiceOrgElementCriteria elementCriteria = new TbServiceOrgElementCriteria();
        elementCriteria.createCriteria().andOrgIdEqualTo(orgTeamData.getOrgId());
        List<TbServiceOrgElement> tbServiceOrgElements = tbServiceOrgElementMapper.selectByExample(elementCriteria);

        if(null !=tbServiceOrgElements && tbServiceOrgElements.size()>0){
            serviceOrgElement.setModifiedTime(new Date());
            serviceOrgElement.setModifierAccount(account);
            return tbServiceOrgElementMapper.updateByPrimaryKeySelective(serviceOrgElement);
        }else{
            serviceOrgElement.setId(UUID.randomUUID().toString().replaceAll("-",""));
            serviceOrgElement.setCreatedTime(new Date());
            serviceOrgElement.setCreatorAccount(account);
            serviceOrgElement.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            return tbServiceOrgElementMapper.insert(serviceOrgElement);
        }
    }

    @ServiceLog(doAction = "保存/修改服务机构联系方式")
    @Override
    public int saveOrUpdateOrgContactData(OrgContactData orgContactData,String account){
        TbServiceOrgInfo tbServiceOrgInfo = new TbServiceOrgInfo();
        BeanUtils.copyProperties(orgContactData,tbServiceOrgInfo);
        tbServiceOrgInfo.setRecordStatus(new Byte(RECORD_STATUS_VALID));
        TbServiceOrgInfo tbServiceOrgInfo1 = tbServiceOrgInfoMapper.selectByPrimaryKey(orgContactData.getOrgId());
        if(null!=tbServiceOrgInfo1&&StringUtils.isNotEmpty(tbServiceOrgInfo1.getOrgId())){
            //存在对应机构联系方式，修改。
            tbServiceOrgInfo.setModifiedTime(new Date());
            tbServiceOrgInfo.setModifierAccount(account);
            return tbServiceOrgInfoMapper.updateByPrimaryKeySelective(tbServiceOrgInfo);
        }else{
            //不存在联系方式，新增
            tbServiceOrgInfo.setCreatedTime(new Date());
            tbServiceOrgInfo.setCreatorAccount(account);
            return tbServiceOrgInfoMapper.insertSelective(tbServiceOrgInfo);
        }
    }

    @ServiceLog(doAction = "我的机构,机构信息")
    @Override
    public MyOrgInfoVo getMyOrgInfo(String account) {
       Result<UserExtensionInfo> userResult =  userClient.getUserExtension(account);
        if (userResult.getData() == null) {
            return  null;
        }
        UserExtensionInfo userInfo = userResult.getData();
        String orgId =  userInfo.getAffiliateCode();
        if(StringUtils.isBlank(orgId)){
            return  null;
        }
        //机构详情
        OrgDetailVo orgDetailVo = getServiceOrgDetail(orgId);
        //机构统计信息
        MyOrgInfoVo myOrgInfoVo = new MyOrgInfoVo();
        myOrgInfoVo.setOrgDetailVo(orgDetailVo);
        OrgCount orgCount =  orgMapper.getMyOrgInfo(orgId);
        myOrgInfoVo.setOrgCount(orgCount);
        return myOrgInfoVo;
    }

    @ServiceLog(doAction = "查询服务超市统计数据")
    @Override
    public ServiceStatisticalNumVO selectServiceStatisticalNum(){
        ServiceStatisticalNumVO serviceStatisticalNumVO = new ServiceStatisticalNumVO();
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long orgNum = tbServiceOrgMapper.countByExample(orgCriteria);
        serviceStatisticalNumVO.setOrgNum(orgNum+"");

        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andCheckStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long companyNum = tbServiceCompanyMapper.countByExample(companyCriteria);
        serviceStatisticalNumVO.setCompanyNum(companyNum+"");

        TbServiceAdvisorCriteria advisorCriteria = new TbServiceAdvisorCriteria();
        advisorCriteria.createCriteria().andApprovalStatusEqualTo(ADVISOR_STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long advisorNum = tbServiceAdvisorMapper.countByExample(advisorCriteria);
        serviceStatisticalNumVO.setAdvisorNum(advisorNum+"");

        TbServiceInvestorCriteria investorCriteria = new TbServiceInvestorCriteria();
        investorCriteria.createCriteria().andApprovalStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long inverstorNum = tbServiceInvestorMapper.countByExample(investorCriteria);
        serviceStatisticalNumVO.setInvestorNum(inverstorNum+"");

        serviceStatisticalNumVO.setActivityNum(activityClient.getActivityNum().getData());

        return serviceStatisticalNumVO;
    }

    @ServiceLog(doAction = "根据业务领域/产品查询服务超市统计数据")
    @Override
    public BusinessStatisticalNumVO selectBusinessAreaStatisticalNum(BusinessStatisticalParam businessStatisticalParam){
        BusinessStatisticalNumVO businessStatisticalNumVO = new BusinessStatisticalNumVO();
        String businessType = businessStatisticalParam.getBusinessType();
        String productId = businessStatisticalParam.getProductId();

        TbServiceProductCriteria productCriteria = new TbServiceProductCriteria();
        TbServiceProductCriteria.Criteria productCriteriac = productCriteria.createCriteria().andStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));

        if(StringUtils.isNotEmpty(businessType)){

            //机构数
            TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
            orgCriteria.createCriteria().andBusinessTypeLike("%"+businessType+"%").andOrgStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            long orgNum = tbServiceOrgMapper.countByExample(orgCriteria);
            businessStatisticalNumVO.setOrgNum(orgNum+"");
            productCriteriac.andSignoryIdEqualTo(businessType);

            //顾问数
            TbServiceAdvisorCriteria advisorCriteria = new TbServiceAdvisorCriteria();
            advisorCriteria.createCriteria().andBusinessAreaLike("%"+businessType+"%").andApprovalStatusEqualTo(ADVISOR_STATUS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            long advisorNum = tbServiceAdvisorMapper.countByExample(advisorCriteria);
            businessStatisticalNumVO.setAdvisorNum(advisorNum +"");

            //交易量
            TbServiceRequireCriteria requireCriteria = new TbServiceRequireCriteria();
            requireCriteria.createCriteria().andHandleResultEqualTo(REQUIRE_HANDLE_RESULT_SUCCESS).andBusinessIdEqualTo(businessType).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            long requireNum = tbServiceRequireMapper.countByExample(requireCriteria);
            businessStatisticalNumVO.setTransactionNum(requireNum+"");
        }else if(StringUtils.isNotEmpty(productId)){
            productCriteriac.andTemplateIdEqualTo(productId);
            businessStatisticalNumVO.setOrgNum(orgMapper.getProductOrgNum(productId));
            businessStatisticalNumVO.setAdvisorNum(orgMapper.getProductAdvisorNum(productId));
            businessStatisticalNumVO.setTransactionNum(orgMapper.getProductNum(productId));
        }
        String productRatingNum = orgMapper.getProductRatingNum(businessStatisticalParam);

        long productNum = tbServiceProductMapper.countByExample(productCriteria);
        businessStatisticalNumVO.setProductNum(productNum+"");
        businessStatisticalNumVO.setEvaluateNum(productRatingNum);
        return businessStatisticalNumVO;
    }

    @ServiceLog(doAction = "获取当前用户机构状态")
    @Override
    public String getOrgStatusByUser(String account){
        if(StringUtils.isEmpty(account)){
            throw new JnSpringCloudException(OrgExceptionEnum.USER_EXTENSION_IS_NULL);
        }
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        orgCriteria.setOrderByClause(" created_time desc ");
        List<TbServiceOrg> tbServiceOrgs = tbServiceOrgMapper.selectByExample(orgCriteria);
        if(null == tbServiceOrgs || tbServiceOrgs.size()==0){
            return "-1";
        }else{
            return tbServiceOrgs.get(0).getOrgStatus();
        }
    }

}
