package com.jn.enterprise.pd.declaration.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
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
 * 申报中心-申报公告管理
 *
 * @author： wzy
 * @date： Created on 2019/4/10 20:05
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "申报中心-申报公告管理")
@RestController
@RequestMapping("/pd/declarationNotice")
public class DeclarationNoticeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeclarationNoticeController.class);
    @Autowired
    private DeclarationNoticeService declarationNoticeService;

    @ControllerLog(doAction = "申报中心公告列表")
    @ApiOperation(value = "申报中心公告列表", notes = "申报中心公告列表")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/declarationNotice/list")
    public Result<List<TbPdDeclarationNoticeManage>> list(@ApiParam(value = "所属类型",example = "白下高新区") @RequestParam String rangeName,
                                                          @ApiParam(value = "排序（1：发布时间排序，2：时间节点排序，3：热度排序）",required = true,example = "1") @RequestParam String sortType) {
        List<TbPdDeclarationNoticeManage> data = declarationNoticeService.selectByDeclarationNoticeList(rangeName,sortType);
        return new Result(data);
    }
}
