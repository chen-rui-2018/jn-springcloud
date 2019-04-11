package com.jn.enterprise.pd.declaration.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManage;
import com.jn.enterprise.pd.declaration.service.DeclarationPlatformService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 申报平台管理
 *
 * @author： wzy
 * @date： Created on 2019/4/10 17:08
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "项目申报-申报平台管理")
@RestController
@RequestMapping("/pd/declaration")
public class DeclarationPlatformController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeclarationPlatformController.class);

    @Autowired
    private DeclarationPlatformService declarationPlatformService;

    @ControllerLog(doAction = "申报平台列表")
    @RequiresPermissions("/pd/declaration/list")
    @ApiOperation(value = "申报平台列表", notes = "申报平台列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<TbPdDeclarationPlatformManage>> list(@ApiParam(value = "所属平台",required = true,example = "园区本级平台") @RequestParam String subordinatePlatformName) {
        List<TbPdDeclarationPlatformManage> data = declarationPlatformService.selectByDeclarationPlatformList(subordinatePlatformName);
        return new Result(data);
    }
}
