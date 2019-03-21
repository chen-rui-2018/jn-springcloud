package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;

import java.util.List;

/**
 * 企业信息Service
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:50
 * @version： v1.0
 * @modified By:
 */
public interface CompanyService {

    /**
     * 查询企业列表
     * @param serviceCompanyParam
     * @return
     */
    PaginationData<List<ServiceCompany>> getCompanyList(ServiceCompanyParam serviceCompanyParam);

    /**
     * 根据企业ID查询详情
     * @param companyId
     * @return
     */
    ServiceCompany getCompanyDetail(String companyId);

    /**
     * 根据用户账号查询企业信息（用户为企业管理员）
     * @param account
     * @return
     */
    ServiceCompany getCompanyDetailByAccount(String account);

}
