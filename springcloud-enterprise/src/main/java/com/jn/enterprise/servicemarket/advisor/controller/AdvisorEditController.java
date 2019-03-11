package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceCertificateType;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorBaseInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceExperienceParam;
import com.jn.enterprise.servicemarket.advisor.model.ServiceHonorParam;
import com.jn.enterprise.servicemarket.advisor.model.ServiceProjectExperienceParam;
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

import java.util.List;

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
    public Result saveOrUpdateAdvisorHonor(@RequestBody @Validated ServiceHonorParam serviceHonorParam){
        advisorEditService.saveOrUpdateAdvisorHonor(serviceHonorParam);
        return new Result();
    }


    @ControllerLog(doAction = "服务经历保存并更新")
    @ApiOperation(value = "服务经历保存并更新", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateAdvisorExperience")
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorExperience")
    public Result saveOrUpdateAdvisorExperience(@RequestBody @Validated ServiceExperienceParam serviceExperienceParam){
        advisorEditService.saveOrUpdateAdvisorExperience(serviceExperienceParam);
        return new Result();
    }

    @ControllerLog(doAction = "项目经验保存并更新")
    @ApiOperation(value = "项目经验保存并更新", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateAdvisorProjectExperience")
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorProjectExperience")
    public Result saveOrUpdateAdvisorProjectExperience(@RequestBody @Validated ServiceProjectExperienceParam serviceProjectExperienceParam){
        advisorEditService.saveOrUpdateAdvisorProjectExperience(serviceProjectExperienceParam);
        return new Result();
    }

    @ControllerLog(doAction = "获取指定证件类型")
    @ApiOperation(value = "获取指定证件类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCertificateTypeList")
    @RequiresPermissions("/serviceMarket/advisorEditController/getCertificateTypeList")
    public Result<List<TbServiceCertificateType>> getCertificateTypeList(){
        //证件类型分类 荣誉资质：honor
        String certificateType="honor";
        List<TbServiceCertificateType> certificateTypeList = advisorEditService.getCertificateTypeList(certificateType);
        return new Result(certificateTypeList);
    }

}
