package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorBaseInfoParam;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementPortalParam;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorServiceManagementInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementPortalService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisroManagementDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/2/28 9:47
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务顾问管理(后台门户管理)")
@RestController
@RequestMapping(value = "/serviceMarket/advisorManagementPortalController")
public class AdvisorManagementPortalController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementPortalController.class);

    @Autowired
    private AdvisorManagementPortalService advisorManagementPortalService;

    @Autowired
    private AdvisorEditService advisorEditService;


    @ControllerLog(doAction = "服务顾问管理(后台门户管理)")
    @RequiresPermissions("/advisor/advisorManagementPortalController/getAdvisorManagementInfoList")
    @ApiOperation(value = "服务顾问管理(后台门户管理)")
    @RequestMapping(value = "/getAdvisorManagementInfoList",method = RequestMethod.GET)
    public Result<PaginationData<List<AdvisorServiceManagementInfo>>> getAdvisorManagementInfoList(@Validated AdvisorManagementPortalParam advisorManagementParam){
        PaginationData advisorManagementInfo = advisorManagementPortalService.getAdvisorManagementInfoList(advisorManagementParam);
        return  new Result(advisorManagementInfo);
    }

    @ControllerLog(doAction = "服务顾问详情(后台门户管理)")
    @RequiresPermissions("/advisor/advisorManagementPortalController/getAdvisorManagementDetails")
    @ApiOperation(value = "服务顾问详情(后台门户管理)")
    @RequestMapping(value = "/getAdvisorManagementDetails",method = RequestMethod.GET)
    public Result<AdvisroManagementDetailsVo> getAdvisorManagementDetails(@ApiParam(value = "顾问账号" ,required = true,example = "wangsong") @RequestParam("advisorAccount") String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        AdvisroManagementDetailsVo advisorManagementDetails = advisorManagementPortalService.getAdvisorManagementDetails(advisorAccount);
        return  new Result(advisorManagementDetails);
    }

    @ControllerLog(doAction = "服务顾问基本资料修改(后台门户管理)")
    @RequiresPermissions("/advisor/advisorManagementPortalController/updateAdvisorBaseInfo")
    @ApiOperation(value = "服务顾问基本资料修改(后台门户管理)",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/updateAdvisorBaseInfo",method = RequestMethod.POST)
    public Result<Integer> updateAdvisorBaseInfo(@RequestBody @Validated AdvisorBaseInfoParam advisorBaseInfoParam){
        int responseNum = advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfoParam);
        logger.info("------服务顾问基本资料修改(后台门户管理)成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }
}
