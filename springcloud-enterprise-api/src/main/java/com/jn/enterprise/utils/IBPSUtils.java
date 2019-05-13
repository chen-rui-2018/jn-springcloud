package com.jn.enterprise.utils;

import com.google.gson.Gson;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.company.model.IBPSResult;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * IBPS启动工具类
 * @author： huxw
 * @date： Created on 2019-5-7 15:54:37
 * @version： v1.0
 * @modified By:
 */
public class IBPSUtils {

    private static final Logger logger = LoggerFactory.getLogger(IBPSUtils.class);

    private final static String IBPS_REQUEST_URL = "/api/webapi/bpmService/start";

    public static IBPSResult sendRequest(String bpmnDefId, String account, Object object) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(object);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("bpmnDefId",bpmnDefId);
        map.add("data",jsonStr);
        JSONObject request = CallOtherSwaggerUtils.request(account, IBPS_REQUEST_URL, HttpMethod.POST, map);
        logger.info("启动ibps流程返回数据：{}",request.toString());
        return gson.fromJson(request.toString(), IBPSResult.class);
    }
}
