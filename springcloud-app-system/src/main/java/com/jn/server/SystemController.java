package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.system.model.Resources;
import com.jn.system.model.User;
import com.jn.system.service.ResourcesService;
import com.jn.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

	@Autowired
	private UserService userService;

	@Autowired
	private ResourcesService resourcesService;

    /**
     * 获取用户
     * @param u
     * @return
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Result<User> getUser(@RequestBody @Validated User u) {
        User user = userService.findTByT(u) ;
        if(user == null) {
            throw new JnSpringCloudException(CommonExceptionEnum.DATA_NULL) ;
        }
    	return new Result(user);
    }
    /**
     * 获取资源
     * @param r
     * @return
     */
    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    public Result<List<Resources>> getResources(@RequestBody  Resources r) {
        List<Resources> resourcesList = resourcesService.findTByT(r) ;
        if(resourcesList == null || resourcesList.size() == 0) {
            throw new JnSpringCloudException(CommonExceptionEnum.DATA_NULL) ;
        }
    	return new Result(resourcesList);
    }
}
