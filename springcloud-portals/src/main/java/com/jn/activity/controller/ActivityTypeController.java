package com.jn.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.cache.RedisCache;
import com.jn.portalsLogin.model.PortalUserLogin;
import com.jn.portalsLogin.model.PortalsUser;
import com.jn.portalsLogin.user.service.PortalsLoginDataCheckService;
import com.jn.portalsLogin.user.service.PortalsLoginService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.model.UserLogin;
import com.jn.system.model.UserNoPasswordLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 活动类型
 * @Author: yangph
 * @Date: 2018/11/21 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "门户活动类型")
@RestController
public class ActivityTypeController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityTypeController.class);


}
