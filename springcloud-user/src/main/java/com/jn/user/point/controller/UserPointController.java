package com.jn.user.point.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.enums.UserPointExceptionEnum;
import com.jn.user.model.PointDeductionParam;
import com.jn.user.model.PointDeductionVO;
import com.jn.user.model.PointIncomeParam;
import com.jn.user.model.PointOrderPayParam;
import com.jn.user.point.model.*;
import com.jn.user.point.service.UserPointService;
import com.jn.user.userinfo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "积分管理-用户积分")
@RestController
@RequestMapping("/user/point")
public class UserPointController extends BaseController {

    @Autowired
    private UserPointService pointService;
    @Autowired
    private UserInfoService userInfoService;

    @ControllerLog(doAction = "查询当前用户积分")
    @ApiOperation(value = "查询当前用户积分")
    @RequestMapping(value = "/getUserPoint",method = RequestMethod.GET)
    public Result<UserPointVO> getUserPoint(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(pointService.getUserPoint(user.getAccount()));
    }

    @ControllerLog(doAction = "查询用户积分余额列表[后台管理员使用]")
    @ApiOperation(value = "查询用户积分余额列表[后台管理员使用]")
    @RequestMapping(value = "/getUserPointList",method = RequestMethod.GET)
    @RequiresPermissions("/user/point/getUserPointList")
    public Result<PaginationData<List<UserPointVO>>> getUserPointList(UserPointParam userPointParam){
        return new Result<>(pointService.getUserPointList(userPointParam));
    }

    @ControllerLog(doAction = "查询指定用户积分明细[后台管理员使用]")
    @ApiOperation(value = "查询指定用户积分明细[后台管理员使用]")
    @RequestMapping(value = "/getPointDetailByUserAccount",method = RequestMethod.GET)
    @RequiresPermissions("/user/point/getPointDetailByUserAccount")
    public Result<PaginationData<List<UserPointDetailVO>>> getPointDetailByUserAccount(UserPointDetailParam userPointDetailParam){
        return new Result<>(pointService.getUserPointDetail(userPointDetailParam));
    }

    @ControllerLog(doAction = "查询当前用户积分明细")
    @ApiOperation(value = "查询当前用户积分明细")
    @RequestMapping(value = "/getUserPointDetail",method = RequestMethod.GET)
    public Result<PaginationData<List<UserPointDetailVO>>> getUserPointDetail(Page page){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        UserPointDetailParam userPointDetailParam = new UserPointDetailParam();
        BeanUtils.copyProperties(page,userPointDetailParam);
        userPointDetailParam.setUserAccount(user.getAccount());
        return new Result<>(pointService.getUserPointDetail(userPointDetailParam));
    }

    @ControllerLog(doAction = "查询当前用户实名制情况")
    @ApiOperation(value = "查询当前用户实名制情况",notes = "用户只能进行一次实名制，返回true代表已实名制，false代表未实名制。可通过该状态高亮实名制次数和‘去完成’按钮的显示。")
    @RequestMapping(value = "/getUserRealNameStatus",method = RequestMethod.GET)
    public Result<Boolean> getUserRealNameStatus(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(userInfoService.getUserRealNameStatus(user.getAccount()));
    }

    @ControllerLog(doAction = "获取某一功能周期内完成次数")
    @ApiOperation(value = "获取某一功能周期内完成次数",notes = "入参为操作标识[该数据前台固定传值，可在‘积分管理-积分规则-获取积分规则列表 ’接口中查看具体的数值类型，取‘ruleCode’值]。" +
            "返回内容包含周期内已获得积分次数和周期限制总次数。前端可跟据该数据标识‘去完成’的高亮显示")
    @RequestMapping(value = "/getFunctionPointState",method = RequestMethod.GET)
    public Result<UserFunctionPointVO> getFunctionPointState(@ApiParam(name = "ruleCode", value = "操作标识", required = true,example = "check_in")
                                          @RequestParam(value = "ruleCode")String ruleCode){
        Assert.notNull(ruleCode, UserPointExceptionEnum.POINT_RULE_RULE_CODE_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(pointService.getFunctionPointState(ruleCode,user.getAccount()));
    }


    @ControllerLog(doAction = "查询账单抵扣积分详情")
    @ApiOperation(value = "查询账单抵扣积分详情")
    @RequestMapping(value = "/orderPointDeduction",method = RequestMethod.GET)
    public Result<PointDeductionVO> orderPointDeduction(@ApiParam(name = "billIds", value = "账单标识[数组]", required = true,example = "['1234***','123***']")
                                                        @RequestParam(value = "billIds")String[] billIds){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PointDeductionParam pointDeductionParam = new PointDeductionParam();
        pointDeductionParam.setAccount(user.getAccount());
        pointDeductionParam.setBillIds(billIds);
        return new Result<>(pointService.orderPointDeduction(pointDeductionParam));
    }

    @ControllerLog(doAction = "积分收入测试")
    @ApiOperation(value = "积分收入[测试接口]",notes = "积分收入为业务层代码调用，此次仅提供测试入口。前端请忽略该接口")
    @RequestMapping(value = "/updatePointRuleInfo",method = RequestMethod.POST)
    public Result<Boolean> userPointIncome(@RequestBody @Validated PointIncomeParam pointIncomeParam){
        return new Result<>(pointService.userPointIncome(pointIncomeParam));
    }

}
