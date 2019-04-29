package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivityParment;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.api.ActivityClient;
import com.jn.park.api.PolicyCenterClient;
import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.model.PolicyCenterHomeShow;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 政策中心 内部使用API接口
 * @Author: huxw
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */

@RestController
public class PolicyServerController extends BaseController implements PolicyCenterClient {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PolicyServerController.class);

    @Autowired
    private PolicyCenterService policyCenterService;

    @ControllerLog(doAction = "获取政策中心首页列表")
    @Override
    public Result<PaginationData<List<PolicyCenterHomeShow>>> getPolicyList(@RequestBody @Validated PolicyCenterHomeParam policyCenterHomeParam) {
        PaginationData policyCenterList = policyCenterService.getPolicyCenterList(policyCenterHomeParam);
        return new Result(policyCenterList);
    }
}
