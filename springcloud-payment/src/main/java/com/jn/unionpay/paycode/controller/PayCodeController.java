package com.jn.unionpay.paycode.controller;

import com.jn.common.model.Result;
import com.jn.paycode.model.PaymentCode;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.unionpay.paycode.service.PayCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 支付字典查询
 * @author： jiangyl
 * @date： Created on 2019/3/12 17:27
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "支付字典值")
@RestController
@RequestMapping("/guest/pay/code")
public class PayCodeController {

    @Autowired
    private PayCodeService payCodeService;

    @ControllerLog(doAction = "查询账单类型数据")
    @ApiOperation(value = "查询账单类型数据", notes = "查询账单类型，不分页查询，保存账单时账单类型存该接口对应的字典ID")
    @RequestMapping(value = "/getBillTypeList",method = RequestMethod.GET)
    public Result<List<PaymentCode>> getBillTypeList(){
        return new Result<>(payCodeService.getBillTypeList());
    }


}
