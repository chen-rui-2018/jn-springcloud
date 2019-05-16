package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.hatch.service.HatchHomeConfigService;
import com.jn.park.hatch.api.HatchhomeConfigClient;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


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

    @Override
    @ControllerLog(doAction = "孵化企业-新增入孵企业信息")
    public Result insertEnterpriseInfo(HatchIncubatorEnterpriseParamModel hatchIncubatorEnterpriseParamModel) {
        hatchHomeConfigService.insertEnterpriseInfo(hatchIncubatorEnterpriseParamModel);
        return new Result();
    }

    @Override
    @ControllerLog(doAction = "孵化企业-新增入孵团队信息")
    public Result insertTeamInfo(HatchIncubatorTeamParamModel hatchIncubatorTeamParamModel) {
        hatchHomeConfigService.insertTeamInfo(hatchIncubatorTeamParamModel);
        return new Result();
    }




}
