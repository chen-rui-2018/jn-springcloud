package com.jn.wechat.base.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.MiniProgramPublicRegisterClient;
import com.jn.user.model.RegisterInfoParam;
import com.jn.wechat.base.enums.WxExceptionEnums;
import com.jn.wechat.base.service.WxInRedisConfigStorage;
import com.jn.wechat.base.service.WxRegisterUserService;
import com.jn.wechat.model.WxUserRegisterBindingParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信服务号用户绑定注册接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/25 21:41
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxRegisterUserServiceImpl implements WxRegisterUserService {
    @Autowired
    private MiniProgramPublicRegisterClient miniProgramPublicRegisterClient;
    @Autowired
    private WxInRedisConfigStorage wxInRedisConfigStorage;

    @ServiceLog(doAction = "微信服务号用户绑定注册接口")
    @Override
    public void registerBinding(WxUserRegisterBindingParam wxUserRegisterBindingParam) {
        RegisterInfoParam registerInfoParam = new RegisterInfoParam();
        String openid = wxInRedisConfigStorage.getCacheValue(WxInRedisConfigStorage.WX_OPENID_KEY+wxUserRegisterBindingParam.getUserFlag());
        if(StringUtils.isBlank(openid)) {
            throw new JnSpringCloudException(WxExceptionEnums.GET_OPENID_FAIL);
        }
        registerInfoParam.setOpenId(openid);
        registerInfoParam.setPhone(wxUserRegisterBindingParam.getPhoneNo());
        registerInfoParam.setCode(wxUserRegisterBindingParam.getPhoneCode());
        Result result = miniProgramPublicRegisterClient.registerAndBinding(registerInfoParam);
        if(null == result) {
            throw new JnSpringCloudException(WxExceptionEnums.WX_REGISTER_BINDING_FAIL);
        }else if(!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            throw new JnSpringCloudException(WxExceptionEnums.WX_REGISTER_BINDING_FAIL,result.getResult());
        }
    }
}
