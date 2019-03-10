package com.jn.park.finance.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceBudgetHistoryQueryModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.service.FinanceBudgetService;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.record.FnGroupCountRecord;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 14:38
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "预算录入")
@RestController
@RequestMapping("/finance/budget")
public class FinanceBudgetController extends FinanceBaseController {
    @Autowired
    private FinanceBudgetService financeBudgetService;

    @ControllerLog(doAction = "总预算查询")
    @ApiOperation(value = "总预算查询", httpMethod = "GET")
    @GetMapping(value = "/selectTotalBudget")
    @RequiresPermissions("/finance/budget/selectTotalBudget")
    public Result<List<FinanceTotalBudgetVo>> selectTotalBudget(  FinanceBudgetQueryModel financeBudgetQueryModel){
        //财务部能看所有部门的数据，非财务部的用户，需要校验下要查询的部门是否属于用户所属的部门
        if(!isFinanceDepartmentUser()){
            checkUserDepartmentId(financeBudgetQueryModel.getDepartmentId());
            if(null==financeBudgetQueryModel.getDepartmentId()){
                financeBudgetQueryModel.setDepartmentId(getUserDepartmentIds());
            }
        }
        this.checkIsSomeYear(financeBudgetQueryModel.getStartMonth(),financeBudgetQueryModel.getEndMonth());
        List<FinanceTotalBudgetVo>  financeTotalBudgetVoList=financeBudgetService.selectTotalBudget(financeBudgetQueryModel,getUser().getAccount());
        return new Result(financeTotalBudgetVoList);
    }

    @ControllerLog(doAction = "预算录入历史查询")
    @ApiOperation(value = "预算录入历史查询", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/selectBudgetHistory")
    @RequiresPermissions("/finance/budget/selectBudgetHistory")
    public Result<List<FinanceBudgetHistoryVo>> selectBudgetHistory(FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel){
        //财务部能看所有部门的数据，非财务部的用户，需要校验下要查询的部门是否属于用户所属的部门
        if(!isFinanceDepartmentUser()){
            checkUserDepartmentId(financeBudgetHistoryQueryModel.getDepartmentId());
            if(null==financeBudgetHistoryQueryModel.getDepartmentId()){
                financeBudgetHistoryQueryModel.setDepartmentId(getUserDepartmentIds());
            }
        }
        this.checkIsSomeYear(financeBudgetHistoryQueryModel.getStartMonth(),financeBudgetHistoryQueryModel.getEndMonth());
        List<FinanceBudgetHistoryVo> financeBudgetHistoryVoList =financeBudgetService.selectBudgetHistory(financeBudgetHistoryQueryModel,getUser().getAccount());
        return new Result(financeBudgetHistoryVoList);
    }


    @ControllerLog(doAction = "预算录入")
    @ApiOperation(value = "预算录入", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/finance/budget/add")
    public Result add( @RequestParam("file") CommonsMultipartFile file){
        return new Result();
    }

    /**
     * 校验开始结束日期是否为同一年
     * @param startMonth
     * @param endMonth
     */
    private void checkIsSomeYear(String startMonth,String endMonth){
        if(null==startMonth||startMonth.length()==6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"开始月份格式必须是YYYYMM");
        }
        if(null!=endMonth&&endMonth.length()==6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"开始月份格式必须是YYYYMM");
        }
        if(!startMonth.substring(0,4).equals(endMonth.substring(0,4))){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"只能查同一年的数据");
        }
    }
}
