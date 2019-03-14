package com.jn.user.userinfo.service;


import com.jn.common.model.PaginationData;
import com.jn.user.model.*;

import java.util.List;

/**
 * 获取用户信息
 * @Author: yangph
 * @Date: 2018/12/10 11:31
 * @Version v1.0
 * @modified By:
 */
public interface UserInfoService {
    /**
     * 根据账号获取用户扩展信息
     * @param account 用户账号
     * @return
     */
    UserExtensionInfo getUserExtension(String account);

    /**
     * 批量获取用户的扩展信息
     * @param accountList  用户账号集合
     * @return
     */
    List<UserExtensionInfo> getMoreUserExtension(List<String> accountList);

    /**
     * 更新用户所属机构信息
     * @param userAffiliateInfo
     * @return true:更新成功    false:更新失败
     */
    boolean updateAffiliateInfo(UserAffiliateInfo userAffiliateInfo);

    /**
     * 更新用户所属企业信息
     * @param  userCompanyInfo
     * @return true:更新成功    false:更新失败
     */
    boolean updateCompanyInfo(UserCompanyInfo userCompanyInfo);

    /**
     * 根据所属机构编码批量获取用户信息
     * @param affiliateParam  所属机构编码入参
     * @return
     */
    PaginationData getUserExtensionByAffiliateCode(AffiliateParam affiliateParam);

    /**
     * 根据所属企业编码批量获取用户信息
     * @param companyParam  所属企业编码入参
     * @return
     */
    PaginationData getUserExtensionByCompanyCode(CompanyParam companyParam);

    /**
     * 更新redis中的用户信息
     * @param account 用户账号
     * @return  true:更新成功  失败会抛异常
     */
    boolean updateRedisUserInfo(String account);
}
