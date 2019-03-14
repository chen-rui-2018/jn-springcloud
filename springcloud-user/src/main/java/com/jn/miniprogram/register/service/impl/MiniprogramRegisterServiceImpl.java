package com.jn.miniprogram.register.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.miniprogram.register.model.RegisterInfoParam;
import com.jn.miniprogram.register.service.MiniprogramRegisterService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.userjoin.service.UserJoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yangph
 * @Date: 2019/3/11 20:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class MiniprogramRegisterServiceImpl implements MiniprogramRegisterService {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniprogramRegisterServiceImpl.class);

    @Autowired
    private UserJoinService userJoinService;


    /**
     * 判断OpenId是否已绑定
     * @param openId 微信用户openId
     * @return 0:未绑定  1：已绑定
     */
    @ServiceLog(doAction = "判断OpenId是否已绑定")
    @Override
    public int isBindingOpenId(String openId) {
        //todo:根据openId从微信表中获取信息，若有数据，表明已绑定，否则未绑定 yangph
        return 0;
    }

    /**
     * 注册并绑定
     * @param registerInfoParam  注册绑定入参
     * @return
     */
    @ServiceLog(doAction = "注册并绑定")
    @Override
    public int registerAndBinding(RegisterInfoParam registerInfoParam) {
        //判断手机号和验证码是否正确
        String codeByPhone = userJoinService.getSendCodeByPhone(registerInfoParam.getPhone());
        if(StringUtils.isBlank(codeByPhone) || !StringUtils.equals(registerInfoParam.getCode(), codeByPhone)){
          throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.CODE_IS_ERROR);
        }
        //todo:往微信表插入传递的微信信息，并把openId绑定 yangph
        return 1;
    }

}
