package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.ding.service.DingTalkBaseService;
import com.jn.hardware.ding.service.DingTalkDepartmentService;
import com.jn.hardware.ding.service.DingTalkUserService;
import com.jn.hardware.model.dingtalk.BaseResult;
import com.jn.hardware.model.dingtalk.user.DepartmentListParam;
import com.jn.hardware.model.dingtalk.user.DepartmentListResult;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 钉钉：内部接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:57
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class DingTalkController implements DingTalkClient {

    @Autowired
    private DingTalkBaseService dingTalkBaseService;
    @Autowired
    private DingTalkUserService dingTalkUserService;
    @Autowired
    private DingTalkDepartmentService dingTalkDepartmentService;
    /**
     * 强制获取access_token
     * @return
     */
    @Override
    public Result<String> getAccessToken() {
        return new Result(dingTalkBaseService.getAccessToken());
    }

    @Override
    public Result<DepartmentUserInfoResult> getDepartUserByPage(@RequestBody DepartmentUserInfoParam departmentUserInfoParam) {
        Result<DepartmentUserInfoResult> result = new Result<>();
        DepartmentUserInfoResult departmentUserInfoResult = dingTalkUserService.getDepartUserByPage(departmentUserInfoParam);
        if(!BaseResult.SUCCESS_CODE.equals(departmentUserInfoResult.getErrcode())) {
            result.setCode(departmentUserInfoResult.getErrcode());
            result.setResult(departmentUserInfoResult.getErrmsg());
        }
        result.setData(departmentUserInfoResult);
        return result;
    }

    @Override
    public Result<DepartmentListResult> getDepartmentList(@RequestBody DepartmentListParam departmentListParam) {
        Result<DepartmentListResult> result = new Result<>();
        DepartmentListResult departmentListResult = dingTalkDepartmentService.getDepartmentList(departmentListParam);
        if(!BaseResult.SUCCESS_CODE.equals(departmentListResult.getErrcode())) {
            result.setCode(departmentListResult.getErrcode());
            result.setResult(departmentListResult.getErrmsg());
        }
        result.setData(departmentListResult);
        return result;
    }
}
