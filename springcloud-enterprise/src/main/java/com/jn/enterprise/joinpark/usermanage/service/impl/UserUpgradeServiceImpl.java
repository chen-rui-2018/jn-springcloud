package com.jn.enterprise.joinpark.usermanage.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.common.config.IBPSDefIdConfig;
import com.jn.enterprise.common.enums.CommonExceptionEnum;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyStaffMapper;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.company.entity.TbServiceCompanyStaffCriteria;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.enums.UpgradeStatusEnum;
import com.jn.enterprise.company.model.Company;
import com.jn.enterprise.company.model.CompanyCheckParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.InviteUpgradeStatusVO;
import com.jn.enterprise.enums.JoinParkExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.joinpark.usermanage.model.StaffCheckParam;
import com.jn.enterprise.joinpark.usermanage.service.UserUpgradeService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.model.UserInfo;
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

    @Override
    @ServiceLog(doAction = "升级企业")
    public int changeToCompany(CompanyCheckParam companyCheckParam, String phone, String account) {
        if (companyCheckParam.getComPropertys().length == 0 || companyCheckParam.getComPropertys().length > 3) {
            logger.warn("[升级企业] 企业性质超过3条");
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.UPGRADE_COMPANY_PROPERTY_GT_THREE);
        }

        //从redis中取出短信验证码
        Result sendCodeByPhone = userExtensionClient.getSendCodeByPhone(phone);
        String code = (String)sendCodeByPhone.getData();
        if(!StringUtils.equals(code,companyCheckParam.getCheckCode())){
            logger.warn("[升级企业] 验证码有误,phone:{}", phone);
            throw new JnSpringCloudException(JoinParkExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }

        InviteUpgradeStatusVO joinParkStatus = companyService.getJoinParkStatus(account);
        if (!joinParkStatus.getCode().equals(UpgradeStatusEnum.UPGRADE_OK.getCode())) {
            logger.warn("[升级企业] {}", account + joinParkStatus.getMessage());
            throw new JnSpringCloudException(CommonExceptionEnum.UPGRADE_COMMON, account + joinParkStatus.getMessage());
        }

        // 判断企业名称是否重复
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andComNameEqualTo(companyCheckParam.getComName());
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        if(null != tbServiceCompanies && tbServiceCompanies.size() > 0){
            logger.warn("[升级企业] 企业已存在，不能再次认证。conName:{}", companyCheckParam.getComName());
            throw new JnSpringCloudException(JoinParkExceptionEnum.COMPANY_IS_EXIST);
        }

        // 封装数据
        companyCheckParam.setId("");
        companyCheckParam.setComId(UUID.randomUUID().toString().replaceAll("-", ""));
        companyCheckParam.setComAdmin(account);
        companyCheckParam.setCreatorAccount(account);
        companyCheckParam.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyCheckParam.setCreditUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyCheckParam.setCreditPoints("100");
        companyCheckParam.setCheckStatus(CompanyDataEnum.COMPANY_CHECK_STATUS_WAIT.getCode());
        companyCheckParam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getCode());

        // 处理图片格式
        companyCheckParam.setBusinessLicense(IBPSFileUtils.uploadFile2Json(account, companyCheckParam.getBusinessLicense()));
        companyCheckParam.setAvatar(IBPSFileUtils.uploadFile2Json(account, companyCheckParam.getAvatar()));

        // 处理企业性质，多个以‘,’拼接
        companyCheckParam.setComProperty(StringUtils.join(companyCheckParam.getComPropertys(),","));
        companyCheckParam.setComPropertys(null);

        // 调用IBPS启动流程
        String bpmnDefId = ibpsDefIdConfig.getUpdateCompanyInfo();
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

        // 调用修改用户扩展信息服务接口
        Integer responseNums = 0;

        // 修改用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(account);
        BeanUtils.copyProperties(staffCheckParam, userInfo);
        Result result = userExtensionClient.saveOrUpdateUserInfo(userInfo);
        if (result == null || result.getData() == null) {
            logger.warn("[升级员工] 更新用户扩展信息错误");
            return responseNums;
        }

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
        responseNums = tbServiceCompanyStaffMapper.insert(tbServiceCompanyStaff);
        return responseNums;
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
