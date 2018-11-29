package com.jn.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 刷新接口
 *
 * @author： fengxh
 * @date： Created on 2018/11/28 20:56
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-app-config-manager")
public interface Refresh {


    /**
     * 刷新接口
     * @return
     */
    @RequestMapping(value = "/scca/bus/refresh", method = RequestMethod.POST)
    Object refresh();
}
