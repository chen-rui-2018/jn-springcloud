package com.jn.enterprise.joinpark.usermanage.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.common.config.IBPSDefIdConfig;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyStaffMapper;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.company.entity.TbServiceCompanyStaffCriteria;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.Company;
import com.jn.enterprise.company.model.CompanyCheckParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.enums.JoinParkExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.joinpark.usermanage.model.StaffCheckParam;
import com.jn.enterprise.joinpark.usermanage.service.UserUpgradeService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/5 11:56
 * @version： v1.0
 * @modified By:huxw
 */
@Service
public class UserUpgradeServiceImpl implements UserUpgradeService {

    private static Logger logger = LoggerFactory.getLogger(UserUpgradeServiceImpl.class);

    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;
    @Autowired
    private TbServiceCompanyStaffMapper tbServiceCompanyStaffMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private IBPSDefIdConfig ibpsDefIdConfig;

    /**
     * 企业审批状态 0:审核中 -1:无效
     */
    private final static String COMPANY_APPLY_IS_CHECKING = "0";

    @Override
    @ServiceLog(doAction = "升级企业")
    public int changeToCompany(CompanyCheckParam companyCheckParam, String phone, String account) {
        //从redis中取出短信验证码
        Result sendCodeByPhone = userExtensionClient.getSendCodeByPhone(phone);
        String code = (String)sendCodeByPhone.getData();
        if(!StringUtils.equals(code,companyCheckParam.getCheckCode())){
            logger.warn("[升级企业] 验证码有误,phone:{}", phone);
            throw new JnSpringCloudException(JoinParkExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }

        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andComNameEqualTo(companyCheckParam.getComName());
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        if(null != tbServiceCompanies && tbServiceCompanies.size() > 0){
            logger.warn("[升级企业] 企业已存在，不能再次认证。conName:{}", companyCheckParam.getComName());
            throw new JnSpringCloudException(JoinParkExceptionEnum.COMPANY_IS_EXIST);
        }

        // 判断用户已是企业员工或企业管理员
        UserExtensionInfo userExtensionInfo = getUserExtensionByAccount(account);
        if (StringUtils.isNotBlank(userExtensionInfo.getCompanyCode())) {
            logger.warn("[升级企业] 用户已是企业员工或企业管理员，account：{}", account);
            throw new JnSpringCloudException(JoinParkExceptionEnum.USER_IS_COMPANY_EXIST);
        }

        // 判断用户是否正在升级员工
        TbServiceCompanyStaffCriteria example = new TbServiceCompanyStaffCriteria();
        TbServiceCompanyStaffCriteria inviteExample = new TbServiceCompanyStaffCriteria();
        TbServiceCompanyStaffCriteria.Criteria criteria = inviteExample.createCriteria();
        example.createCriteria().andCheckStatusEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andAccountEqualTo(account);
        criteria.andInviteStatusEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_SEND.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andAccountEqualTo(account);
        example.or(criteria);
        List<TbServiceCompanyStaff> staffList = tbServiceCompanyStaffMapper.selectByExample(example);
        if (staffList != null && !staffList.isEmpty()) {
            logger.warn("[升级企业] {}账号已收到企业邀请或已升级员工，请勿执行此操作", account);
            throw new JnSpringCloudException(JoinParkExceptionEnum.USER_UPGRADE_STAFF_READY);
        }

        // 封装数据
        companyCheckParam.setId("");
        companyCheckParam.setComAdmin(account);
        companyCheckParam.setCreatorAccount(account);
        companyCheckParam.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyCheckParam.setCreditUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyCheckParam.setCreditPoints("100");
        companyCheckParam.setCheckStatus(COMPANY_APPLY_IS_CHECKING);
        companyCheckParam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getCode());

        // 处理图片格式
        companyCheckParam.setBusinessLicense(IBPSFileUtils.uploadFile2Json(account, companyCheckParam.getBusinessLicense()));
        companyCheckParam.setAvatar(IBPSFileUtils.uploadFile2Json(account, companyCheckParam.getAvatar()));

        // 调用IBPS启动流程
        String bpmnDefId = ibpsDefIdConfig.getUpgradeCompany();
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(bpmnDefId, account, companyCheckParam);

        if (ibpsResult == null || !ibpsResult.getState().equals("200")) {
            logger.warn("[升级企业] 启动ibps流程出错，错误信息：{}" + ibpsResult == null ? "" : ibpsResult.getMessage());
            throw new JnSpringCloudException(JoinParkExceptionEnum.UPGRADE_SUBMIT_IBPS_ERROR);
        }
        logger.info("[升级企业] " + ibpsResult.getMessage());
        return 1;
    }

