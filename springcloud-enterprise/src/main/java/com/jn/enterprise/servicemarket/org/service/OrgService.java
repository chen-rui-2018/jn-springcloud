package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.enterprise.servicemarket.org.vo.*;
import com.jn.enterprise.servicemarket.org.model.*;

import java.util.List;

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
     * @param allowTechnology 是否允许展示科技金融业务领域数据  true:允许展示  false:不允许展示
     * @return
     */
    PaginationData<List<ServiceOrg>> selectServiceOrgList(OrgParameter orgParment,boolean allowTechnology);

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

    /**
     * 我的机构信息
     * @param account
     * @return
     */
    MyOrgInfoVo getMyOrgInfo(String account);

    /**
     * 查询服务超市统计数据
     * @return
     */
    ServiceStatisticalNumVO selectServiceStatisticalNum();

    /**
     * 根据业务领域/产品查询服务超市统计数据
     * @param businessStatisticalParam
     * @return
     */
    BusinessStatisticalNumVO selectBusinessAreaStatisticalNum(BusinessStatisticalParam businessStatisticalParam);

    /**
     * 获取当前用户机构状态
     * @param account
     * @return
     */
    String getOrgStatusByUser(String account);

    /**
     * 添加机构管理员角色
     * @param orgAccount
     * @param orgId
     * @param loginAccount
     * @return
     */
    int addOrgRole(String orgAccount,String orgId,String loginAccount);

}
