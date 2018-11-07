package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.system.config.RedisSessionDAO;
import com.jn.system.model.Resources;
import com.jn.system.model.User;
import com.jn.system.service.ResourcesService;
import com.jn.system.service.SysResourcesService;
import com.jn.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Set;

/**
 * 提供内部使用的API接口
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/api/system")
public class SystemController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SystemController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SysResourcesService sysResourcesService;

    /**
     * 获取用户
     * @param u
     * @return
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Result<User> getUser(@RequestBody @Validated User u) {
        logger.info("进入获取用户的API,用户参数：{}",u.toString());
        List<User> user = userService.findTByT(u) ;
        if(user == null || user.size() ==0 ) {
            new Result();
        }
    	return new Result(user.get(0));
    }
    /**
     * 获取资源
     * @param id
     * @return
     */
    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    public Result<Set<String>> getResources(@RequestBody  String id) {
        Set<String> resourcesList = sysResourcesService.findPermissionsUrlById(id);
    	return new Result(resourcesList);
    }
}
