package com.jn.park.finance.controller;

import com.jn.common.model.Result;
import com.jn.park.finance.vo.FinanceIncomeSummarizingProportionVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-定时器")
@RestController
@RequestMapping("/finance/timer")
public class FinanceTimerController {


    @ControllerLog(doAction = "")
    @ApiOperation(value = "", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/")
    @RequiresPermissions("/finance/timer/")
    public Result summarizingProportion(){
        // TODO: 2019/3/21  
        return new Result(new Result<List<Map<String,Object>>>());
    }
}
