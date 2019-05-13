package com.jn.park.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.model.CommentAddParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 点评
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:30
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface CommentClient {

    /**
     * 获取评论信息
     * @param activityPagingParam
     * @return
     */
    @RequestMapping(value = "/api/comment/getCommentInfo", method = RequestMethod.POST)
    Result<PaginationData<List<Comment>>>  getCommentInfo(@RequestBody ActivityPagingParam activityPagingParam);

    /**
     * 评论/评论回复
     * @param commentAddParam
     * @return
     */
    @RequestMapping(value = "/api/comment/commentActivity", method = RequestMethod.POST)
    Result<Boolean> commentActivity(@RequestBody CommentAddParam commentAddParam);

}
