package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictParameter;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictionary;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.enterprise.servicemarket.org.TraitTypeEnum;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
import com.jn.enterprise.servicemarket.org.enums.CertTypeEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.servicemarket.org.vo.*;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductCriteria;
import com.jn.enterprise.servicemarket.require.dao.TbServiceRequireMapper;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequireCriteria;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.api.ActivityClient;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.enums.HomeRoleEnum;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserExtensionInfo;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TbServiceOrgTempMapper tbServiceOrgTempMapper;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private IndustryService industryService;
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";
    /**
     * 科技金融业务领域
     */
    private static final String BUSINESS_TECHNOLOGY="technology_finance";

    /**
     * 机构认证流程id
     */
    @Value(value = "${orgProcessId}")
    private String orgProcessId;


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
    private final static String ORG_APPLY_IS_CHECKING = "0";
    private final static String TECHNOLOGY_FINANCE = "technology_finance";


    @ServiceLog(doAction = "查询服务机构列表")
    @Override
    public PaginationData<List<ServiceOrg>> selectServiceOrgList(OrgParameter orgParameter,boolean allowTechnology){
        Page<Object> objects = PageHelper.startPage(orgParameter.getPage(), orgParameter.getRows() == 0 ? 15 : orgParameter.getRows());
        List<String> sList = new ArrayList<>(16);
        if(null!=orgParameter.getDevelopmentStage()&&orgParameter.getDevelopmentStage().length>0){
            sList.addAll(Arrays.asList(orgParameter.getDevelopmentStage()));
        }
        if(null!=orgParameter.getIndustrySector()&&orgParameter.getIndustrySector().length>0){
            sList.addAll(Arrays.asList(orgParameter.getIndustrySector()));
        }
        orgParameter.setCompanyList(sList);
        OrgListParam orgListParam=new OrgListParam();
        BeanUtils.copyProperties(orgParameter, orgListParam);
        //综合排序
        String sortType="integrate";
        if(StringUtils.isBlank(orgParameter.getSortTypes())|| StringUtils.equals(orgParameter.getSortTypes(),sortType)){
            //设置排序权重值，目前使用默认排序权重
        }
        //若是查询条件有科技金融，去掉不允许展示科技金融条件
        String[] businessType = orgParameter.getBusinessType();
        if(businessType!=null && businessType.length>0){
            String join = StringUtils.join(businessType, ",");
            if(join.contains(BUSINESS_TECHNOLOGY)){
                allowTechnology=true;
            }
        }

        //不予许展示科技金融
        if(!allowTechnology){
            orgListParam.setAllowTechnology(BUSINESS_TECHNOLOGY);
        }
        List<ServiceOrg> serviceOrg = orgMapper.selectServiceOrgList(orgListParam);

        // 处理图片格式
        List<ServiceOrg> serviceOrgResult = new ArrayList<>();
        if (serviceOrg != null && !serviceOrg.isEmpty()) {
            for (ServiceOrg serOrg : serviceOrg) {
                serOrg.setOrgLogo(IBPSFileUtils.getFilePath(serOrg.getOrgLogo()));
                serviceOrgResult.add(serOrg);
            }
        }
        PaginationData<List<ServiceOrg>> data = new PaginationData(serviceOrgResult, objects.getTotal());
        return data;
    }


    @ServiceLog(doAction = "根据机构ID查询机构详情")
    @Override
    public OrgDetailVo getServiceOrgDetail(String orgId){
        //获取机构基本信息
        OrgDetailVo orgDetailVo = orgMapper.getServiceOrgDetail(orgId);
        if(orgDetailVo==null){
            logger.warn("根据机构ID查询机构详情异常，当前机构id:[{}]在系统中不存在或已失效",orgId);
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_INFO_NOT_EXIST);
        }
        //获取系统所有业务领域
        IndustryDictParameter industryDictParameter=new IndustryDictParameter();
        //领域类型[0业务领域1行业领域2发展阶段3企业性质]
        industryDictParameter.setPreType("0");
        List<IndustryDictionary> industryDictionaryList = industryService.getIndustryDictionary(industryDictParameter);
        for(IndustryDictionary industryDictionary :industryDictionaryList){
            if(StringUtils.equals(orgDetailVo.getBusinessType(),industryDictionary.getId())){
                orgDetailVo.setBusinessTypeName(industryDictionary.getPreValue());
                break;
            }
        }

        //处理logo图片格式
        orgDetailVo.setOrgLogo(IBPSFileUtils.getFilePath(orgDetailVo.getOrgLogo()));
        //获取客户偏好--行业领域
        List<TbServiceOrgTrait> serviceOrgTraitList = getOrgIndustrySector(orgId,TraitTypeEnum.INDUSTRY_FIELDS.getValue());
        List<IndustryDictionary> industryDictionary = industryService.getIndustryDictionary(new IndustryDictParameter());
        if(!serviceOrgTraitList.isEmpty()){
            List<IndustryTypeShow>industrySectorList=new ArrayList<>(16);
            getIndustryTypeShow(serviceOrgTraitList, industryDictionary, industrySectorList);
            orgDetailVo.setIndustrySector(industrySectorList);
        }
        //获取客户偏好--发展阶段
        serviceOrgTraitList=getOrgIndustrySector(orgId,TraitTypeEnum.STAGE_OF_DEVELOP.getValue());
        if(!serviceOrgTraitList.isEmpty()){
            List<IndustryTypeShow>developmentStageList=new ArrayList<>(16);
            getIndustryTypeShow(serviceOrgTraitList, industryDictionary, developmentStageList);
            orgDetailVo.setDevelopmentStage(developmentStageList);
        }
        //获取机构荣誉资质
        getOrgHonorInfoByOrgId(orgId, orgDetailVo);
        //获取机构团队信息
        List<TbServiceOrgTeam> serviceOrgTeamList = getTbServiceOrgTeams(orgId);
        if(!serviceOrgTeamList.isEmpty()){
            List<OrgTeam> orgTeamList=new ArrayList<>(16);
            for(TbServiceOrgTeam serviceOrgTeam:serviceOrgTeamList){
                OrgTeam orgTeam=new OrgTeam();
                BeanUtils.copyProperties(serviceOrgTeam,orgTeam);
                orgTeamList.add(orgTeam);
            }
           orgDetailVo.setOrgTeams(orgTeamList);
        }
        //更新机构浏览量
        updateOrgSHowNum(orgId);
        return orgDetailVo;
    }

    /**
     * 更新机构浏览量
     * @param orgId
     */
    @ServiceLog(doAction = "更新机构浏览量")
    private void updateOrgSHowNum(String orgId) {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        //审批状态为未审批，审批中，审批通过的机构
        example.createCriteria().andOrgIdEqualTo(orgId)
                .andOrgStatusIn(Arrays.asList(ApprovalStatusEnum.NOT_APPROVED.getValue(),ApprovalStatusEnum.APPROVAL.getValue()))
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrg> serviceOrgList = tbServiceOrgMapper.selectByExample(example);
        if(!serviceOrgList.isEmpty()){
            TbServiceOrg tbServiceOrg = serviceOrgList.get(0);
            int oldShow=tbServiceOrg.getOrgShow()==null?0:tbServiceOrg.getOrgShow();
            tbServiceOrg.setOrgShow(oldShow+1);
            int resNum = tbServiceOrgMapper.updateByExampleSelective(tbServiceOrg, example);
            logger.info("更新机构浏览量成功，数据响应条数：{}",resNum);
        }else{
            logger.warn("更新机构浏览量失败");
        }

    }

    /**
     * 获取机构团队信息
     * @param orgId
     * @return
     */
    @ServiceLog(doAction = "获取机构团队信息")
    private List<TbServiceOrgTeam> getTbServiceOrgTeams(String orgId) {
        TbServiceOrgTeamCriteria example = new TbServiceOrgTeamCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        return tbServiceOrgTeamMapper.selectByExample(example);
    }

    /**
     * 封装处理客户偏好
     * @param serviceOrgTraitList
     * @param industryDictionary
     * @param industrySectorList
     */
    @ServiceLog(doAction = "封装处理客户偏好")
    private void getIndustryTypeShow(List<TbServiceOrgTrait> serviceOrgTraitList, List<IndustryDictionary>industryDictionary, List<IndustryTypeShow> industrySectorList) {
        for (TbServiceOrgTrait tbServiceOrgTrait : serviceOrgTraitList) {
            for (IndustryDictionary industry : industryDictionary) {
                if (StringUtils.equals(industry.getId(), tbServiceOrgTrait.getTraitValue())) {
                    IndustryTypeShow industryTypeShow = new IndustryTypeShow();
                    industryTypeShow.setOrgTraitId(industry.getId());
                    industryTypeShow.setOrgTraitName(industry.getPreValue());
                    industrySectorList.add(industryTypeShow);
                    break;
                }
            }
        }
    }

    /**
     * 根据机构id获取机构荣誉资质信息
     * @param orgId
     * @param orgDetailVo
     */
    @ServiceLog(doAction = "根据机构id获取机构荣誉资质信息")
    private void getOrgHonorInfoByOrgId(String orgId, OrgDetailVo orgDetailVo) {
        TbServiceOrgLicenseCriteria example=new TbServiceOrgLicenseCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgLicense> serviceOrgLicenseList = tbServiceOrgLicenseMapper.selectByExample(example);
        if(!serviceOrgLicenseList.isEmpty()){
            List<OrgLicense> honorLicense=new ArrayList<>(16);
            for(TbServiceOrgLicense serviceOrgLicense:serviceOrgLicenseList){
                //处理图片格式
                serviceOrgLicense.setFileUrl(IBPSFileUtils.getFilePath(serviceOrgLicense.getFileUrl()));
                //营业执照
                if(StringUtils.equals(serviceOrgLicense.getCertType(),CertTypeEnum.LICENSE.getValue())){
                    orgDetailVo.setOrgLicensesUrl(serviceOrgLicense.getFileUrl());
                }else{
                    OrgLicense orgLicense=new OrgLicense();
                    BeanUtils.copyProperties(serviceOrgLicense, orgLicense);
                    if(serviceOrgLicense.getAwardTime()!=null){
                        orgLicense.setAwardTime(DateUtils.formatDate(serviceOrgLicense.getAwardTime(),"yyyy-MM"));
                    }
                    honorLicense.add(orgLicense);
                }
            }
            orgDetailVo.setHonorLicense(honorLicense);
        }
    }

    /**
     * 根据机构id获取客户偏好--行业领域,发展阶段
     * @param orgId
     * @return
     */
    @ServiceLog(doAction = "根据机构id获取客户偏好--行业领域,发展阶段")
    private List<TbServiceOrgTrait> getOrgIndustrySector(String orgId,String traitType) {
        TbServiceOrgTraitCriteria example=new TbServiceOrgTraitCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId)
                .andTraitTypeEqualTo(traitType)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        return tbServiceOrgTraitMapper.selectByExample(example);
    }

    /**
     * 保存服务机构基本信息(id为空时为新增)
     * @param orgBasicData
     * @param account
     * @return
     */
    @ServiceLog(doAction = "保存服务机构基本信息(id为空时为新增)")
    @Override
    public String saveOrUpdateOrgBasicData(OrgBasicData orgBasicData, String account){
        String r = "";
        TbServiceOrgTemp tbServiceOrgTemp = new TbServiceOrgTemp();
        BeanUtils.copyProperties(orgBasicData,tbServiceOrgTemp);
        tbServiceOrgTemp.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        if(null != orgBasicData.getIndustrySector()&&orgBasicData.getIndustrySector().length>0){
            List<String> hobby = new ArrayList<>(16);
            hobby.addAll(Arrays.asList(orgBasicData.getIndustrySector()));
            TbServicePreferCriteria preferCriteria = new TbServicePreferCriteria();
            preferCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbServicePrefer> tbServicePrefers = tbServicePreferMapper.selectByExample(preferCriteria);
            List<String>sbHobby=new ArrayList<>(16);
            for (TbServicePrefer prefer:tbServicePrefers) {
                for (String shobby :hobby) {
                    if(StringUtils.equals(shobby,prefer.getId())){
                        sbHobby.add(prefer.getPreValue());
                    }
                }
            }
            tbServiceOrgTemp.setOrgHobby(StringUtils.join(sbHobby,","));
        }

        try {
            tbServiceOrgTemp.setOrgRegisterTime(DateUtils.parseDate(orgBasicData.getOrgRegisterTime(),"yyyy-MM-dd"));
        } catch (ParseException e) {
            logger.info("保存/修改服务机构基本信息。失败原因：时间转换异常{}", e.getMessage(), e);
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_TIME_PARSE_ERROR);
        }
        if(StringUtils.isEmpty(orgBasicData.getOrgId())){
            //新增，设置状态为待审核
            tbServiceOrgTemp.setOrgStatus("0");
            tbServiceOrgTemp.setOrgId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbServiceOrgTemp.setCreatedTime(new Date());
            tbServiceOrgTemp.setCreatorAccount(account);
            tbServiceOrgTemp.setOrgAccount(account);
            tbServiceOrgTempMapper.insert(tbServiceOrgTemp);
        }else{
            tbServiceOrgTemp.setModifiedTime(new Date());
            tbServiceOrgTemp.setModifierAccount(account);
            tbServiceOrgTempMapper.updateByPrimaryKeySelective(tbServiceOrgTemp);
        }
        r = tbServiceOrgTemp.getOrgId();
        //处理机构特性列表
        List<TbServiceOrgTrait> traits = new ArrayList<>();
        TbServiceOrgTraitCriteria traitCriteria = new TbServiceOrgTraitCriteria();
        TbServiceOrgTraitCriteria.Criteria criteria = traitCriteria.createCriteria().andOrgIdEqualTo(tbServiceOrgTemp.getOrgId());
        //trait_type : 特性类型(1业务擅长2行业领域3发展阶段4企业性质)
        if(null != orgBasicData.getIndustrySector() && orgBasicData.getIndustrySector().length>0){
            criteria.andTraitTypeEqualTo("2");
            tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
            traits.addAll(setTraitBean(orgBasicData.getIndustrySector(),"2",tbServiceOrgTemp.getOrgId(),account));
        }
        if(null != orgBasicData.getDevelopmentStage() && orgBasicData.getDevelopmentStage().length>0){
            criteria.andTraitTypeEqualTo("3");
            tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
            traits.addAll(setTraitBean(orgBasicData.getDevelopmentStage(),"3",tbServiceOrgTemp.getOrgId(),account));
        }
        if(!traits.isEmpty()){
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
                serviceOrgTrait.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
                serviceOrgTrait.setTraitType(traitType);
                traitsList.add(serviceOrgTrait);
            }
        }
        return traitsList;
    }

    @ServiceLog(doAction = "保存服务机构资质信息")
    @Override
    public int saveOrgLicenseData(OrgLicenseData orgLicenseData,String account){
        TbServiceOrgTemp orgTemp = new TbServiceOrgTemp();
        BeanUtils.copyProperties(orgLicenseData,orgTemp);
        TbServiceOrgLicenseCriteria licenseCriteria = new TbServiceOrgLicenseCriteria();
        licenseCriteria.createCriteria().andOrgIdEqualTo(orgLicenseData.getOrgId());
        tbServiceOrgLicenseMapper.deleteByExample(licenseCriteria);
        List<OrgLicense> licenses = orgLicenseData.getLicenses();
        List<TbServiceOrgLicense> orgLicenses = new ArrayList<>();
        for (OrgLicense orgLicense :licenses) {
            TbServiceOrgLicense tbServiceOrgLicense = new TbServiceOrgLicense();
            BeanUtils.copyProperties(orgLicense, tbServiceOrgLicense);
            if (orgLicense.getAwardTime() != null) {
                tbServiceOrgLicense.setAwardTime(DateUtils.parseDate(orgLicense.getAwardTime()));
             }
            if(tbServiceOrgLicense.getCertName()==null){
                logger.warn("保存服务机构资质信息失败，机构荣誉资质名称不能为空");
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_HONOR_NAME_NOT_NULL);
            }
            String certName="营业执照";
            if(tbServiceOrgLicense.getCertName().contains(certName)){
                //证书类型：1：营业执照    2：执业资质  3：其他
                tbServiceOrgLicense.setCertType(CertTypeEnum.LICENSE.getValue());
            }else{
                tbServiceOrgLicense.setCertType(CertTypeEnum.PRACTISING_QUALIFICATION.getValue());
            }
            tbServiceOrgLicense.setCreatedTime(new Date());
            tbServiceOrgLicense.setCreatorAccount(account);
            tbServiceOrgLicense.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            tbServiceOrgLicense.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbServiceOrgLicense.setOrgId(orgLicenseData.getOrgId());
            orgLicenses.add(tbServiceOrgLicense);
        }
        orgLicenseMapper.insertLicenseList(orgLicenses);
        orgTemp.setModifiedTime(new Date());
        orgTemp.setModifierAccount(account);
        return tbServiceOrgTempMapper.updateByPrimaryKeySelective(orgTemp);
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
            serviceOrgTeam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
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

        if(null !=tbServiceOrgElements && !tbServiceOrgElements.isEmpty()){
            serviceOrgElement.setModifiedTime(new Date());
            serviceOrgElement.setModifierAccount(account);
            return tbServiceOrgElementMapper.updateByPrimaryKeySelective(serviceOrgElement);
        }else{
            serviceOrgElement.setId(UUID.randomUUID().toString().replaceAll("-",""));
            serviceOrgElement.setCreatedTime(new Date());
            serviceOrgElement.setCreatorAccount(account);
            serviceOrgElement.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            return tbServiceOrgElementMapper.insert(serviceOrgElement);
        }
    }

    @ServiceLog(doAction = "保存/修改服务机构联系方式")
    @Override
    public int saveOrUpdateOrgContactData(OrgContactData orgContactData,String account){
        TbServiceOrgInfo tbServiceOrgInfo = new TbServiceOrgInfo();
        BeanUtils.copyProperties(orgContactData,tbServiceOrgInfo);
        tbServiceOrgInfo.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        TbServiceOrgInfo tbServiceOrgInfo1 = tbServiceOrgInfoMapper.selectByPrimaryKey(orgContactData.getOrgId());
        int code = 0;
        if(null!=tbServiceOrgInfo1&&StringUtils.isNotEmpty(tbServiceOrgInfo1.getOrgId())){
            //存在对应机构联系方式，修改。
            tbServiceOrgInfo.setModifiedTime(new Date());
            tbServiceOrgInfo.setModifierAccount(account);
            code = tbServiceOrgInfoMapper.updateByPrimaryKeySelective(tbServiceOrgInfo);
        }else{
            //不存在联系方式，新增
            tbServiceOrgInfo.setCreatedTime(new Date());
            tbServiceOrgInfo.setCreatorAccount(account);
            code = tbServiceOrgInfoMapper.insertSelective(tbServiceOrgInfo);
        }
        // 开始 启动IBPS审核流 --- 封装数据开始  ------------------------
        String orgId = orgContactData.getOrgId();
        TbServiceOrgTempCriteria orgTempCriteria = new TbServiceOrgTempCriteria();
        orgTempCriteria.createCriteria().andOrgIdEqualTo(orgId);
        List<TbServiceOrgTemp> serviceOrgTempList = tbServiceOrgTempMapper.selectByExample(orgTempCriteria);
        if(null==serviceOrgTempList||serviceOrgTempList.size()!=1){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_DATA_IS_ERROR);
        }
        if(!StringUtils.equals(serviceOrgTempList.get(0).getOrgStatus(),ORG_APPLY_IS_CHECKING)){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_DATA_STATUS_IS_NOT_CHECKING);
        }
        //获取tbServiceOrg的ORGID作为其子表的ORGID条件查询出关联数据
        TbServiceOrgTemp tbServiceOrgTemp=serviceOrgTempList.get(0);
        TbServiceOrgCopy tbServiceOrgCopy= new TbServiceOrgCopy();
        BeanUtils.copyProperties(tbServiceOrgTemp,tbServiceOrgCopy);
        //将Date类型转换成String类型,
        if(tbServiceOrgTemp.getOrgRegisterTime()!=null){
            tbServiceOrgCopy.setOrgRegisterTime(DateUtils.formatDate(tbServiceOrgTemp.getOrgRegisterTime(),PATTERN));
        }
        Date checkTime = tbServiceOrgTemp.getCheckTime();
        Date createdTime = tbServiceOrgTemp.getCreatedTime();
        Date modifiedTime= tbServiceOrgTemp.getModifiedTime();
        if(checkTime!=null){
            tbServiceOrgCopy.setCheckTime(DateUtils.formatDate(tbServiceOrgTemp.getCheckTime(),PATTERN));
        }
        if(createdTime!=null){
            tbServiceOrgCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgTemp.getCreatedTime(),PATTERN));
        }
        if(modifiedTime!=null){
            tbServiceOrgCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgTemp.getModifiedTime(),PATTERN));
        }
        //将Byte转为String类型
        if(null != tbServiceOrgTemp.getRecordStatus()){
            tbServiceOrgCopy.setRecordStatus((int)tbServiceOrgTemp.getRecordStatus()+"");
        }
        //=============== 获取子表信息 =====================
        String serviceOrgId=tbServiceOrgTemp.getOrgId();
        TbServiceOrgElementCriteria example=new TbServiceOrgElementCriteria();
        example.createCriteria().andOrgIdEqualTo(serviceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgElement> tbServiceOrgElements = tbServiceOrgElementMapper.selectByExample(example);

        //一对一
        TbServiceOrgElementCopy tbServiceOrgElementCopy1=new TbServiceOrgElementCopy();
        if(!tbServiceOrgElements.isEmpty()){
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgElements.get(0),tbServiceOrgElementCopy1);
            if(tbServiceOrgElements.get(0).getCreatedTime()!=null){
                tbServiceOrgElementCopy1.setCreatedTime(DateUtils.formatDate(tbServiceOrgElements.get(0).getCreatedTime(),PATTERN));
            }
            if(null != tbServiceOrgElements.get(0).getModifiedTime()){
                tbServiceOrgElementCopy1.setModifiedTime(DateUtils.formatDate(tbServiceOrgElements.get(0).getModifiedTime(),PATTERN));
            }
            if(null != tbServiceOrgElements.get(0).getRecordStatus()){
                tbServiceOrgElementCopy1.setRecordStatus((int)tbServiceOrgElements.get(0).getRecordStatus()+"");
            }
        }
        tbServiceOrgElementCopy1.setOrgId(null);
        tbServiceOrgElementCopy1.setId(null);
        tbServiceOrgCopy.setTb_service_org_element(tbServiceOrgElementCopy1);

        //一对一
        TbServiceOrgInfoCriteria example1=new TbServiceOrgInfoCriteria();
        example1.createCriteria().andOrgIdEqualTo(serviceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgInfo> tbServiceOrgInfos = tbServiceOrgInfoMapper.selectByExample(example1);

        TbServiceOrgInfoCopy tbServiceOrgInfoCopy=new TbServiceOrgInfoCopy();
        if(!tbServiceOrgInfos.isEmpty()){
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgInfos.get(0),tbServiceOrgInfoCopy);
            if(null != tbServiceOrgInfos.get(0).getCreatedTime()){
                tbServiceOrgInfoCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgInfos.get(0).getCreatedTime(),PATTERN));
            }
            if(null != tbServiceOrgInfos.get(0).getModifiedTime()){
                tbServiceOrgInfoCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgInfos.get(0).getModifiedTime(),PATTERN));
            }
            if(null != tbServiceOrgInfos.get(0).getRecordStatus()){
                tbServiceOrgInfoCopy.setRecordStatus((int)tbServiceOrgInfos.get(0).getRecordStatus()+"");
            }
        }
        tbServiceOrgInfoCopy.setOrgId(orgId);
        tbServiceOrgCopy.setTb_service_org_info(tbServiceOrgInfoCopy);

        //一对多
        TbServiceOrgLicenseCriteria example2=new TbServiceOrgLicenseCriteria();
        example2.createCriteria().andOrgIdEqualTo(serviceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgLicense> tbServiceOrgLicenses = tbServiceOrgLicenseMapper.selectByExample(example2);
        List<TbServiceOrgLicenseCopy> tbServiceOrgLicenseCopies=new ArrayList<>();

        for(int i=0;i<tbServiceOrgLicenses.size();i++){
            TbServiceOrgLicenseCopy tbServiceOrgLicenseCopy=new TbServiceOrgLicenseCopy();
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgLicenses.get(i),tbServiceOrgLicenseCopy);
            if(null != tbServiceOrgLicenses.get(i).getCreatedTime()){
                tbServiceOrgLicenseCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgLicenses.get(i).getCreatedTime(),PATTERN));
            }
            if(null != tbServiceOrgLicenses.get(i).getModifiedTime()){
                tbServiceOrgLicenseCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgLicenses.get(i).getModifiedTime(),PATTERN));
            }
            if(null != tbServiceOrgLicenses.get(i).getRecordStatus()){
                tbServiceOrgLicenseCopy.setRecordStatus((int)tbServiceOrgLicenses.get(i).getRecordStatus()+"");
            }
            tbServiceOrgLicenseCopy.setOrgId(null);
            tbServiceOrgLicenseCopy.setId(null);
            tbServiceOrgLicenseCopies.add(tbServiceOrgLicenseCopy);
        }
        if (tbServiceOrgLicenses.isEmpty()){
            tbServiceOrgLicenseCopies.clear();
        }
        tbServiceOrgCopy.setTb_service_org_license(tbServiceOrgLicenseCopies);

        //一对多
        TbServiceOrgTraitCriteria example3=new TbServiceOrgTraitCriteria();
        example3.createCriteria().andOrgIdEqualTo(serviceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgTrait> tbServiceOrgTraits = tbServiceOrgTraitMapper.selectByExample(example3);
        List<TbServiceOrgTraitCopy> tbServiceOrgTraitCopies=new ArrayList<>();

        for(int i=0;i<tbServiceOrgTraits.size();i++){
            TbServiceOrgTraitCopy tbServiceOrgLicenseCopy=new TbServiceOrgTraitCopy();
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgTraits.get(i),tbServiceOrgLicenseCopy);
            createdTime = tbServiceOrgTraits.get(i).getCreatedTime();
            modifiedTime = tbServiceOrgTraits.get(i).getModifiedTime();
            Byte recordStatus = tbServiceOrgTraits.get(i).getRecordStatus();
            if(createdTime!=null){
                tbServiceOrgLicenseCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgTraits.get(i).getCreatedTime(),PATTERN));
            }
            if(modifiedTime!=null){
                tbServiceOrgLicenseCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgTraits.get(i).getModifiedTime(),PATTERN));
            }
            if(recordStatus!=null){
                tbServiceOrgLicenseCopy.setRecordStatus((int)tbServiceOrgTraits.get(i).getRecordStatus()+"");
            }
            tbServiceOrgLicenseCopy.setOrgId(null);
            tbServiceOrgLicenseCopy.setId(null);
            tbServiceOrgTraitCopies.add(tbServiceOrgLicenseCopy);
        }
        if (tbServiceOrgTraits.isEmpty()){
            tbServiceOrgTraitCopies.clear();
        }
        tbServiceOrgCopy.setTb_service_org_trait(tbServiceOrgTraitCopies);

        //一对多
        List<TbServiceOrgTeam> tbServiceOrgTeams = getTbServiceOrgTeams(serviceOrgId);
        List<TbServiceOrgTeamCopy> tbServiceOrgTeamCopies=new ArrayList<>();

        for(int i=0;i<tbServiceOrgTeams.size();i++){
            TbServiceOrgTeamCopy tbServiceOrgLicenseCopy=new TbServiceOrgTeamCopy();
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgTeams.get(i),tbServiceOrgLicenseCopy);
            if(null != tbServiceOrgTeams.get(i).getCreatedTime()){
                tbServiceOrgLicenseCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgTeams.get(i).getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgTeams.get(i).getModifiedTime()){
                tbServiceOrgLicenseCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgTeams.get(i).getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgTeams.get(i).getRecordStatus()){
                tbServiceOrgLicenseCopy.setRecordStatus((int)tbServiceOrgTeams.get(i).getRecordStatus()+"");
            }
            tbServiceOrgLicenseCopy.setOrgId(null);
            tbServiceOrgLicenseCopy.setId(null);
            tbServiceOrgTeamCopies.add(tbServiceOrgLicenseCopy);
        }
        if (tbServiceOrgTeams.isEmpty()){
            tbServiceOrgTeamCopies.clear();
        }
        tbServiceOrgCopy.setTb_service_org_team(tbServiceOrgTeamCopies);
        //将id设置为空
        tbServiceOrgCopy.setOrgId(null);

        // 处理图片格式
        tbServiceOrgCopy.setOrgLogo(IBPSFileUtils.uploadFile2Json(account, tbServiceOrgCopy.getOrgLogo()));

        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(orgProcessId, account, tbServiceOrgCopy);
        String okStatus="200";
        //启动工作流成功
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("机构认证信提交成功，审批流程启动成功,流程实例id为：[{}]",ibpsResult.getData());
            clearOrgTempOldData(orgId);

        }
        return code;
    }

    /**
     * 清空机构认证原有数据
     * @param orgId
     */
    @ServiceLog(doAction = "清空机构认证原有数据")
    private void clearOrgTempOldData(String orgId) {
        //ibps启动成功，将原有数据全部删除 [ibps会重新查询一份新数据]
        TbServiceOrgTempCriteria orgCriteriaTemp = new TbServiceOrgTempCriteria();
        orgCriteriaTemp.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int i = tbServiceOrgTempMapper.deleteByExample(orgCriteriaTemp);
        logger.info("工作流启动成功，删除原机构基本信息，响应数据条数：{}",i);
        TbServiceOrgElementCriteria orgElementCriteria = new TbServiceOrgElementCriteria();
        orgElementCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int i1 = tbServiceOrgElementMapper.deleteByExample(orgElementCriteria);
        logger.info("工作流启动成功，删除原服务机构团队人员结构信息，响应数据条数：{}",i1);
        TbServiceOrgInfoCriteria orgInfoCriteria = new TbServiceOrgInfoCriteria();
        orgInfoCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int i2 = tbServiceOrgInfoMapper.deleteByExample(orgInfoCriteria);
        logger.info("工作流启动成功，删除原服务机构地址信息，响应数据条数：{}",i2);
        TbServiceOrgLicenseCriteria orgLicenseCriteria = new TbServiceOrgLicenseCriteria();
        orgLicenseCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int i3 = tbServiceOrgLicenseMapper.deleteByExample(orgLicenseCriteria);
        logger.info("工作流启动成功，删除原机构资质信息，响应数据条数：{}",i3);
        TbServiceOrgTeamCriteria orgTeamCriteria = new TbServiceOrgTeamCriteria();
        orgTeamCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int i4 = tbServiceOrgTeamMapper.deleteByExample(orgTeamCriteria);
        logger.info("工作流启动成功，删除原机构团队信息，响应数据条数：{}",i4);
        TbServiceOrgTraitCriteria orgTraitCriteria = new TbServiceOrgTraitCriteria();
        orgTraitCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int i5 = tbServiceOrgTraitMapper.deleteByExample(orgTraitCriteria);
        logger.info("工作流启动成功，删除原服务机构特性信息，响应数据条数：{}",i5);
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
        orgCriteria.createCriteria().andOrgStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long orgNum = tbServiceOrgMapper.countByExample(orgCriteria);
        serviceStatisticalNumVO.setOrgNum(orgNum+"");

        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andCheckStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long companyNum = tbServiceCompanyMapper.countByExample(companyCriteria);
        serviceStatisticalNumVO.setCompanyNum(companyNum+"");

        TbServiceAdvisorCriteria advisorCriteria = new TbServiceAdvisorCriteria();
        advisorCriteria.createCriteria().andApprovalStatusEqualTo(ADVISOR_STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long advisorNum = tbServiceAdvisorMapper.countByExample(advisorCriteria);
        serviceStatisticalNumVO.setAdvisorNum(advisorNum+"");

        TbServiceInvestorCriteria investorCriteria = new TbServiceInvestorCriteria();
        investorCriteria.createCriteria().andApprovalStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
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
        TbServiceProductCriteria.Criteria productCriteriac = productCriteria.createCriteria().andStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andSignoryIdNotEqualTo(TECHNOLOGY_FINANCE).andOrgIdIsNotNull().andOrgIdNotEqualTo("");

        if(StringUtils.isNotEmpty(businessType)){

            //机构数
            TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
            orgCriteria.createCriteria().andBusinessTypeLike("%"+businessType+"%").andOrgStatusEqualTo(STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long orgNum = tbServiceOrgMapper.countByExample(orgCriteria);
            businessStatisticalNumVO.setOrgNum(orgNum+"");
            productCriteriac.andSignoryIdEqualTo(businessType);

            //顾问数
            TbServiceAdvisorCriteria advisorCriteria = new TbServiceAdvisorCriteria();
            advisorCriteria.createCriteria().andBusinessAreaLike("%"+businessType+"%").andApprovalStatusEqualTo(ADVISOR_STATUS_EFFECTIVE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long advisorNum = tbServiceAdvisorMapper.countByExample(advisorCriteria);
            businessStatisticalNumVO.setAdvisorNum(advisorNum +"");

            //交易量
            TbServiceRequireCriteria requireCriteria = new TbServiceRequireCriteria();
            requireCriteria.createCriteria().andHandleResultEqualTo(REQUIRE_HANDLE_RESULT_SUCCESS).andBusinessIdEqualTo(businessType).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
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
        //查询正式表
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgAccountEqualTo(account).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        orgCriteria.setOrderByClause(" created_time desc ");
        List<TbServiceOrg> serviceOrgList = tbServiceOrgMapper.selectByExample(orgCriteria);
        if(serviceOrgList.isEmpty()){
            //查询临时表
            TbServiceOrgTempCriteria example=new TbServiceOrgTempCriteria();
            example.createCriteria().andOrgAccountEqualTo(account).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            example.setOrderByClause("created_time desc");
            List<TbServiceOrgTemp> serviceOrgTempList = tbServiceOrgTempMapper.selectByExample(example);
            if(serviceOrgTempList.isEmpty()){
                return "-1";
            }else{
                return serviceOrgTempList.get(0).getOrgStatus();
            }
        }else{
            return serviceOrgList.get(0).getOrgStatus();
        }
    }

    /**
     * 添加机构管理员角色
     * @param tbServiceOrgCopy
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "添加机构管理员角色")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addOrgRole(TbServiceOrgCopy  tbServiceOrgCopy,String loginAccount) {
        String orgAccount=tbServiceOrgCopy.getOrgAccount();
        String orgId=tbServiceOrgCopy.getOrgId();
        if(StringUtils.isBlank(orgAccount)){
            logger.warn("添加机构管理员角色失败，失败原因：机构账号不能为空");
            throw new JnSpringCloudException(OrgExceptionEnum.ACCOUNT_NOT_NULL);
        }
        if(StringUtils.isBlank(orgId)){
            logger.warn("添加机构管理员角色失败，失败原因：机构id不能为空");
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_ID_IS_NOT_NULL);
        }
        //判断当前账号在系统中是否存在
        User user=new User();
        user.setAccount(orgAccount);
        Result<User> userResult = systemClient.getUser(user);
        if(userResult==null || userResult.getData()==null){
            logger.warn("添加机构管理员角色失败，失败原因：机构账号在系统中不存在");
            throw new JnSpringCloudException(OrgExceptionEnum.ACCOUNT_NOT_NULL);
        }
        //新增机构认证信息
        if(StringUtils.isBlank(tbServiceOrgCopy.getOriginalId())){
            //把机构认证信息从临时表移动到正式表
            moveTempOrgInfoToFormal(tbServiceOrgCopy);
        }else{
            //修改机构认证信息
            //修改基本信息
            updateOrgBaseData(tbServiceOrgCopy, loginAccount);
            //修改机构团队人员结构信息
            updateOrgElementData(tbServiceOrgCopy, loginAccount);
            //修改机构地址信息
            updateOrgInfoData(tbServiceOrgCopy, loginAccount);
            //修改服务机构资质信息
            updateOrgLicenseData(tbServiceOrgCopy, loginAccount);
            //修改机构团队信息
            updateOrgTeamData(tbServiceOrgCopy,loginAccount);
            //修改机构特性
            updateOrgTraitData(tbServiceOrgCopy,loginAccount);
            //清除要更新的服务机构新增数据
            clearOldServiceInfoData(tbServiceOrgCopy.getOrgId());
            //更新机构用户所属机构信息
            updateOrgAccountAffiliateInfo(tbServiceOrgCopy.getOrgAccount(),tbServiceOrgCopy.getOriginalId(),tbServiceOrgCopy.getOrgName());
        }

        //给用户添加"机构管理员"角色
        Result<SysRole> addSysRoleResult = systemClient.getRoleByName(HomeRoleEnum.ORG_ADMIN.getCode());
        Result<SysRole> delSysRoleResult = systemClient.getRoleByName(HomeRoleEnum.NORMAL_USER.getCode());
        if(addSysRoleResult==null ||addSysRoleResult.getData()==null || delSysRoleResult==null || delSysRoleResult.getData()==null){
            logger.warn("添加机构管理员角色失败，失败原因：无法获取“机构管理员”、“普通用户”角色信息，请确认系统服务是否正常，且“机构管理员”、“普通用户”角色在系统中存在");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        //更新用户角色
        Result<Boolean> booleanResult = investorService.updateUserRoleInfo(user, addSysRoleResult,delSysRoleResult);
        if(booleanResult.getData()){
            //把机构id和机构名称更新到用户信息表
            return 1;
        }else{
            logger.warn("添加机构管理员角色失败，失败原因：更新用户角色为“机构管理员”失败");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 修改服务机构特性信息
     * @param tbServiceOrgCopy
     * @param loginAccount
     */
    @ServiceLog(doAction = "修改服务机构特性信息")
    private void updateOrgTraitData(TbServiceOrgCopy tbServiceOrgCopy, String loginAccount) {
        TbServiceOrgTraitCriteria traitExample=new TbServiceOrgTraitCriteria();
        traitExample.createCriteria().andOrgIdEqualTo(tbServiceOrgCopy.getOriginalId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        //1.根据机构id删除表中原有数据
        int resNum = tbServiceOrgTraitMapper.deleteByExample(traitExample);
        logger.info("根据机构id:[{}]删除服务机构特性信息成功，数据响应条数;{}",tbServiceOrgCopy.getOriginalId(),resNum);
        //2.把信息的表单数据插入数据库
        if(!tbServiceOrgCopy.getTb_service_org_trait().isEmpty()){
            List<TbServiceOrgTraitCopy>  traitCopyList = tbServiceOrgCopy.getTb_service_org_trait();
            for(TbServiceOrgTraitCopy traitCopy:traitCopyList){
                TbServiceOrgTrait orgTrait=new TbServiceOrgTrait();
                BeanUtils.copyProperties(traitCopy, orgTrait);
                //主键id
                orgTrait.setId(UUID.randomUUID().toString());
                //机构id
                orgTrait.setOrgId(tbServiceOrgCopy.getOriginalId());
                logger.info("服务机构特性信息数据：{}",orgTrait.toString());
                orgTrait.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getTb_service_org_info().getCreatedTime()));
                orgTrait.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
                orgTrait.setModifierAccount(loginAccount);
                orgTrait.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
                resNum+=tbServiceOrgTraitMapper.insertSelective(orgTrait);
            }
            logger.info("修改服务机构特性信息成功，数据响应条数：{}",resNum);
        }
    }



    /**
     * 修改服务机构团队信息
     * @param tbServiceOrgCopy
     * @param loginAccount
     */
    @ServiceLog(doAction = "修改服务机构团队信息")
    private void updateOrgTeamData(TbServiceOrgCopy tbServiceOrgCopy, String loginAccount) {
        TbServiceOrgTeamCriteria teamExample=new TbServiceOrgTeamCriteria();
        teamExample.createCriteria().andOrgIdEqualTo(tbServiceOrgCopy.getOriginalId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        //1.根据机构id删除表中原有数据
        int resNum = tbServiceOrgTeamMapper.deleteByExample(teamExample);
        logger.info("根据机构id:[{}]删除服务机构团队信息成功，数据响应条数;{}",tbServiceOrgCopy.getOriginalId(),resNum);
        //2.把信息的表单数据插入数据库
        if(!tbServiceOrgCopy.getTb_service_org_team().isEmpty()){
            List<TbServiceOrgTeamCopy> teamCopyList = tbServiceOrgCopy.getTb_service_org_team();
            for(TbServiceOrgTeamCopy teamCopy:teamCopyList){
                TbServiceOrgTeam  orgTeam=new TbServiceOrgTeam();
                BeanUtils.copyProperties(teamCopy, orgTeam);
                orgTeam.setOrgId(tbServiceOrgCopy.getOriginalId());
                orgTeam.setId(UUID.randomUUID().toString());
                logger.info("服务机构团队信息数据：{}",orgTeam.toString());
                orgTeam.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getTb_service_org_info().getCreatedTime()));
                orgTeam.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
                orgTeam.setModifierAccount(loginAccount);
                orgTeam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
                resNum+=tbServiceOrgTeamMapper.insertSelective(orgTeam);
            }
            logger.info("修改服务机构团队信息成功，数据响应条数：{}",resNum);
        }
    }

    /**
     * 修改服务机构资质信息
     * @param tbServiceOrgCopy
     * @param loginAccount
     */
    @ServiceLog(doAction = "修改服务机构资质信息")
    private void updateOrgLicenseData(TbServiceOrgCopy tbServiceOrgCopy, String loginAccount) {
        TbServiceOrgLicenseCriteria licenseExample=new TbServiceOrgLicenseCriteria();
        licenseExample.createCriteria().andOrgIdEqualTo(tbServiceOrgCopy.getOriginalId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        //1.根据机构id删除表中原有数据
        int resNum = tbServiceOrgLicenseMapper.deleteByExample(licenseExample);
        logger.info("根据机构id:[{}]删除服务机构资质信息成功，数据响应条数;{}",tbServiceOrgCopy.getOriginalId(),resNum);
        //2.把信息的表单数据插入数据库
        if(!tbServiceOrgCopy.getTb_service_org_license().isEmpty()){
            List<TbServiceOrgLicenseCopy> licenseCopyList = tbServiceOrgCopy.getTb_service_org_license();
            for(TbServiceOrgLicenseCopy licenseCopy:licenseCopyList){
                TbServiceOrgLicense tbServiceOrgLicense=new TbServiceOrgLicense();
                BeanUtils.copyProperties(licenseCopy, tbServiceOrgLicense);
                tbServiceOrgLicense.setId(UUID.randomUUID().toString());
                //原来的orgId
                tbServiceOrgLicense.setOrgId(tbServiceOrgCopy.getOriginalId());
                if(licenseCopy.getAwardTime()!=null){
                    tbServiceOrgLicense.setAwardTime(DateUtils.parseDate(licenseCopy.getAwardTime()));
                }
                logger.info("机构资质数据：{}",tbServiceOrgLicense.toString());
                tbServiceOrgLicense.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
                tbServiceOrgLicense.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getTb_service_org_info().getCreatedTime()));
                tbServiceOrgLicense.setModifierAccount(loginAccount);
                tbServiceOrgLicense.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
                resNum+=tbServiceOrgLicenseMapper.insertSelective(tbServiceOrgLicense);
            }
            logger.info("修改机构资质成功，数据响应条数：{}",resNum);
        }
    }

    /**
     * 修改机构地址信息
     * @param tbServiceOrgCopy
     * @param loginAccount
     */
    @ServiceLog(doAction = "修改机构地址信息")
    private void updateOrgInfoData(TbServiceOrgCopy tbServiceOrgCopy, String loginAccount) {
        TbServiceOrgInfoCriteria infoExample=new TbServiceOrgInfoCriteria();
        infoExample.createCriteria().andOrgIdEqualTo(tbServiceOrgCopy.getOriginalId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        //1.根据机构id删除表中原有数据
        int resNum = tbServiceOrgInfoMapper.deleteByExample(infoExample);
        logger.info("根据机构id:[{}]删除机构地址信息成功，数据响应条数;{}",tbServiceOrgCopy.getOriginalId(),resNum);
        //2.把信息的表单数据插入数据库
        if(tbServiceOrgCopy.getTb_service_org_info()!=null){
            TbServiceOrgInfo tbServiceOrgInfo=new TbServiceOrgInfo();
            BeanUtils.copyProperties(tbServiceOrgCopy.getTb_service_org_info(), tbServiceOrgInfo);
            tbServiceOrgInfo.setOrgId(tbServiceOrgCopy.getOriginalId());
            tbServiceOrgInfo.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getTb_service_org_info().getCreatedTime()));
            tbServiceOrgInfo.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbServiceOrgInfo.setModifierAccount(loginAccount);
            tbServiceOrgInfo.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            resNum=tbServiceOrgInfoMapper.insert(tbServiceOrgInfo);
            logger.info("修改机构地址信息信息成功，数据响应条数：{}",resNum);
        }
    }

    /**
     * 把机构认证信息从临时表移动到正式表
     * @param tbServiceOrgCopy
     */
    @ServiceLog(doAction = "把机构认证信息从临时表移动到正式表")
    @Transactional(rollbackFor = Exception.class)
    public  void moveTempOrgInfoToFormal(TbServiceOrgCopy tbServiceOrgCopy) {
        TbServiceOrg tbServiceOrg=new TbServiceOrg();
        BeanUtils.copyProperties(tbServiceOrgCopy, tbServiceOrg);
        //审批状态改为审批通过  状态(0：未审核[审核中] 1：审核通过  2：审核不通过)
        tbServiceOrg.setOrgStatus(ApprovalStatusEnum.APPROVAL.getValue());
        tbServiceOrg.setOrgRegisterTime(DateUtils.parseDate(tbServiceOrgCopy.getOrgRegisterTime()));
        tbServiceOrg.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getCreatedTime()));
        tbServiceOrg.setCheckTime(DateUtils.parseDate(tbServiceOrgCopy.getCheckTime()));
        tbServiceOrg.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        int resNum = tbServiceOrgMapper.insertSelective(tbServiceOrg);
        logger.info("新增机构认证信息成功，数据响应条数：{}",resNum);
        TbServiceOrgTempCriteria example=new TbServiceOrgTempCriteria();
        example.createCriteria().andOrgIdEqualTo(tbServiceOrg.getOrgId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        resNum=tbServiceOrgTempMapper.deleteByExample(example);
        logger.info("根据机构id:[{}]删除机构临时表数据成功，数据响应条数：{}",tbServiceOrgCopy.getOrgId(),resNum);
        //更新机构用户所属机构信息
        updateOrgAccountAffiliateInfo(tbServiceOrgCopy.getOrgAccount(),tbServiceOrgCopy.getOrgId(),tbServiceOrgCopy.getOrgName());
    }

    /**
     * 修改机构团队人员结构信息
     * @param tbServiceOrgCopy
     * @param loginAccount
     */
    @ServiceLog(doAction = "修改机构团队人员结构信息")
    private void updateOrgElementData(TbServiceOrgCopy tbServiceOrgCopy, String loginAccount) {
        TbServiceOrgElementCriteria elementExample=new TbServiceOrgElementCriteria();
        elementExample.createCriteria().andOrgIdEqualTo(tbServiceOrgCopy.getOriginalId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        //1.根据机构id删除表中原有数据
        int resNum = tbServiceOrgElementMapper.deleteByExample(elementExample);
        logger.info("根据机构id:[{}]删除机构团队人员信息成功，数据响应条数;{}",tbServiceOrgCopy.getOriginalId(),resNum);
        //2.把信息的表单数据插入数据库
        if(tbServiceOrgCopy.getTb_service_org_element()!=null){
            TbServiceOrgElement tbServiceOrgElement=new TbServiceOrgElement();
            BeanUtils.copyProperties(tbServiceOrgCopy.getTb_service_org_element(), tbServiceOrgElement);
            tbServiceOrgElement.setId(UUID.randomUUID().toString());
            tbServiceOrgElement.setOrgId(tbServiceOrgCopy.getOriginalId());
            tbServiceOrgElement.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getTb_service_org_element().getCreatedTime()));
            tbServiceOrgElement.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbServiceOrgElement.setModifierAccount(loginAccount);
            tbServiceOrgElement.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            resNum=tbServiceOrgElementMapper.insert(tbServiceOrgElement);
            logger.info("修改机构团队人员信息成功，数据响应条数：{}",resNum);
        }
    }

    /**
     * 修改机构认证基本信息
     * @param tbServiceOrgCopy
     * @param loginAccount
     */
    @ServiceLog(doAction = "修改机构认证基本信息")
    private void updateOrgBaseData(TbServiceOrgCopy tbServiceOrgCopy, String loginAccount) {
        TbServiceOrg tbServiceOrg =new TbServiceOrg();
        BeanUtils.copyProperties(tbServiceOrgCopy, tbServiceOrg);
        tbServiceOrg.setOrgId(tbServiceOrgCopy.getOriginalId());
        //审批状态改为审批通过  状态(0：未审核[审核中] 1：审核通过  2：审核不通过)
        tbServiceOrg.setOrgStatus(ApprovalStatusEnum.APPROVAL.getValue());
        tbServiceOrg.setOrgRegisterTime(DateUtils.parseDate(tbServiceOrgCopy.getOrgRegisterTime()));
        tbServiceOrg.setCreatedTime(DateUtils.parseDate(tbServiceOrgCopy.getCreatedTime()));
        tbServiceOrg.setCheckTime(DateUtils.parseDate(tbServiceOrgCopy.getCheckTime()));
        tbServiceOrg.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        tbServiceOrg.setModifierAccount(loginAccount);
        tbServiceOrg.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        example.createCriteria().andOrgIdEqualTo(tbServiceOrgCopy.getOriginalId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        int resNum = tbServiceOrgMapper.updateByExampleSelective(tbServiceOrg, example);
        logger.info("修改机构认证基本信息成功，数据响应条数：{}",resNum);
    }

    /**
     * 更新机构用户所属机构信息
     * @param orgAccount
     */
    @ServiceLog(doAction = "更新机构用户所属机构信息")
    private void updateOrgAccountAffiliateInfo(String orgAccount,String orgId,String orgName) {
        UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();
        List accountList= Arrays.asList(orgAccount);
        userAffiliateInfo.setAccountList(accountList);
        userAffiliateInfo.setAffiliateCode(orgId);
        userAffiliateInfo.setAffiliateName(orgName);
        Result resultData = userExtensionClient.updateAffiliateInfo(userAffiliateInfo);
        if(resultData==null ||resultData.getData()==null || !(Boolean)resultData.getData()){
            logger.warn("添加机构管理员角色失败，失败原因：更新用户所属机构信息失败");
            throw new JnSpringCloudException(OrgExceptionEnum.UPDATE_ACCOUNT_ORG_INFO_FAIL);
        }else{
            logger.info("更新用户[{}]所属机构信息成功",orgAccount);
        }
    }

    /**
     * 清除要更新的服务机构新增数据
     * @param addOrgId
     */
    @ServiceLog(doAction = "清除要更新的服务机构新增数据")
    @Transactional(rollbackFor = Exception.class)
    public void clearOldServiceInfoData(String addOrgId) {
        //根据机构id删除临时表中数据
        int resNum = tbServiceOrgTempMapper.deleteByPrimaryKey(addOrgId);
        logger.info("根据机构id:[{}]删除机构临时表数据成功，数据响应条数:{}条",addOrgId,resNum);
        //删除服务机构团队人员信息
        TbServiceOrgElementCriteria elementExample=new TbServiceOrgElementCriteria();
        elementExample.createCriteria().andOrgIdEqualTo(addOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        resNum=tbServiceOrgElementMapper.deleteByExample(elementExample);
        logger.info("根据机构id:[{}]删除服务机构团队人员信息表数据成功，数据响应条数:{}条",addOrgId,resNum);
        //删除服务机构地址信息
        TbServiceOrgInfoCriteria orgInfoExample=new TbServiceOrgInfoCriteria();
        orgInfoExample.createCriteria().andOrgIdEqualTo(addOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        resNum=tbServiceOrgInfoMapper.deleteByExample(orgInfoExample);
        logger.info("根据机构id:[{}]删除服务机构地址信息表数据成功，数据响应条数:{}条",addOrgId,resNum);
        //删除服务机构资质信息
        TbServiceOrgLicenseCriteria licenseExample=new TbServiceOrgLicenseCriteria();
        licenseExample.createCriteria().andOrgIdEqualTo(addOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        resNum=tbServiceOrgLicenseMapper.deleteByExample(licenseExample);
        logger.info("根据机构id:[{}]删除服务机构资质信息表数据成功，数据响应条数:{}条",addOrgId,resNum);
        //删除服务机构团队信息
        TbServiceOrgTeamCriteria teamExample=new TbServiceOrgTeamCriteria();
        teamExample.createCriteria().andOrgIdEqualTo(addOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        resNum=tbServiceOrgTeamMapper.deleteByExample(teamExample);
        logger.info("根据机构id:[{}]删除服务机构团队信息表数据成功，数据响应条数:{}条",addOrgId,resNum);
        //删除服务机构特性信息
        TbServiceOrgTraitCriteria traitExample=new TbServiceOrgTraitCriteria();
        traitExample.createCriteria().andOrgIdEqualTo(addOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        resNum=tbServiceOrgTraitMapper.deleteByExample(traitExample);
        logger.info("根据机构id:[{}]删除服务机构特性信息表数据成功，数据响应条数:{}条",addOrgId,resNum);
    }
}
