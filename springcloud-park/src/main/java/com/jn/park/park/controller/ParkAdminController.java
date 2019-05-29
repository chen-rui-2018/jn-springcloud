package com.jn.park.park.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.SecurityTokenParam;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    @Autowired
    private SecurityVideoClient securityVideoClient;


    @ControllerLog(doAction = "打开关键区域视频监控")
    @ApiOperation(value = "打开关键区域视频监控")
    @RequestMapping(value = "/getSecurityTokenURL",method = RequestMethod.GET)
    @RequiresPermissions(value = "/portal/park/getSecurityTokenURL")
    @ResponseBody
    public void getSecurityTokenURL(HttpServletResponse response, String id){
        SecurityTokenParam securityTokenParam=new SecurityTokenParam();
        Result<String>result=securityVideoClient.getSecurityTokenURL(securityTokenParam);
        try {
            response.sendRedirect(result.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
