package com.jn.enterprise.servicemarket.comment.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.comment.model.*;
import com.jn.enterprise.servicemarket.comment.service.CommentService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务点评
 * @Author: jiangyl
 * @Date: 2019/2/25 14:51
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务点评")
@RestController
@RequestMapping(value = "/guest/serviceMarket/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @ControllerLog(doAction = "获取对他人的评价列表（客户对机构的评价）")
    @ApiOperation(value = "获取对他人的评价列表",notes = "客户对机构的评价")
    @RequestMapping(value = "/getGiveOthersCommentList",method = RequestMethod.GET)
    @RequiresPermissions("/guest/serviceMarket/comment/getGiveOthersCommentList")
    public Result<PaginationData<List<Rating>>> getGiveOthersCommentList(@Validated RatingParameter ratingParameter){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = commentService.getGiveOthersCommentList(ratingParameter,user.getAccount());
        return new Result(data);
    }

    @ControllerLog(doAction = "获取我收到的评价列表(机构/顾问收到的评价)")
    @ApiOperation(value = "获取我收到的评价列表",notes = "机构/顾问收到的评价")
    @RequestMapping(value = "/getGiveMeCommentList",method = RequestMethod.GET)
    @RequiresPermissions("/guest/serviceMarket/comment/getGiveMeCommentList")
    public Result<PaginationData<List<Rating>>> getGiveMeCommentList(@Validated ReceiveRatingParameter receiveRatingParameter){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = commentService.getGiveMeCommentList(receiveRatingParameter,user.getAccount());
        return new Result(data);
    }

    @ControllerLog(doAction = "获取评价页详情")
    @ApiOperation(value = "获取评价页详情",notes = "已评价和未评价都从这接口获取")
    @RequestMapping(value = "/getRatingCommentDetail",method = RequestMethod.GET)
    @RequiresPermissions("/guest/serviceMarket/comment/getRatingCommentDetail")
    public Result<RatingDetail> getRatingCommentDetail(@ApiParam(name="id",value = "需求/评价id",required = true,example = "2cc20cc10c4b4d608f5a05728b86d888")@RequestParam(value = "id") String id){
        Assert.notNull(id, OrgExceptionEnum.COMMENT_ID_IS_NOT_NULL.getMessage());
        RatingDetail ratingCommentDetail = commentService.getRatingCommentDetail(id);
        return new Result<>(ratingCommentDetail);
    }

    @ControllerLog(doAction = "提交评价信息")
    @ApiOperation(value = "提交评价信息")
    @RequestMapping(value = "/saveRatingComment",method = RequestMethod.POST)
    @RequiresPermissions("/guest/serviceMarket/comment/saveRatingComment")
    public Result<Boolean> saveRatingComment(@RequestBody @Validated CommentParameter commentParameter){
        Assert.notNull(commentParameter.getId(), OrgExceptionEnum.COMMENT_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Boolean aBoolean = commentService.saveRatingComment(commentParameter,user.getAccount());
        logger.info("提交评价信息,需求ID{},响应结果{}",commentParameter.getId(),aBoolean);
        return new Result<>(aBoolean);
    }

}
