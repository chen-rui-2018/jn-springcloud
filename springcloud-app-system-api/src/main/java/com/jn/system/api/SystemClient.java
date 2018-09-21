package com.jn.system.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jn.system.model.Resources;
import com.jn.system.model.User;

@FeignClient("springcloud-app-system")
public interface SystemClient {


    @RequestMapping(value = "/api/getUser", method = RequestMethod.POST)
    User getUser(@RequestBody  User u);

    @RequestMapping(value = "/api/getResources", method = RequestMethod.POST)
    List<Resources> getResources(@RequestBody  Resources r);



}