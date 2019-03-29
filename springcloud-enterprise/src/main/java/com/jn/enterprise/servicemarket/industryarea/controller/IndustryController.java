package com.jn.enterprise.servicemarket.industryarea.controller;

import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictParameter;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictionary;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 机构字典（业务领域 行业领域 发展阶段 企业性质 ...）
 * @author： jiangyl
 * @date： Created on 2019/3/1 15:27
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "服务超市-机构字典[业务领域 行业领域 发展阶段 企业性质]")
@RestController
@RequestMapping(value = "/guest/serviceMarket/industryManage")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @ControllerLog(doAction = "机构字典")
    @ApiOperation(value = "机构字典",notes = "[字段类型：0业务领域1行业领域2发展阶段3企业性质][不分页查询]")
    @RequestMapping(value = "/selectIndustryList",method = RequestMethod.GET)
    public Result<List<IndustryDictionary>> selectIndustryList(@Validated IndustryDictParameter industryDictParameter){
        List<IndustryDictionary> industryDictionary = industryService.getIndustryDictionary(industryDictParameter);
        return new Result(industryDictionary);
    }

}
