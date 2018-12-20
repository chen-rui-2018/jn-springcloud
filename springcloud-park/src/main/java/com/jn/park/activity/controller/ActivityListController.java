package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台活动列表和活动类型列表
 *
 * @Author: chenr
 * @Date: 2018/12/20 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "前台活动列表和活动类型列表")
@RestController
public class ActivityListController extends BaseController {
    /**
     * 日志组件
     */

    private static Logger logger = LoggerFactory.getLogger(ActivityListController.class);

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "前台获取简单活动列表")
    @ApiOperation(value = "前台获取简单活动列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/activityListSlim")
    public Result activityListSlim(@ApiParam(name="typeId",value="活动类型ID") @RequestParam(required = false)String typeId,
                                   @ApiParam(name="keyWord",value="关键字(活动标题/地点/内容)") @RequestParam(required = false)String keyWord,
                                   @ApiParam(name="page",value="页码") @RequestParam(required = false) Integer page,
                                   @ApiParam(name="rows",value="每页显示数量") @RequestParam(required = false) Integer rows ) {
        PaginationData paginationData = activityService.activityListSlim(typeId,page,rows,keyWord);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class,notes="作为活动的查询条件")
    @RequestMapping(value = "/guest/findActivityTypeList")
    public Result findActivityTypeListByState() {
        //只返回有效活动类型
        String state = "1";
        int page = 0;
        int rows =  0;
        PaginationData  activityTypeList = activityTypeService.findActivityTypeListByState(state,page,rows,false);
        return new Result(activityTypeList);
    }


}
