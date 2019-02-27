package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.system.log.annotation.ServiceLog;
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

    @ServiceLog(doAction = "查询服务机构列表")
    @Override
    public PaginationData selectServiceOrgList(OrgParameter orgParameter){
        Page<Object> objects = PageHelper.startPage(orgParameter.getPage(), orgParameter.getRows() == 0 ? 15 : orgParameter.getRows());
        List<ServiceOrg> serviceOrg = orgMapper.selectServiceOrgList(orgParameter);
        PaginationData data = new PaginationData(serviceOrg, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "根据机构ID查询机构详情")
    @Override
    public OrgDetail getServiceOrgDetail(String orgId){
        return orgMapper.getServiceOrgDetail(orgId);
    }

    @ServiceLog(doAction = "保存服务机构基本信息(id为空时为新增)")
    @Override
    public int saveOrUpdateOrgBasicData(OrgBasicData orgBasicData, String account){
        int insert = 0;
        TbServiceOrg tbServiceOrg = new TbServiceOrg();
        BeanUtils.copyProperties(orgBasicData,tbServiceOrg);

        //修改、新增，设置状态为待审核
        tbServiceOrg.setOrgStatus("0");
        tbServiceOrg.setRecordStatus(new Byte("1"));
        if(StringUtils.isEmpty(orgBasicData.getOrgId())){
            tbServiceOrg.setOrgId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbServiceOrg.setCreatedTime(new Date());
            tbServiceOrg.setCreatorAccount(account);
            insert = tbServiceOrgMapper.insert(tbServiceOrg);
        }else{
            tbServiceOrg.setModifiedTime(new Date());
            tbServiceOrg.setModifierAccount(account);
            insert = tbServiceOrgMapper.updateByPrimaryKeySelective(tbServiceOrg);
        }

        //处理机构特性列表
        TbServiceOrgTraitCriteria traitCriteria = new TbServiceOrgTraitCriteria();
        traitCriteria.createCriteria().andOrgIdEqualTo(tbServiceOrg.getOrgId());
        tbServiceOrgTraitMapper.deleteByExample(traitCriteria);
        List<TbServiceOrgTrait> traits = new ArrayList<>();
        //trait_type : 特性类型(1业务擅长2行业领域3发展阶段4企业性质)
        traits.addAll(setTraitBean(orgBasicData.getOrgSpeciality(),"1",tbServiceOrg.getOrgId(),account));
        traits.addAll(setTraitBean(orgBasicData.getIndustrySector(),"2",tbServiceOrg.getOrgId(),account));
        traits.addAll(setTraitBean(orgBasicData.getDevelopmentStage(),"3",tbServiceOrg.getOrgId(),account));
        traits.addAll(setTraitBean(orgBasicData.getCompanyNature(),"4",tbServiceOrg.getOrgId(),account));
        Map<String,Object> map = new HashMap<>();
        map.put("list",traits);
        orgTraitMapper.insertTraitList(map);
        return insert;
    }

    /**
     * 封装机构特性TbServiceOrgTraitList
     * @param sectorList
     * @param traitType
     * @param serviceOrgId
     * @param account
     * @return
     */
    public List<TbServiceOrgTrait> setTraitBean(String sectorList,String traitType,String serviceOrgId,String account){
        String[] sectors = sectorList.split(",");
        List<TbServiceOrgTrait> traitsList = new ArrayList<>();
        for (String sector:sectors) {
            TbServiceOrgTrait serviceOrgTrait = new TbServiceOrgTrait();
            serviceOrgTrait.setOrgId(serviceOrgId);
            serviceOrgTrait.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            serviceOrgTrait.setCreatedTime(new Date());
            serviceOrgTrait.setCreatorAccount(account);
            serviceOrgTrait.setStatus("1");
            serviceOrgTrait.setTraitValue(sector);
            serviceOrgTrait.setRecordStatus(new Byte("1"));
            serviceOrgTrait.setTraitType(traitType);
            traitsList.add(serviceOrgTrait);
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
                logger.info("新增活动时间转换失败。失败原因{}", e.getMessage(), e);
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_TIME_PARSE_ERROR);
            }
            tbServiceOrgLicense.setCreatedTime(new Date());
            tbServiceOrgLicense.setCreatorAccount(account);
            tbServiceOrgLicense.setRecordStatus(new Byte("1"));
            tbServiceOrgLicense.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbServiceOrgLicense.setOrgId(orgLicenseData.getOrgId());
            orgLicenses.add(tbServiceOrgLicense);
        }
        orgLicenseMapper.insertLicenseList(orgLicenses);
        org.setModifiedTime(new Date());
        org.setModifierAccount(account);
        return tbServiceOrgMapper.updateByPrimaryKeySelective(org);
    }

    @ServiceLog(doAction = "保存服务机构团队信息(传入Id为修改，否则为新增)")
    @Override
    public int saveOrUpdateOrgTeamData(OrgTeamData orgTeamData,String account){
        TbServiceOrgElement serviceOrgElement = new TbServiceOrgElement();
        BeanUtils.copyProperties(orgTeamData,serviceOrgElement);

        List<OrgTeam> orgTeams = orgTeamData.getOrgTeams();
        List<TbServiceOrgTeam> orgTeamList = new ArrayList<>(8);
        for (OrgTeam team: orgTeams) {
            TbServiceOrgTeam serviceOrgTeam = new TbServiceOrgTeam();
            serviceOrgTeam.setId(UUID.randomUUID().toString().replaceAll("-",""));
            try {
                serviceOrgTeam.setConTime(DateUtils.parseDate(team.getConTime(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                logger.info("从业起止年份时间转换失败。失败原因{}", e.getMessage(), e);
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_TIME_PARSE_ERROR);
            }
            serviceOrgTeam.setCreatedTime(new Date());
            serviceOrgTeam.setCreatorAccount(account);
            serviceOrgTeam.setRecordStatus(new Byte("1"));
            orgTeamList.add(serviceOrgTeam);
        }
        TbServiceOrgTeamCriteria orgTeamCriteria = new TbServiceOrgTeamCriteria();
        orgTeamCriteria.createCriteria().andOrgIdEqualTo(orgTeamData.getOrgId());
        int i = tbServiceOrgTeamMapper.deleteByExample(orgTeamCriteria);
        logger.info("保存机构核心服务团队信息，删除历史数据{}条",i);
        int i1 = orgTeamMapper.insertTeamList(orgTeamList);
        logger.info("保存机构核心服务团队信息，添加数据{}条",i1);

        if(StringUtils.isEmpty(orgTeamData.getId())){
            serviceOrgElement.setId(UUID.randomUUID().toString().replaceAll("-",""));
            serviceOrgElement.setCreatedTime(new Date());
            serviceOrgElement.setCreatorAccount(account);
            serviceOrgElement.setRecordStatus(new Byte("1"));
            return tbServiceOrgElementMapper.insert(serviceOrgElement);
        }else{
            serviceOrgElement.setModifiedTime(new Date());
            serviceOrgElement.setModifierAccount(account);
            return tbServiceOrgElementMapper.updateByPrimaryKeySelective(serviceOrgElement);
        }
    }

    @ServiceLog(doAction = "保存/修改服务机构联系方式")
    @Override
    public int saveOrUpdateOrgContactData(OrgContactData orgContactData,String account){
        TbServiceOrgInfo tbServiceOrgInfo = new TbServiceOrgInfo();
        BeanUtils.copyProperties(orgContactData,tbServiceOrgInfo);
        tbServiceOrgInfo.setRecordStatus(new Byte("1"));
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


}
