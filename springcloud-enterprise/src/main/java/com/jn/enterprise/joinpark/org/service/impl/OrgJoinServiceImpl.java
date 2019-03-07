package com.jn.enterprise.joinpark.org.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.joinpark.org.service.OrgJoinService;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 加入园区-机构认证
 * @author： jiangyl
 * @date： Created on 2019/3/4 11:22
 * @version： v1.0
 * @modified By:
 */
@Service
public class OrgJoinServiceImpl implements OrgJoinService {
    private static Logger logger = LoggerFactory.getLogger(OrgJoinServiceImpl.class);

    @Autowired
    private OrgService orgService;

    @ServiceLog(doAction = "机构认证保存/更新")
    @Override
    public int saveOrUpdateOrgDetail(OrgDetailParameter orgDetailParameter,String account){
        OrgBasicData orgBasicData = new OrgBasicData();
        BeanUtils.copyProperties(orgDetailParameter,orgBasicData);
        String orgId = orgService.saveOrUpdateOrgBasicData(orgBasicData, account);
        logger.info("保存服务机构基本信息，响应机构ID ===>{}",orgId);
        if(StringUtils.isEmpty(orgId)){
            logger.error("保存服务机构基本信息错误，");
            throw new JnSpringCloudException(OrgExceptionEnum.SAVE_ORG_BASIC_DATA_ERROR);
        }
        orgDetailParameter.setOrgId(orgId);
        OrgLicenseData orgLicenseData = new OrgLicenseData();
        orgLicenseData.setBusinessType(orgDetailParameter.getBusinessType());
        orgLicenseData.setOrgId(orgDetailParameter.getOrgId());
        orgLicenseData.setLicenses(orgDetailParameter.getLicenses());
        int i1 = orgService.saveOrgLicenseData(orgLicenseData, account);
        logger.info("保存服务机构资质信息，响应条数{}",i1);
        OrgTeamData orgTeamData = new OrgTeamData();
        BeanUtils.copyProperties(orgDetailParameter,orgTeamData);
        orgTeamData.setOrgTeams(orgDetailParameter.getOrgTeams());
        int i2 = orgService.saveOrUpdateOrgTeamData(orgTeamData, account);
        logger.info("保存服务机构团队信息，响应条数{}",i2);
        OrgContactData orgContactData = new OrgContactData();
        orgContactData.setOrgId(orgId);
        int i3 = orgService.saveOrUpdateOrgContactData(orgContactData, account);
        logger.info("保存服务机构联系信息，响应条数{}",i3);
        return 1;
    }

}
