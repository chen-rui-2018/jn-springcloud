package com.jn.park.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 项目管理
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 20:08
 * @version： v1.0
 * @modified By:
 **/
@FeignClient("springcloud-park")
public interface BusinessAdClient {

    /**
     * 定时更新招商信息,招商动态,招商政策状态
     *
     * @return
     */
    @RequestMapping(value = "/api/businessAd/updateBusinessAdStatus", method = RequestMethod.POST)
    Result<Boolean> updateBusinessAdStatus();

    /**
     * 定时更新项目管理拟制合同状态
     *
     * @return
     */
    @RequestMapping(value = "/api/projectInfo/updateProjectInfoStatus", method = RequestMethod.POST)
    Result<Boolean> updateProjectInfoStatus();

    /**
     * 项目管理，拟制合同状态不正常提醒功能
     *
     * @return
     */
    @RequestMapping(value = "/api/projectInfo/projectRemind", method = RequestMethod.POST)
    Result<Boolean> projectRemind();




}
