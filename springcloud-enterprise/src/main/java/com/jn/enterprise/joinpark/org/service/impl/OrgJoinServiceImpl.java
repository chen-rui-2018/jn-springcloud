package com.jn.enterprise.joinpark.org.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.common.enums.CommonExceptionEnum;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.InviteUpgradeStatusVO;
import com.jn.enterprise.company.vo.UpgradeStatusVO;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.joinpark.org.dao.ServiceOrgMapper;
import com.jn.enterprise.joinpark.org.dao.ServiceOrgTempMapper;
import com.jn.enterprise.joinpark.org.enums.OrgTraitTypeEnum;
import com.jn.enterprise.joinpark.org.model.PreferInfoShow;
import com.jn.enterprise.joinpark.org.service.OrgJoinService;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.enums.OrgNameIsExistEnum;
import com.jn.enterprise.servicemarket.advisor.enums.OrgNameSearchTypeEnum;
import com.jn.enterprise.servicemarket.advisor.model.OrgNameIsExistParam;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.enterprise.servicemarket.org.dao.*;
import com.jn.enterprise.servicemarket.org.entity.*;
import com.jn.enterprise.servicemarket.org.enums.CertTypeEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.DateUtil;

import java.util.*;

/**
 * 加入园区-机构认证
 * @author： jiangyl
 * @date： Created on 2019/3/4 11:22
 * @version： v1.0
 * @modified By:yangph
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
    private TbServiceOrgElementMapper tbServiceOrgElementMapper;
    @Autowired
    private TbServiceOrgInfoMapper tbServiceOrgInfoMapper;
    @Autowired
    private TbServiceOrgLicenseMapper tbServiceOrgLicenseMapper;
    @Autowired
    private TbServiceOrgTeamMapper tbServiceOrgTeamMapper;
    @Autowired
    private TbServiceOrgTraitMapper tbServiceOrgTraitMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TbServicePreferMapper tbServicePreferMapper;


    /**
     * 机构认证流程id
     */
    @Value(value = "${orgProcessId}")
    private String orgProcessId;

    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    @ServiceLog(doAction = "机构认证保存/更新")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IBPSResult saveOrUpdateOrgDetail(OrgDetailParameter orgDetailParameter,String account){
        //机构id为空
        if(StringUtils.isBlank(orgDetailParameter.getOrgId())){
            //判断当前用户是否可以认证
            InviteUpgradeStatusVO joinParkStatus = companyService.getJoinParkStatus(account);
            String allowStatus="0";
            if(!StringUtils.equals(allowStatus,joinParkStatus.getCode())){
                logger.warn(joinParkStatus.getMessage());
                throw new JnSpringCloudException(CommonExceptionEnum.UPGRADE_COMMON, account + joinParkStatus.getInviteMessage());
            }
            //判断机构名称是否重复
            OrgNameIsExistParam orgNameIsExistParam=new OrgNameIsExistParam();
            orgNameIsExistParam.setSearchType(OrgNameSearchTypeEnum.SEARCH_type_ADD.getCode());
            orgNameIsExistParam.setOrgName(orgDetailParameter.getOrgName());
            orgNameIsExist(orgNameIsExistParam);
        }else{
            //判断机构id是否有效
            TbServiceOrgCriteria example=new TbServiceOrgCriteria();
            example.createCriteria().andOrgIdEqualTo(orgDetailParameter.getOrgId())
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long existNum = tbServiceOrgMapper.countByExample(example);
            if(existNum==0){
                logger.warn("当前机构id:[{}]在系统中不存在，无法修改机构信息");
                throw new JnSpringCloudException(OrgExceptionEnum.ORG_ID_IS_NOT_EXIST);
            }
            //判断机构名称是否重复
            OrgNameIsExistParam orgNameIsExistParam=new OrgNameIsExistParam();
            orgNameIsExistParam.setSearchType(OrgNameSearchTypeEnum.SEARCH_TYPE_UPDATE.getCode());
            orgNameIsExistParam.setOrgName(orgDetailParameter.getOrgName());
            orgNameIsExistParam.setOrgId(orgDetailParameter.getOrgId());
            orgNameIsExist(orgNameIsExistParam);
        }
        //只有认证通过的机构才可以修改，无论新增还是修改，都会重新发起审批流程，通过ibps把数据保存到临时表
        //封装处理基本信息
        TbServiceOrgCopy tbServiceOrgCopy = processBaseData(orgDetailParameter, account);
        //封装处理机构团队人员结构信息
        TbServiceOrgElementCopy tbServiceOrgElementCopy = processOrgElementData(orgDetailParameter, account);
        tbServiceOrgCopy.setTb_service_org_element(tbServiceOrgElementCopy);
        //封装处理机构地址信息
        TbServiceOrgInfoCopy tbServiceOrgInfoCopy = processOrgInfoData(orgDetailParameter, account);
        tbServiceOrgCopy.setTb_service_org_info(tbServiceOrgInfoCopy);
        //封装处理服务机构资质信息
        List<TbServiceOrgLicenseCopy> tbServiceOrgLicenseCopies = processOrgLicenseData(orgDetailParameter, account);
        tbServiceOrgCopy.setTb_service_org_license(tbServiceOrgLicenseCopies);
        //封装处理服务机构团队信息
        List<TbServiceOrgTeamCopy> tbServiceOrgTeamCopies = processOrgTeamData(orgDetailParameter, account);
        tbServiceOrgCopy.setTb_service_org_team(tbServiceOrgTeamCopies);
        //封装处理服务机构特性
        processOrgTraitData(orgDetailParameter, account,tbServiceOrgCopy);
        //启动机构认证审批工作流
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(orgProcessId, account, tbServiceOrgCopy);
        String okStatus="200";
        //启动工作流成功
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("机构认证信提交成功，审批流程启动成功,流程实例id为：[{}]",ibpsResult.getData());
        }else{
            logger.warn("机构认证保存/更新失败，失败原因，启动ibps工作流失败，失败详情：{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(OrgExceptionEnum.SAVE_OR_UPDATE_ORG_INFO_FAIL);
        }
        return ibpsResult;
    }

    /**
     * 封装处理服务机构特性
     * @param orgDetailParameter
     * @param account
     */
    @ServiceLog(doAction = "封装处理服务机构特性")
    private void processOrgTraitData(OrgDetailParameter orgDetailParameter, String account,TbServiceOrgCopy tbServiceOrgCopy) {
        List<TbServiceOrgTraitCopy> tb_service_org_trait=new ArrayList<>(16);
        //获取客户偏好字典表所有类型值 类型：0业务领域1行业领域2发展阶段3企业性质
        List<PreferInfoShow> preferInfoList = getPreferInfoList(Arrays.asList("1","2-"));
        List<String> orgHobbys=new ArrayList<>(16);
        if(orgDetailParameter.getIndustrySector()!=null && orgDetailParameter.getIndustrySector().length>0){
            //行业领域
            for(int i=0;i<orgDetailParameter.getIndustrySector().length;i++){
                for(PreferInfoShow preferInfoShow:preferInfoList){
                    if(StringUtils.equals(orgDetailParameter.getIndustrySector()[i],preferInfoShow.getId())){
                        orgHobbys.add(preferInfoShow.getPreValue());
                        break;
                    }
                }
                TbServiceOrgTraitCopy tbServiceOrgTraitCopy=new TbServiceOrgTraitCopy();
                //id
                tbServiceOrgTraitCopy.setId("");
                //特性状态
                tbServiceOrgTraitCopy.setTraitType(OrgTraitTypeEnum.INDUSTRY.getCode());
                //特性值
                tbServiceOrgTraitCopy.setTraitValue(orgDetailParameter.getIndustrySector()[i]);
                //状态 (0无效1有效)
                tbServiceOrgTraitCopy.setStatus("1");
                //创建时间
                tbServiceOrgTraitCopy.setCreatedTime(DateUtils.getDate(PATTERN));
                //创建人
                tbServiceOrgTraitCopy.setCreatorAccount(account);
                //是否删除
                tbServiceOrgTraitCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
                tb_service_org_trait.add(tbServiceOrgTraitCopy);
            }
        }
        if(orgDetailParameter.getDevelopmentStage()!=null && orgDetailParameter.getDevelopmentStage().length>0){
            //发展阶段
            for(int i=0;i<orgDetailParameter.getDevelopmentStage().length;i++){
                for(PreferInfoShow preferInfoShow:preferInfoList){
                    if(StringUtils.equals(orgDetailParameter.getDevelopmentStage()[i],preferInfoShow.getId())){
                        orgHobbys.add(preferInfoShow.getPreValue());
                        break;
                    }
                }
                TbServiceOrgTraitCopy tbServiceOrgTraitCopy=new TbServiceOrgTraitCopy();
                //id
                tbServiceOrgTraitCopy.setId("");
                //特性状态
                tbServiceOrgTraitCopy.setTraitType(OrgTraitTypeEnum.DEVELOP_STAGE.getCode());
                //特性值
                tbServiceOrgTraitCopy.setTraitValue(orgDetailParameter.getDevelopmentStage()[i]);
                //状态 (0无效1有效)
                tbServiceOrgTraitCopy.setStatus("1");
                //创建时间
                tbServiceOrgTraitCopy.setCreatedTime(DateUtils.getDate(PATTERN));
                //创建人
                tbServiceOrgTraitCopy.setCreatorAccount(account);
                //是否删除
                tbServiceOrgTraitCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
                tb_service_org_trait.add(tbServiceOrgTraitCopy);
            }
        }
        tbServiceOrgCopy.setOrgHobby(StringUtils.join(orgHobbys,","));
        tbServiceOrgCopy.setTb_service_org_trait(tb_service_org_trait);
    }

    /**
     * 获取客户偏好机构字典表所有值
     * @return
     */
    @ServiceLog(doAction = "获取客户偏好机构字典表所有值")
    @Override
    public  List<PreferInfoShow> getPreferInfoList(List<String> params) {
        TbServicePreferCriteria example=new TbServicePreferCriteria();
        example.createCriteria().andPreTypeIn(params)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServicePrefer> preferList = tbServicePreferMapper.selectByExample(example);
        if(preferList.isEmpty()){
            return Collections.emptyList();
        }else{
            List<PreferInfoShow> preferInfoShows=new ArrayList<>();
            for(TbServicePrefer prefer:preferList){
                PreferInfoShow preferInfoShow=new PreferInfoShow();
                BeanUtils.copyProperties(prefer, preferInfoShow);
                preferInfoShows.add(preferInfoShow);
            }
            return  preferInfoShows;
        }
    }

    /**
     * 封装处理服务机构团队信息
     * @param orgDetailParameter
     * @param account
     * @return
     */
    @ServiceLog(doAction = "封装处理服务机构团队信息")
    private List<TbServiceOrgTeamCopy> processOrgTeamData(OrgDetailParameter orgDetailParameter, String account) {
        List<TbServiceOrgTeamCopy>tb_service_org_team=new ArrayList<>();
        if(orgDetailParameter.getOrgTeams()!=null){
            List<OrgTeam> orgTeams = orgDetailParameter.getOrgTeams();
            for(OrgTeam orgTeam:orgTeams){
                TbServiceOrgTeamCopy tbServiceOrgTeamCopy =new TbServiceOrgTeamCopy();
                BeanUtils.copyProperties(orgTeam, tbServiceOrgTeamCopy);
                //id
                tbServiceOrgTeamCopy.setId("");
                //机构id
                tbServiceOrgTeamCopy.setOrgId("");
                //创建时间
                tbServiceOrgTeamCopy.setCreatedTime(DateUtils.getDate(PATTERN));
                //创建人
                tbServiceOrgTeamCopy.setCreatorAccount(account);
                //是否删除 0:已删除  1：有效
                tbServiceOrgTeamCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
                tb_service_org_team.add(tbServiceOrgTeamCopy);
            }
        }
        return tb_service_org_team;
    }

    /**
     * 封装处理服务机构资质信息
     * @param orgDetailParameter
     * @param account
     * @return
     */
    @ServiceLog(doAction = "封装处理服务机构资质信息")
    private List<TbServiceOrgLicenseCopy> processOrgLicenseData(OrgDetailParameter orgDetailParameter, String account) {
        List<TbServiceOrgLicenseCopy>tb_service_org_license=new ArrayList<>(16);
        if(orgDetailParameter.getLicenses()!=null){
            List<OrgLicense> licenses = orgDetailParameter.getLicenses();
            for(OrgLicense orgLicense:licenses){
                TbServiceOrgLicenseCopy tbServiceOrgLicenseCopy=new TbServiceOrgLicenseCopy();
                BeanUtils.copyProperties(orgLicense, tbServiceOrgLicenseCopy);
                //id
                tbServiceOrgLicenseCopy.setId("");
                //机构id
                tbServiceOrgLicenseCopy.setOrgId("");
                //处理资质图片信息
                if(StringUtils.isNotBlank(orgLicense.getFileUrl())){
                    tbServiceOrgLicenseCopy.setFileUrl(IBPSFileUtils.uploadFile2Json(account,orgLicense.getFileUrl()));
                }
                String certName="营业执照";
                if(tbServiceOrgLicenseCopy.getCertName().contains(certName)){
                    //证书类型：1：营业执照    2：执业资质  3：其他
                    tbServiceOrgLicenseCopy.setCertType(CertTypeEnum.LICENSE.getValue());
                }else{
                    tbServiceOrgLicenseCopy.setCertType(CertTypeEnum.PRACTISING_QUALIFICATION.getValue());
                }
                //创建时间
                tbServiceOrgLicenseCopy.setCreatedTime(DateUtils.getDate(PATTERN));
                //创建人
                tbServiceOrgLicenseCopy.setCreatorAccount(account);
                //是否删除 0:已删除  1：有效
                tbServiceOrgLicenseCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
                tb_service_org_license.add(tbServiceOrgLicenseCopy);
            }
        }
        return tb_service_org_license;
    }

    /**
     * 封装处理机构地址信息
     * @param orgDetailParameter
     * @param account
     * @return
     */
    @ServiceLog(doAction = "封装处理机构地址信息")
    private TbServiceOrgInfoCopy processOrgInfoData(OrgDetailParameter orgDetailParameter, String account) {
        TbServiceOrgInfoCopy tbServiceOrgInfoCopy=new TbServiceOrgInfoCopy();
        BeanUtils.copyProperties(orgDetailParameter, tbServiceOrgInfoCopy);
        //创建时间
        tbServiceOrgInfoCopy.setCreatedTime(DateUtils.getDate(PATTERN));
        //创建人
        tbServiceOrgInfoCopy.setCreatorAccount(account);
        //是否删除 0:已删除  1：有效
        tbServiceOrgInfoCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
        return tbServiceOrgInfoCopy;
    }

    /**
     * 封装处理机构团队人员结构信息
     * @param orgDetailParameter  机构认证请求入参
     * @param account           登录用户账号
     * @return
     */
    @ServiceLog(doAction = "封装处理机构团队人员结构信息")
    private TbServiceOrgElementCopy processOrgElementData(OrgDetailParameter orgDetailParameter, String account) {
        TbServiceOrgElementCopy tbServiceOrgElementCopy=new TbServiceOrgElementCopy();
        BeanUtils.copyProperties(orgDetailParameter, tbServiceOrgElementCopy);
        //id
        tbServiceOrgElementCopy.setId("");
        //机构id
        tbServiceOrgElementCopy.setOrgId("");
        //创建时间
        tbServiceOrgElementCopy.setCreatedTime(DateUtils.getDate(PATTERN));
        //创建人
        tbServiceOrgElementCopy.setCreatorAccount(account);
        //是否删除 0:已删除  1：有效
        tbServiceOrgElementCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
        return tbServiceOrgElementCopy;
    }

    /**
     * 封装处理机构基本信息
     * @param orgDetailParameter  机构认证请求入参
     * @param account           登录用户账号
     * @return
     */
    @ServiceLog(doAction = "封装处理机构基本信息")
    private TbServiceOrgCopy processBaseData(OrgDetailParameter orgDetailParameter, String account) {
        TbServiceOrgCopy tbServiceOrgCopy = new TbServiceOrgCopy();
        //基本信息处理
        BeanUtils.copyProperties(orgDetailParameter,tbServiceOrgCopy);
        //机构logo处理
        if(StringUtils.isNotBlank(tbServiceOrgCopy.getOrgLogo())){
            tbServiceOrgCopy.setOrgLogo(IBPSFileUtils.uploadFile2Json(account, tbServiceOrgCopy.getOrgLogo()));
        }
        //机构id
        tbServiceOrgCopy.setOrgId("");
        //原来的机构id
        tbServiceOrgCopy.setOriginalId(orgDetailParameter.getOrgId());
        //机构账号
        tbServiceOrgCopy.setOrgAccount(account);
        //机构浏览量
        tbServiceOrgCopy.setOrgShow(0);
        //审核状态 (0：未审核[审核中] 1：审核通过  2：审核不通过)
        tbServiceOrgCopy.setOrgStatus(ApprovalStatusEnum.NOT_APPROVED.getValue());
        //创建时间
        tbServiceOrgCopy.setCreatedTime(DateUtils.getDate(PATTERN));
        //修改时间
        tbServiceOrgCopy.setCreatorAccount(account);
        //是否删除 0:已删除   1：有效
        tbServiceOrgCopy.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue()+"");
        return tbServiceOrgCopy;
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
