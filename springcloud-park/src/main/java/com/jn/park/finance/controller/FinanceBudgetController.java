package com.jn.park.finance.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceBudgetHistoryQueryModel;
import com.jn.park.finance.model.FinanceBudgetMoneyModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceBudgetService;
import com.jn.park.finance.service.FinanceTypeService;
import com.jn.park.finance.vo.FianceDynamicTableVo;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 14:38
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-预算录入")
@RestController
@RequestMapping("/finance/budget")
public class FinanceBudgetController extends FinanceBaseController {
    @Autowired
    private FinanceBudgetService financeBudgetService;
    @Autowired
    private FinanceTypeService financeTypeService;
    @Autowired
    private SystemClient systemClient;

    @ControllerLog(doAction = "总预算查询")
    @ApiOperation(value = "总预算查询", httpMethod = "GET")
    @GetMapping(value = "/selectTotalBudget")
    @RequiresPermissions("/finance/budget/selectTotalBudget")
    public Result<FianceDynamicTableVo<List<FinanceTotalBudgetVo>>> selectTotalBudget(@Validated FinanceBudgetQueryModel financeBudgetQueryModel){
        //财务部能看所有部门的数据，非财务部的用户，需要校验下要查询的部门是否属于用户所属的部门
        if(!isFinanceDepartmentUser()){
            checkUserDepartmentId(financeBudgetQueryModel.getDepartmentId());
            if(StringUtils.isBlank(financeBudgetQueryModel.getDepartmentId())){
                financeBudgetQueryModel.setDepartmentId(getUserDepartmentIds());
            }
        }
        this.checkIsSomeYear(financeBudgetQueryModel.getStartMonth(),financeBudgetQueryModel.getEndMonth());
        FianceDynamicTableVo<List<FinanceTotalBudgetVo>>  financeTotalBudgetVoList=financeBudgetService.selectTotalBudget(financeBudgetQueryModel,getUser().getAccount());
        return new Result(financeTotalBudgetVoList);
    }

    @ControllerLog(doAction = "预算录入历史查询")
    @ApiOperation(value = "预算录入历史查询", httpMethod = "GET")
    @GetMapping(value = "/selectBudgetHistory")
    @RequiresPermissions("/finance/budget/selectBudgetHistory")
    public Result<FianceDynamicTableVo<List<FinanceBudgetHistoryVo>>> selectBudgetHistory(FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel){
        //财务部能看所有部门的数据，非财务部的用户，需要校验下要查询的部门是否属于用户所属的部门

        if(!isFinanceDepartmentUser()){
            checkUserDepartmentId(financeBudgetHistoryQueryModel.getDepartmentId());
            if(StringUtils.isBlank(financeBudgetHistoryQueryModel.getDepartmentId())){
                financeBudgetHistoryQueryModel.setDepartmentId(getUserDepartmentIds());
            }
        }
        this.checkIsSomeYear(financeBudgetHistoryQueryModel.getStartMonth(),financeBudgetHistoryQueryModel.getEndMonth());
        FianceDynamicTableVo<List<FinanceBudgetHistoryVo>> financeBudgetHistoryVoList =financeBudgetService.selectBudgetHistory(financeBudgetHistoryQueryModel,getUser().getAccount());
        return new Result(financeBudgetHistoryVoList);
    }


    @ControllerLog(doAction = "预算录入")
    @ApiOperation(value = "预算录入", httpMethod = "POST")
    @PostMapping(value = "/add")
    @RequiresPermissions("/finance/budget/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "budgetType",value = "预算类型 0：年初预算 1：临时预算",dataType = "Byte",required = true,paramType = "query"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "departmentName",value = "部门名称",required = true,dataType = "String",paramType = "query")
    })
    public Result add(@ApiParam(value = "Excel模板文件",required = true) MultipartFile file, Byte budgetType, String departmentId, String departmentName){
        //判断文件后缀名是否为.xlsx
        //获取文件名
        String name=file.getOriginalFilename();
        String fileName= name.substring(name.length()-4);
        if(!("xlsx").equals(fileName) ){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请导入模板文件");
        }
        //读出excel中的所有行数据
        List<Object>rows=ExcelUtil.readExcel(file,null);
        if(null==rows||rows.size()<2){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"至少要导入一行数据");
        }

        //第一行为表头，得出需要导入的年月列表
        List<String>monthList=new ArrayList<>();
        List<String>first=(List<String>)rows.get(0);
        int firstSize=first.size();
        try {
            for(int i=1;i<firstSize;i++){
                String month=DateUtils.formatDate(DateUtils.parseDate(first.get(i).toString(),"yyyy年MM月"),"yyyyMM");
                monthList.add(month);
            }
        }catch (ParseException e){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请导入模板文件");
        }

        //第二行开始为数据行
        //多少行
        int rowsSize=rows.size();
        //每行多少个月
        int monthCount=monthList.size();
        List<FinanceBudgetHistoryVo>financeBudgetHistoryVoList=new ArrayList<>();
        for(int i=1;i<rowsSize;i++){
            List<String>data=(List<String>)rows.get(i);
            FinanceBudgetHistoryVo financeBudgetHistoryVo=new FinanceBudgetHistoryVo();
            financeBudgetHistoryVo.setBudgetType(budgetType);
            List<FinanceTypeModel>typeModelList=financeTypeService.selectTypeByDepartmentIds(departmentId,data.get(0));
            if(typeModelList.size()!=1){
                throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,String.format("分类名【%s】不存在",data.get(0)));
            }
            financeBudgetHistoryVo.setCostTypeId(typeModelList.get(0).getId());
            financeBudgetHistoryVo.setCostTypeName(typeModelList.get(0).getFinanceName());
            financeBudgetHistoryVo.setDepartmentId(departmentId);
            financeBudgetHistoryVo.setDepartmentName(departmentName);
            List<FinanceBudgetMoneyModel>moneyModelList=new ArrayList<>();
            for(int ii=1;ii<monthCount;ii++){
                BigDecimal money=new BigDecimal(data.get(ii));
                moneyModelList.add(new FinanceBudgetMoneyModel(monthList.get(ii),money));
            }
            financeBudgetHistoryVo.setBudgetMoneyModels(moneyModelList);
            financeBudgetHistoryVoList.add(financeBudgetHistoryVo);
        }

        financeBudgetService.add(financeBudgetHistoryVoList,getUser().getAccount());





        return new Result();
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
