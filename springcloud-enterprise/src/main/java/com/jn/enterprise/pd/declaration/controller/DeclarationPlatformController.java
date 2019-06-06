package com.jn.enterprise.pd.declaration.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformSubordinate;
import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;
import com.jn.enterprise.pd.declaration.service.DeclarationPlatformService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
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
    public Result<PaginationData<List<DeclarationPlatformModel>>> list(@ApiParam(value = "所属平台(1:园区本级平台,2：市级平台，3：省级平台，4：国家级平台)",required = true,example = "1") @RequestParam String subordinatePlatformName,
                                                                       @ApiParam(value = "平台标题",example = "人才") @RequestParam(name = "platformTitle", required = false) String platformTitle,
                                                                       @ApiParam(value = "当前页",required = true,example = "1") @RequestParam int page,
                                                                       @ApiParam(value = "每页总数",required = true,example = "5") @RequestParam int rows) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<DeclarationPlatformModel>> data = declarationPlatformService.selectByDeclarationPlatformList(subordinatePlatformName,platformTitle,page,rows,user);
        return new Result(data);
    }


    @ControllerLog(doAction = "申报中心所属平台类型列表")
    @ApiOperation(value = "申报中心所属平台类型列表", notes = "申报中心所属平台类型列表")
    @RequestMapping(value = "/typeList" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/declaration/typeList")
    public Result<List<TbPdDeclarationPlatformSubordinate>> typeList(){
        List<TbPdDeclarationPlatformSubordinate> data = declarationPlatformService.selectByPlatformSubordinateList();
        return new Result(data);
    }


    @ControllerLog(doAction = "申报平台备忘录")
    @ApiOperation(value = "申报平台备忘录", notes = "申报平台备忘录")
    @RequestMapping(value = "/addOrEditMemorandum" ,method = RequestMethod.POST)
    @RequiresPermissions("/pd/declaration/addOrEditMemorandum")
    public Result addOrEditMemorandum( @ApiParam(value = "申报平台ID",example = "111") @RequestParam(name = "platformId") String platformId,
                                     @ApiParam(value = "账户密码",example = "admin/1") @RequestParam(name = "accountAndPassword", required = false) String accountAndPassword){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        declarationPlatformService.addOrEditMemorandum(platformId,accountAndPassword,user);
        return new Result();
    }

}
