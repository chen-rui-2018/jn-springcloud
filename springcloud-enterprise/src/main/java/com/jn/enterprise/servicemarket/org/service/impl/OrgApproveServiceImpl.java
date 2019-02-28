package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
import com.jn.enterprise.servicemarket.org.service.OrgApproveService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";
    /**
     * 机构状态 1:审核中
     */
    private final static String ORG_APPLY_IS_CHECKING = "1";

    @Override
    @ServiceLog(doAction = "查询机构审核认证列表")
    public PaginationData getOrgApplyList(OrgApplyParameter orgApplyParameter){
        List<OrgApply> orgApplyList = new ArrayList<>(8);
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
            OrgApply orgApply = new OrgApply();
            BeanUtils.copyProperties(serviceOrg,orgApply);
            if(null != serviceOrg.getCreatedTime()){
                orgApply.setCreatedTime(DateUtils.formatDate(serviceOrg.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != serviceOrg.getOrgRegisterTime()){
                orgApply.setOrgRegisterTime(DateUtils.formatDate(serviceOrg.getOrgRegisterTime(),"yyyy-MM-dd"));
            }
            orgApplyList.add(orgApply);
            accountList.add(serviceOrg.getOrgAccount());
        }
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        List<UserExtensionInfo> userExtensions = moreUserExtension.getData();
        for (OrgApply orgApply:orgApplyList) {
            for (UserExtensionInfo userExtesion:userExtensions) {
                if(StringUtils.equals(orgApply.getOrgAccount(),userExtesion.getAccount())){
                    BeanUtils.copyProperties(userExtesion,orgApply);
                }
            }
        }
        PaginationData data = new PaginationData(orgApplyList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "查询机构入驻数据")
    public OrgApplyCount getOrgCount(){
        OrgApplyCount orgApplyCount = new OrgApplyCount();
        // 入驻机构总数（已审核通过数）
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long orgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setOrgCount(orgCount+"");
        logger.info("入驻机构总数（已审核通过数）{}",orgCount);
        // 待审核机构数
        orgCriteria.createCriteria().andOrgStatusEqualTo("0").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        long waitApplyCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setWaitApplyCount(waitApplyCount+"");
        logger.info("待审核机构数{}",waitApplyCount);
        // 本月入驻机构数
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andCheckTimeBetween(cale.getTime(),new Date());
        long monthJoinOrgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setMonthJoinOrgCount(monthJoinOrgCount+"");
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
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andCheckTimeBetween(startCalendar.getTime(),endCalendar.getTime());
        long lastMonthJoinOrgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setLastMonthJoinOrgCount(lastMonthJoinOrgCount+"");
        logger.info("上月入驻机构数{}",lastMonthJoinOrgCount);
        //本月入驻环比
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(monthJoinOrgCount / (double) lastMonthJoinOrgCount * 100);
        orgApplyCount.setMonthJoinOrgRatio(format);
        return orgApplyCount;
    }

    @Override
    @ServiceLog(doAction = "查询机构申请详细信息")
    public OrgApplyDetail getOrgApplyDetail(String orgId){
        OrgApplyDetail orgApplyDetail = orgApproveMapper.getOrgApplyDetailById(orgId);

        TbServiceOrgLicenseCriteria licenseCriteria = new TbServiceOrgLicenseCriteria();
        licenseCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceOrgLicense> orgLicenses = tbServiceOrgLicenseMapper.selectByExample(licenseCriteria);

        List<OrgLicense> licenses = new ArrayList<>(8);
        for (TbServiceOrgLicense tbServiceOrgLicense:orgLicenses) {
            OrgLicense orgLicense = new OrgLicense();
            BeanUtils.copyProperties(tbServiceOrgLicense,orgLicense);
            licenses.add(orgLicense);
        }
        orgApplyDetail.setOrgLicenses(licenses);
        TbServiceOrgTeamCriteria teamCriteria = new TbServiceOrgTeamCriteria();
        teamCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceOrgTeam> orgTeamList = tbServiceOrgTeamMapper.selectByExample(teamCriteria);
        List<OrgTeam> teams = new ArrayList<>(8);
        for (TbServiceOrgTeam tbServiceOrgTeam:orgTeamList ) {
            OrgTeam orgTeam = new OrgTeam();
            BeanUtils.copyProperties(tbServiceOrgTeam,orgTeam);
            teams.add(orgTeam);
        }
        orgApplyDetail.setOrgTeams(teams);
        TbServiceOrgTraitCriteria traitCriteria = new TbServiceOrgTraitCriteria();
        traitCriteria.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceOrgTrait> orgTraits = tbServiceOrgTraitMapper.selectByExample(traitCriteria);
        List<OrgTrait> traits1 = new ArrayList<>(8);
        for (TbServiceOrgTrait tbServiceOrgTrait:orgTraits) {
            OrgTrait trait = new OrgTrait();
            BeanUtils.copyProperties(tbServiceOrgTrait,trait);
            traits1.add(trait);
        }
        orgApplyDetail.setOrgTraits(traits1);
        //TODO 对接审核流接口信息  jiangyl
        return orgApplyDetail;
    }


    @Override
    @ServiceLog(doAction = "机构申请审核")
    public Boolean checkOrgApply(OrgApplyCheckData orgApplyCheckData){
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

        return false;
    }

}
