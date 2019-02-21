package com.jn.wechat.base.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.wechat.base.model.result.WxUser;
import com.jn.wechat.base.service.WxHttpClientService;
import com.jn.wechat.base.service.WxUserService;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信用户管理相关操作接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/1/8 15:40
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxUserServiceImpl implements WxUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxHttpClientService wxHttpClientService;

    @Override
    @ServiceLog(doAction = "获取用户基本信息")
    public WxUser userInfo(String openid) {
        return this.userInfo(openid, null);
    }

    @Override
    @ServiceLog(doAction = "获取用户基本信息")
    public WxUser userInfo(String openid, String lang) {
        lang = lang == null ? "zh_CN" : lang;
        String s = wxHttpClientService.get(WxUserService.USER_INFO_URL,"openid=" + openid + "&lang=" + lang);
        WxUser wxUser = JsonStringToObjectUtil.jsonToObject(s,new TypeReference<WxUser>(){});
        logger.info("\n返回wxUser对象{}",wxUser.toString());
        return wxUser;
    }



}