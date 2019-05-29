package com.jn.enterprise.company.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.model.ServiceCompany;
import com.jn.enterprise.company.service.UpCompanyAccountService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.vo.SysUserRoleVO;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserCompanyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 升级企业账号服务层实现
 *
 * @author： shaobao
 * @date： Created on 2019/5/28 19:24
 * @version： v1.0
 * @modified By:
 **/
@Service
public class UpCompanyAccountServiceImpl implements UpCompanyAccountService {
    /**
     * 日志组件
     *
     * @param tbServiceCompany
     */
    private static Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 升级企业账号,设置企业申请人为企业管理员
     *
     * @param ServiceCompany
     */
    @Override
    @ServiceLog(doAction = "升级企业账号,设置企业申请人为企业管理员")
    @Transactional(rollbackFor = Exception.class)
    public void setComApplicantToManager(ServiceCompany ServiceCompany) {
        //1.获取企业申请人
        String comAdmin = ServiceCompany.getComAdmin();
        //获取企业id
        String companyId = ServiceCompany.getId();
        //获取企业名称
        String comName = ServiceCompany.getComName();
        if (StringUtils.isNotBlank(comAdmin)) {
            Result<SysRole> result = systemClient.getRoleByName(CompanyDataEnum.COMPANY_ADMIN.getCode());
            logger.info("[升级企业账号] 调用系统服务 根据角色名称获取角色信息 接口 返回结果:{}", result);
            if (result != null && result.getData() != null) {
                String roleId = result.getData().getId();

                //2.为用户赋权,增加企业管理员角色
                SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();
                User user = new User();
                user.setAccount(comAdmin);

                Set<String> addRoleSet = new HashSet<String>();
                addRoleSet.add(roleId);
                sysUserRoleVO.setUser(user);
                sysUserRoleVO.setAddRoleId(addRoleSet);

                systemClient.updateUserRole(sysUserRoleVO);
                logger.info("[升级企业账号] 调用系统服务 修改用户角色 接口 用户账号:{},角色id:{}", comAdmin, roleId);
            }

            //3.更新用户企业信息
            UserCompanyInfo userCompanyInfo = new UserCompanyInfo();
            List<String> accountList = new ArrayList<String>(16);
            accountList.add(comAdmin);
            userCompanyInfo.setAccountList(accountList);
            userCompanyInfo.setCompanyCode(companyId);
            userCompanyInfo.setCompanyName(comName);
            userExtensionClient.updateCompanyInfo(userCompanyInfo);
            logger.info("[升级企业账号] 调用用户服务 修改用户所属企业 接口 用户账号:{}", comAdmin);
        }
    }

}
