package com.jn.enterprise.technologyfinancial.investors.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListShow;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementNameParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementUpOrDownParam;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorManagementService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
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
 * @Date: 2019/3/21 14:58
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "科技金融管理投资人管理")
@RestController
@RequestMapping(value = "/technologyFinancial/investorManagementController")
public class InvestorManagementController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorManagementController.class);

    @Autowired
    private InvestorManagementService investorManagementService;

    @ControllerLog(doAction = "投资人管理列表查询")
    @ApiOperation(value = "投资人管理列表查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorManagementList")
    @RequestMapping(value = "/getInvestorManagementList")
    public Result<PaginationData<List<InvestorManagementListShow>>> getInvestorManagementList(@RequestBody @Validated InvestorManagementListParam investorManagementListParam){
        PaginationData investorManagementList = investorManagementService.getInvestorManagementList(investorManagementListParam);
        return  new Result(investorManagementList);
    }

    @ControllerLog(doAction = "投资人管理姓名查询")
    @ApiOperation(value = "投资人管理姓名查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorManagementNames")
    @RequestMapping(value = "/getInvestorManagementNames")
    public Result<PaginationData<List<String>>> getInvestorManagementNames(@RequestBody @Validated InvestorManagementNameParam investorManagementListParam){
        PaginationData investorManagementNames = investorManagementService.getInvestorManagementNames(investorManagementListParam);
        return  new Result(investorManagementNames);
    }

    @ControllerLog(doAction = "投资人上架/下架")
    @ApiOperation(value = "投资人上架/下架", httpMethod = "POST", response = Result.class,notes = "返回数据为数据响应条数")
    @RequiresPermissions("/technologyFinancial/investorController/investorUpOrDown")
    @RequestMapping(value = "/investorUpOrDown")
    public Result<Integer> investorUpOrDown(@RequestBody @Validated InvestorManagementUpOrDownParam investorManagementUpOrDownParam){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("投资人上架/下架获取当前登录用户失败");
            return new Result(InvestorExceptionEnum.NETWORK_ANOMALY.getCode(),InvestorExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum = investorManagementService.investorUpOrDown(investorManagementUpOrDownParam, user.getAccount());
        logger.info("-------投资人上架/下架操作成功，数据响应条数是[{}]-------",responseNum);
        return  new Result(responseNum);
    }
}
