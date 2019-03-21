package com.jn.user.api;

import com.jn.common.model.Result;
import com.jn.user.model.RegisterInfoParam;
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
     * 判断OpenId是否已绑定
     * @param openId  微信账号对应的openId
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/isBindingOpenId", method = RequestMethod.POST)
    Result isBindingOpenId(@RequestBody String openId);

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/getCode")
    Result getCode(@RequestBody String phone);

    /**
     * 注册并绑定
     * @param registerInfoParam
     * @return
     */
    @RequestMapping(value = "/api/miniProgramRegister/registerAndBinding")
    Result registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam);
}
