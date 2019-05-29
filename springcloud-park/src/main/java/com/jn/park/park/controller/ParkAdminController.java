package com.jn.park.park.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.SecurityTokenParam;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Api(tags = "园区管理-后台")
@RestController
@RequestMapping(value="/portal/park")
public class ParkAdminController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(ParkAdminController.class);
    @Autowired
    private SecurityVideoClient securityVideoClient;


    @ControllerLog(doAction = "打开关键区域视频监控")
    @ApiOperation(value = "打开关键区域视频监控")
    @RequestMapping(value = "/getSecurityTokenURL",method = RequestMethod.GET)
    @RequiresPermissions(value = "/portal/park/getSecurityTokenURL")
    @ResponseBody
    public void getSecurityTokenURL(HttpServletResponse response){
        SecurityTokenParam securityTokenParam=new SecurityTokenParam();
        logger.info("获取视频监控地址 接口 请求参数：{}",logger);
        Result<String>result=securityVideoClient.getSecurityTokenURL(securityTokenParam);
        logger.info("获取视频监控地址 接口 返回参数:{}",result);
        try {
            response.sendRedirect(result.getData());
        } catch (IOException e) {
           logger.info("获取视频监控地址失败",e);
        }
    }

}
