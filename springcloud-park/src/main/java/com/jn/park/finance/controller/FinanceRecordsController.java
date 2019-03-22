package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.model.FinanceRecordsFindAllModel;
import com.jn.park.finance.model.FinanceRecordsFindDetailModel;
import com.jn.park.finance.service.FinanceRecordsService;
import com.jn.park.finance.vo.FinanceRecordsFindAllVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-财务备案")
@RestController
@RequestMapping("/finance/records")
public class FinanceRecordsController extends BaseController {

    @Autowired
    private FinanceRecordsService financeRecordsService;

    @ControllerLog(doAction = "备案项,需录入项等查询")
    @ApiOperation(value = "备案项,需录入项等查询",notes = "备案项,需录入项等查询",httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/findDetail")
    @RequiresPermissions("/finance/records/findDetail")
    public Result<FinanceRecordsFindDetailModel> findDetail(){
        //todo
        FinanceRecordsFindDetailModel findDetail=financeRecordsService.findDetail();
        return new Result(findDetail);
    }

    @ControllerLog(doAction = "备案查询")
    @ApiOperation(value = "备案查询",notes = "备案查询", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/findAll")
    @RequiresPermissions("/finance/records/findAll")
    public Result<PaginationData<FinanceRecordsFindAllVo>> findAll(@RequestBody FinanceRecordsFindAllModel financeRecordsFindAllModel){
        //todo
        PaginationData findAll=financeRecordsService.findAll(financeRecordsFindAllModel);
        return new Result(findAll);
    }

    @ControllerLog(doAction = "查看")
    @ApiOperation(value = "查看",notes = "查看", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/single")
    @RequiresPermissions("/finance/records/single")
    public Result single(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "录入")
    @ApiOperation(value = "录入", notes = "录入",httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/entering")
    @RequiresPermissions("/finance/records/entering")
    public Result entering(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "财务确认")
    @ApiOperation(value = "财务确认",notes = "财务确认", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/notarize")
    @RequiresPermissions("/finance/records/notarize")
    public Result notarize(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }


    /**
     * 校验开始结束日期是否为同一年
     * @param startMonth
     * @param endMonth
     */
    private void checkIsSomeYear(String startMonth,String endMonth){
        if(StringUtils.isBlank(startMonth)||startMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"开始月份格式必须是YYYYMM");
        }
        if(null!=endMonth&&endMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"结束月份格式必须是YYYYMM");
        }
        if((startMonth.compareTo(endMonth))>0){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"结束月份必须大于等于开始月份");
        }
        if(!startMonth.substring(0,4).equals(endMonth.substring(0,4))){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"只能查同一年的数据");
        }
    }
}
