package com.jn.park.hatch.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.hatch.model.HatchUpdateRevenueParamModel;
import com.jn.park.hatch.service.HatchEntAndTeamService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 在孵企业（团队）管理
 *
 * @author： wzy
 * @date： Created on 2019/5/15 9:50
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "孵化企业-在孵企业（团队）管理")
@RestController
@RequestMapping("/guest/hatch/incubator/entAndTeam")
public class HatchEntAndTeamController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(HatchEntAndTeamController.class);
    @Autowired
    private HatchEntAndTeamService hatchEntAndTeamService;

    @ControllerLog(doAction = "孵化企业-更新企业税收-营收-投资额")
    @ApiOperation(value = "孵化企业-更新企业税收-营收-投资额", notes = "孵化企业-更新企业税收-营收-投资额")
    @RequestMapping(value = "/updateRevenue" ,method = RequestMethod.POST)
    public Result updateRevenue(@RequestBody @Validated HatchUpdateRevenueParamModel hatchUpdateRevenueParamModel) {
         Result result = hatchEntAndTeamService.updateRevenue(hatchUpdateRevenueParamModel);
        return result;
    }
}
