package com.jn.park.comment.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.comment.model.CommentAdd;
import com.jn.park.comment.service.CommentService;
import com.jn.park.enums.CommentExceptionEnum;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论/点评
 * @Author: yangph
 * @Date: 2018/12/11 10:48
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "评论/点评")
@RestController
@RequestMapping(value = "/comment/review")
public class CommentController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @ControllerLog(doAction = "活动评论/回复")
    @ApiOperation(value = "活动评论/回复", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/commentActivity")
    public Result commentActivity(@Validated @RequestBody CommentAdd commentAdd){
        Assert.notNull(commentAdd.getId(),"活动/点评id不能为空");
        Assert.notNull(commentAdd.getComContent(),"评论内容不能为空");
        Result result=new Result();
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.info("活动评论获取用户账号失败");
            result.setCode(CommentExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setResult(CommentExceptionEnum.NETWORK_ANOMALY.getMessage());
            return result;
        }
        commentService.commentActivity(commentAdd,user.getAccount());
        return result;
    }

    @ControllerLog(doAction = "活动评论点赞")
    @ApiOperation(value = "活动评论点赞", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/commentActivityLike")
    public Result commentActivityLike(@Validated @RequestBody CommentAdd commentAdd){
        Assert.notNull(commentAdd.getId(),"活动/点评id不能为空");
        Result result=new Result();
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.info("活动评论点赞获取用户账号失败");
            result.setCode(CommentExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setResult(CommentExceptionEnum.NETWORK_ANOMALY.getMessage());
            return result;
        }
        commentService.commentActivityLike(commentAdd,user.getAccount());
        return result;
    }

    //todo:删除评论待确认需求后再做
}
