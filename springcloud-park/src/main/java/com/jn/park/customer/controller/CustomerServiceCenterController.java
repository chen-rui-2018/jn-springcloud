package com.jn.park.customer.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.customer.model.ConsultationCustomerListParam;
import com.jn.park.customer.model.ConsultationCustomerListShow;
import com.jn.park.customer.model.OnlineCustomerParam;
import com.jn.park.customer.model.ServiceModuleShow;
import com.jn.park.customer.service.CustomerServiceCenterService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/14 9:18
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "客服中心")
@RestController
@RequestMapping("/customer/customerServiceCenterController")
public class CustomerServiceCenterController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterController.class);

    @Autowired
    private CustomerServiceCenterService customerServiceCenterService;

    @ControllerLog(doAction = "园区用户咨询客服")
    @ApiOperation(value = "园区用户咨询客服")
    @RequiresPermissions("/customer/customerServiceCenterController/consultationCustomerList")
    @RequestMapping(value = "/consultationCustomerList",method = RequestMethod.GET)
    public Result<PaginationData<List<ConsultationCustomerListShow>>> consultationCustomerList(@Validated ConsultationCustomerListParam consultationCustomerListParam) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("园区用户咨询客服获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        PaginationData result=customerServiceCenterService.consultationCustomerList(consultationCustomerListParam,user.getAccount());
        return new Result<>(result);
    }

    @ControllerLog(doAction = "用户问题详情")
    @ApiOperation(value = "用户问题详情")
    @RequiresPermissions("/customer/customerServiceCenterController/customerQuesDetail")
    @RequestMapping(value = "/customerQuesDetail",method = RequestMethod.GET)
    public Result customerQuesDetail(@ApiParam(name="processInsId",value = "流程实例Id",required = true,example = "f5c95f9adf714aedab3739cbc9297178")
                                         @RequestParam(value = "processInsId") String processInsId) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户问题详情获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        Object obj=customerServiceCenterService.customerQuesDetail(user.getAccount(),processInsId);
        return new Result<>(obj);
    }

    @ControllerLog(doAction = "服务模块信息")
    @ApiOperation(value = "服务模块信息")
    @RequiresPermissions("/customer/customerServiceCenterController/serviceModules")
    @RequestMapping(value = "/serviceModules",method = RequestMethod.GET)
    public Result<List<ServiceModuleShow>> serviceModules() {
        return new Result<>(customerServiceCenterService.serviceModules());
    }

    @ControllerLog(doAction = "在线客服")
    @ApiOperation(value = "在线客服",notes = "返回数据响应条数，正常为1")
    @RequiresPermissions("/customer/customerServiceCenterController/onlineCustomerService")
    @RequestMapping(value = "/onlineCustomerService",method = RequestMethod.POST)
    public Result<Integer> onlineCustomerService(@RequestBody @Validated OnlineCustomerParam onlineCustomerParam) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户问题详情获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int reqNum=customerServiceCenterService.onlineCustomerService(onlineCustomerParam,user.getAccount());
        logger.info("-----在线客服数据响应条数：{}------",reqNum);
        return new Result<>(reqNum);
    }

}
