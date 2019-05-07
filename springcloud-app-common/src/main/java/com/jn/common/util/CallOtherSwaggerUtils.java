package com.jn.common.util;

import com.jn.common.util.encryption.EncryptUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
@Component
public class CallOtherSwaggerUtils {

    @Autowired
    private JedisFactory jedisFactory;

    @Autowired
    RestTemplate restTemplate;

    public static CallOtherSwaggerUtils callOtherSwaggerUtils;

    @PostConstruct
    public void init() {
        callOtherSwaggerUtils = this;
    }

    /**
     * KEY PREFIX
     */
    private static String PREFIX = "swagger:account:";

    /**
     * REAL_PATH
     */
    private static String REAL_PATH = "http://112.94.22.222:2382/ibpsApi";
    /**
     * 获取TOKEN 请求地址
     */
    private static String LOGIN_URL = REAL_PATH + "/api/loginService/noPwdLogin";
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
     * @param account 账号
     * @param url     请求URL
     * @param method  method
     * @param param   请求参数
     * @return
     */
    public static JSONObject request(String account, String url, HttpMethod method, MultiValueMap<String, String> param) {
        JSONObject result = new JSONObject();
        try {
            String token = callOtherSwaggerUtils.jedisFactory.getJedis().get(PREFIX + account);
            if (StringUtils.isEmpty(token)) {
                String accountKey = EncryptUtil.encryptSha256(account);
                MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
                map.add("account", account);
                map.add("accountKey", accountKey);
                JSONObject tokenJsonObject = RestTemplateUtil.request(LOGIN_URL, HttpMethod.POST, map, new HashMap<>());
                token = ((LinkedHashMap)tokenJsonObject.get("data")).get("token").toString();
                callOtherSwaggerUtils.jedisFactory.getJedis().set(PREFIX + account, token, NXXX, EXPX, TIME);
            }
            Map dynamicHeaders = new HashMap<>();
            dynamicHeaders.put("X-Authorization-access_token", token);
            result = RestTemplateUtil.request(REAL_PATH + url, method, param, dynamicHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
