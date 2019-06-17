package com.jn.server;

import com.jn.common.model.Result;
import com.jn.park.api.BusinessAdClient;
import com.jn.park.attractinvest.service.BusinessAdService;
import com.jn.park.attractinvest.service.ProjectInfoService;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目管理api接口
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 20:12
 * @version： v1.0
 * @modified By:
 **/
@RestController
public class BusinessAdServerController implements BusinessAdClient {

    @Autowired
    private BusinessAdService businessAdService;

    @Autowired
    private ProjectInfoService projectInfoService;

    /**
     * 定时更新招商信息,招商动态,招商政策状态
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "获取政策中心首页列表")
    public Result<Boolean> updateBusinessAdStatus() {
        businessAdService.updateBusinessAdStatus();
        return new Result<>(true);
    }

    /**
     * 定时更新项目管理拟制合同状态
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "定时更新项目管理拟制合同状态")
    public Result<Boolean> updateProjectInfoStatus() {
        projectInfoService.updateProjectInfoStatus();
        return new Result<>(true);
    }

    /**
     * 项目管理，拟制合同状态不正常提醒功能
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "项目管理，拟制合同状态不正常提醒功能")
    public Result<Boolean> projectRemind() {
        projectInfoService.projectRemind();
        return new Result<>(true);
    }
}
