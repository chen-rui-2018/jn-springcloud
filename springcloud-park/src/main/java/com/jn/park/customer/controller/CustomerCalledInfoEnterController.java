package com.jn.park.customer.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.customer.model.UserIntroInfo;
import com.jn.park.customer.service.CustomerServiceCenterManageService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/5/21 21:36
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "客服中心--园区客服中心")
@RestController
@RequestMapping("/guest/customer/customerCalledInfoEnterController")
public class CustomerCalledInfoEnterController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterManageController.class);

    @Autowired
    private CustomerServiceCenterManageService manageService;


    @ControllerLog(doAction = "根据手机号获取用户信息")
    @ApiOperation(value = "根据手机号获取用户信息")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public Result<UserIntroInfo> getUserInfo(@ApiParam(name="phone",value = "来电用户电话",required = true,example = "18088888888")
                                       @RequestParam(value = "phone") String phone) {
        return new Result(manageService.getUserInfo(phone));
    }
}
