package com.jn.enterprise.pay.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.pay.model.PayAccountBookMoneyRecord;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 我的账户管理（视图层）
 *
 * @author： wzy
 * @date： Created on 2019/5/5 11:43
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "统一缴费-我的账户")
@RestController
@RequestMapping("/guest/payment/payAccount")
public class MyPayAccountController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MyPayAccountController.class);

    @Autowired
    private MyPayAccountService myPayAccountService;

    @ControllerLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @ApiOperation(value = "我的账户-查询当前账户下所有账本信息",notes = "我的账户-查询当前账户下所有账本信息")
    @RequestMapping(value = "/queryPayAccountBook",method = RequestMethod.GET)
    public Result<PayAccountAndAccountBookVo> queryPayAccountBook(@ApiParam(name="userId",value = "登录人账号",required = true,example = "wangsong") @RequestParam(value = "userId") String userId){
        PayAccountAndAccountBookVo data = myPayAccountService.queryPayAccountBook(userId);
        return new Result(data);
    }

    @ControllerLog(doAction = "我的账本-查询当前账本下所有明细信息")
    @ApiOperation(value = "我的账本-查询当前账本下所有明细信息",notes = "我的账本-查询当前账本下所有明细信息")
    @RequestMapping(value = "/queryPayAccountDetails",method = RequestMethod.POST)
    public Result<PaginationData<List<PayAccountBookMoneyRecord>>> queryPayAccountDetails(@ApiParam(name="acBookId",value = "账本编号",required = true,example = "20190504123") @RequestParam(value = "acBookId") String acBookId,
                                                                                          @ApiParam(name="startDate",value = "查询时间起",example = "2019-05-10 11:28:48") @RequestParam(value = "startDate",required = false) String startDate,
                                                                                          @ApiParam(name="endDate",value = "查询时间止",example = "2019-05-13 11:28:48") @RequestParam(value = "endDate",required = false) String endDate,
                                                                                          @ApiParam(name="page",value = "当前页数",required = true,example = "1") @RequestParam(value = "page") int page,
                                                                                          @ApiParam(name="rows",value = "每页显示数量",required = true,example = "10") @RequestParam(value = "rows") int rows){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(acBookId,"账本编号不能为空");
        PaginationData<List<PayAccountBookMoneyRecord>> data = myPayAccountService.queryPayAccountDetails(user,acBookId,startDate,endDate,page,rows);
        return new Result(data);
    }


}
