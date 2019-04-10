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
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * 我的话题【后台接口】
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:35
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "我的管理-话题管理[后端接口]")
@RestController
@RequestMapping(value = "/manage/gam/topic")
public class GamTopicManageController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(GamTopicManageController.class);

    @Autowired
    private GamTopicService gamTopicService;

    @ControllerLog(doAction = "删除话题[后台管理接口使用]")
    @ApiOperation(value = "删除话题[后台管理接口使用]",notes = "根据话题ID删除话题（该接口只提供给后台管理用）。返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/deleteGamTopicForAdmin",method = RequestMethod.POST)
    @RequiresPermissions("/manage/gam/topic/deleteGamTopicForAdmin")
    public Result<Integer> deleteGamTopicForAdmin(@ApiParam(name = "topicId", value = "话题ID", required = true,example = "s342***")String topicId){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(gamTopicService.deleteGamTopicForAdmin(topicId,user.getAccount()));
    }


    @ControllerLog(doAction = "根据条件查询用户话题列表[后台管理接口]")
    @ApiOperation(value = "根据条件查询用户话题列表[后台管理接口]",notes = "该接口只提供给后台管理用")
    @RequestMapping(value = "/getGamTopicListByParam",method = RequestMethod.GET)
    @RequiresPermissions("/manage/gam/topic/getGamTopicListByParam")
    public Result<PaginationData<List<GamTopicVO>>> getGamTopicListByParam(GamTopicParam gamTopicParam){
        PaginationData<List<GamTopicVO>> myGamTopicList = gamTopicService.getGamTopicListByParam(gamTopicParam);
        return new Result<>(myGamTopicList);
    }

}
