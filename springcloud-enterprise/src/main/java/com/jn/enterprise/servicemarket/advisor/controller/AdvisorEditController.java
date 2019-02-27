package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorBaseInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceExperience;
import com.jn.enterprise.servicemarket.advisor.model.ServiceHonor;
import com.jn.enterprise.servicemarket.advisor.model.ServiceProjectExperience;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/2/27 10:11
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "编辑顾问资料")
@RestController
@RequestMapping(value = "/serviceMarket/advisorEditController")
public class AdvisorEditController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorEditController.class);

    @Autowired
    private AdvisorEditService advisorEditService;

    @ControllerLog(doAction = "基本信息保存并更新")
    @ApiOperation(value = "基本信息保存并更新", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateAdvisorBaseInfo")
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorBaseInfo")
    public Result saveOrUpdateAdvisorBaseInfo(@RequestBody @Validated  AdvisorBaseInfo advisorBaseInfo){
        advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfo);
        return new Result();
    }

    @ControllerLog(doAction = "荣誉资质保存并更新")
    @ApiOperation(value = "荣誉资质保存并更新", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateAdvisorHonor")
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorHonor")
    public Result saveOrUpdateAdvisorHonor(@RequestBody @Validated ServiceHonor serviceHonor){
        advisorEditService.saveOrUpdateAdvisorHonor(serviceHonor);
        return new Result();
    }


    @ControllerLog(doAction = "服务经历保存并更新")
    @ApiOperation(value = "服务经历保存并更新", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateAdvisorExperience")
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorExperience")
    public Result saveOrUpdateAdvisorExperience(@RequestBody @Validated ServiceExperience serviceExperience){
        advisorEditService.saveOrUpdateAdvisorExperience(serviceExperience);
        return new Result();
    }

    @ControllerLog(doAction = "项目经验保存并更新")
    @ApiOperation(value = "项目经验保存并更新", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateAdvisorProjectExperience")
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorProjectExperience")
    public Result saveOrUpdateAdvisorProjectExperience(@RequestBody @Validated ServiceProjectExperience serviceProjectExperience){
        advisorEditService.saveOrUpdateAdvisorProjectExperience(serviceProjectExperience);
        return new Result();
    }

}
