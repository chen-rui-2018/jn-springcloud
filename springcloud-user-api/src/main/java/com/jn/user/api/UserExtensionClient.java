package com.jn.user.api;

import com.jn.common.model.Result;
import com.jn.user.model.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 用户信息客户端
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-user")
public interface UserExtensionClient {
    /**
     * 获取登录用户扩展信息
     *
     * @param account 用户账号
     * @return
     */
    @RequestMapping(value = "/api/user/getUserExtension", method = RequestMethod.POST)
    Result<UserExtensionInfo> getUserExtension(@RequestBody String account);

    /**
     * 批量获取用户的扩展信息
     * @param accountList
     * @return
     */
    @RequestMapping(value = "/api/user/getMoreUserExtension", method = RequestMethod.POST)
    Result<List<UserExtensionInfo>>getMoreUserExtension(@RequestBody List<String> accountList);

    /**
     * 更新用户所属机构信息
     * @param userAffiliateInfo
     * @return
     */
    @RequestMapping(value = "/api/user/updateAffiliateInfo", method = RequestMethod.POST)
    Result updateAffiliateInfo(@RequestBody @Validated UserAffiliateInfo userAffiliateInfo);

    /**
     * 更新用户所属企业信息
     * @param userCompanyInfo
     * @return
     */
    @RequestMapping(value = "/api/user/updateCompanyInfo", method = RequestMethod.POST)
    Result updateCompanyInfo(@RequestBody @Validated UserCompanyInfo userCompanyInfo);

    /**
     * 根据所属机构编码批量获取用户信息
     * @param affiliateParam
     * @return
     */
    @RequestMapping(value = "/api/user/getUserExtensionByAffiliateCode", method = RequestMethod.POST)
    Result getUserExtensionByAffiliateCode(@RequestBody @Validated AffiliateParam affiliateParam);

    /**
     * 根据所属机构编码批量获取用户信息
     * @param companyParam
     * @return
     */
    @RequestMapping(value = "/api/user/getUserExtensionByCompanyCode", method = RequestMethod.POST)
    Result getUserExtensionByCompanyCode(@RequestBody @Validated CompanyParam companyParam);

    /**
     * 通过手机号获取已发送的验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/api/user/getSendCodeByPhone", method = RequestMethod.POST)
    Result getSendCodeByPhone(@RequestBody  String phone);

    /**
     * 通过条件 返回用户账号列表
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/user/getAccountList", method = RequestMethod.POST)
    Result<List<String>> getAccountList(@RequestBody  UserInfoQueryParam param);

    /**
     * 保存/修改用户信息
     * @param userInfoParam
     * @return
     */
    @RequestMapping(value = "/api/user/saveOrUpdateUserInfo", method = RequestMethod.POST)
    Result saveOrUpdateUserInfo(@RequestBody @Validated UserInfo userInfoParam);

    /**
     * 根据查询字段批量获取用户信息
     * @param searchFiledParam
     * @return
     */
    @RequestMapping(value = "/api/user/getUserExtensionBySearchFiled", method = RequestMethod.POST)
    Result getUserExtensionBySearchFiled(@RequestBody @Validated SearchFiledParam searchFiledParam);

}
