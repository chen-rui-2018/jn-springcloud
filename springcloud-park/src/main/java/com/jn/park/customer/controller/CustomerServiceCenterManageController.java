package com.jn.park.customer.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.customer.model.IBPSCompleteCustomerParam;
import com.jn.park.customer.model.IBPSOnlineCustomerForm;
import com.jn.park.customer.model.MyTasksParam;
import com.jn.park.customer.service.CustomerServiceCenterManageService;
import com.jn.park.enums.CustomerCenterExceptionEnum;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @Author: yangph
 * @Date: 2019/5/19 16:03
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "客服中心--园区客服中心")
@RestController
@RequestMapping("/customer/customerServiceCenterManageController")
public class CustomerServiceCenterManageController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterManageController.class);

    @Autowired
    private CustomerServiceCenterManageService manageService;

    @ControllerLog(doAction = "我的待办事项")
    @ApiOperation(value = "我的待办事项")
    @RequiresPermissions("/customer/customerServiceCenterManageController/myTasks")
    @RequestMapping(value = "/myTasks",method = RequestMethod.GET)
    public Result<PaginationData> myTasks(@Valid MyTasksParam myTasksParam) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("我的待办事项获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        PaginationData paginationData = manageService.myTasks(myTasksParam, user.getAccount());
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "我的已办事项")
    @ApiOperation(value = "我的已办事项")
    @RequiresPermissions("/customer/customerServiceCenterManageController/myHandled")
    @RequestMapping(value = "/myHandled",method = RequestMethod.GET)
    public Result<PaginationData> myHandled(@Valid MyTasksParam myTasksParam) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("我的已办事项获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        PaginationData paginationData = manageService.myHandled(myTasksParam, user.getAccount());
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "获取流程表单")
    @ApiOperation(value = "获取流程表单")
    @RequiresPermissions("/customer/customerServiceCenterManageController/getInstForm")
    @RequestMapping(value = "/getInstForm",method = RequestMethod.GET)
    public Result<IBPSOnlineCustomerForm> getInstForm(@ApiParam(name="processInsId",value = "流程实例Id",required = true,example = "f5c95f9adf714aedab3739cbc9297178")
                                                  @RequestParam(value = "processInsId") String processInsId) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("流程表单获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return new Result(manageService.getInstForm(processInsId, user.getAccount()));
    }

    @ControllerLog(doAction = "问题处理")
    @ApiOperation(value = "问题处理")
    @RequiresPermissions("/customer/customerServiceCenterManageController/complete")
    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public Result<Integer> complete(@RequestBody @Valid IBPSCompleteCustomerParam ibpsCompleteCustomerParam) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("处理任务获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int resNum=manageService.complete(ibpsCompleteCustomerParam,user.getAccount());
        return new Result(resNum);
    }
}
