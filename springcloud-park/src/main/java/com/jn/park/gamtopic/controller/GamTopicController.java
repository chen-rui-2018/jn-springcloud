package com.jn.park.gamtopic.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.gamtopic.model.GamTopic;
import com.jn.park.gamtopic.model.GamTopicParam;
import com.jn.park.gamtopic.model.GamTopicVO;
import com.jn.park.gamtopic.service.GamTopicService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 我的话题
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:35
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "我的管理-我的话题")
@RestController
@RequestMapping(value = "/user/gam/topic")
public class GamTopicController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(GamTopicController.class);

    @Autowired
    private GamTopicService gamTopicService;

    @ControllerLog(doAction = "新增话题")
    @ApiOperation(value = "新增话题",notes = "新增话题，话题类型包括[1公开2关注可看3私密]，不传类型默认为公开。返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/saveGamTopic",method = RequestMethod.POST)
    public Result<Integer> saveGamTopic(@Validated @RequestBody GamTopic gamTopic){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(gamTopicService.saveGamTopic(gamTopic,user.getAccount()));
    }

    @ControllerLog(doAction = "删除话题[前端使用]")
    @ApiOperation(value = "删除话题[前端使用]",notes = "根据话题ID删除话题（只能删除当前用户的话题数据）。返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/deleteGamTopic",method = RequestMethod.POST)
    public Result<Integer> deleteGamTopic(@ApiParam(name = "topicId", value = "话题ID", required = true,example = "s342***")String topicId){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(gamTopicService.deleteGamTopic(topicId,user.getAccount()));
    }

    @ControllerLog(doAction = "查询当前用户话题列表[前端使用]")
    @ApiOperation(value = "查询当前用户话题列表[前端用户]",notes = "查询当前用户话题列表")
    @RequestMapping(value = "/getMyGamTopicList",method = RequestMethod.GET)
    public Result<PaginationData<List<GamTopicVO>>> getMyGamTopicList(Page page){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<GamTopicVO>> myGamTopicList = gamTopicService.getMyGamTopicList(page, user.getAccount());
        return new Result<>(myGamTopicList);
    }


}