    @Override
    @ServiceLog(doAction = "升级员工")
    public int changeToStaff(StaffCheckParam staffCheckParam, String phone, String account){
        String code = (String)userExtensionClient.getSendCodeByPhone(phone).getData();
        if(!StringUtils.equals(code,staffCheckParam.getCheckCode())){
            //验证码有误
            throw new JnSpringCloudException(JoinParkExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }

        // 判断账号是否是企业员工
        TbServiceCompanyStaffCriteria companyStaffCriteria = new TbServiceCompanyStaffCriteria();
        companyStaffCriteria.createCriteria().andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andAccountEqualTo(account);
        List<TbServiceCompanyStaff> tbServiceCompanyStaffs = tbServiceCompanyStaffMapper.selectByExample(companyStaffCriteria);
        if(null !=tbServiceCompanyStaffs && tbServiceCompanyStaffs.size()>0){
            throw new JnSpringCloudException(JoinParkExceptionEnum.USER_IS_COMPANY_EXIST);
        }

        // 判断是否正在升级企业
        TbServiceCompanyCriteria example = new TbServiceCompanyCriteria();
        example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andComAdminEqualTo(account)
                .andCheckStatusNotEqualTo(CompanyDataEnum.COMPANY_CHECK_STATUS_NOT_PASS.getCode());
        List<TbServiceCompany> companyList = tbServiceCompanyMapper.selectByExample(example);
        if (companyList != null && !companyList.isEmpty()) {
            logger.warn("[升级员工] {}账号已升级企业，请勿执行此操作", account);
            throw new JnSpringCloudException(JoinParkExceptionEnum.USER_UPGRADE_COMPANY_READY);
        }

        // 判断企业是否存在
        companyService.getCompanyDetailByAccountOrId(staffCheckParam.getComId());

        // 封装数据
        TbServiceCompanyStaff tbServiceCompanyStaff = new TbServiceCompanyStaff();
        tbServiceCompanyStaff.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tbServiceCompanyStaff.setComName(staffCheckParam.getComName());
        tbServiceCompanyStaff.setComId(staffCheckParam.getComId());
        tbServiceCompanyStaff.setAccount(account);
        tbServiceCompanyStaff.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());
        tbServiceCompanyStaff.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_AGREE.getCode());
        tbServiceCompanyStaff.setJoinPattern(CompanyDataEnum.COMPANY_STAFF_JOIN_PATTERN_UPGRADE.getCode());
        tbServiceCompanyStaff.setInviterAccount(account);
        tbServiceCompanyStaff.setInviteTime(new Date());
        tbServiceCompanyStaff.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        int insert = tbServiceCompanyStaffMapper.insert(tbServiceCompanyStaff);
        return insert;
    }

    @Override
    @ServiceLog(doAction = "查询公司列表")
    public List<Company> selectCompany(String comName){
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andComNameLike("%"+comName+"%").andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode());
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        List<Company> companyList = new ArrayList<>(8);
        for (TbServiceCompany serviceCompany: tbServiceCompanies) {
            Company company = new Company();
            BeanUtils.copyProperties(serviceCompany, company);

            // 处理图片格式
            company.setAvatar(IBPSFileUtils.getFilePath(company.getAvatar()));
            companyList.add(company);
        }
        return companyList;
    }

    /**
     * 根据账号获取账号信息
     * @param account
     * @return
     */
    private UserExtensionInfo getUserExtensionByAccount(String account) {
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if (userExtension == null || userExtension.getData() == null) {
            logger.warn("[升级企业] 根据账号获取用户失败，account：{}", account);
            throw new JnSpringCloudException(CompanyExceptionEnum.GET_USER_EXTENSION_INFO_ERROR);
        }
        return userExtension.getData();
    }

}