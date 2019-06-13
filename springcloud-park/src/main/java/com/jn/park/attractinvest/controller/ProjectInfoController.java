package com.jn.park.attractinvest.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.attractinvest.service.ProjectInfoService;
import com.jn.park.attractinvest.vo.ProjectInfoVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 招商管理-项目管理
 *
 * @author： shaobao
 * @date： Created on 2019/6/10 9:46
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "招商管理-项目管理")
@RestController
@RequestMapping("/park/project")
public class ProjectInfoController extends BaseController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @ControllerLog(doAction = "企业入驻流程后置处理")
    @ApiOperation(value = "企业入驻流程后置处理", notes = "企业入驻流程后置处理")
    @RequestMapping(value = "/enterpriseEnterHandle", method = RequestMethod.POST)
    @RequiresPermissions("/park/project/enterpriseEnterHandle")
    public Result enterpriseEnterHandle(@Validated @RequestBody ProjectInfoVo projectInfoVo) {
        //获取当前用户
        User user=(User) SecurityUtils.getSubject().getPrincipal();

        projectInfoService.enterpriseEnterHandle(projectInfoVo,user);
        return new Result();
    }
}
