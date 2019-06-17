package com.jn.hardware.ding.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.util.RestTemplateUtil;
import com.jn.hardware.config.DingTalkProperties;
import com.jn.hardware.ding.service.DingTalkBaseService;
import com.jn.hardware.ding.service.DingTalkInRedisConfigStorage;
import com.jn.hardware.model.dingtalk.token.AccessTokenResult;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 钉钉基础接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 11:45
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class DingTalkBaseServiceImpl implements DingTalkBaseService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DingTalkProperties dingTalkProperties;
    @Autowired
    private DingTalkInRedisConfigStorage dingTalkInRedisConfigStorage;

    @Override
    public String getAccessToken() {
        logger.info("\n强制获取钉钉access_token开始.");
        String url = String.format(DingTalkBaseService.GET_ACCESS_TOKEN_URL,dingTalkProperties.getAppkey(),dingTalkProperties.getAppsecret());
        String result = RestTemplateUtil.get(url);
        logger.info("\n获取钉钉access_token，响应结果：【{}】",result);
        AccessTokenResult accessTokenResult = JsonStringToObjectUtil.jsonToObject(result,new TypeReference<AccessTokenResult>(){});
        String accessTokenString = "";
        if(null != accessTokenResult && StringUtils.isNotBlank(accessTokenResult.getAccess_token())) {
            accessTokenString = accessTokenResult.getAccess_token();
            //缓存accessToken
            dingTalkInRedisConfigStorage.setAccessToken(accessTokenString,AccessTokenResult.expires_in);
        }

        return accessTokenString;
    }
}
