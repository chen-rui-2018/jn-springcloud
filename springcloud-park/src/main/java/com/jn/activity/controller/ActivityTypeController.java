package com.jn.activity.controller;

import com.github.pagehelper.PageInfo;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.model.ActivityType;
import com.jn.activity.service.ActivityTypeService;
import com.jn.activity.vo.ActivityTypeVO;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
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
 *
 * @Author: chenr
 * @Date: 2018/12/05 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "门户活动类型")
@RestController
@RequestMapping(value = "/guest/portals/activityType")
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
    public Result insertActivityType(@RequestBody Map<String, Object> model) {
        Assert.notNull(model.get("typeName"), ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY.getMessage());
        Assert.notNull(model.get("state"), ActivityExceptionEnum.ACTIVITY_TYPE_STATUS_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String typeName = model.get("typeName").toString();
        String state = model.get("state").toString();
        List<String> templateList = (List) model.get("templateList");
        activityTypeService.insertActivityType(typeName, state, templateList, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findActivityTypeList")
    public Result findActivityTypeListByState(String state, String page, String rows) {
        PageInfo activityTypeList = activityTypeService.findActivityTypeListByState(state, page, rows);
        return new Result(activityTypeList);
    }

    @ControllerLog(doAction = "展示当前活动类型")
    @ApiOperation(value = "根据ID 获取当前活动类型内容", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findActivityType")
    public Result findActivityTypeById(String typeId) {
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        ActivityType vo = activityTypeService.findActivityTypeById(typeId);
        return new Result(vo);
    }

    @ControllerLog(doAction = "编辑当前活动类型")
    @ApiOperation(value = "编辑当前活动类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateActivityType")
    public Result updateActivityType(@RequestBody Map<String, Object> model) {
        Assert.notNull(model.get("typeName"), ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY.getMessage());
        Assert.notNull(model.get("state"), ActivityExceptionEnum.ACTIVITY_TYPE_STATUS_EMPTY.getMessage());
        Assert.notNull(model.get("typeId"), ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String typeName = model.get("typeName").toString();
        String state = model.get("state").toString();
        String typeId = model.get("typeId").toString();
        List<String> templateList = (List) model.get("templateList");
        activityTypeService.updateActivityType(typeId,typeName, state, templateList, user);
        return new Result();
    }
    @ControllerLog(doAction = "删除活动类型")
    @ApiOperation(value = "删除活动类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteActivityTypeList")
    public Result deleteActivityTypeList(@RequestBody Map<String, List<String>> model){
        Assert.notNull(model.get("typeId"), ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        List<String> typeId = model.get("typeId");
        activityTypeService.deleteActivityTypeList(typeId);
        return new Result();
    }
}
