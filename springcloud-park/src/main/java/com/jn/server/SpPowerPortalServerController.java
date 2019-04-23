package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.SpPowerPortalClient;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.park.spPower.model.SpAdModel;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 活动 内部使用API接口
 * @Author: jiangyl
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */

@RestController
@RequestMapping("/api/sp/power")
public class SpPowerPortalServerController extends BaseController implements SpPowerPortalClient {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(SpPowerPortalServerController.class);

    @Autowired
    private SpPowerPortalService spPowerPortalService;

    @ControllerLog(doAction = "获取行政审批宣传图列表")
    @ApiOperation(value = "获取行政审批宣传图列表", notes = "获取行政审批宣传图列表")
    @RequestMapping(value = "/getAdvertising")
    @Override
    public Result<List<SpAdModel>> getAdvertising() {
        return new Result(spPowerPortalService.getAdvertising());
    }
}
