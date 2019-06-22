package com.jn.enterprise.joinpark.org.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.common.enums.CommonExceptionEnum;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.InviteUpgradeStatusVO;
import com.jn.enterprise.company.vo.UpgradeStatusVO;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.joinpark.org.dao.ServiceOrgMapper;
import com.jn.enterprise.joinpark.org.dao.ServiceOrgTempMapper;
import com.jn.enterprise.joinpark.org.service.OrgJoinService;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.enums.OrgNameIsExistEnum;
import com.jn.enterprise.servicemarket.advisor.enums.OrgNameSearchTypeEnum;
import com.jn.enterprise.servicemarket.advisor.model.OrgNameIsExistParam;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgTempMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTempCriteria;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    @Autowired
    private TbServiceOrgTempMapper tbServiceOrgTempMapper;

    @Autowired
    private ServiceOrgMapper serviceOrgMapper;

    @Autowired
    private ServiceOrgTempMapper serviceOrgTempMapper;

    @Autowired
    private CompanyService companyService;

    @ServiceLog(doAction = "机构认证保存/更新")
    @Override
    public int saveOrUpdateOrgDetail(OrgDetailParameter orgDetailParameter,String account){
        //判断当前用户是否可以认证
        InviteUpgradeStatusVO joinParkStatus = companyService.getJoinParkStatus(account);
        String allowStatus="0";
        if(!StringUtils.equals(allowStatus,joinParkStatus.getCode())){
            logger.warn(joinParkStatus.getMessage());
            throw new JnSpringCloudException(CommonExceptionEnum.UPGRADE_COMMON, account + joinParkStatus.getInviteMessage());
        }

        //机构id为空
        if(StringUtils.isBlank(orgDetailParameter.getOrgId())){
            //校验当前用户是否已认证机构认证
            checkLoginAccountIsExist(account);
        }
        OrgBasicData orgBasicData = new OrgBasicData();
        //机构logo处理
        if(StringUtils.isNotBlank(orgDetailParameter.getOrgLogo())){
            IBPSFileUtils.uploadFile2Json(account,orgDetailParameter.getOrgLogo());
        }
        //基本信息处理
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
        //处理资质图片信息
        if(orgDetailParameter.getLicenses()!=null){
            List<OrgLicense> licenses = orgDetailParameter.getLicenses();
            for(OrgLicense orgLicense:licenses){
                if(StringUtils.isNotBlank(orgLicense.getFileUrl())){
                    orgLicense.setFileUrl(IBPSFileUtils.uploadFile2Json(account,orgLicense.getFileUrl()));
                }
            }
        }
        orgLicenseData.setLicenses(orgDetailParameter.getLicenses());
        int i1 = orgService.saveOrgLicenseData(orgLicenseData, account);
        logger.info("保存服务机构资质信息，响应条数{}",i1);
        OrgTeamData orgTeamData = new OrgTeamData();
        BeanUtils.copyProperties(orgDetailParameter,orgTeamData);
        orgTeamData.setOrgId(orgId);
        orgTeamData.setOrgTeams(orgDetailParameter.getOrgTeams());
        int i2 = orgService.saveOrUpdateOrgTeamData(orgTeamData, account);
        logger.info("保存服务机构团队信息，响应条数{}",i2);
        OrgContactData orgContactData = new OrgContactData();
        BeanUtils.copyProperties(orgDetailParameter,orgContactData);
        orgContactData.setOrgId(orgId);
        int i3 = orgService.saveOrUpdateOrgContactData(orgContactData, account);
        logger.info("保存服务机构联系信息，响应条数{}",i3);

        return 1;
    }

    /**
     * 校验当前用户是否已认证机构认证
     * @param account
     */
    @ServiceLog(doAction = "校验当前用户是否已认证机构认证")
    private void checkLoginAccountIsExist(String account) {
        TbServiceOrgTempCriteria exampleTemp=new TbServiceOrgTempCriteria();
        exampleTemp.createCriteria().andOrgAccountEqualTo(account)
                .andOrgStatusIn(Arrays.asList(ApprovalStatusEnum.NOT_APPROVED.getValue(),ApprovalStatusEnum.APPROVAL.getValue()))
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbServiceOrgTempMapper.countByExample(exampleTemp);
        if(existNum==0){
            TbServiceOrgCriteria example=new TbServiceOrgCriteria();
            example.createCriteria().andOrgAccountEqualTo(account)
                    .andOrgStatusIn(Arrays.asList(ApprovalStatusEnum.NOT_APPROVED.getValue(),ApprovalStatusEnum.APPROVAL.getValue()))
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            existNum=tbServiceOrgMapper.countByExample(example);
        }
        if(existNum>0){
            logger.warn("当前用户[{}]信息已存在，请不要重复进行机构认证",account);
            throw new JnSpringCloudException(OrgExceptionEnum.ORG_INFO_HAS_EXIST);
        }
    }

    /**
     * 判断机构名称是否已存在
     * @param orgParam
     * @return
     */
    @ServiceLog(doAction = "判断机构名称是否已存在")
    @Override
    public String orgNameIsExist(OrgNameIsExistParam orgParam) {
        //查询类型
        List<String> searchTypes = Arrays.asList(OrgNameSearchTypeEnum.SEARCH_type_ADD.getCode(), OrgNameSearchTypeEnum.SEARCH_TYPE_UPDATE.getCode());
        if(!searchTypes.contains(orgParam.getSearchType())){
            logger.warn("判断机构名称是否已存在异常，异常原因：查询类型：[{}]系统中不存在",orgParam.getSearchType());
            throw new JnSpringCloudException(OrgExceptionEnum.SEARCH_TYPE_NOT_ALLOW);
        }
        //正式表
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        //临时表
        TbServiceOrgTempCriteria exampleTemp=new TbServiceOrgTempCriteria();
        if(StringUtils.equals(OrgNameSearchTypeEnum.SEARCH_type_ADD.getCode(),orgParam.getSearchType())){
            //审批状态(0：未审核[审核中] 1：审核通过  2：审核不通过)
            //正式表
            example.createCriteria().andOrgNameEqualTo(orgParam.getOrgName())
                    .andOrgStatusEqualTo("1")
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            //临时表 待审批，审批通过的状态对应机构名称都查询
            exampleTemp.createCriteria().andOrgNameEqualTo(orgParam.getOrgName())
                    .andOrgStatusIn(Arrays.asList("0","1"))
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long existNum = tbServiceOrgMapper.countByExample(example);
            return existNum>0? OrgNameIsExistEnum.ORG_NAME_EXIST.getCode():OrgNameIsExistEnum.ORG_NAME_NOT_EXIST.getCode();
        }else if(StringUtils.equals(OrgNameSearchTypeEnum.SEARCH_TYPE_UPDATE.getCode(), orgParam.getSearchType())){
            //机构id不能为空
            if(StringUtils.isBlank(orgParam.getOrgId())){
                logger.warn("判断机构名称是否已存在异常，异常原因：修改页面，机构id为空");
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_ID_IS_NOT_NULL);
            }
            //机构id是否存在修改页面只需判断正式表
            example.createCriteria().andOrgIdEqualTo(orgParam.getOrgId()).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long existNum = tbServiceOrgMapper.countByExample(example);
            if(existNum==0){
                logger.warn("判断机构名称是否已存在异常，异常原因：机构id在系统中不存在");
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_ID_IS_NOT_EXIST);
            }
            existNum= serviceOrgMapper.orgNameIsExist(orgParam.getOrgId(), orgParam.getOrgName());
            if(existNum==0){
                existNum= serviceOrgTempMapper.orgNameIsExist(orgParam.getOrgId(), orgParam.getOrgName());
            }
            return existNum>0?OrgNameIsExistEnum.ORG_NAME_EXIST.getCode():OrgNameIsExistEnum.ORG_NAME_NOT_EXIST.getCode();

        }else {
            return "";
        }
    }

}
