package com.jn.user.point.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.enums.UserPointExceptionEnum;
import com.jn.user.point.model.PointRuleParam;
import com.jn.user.point.model.PointRuleVO;
import com.jn.user.point.service.PointRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/15 9:27
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "积分管理-积分规则[前台]")
@RestController
@RequestMapping("/guest/user/point")
public class UserPointRuleController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserPointRuleController.class);

    @Autowired
    private PointRuleService pointRuleService;

    @ControllerLog(doAction = "获取积分规则列表")
    @ApiOperation(value = "获取积分规则列表",notes = "不分页查询")
    @RequestMapping(value = "/getPointRuleList",method = RequestMethod.GET)
    public Result<List<PointRuleVO>> getPointRuleList(@ApiParam(name = "ruleType", value = "规则类型[1收入规则2支出规则]", required = true,example = "1")
                                                                          @RequestParam(value = "ruleType")String ruleType){
        Assert.notNull(ruleType, UserPointExceptionEnum.POINT_RULE_TYPE_IS_NOT_EXIST.getMessage());
        List<PointRuleVO> frontPointRuleList = pointRuleService.getFrontPointRuleList(ruleType);
        return new Result<>(frontPointRuleList);
    }


}
