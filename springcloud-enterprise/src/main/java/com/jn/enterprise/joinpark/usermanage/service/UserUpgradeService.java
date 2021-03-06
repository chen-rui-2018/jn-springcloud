package com.jn.enterprise.joinpark.usermanage.service;

import com.jn.enterprise.company.model.Company;
import com.jn.enterprise.company.model.CompanyCheckParam;
import com.jn.enterprise.joinpark.usermanage.model.StaffCheckParam;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/5 11:53
 * @version： v1.0
 * @modified By:
 */
public interface UserUpgradeService {

    /**
     * 升级企业
     * @param companyCheckParam
     * @param phone
     * @param account
     * @return
     */
    int changeToCompany(CompanyCheckParam companyCheckParam, String phone, String account);

    /**
     * 升级员工
     * @param staffCheckParam
     * @param phone
     * @param account
     * @return
     */
    int changeToStaff(StaffCheckParam staffCheckParam, String phone, String account);

    /**
     * 查询公司列表
     * @param comName
     * @return
     */
    List<Company> selectCompany(String comName);
}
