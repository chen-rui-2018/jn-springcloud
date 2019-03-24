package com.jn.park.approve.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.approve.model.ApproveGuideContentPortalModel;
import com.jn.park.approve.model.ApproveGuideMessagePortalModel;
import com.jn.park.approve.model.ApproveGuideTitlePortalModel;
import com.jn.park.approve.model.ApproveGuideTypePortalModel;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： huangbq
 * @date： Created on 2019/3/12 16:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "对外行政审批中心-门户(新)")
@RestController
@RequestMapping("/portal/approve/guide")
public class ApproveGuidePortalController extends BaseController {

    @ControllerLog(doAction = "一级分类列表")
    @ApiOperation(value = "一级分类列表", httpMethod = "GET",notes = "首页左侧的一级分类列表")
    @GetMapping(value = "/rootGuideTypeList")
    @RequiresPermissions("/portal/approve/guide/rootGuideTypeList")
    public Result<ApproveGuideTypePortalModel> rootGuideTypeList(){
        return new Result<ApproveGuideTypePortalModel>();
    }

    @ControllerLog(doAction = "指南标题列表")
    @ApiOperation(value = "指南标题列表", httpMethod = "GET",notes = "获取审批指南的标题列表")
    @GetMapping(value = "/guideTitleList")
    @RequiresPermissions("/portal/approve/guide/guideTitleList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId",value = "父分类ID"),
            @ApiImplicitParam(name = "title",value = "指南标题")
    })
    public Result<PaginationData<ApproveGuideTitlePortalModel>> guideTitleList(Integer parentId, String title, Page page){
        return new Result<PaginationData<ApproveGuideTitlePortalModel>>();
    }

    @ControllerLog(doAction = "指南内容")
    @ApiOperation(value = "指南内容", httpMethod = "GET",notes = "获取审批指南的详情内容")
    @GetMapping(value = "/guideContent")
    @RequiresPermissions("/portal/approve/guide/guideContent")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "指南标题ID",required = true)
    })
    public Result<ApproveGuideContentPortalModel> guideContent(Integer id){
        return new Result<ApproveGuideContentPortalModel>();
    }

    @ControllerLog(doAction = "我要留言")
    @ApiOperation(value = "我要留言", httpMethod = "POST",notes = "我要留言，添加留言")
    @PostMapping(value = "/addGuideMessage")
    @RequiresPermissions("/portal/approve/guide/addGuideMessage")
    public Result addGuideMessage(@Validated ApproveGuideMessagePortalModel approveGuideMessagePortalModel){
        return new Result<>();
    }

    @ControllerLog(doAction = "在线办理地址")
    @ApiOperation(value = "在线办理地址", httpMethod = "GET",notes = "返回在线办理的地址，客户端接收到地址号在新窗口中打开")
    @GetMapping(value = "/onlineUrl")
    @RequiresPermissions("/portal/approve/guide/onlineUrl")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "指南标题ID",required = true)
    })
    public Result onlineUrl(Integer id){
        return new Result();
    }
}
