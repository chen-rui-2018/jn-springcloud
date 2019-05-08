package com.jn.enterprise.pd.evaluate.controller;

import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.pd.evaluate.model.EvaluateCompanyModel;
import com.jn.enterprise.pd.evaluate.model.EvaluateTargetModel;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/4/2 19:04
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "项目申报-常年申报评测(外部)")
@RestController
@RequestMapping("/pd/evaluate")
public class EvaluateController {

    @Autowired
    private CompanyClient companyClient;

    @ControllerLog(doAction = "评测结果通知")
    @ApiOperation(value = "评测结果通知", notes = "企业评测完成后，零七优服调用此接口（调用参数：企业代码+评测结果）把评测结果通知到智慧园区，智慧园区再用短信方式通知对应的企业",httpMethod = "POST")
    @PostMapping(value = "/notice")
    @RequiresPermissions("/pd/evaluate/notice")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId",value = "企业代码",example = "1231231",required = true),
            @ApiImplicitParam(name = "resultCode",value = "评测结果代码（0000：通过，其他：不通过）",example = "0000",required = true),
            @ApiImplicitParam(name = "resultMsg",value = "评测结果描述",example = "评测通过",required = true)
    })
    public Result notice(String companyId,String resultCode,String resultMsg){
        return new Result<>();
    }

    @ControllerLog(doAction = "企业基本信息查询")
    @ApiOperation(value = "企业基本信息查询", notes = "查询企业的基本信息",httpMethod = "GET")
    @GetMapping(value = "/getCompany")
    @RequiresPermissions("/pd/evaluate/getCompany")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId",value = "企业代码",example = "8afabb60045d40e485e1d4ac04666e8a",required = true)
    })
    public Result<EvaluateCompanyModel> getCompany(String companyId){
        Result<ServiceCompany> result=companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        EvaluateCompanyModel evaluateCompanyModel=new EvaluateCompanyModel();
        BeanUtils.copyProperties(result.getData(),evaluateCompanyModel);
        return new Result<EvaluateCompanyModel>(evaluateCompanyModel);
    }


    @ControllerLog(doAction = "评测指标查询")
    @ApiOperation(value = "评测指标查询", notes = "根据企业ID返回该企业对应的评测指标内容（列表）",httpMethod = "GET")
    @GetMapping(value = "/getTargetList")
    @RequiresPermissions("/pd/evaluate/getTargetList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId",value = "企业代码",example = "8afabb60045d40e485e1d4ac04666e8a",required = true)
    })
    public Result<List<EvaluateTargetModel>> getTarget(String companyId){
        return new Result<List<EvaluateTargetModel>>();
    }
}
