package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.park.api.ActivityClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动 内部使用API接口
 * @Author: jiangyl
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */

@RestController
@RequestMapping("/api/activity")
public class ActivityServerController extends BaseController implements ActivityClient{
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityServerController.class);


}
