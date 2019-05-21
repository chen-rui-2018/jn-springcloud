package com.jn.server;

import com.jn.common.controller.BaseController;

import com.jn.common.model.Result;
import com.jn.park.api.PropertyCenterClient;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.park.repair.service.RepairService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 物业服务 内部使用API接口
 * @Author: yuanyy
 * @Date: 2019/5/11 10:45
 * @Version v1.0
 * @modified By:
 */

@RestController
public class PropertyServerController extends BaseController implements PropertyCenterClient {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PropertyServerController.class);

    @Autowired
    private RepairService repairService;


    @ControllerLog(doAction = "物业服务-自动执行ibps处理节点任务")
    @Override
    public Result<String> automaticApprovalTaskByTaskId(@RequestBody PayCallBackNotify  payCallBackNotify) {
        logger.info("物业服务-自动执行ibps处理节点任务");
        repairService.automaticApprovalTaskByTaskId(payCallBackNotify);
        return new Result();
    }
}
