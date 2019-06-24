package com.jn.hardware.ding.service;

import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;

/**
 * 钉钉：通讯录管理-用户管理相关接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 15:17
 * @Version： v1.0
 * @Modified By:
 */
public interface DingTalkUserService {

    String GET_DEPART_USER_BY_PAGE_URL = "https://oapi.dingtalk.com/user/listbypage";
    /**
     * 获取部门用户详情
     * @param departmentUserInfoParam
     */
    DepartmentUserInfoResult getDepartUserByPage(DepartmentUserInfoParam departmentUserInfoParam);

}
