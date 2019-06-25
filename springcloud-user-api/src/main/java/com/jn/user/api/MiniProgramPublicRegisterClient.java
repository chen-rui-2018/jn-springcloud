package com.jn.user.api;

import com.jn.common.model.Result;
import com.jn.user.model.RegisterInfoParam;
import com.jn.user.model.WeChatRequestParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: yangph
 * @Date: 2019/3/19 14:40
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-user")
public interface MiniProgramPublicRegisterClient {
    /**
     * 判断OpenId是否已绑定
     * @param weChatRequestParam  微信用户信息
     * @return
     */
    @RequestMapping(value = "/api/miniProgramPublicController/isBindingAccountByOpenId", method = RequestMethod.POST)
    Result isBindingAccountByOpenId(@RequestBody @Validated WeChatRequestParam weChatRequestParam);

    /**
     * 根据OpenId判断OpenId是否已绑定
     * @param openId
     * @return
     */
    @RequestMapping(value = "/api/miniProgramPublicController/openIdIsBindingAccount", method = RequestMethod.POST)
    Result<String> openIdIsBindingAccount(@RequestBody String openId);

    /**
     * 注册并绑定
     * @param registerInfoParam
     * @return
     */
    @RequestMapping(value = "/api/miniProgramPublicController/registerAndBinding")
    Result registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam);

    /**
     * 根据账号获取openId
     * @param account
     * @return
     */
    @RequestMapping(value = "/api/miniProgramPublicController/getOpenIdByAccount")
    Result getOpenIdByAccount(@RequestBody String account);
}
