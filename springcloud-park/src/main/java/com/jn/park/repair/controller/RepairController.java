package com.jn.park.repair.controller;

import com.jn.common.controller.BaseController;

import com.jn.common.model.Result;

import com.jn.park.repair.service.RepairService;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 物业管理-企业报修
 * @Author: yuanyy
 * @Date: 2019/03/27 15:48
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "物业管理-企业报修")
@RestController
@RequestMapping(value = "/park/property/repair")
public class RepairController extends BaseController {


    @Autowired
    private RepairService repairService;

    @ControllerLog(doAction = "创建报修缴费单")
    @ApiOperation(value = "创建报修缴费单",notes = "企业报修-创建报修缴费单")
    @RequestMapping(value = "/generateBill",method = RequestMethod.POST)
    public Result<Integer> generateBill(@RequestBody PayBillCreateParamVo payBillCreateParamVo){
        repairService.generateBill(payBillCreateParamVo);
        return new Result<>();
    }



}
