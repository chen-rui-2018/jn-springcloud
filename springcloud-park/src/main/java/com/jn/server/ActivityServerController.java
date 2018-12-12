package com.jn.server;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.park.api.ActivityClient;
import com.jn.park.activity.entity.TbActivityApply;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.Activity;
import com.jn.park.model.ActivityDetail;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

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
