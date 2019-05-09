package com.jn.enterprise.pd.talent.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclaration;
import com.jn.enterprise.pd.talent.service.PerennialDeclarationService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目申报-常年申报
 *
 * @author： wzy
 * @date： Created on 2019/4/28 11:06
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "项目申报-常年申报")
@RestController
@RequestMapping("/guest/pd/perennialDeclaration")
public class PerennialDeclarationController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PerennialDeclarationController.class);
    @Autowired
    private PerennialDeclarationService perennialDeclarationService;

    @ControllerLog(doAction = "项目申报-常年申报")
    @ApiOperation(value = "常年申报列表", notes = "常年申报列表")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result<List<TbPdPerennialDeclaration>> list(@ApiParam(value = "标题",example = "国家") @RequestParam(name = "title", required = false) String title,
                                                       @ApiParam(value = "政策类型",example = "荣誉资质") @RequestParam(name = "policyType", required = false) String policyType,
                                                       @ApiParam(value = "适用地区",example = "全国") @RequestParam(name = "zoneApplication", required = false) String zoneApplication,
                                                       @ApiParam(value = "当前页",required = true,example = "1") @RequestParam int page,
                                                       @ApiParam(value = "每页总数",required = true,example = "4") @RequestParam int rows) {

        PaginationData<List<TbPdPerennialDeclaration>> data = perennialDeclarationService.selectByPerennialDeclarationList(title,policyType,zoneApplication,page,rows);
        return new Result(data);
    }
}
