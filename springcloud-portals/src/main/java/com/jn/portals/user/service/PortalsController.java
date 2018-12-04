package com.jn.portals.user.service;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCache;
import com.jn.portals.enums.PortalsExceptionEnum;
import com.jn.portals.model.PortalsUser;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供内部使用的API接口
 * @Author: yangph
 * @Date: 2018/11/28 19:32
 * @Version v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/api/portals")
public class PortalsController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PortalsController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value(value = "${user.outreach.information.key}")
    private String redisUserKey;

    @Value(value = "${user.outhrache.information.expire}")
    private int expire;

    @Value(value = "${user.outhrache.information.prefix}")
    private String prefix;


    @ControllerLog(doAction = "获取登录用户扩展信息")
    @ApiOperation(value = "获取登录用户扩展信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getUserExtension")
    public Result<PortalsUser> getUserExtension(@RequestBody String account) {
        Result<PortalsUser> result=new Result();
        //判断用户账号是否为空
        if(StringUtils.isBlank(account)){
            result.setCode(PortalsExceptionEnum.ACCOUNT_CANNOT_EMPTY.getCode());
            result.setResult(PortalsExceptionEnum.ACCOUNT_CANNOT_EMPTY.getMessage());
            return  result;
        }
        //从redis中取出用户扩展信息
        RedisCache cache=new RedisCache(redisTemplate, prefix, expire);
        PortalsUser portalsUser =(PortalsUser) cache.get(redisUserKey + "_" + account);
        if(portalsUser==null){
            logger.info("----登录用户扩展信息没有或已失效----");
            result.setCode(PortalsExceptionEnum.NO_USER_EXTENSION.getCode());
            result.setResult(PortalsExceptionEnum.NO_USER_EXTENSION.getMessage());
            return  result;
        }
        result.setData(portalsUser);
        return result;
    }
}
