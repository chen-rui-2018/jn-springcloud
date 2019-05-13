package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
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
 * @Date: 2019/2/27 10:11
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户中心--角色认证--服务顾问认证--填写顾问资料")
@RestController
@RequestMapping(value = "/serviceMarket/advisorEditController")
public class AdvisorEditController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorEditController.class);

    @Autowired
    private AdvisorEditService advisorEditService;

    @Autowired
    private AdvisorService advisorService;

    @ControllerLog(doAction = "基本信息保存并更新")
    @ApiOperation(value = "基本信息保存并更新(pc/app基本资料)")
    @RequestMapping(value = "/saveOrUpdateAdvisorBaseInfo",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorBaseInfo")
    public Result saveOrUpdateAdvisorBaseInfo(@RequestBody @Validated AdvisorBaseInfoParam advisorBaseInfoParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfoParam);
        logger.info("------基本信息保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "荣誉资质保存并更新")
    @ApiOperation(value = "荣誉资质保存并更新,(pc/app资质认证)")
    @RequestMapping(value = "/saveOrUpdateAdvisorHonor",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorHonor")
    public Result saveOrUpdateAdvisorHonor(@RequestBody @Validated ServiceHonorParam serviceHonorParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorHonor(serviceHonorParam);
        logger.info("------荣誉资质保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "服务经历保存并更新")
    @ApiOperation(value = "服务经历保存并更新,(pc/app服务经历)")
    @RequestMapping(value = "/saveOrUpdateAdvisorExperience",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/advisorEditController/saveOrUpdateAdvisorExperience")
    public Result saveOrUpdateAdvisorExperience(@RequestBody @Validated ServiceExperienceParam serviceExperienceParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorExperience(serviceExperienceParam);
        logger.info("------荣誉资质保存并更新成功，数据响应条数：{}------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "项目经验保存并更新")
    @ApiOperation(value = "项目经验保存并更新(pc/app项目经验)")
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

    @ControllerLog(doAction = "服务顾问详情")
    @ApiOperation(value = "服务顾问详情 (回显顾问认证信息)",notes="根据顾问账号获取顾问详情")
    @RequiresPermissions("/serviceMarket/advisorEditController/getServiceAdvisorInfo")
    @RequestMapping(value = "/getServiceAdvisorInfo",method = RequestMethod.GET)
    public Result<AdvisorDetailsVo> getServiceAdvisorInfo(@ApiParam(value = "顾问账号" ,required = true,example = "wangsong")@RequestParam("advisorAccount") String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户提需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        //判断当前登录用户是否为顾问
        advisorEditService.currentUserIsAdvisor(user.getAccount());
        AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount, ApprovalStatusEnum.APPROVAL.getValue());
        return  new Result(advisorDetailsVo);
    }

   //todo:顾问认证页面提交审批，修改状态（未反馈》》待审批）为待审批
}
