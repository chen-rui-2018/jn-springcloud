package com.jn.park.comment.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.comment.service.CommentService;
import com.jn.park.enums.CommentExceptionEnum;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ControllerLog(doAction = "评论/回复")
    @ApiOperation(value = "评论/回复", httpMethod = "POST",notes = "返回数据响应条数，正常返回1")
    @RequestMapping(value = "/commentActivity")
    public Result<Integer> commentActivity(@Validated @RequestBody CommentAddParam commentAddParam){
        Assert.notNull(commentAddParam.getRootId(),CommentExceptionEnum.APPLY_ROOT_ID_NOT_NULL.getMessage());
        Assert.notNull(commentAddParam.getpId(),CommentExceptionEnum.APPLY_P_ID_NOT_NULL.getMessage());
        Assert.notNull(commentAddParam.getComContent(),CommentExceptionEnum.APPLY_CONTENT_NOT_EMPTY.getMessage());
        Result result=new Result();
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.info("评论获取用户账号失败");
            return new Result(CommentExceptionEnum.NETWORK_ANOMALY.getCode(),CommentExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        commentAddParam.getAccount();
        int resNum = commentService.commentActivity(commentAddParam);
        logger.info("-------------评论/回复添加成功，数据响应条数：{}---------------",resNum);
        result.setData(resNum);
        return result;
    }

    @ControllerLog(doAction = "评论点赞")
    @ApiOperation(value = "评论点赞", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/commentActivityLike")
    public Result commentActivityLike(@ApiParam(value = "点赞对象ID" ,required = true,example = "1234") @RequestParam(value = "id") String id){
        Assert.notNull(id,CommentExceptionEnum.APPLY_P_ID_NOT_NULL.getMessage());
        Result result=new Result();
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.info("评论点赞获取用户账号失败");
            return new Result(CommentExceptionEnum.NETWORK_ANOMALY.getCode(),CommentExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        commentService.commentActivityLike(id,user.getAccount());
        return result;
    }

    @ControllerLog(doAction = "评论取消点赞")
    @ApiOperation(value = "评论点赞", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/commentActivityCancelLike")
    public Result commentActivityCancelLike(@ApiParam(value = "点评ID/活动ID" ,required = true,example = "1234") @RequestParam(value = "id") String id){
        Assert.notNull(id,CommentExceptionEnum.APPLY_P_ID_NOT_NULL.getMessage());
        Result result=new Result();
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.info("评论取消点赞获取用户账号失败");
            return new Result(CommentExceptionEnum.NETWORK_ANOMALY.getCode(),CommentExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        commentService.commentActivityCancelLike(id,user.getAccount());
        return result;
    }

    //todo:删除评论待确认需求后再做 yangph
}
