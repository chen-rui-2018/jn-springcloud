package com.jn.hardware.ding.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.util.RestTemplateUtil;
import com.jn.hardware.ding.service.DingTalkBaseService;
import com.jn.hardware.ding.service.DingTalkInRedisConfigStorage;
import com.jn.hardware.ding.service.DingTalkUserService;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;
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
 * 钉钉：通讯录管理-用户管理相关接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 16:42
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class DingTalkUserServiceImpl implements DingTalkUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DingTalkInRedisConfigStorage dingTalkInRedisConfigStorage;
    @Autowired
    private DingTalkBaseService dingTalkBaseService;

    @Override
    public DepartmentUserInfoResult getDepartUserByPage(DepartmentUserInfoParam departmentUserInfoParam) {
        logger.info("\n分页获取部门用户详细信息,入参:【{}】",departmentUserInfoParam);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        String accessToken = dingTalkInRedisConfigStorage.getAccessToken();
        map.add("access_token", accessToken);
        map.add("lang", departmentUserInfoParam.getLang());
        map.add("department_id",departmentUserInfoParam.getDepartment_id());
        map.add("offset",departmentUserInfoParam.getOffset());
        map.add("size",departmentUserInfoParam.getSize());
        if(null!=departmentUserInfoParam.getDepartmentUserOrder()) {
            map.add("order",departmentUserInfoParam.getDepartmentUserOrder().getCode());
        }
        JSONObject jsonObject = RestTemplateUtil.request(DingTalkUserService.GET_DEPART_USER_BY_PAGE_URL, HttpMethod.GET,map,null, MediaType.APPLICATION_FORM_URLENCODED);
        logger.info("\n分页获取部门用户详细信息,接口响应:【{}】",jsonObject);
        DepartmentUserInfoResult departmentUserInfoResult = JsonStringToObjectUtil.jsonToObject(jsonObject.toJSONString(),new TypeReference<DepartmentUserInfoResult>(){});
        return departmentUserInfoResult;
    }
}
