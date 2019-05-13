package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.CareClient;
import com.jn.park.care.model.CareParam;
import com.jn.park.gamtopic.model.CareUserDetails;
import com.jn.park.gamtopic.service.CareService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论API接口
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:29
 * @version： v1.0
 * @modified By:
 */
@RestController
public class CareServerController extends BaseController implements CareClient {
    private static Logger logger = LoggerFactory.getLogger(CareServerController.class);

    @Autowired
    private CareService careService;


    @ControllerLog(doAction = "获取评论信息")
    @Override
    public Result findCompanyCareInfo(@RequestBody CareParam careParam){
        CareUserDetails companyCareInfo = careService.findCompanyCareInfo(careParam.getAccount(), careParam.getCurrentAccount());
        return new Result<>(companyCareInfo);
    }


}
