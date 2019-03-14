package com.jn.enterprise.technologyfinancial.investors.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoListParam;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/3/9 16:35
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "科技金融投资人")
@RestController
@RequestMapping(value = "/technologyFinancial/investorController")
public class InvestorController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorController.class);

    @Autowired
    private InvestorService investorService;

    @ControllerLog(doAction = "投资人列表查询")
    @ApiOperation(value = "投资人列表查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorInfoList")
    @RequestMapping(value = "/getInvestorInfoList")
    public Result getInvestorInfoList(@RequestBody @Validated InvestorInfoListParam investorInfoListParam){
        PaginationData investorInfoList = investorService.getInvestorInfoList(investorInfoListParam);
        return  new Result(investorInfoList);
    }

    @ControllerLog(doAction = "投资人详情")
    @ApiOperation(value = "投资人详情", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorInfoDetails")
    @RequestMapping(value = "/getInvestorInfoDetails")
    public Result<InvestorInfoDetailsVo> getInvestorInfoDetails(@ApiParam(value = "投资人账号" ,required = true)@RequestParam("investorAccount") String investorAccount){
        Assert.notNull(investorAccount, InvestorExceptionEnum.INVESTOR_ACCOUNT_NOT_NULL.getMessage());
        InvestorInfoDetailsVo investorInfoDetailsVo=investorService.getInvestorInfoDetails(investorAccount);
        return  new Result(investorInfoDetailsVo);
    }
}
