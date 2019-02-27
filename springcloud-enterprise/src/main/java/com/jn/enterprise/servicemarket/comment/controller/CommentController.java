package com.jn.enterprise.servicemarket.comment.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.comment.model.*;
import com.jn.enterprise.servicemarket.comment.service.CommentService;
import com.jn.enterprise.servicemarket.org.model.OrgParameter;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务点评
 * @Author: yangph
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

    @ControllerLog(doAction = "获取对他人的评价列表(客户对机构的评价)")
    @ApiOperation(value = "获取对他人的评价列表(客户对机构的评价)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getGiveOthersCommentList")
    @RequiresPermissions("/guest/serviceMarket/comment/getGiveOthersCommentList")
    public Result getGiveOthersCommentList(@RequestBody @Validated RatingParameter ratingParameter){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = commentService.getGiveOthersCommentList(ratingParameter,user.getAccount());
        return new Result(data);
    }

    @ControllerLog(doAction = "获取我收到的评价列表(机构/顾问收到的评价)")
    @ApiOperation(value = "获取我收到的评价列表(机构/顾问收到的评价)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getGiveMeCommentList")
    @RequiresPermissions("/guest/serviceMarket/comment/getGiveMeCommentList")
    public Result getGiveMeCommentList(@RequestBody @Validated ReceiveRatingParameter receiveRatingParameter){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = commentService.getGiveMeCommentList(receiveRatingParameter,user.getAccount());
        return new Result(data);
    }

    @ControllerLog(doAction = "获取评价页详情")
    @ApiOperation(value = "获取评价页详情(已评价和未评价都从这接口获取)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getRatingCommentDetail")
    @RequiresPermissions("/guest/serviceMarket/comment/getRatingCommentDetail")
    public Result getRatingCommentDetail(@ApiParam(name="id",value = "需求/评价id",required = true)@RequestBody String id){
        Assert.notNull(id, OrgExceptionEnum.COMMENT_ID_IS_NOT_NULL.getMessage());
        RatingDetail ratingCommentDetail = commentService.getRatingCommentDetail(id);
        return new Result(ratingCommentDetail);
    }

    @ControllerLog(doAction = "提交评价信息")
    @ApiOperation(value = "提交评价信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveRatingComment")
    @RequiresPermissions("/guest/serviceMarket/comment/saveRatingComment")
    public Result saveRatingComment(CommentParameter commentParameter){
        Assert.notNull(commentParameter.getId(), OrgExceptionEnum.COMMENT_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Boolean aBoolean = commentService.saveRatingComment(commentParameter,user.getAccount());
        logger.info("提交评价信息,需求ID{},响应结果{}",commentParameter.getId(),aBoolean);
        return new Result(aBoolean);
    }

}
