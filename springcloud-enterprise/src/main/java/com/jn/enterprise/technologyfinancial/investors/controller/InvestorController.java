package com.jn.enterprise.technologyfinancial.investors.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.model.*;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;
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
 * @Date: 2019/3/9 16:35
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "科技金融-科技金融投资人")
@RestController
public class InvestorController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorController.class);

    @Autowired
    private InvestorService investorService;

    @ControllerLog(doAction = "投资人列表查询")
    @ApiOperation(value = "投资人列表查询")
    @RequestMapping(value = "/guest/technologyFinancial/investorController/getInvestorInfoList",method = RequestMethod.GET)
    public Result<PaginationData<List<InvestorInfoListShow>>> getInvestorInfoList(@Validated InvestorInfoListParam investorInfoListParam){
        PaginationData investorInfoList = investorService.getInvestorInfoList(investorInfoListParam);
        return  new Result(investorInfoList);
    }

    @ControllerLog(doAction = "投资人认证")
    @ApiOperation(value = "投资人认证",notes = "返回数据状态为200，表示投资人认证提交成功，启动审批流程成功")
    @RequiresPermissions("/technologyFinancial/investorController/addInvestorInfo")
    @RequestMapping(value = "/technologyFinancial/investorController/addInvestorInfo",method = RequestMethod.POST)
    public Result<Integer> addInvestorInfo(@RequestBody @Validated InvestorAuthenticateParam investorAuthenticateParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("投资人认证获取当前登录用户失败");
            return new Result(InvestorExceptionEnum.NETWORK_ANOMALY.getCode(),InvestorExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(investorService.addInvestorInfo(investorAuthenticateParam, user.getAccount()));
    }

    @ControllerLog(doAction = "投资人详情")
    @ApiOperation(value = "投资人详情/投资人查看")
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorInfoDetails")
    @RequestMapping(value = "/technologyFinancial/investorController/getInvestorInfoDetails",method = RequestMethod.GET)
    public Result<InvestorInfoDetailsVo> getInvestorInfoDetails(@ApiParam(value = "投资人账号" ,required = true,example = "wangsong")@RequestParam("investorAccount") String investorAccount){
        Assert.notNull(investorAccount, InvestorExceptionEnum.INVESTOR_ACCOUNT_NOT_NULL.getMessage());
        InvestorInfoDetailsVo investorInfoDetailsVo=investorService.getInvestorInfoDetails(investorAccount);
        return  new Result(investorInfoDetailsVo);
    }

    @ControllerLog(doAction = "查询所属单位")
    @ApiOperation(value = "查询所属单位")
    @RequiresPermissions("/technologyFinancial/investorController/getAffiliationUnit")
    @RequestMapping(value = "/technologyFinancial/investorController/getAffiliationUnit",method = RequestMethod.GET)
    public Result<PaginationData<List<AffiliationUnitShow>>> getAffiliationUnit(@Validated  AffiliationUnitInfoParam affiliationUnitInfoParam){
        PaginationData result= investorService.getAffiliationUnit(affiliationUnitInfoParam);
        return  new Result(result);
    }

    @ControllerLog(doAction = "查询投资人主投领域")
    @ApiOperation(value = "查询投资人主投领域")
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorMainArea")
    @RequestMapping(value = "/technologyFinancial/investorController/getInvestorMainArea",method = RequestMethod.GET)
    public Result<List<InvestorMainArea>> getInvestorMainArea(){
        List<InvestorMainArea> investorMainAreaList = investorService.getInvestorMainArea();
        return  new Result(investorMainAreaList);
    }

    @ControllerLog(doAction = "查询投资人主投轮次")
    @ApiOperation(value = "查询投资人主投轮次")
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorMainRound")
    @RequestMapping(value = "/technologyFinancial/investorController/getInvestorMainRound",method = RequestMethod.GET)
    public Result<List<InvestorMainRound>> getInvestorMainRound(){
        List<InvestorMainRound> investorMainRound = investorService.getInvestorMainRound();
        return  new Result(investorMainRound);
    }
}
