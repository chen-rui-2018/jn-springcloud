package com.jn.park.feedback.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.feedback.model.Feedback;
import com.jn.park.feedback.model.FeedbackParam;
import com.jn.park.feedback.model.FeedbackVO;
import com.jn.park.feedback.service.FeedbackService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 我的管理-问题反馈
 * @Author: jiangyl
 * @Date: 2019/03/27 15:48
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "我的管理-问题反馈")
@RestController
@RequestMapping(value = "/mine/feedback")
public class FeedbackController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService feedbackService;

    @ControllerLog(doAction = "新增反馈问题")
    @ApiOperation(value = "新增反馈问题",notes = "问题反馈中的反馈类型ID(反馈类型名称)传园区字典表查询(条件为：userFeed)返回的codeValue字段，反馈类型名称传codeName字段。返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/saveFeedback",method = RequestMethod.POST)
    public Result<Integer> saveFeedback(@Validated @RequestBody Feedback feedback){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(feedbackService.saveFeedback(feedback,user.getAccount()));
    }

    @ControllerLog(doAction = "获取反馈问题列表[后台管理]")
    @ApiOperation(value = "获取反馈问题列表[后台管理接口]",notes = "问题反馈中的反馈类型ID(反馈类型名称)传园区字典表查询(条件为：userFeed)返回的codeValue字段，反馈类型名称传codeName字段。")
    @RequestMapping(value = "/getFeedbackList",method = RequestMethod.GET)
    @RequiresPermissions("/mine/feedback/getFeedbackList")
    public Result<PaginationData<List<FeedbackVO>>> getUserFeedbackList(FeedbackParam feedbackParam){
        PaginationData<List<FeedbackVO>> userFeedbackList = feedbackService.getUserFeedbackList(feedbackParam);
        return new Result<>(userFeedbackList);
    }

}
