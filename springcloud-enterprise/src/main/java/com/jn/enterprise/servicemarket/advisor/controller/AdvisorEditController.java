package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.advisor.model.*;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
    @ApiOperation(value = "基本信息保存并更新")
    @RequestMapping(value = "/saveOrUpdateAdvisorBaseInfo",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorBaseInfo")
    public Result saveOrUpdateAdvisorBaseInfo(@RequestBody @Validated AdvisorBaseInfoParam advisorBaseInfoParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfoParam);
        logger.info("------基本信息保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "荣誉资质保存并更新")
    @ApiOperation(value = "荣誉资质保存并更新")
    @RequestMapping(value = "/saveOrUpdateAdvisorHonor",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorHonor")
    public Result saveOrUpdateAdvisorHonor(@RequestBody @Validated ServiceHonorParam serviceHonorParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorHonor(serviceHonorParam);
        logger.info("------荣誉资质保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "服务经历保存并更新")
    @ApiOperation(value = "服务经历保存并更新")
    @RequestMapping(value = "/saveOrUpdateAdvisorExperience",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorExperience")
    public Result saveOrUpdateAdvisorExperience(@RequestBody @Validated ServiceExperienceParam serviceExperienceParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorExperience(serviceExperienceParam);
        logger.info("------荣誉资质保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "项目经验保存并更新")
    @ApiOperation(value = "项目经验保存并更新")
    @RequestMapping(value = "/saveOrUpdateAdvisorProjectExperience",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorProjectExperience")
    public Result saveOrUpdateAdvisorProjectExperience(@RequestBody @Validated ServiceProjectExperienceParam serviceProjectExperienceParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorProjectExperience(serviceProjectExperienceParam);
        logger.info("------荣誉资质保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "获取指定证件类型")
    @ApiOperation(value = "获取指定证件类型")
    @RequestMapping(value = "/getCertificateTypeList",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/advisorEditController/getCertificateTypeList")
    public Result<List<AdvisorCertificateTypeShow>> getCertificateTypeList(){
        //证件类型分类 荣誉资质：honor
        String certificateType="honor";
        List<AdvisorCertificateTypeShow> certificateTypeList = advisorEditService.getCertificateTypeList(certificateType);
        return new Result(certificateTypeList);
    }

}
