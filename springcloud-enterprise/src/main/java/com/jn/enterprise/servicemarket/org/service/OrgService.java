package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.vo.OrgDetailVo;

/**
 * 服务机构service
 * @Author: jiangyl
 * @Date: 2019/2/13 10:37
 * @Version v1.0
 * @modified By:
 */
public interface OrgService {

    /**
     * 查询服务机构列表
     * @param orgParment
     * @return
     */
    PaginationData selectServiceOrgList(OrgParameter orgParment);

    /**
     * 根据机构ID查询机构详情
     * @param orgId
     * @return
     */
    OrgDetailVo getServiceOrgDetail(String orgId);

    /**
     * 保存服务机构基本信息(id为空时为新增)
     * @param orgBasicData
     * @param account
     * @return
     */
    String saveOrUpdateOrgBasicData(OrgBasicData orgBasicData,String account);

    /**
     * 保存服务机构资质信息
     * @param orgLicenseData
     * @param account
     * @return
     */
    int saveOrgLicenseData(OrgLicenseData orgLicenseData,String account);

    /**
     * 保存服务机构团队信息
     * @param orgTeamData
     * @param account
     * @return
     */
    int saveOrUpdateOrgTeamData(OrgTeamData orgTeamData,String account);

    /**
     * 保存/修改服务机构联系信息
     * @param orgContactData
     * @param account
     * @return
     */
    int saveOrUpdateOrgContactData(OrgContactData orgContactData,String account);
}
