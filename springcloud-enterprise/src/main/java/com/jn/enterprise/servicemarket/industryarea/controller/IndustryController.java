package com.jn.enterprise.servicemarket.industryarea.controller;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictParameter;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictionary;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryParameter;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 机构字典（业务领域 行业领域 发展阶段 企业性质 ...）
 * @author： jiangyl
 * @date： Created on 2019/3/1 15:27
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "机构字典[业务领域 行业领域 发展阶段 企业性质]")
@RestController
@RequestMapping(value = "/guest/serviceMarket/industryManage")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @ControllerLog(doAction = "机构字典")
    @ApiOperation(value = "机构字典[字段类型：0业务领域1行业领域2发展阶段3企业性质]", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectIndustryList")
    public Result selectIndustryList(@RequestBody @Validated IndustryDictParameter industryDictParameter){
        List<IndustryDictionary> industryDictionary = industryService.getIndustryDictionary(industryDictParameter);
        return new Result(industryDictionary);
    }

}
