package com.jn.enterprise.company.service;

import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.model.ServiceCompany;

/**
 * 升级企业账号服务层
 *
 * @author： shaobao
 * @date： Created on 2019/5/28 19:23
 * @version： v1.0
 * @modified By:
 **/
public interface UpCompanyAccountService {
    /**
     * 升级企业账号,设置企业申请人为企业管理员
     *
     * @param ServiceCompany
     */
    void setComApplicantToManager(ServiceCompany ServiceCompany);
}
