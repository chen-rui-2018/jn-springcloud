package com.jn.hardware.ding.service;

import com.jn.hardware.model.dingtalk.user.DepartmentListParam;
import com.jn.hardware.model.dingtalk.user.DepartmentListResult;

/**
 * 钉钉：部门管理相关接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/17 10:48
 * @Version： v1.0
 * @Modified By:
 */
public interface DingTalkDepartmentService {

    /**
     * 获取部门列表接口url
     */
    String GET_DEPARTMENT_LIST_URL = "https://oapi.dingtalk.com/department/list";

    /**
     * 获取部门列表
     * @param departmentListParam
     * @return
     */
    DepartmentListResult getDepartmentList(DepartmentListParam departmentListParam);

}
