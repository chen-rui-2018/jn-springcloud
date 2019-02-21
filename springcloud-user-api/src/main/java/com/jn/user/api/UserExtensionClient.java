package com.jn.user.api;

import com.jn.common.model.Result;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserCompanyInfo;
import com.jn.user.model.UserExtensionInfo;
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
    Result updateAffiliateInfo(@RequestBody @Validated UserAffiliateInfo userAffiliateInfo);

    /**
     * 更新用户所属企业信息
     * @param userCompanyInfo
     * @return
     */
    Result updateCompanyInfo(@RequestBody @Validated UserCompanyInfo userCompanyInfo);
}
