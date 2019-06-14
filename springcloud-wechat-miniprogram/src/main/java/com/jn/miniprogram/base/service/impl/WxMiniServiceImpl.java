package com.jn.miniprogram.base.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.StringUtils;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import com.jn.miniprogram.base.model.security.AccessToken;
import com.jn.miniprogram.base.service.WxInRedisConfigStorage;
import com.jn.miniprogram.base.service.WxMiniService;
import com.jn.miniprogram.base.utils.crypto.SHA1;
import com.jn.miniprogram.base.utils.json.JacksonJsonTransformUtil;
import com.jn.miniprogram.config.WxMiniProperties;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 微信小程序API接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/3/9 16:25
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxMiniServiceImpl implements WxMiniService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMiniProperties wxMiniProperties;

    @Autowired
    private WxInRedisConfigStorage wxInRedisConfigStorage;

    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        try {
            return SHA1.gen(wxMiniProperties.getToken(), timestamp, nonce)
                    .equals(signature);
        } catch (Exception e) {
            logger.error("校验信息是否来自微信小程序服务器失败，原因{} :" , e.getMessage());
            return false;
        }
    }

    /**
     * 强制获取access_token
     * @return
     */
    @Override
    @ServiceLog(doAction = "强制获取access_token")
    public String getAccessToken() {
        String url = WxMiniService.GET_ACCESS_TOKEN_URL;
        url = String.format(url,wxMiniProperties.getAppId(),wxMiniProperties.getSecret());
        String accessTokenString = null;
        String responseString = RestTemplateUtil.get(url);
        AccessToken accessToken = null;
        try {
            accessToken = JacksonJsonTransformUtil.jsonToObject(responseString, new TypeReference<AccessToken>(){});
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.JSON_PROCESS_FAIL);
        }
        if(null != accessToken && StringUtils.isNotBlank(accessToken.getAccess_token())) {
            accessTokenString = accessToken.getAccess_token();
            //缓存accessToken
            wxInRedisConfigStorage.setAccessToken(accessTokenString,accessToken.getExpires_in());
        }

        logger.info("获取access_token接口返回值{}：",accessTokenString);
        return accessTokenString;

    }

}
