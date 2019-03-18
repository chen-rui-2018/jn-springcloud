package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.enums.FinanceExceptionEnums;
import com.jn.park.finance.model.*;
import com.jn.park.finance.service.FinanceExpensesService;
import com.jn.park.finance.vo.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-支出录入")
@RestController
@RequestMapping("/finance/expend")
public class FinanceExpensesController extends BaseController {

    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }

    @Autowired
    private FinanceExpensesService financeExpensesService;

    @ControllerLog(doAction = "支出录入查询")
    @ApiOperation(value = "支出录入查询", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/findAll")
    @RequiresPermissions("/finance/expend/findAll")
    public Result findAll(@RequestBody FinanceExpendPageModel financeExpendPageModel){
        //todo
        PaginationData findAll= financeExpensesService.findAll(financeExpendPageModel);
        return new Result(findAll);
    }

    @ControllerLog(doAction = "支出录入历史查询")
    @ApiOperation(value = "支出录入历史查询", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/findHistoryAll")
    @RequiresPermissions("/finance/expend/findHistoryAll")
    public Result findHistoryAll(@RequestBody FinanceExpendHistoryPageModel financeEhpm){
        //todo
        PaginationData findHistoryAll= financeExpensesService.findHistoryAll(financeEhpm);
        return new Result(findHistoryAll);
    }

    @ControllerLog(doAction = "录入导入")
    @ApiOperation(value = "录入导入", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/importData")
    @RequiresPermissions("/finance/expend/importData")
    public Result importData(@ApiParam(value = "Excel模板文件",required = true) MultipartFile file){
        //todo
        List<FinanceExpendImportDataVo> financeExpendImportDataVos=financeExpensesService.importData(file,getUser());

        return new Result(financeExpendImportDataVos);
    }

    /*@ControllerLog(doAction = "查询导入的数据")
    @ApiOperation(value = "查询导入的数据", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/findImportData")
    @RequiresPermissions("/finance/expend/findImportData")
    public Result<FinanceExpendFindImportDataVo> findImportData(){
        //todo
        List<FinanceExpendFindImportDataVo> findImportData= financeExpensesService.findImportData(excelId);
        return new Result(findImportData);
    }*/



    /*@ControllerLog(doAction = "批量打标")
    @ApiOperation(value = "批量打标", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/batchMark")
    @RequiresPermissions("/finance/expend/batchMark")
    public Result batchMark(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }*/

    @ControllerLog(doAction = "保存打标数据")
    @ApiOperation(value = "保存打标数据", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/saveMarkData")
    @RequiresPermissions("/finance/expend/saveMarkData")
    public Result saveMarkData(@RequestBody List<FinanceExpendFindImportDataVo> feList){
        //todo
        Result result=financeExpensesService.saveMarkData(feList,getUser());
        return new Result(result);
    }

    @ControllerLog(doAction = "查询财务类型")
    @ApiOperation(value = "查询财务类型", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectFinanceType")
    @RequiresPermissions("/finance/expend/selectFinanceType")
    public Result selectFinanceType(){
        //todo
        List<FinanceExpendFinanceTypeVo> selectFinanceType= financeExpensesService.selectFinanceType();
        return new Result(selectFinanceType);
    }



}
