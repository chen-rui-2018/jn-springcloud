package com.jn.park.gamtopic.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.gamtopic.model.DynamicManageDetails;
import com.jn.park.gamtopic.model.DynamicManageShow;
import com.jn.park.gamtopic.model.DynamicQueryParam;
import com.jn.park.gamtopic.service.DynamicService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 15:03
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "同园社交--动态管理(后台)")
@RestController
@RequestMapping(value="park/manage/dynamic")
public class DynamicManageController extends BaseController {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DynamicManageController.class);
    @Autowired
    private DynamicService dynamicService;

    @ControllerLog(doAction = "动态列表")
    @ApiOperation(value ="动态列表",notes = "根据条件返回动态列表")
    @RequestMapping(value="/findDynamicList",method = RequestMethod.GET)
    public Result<PaginationData<List<DynamicManageShow>>> findDynamicList(DynamicQueryParam queryParam){
        PaginationData data = dynamicService.findDynamicList(queryParam);
        return new Result<>(data);
    }
    @ControllerLog(doAction = "动态详情")
    @ApiOperation(value ="动态详情",notes = "根据动态id 返回动态详情")
    @RequestMapping(value="/findDynamicDetails",method = RequestMethod.GET)
    public Result<DynamicManageDetails> findDynamicDetails(@ApiParam(value="动态id",name ="dynamicId",required = true,example = "ebf75324ccbe4614afbad37ca920aa08" ) @RequestParam(value = "dynamicId") String  dynamicId){
        DynamicManageDetails data = dynamicService.findDynamicDetails(dynamicId);
        return new Result<>(data);
    }
    @ControllerLog(doAction = "删除动态")
    @ApiOperation(value ="删除动态",notes = "根据动态id 删除当前动态,返回删除的动态条数,正常为1")
    @RequestMapping(value="/deleteDynamicInfo",method = RequestMethod.POST)
    public Result deleteDynamicInfo(@ApiParam(value="动态id",name ="dynamicId",required = true,example = "ebf75324ccbe4614afbad37ca920aa08" ) @RequestParam(value = "dynamicId") String  dynamicId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int i  = dynamicService.deleteDynamicInfo(dynamicId,user==null ? "":user.getAccount());
        return new Result<>(i);
    }


}
