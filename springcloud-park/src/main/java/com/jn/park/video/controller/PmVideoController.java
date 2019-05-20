package com.jn.park.video.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.video.service.PmVideoService;
import com.jn.park.video.vo.PmVideoVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 安防录像申请管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/5/18 16:11
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "安防录像申请管理")
@RestController
@RequestMapping("/park/video")
public class PmVideoController extends BaseController {

    @Autowired
    private PmVideoService pmVideoService;

    @ControllerLog(doAction = "物业-安防录像申请赋权处理")
    @PostMapping(path = "/pmVideoApplyHandler")
    @ApiOperation(value = "物业-安防录像申请赋权处理",notes = "返回赋权处理结果,正常结果为1")
    @RequiresPermissions("/park/video/pmVideoApplyHandler")
    public Result<Integer> pmVideoApplyHandler(@RequestBody  PmVideoVo pmVideoVo){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer num = pmVideoService.pmVideoApplyHandler(pmVideoVo,user);
        return new Result(num);
    }
}
