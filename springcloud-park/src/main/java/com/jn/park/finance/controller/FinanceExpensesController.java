package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-支出录入")
@RestController
@RequestMapping("/finance/expenses")
public class FinanceExpensesController extends BaseController {

    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }
    @Autowired
    private FinanceExpensesService financeExpensesService;

    @ControllerLog(doAction = "支出录入查询")
    @ApiOperation(value = "支出录入查询",notes = "支出录入查询", httpMethod = "GET")
    @GetMapping(value = "/findAll")
    @RequiresPermissions("/finance/expenses/findAll")
    public Result<PaginationData<List<FinanceExpendHistoryVo>>> findAll(FinanceExpensesPageModel financeExpensesPageModel){
        //todo
        this.checkIsSomeYear(financeExpensesPageModel.getStartTime(),financeExpensesPageModel.getEndTime());
        PaginationData findAll= financeExpensesService.findAll(financeExpensesPageModel);
        return new Result(findAll);
    }

    @ControllerLog(doAction = "支出录入历史查询")
    @ApiOperation(value = "支出录入历史查询",notes = "支出录入历史查询", httpMethod = "GET")
    @GetMapping(value = "/findHistoryAll")
    @RequiresPermissions("/finance/expenses/findHistoryAll")
    public Result<PaginationData<List<FinanceExpendHistoryVo>>> findHistoryAll(FinanceExpensesHistoryPageModel financeEhpm){
        //todo
        this.checkIsSomeYear(financeEhpm.getStartTime(),financeEhpm.getEndTime());
        PaginationData findHistoryAll= financeExpensesService.findHistoryAll(financeEhpm);
        return new Result(findHistoryAll);
    }

    @ControllerLog(doAction = "录入导入")
    @ApiOperation(value = "录入导入", httpMethod = "POST")
    @PostMapping(value = "/importData")
    @RequiresPermissions("/finance/expenses/importData")
    public Result<FinanceExpendImportDataVo> importData(@ApiParam(value = "Excel模板文件",required = true) MultipartFile file){
        //todo
        //判断文件后缀名是否为.xlsx
        //获取文件名
        String name=file.getOriginalFilename();
        String fileName= name.substring(name.length()-4);
        if(!fileName.equals("xlsx")){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请导入模板文件");
        }
        List<FinanceExpendImportDataVo> financeExpendImportDataVos=financeExpensesService.importData(file,getUser());

        return new Result(financeExpendImportDataVos);
    }

    @ControllerLog(doAction = "保存打标数据")
    @ApiOperation(value = "保存打标数据", httpMethod = "POST")
    @PostMapping(value = "/saveMarkData")
    @RequiresPermissions("/finance/expenses/saveMarkData")
    public Result saveMarkData(@RequestBody List<FinanceExpendFindImportDataVo> feList){
        //todo
        Result result=financeExpensesService.saveMarkData(feList,getUser());
        return new Result(result);
    }

    @ControllerLog(doAction = "获取财务类型")
    @ApiOperation(value = "获取财务类型",notes = "获取财务类型", httpMethod = "GET")
    @GetMapping(value = "/selectFinanceType")
    @RequiresPermissions("/finance/expenses/selectFinanceType")
    public Result<List<FinanceExpendFinanceTypeVo>>  selectFinanceType(){
        //todo
        List<FinanceExpendFinanceTypeVo> selectFinanceType= financeExpensesService.selectFinanceType();
        return new Result(selectFinanceType);
    }

    @ControllerLog(doAction = "获取部门信息")
    @ApiOperation(value = "获取部门信息",notes = "获取部门信息", httpMethod = "GET")
    @GetMapping(value = "/selectDepartment")
    @RequiresPermissions("/finance/expenses/selectDepartment")
    public Result<List<FinanceSelectDepartmentModel>>  selectDepartment(){
        //todo
        List<FinanceSelectDepartmentModel> selectFinanceType= financeExpensesService.selectDepartment();
        return new Result(selectFinanceType);
    }


    /**
     * 校验开始结束日期是否为同一年
     * @param startMonth
     * @param endMonth
     */
    private void checkIsSomeYear(String startMonth,String endMonth){
        if(StringUtils.isBlank(startMonth)||startMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"起止月份格式必须是YYYYMM");
        }
        if(null!=endMonth&&endMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"起止月份格式必须是YYYYMM");
        }
        if((startMonth.compareTo(endMonth))>0){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"起止月份必须大于等于开始月份");
        }
        if(!startMonth.substring(0,4).equals(endMonth.substring(0,4))){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"只能查同一年的数据");
        }
    }

}
