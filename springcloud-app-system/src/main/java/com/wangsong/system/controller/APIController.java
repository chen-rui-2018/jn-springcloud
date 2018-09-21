package com.wangsong.system.controller;

import com.wangsong.common.controller.BaseController;
import com.wangsong.system.model.Resources;
import com.wangsong.system.model.User;
import com.wangsong.system.service.ResourcesService;
import com.wangsong.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class APIController  extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private ResourcesService resourcesService;
	
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Object getUser(@RequestBody  User u) {
    	return userService.findTByT(u);
    }

    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    public Object getResources(@RequestBody  Resources r) {
    	return resourcesService.findTByT(r);
    }

    @RequestMapping(value = "/getUserTest", method = RequestMethod.POST)
    public Object getUserTest(@RequestBody @Validated User u) {
        return userService.findTByT(u);
    }

}
