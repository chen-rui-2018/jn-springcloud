package com.jn.park.approve.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.Result;
import com.jn.park.approve.model.ApproveGuideContentAddModel;
import com.jn.park.approve.model.ApproveGuideTitleModel;
import com.jn.park.approve.model.ApproveGuideTypeAddModel;
import com.jn.park.approve.vo.ApproveGuideTypeTreeVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/12 16:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "对外行政审批中心-行政审批指南管理")
@RestController
@RequestMapping("/approve/guide")
public class ApproveGuideController extends BaseController {

    @ControllerLog(doAction = "分类树")
    @ApiOperation(value = "分类树", httpMethod = "GET")
    @GetMapping(value = "/guideTypeTree")
    @RequiresPermissions("/approve/guide/guideTypeTree")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "分类名(可模糊搜索)")
    })
    public Result<ApproveGuideTypeTreeVo> guideTypeTree(String name){
        return new Result<ApproveGuideTypeTreeVo>();
    }

    @ControllerLog(doAction = "指南标题列表")
    @ApiOperation(value = "指南标题列表", httpMethod = "GET")
    @GetMapping(value = "/guideTitleList")
    @RequiresPermissions("/portal/approve/guide/guideTitleList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId",value = "父分类ID"),
            @ApiImplicitParam(name = "showStatus",value = "显示状态（草稿，已发布，下线）"),
            @ApiImplicitParam(name = "title",value = "指南标题"),
            @ApiImplicitParam(name = "orderByClause",value = "排序字段",example = "created_time desc")
    })
    public Result<ApproveGuideTitleModel> guideTitleList(Integer parentId, String showStatus, String title, String orderByClause, Page page){
        return new Result<ApproveGuideTitleModel>();
    }

    @ControllerLog(doAction = "发布指南内容")
    @ApiOperation(value = "发布指南内容", httpMethod = "POST")
    @PostMapping(value = "/addGuideContent")
    @RequiresPermissions("/portal/approve/guide/addGuideContent")
    public Result addGuideContent(ApproveGuideContentAddModel approveGuideContentAddModel){
        return new Result<>();
    }

    @ControllerLog(doAction = "发布指南分类")
    @ApiOperation(value = "发布指南", httpMethod = "POST")
    @PostMapping(value = "/addGuideType")
    @RequiresPermissions("/portal/approve/guide/addGuideType")
    public Result addGuideType(ApproveGuideTypeAddModel approveGuideTypeAddModel){
        return new Result<>();
    }

    @ControllerLog(doAction = "设置首页排序(在门户首页的顺序asc)")
    @ApiOperation(value = "设置首页排序(在门户首页的顺序asc)", httpMethod = "POST")
    @PostMapping(value = "/updateGuideHomeSort")
    @RequiresPermissions("/portal/approve/guide/updateGuideHomeSort")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",dataType = "Long",required = true),
            @ApiImplicitParam(name = "homeSort",value = "首页排序(在门户首页的顺序asc)",dataType = "Long",required = true)
    })
    public Result updateGuideHomeSort(Integer id, Integer homeSort){
        return new Result<>();
    }

    @ControllerLog(doAction = "设置置顶顺序(在行政审批中心首页的顺序asc）")
    @ApiOperation(value = "设置置顶顺序(在行政审批中心首页的顺序asc）", httpMethod = "POST")
    @PostMapping(value = "/updateGuideTopSort")
    @RequiresPermissions("/portal/approve/guide/updateGuideTopSort")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",dataType = "Long",required = true),
            @ApiImplicitParam(name = "topSort",value = "置顶顺序(在行政审批中心首页的顺序asc）",dataType = "Long",required = true)
    })
    public Result updateGuideTopSort(Integer id, Integer topSort){
        return new Result<>();
    }

    @ControllerLog(doAction = "推送指南")
    @ApiOperation(value = "推送指南", httpMethod = "POST",notes = "把选中的审批指南推送给园区注册的所有企业")
    @PostMapping(value = "/push")
    @RequiresPermissions("/portal/approve/guide/push")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "审批指南ID，多个用逗号（,）隔开",dataType = "Long",required = true)
    })
    public Result push(String ids){
        return new Result<>();
    }
}
