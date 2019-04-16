package com.jn.enterprise.pd.declaration.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeRange;
import com.jn.enterprise.pd.declaration.enums.ExceptionStatusEnums;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
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
    public Result<List<TbPdDeclarationNoticeManage>> list(@ApiParam(value = "所属类型(1:白下高新区，2：秦淮区，3：南京市，4：江苏省，5：国家)",example = "1") @RequestParam String rangeId,
                                                          @ApiParam(value = "排序（1：发布时间排序，2：时间节点排序，3：热度排序）",required = true,example = "1") @RequestParam String sortType) {
        List<TbPdDeclarationNoticeManage> data = declarationNoticeService.selectByDeclarationNoticeList(rangeId,sortType);
        return new Result(data);
    }

    @ControllerLog(doAction = "申报中心-查询公告详情")
    @ApiOperation(value = "申报中心-查询公告详情", notes = "申报中心-查询公告详情")
    @RequestMapping(value = "/selectByTalentNotice" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/declarationNotice/selectByTalentNotice")
    public Result<TbPdDeclarationNoticeManage> selectByTalentNotice(@ApiParam(value = "公告ID",required = true ,example = "563311034148847616") @RequestParam String id){
        Assert.notNull(id, ExceptionStatusEnums.NOTICE_ID_NOT_NULL.getMessage());
        TbPdDeclarationNoticeManage notice = declarationNoticeService.selectByTalentNotice(id);
        return new Result(notice);
    }

    @ControllerLog(doAction = "申报中心公告所属类型列表")
    @ApiOperation(value = "申报中心公告所属类型列表", notes = "申报中心公告所属类型列表")
    @RequestMapping(value = "/typeList" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/declarationNotice/typeList")
    public Result<List<TbPdDeclarationNoticeRange>> typeList(){
        List<TbPdDeclarationNoticeRange> data = declarationNoticeService.selectByNoticeRangeList();
        return new Result(data);
    }

    @ControllerLog(doAction = "申报中心公告访问量")
    @ApiOperation(value = "申报中心公告访问量", notes = "申报中心公告访问量")
    @RequestMapping(value = "/trafficVolume" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/declarationNotice/trafficVolume")
    public Result trafficVolume(@ApiParam(value = "公告ID",required = true ,example = "563311034148847616") @RequestParam String id){
        Assert.notNull(id, ExceptionStatusEnums.NOTICE_ID_NOT_NULL.getMessage());
        declarationNoticeService.updateTrafficVolume(id);
        return new Result();
    }
}
