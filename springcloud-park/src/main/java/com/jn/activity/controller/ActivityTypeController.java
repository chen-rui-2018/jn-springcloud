package com.jn.activity.controller;

import com.github.pagehelper.PageInfo;
import com.jn.activity.service.ActivityTypeService;
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

import java.util.List;
import java.util.Map;

/**
 * 活动类型
 * @Author: chenr
 * @Date: 2018/12/05 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "门户活动类型")
@RestController
@RequestMapping(value = "/portals/activityType")
public class ActivityTypeController extends BaseController {
    /**
     * 日志组件
     */

    private static Logger logger = LoggerFactory.getLogger(ActivityTypeController.class);

    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "增加活动类型")
    @ApiOperation(value = "增加活动类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result insertActivityType(@RequestBody Map<String,Object> model){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        String typeName = model.get("typeName").toString();
        String state = model.get("state").toString();
        List<String> templateList = (List) model.get("templateList");
        activityTypeService.insertActivityType(typeName,state,templateList,user);
        return new Result();
    }
    @ControllerLog(doAction = "查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findActivityTypeList")
    public Result findActivityTypeListByState(String state, String page, String rows){
      PageInfo activityTypeList =  activityTypeService.findActivityTypeListByState(state,page,rows);
      return new Result(activityTypeList);
    }
    @ControllerLog(doAction = "展示当前活动类型")
    @ApiOperation(value = "根据Id 展示当前活动类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value="/findActivityType")
    public Result findActivityTypeById(@RequestBody  String typeId){
        //Todo 下午完成service + dao
        return new Result();
    }

}
