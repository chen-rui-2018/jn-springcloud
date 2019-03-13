package com.jn.oa.item.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.model.WorkPlanAdd;
import com.jn.oa.item.model.WorkPlanPage;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.item.vo.WorkPlanVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 工作计划管理
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 oa:42
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "工作计划管理")
@RestController
@RequestMapping("/oa/workPlan")
public class WorkPlanController extends BaseController {

    @Autowired
    private WorkPlanService workPlanService;

    @ControllerLog(doAction = "工作计划列表")
    @RequiresPermissions("/oa/workPlan/list")
    @ApiOperation(value = "工作计划列表", httpMethod = "POST", response = Result.class)
    @RequestMapping("/list")
    public Result list(@RequestBody WorkPlanPage workPlanPage) {
        //获取当前用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = workPlanService.list(workPlanPage,user);
        return new Result(data);
    }
}
