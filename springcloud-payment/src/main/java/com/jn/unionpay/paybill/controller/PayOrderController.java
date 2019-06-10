package com.jn.unionpay.paybill.controller;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.paybill.model.PayOrderModel;
import com.jn.paybill.model.PayOrderVO;
import com.jn.paybill.model.PaymentBill;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.service.PayBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单支付
 * @author： jiangyl
 * @date： Created on 2019/4/3 10:53
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "统一缴费-前端订单")
@RestController
@RequestMapping("/pay/bill")
public class PayOrderController {

    @Autowired
    private PayBillService payBillService;

    @ControllerLog(doAction = "取消支付订单")
    @ApiOperation(value = "取消支付订单",notes = "反正值为数据响应接口，正常为1。传值请不要加引号")
    @RequestMapping(value = "/cancelPayOrderById",method = RequestMethod.POST)
    public Result<Integer> cancelPayOrderById(@ApiParam(name = "orderId", value = "订单ID", required = true,example = "s342***")@RequestBody String orderId){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Integer integer = payBillService.cancelPayOrderById(orderId, user.getAccount());
        return new Result<>(integer);
    }

    @ControllerLog(doAction = "获取当前用户订单列表")
    @ApiOperation(value = "获取当前用户订单列表",notes = "支持分页查询，只能查询当前用户数据")
    @RequestMapping(value = "/getBillList",method = RequestMethod.GET)
    public Result<PaginationData<List<PayOrderModel>>> getPayOrderForUser(Page page){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<PayOrderModel>> payOrderForUser = payBillService.getPayOrderForUser(page, user.getAccount());
        return new Result<>(payOrderForUser);
    }

    @ControllerLog(doAction = "根据支付订单ID查询详情")
    @ApiOperation(value = "根据支付订单ID查询详情")
    @RequestMapping(value = "/getPayOrderDetail",method = RequestMethod.GET)
    public Result<PayOrderVO> getPayOrderDetail(@ApiParam(name = "orderId", value = "订单ID", required = true,example = "s342***")@RequestParam String orderId){
        return new Result<>(payBillService.getPayOrderDetail(orderId));
    }


}
