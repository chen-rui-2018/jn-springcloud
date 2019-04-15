package com.jn.user.point.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.enums.UserPointExceptionEnum;
import com.jn.user.point.model.PointRuleModel;
import com.jn.user.point.model.PointRuleVO;
import com.jn.user.point.model.PointRuleParam;
import com.jn.user.point.service.PointRuleService;
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

/**
 * 积分规则
 * @author： jiangyl
 * @date： Created on 2019/4/3 15:59
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "积分管理-积分规则[后台]")
@RestController
@RequestMapping("/point/rule/")
public class PointRuleController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(PointRuleController.class);

    @Autowired
    private PointRuleService pointRuleService;

    @ControllerLog(doAction = "获取积分规则列表")
    @ApiOperation(value = "获取积分规则列表",notes = "规则代码/规则名称无字典数据，积分规则只能修改，不能新增及删除")
    @RequestMapping(value = "/getPointRuleList",method = RequestMethod.GET)
    public Result<PaginationData<List<PointRuleVO>>> getPointRuleList(PointRuleParam pointRuleParam){
        PaginationData<List<PointRuleVO>> pointRuleList = pointRuleService.getPointRuleList(pointRuleParam);
        return new Result<>(pointRuleList);
    }


    @ControllerLog(doAction = "获取积分规则详情")
    @ApiOperation(value = "获取积分规则详情",notes = "入参为积分规则ID")
    @RequestMapping(value = "/getPointRuleDetail",method = RequestMethod.GET)
    public Result<PointRuleVO> getPointRuleDetail(@ApiParam(name = "ruleId", value = "积分规则ID", required = true,example = "aea8167ff8c24b28a24c900dcfad334b")
                                                         @RequestParam(value = "ruleId")String ruleId){
        Assert.notNull(ruleId, UserPointExceptionEnum.POINT_RULE_RULE_ID_IS_NOT_NULL.getMessage());
        PointRuleVO pointRuleDetail = pointRuleService.getPointRuleDetail(ruleId);
        return new Result<>(pointRuleDetail);
    }

    @ControllerLog(doAction = "修改积分规则信息")
    @ApiOperation(value = "修改积分规则信息",notes = "返回值为数据响应条数，正常为1")
    @RequestMapping(value = "/updatePointRuleInfo",method = RequestMethod.POST)
    public Result<Integer> updatePointRuleInfo(@RequestBody @Validated PointRuleModel pointRuleModel){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Integer i =  pointRuleService.updatePointRuleInfo(pointRuleModel,user.getAccount());
        return new Result<>(i);
    }



}
