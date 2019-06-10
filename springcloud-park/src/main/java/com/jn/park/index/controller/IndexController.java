package com.jn.park.index.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.index.enums.IndexExceptionEnum;
import com.jn.park.index.model.Achievement;
import com.jn.park.index.model.AchievementParam;
import com.jn.park.index.model.ImportantNews;
import com.jn.park.index.model.ImportantNewsParam;
import com.jn.park.index.service.IndexService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页
 * @author： huxw
 * @date： Created on 2019-4-16 16:17:08
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "首页")
@RestController
@RequestMapping("/guest/IndexController")
public class IndexController extends BaseController {

    @Autowired
    private IndexService indexService;

    @ControllerLog(doAction = "重要消息列表")
    @ApiOperation(value = "重要消息列表", notes = "获取重要消息列表")
    @RequestMapping(value = "/getImportantNewsList",method = RequestMethod.GET)
    public Result<PaginationData<List<ImportantNews>>> getImportantNewsList(@Validated ImportantNewsParam importantNewsParam) {
        Page<Object> objects = PageHelper.startPage(importantNewsParam.getPage(), importantNewsParam.getRows());
        List<ImportantNews> importantNewsList = indexService.getImportantNewsList(importantNewsParam);
        return new Result(new PaginationData(importantNewsList, objects.getTotal()));
    }

    @ControllerLog(doAction = "成果列表")
    @ApiOperation(value = "成果列表", notes = "获取园区成果列表")
    @RequestMapping(value = "/getAchievementList",method = RequestMethod.GET)
    public Result<PaginationData<List<Achievement>>> getAchievementList(@Validated AchievementParam achievementParam) {
        Page<Object> objects = PageHelper.startPage(achievementParam.getPage(), achievementParam.getRows());
        List<Achievement> achievementList = indexService.getAchievementList(achievementParam);
        return new Result(new PaginationData(achievementList, objects.getTotal()));
    }

    @ControllerLog(doAction = "成果详情")
    @ApiOperation(value = "成果详情", notes = "获取成果详情")
    @RequestMapping(value = "/getAchievementDetails",method = RequestMethod.GET)
    public Result<Achievement> getAchievementDetails(@RequestParam(required = false) String achievementId) {
        Assert.notNull(achievementId, IndexExceptionEnum.PARAM_IS_NULL.getMessage());
        return new Result(indexService.getAchievementDetails(achievementId));
    }

}
