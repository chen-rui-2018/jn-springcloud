package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityType;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动类型管理
 *
 * @Author: chenr
 * @Date: 2018/12/05 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动类型管理")
@RestController
@RequestMapping(value = "/activity/activityType")
public class ActivityTypeController extends BaseController {
    //todo:待权限系统完成添加权限注解,由陈蕊添加
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityTypeController.class);

    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "增加活动类型")
    @ApiOperation(value = "增加活动类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result insertActivityType(@ApiParam(name = "typeName", value = "活动名称(最大长度20个中文)", required = true) @RequestParam String typeName,
                                     @ApiParam(name = "state", value = "活动类型状态(0:无效,1:有效)", required = true) @RequestParam String state,
                                     @ApiParam(name = "templateList", value = "模板列表(多个使用逗号','分隔)") @RequestParam(required = false) String templateList) {
        Assert.notNull(typeName, ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY.getMessage());
        Assert.notNull(state, ActivityExceptionEnum.ACTIVITY_TYPE_STATUS_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityTypeService.insertActivityType(typeName, state, templateList, user);
        return new Result();
    }

    @ControllerLog(doAction = "分页查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findActivityTypeList")
    public Result findActivityTypeListByState(@ApiParam(name = "state", value = "活动类型状态(0:无效,1:有效,不输入:全部)") @RequestParam(required = false) String state,
                                              @ApiParam(name = "page", value = "页码") @RequestParam(required = false) Integer page,
                                              @ApiParam(name = "rows", value = "每页显示数量") @RequestParam(required = false) Integer rows) {
        PaginationData activityTypeList = activityTypeService.findActivityTypeListByState(state, page, rows, true);
        return new Result(activityTypeList);
    }

    @ControllerLog(doAction = "展示当前活动类型")
    @ApiOperation(value = "根据ID 获取当前活动类型内容", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findActivityType")
    public Result findActivityTypeById(@ApiParam(name = "typeId", value = "活动类型ID", required = true) @RequestParam String typeId) {
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        ActivityType vo = activityTypeService.findActivityTypeById(typeId);
        return new Result(vo);
    }

    @ControllerLog(doAction = "编辑当前活动类型")
    @ApiOperation(value = "编辑当前活动类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateActivityType")
    public Result updateActivityType(@ApiParam(name = "typeId", value = "活动类型ID", required = true) @RequestParam String typeId,
                                     @ApiParam(name = "typeName", value = "活动名称(最大长度20个中文)", required = true) @RequestParam String typeName,
                                     @ApiParam(name = "state", value = "活动类型状态(0:无效,1:有效)", required = true) @RequestParam String state,
                                     @ApiParam(name = "templateList", value = "模板列表(多个使用逗号','分隔)") @RequestParam(required = false) String templateList) {
        Assert.notNull(typeName, ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY.getMessage());
        Assert.notNull(state, ActivityExceptionEnum.ACTIVITY_TYPE_STATUS_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityTypeService.updateActivityType(typeId, typeName, state, templateList, user);
        return new Result();
    }

    @ControllerLog(doAction = "删除活动类型")
    @ApiOperation(value = "删除活动类型", httpMethod = "POST", response = Result.class, notes = "可进行批量删除")
    @RequestMapping(value = "/deleteActivityTypeList")
    public Result deleteActivityTypeList(@ApiParam(name = "typeId", value = "活动类型ID(多个id时使用逗号','分隔)", required = true) @RequestParam String typeId) {
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        activityTypeService.deleteActivityTypeList(typeId);
        return new Result();
    }
}
