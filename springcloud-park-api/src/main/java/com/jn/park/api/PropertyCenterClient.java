package com.jn.park.api;


import com.jn.common.model.Result;
import com.jn.park.property.model.PayCallBackNotify;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * 物业服务客户端
 * @Author: yuanyy
 * @Date: 2019/5/11 10:07:51
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface PropertyCenterClient {

    /**
     * 物业服务-自动执行ibps处理节点任务
     * @param
     * @return
     */
    @RequestMapping(value = "/api/property/repair/automaticApprovalTaskByTaskId", method = RequestMethod.POST)
    Result<String> automaticApprovalTaskByTaskId(@RequestBody  PayCallBackNotify payCallBackNotify);

}
