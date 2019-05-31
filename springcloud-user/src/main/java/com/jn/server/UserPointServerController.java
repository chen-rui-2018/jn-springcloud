package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.api.UserPointServerClient;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.model.PointDeductionParam;
import com.jn.user.model.PointDeductionVO;
import com.jn.user.model.PointIncomeParam;
import com.jn.user.model.PointOrderPayParam;
import com.jn.user.point.service.UserPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 用户积分服务
 * @Author: jiangyl
 * @Date: 2019/3/19 14:09
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户积分服务")
@RestController
@RequestMapping("/api/user/point")
public class UserPointServerController extends BaseController implements UserPointServerClient {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(UserPointServerController.class);

    @Autowired
    private UserPointService userPointService;


    @ControllerLog(doAction = "用户积分收入")
    @ApiOperation(value = "用户积分收入",notes = "业务层调用，传当前用户和积分规则标识即可")
    @RequestMapping(value = "/userPointIncome",method = RequestMethod.POST)
    @Override
    public Result<Boolean> userPointIncome(@RequestBody @Validated PointIncomeParam pointIncomeParam) {
        return new Result(userPointService.userPointIncome(pointIncomeParam));
    }

    @ControllerLog(doAction = "查询账单抵扣积分详情")
    @ApiOperation(value = "查询账单抵扣积分详情")
    @RequestMapping(value = "/orderPointDeduction",method = RequestMethod.POST)
    @Override
    public Result<PointDeductionVO> orderPointDeduction(@RequestBody PointDeductionParam pointDeductionParam){
        return new Result<>(userPointService.orderPointDeduction(pointDeductionParam));
    }

    @ControllerLog(doAction = "账单发起支付，积分预扣除接口")
    @ApiOperation(value = "账单发起支付，积分预扣除接口")
    @RequestMapping(value = "/pointPreDeduction",method = RequestMethod.POST)
    @Override
    public Result<Boolean> pointPreDeduction(@RequestBody PointOrderPayParam pointOrderPayParam){
        return new Result<>(userPointService.pointPreDeduction(pointOrderPayParam));
    }

    @ControllerLog(doAction = "支付成功，积分扣除接口")
    @ApiOperation(value = "支付成功，积分扣除接口")
    @RequestMapping(value = "/orderPaySuccessPointDeduction",method = RequestMethod.POST)
    @Override
    public Result<Boolean> orderPaySuccessPointDeduction(@RequestBody String orderId){
        return new Result<>(userPointService.orderPaySuccessPointDeduction(orderId));
    }

    @ControllerLog(doAction = "支付失败/取消支付，积分退回（回滚）接口")
    @ApiOperation(value = "支付失败/取消支付，积分退回（回滚）接口")
    @RequestMapping(value = "/orderPayErrorPointReturn",method = RequestMethod.POST)
    @Override
    public Result<Boolean> orderPayErrorPointReturn(@RequestBody String orderId){
        return new Result<>(userPointService.orderPayErrorPointReturn(orderId));
    }

}
