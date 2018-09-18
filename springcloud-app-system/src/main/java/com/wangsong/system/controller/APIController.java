package com.wangsong.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.common.controller.BaseController;
import com.wangsong.system.model.Resources;
import com.wangsong.system.model.User;
import com.wangsong.system.service.ResourcesService;
import com.wangsong.system.service.UserService;



@Controller
@RequestMapping("/api")
public class APIController  extends BaseController {
	
		
	@Autowired
	private UserService userService;

	@Autowired
	private ResourcesService resourcesService;
	
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public Object getUser(@RequestBody  User u) {
    	return userService.findTByT(u);
    }

  
    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    @ResponseBody
    public Object getResources(@RequestBody  Resources r) {
    	return resourcesService.findTByT(r);
    }

    
}
