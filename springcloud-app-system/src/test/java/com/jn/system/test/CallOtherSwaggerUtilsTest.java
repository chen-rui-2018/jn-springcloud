package com.jn.system.test;

import com.jn.common.util.CallOtherSwaggerUtils;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author： shenph
 * @date： Created on 2019/5/6 20:15
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CallOtherSwaggerUtilsTest {

    @Test
    public void test() {
        //启动流程  -- 物品采购流程
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("bpmnDefId", "563373505169588224");
        map.add("data", "{\"id\":\"\",\"title\":\"采购1\",\"createdTime\":\"2019-05-07 11:40:51\",\"creatorAccount\":\"user10000\",\"deptId\":\"a794452f-fad6-4697-afe1-e62542bd753a\",\"tb_oa_purchase_details\":[{\"id\":\"\",\"purchaseId\":\"\",\"type\":\"1\",\"goodsName\":\"1\",\"goodsType\":\"1\",\"goodsPrice\":\"1\",\"goodsNum\":\"1\",\"totalPrice\":1}],\"totalNum\":1,\"totalMoney\":1,\"attachment\":\"\",\"remark\":\"<p>123<br/></p>\",\"approvalStatus\":\"0\"}");
        JSONObject jsonObject1 = CallOtherSwaggerUtils.request("wangsong", "/api/webapi/bpmService/start", HttpMethod.POST, map);
        System.out.println(jsonObject1);
    }

    @Test
    public void test1() {
        //获取用戶菜單角色
        //JSONObject jsonObject2 = CallOtherSwaggerUtils.request("wangsong", "/api/webapi/appResourcesService/getMenuData", HttpMethod.GET, new LinkedMultiValueMap<String, String>());

        //获取审批历史记录
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("bpmInstId", "578164728874926080");
        JSONObject jsonObject2 = CallOtherSwaggerUtils.request("wangsong", "/api/webapi/bpmService/opinions", HttpMethod.GET, map);
        System.out.println(jsonObject2);
    }
}
