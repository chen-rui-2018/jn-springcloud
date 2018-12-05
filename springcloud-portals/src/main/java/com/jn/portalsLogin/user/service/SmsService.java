package com.jn.portalsLogin.user.service;

import com.jn.common.model.Result;

/**
 * 发送短信验证码
 * @Author: yangph
 * @Date: 2018/12/3 15:40
 * @Version v1.0
 * @modified By:
 */
public interface SmsService {
    /**
     * 保存短信验证码
     * @param phone    手机号
     * @param smsCode  短信验证码
     * @return
     */
    Result saveSmsCode(String phone, String smsCode);
}
