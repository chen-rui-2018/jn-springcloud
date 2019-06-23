package com.jn.hardware.ding.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.util.RestTemplateUtil;
import com.jn.hardware.ding.service.DingTalkDepartmentService;
import com.jn.hardware.ding.service.DingTalkInRedisConfigStorage;
import com.jn.hardware.model.dingtalk.user.DepartmentDetailsInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentDetailsInfoResult;
import com.jn.hardware.model.dingtalk.user.DepartmentListParam;
import com.jn.hardware.model.dingtalk.user.DepartmentListResult;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 钉钉：部门管理相关接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/17 11:10
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class DingTalkDepartmentServiceImpl implements DingTalkDepartmentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DingTalkInRedisConfigStorage dingTalkInRedisConfigStorage;

    @Override
    public DepartmentListResult getDepartmentList(DepartmentListParam departmentListParam) {
        logger.info("\n获取部门列表信息，入参:【{}】",departmentListParam);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        String accessToken = dingTalkInRedisConfigStorage.getAccessToken();
        map.add("access_token", accessToken);
        map.add("id", departmentListParam.getId());
        map.add("fetch_child",departmentListParam.getFetch_child());
        JSONObject jsonObject = RestTemplateUtil.request(DingTalkDepartmentService.GET_DEPARTMENT_LIST_URL, HttpMethod.GET,map,null, MediaType.APPLICATION_FORM_URLENCODED);
        logger.info("\n获取部门列表信息,接口响应:【{}】",jsonObject);
        DepartmentListResult departmentListResult = JsonStringToObjectUtil.jsonToObject(jsonObject.toJSONString(),new TypeReference<DepartmentListResult>(){});
        return departmentListResult;
    }

    /**
     * 获取部门详情
     * @param departmentDetailsInfoParam
     * @return
     */
    @Override
    public DepartmentDetailsInfoResult getDepartmentDetails(DepartmentDetailsInfoParam departmentDetailsInfoParam) {
        logger.info("\n获取部门详情,入参:【{}】",departmentDetailsInfoParam);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        String accessToken = dingTalkInRedisConfigStorage.getAccessToken();
        map.add("access_token", accessToken);
        map.add("lang", departmentDetailsInfoParam.getLang());
        map.add("id",departmentDetailsInfoParam.getId());
        logger.info("\n获取部门详情,接口入参:【{}】",map);
        JSONObject jsonObject = RestTemplateUtil.request(DingTalkDepartmentService.GET_DEPARTMENT_DETAILS_URL, HttpMethod.GET,map,null, MediaType.APPLICATION_FORM_URLENCODED);
        logger.info("\n获取部门详情,接口响应:【{}】",jsonObject);
        DepartmentDetailsInfoResult departmentDetailsInfoResult = JsonStringToObjectUtil.jsonToObject(jsonObject.toJSONString(),new TypeReference<DepartmentDetailsInfoResult>(){});
        return departmentDetailsInfoResult;
    }
}
