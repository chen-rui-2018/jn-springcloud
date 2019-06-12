package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.ActivityApplyListParam;
import com.jn.park.activity.model.CompanyActivityApplyParam;
import com.jn.park.activity.model.CompanyActivityApplyShow;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.api.ActivityClient;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
public class ActivityServerController extends BaseController implements ActivityClient{
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityServerController.class);

    @Autowired
    private ActivityService activityService;
    
    @ControllerLog(doAction = "获取有效活动总数")
    @Override
    public Result<String> getActivityNum(){
        return new Result<>(activityService.getActivityNum());
    }

    @Override
    public Result<PaginationData> findActivitySuccessfulRegistration(@RequestBody ActivityApplyListParam activityApplyListParam,@RequestParam("needPage") Boolean needPage) {
        return new Result<PaginationData>(activityService.findActivitySuccessfulRegistration(activityApplyListParam,needPage));
    }

    @ControllerLog(doAction = "获取企业报报名活动信息")
    public Result<List<CompanyActivityApplyShow>> getCompanyActivityApplyInfo(@RequestBody CompanyActivityApplyParam param) {
        logger.info("进入获取企业报报名活动信息API,入参：{}",param.toString());
        return new Result(activityService.getCompanyActivityApplyInfo(param));
    }

    @ControllerLog(doAction = "获取举办活动总数")
    public Result<Integer> getActivityHistoryNum(){
        return new Result(activityService.getActivityHistoryNum());
    }
}
