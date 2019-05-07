package com.jn.park.gamtopic.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.service.DynamicService;
import com.jn.park.gamtopic.vo.DnnamicCommentDetailsVo;
import com.jn.park.gamtopic.vo.DynamicWebDetailsVo;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 10:49
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "同园社交--动态相关(前端)")
@RestController
@RequestMapping(value="park/web/dynamic")
public class DynamicWebController extends BaseController {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DynamicWebController.class);

    @Autowired
    private DynamicService dynamicService;


    @ControllerLog(doAction = "发布动态")
    @ApiOperation(value ="发布动态",notes = "返回值为新增的动态数,正常为1")
    @RequestMapping(value="/addDynamic",method = RequestMethod.POST)
    public Result addDynamicInfo(@Validated @RequestBody DynamicAddParam dynamicAddParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String dynamicId  = UUID.randomUUID().toString().replaceAll("-","");
        int  i = dynamicService.addDynamicInfo(dynamicAddParam,dynamicId,user==null?"":user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "动态列表")
    @ApiOperation(value ="动态列表",notes = "返回用户可查看的动态列表")
    @RequestMapping(value="/findDynamicList",method = RequestMethod.GET)
    public Result<PaginationData<List<DynamicWebShow>>> findDynamicList(Page page){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = dynamicService.findDynamicWebList(page,user==null? "" : user.getAccount());
        return new Result<>(data);
    }
    @ControllerLog(doAction = "关注的用户动态列表")
    @ApiOperation(value ="关注的用户动态列表",notes = "返回用户关注的用户的动态列表")
    @RequestMapping(value="/findCareDynamicList",method = RequestMethod.GET)
    public Result<PaginationData<List<DynamicWebShow>>> findCareDynamicList(Page page){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = dynamicService.findCareDynamicList(page,user==null? "" : user.getAccount());
        return new Result<>(data);
    }
    @ControllerLog(doAction = "动态详情")
    @ApiOperation(value ="动态详情",notes = "动态内容加评论信息")
    @RequestMapping(value="/findDynamicDetails",method = RequestMethod.GET)
    public Result<DynamicWebDetailsVo> findDynamicDetails(@ApiParam(value="动态id",name = "dynamicId",required = true,example = "ebf75324ccbe4614afbad37ca920aa08")@RequestParam("dynamicId") String dynamicId){
        DynamicWebDetailsVo data = dynamicService.findDynamicWebDetails(dynamicId);
        return new Result<>(data);
    }
    @ControllerLog(doAction = "动态评论列表")
    @ApiOperation(value ="动态评论列表",notes = "根据动态id,返回评论列表")
    @RequestMapping(value="/findDynamicComments",method = RequestMethod.GET)
    public Result<PaginationData<List<DynamicComments>>> findDynamicComments(DynamicCommentsParam param){
        PaginationData<List<DynamicComments>> data = dynamicService.findDynamicComments(param);
        return new Result<>(data);
    }
    @ControllerLog(doAction = "动态评论详情")
    @ApiOperation(value ="动态评论详情",notes = "根据评论id,返回论信息和评论回复列表")
    @RequestMapping(value="/findDynamicCommentsDetails",method = RequestMethod.GET)
    public Result<DnnamicCommentDetailsVo> findDynamicCommentsDetails(@ApiParam(value="评论id",name = "commentId",required = true,example = "fdc46ece154f43648fc278a80b904xxx")@RequestParam("commentId") String commentId){
        DnnamicCommentDetailsVo vo = dynamicService.findDynamicCommentsDetails(commentId);
        return new Result<>(vo);
    }
    @ControllerLog(doAction = "评论回复列表")
    @ApiOperation(value ="评论回复列表",notes = "根据评论id,评论回复列表")
    @RequestMapping(value="/findCommentReplyList",method = RequestMethod.GET)
    public Result<PaginationData<List<DynamicComments>>> findCommentReplyList(DynamicCommentsParam param){
        PaginationData<List<DynamicComments>> data = dynamicService.findCommentReplyList(param);
        return new Result<>(data);

    }
    @ControllerLog(doAction = "点赞人列表")
    @ApiOperation(value ="点赞人列表",notes = "根据评论id/动态id,返回点赞人的列表")
    @RequestMapping(value="/findLikedUserInfoList",method = RequestMethod.GET)
    public Result<PaginationData<List<LikedUserInfo>>> findLikedUserInfoList(DynamicCommentsParam param){
        PaginationData<List<LikedUserInfo>> data = dynamicService.findLikedUserInfoList(param);
        return new Result<>(data);

    }
    @ControllerLog(doAction = "当前用户动态列表")
    @ApiOperation(value ="当前用户动态列表",notes = "根据评用户账号,当前用户动态列表")
    @RequestMapping(value="/findDynamicByAccount",method = RequestMethod.GET)
    public Result<PaginationData< List<DynamicWebShow>>> findDynamicByAccount(CareDetailsQueryParam param){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData< List<DynamicWebShow>> data = dynamicService.findDynamicByAccount(param,user==null?"":user.getAccount());
        return new Result<>(data);

    }





}
