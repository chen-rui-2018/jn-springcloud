package com.jn.common.util;

import com.jn.common.util.encryption.EncryptUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 调用第三方swagger接口工具
 *
 * @author： shenph
 * @date： Created on 2019/5/6 16:28
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
        prefix = "jn.ibps.swagger"
)
@Component
@RefreshScope
public class CallOtherSwaggerUtils {

    /**
     * ibps.swagger的链接
     */
    private static String url;

    @Autowired
    private JedisFactory jedisFactory;

    public static CallOtherSwaggerUtils callOtherSwaggerUtils;

    @PostConstruct
    public void init() {
        callOtherSwaggerUtils = this;
    }

    /**
     * KEY PREFIX
     */
    private static String PREFIX = "swagger:account:nj:";

    /**
     * 获取TOKEN 请求地址
     */
    private static String LOGIN_URL = "/api/loginService/noPwdLogin";
    /**
     * 只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
     */
    private static String NXXX = "NX";
    /**
     * 只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
     */
    private static String EXPX = "EX";
    /**
     * token失效时间
     */
    private static int TIME = 60 * 60 * 2;

    /**
     * swagger util
     *
     * @param account 账号
     * @param curl    请求URL
     * @param method  method
     * @param param   请求参数
     * @return
     */
    public static JSONObject request(String account, String curl, HttpMethod method, MultiValueMap<String, String> param) {
        return request(account, curl, method, param, MediaType.APPLICATION_FORM_URLENCODED);
    }

    /**
     * swagger util
     *
     * @param account   账号
     * @param curl      请求URL
     * @param method    method get post
     * @param param     请求参数
     * @param mediaType application/x-www-form-urlencoded application/json
     * @return
     */
    public static JSONObject request(String account, String curl, HttpMethod method, MultiValueMap<String, String> param, MediaType mediaType) {
        JSONObject result = new JSONObject();
        try {
            String token = getToken(account);
            Map dynamicHeaders = new HashMap<>();
            dynamicHeaders.put("X-Authorization-access_token", token);
            result = RestTemplateUtil.request(url + curl, method, param, dynamicHeaders, mediaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * swagger util
     *
     * @param account 账号
     * @param curl    请求URL
     * @param method  method get post
     * @return
     */
    public static JSONObject request(String account, String curl, HttpMethod method, String jsonObject) {
        JSONObject result = new JSONObject();
        try {
            String token = getToken(account);
            Map dynamicHeaders = new HashMap<>();
            dynamicHeaders.put("X-Authorization-access_token", token);
            result = RestTemplateUtil.request(url + curl, method, jsonObject, dynamicHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取token
     *
     * @param account
     * @return
     */
    private static String getToken(String account) {
        String token = callOtherSwaggerUtils.jedisFactory.getJedis().get(PREFIX + account);
        if (StringUtils.isEmpty(token)) {
            String accountKey = EncryptUtil.encryptSha256(account);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("account", account);
            map.add("accountKey", accountKey);
            JSONObject tokenJsonObject = RestTemplateUtil.request(url + LOGIN_URL, HttpMethod.POST, map, new HashMap<>(), MediaType.APPLICATION_FORM_URLENCODED);
            token = ((LinkedHashMap) tokenJsonObject.get("data")).get("token").toString();
            callOtherSwaggerUtils.jedisFactory.getJedis().set(PREFIX + account, token, NXXX, EXPX, TIME);
        }
        return token;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        CallOtherSwaggerUtils.url = url;
    }
}
