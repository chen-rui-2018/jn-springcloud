package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
import com.jn.enterprise.servicemarket.org.service.OrgApproveService;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyCountVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyDetailVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 服务机构认证审核接口实现类
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:45
 * @version： v1.0
 * @modified By:
 */
@Service
public class OrgApproveServiceImpl implements OrgApproveService {
    private static Logger logger = LoggerFactory.getLogger(OrgApproveServiceImpl.class);

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private OrgApproveMapper orgApproveMapper;
    @Autowired
    private TbServiceOrgTeamMapper tbServiceOrgTeamMapper;
    @Autowired
    private TbServiceOrgTraitMapper tbServiceOrgTraitMapper;
    @Autowired
    private TbServiceOrgLicenseMapper tbServiceOrgLicenseMapper;
    @Autowired
    private TbServiceOrgInfoMapper tbServiceOrgInfoMapper;
    @Autowired
    private TbServiceOrgElementMapper tbServiceOrgElementMapper;

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";
    /**
     * 机构状态 0:审核中
     */
    private final static String ORG_APPLY_IS_CHECKING = "0";

    @Override
    @ServiceLog(doAction = "查询机构审核认证列表")
    public PaginationData< List<OrgApplyVo>> getOrgApplyList(OrgApplyParameter orgApplyParameter){
        List<OrgApplyVo> orgApplyVoList = new ArrayList<>(8);
        Page<Object> objects = PageHelper.startPage(orgApplyParameter.getPage(), orgApplyParameter.getRows() == 0 ? 15 : orgApplyParameter.getRows());
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        TbServiceOrgCriteria.Criteria criteria = orgCriteria.createCriteria();
        if(StringUtils.isNotEmpty(orgApplyParameter.getOrgName())){
            criteria.andOrgNameLike("%"+orgApplyParameter.getOrgName()+"%");
        }
        if(StringUtils.isNotEmpty(orgApplyParameter.getOrgStatus())){
            criteria.andOrgStatusEqualTo(orgApplyParameter.getOrgStatus());
        }
        List<TbServiceOrg> tbServiceOrgs = tbServiceOrgMapper.selectByExample(orgCriteria);
        List<String> accountList = new ArrayList<>();
        for (TbServiceOrg serviceOrg:tbServiceOrgs) {
            OrgApplyVo orgApplyVo = new OrgApplyVo();
            BeanUtils.copyProperties(serviceOrg, orgApplyVo);
            if(null != serviceOrg.getCreatedTime()){
                orgApplyVo.setCreatedTime(DateUtils.formatDate(serviceOrg.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != serviceOrg.getOrgRegisterTime()){
                orgApplyVo.setOrgRegisterTime(DateUtils.formatDate(serviceOrg.getOrgRegisterTime(),"yyyy-MM-dd"));
            }
            orgApplyVoList.add(orgApplyVo);
            accountList.add(serviceOrg.getOrgAccount());
        }
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        List<UserExtensionInfo> userExtensions = moreUserExtension.getData();
        for (OrgApplyVo orgApplyVo : orgApplyVoList) {
            for (UserExtensionInfo userExtesion:userExtensions) {
                if(StringUtils.equals(orgApplyVo.getOrgAccount(),userExtesion.getAccount())){
                    BeanUtils.copyProperties(userExtesion, orgApplyVo);
                }
            }
        }
        PaginationData<List<OrgApplyVo>> data = new PaginationData<>(orgApplyVoList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "查询机构入驻数据")
    public OrgApplyCountVo getOrgCount(){
        OrgApplyCountVo orgApplyCountVo = new OrgApplyCountVo();
        // 入驻机构总数（已审核通过数）
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long orgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCountVo.setOrgCount(orgCount+"");
        logger.info("入驻机构总数（已审核通过数）{}",orgCount);
        // 待审核机构数
        TbServiceOrgCriteria orgCriteria1 = new TbServiceOrgCriteria();
        orgCriteria1.createCriteria().andOrgStatusEqualTo("0").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long waitApplyCount = tbServiceOrgMapper.countByExample(orgCriteria1);
        orgApplyCountVo.setWaitApplyCount(waitApplyCount+"");
        logger.info("待审核机构数{}",waitApplyCount);
        // 本月入驻机构数
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        TbServiceOrgCriteria orgCriteria2 = new TbServiceOrgCriteria();
        orgCriteria2.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andCheckTimeBetween(cale.getTime(),new Date());
        long monthJoinOrgCount = tbServiceOrgMapper.countByExample(orgCriteria2);
        orgApplyCountVo.setMonthJoinOrgCount(monthJoinOrgCount+"");
        logger.info("本月入驻机构数{}",monthJoinOrgCount);
        //上月入驻机构数
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, -1);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.MONTH, -1);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        endCalendar.set(Calendar.HOUR_OF_DAY, endCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        endCalendar.set(Calendar.MINUTE, endCalendar.getActualMaximum(Calendar.MINUTE));
        endCalendar.set(Calendar.SECOND, endCalendar.getActualMaximum(Calendar.SECOND));
        endCalendar.set(Calendar.MILLISECOND, endCalendar.getActualMaximum(Calendar.MILLISECOND));
        TbServiceOrgCriteria orgCriteria3 = new TbServiceOrgCriteria();
        orgCriteria3.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andCheckTimeBetween(startCalendar.getTime(),endCalendar.getTime());
        long lastMonthJoinOrgCount = tbServiceOrgMapper.countByExample(orgCriteria3);
        orgApplyCountVo.setLastMonthJoinOrgCount(lastMonthJoinOrgCount+"");
        logger.info("上月入驻机构数{}",lastMonthJoinOrgCount);
        //本月入驻环比
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(monthJoinOrgCount / (double) lastMonthJoinOrgCount * 100);
        orgApplyCountVo.setMonthJoinOrgRatio(format);
        return orgApplyCountVo;
    }

    @Override
    @ServiceLog(doAction = "查询机构申请详细信息")
    public OrgApplyDetailVo getOrgApplyDetail(String orgId){
        OrgApplyDetailVo orgApplyDetailVo = orgApproveMapper.getOrgApplyDetailById(orgId);

        TbServiceOrgLicenseCriteria licenseCriteria = new TbServiceOrgLicenseCriteria();
        licenseCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceOrgLicense> orgLicenses = tbServiceOrgLicenseMapper.selectByExample(licenseCriteria);

        List<OrgLicense> licenses = new ArrayList<>(8);
        for (TbServiceOrgLicense tbServiceOrgLicense:orgLicenses) {
            OrgLicense orgLicense = new OrgLicense();
            BeanUtils.copyProperties(tbServiceOrgLicense,orgLicense);
            licenses.add(orgLicense);
        }
        orgApplyDetailVo.setOrgLicenses(licenses);
        TbServiceOrgTeamCriteria teamCriteria = new TbServiceOrgTeamCriteria();
        teamCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceOrgTeam> orgTeamList = tbServiceOrgTeamMapper.selectByExample(teamCriteria);
        List<OrgTeam> teams = new ArrayList<>(8);
        for (TbServiceOrgTeam tbServiceOrgTeam:orgTeamList ) {
            OrgTeam orgTeam = new OrgTeam();
            BeanUtils.copyProperties(tbServiceOrgTeam,orgTeam);
            teams.add(orgTeam);
        }
        orgApplyDetailVo.setOrgTeams(teams);
        TbServiceOrgTraitCriteria traitCriteria = new TbServiceOrgTraitCriteria();
        traitCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceOrgTrait> orgTraits = tbServiceOrgTraitMapper.selectByExample(traitCriteria);
        List<OrgTrait> traits1 = new ArrayList<>(8);
        for (TbServiceOrgTrait tbServiceOrgTrait:orgTraits) {
            OrgTrait trait = new OrgTrait();
            BeanUtils.copyProperties(tbServiceOrgTrait,trait);
            traits1.add(trait);
        }
        orgApplyDetailVo.setOrgTraits(traits1);
        //TODO 对接审核流接口信息  jiangyl
        return orgApplyDetailVo;
    }


    @Override
    @ServiceLog(doAction = "机构申请审核")
    public Boolean checkOrgApply(OrgApplyCheckData orgApplyCheckData, User user){
        String orgId = orgApplyCheckData.getOrgId();
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgIdEqualTo(orgId);
        List<TbServiceOrg> tbServiceOrgs = tbServiceOrgMapper.selectByExample(orgCriteria);
        if(null==tbServiceOrgs||tbServiceOrgs.size()!=1){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_DATA_IS_ERROR);
        }
        if(!StringUtils.equals(tbServiceOrgs.get(0).getOrgStatus(),ORG_APPLY_IS_CHECKING)){
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_DATA_STATUS_IS_NOT_CHECKING);
        }
        //TODO 对接工作流返回状态，校验审核完修改机构状态。jiangyl
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
            tbServiceOrgTeamCopies.add(tbServiceOrgLicenseCopy);
        }
        if (tbServiceOrgTeams.size() == 0){
            tbServiceOrgTeamCopies.clear();
        }
        tbServiceOrgCopy.setTb_service_org_team(tbServiceOrgTeamCopies);


        //TODO 对接工作流返回状态，校验审核完修改机构状态。jiangyl
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
        map.add("bpmnDefId","572074916870881280");
        String gson=new Gson().toJson(tbServiceOrgCopy);
        map.add("data", gson);
        JSONObject request = CallOtherSwaggerUtils.request(user.getAccount(), "/api/webapi/bpmService/start", HttpMethod.POST, map);
        //return new Result(request);
        logger.info("启动流程的date数据：==========>>>>{}",gson);
        logger.info("启动流程返回结果：========>>>>{}",request);
        return false;
    }

}
