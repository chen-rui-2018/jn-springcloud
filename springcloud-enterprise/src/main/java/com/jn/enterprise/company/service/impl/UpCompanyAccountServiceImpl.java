package com.jn.enterprise.company.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyModifyMapper;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.company.entity.TbServiceCompanyModify;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.UpCompanyAccountService;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.pay.model.PayAccountBookCreateParam;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.vo.SysUserRoleVO;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.enums.HomeRoleEnum;
import com.jn.user.model.UserCompanyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 升级企业账号服务层实现
 * @author： shaobao
 * @date： Created on 2019/5/28 19:24
 * @version： v1.0
 * @modified By: huxw
 * @updateDate 2019-6-27 16:59:22
 **/
@Service
public class UpCompanyAccountServiceImpl implements UpCompanyAccountService {

    // 日志
    private static Logger logger = LoggerFactory.getLogger(UpCompanyAccountServiceImpl.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TbServiceCompanyModifyMapper tbServiceCompanyModifyMapper;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 升级/编辑企业信息后置脚本
     * @param serviceCompany
     */
    @Override
    @ServiceLog(doAction = "升级/编辑企业信息后置脚本")
    @Transactional(rollbackFor = Exception.class)
    public void setComApplicantToManager(ServiceCompany serviceCompany) {
        //1.获取企业申请人
        String comAdmin = serviceCompany.getComAdmin();
        //获取企业id
        String companyId = serviceCompany.getComId();
        //获取企业名称
        String comName = serviceCompany.getComName();
        boolean companyIsAdd = isAdd(companyId);
        if (StringUtils.isNotBlank(comAdmin)) {
            Date curDate = new Date();
            serviceCompany.setCheckTime(DateUtils.formatDate(curDate, "yyyy-MM-dd HH:mm:ss"));
            int isSuccess = companyService.saveOrUpdateCompanyInfo(serviceCompany);
            if (isSuccess == 1) {
                Result<SysRole> result = systemClient.getRoleByName(CompanyDataEnum.COMPANY_ADMIN.getCode());
                Result<SysRole> normalResult = systemClient.getRoleByName(HomeRoleEnum.NORMAL_USER.getCode());
                if (result == null || result.getData() == null || normalResult == null || normalResult.getData() == null) {
                    logger.warn("[企业后置脚本] 根据角色名称获取角色信息失败");
                    throw new JnSpringCloudException(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR);
                }
                logger.info("[企业后置脚本] 调用系统服务 根据角色名称获取角色信息 接口 返回结果:{}", result);

                String roleId = result.getData().getId();
                String normalRoleId = normalResult.getData().getId();

                //2.为用户赋权,增加企业管理员角色，删除普通用户
                SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();
                User user = new User();
                user.setAccount(comAdmin);

                Set<String> addRoleSet = new HashSet<String>();
                Set<String> removeRoleSet = new HashSet<String>();
                addRoleSet.add(roleId);
                removeRoleSet.add(normalRoleId);
                sysUserRoleVO.setUser(user);
                sysUserRoleVO.setAddRoleId(addRoleSet);
                sysUserRoleVO.setDeleRoleIds(removeRoleSet);

                Result<Boolean> booleanResult = systemClient.updateUserRole(sysUserRoleVO);
                if (booleanResult == null || !booleanResult.getData()) {
                    logger.warn("[企业后置脚本] 修改用户角色失败，用户账号:{}", comAdmin);
                    throw new JnSpringCloudException(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR);
                }
                logger.info("[企业后置脚本] 调用系统服务 修改用户角色 接口 用户账号:{},角色id:{}", comAdmin, roleId);

                //3.更新用户企业信息
                UserCompanyInfo userCompanyInfo = new UserCompanyInfo();
                List<String> accountList = new ArrayList<String>(16);
                accountList.add(comAdmin);
                userCompanyInfo.setAccountList(accountList);
                userCompanyInfo.setCompanyCode(companyId);
                userCompanyInfo.setCompanyName(comName);
                Result userExtension = userExtensionClient.updateCompanyInfo(userCompanyInfo);
                if (userExtension == null || userExtension.getData() == null) {
                    logger.warn("[企业后置脚本] 修改用户所属企业失败 用户账号:{}", comAdmin);
                    throw new JnSpringCloudException(CompanyExceptionEnum.CALL_USER_SERVICE_ERROR);
                }
                logger.info("[企业后置脚本] 调用用户服务 修改用户所属企业 接口 用户账号:{}", comAdmin);

                TbServiceCompanyModify companyModify = new TbServiceCompanyModify();
                companyModify.setId(serviceCompany.getId());
                companyModify.setCheckTime(curDate);
                companyModify.setCheckStatus(CompanyDataEnum.COMPANY_CHECK_STATUS_PASS.getCode());
                companyModify.setRecordStatus(RecordStatusEnum.DELETE.getValue());
                int i = tbServiceCompanyModifyMapper.updateByPrimaryKeySelective(companyModify);
                if (i != 1) {
                    logger.warn("[企业后置脚本] 将临时表企业数据置为无效失败");
                    throw new JnSpringCloudException(CompanyExceptionEnum.DELETE_COMPANY_TEMP_ERROR);
                }
                logger.info("[企业后置脚本] 已成功将临时表企业数据置为无效");

                // 只有新增时才创建账本
                if (companyIsAdd) {
                    logger.info("[企业后置脚本] 新增企业调度创建企业账本接口");
                    // 4.创建企业的账本信息-延迟调度
                    PayAccountBookCreateParam payAccountBookCreateParam = new PayAccountBookCreateParam();
                    payAccountBookCreateParam.setComAdmin(comAdmin);
                    payAccountBookCreateParam.setEnterId(companyId);

                    Delay delay = new Delay();
                    delay.setServiceId(applicationName);
                    delay.setServiceUrl("/api/payment/payAccount/createPayAccountBook");
                    delay.setTtl("30");
                    delay.setDataString(JSONObject.toJSONString(payAccountBookCreateParam));
                    logger.info("开始回调");
                    Result<Boolean> delayResult = delaySendMessageClient.delaySend(delay);
                    logger.info("结束回调,返回结果，【{}】", delayResult.toString());
                }
            } else {
                logger.warn("[企业后置脚本] 添加/修改企业信息失败");
                throw new JnSpringCloudException(CompanyExceptionEnum.UPDATE_COMPANY_INFO_ERROR);
            }
        } else {
            logger.warn("[企业后置脚本] 企业管理员获取失败");
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_ADMIN_GET_ERROR);
        }
    }

    /**
     * 判断企业是否新增
     * @param comId
     * @return
     */
    private boolean isAdd(String comId) {
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andIdEqualTo(comId);
        List<TbServiceCompany> companyList = tbServiceCompanyMapper.selectByExample(companyCriteria);
        if (companyList != null && !companyList.isEmpty()) {
            return false;
        }
        return true;
    }
}
