package com.jn.enterprise.utils;

import com.google.gson.Gson;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.company.model.IBPSResult;
import org.json.simple.JSONObject;
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

    private final static String IBPS_REQUEST_URL = "/api/webapi/bpmService/start";

    public static IBPSResult sendRequest(String bpmnDefId, String account, Object object) {
        Gson gson = new Gson();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("bpmnDefId",bpmnDefId);
        String jsonStr = gson.toJson(object);
        map.add("data",jsonStr);
        JSONObject request = CallOtherSwaggerUtils.request(account, IBPS_REQUEST_URL, HttpMethod.POST, map);
        return gson.fromJson(request.toString(), IBPSResult.class);
    }
}
