package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.hatch.model.HatchUpdateRevenueParamModel;
import com.jn.park.hatch.service.HatchEntAndTeamService;
import com.jn.park.hatch.service.HatchHomeConfigService;
import com.jn.park.hatch.api.HatchhomeConfigClient;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author： wzy
 * @date： Created on 2019/5/9 17:44
 * @version： v1.0
 * @modified By:
 */
@RestController
public class HatchServerController extends BaseController implements HatchhomeConfigClient {

    @Autowired
    private HatchHomeConfigService hatchHomeConfigService;

    @Autowired
    private HatchEntAndTeamService hatchEntAndTeamService;

    @Override
    @ControllerLog(doAction = "孵化企业-新增入孵企业信息")
    public Result insertEnterpriseInfo(@RequestBody @Validated HatchIncubatorEnterpriseParamModel hatchIncubatorEnterpriseParamModel) {
        return hatchHomeConfigService.insertEnterpriseInfo(hatchIncubatorEnterpriseParamModel);
    }

    @Override
    @ControllerLog(doAction = "孵化企业-新增入孵团队信息")
    public Result insertTeamInfo(@RequestBody @Validated HatchIncubatorTeamParamModel hatchIncubatorTeamParamModel) {
        return hatchHomeConfigService.insertTeamInfo(hatchIncubatorTeamParamModel);
    }

    @Override
    @ControllerLog(doAction = "孵化企业-更新企业税收-营收-投资额")
    public Result updateRevenue(@RequestBody @Validated HatchUpdateRevenueParamModel hatchUpdateRevenueParamModel) {
        return hatchEntAndTeamService.updateRevenue(hatchUpdateRevenueParamModel);
    }

    @Override
    @ControllerLog(doAction = "孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】")
    public Result updateGraduateRegister() {
        return hatchEntAndTeamService.updateGraduateegister();
    }

    @Override
    @ControllerLog(doAction = "孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】")
    public Result updateGraduateRevenue() {
        return hatchEntAndTeamService.updateGraduateRevenue();
    }

    @Override
    @ControllerLog(doAction = "孵化企业-更新在孵企业（团队）报名活动项")
    public Result updateEnrolmentActivit() {
        return hatchEntAndTeamService.updateEnrolmentActivit();
    }

    @Override
    @ControllerLog(doAction = "孵化企业-更新在孵企业（团队）政策申报项")
    public Result updatePolicyDeclarate() {
        return hatchEntAndTeamService.updatePolicyDeclarate();
    }


}
