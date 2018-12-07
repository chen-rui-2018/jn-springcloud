package com.jn.activity.controller;

import com.jn.activity.service.ActivityApplyService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动报名
 * @Author: yangph
 * @Date: 2018/12/6 14:03
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动报名")
@RestController
public class ActivityApplyController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityApplyController.class);

    @Autowired
    private ActivityApplyService activityApplyService;

    @ControllerLog(doAction = "快速报名")
    @ApiOperation(value = "快速报名", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/quickApply")
    public Result quickApply(@RequestBody String id){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String account=user.getAccount();
        Result result=activityApplyService.quickApply(id,account);
        return result;
    }

    @ControllerLog(doAction = "取消报名")
    @ApiOperation(value = "取消报名", httpMethod = "POST", response = Result.class,notes = "id:活动id")
    @RequestMapping(value = "/cancelApply")
    public Result cancelApply(@RequestBody String id){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        String account=user.getAccount();
        Result result=activityApplyService.cancelApply(id,account);
        return result;
    }
}
