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
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.model.IBPSFile;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.enterprise.servicemarket.org.TraitTypeEnum;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
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
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 机构认证流程id
     */
    @Value(value = "${orgProcessId}")
    private String orgProcessId;

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
    private final static String ORG_APPLY_IS_CHECKING = "0";

    @ServiceLog(doAction = "查询服务机构列表")
    @Override
    public PaginationData<List<ServiceOrg>> selectServiceOrgList(OrgParameter orgParameter){
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
        //处理logo图片格式
        orgDetailVo.setOrgLogo(IBPSFileUtils.getFilePath(orgDetailVo.getOrgLogo()));
        //获取客户偏好--行业领域
        List<TbServiceOrgTrait> serviceOrgTraitList = getOrgIndustrySector(orgId,TraitTypeEnum.INDUSTRY_FIELDS.getValue());
        if(!serviceOrgTraitList.isEmpty()){
            List<String>industrySectorList=new ArrayList<>(16);
            for(TbServiceOrgTrait tbServiceOrgTrait:serviceOrgTraitList){
                industrySectorList.add(tbServiceOrgTrait.getTraitValue());
            }
            orgDetailVo.setIndustrySector(industrySectorList);
        }
        //获取客户偏好--发展阶段
        serviceOrgTraitList=getOrgIndustrySector(orgId,TraitTypeEnum.STAGE_OF_DEVELOP.getValue());
        if(!serviceOrgTraitList.isEmpty()){
            List<String>developmentStageList=new ArrayList<>(16);
            for(TbServiceOrgTrait tbServiceOrgTrait:serviceOrgTraitList){
                developmentStageList.add(tbServiceOrgTrait.getTraitValue());
            }
            orgDetailVo.setDevelopmentStage(developmentStageList);
        }
        //获取机构荣誉资质
        getOrgHonorInfoByOrgId(orgId, orgDetailVo);
        //获取机构团队信息
        TbServiceOrgTeamCriteria example=new TbServiceOrgTeamCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgTeam> serviceOrgTeamList = tbServiceOrgTeamMapper.selectByExample(example);
        if(!serviceOrgTeamList.isEmpty()){
            List<OrgTeam> orgTeamList=new ArrayList<>(16);
            for(TbServiceOrgTeam serviceOrgTeam:serviceOrgTeamList){
                OrgTeam orgTeam=new OrgTeam();
                BeanUtils.copyProperties(serviceOrgTeam,orgTeam);
                orgTeamList.add(orgTeam);
            }
           orgDetailVo.setOrgTeams(orgTeamList);
        }
        return orgDetailVo;
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
                OrgLicense orgLicense=new OrgLicense();
                //处理图片格式
                serviceOrgLicense.setFileUrl(IBPSFileUtils.getFilePath(serviceOrgLicense.getFileUrl()));
                BeanUtils.copyProperties(serviceOrgLicense, orgLicense);
                honorLicense.add(orgLicense);
            }
            orgDetailVo.setOrgLicenses(honorLicense);
        }
    }

    /**
     * 根据机构id获取客户偏好--行业领域,发展阶段
     * @param orgId
     * @return
     */
    @ServiceLog(doAction = "")
    private List<TbServiceOrgTrait> getOrgIndustrySector(String orgId,String traitType) {
        TbServiceOrgTraitCriteria example=new TbServiceOrgTraitCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId)
                .andTraitTypeEqualTo(traitType)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        return tbServiceOrgTraitMapper.selectByExample(example);
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
            tbServiceOrg.setOrgHobby(StringUtils.join(sbHobby,","));
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
            BeanUtils.copyProperties(orgLicense, tbServiceOrgLicense);
            if (orgLicense.getAwardTime() != null) {
                try {
                    tbServiceOrgLicense.setAwardTime(DateUtils.parseDate(orgLicense.getAwardTime(), "yyyy-MM-dd"));
                } catch(ParseException e){
                    logger.info("保存服务机构资质信息时间转换失败。失败原因{}", e.getMessage(), e);
                    throw new JnSpringCloudException(OrgExceptionEnum.ORG_TIME_PARSE_ERROR);
                }
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
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgIdEqualTo(orgId);
        List<TbServiceOrg> tbServiceOrgs = tbServiceOrgMapper.selectByExample(orgCriteria);
        if(null==tbServiceOrgs||tbServiceOrgs.size()!=1){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_DATA_IS_ERROR);
        }
        if(!StringUtils.equals(tbServiceOrgs.get(0).getOrgStatus(),ORG_APPLY_IS_CHECKING)){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_DATA_STATUS_IS_NOT_CHECKING);
        }
        //获取tbServiceOrg的ORGID作为其子表的ORGID条件查询出关联数据
        TbServiceOrg tbServiceOrg=tbServiceOrgs.get(0);
        TbServiceOrgCopy tbServiceOrgCopy= new TbServiceOrgCopy();
        BeanUtils.copyProperties(tbServiceOrg,tbServiceOrgCopy);
        //将Date类型转换成String类型,
        if(null != tbServiceOrg.getOrgRegisterTime()){
            tbServiceOrgCopy.setOrgRegisterTime(DateUtils.formatDate(tbServiceOrg.getOrgRegisterTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        if(null != tbServiceOrg.getCheckTime()){
            tbServiceOrgCopy.setCheckTime(DateUtils.formatDate(tbServiceOrg.getCheckTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        if(null != tbServiceOrg.getCreatedTime()){
            tbServiceOrgCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrg.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        if(null != tbServiceOrg.getModifiedTime()){
            tbServiceOrgCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrg.getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        //将Byte转为String类型
        if(null != tbServiceOrg.getRecordStatus()){
            tbServiceOrgCopy.setRecordStatus((int)tbServiceOrg.getRecordStatus()+"");
        }
        //=============== 获取子表信息 =====================
        String ServiceOrgId=tbServiceOrg.getOrgId();
        TbServiceOrgElementCriteria example=new TbServiceOrgElementCriteria();
        example.createCriteria().andOrgIdEqualTo(ServiceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgElement> tbServiceOrgElements = tbServiceOrgElementMapper.selectByExample(example);

        //一对一
        TbServiceOrgElementCopy tbServiceOrgElementCopy1=new TbServiceOrgElementCopy();
        if(tbServiceOrgElements.size() != 0){
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgElements.get(0),tbServiceOrgElementCopy1);
            if(null != tbServiceOrgElements.get(0).getCreatedTime()){
                tbServiceOrgElementCopy1.setCreatedTime(DateUtils.formatDate(tbServiceOrgElements.get(0).getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgElements.get(0).getModifiedTime()){
                tbServiceOrgElementCopy1.setModifiedTime(DateUtils.formatDate(tbServiceOrgElements.get(0).getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
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
        example1.createCriteria().andOrgIdEqualTo(ServiceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgInfo> tbServiceOrgInfos = tbServiceOrgInfoMapper.selectByExample(example1);

        TbServiceOrgInfoCopy TbServiceOrgInfoCopy=new TbServiceOrgInfoCopy();
        if(tbServiceOrgInfos.size() != 0){
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgInfos.get(0),TbServiceOrgInfoCopy);
            if(null != tbServiceOrgInfos.get(0).getCreatedTime()){
                TbServiceOrgInfoCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgInfos.get(0).getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgInfos.get(0).getModifiedTime()){
                TbServiceOrgInfoCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgInfos.get(0).getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgInfos.get(0).getRecordStatus()){
                TbServiceOrgInfoCopy.setRecordStatus((int)tbServiceOrgInfos.get(0).getRecordStatus()+"");
            }
        }
        TbServiceOrgInfoCopy.setOrgId(orgId);
        tbServiceOrgCopy.setTb_service_org_info(TbServiceOrgInfoCopy);

        //一对多
        TbServiceOrgLicenseCriteria example2=new TbServiceOrgLicenseCriteria();
        example2.createCriteria().andOrgIdEqualTo(ServiceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgLicense> tbServiceOrgLicenses = tbServiceOrgLicenseMapper.selectByExample(example2);
        List<TbServiceOrgLicenseCopy> tbServiceOrgLicenseCopies=new ArrayList<>();

        for(int i=0;i<tbServiceOrgLicenses.size();i++){
            TbServiceOrgLicenseCopy tbServiceOrgLicenseCopy=new TbServiceOrgLicenseCopy();
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgLicenses.get(i),tbServiceOrgLicenseCopy);
            if(null != tbServiceOrgLicenses.get(i).getCreatedTime()){
                tbServiceOrgLicenseCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgLicenses.get(i).getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgLicenses.get(i).getModifiedTime()){
                tbServiceOrgLicenseCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgLicenses.get(i).getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgLicenses.get(i).getRecordStatus()){
                tbServiceOrgLicenseCopy.setRecordStatus((int)tbServiceOrgLicenses.get(i).getRecordStatus()+"");
            }
            tbServiceOrgLicenseCopy.setOrgId(null);
            tbServiceOrgLicenseCopy.setId(null);
            tbServiceOrgLicenseCopies.add(tbServiceOrgLicenseCopy);
        }
        if (tbServiceOrgLicenses.size() == 0){
            tbServiceOrgLicenseCopies.clear();
        }
        tbServiceOrgCopy.setTb_service_org_license(tbServiceOrgLicenseCopies);

        //一对多
        TbServiceOrgTraitCriteria example3=new TbServiceOrgTraitCriteria();
        example3.createCriteria().andOrgIdEqualTo(ServiceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgTrait> tbServiceOrgTraits = tbServiceOrgTraitMapper.selectByExample(example3);
        List<TbServiceOrgTraitCopy> tbServiceOrgTraitCopies=new ArrayList<>();

        for(int i=0;i<tbServiceOrgTraits.size();i++){
            TbServiceOrgTraitCopy tbServiceOrgLicenseCopy=new TbServiceOrgTraitCopy();
            //复制bean
            BeanUtils.copyProperties(tbServiceOrgTraits.get(i),tbServiceOrgLicenseCopy);
            if(null != tbServiceOrgTraits.get(i).getCreatedTime()){
                tbServiceOrgLicenseCopy.setCreatedTime(DateUtils.formatDate(tbServiceOrgTraits.get(i).getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgTraits.get(i).getModifiedTime()){
                tbServiceOrgLicenseCopy.setModifiedTime(DateUtils.formatDate(tbServiceOrgTraits.get(i).getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != tbServiceOrgTraits.get(i).getRecordStatus()){
                tbServiceOrgLicenseCopy.setRecordStatus((int)tbServiceOrgTraits.get(i).getRecordStatus()+"");
            }
            tbServiceOrgLicenseCopy.setOrgId(null);
            tbServiceOrgLicenseCopy.setId(null);
            tbServiceOrgTraitCopies.add(tbServiceOrgLicenseCopy);
        }
        if (tbServiceOrgTraits.size() ==0){
            tbServiceOrgTraitCopies.clear();
        }
        tbServiceOrgCopy.setTb_service_org_trait(tbServiceOrgTraitCopies);

        //一对多
        TbServiceOrgTeamCriteria example4=new TbServiceOrgTeamCriteria();
        example4.createCriteria().andOrgIdEqualTo(ServiceOrgId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrgTeam> tbServiceOrgTeams = tbServiceOrgTeamMapper.selectByExample(example4);
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
        if (tbServiceOrgTeams.size() == 0){
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
            //ibps启动成功，将原有数据全部删除 [ibps会重新查询一份新数据]
            TbServiceOrgCriteria orgCriteria1 = new TbServiceOrgCriteria();
            orgCriteria1.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            int i = tbServiceOrgMapper.deleteByExample(orgCriteria1);
            logger.info("工作流启动成功，删除原机构基本信息，响应数据条数：{}",i);
            TbServiceOrgElementCriteria orgElementCriteria = new TbServiceOrgElementCriteria();
            orgElementCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            int i1 = tbServiceOrgElementMapper.deleteByExample(orgElementCriteria);
            logger.info("工作流启动成功，删除原服务机构团队人员结构信息，响应数据条数：{}",i1);
            TbServiceOrgInfoCriteria orgInfoCriteria = new TbServiceOrgInfoCriteria();
            orgInfoCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            int i2 = tbServiceOrgInfoMapper.deleteByExample(orgInfoCriteria);
            logger.info("工作流启动成功，删除原服务机构地址信息，响应数据条数：{}",i2);
            TbServiceOrgLicenseCriteria orgLicenseCriteria = new TbServiceOrgLicenseCriteria();
            orgLicenseCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            int i3 = tbServiceOrgLicenseMapper.deleteByExample(orgLicenseCriteria);
            logger.info("工作流启动成功，删除原机构资质信息，响应数据条数：{}",i3);
            TbServiceOrgTeamCriteria orgTeamCriteria = new TbServiceOrgTeamCriteria();
            orgTeamCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            int i4 = tbServiceOrgTeamMapper.deleteByExample(orgTeamCriteria);
            logger.info("工作流启动成功，删除原机构团队信息，响应数据条数：{}",i4);
            TbServiceOrgTraitCriteria orgTraitCriteria = new TbServiceOrgTraitCriteria();
            orgTraitCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            int i5 = tbServiceOrgTraitMapper.deleteByExample(orgTraitCriteria);
            logger.info("工作流启动成功，删除原服务机构特性信息，响应数据条数：{}",i5);

        }
        return code;
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

    /**
     * 添加机构管理员角色
     * @param orgAccount
     * @return
     */
    @ServiceLog(doAction = "添加机构管理员角色")
    @Override
    public int addOrgRole(String orgAccount) {
        if(StringUtils.isBlank(orgAccount)){
            logger.warn("添加机构管理员角色失败，失败原因：机构账号不能为空");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        //判断当前账号在系统中是否存在
        User user=new User();
        user.setAccount(orgAccount);
        Result<User> userResult = systemClient.getUser(user);
        if(userResult==null || userResult.getData()==null){
            logger.warn("添加机构管理员角色失败，失败原因：机构账号在系统中不存在");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        //更新机构用户的所属机构id和机构名称
        updateOrgAccountAffiliateInfo(orgAccount);
        //给用户添加"机构管理员"角色
        Result<SysRole> addSysRoleResult = systemClient.getRoleByName(HomeRoleEnum.ORG_ADMIN.getCode());
        Result<SysRole> delSysRoleResult = systemClient.getRoleByName(HomeRoleEnum.NORMAL_USER.getCode());
        if(addSysRoleResult==null ||addSysRoleResult.getData()==null || delSysRoleResult==null || delSysRoleResult.getData()==null){
            logger.warn("添加机构管理员角色失败，失败原因：无法获取“机构管理员”、“普通用户”角色信息，请确认系统服务是否正常，且“机构管理员”、“普通用户”角色在系统中存在");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        //更新用户角色
        Result<Boolean> booleanResult = investorService.updateUserRoleInfo(user, addSysRoleResult,delSysRoleResult);
        if(booleanResult.getData()==true){
            //把机构id和机构名称更新到用户信息表
            return 1;
        }else{
            logger.warn("添加机构管理员角色失败，失败原因：更新用户角色为“机构管理员”失败");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 更新机构用户所属机构信息
     * @param orgAccount
     */
    @ServiceLog(doAction = "")
    private void updateOrgAccountAffiliateInfo(String orgAccount) {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        example.createCriteria().andOrgAccountEqualTo(orgAccount)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrg> tbServiceOrgList = tbServiceOrgMapper.selectByExample(example);
        if(tbServiceOrgList.isEmpty()){
            logger.warn("添加机构管理员角色失败，失败原因：机构用户在系统中不存在或机构用户已失效");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();
        List accountList= Arrays.asList(orgAccount);
        userAffiliateInfo.setAccountList(accountList);
        userAffiliateInfo.setAffiliateCode(tbServiceOrgList.get(0).getOrgId());
        userAffiliateInfo.setAffiliateName(tbServiceOrgList.get(0).getOrgName());
        Result resultData = userExtensionClient.updateAffiliateInfo(userAffiliateInfo);
        if(resultData==null ||resultData.getData()==null || !(Boolean)resultData.getData()){
            logger.warn("添加机构管理员角色失败，失败原因：更新用户所属机构信息失败");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
    }
}
