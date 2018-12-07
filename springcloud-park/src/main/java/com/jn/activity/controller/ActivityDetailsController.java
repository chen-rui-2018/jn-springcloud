package com.jn.activity.controller;

import com.jn.activity.service.ActivityDetailsService;
import com.jn.activity.vo.ActivityDetailVO;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:07
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动详情")
@RestController
public class ActivityDetailsController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityDetailsController.class);

    @Autowired
    private ActivityDetailsService activityDetailsService;

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class,notes = "id:活动id")
    @RequestMapping(value = "/getActivityDetails")
    public Result getActivityDetails(@RequestBody String id){
        Result result=activityDetailsService.getActivityDetails(id);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode()) || result.getData()==null) {
            return result;
        }
        ActivityDetailVO activityDetailVO= new ActivityDetailVO();
        BeanUtils.copyProperties(result.getData(), activityDetailVO);
        result.setData(activityDetailVO);
        return result;
    }


}
