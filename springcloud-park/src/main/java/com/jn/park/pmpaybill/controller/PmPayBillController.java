package com.jn.park.pmpaybill.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.plan.model.ProjectManageModel;
import com.jn.park.plan.model.ProjectModel;
import com.jn.park.pmpaybill.entity.TbPmPayBillItem;
import com.jn.park.pmpaybill.service.PmPayBillService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2019/5/31 21:01
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "物业服务-物业费管理")
@RestController
@RequestMapping(value = "/park/PmPayBill")
public class PmPayBillController extends BaseController {

    @Autowired
    private PmPayBillService pmPayBillService;

    @ControllerLog(doAction = "批量生成物业费缴费单")
    @ApiOperation(value = "批量生成物业费缴费单", notes = "批量生成物业费缴费单")
    @RequestMapping(value = "/generatePmPayBill", method = RequestMethod.POST)
    @RequiresPermissions("/park/PmPayBill/generatePmPayBill")
    public Result generatePmPayBill(@RequestBody List<TbPmPayBillItem> pmPayBillItems) {
        //批量生成缴费单
        pmPayBillService.generatePmBill(pmPayBillItems);
        return new Result();
    }

}
