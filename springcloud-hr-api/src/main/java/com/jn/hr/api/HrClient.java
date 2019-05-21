package com.jn.hr.api;

import com.jn.common.model.Result;
import com.jn.hr.model.Email;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * oa系统客户端
 *
 * @author： yuanyy
 * @date： Created on 2019/3/7 18:04
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-hr")
public interface HrClient {

   /* @RequestMapping(value = "/api/hr/notices", method = RequestMethod.POST)
    Result<String> noticesApplicationMeeting();*/



}
