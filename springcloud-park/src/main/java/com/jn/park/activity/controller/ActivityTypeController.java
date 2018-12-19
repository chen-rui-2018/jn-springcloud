package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.ActivityType;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 活动类型
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
    //todo:待权限系统完成添加权限注解
    /**
     * 日志组件
     */

    private static Logger logger = LoggerFactory.getLogger(ActivityTypeController.class);

    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "增加活动类型")
    @ApiOperation(value = "增加活动类型", httpMethod = "POST", response = Result.class,
    notes = "参数:typeName-活动类型名称(长度不大于20个中文),state-活动类型状态(0:无效,1:有效),templateList-模板列表,多个模板时使用逗号分隔")
    @RequestMapping(value = "/add")
    public Result insertActivityType( String typeName,String state,String templateList) {
        Assert.notNull(typeName, ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY.getMessage());
        Assert.notNull(state, ActivityExceptionEnum.ACTIVITY_TYPE_STATUS_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityTypeService.insertActivityType(typeName, state, templateList, user);
        return new Result();
    }

    @ControllerLog(doAction = "分页查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class,
    notes = "参数:state-活动状态(0:无效,1:有效),page-分页参数(表示第几页,不传则默认返回第一页),rows-分页参数(表示一页的数据条数,不传值则默认返回第一页,15条数据)")
    @RequestMapping(value = "/findActivityTypeList")
    public Result findActivityTypeListByState(String state,   Page page) {
        PaginationData activityTypeList = activityTypeService.findActivityTypeListByState(state,page);
        return new Result(activityTypeList);
    }

    @ControllerLog(doAction = "展示当前活动类型")
    @ApiOperation(value = "根据ID 获取当前活动类型内容", httpMethod = "POST", response = Result.class,
    notes ="参数:活动类型的ID")
    @RequestMapping(value = "/findActivityType")
    public Result findActivityTypeById(String typeId) {
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        ActivityType vo = activityTypeService.findActivityTypeById(typeId);
        return new Result(vo);
    }

    @ControllerLog(doAction = "编辑当前活动类型")
    @ApiOperation(value = "编辑当前活动类型", httpMethod = "POST", response = Result.class,
    notes = "参数:typeName-活动类型名称(长度不大于20个中文),state-活动类型状态(0:无效,1:有效--不可将已关联活动的类型改为无效),templateList-模板列表,多个模板时使用逗号分隔")
    @RequestMapping(value = "/updateActivityType")
    public Result updateActivityType(String typeId,String typeName,String state,String templateList) {
        Assert.notNull(typeName, ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY.getMessage());
        Assert.notNull(state, ActivityExceptionEnum.ACTIVITY_TYPE_STATUS_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityTypeService.updateActivityType(typeId,typeName, state, templateList, user);
        return new Result();
    }
    @ControllerLog(doAction = "删除活动类型")
    @ApiOperation(value = "删除活动类型", httpMethod = "POST", response = Result.class,
    notes = "根据活动类型ID对活动类型进行逻辑删除,多个时使用逗号分隔;不可将已关联活动的类型进行删除")
    @RequestMapping(value = "/deleteActivityTypeList")
    public Result deleteActivityTypeList(String typeId){
        Assert.notNull(typeId, ActivityExceptionEnum.ACTIVITY_TYPE_ID_EMPTY.getMessage());
        activityTypeService.deleteActivityTypeList(typeId);
        return new Result();
    }
    @ControllerLog(doAction = "查询所有活动类型列表")
    @ApiOperation(value = "查询所有活动类型列表", httpMethod = "POST", response = Result.class,
            notes = "返回所有活动类型")
    @RequestMapping(value = "/findAllActivityType")
    public Result findAllActivityType() {
        List<ActivityType>  activityTypeList = activityTypeService.findAllActivityType();
        return new Result(activityTypeList);
    }
}
