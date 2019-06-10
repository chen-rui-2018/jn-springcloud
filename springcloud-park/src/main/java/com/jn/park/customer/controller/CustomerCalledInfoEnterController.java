package com.jn.park.customer.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.customer.model.*;
import com.jn.park.customer.service.CustomerServiceCenterManageService;
import com.jn.park.customer.service.CustomerServiceCenterService;
import com.jn.park.customer.vo.CustomerServiceCenterDetailVo;
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
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/21 21:36
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "客服中心--园区客服中心")
@RestController
@RequestMapping("/customer/customerCalledInfoEnterController")
public class CustomerCalledInfoEnterController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterManageController.class);

    @Autowired
    private CustomerServiceCenterManageService manageService;

    @Autowired
    private CustomerServiceCenterService customerServiceCenterService;


    @ControllerLog(doAction = "根据手机号获取用户信息")
    @ApiOperation(value = "根据手机号获取用户信息")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/getUserInfo")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public Result<UserIntroInfo> getUserInfo(@ApiParam(name="phone",value = "来电用户电话",required = true,example = "18088888888")
                                       @RequestParam(value = "phone") String phone) {
        return new Result(manageService.getUserInfo(phone));
    }

    @ControllerLog(doAction = "获取服务模块信息")
    @ApiOperation(value = "获取服务模块信息")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/serviceModules")
    @RequestMapping(value = "/serviceModules",method = RequestMethod.GET)
    public Result<List<ServiceModuleShow>> serviceModules() {
        return new Result<>(customerServiceCenterService.serviceModules());
    }

    @ControllerLog(doAction = "获取登录用户信息")
    @ApiOperation(value = "获取登录用户信息")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/getBaseUserInfo")
    @RequestMapping(value = "/getBaseUserInfo",method = RequestMethod.GET)
    public Result<User> getUserInfo() {
        //获取当前登录用户基本信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        logger.info("-----客服中心获取用户登录信息------，user:{}",user.toString());
        return new Result<>((User) SecurityUtils.getSubject().getPrincipal());
    }

    @ControllerLog(doAction = "获取来电用户问题历史")
    @ApiOperation(value = "获取来电用户问题历史")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/getCalledHistory")
    @RequestMapping(value = "/getCalledHistory",method = RequestMethod.GET)
    public Result<PaginationData<List<ConsultationCustomerListShow>>> getCalledHistory(@ApiParam(name="phone",value = "来电用户电话",required = true,example = "18088888888")
                                                                                           @RequestParam(value = "phone") String phone) {
        PaginationData result=manageService.getCalledHistory(phone);
        return new Result<>(result);
    }

    @ControllerLog(doAction = "保存来电录入信息")
    @ApiOperation(value = "保存来电录入信息")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/saveCalledInfo")
    @RequestMapping(value = "/saveCalledInfo",method = RequestMethod.POST)
    public Result<Integer> saveCalledInfo(@RequestBody @Valid CalledInfoParam calledInfoParam) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("保存来电录入信息获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int resNum=manageService.saveCalledInfo(calledInfoParam,user.getAccount());
        return new Result(resNum);
    }

    @ControllerLog(doAction = "来电归属地查询")
    @ApiOperation(value = "来电归属地查询")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/getPhoneCalledOwen")
    @RequestMapping(value = "/getPhoneCalledOwen",method = RequestMethod.GET)
    public Result<String> getPhoneCalledOwen(@ApiParam(name="phone",value = "来电用户电话",required = true,example = "18088888888")
                                                                                       @RequestParam(value = "phone") String phone) {
        return new Result<>(manageService.getPhoneCalledOwen(phone));
    }


    @ControllerLog(doAction = "用户问题详情")
    @ApiOperation(value = "用户问题详情")
    @RequiresPermissions("/customer/customerCalledInfoEnterController/customerQuesDetail")
    @RequestMapping(value = "/customerQuesDetail",method = RequestMethod.GET)
    public Result<CustomerServiceCenterDetailVo> customerQuesDetail(@ApiParam(name="processInsId",value = "流程实例Id",required = true,example = "f5c95f9adf714aedab3739cbc9297178")
                                                                    @RequestParam(value = "processInsId") String processInsId) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("来电录入用户问题详情获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return new Result<>(customerServiceCenterService.customerQuesDetail(user.getAccount(), processInsId));
    }
}
