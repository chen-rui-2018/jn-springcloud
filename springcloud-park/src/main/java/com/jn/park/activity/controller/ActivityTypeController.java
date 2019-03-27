package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityType;
import com.jn.park.model.ActivityTypeAdd;
import com.jn.park.model.ActivityTypeQuery;
import com.jn.park.model.ActivityTypeUpdate;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityTypeController.class);

    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "增加活动类型")
    @ApiOperation(value = "增加活动类型")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @RequiresPermissions("/activity/activityType/add")
    public Result insertActivityType( @Valid @RequestBody  ActivityTypeAdd activityTypeAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityTypeService.insertActivityType(activityTypeAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "分页查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表")
    @RequestMapping(value = "/findActivityTypeList",method = RequestMethod.POST)
    @RequiresPermissions("/activity/activityType/findActivityTypeList" )
    public Result<PaginationData<List<ActivityType>>> findActivityTypeListByStatus(@RequestBody  ActivityTypeQuery activityTypeQuery) {
        PaginationData<List<ActivityType>> activityTypeList = activityTypeService.findActivityTypeListByState(activityTypeQuery,Boolean.TRUE);
        return new Result<>(activityTypeList);
    }

    @ControllerLog(doAction = "展示当前活动类型")
    @ApiOperation(value = "根据ID 获取当前活动类型内容")
    @RequestMapping(value = "/findActivityType",method = RequestMethod.POST)
    @RequiresPermissions("/activity/activityType/findActivityType")
    public Result<ActivityType> findActivityTypeById(@ApiParam(name = "typeId", value = "活动类型ID", required = true) @RequestParam(value = "typeId") String typeId) {
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        ActivityType vo = activityTypeService.findActivityTypeById(typeId);
        return new Result<>(vo);
    }

    @ControllerLog(doAction = "编辑当前活动类型")
    @ApiOperation(value = "编辑当前活动类型")
    @RequestMapping(value = "/updateActivityType",method = RequestMethod.POST)
    @RequiresPermissions("/activity/activityType/updateActivityType")
    public Result updateActivityType( @Validated  @RequestBody ActivityTypeUpdate activityTypeUpdate) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityTypeService.updateActivityType(activityTypeUpdate, user);
        return new Result();
    }

    @ControllerLog(doAction = "删除活动类型")
    @ApiOperation(value = "删除活动类型", notes = "可进行批量删除")
    @RequestMapping(value = "/deleteActivityTypeList",method = RequestMethod.POST)
    @RequiresPermissions("/activity/activityType/deleteActivityTypeList")
    public Result deleteActivityTypeList(@ApiParam(name = "typeId", value = "活动类型ID 数组", required = true) @RequestParam(value = "typeId") String[] typeId) {
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        activityTypeService.deleteActivityTypeList(typeId);
        return new Result();
    }
}
