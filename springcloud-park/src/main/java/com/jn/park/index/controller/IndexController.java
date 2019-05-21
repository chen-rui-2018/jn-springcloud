package com.jn.park.index.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
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

//    @ControllerLog(doAction = "推荐-服务搜索")
//    @ApiOperation(value = "推荐-服务搜索（APP）", notes = "根据活动名称，政策服务，商务服务名称[模糊搜索]", hidden = true)
//    @RequestMapping(value = "/serviceSearch", method = RequestMethod.GET)
//    public Result<PaginationData> serviceSearch(@Validated ServiceSearchParam serviceSearchParam){
//        // 检索关键字
//        String searchFiledStr = serviceSearchParam.getSearchFiled();
//        PaginationData paginationData = new PaginationData();
//
//        // 判断搜索类型
//        if (serviceSearchParam.getServiceType().equals(IndexDataEnum.SERVICE_TYPE_ACTIVITY.getCode())) {
//            ActivitySlimQuery activitySlimQuery = new ActivitySlimQuery();
//            BeanUtils.copyProperties(serviceSearchParam, activitySlimQuery);
//            activitySlimQuery.setKeyWord(searchFiledStr);
//            paginationData = activityService.activityListSlim(activitySlimQuery);
//        } else if (serviceSearchParam.getServiceType().equals(IndexDataEnum.SERVICE_TYPE_POLICY.getCode())) {
//            PolicyCenterHomeParam policyCenterHomeParam = new PolicyCenterHomeParam();
//            BeanUtils.copyProperties(serviceSearchParam, policyCenterHomeParam);
//            policyCenterHomeParam.setPolicySearch(searchFiledStr);
//
//            // 如果未传table类型，默认查询政策一览
//            String tableTypeCode = StringUtils.isEmpty(serviceSearchParam.getTableType())
//                    ? IndexDataEnum.ALL_POLICY.getCode() : serviceSearchParam.getTableType();
//            String tableTypeName = "";
//
//            if (tableTypeCode.equals(IndexDataEnum.ALL_POLICY.getCode())) {
//                tableTypeName = IndexDataEnum.ALL_POLICY.getMessage();
//
//                // 设置政策类型，不传默认普通政策
//                policyCenterHomeParam.setPolicyType(StringUtils.isEmpty(serviceSearchParam.getPolicyType()) ? "0" : serviceSearchParam.getPolicyType());
//            } else if (tableTypeCode.equals(IndexDataEnum.DIAGRAM_POLICY.getCode())) {
//                tableTypeName = IndexDataEnum.DIAGRAM_POLICY.getMessage();
//            } else if (tableTypeCode.equals(IndexDataEnum.FIRST_TOPIC.getCode())) {
//                tableTypeName = IndexDataEnum.FIRST_TOPIC.getMessage();
//            } else if (tableTypeCode.equals(IndexDataEnum.PRIVATE_TOPIC.getCode())) {
//                tableTypeName = IndexDataEnum.PRIVATE_TOPIC.getMessage();
//            } else {
//                throw new JnSpringCloudException(IndexExceptionEnum.POLICY_TYPE_NOT_VALID);
//            }
//
//            policyCenterHomeParam.setTableType(tableTypeName);
//            paginationData = policyCenterService.getPolicyCenterList(policyCenterHomeParam);
//        }  else {
//            throw new JnSpringCloudException(IndexExceptionEnum.PARAM_IS_NULL);
//        }
//
//        return new Result<>(paginationData);
//    }

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

    @ControllerLog(doAction = "增加成果点击量")
    @ApiOperation(value = "增加成果点击量", notes = "成果点击量增加，成功返回1")
    @RequestMapping(value = "/addAchievementClick",method = RequestMethod.GET)
    public Result<Integer> addAchievementClick(@RequestParam String achievementId) {
        return new Result(indexService.addAchievementClick(achievementId));
    }

}
