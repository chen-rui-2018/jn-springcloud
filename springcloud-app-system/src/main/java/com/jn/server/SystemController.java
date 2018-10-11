package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.system.model.Resources;
import com.jn.system.model.User;
import com.jn.system.service.ResourcesService;
import com.jn.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getUser(@RequestBody  User u) {
    	return userService.findTByT(u);
    }
    /**
     * 获取资源
     * @param r
     * @return
     */
    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    public List<Resources> getResources(@RequestBody  Resources r) {
    	return resourcesService.findTByT(r);
    }
}
