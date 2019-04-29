package com.jn.server;

import com.jn.common.model.Result;
import com.jn.park.api.BusinessAdClient;
import com.jn.park.attractinvest.service.BusinessAdService;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： shaobao
 * @date： Created on 2019/4/24 20:12
 * @version： v1.0
 * @modified By:
 **/
@RestController
public class BusinessAdServerController implements BusinessAdClient {

    @Autowired
    private BusinessAdService businessAdService;

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
}
