package com.jn.wechat.base.service;

import com.jn.wechat.base.model.result.WxOAuth2AccessToken;
import com.jn.wechat.base.model.result.WxUser;

/**
 * 微信公众号基础API的Service.
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 10:11
 * @Version： v1.0
 * @Modified By:
 */
public interface WxService {
    /**
     * 获取access_token.
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * oauth2授权的url连接.
     */
    String CONNECT_OAUTH2_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";

    /**
     * 用code换取oauth2的access token.
     */
    String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * 用oauth2获取用户信息.
     */
    String OAUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";

    /**
     * 检验授权凭证（access_token）是否有效
     */
    String OAUTH2_JUDGE_EFFECTIVE_URL = "https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s";

    /**
     * 刷新access_token（如果需要）
     */
    String OAUTH2_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";

    /**
     * 验证消息的确来自微信服务器.
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean checkSignature(String timestamp, String nonce, String signature);

    /**
     * 处理来自微信的消息
     * @param xml
     * @return
     */
    String processRequest(String xml);

    /**
     * 强制刷新获取AccessToken
     * @return
     */
    String getAccessToken();

    /**
     * <pre>
*      构造oauth2授权的url连接.
     * 详情请见: http://mp.weixin.qq.com/wiki/index.php?title=网页授权获取用户基本信息
     * </pre>
     * @param redirectURI 用户授权完成后的重定向链接，无需urlencode, 方法内会进行encode
     * @param scope
     * @param state
     * @return url
     */
    String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state);

    /**
     * 用code换取oauth2的access token,
     * 详情请见: http://mp.weixin.qq.com/wiki/index.php?title=网页授权获取用户基本信息
     * @param code
     * @return
     */
    WxOAuth2AccessToken oauth2getAccessToken(String code);

    /**
     * <pre>
     * 用oauth2获取用户信息, 当前面引导授权时的scope是snsapi_userinfo的时候才可以.
     * </pre>
     * @param oAuth2AccessToken
     * @param lang
     * @return
     */
    WxUser oauth2getUserInfo(WxOAuth2AccessToken oAuth2AccessToken, String lang);

}
