package com.jn.hardware.electricmeter.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.electricmeter.service.impl.ElectricMeterServiceImpl;
import com.jn.hardware.model.electricmeter.ElectricAccessTokenParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 9:21
 * @version： v1.0
 * @modified By:
 */
@RestController
public class ElectricMeterController extends BaseController {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(ElectricMeterController.this.getClass());
    @Autowired
    private ElectricMeterService electricMeterService;


}
