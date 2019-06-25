package com.jn.user.api;

import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.model.RegisterInfoParam;
import com.jn.user.model.WeChatRequestParam;
import io.swagger.annotations.ApiOperation;
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
public interface MiniProgramRegisterClient {
    /**
     * 判断OpenId是否已绑定 (在判断是否绑定时，会将入参的微信信息插入或更新到数据库表中)
     * @param weChatRequestParam  微信用户信息
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/isBindingAccountByOpenId", method = RequestMethod.POST)
    Result isBindingAccountByOpenId(@RequestBody @Validated WeChatRequestParam weChatRequestParam);


    /**
     * 根据OpenId判断OpenId是否已绑定(查询数据库表中是否存在openId，若存在，则再查询是否已绑定账号，若有返回绑定账号，否则返回空)
     * @param openId
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/openIdIsBindingAccount", method = RequestMethod.POST)
    Result<String> openIdIsBindingAccount(@RequestBody String openId);

    /**
     * 注册并绑定  (若入参手机号在系统中已经存在，则直接把手机号openId绑定，若不存在，系统根据手机号自动注册，然后再把注册的账号和openId绑定)
     * @param registerInfoParam
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/registerAndBinding")
    Result registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam);

    /**
     * 根据账号获取openId
     * @param account
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/getOpenIdByAccount")
    Result getOpenIdByAccount(@RequestBody String account);
}
