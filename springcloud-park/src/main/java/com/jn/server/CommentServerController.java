package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.api.CommentClient;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.comment.service.CommentService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 智慧停车系统服务定时任务
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:29
 * @version： v1.0
 * @modified By:
 */
@RestController
public class CommentServerController extends BaseController implements CommentClient {
    private static Logger logger = LoggerFactory.getLogger(CommentServerController.class);

    @Autowired
    private ActivityDetailsService activityDetailsService;
    @Autowired
    private CommentService commentService;


    @ControllerLog(doAction = "获取评论信息")
    @Override
    public Result<PaginationData<List<Comment>>>  getCommentInfo(@RequestBody ActivityPagingParam activityPagingParam){
        PaginationData<List<Comment>> commentInfo = activityDetailsService.getCommentInfo(activityPagingParam,activityPagingParam.getAccount(),Boolean.TRUE);
        return new Result<>(commentInfo);
    }

    @ControllerLog(doAction = " 评论/评论回复")
    @Override
    public Result<Boolean> commentActivity(@RequestBody CommentAddParam commentAddParam){
        commentService.commentActivity(commentAddParam);
        return new Result<>(true);
    }

}
