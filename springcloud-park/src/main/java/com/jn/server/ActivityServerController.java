package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivityParment;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.api.ActivityClient;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import com.jn.user.model.UserInfoQueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
public class ActivityServerController extends BaseController implements ActivityClient{
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityServerController.class);

    @Autowired
    private ActivityService activityService;

    @ControllerLog(doAction = "获取活动列表")
    @ApiOperation(value = "获取活动列表",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/getActivityList")
    @Override
    public Result<PaginationData<List<Activity>>> getActivityList(@RequestBody @Validated ActivityParment activityParment) {
        PaginationData<List<Activity>> paginationData = activityService.selectActivityList(activityParment);
        return new Result<>(paginationData);
    }
    
    @ControllerLog(doAction = "获取有效活动总数")
    @Override
    public Result<String> getActivityNum(){
        return new Result<>(activityService.getActivityNum());
    }
}
