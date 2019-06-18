package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.dingtalk.user.DepartmentListParam;
import com.jn.hardware.model.dingtalk.user.DepartmentListResult;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 钉钉提供的内部服务接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:52
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-hardware")
public interface DingTalkClient {

    /**
     * 强制刷新钉钉access_token
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getAccessToken")
    Result<String> getAccessToken();

    /**
     * 分页获取部门用户详情
     * @param departmentUserInfoParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getDepartUserByPage")
    Result<DepartmentUserInfoResult> getDepartUserByPage(@RequestBody @Validated DepartmentUserInfoParam departmentUserInfoParam);

    /**
     * 获取部门列表信息
     * @param departmentListParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getDepartmentList")
    Result<DepartmentListResult> getDepartmentList(@RequestBody @Validated DepartmentListParam departmentListParam);

}
