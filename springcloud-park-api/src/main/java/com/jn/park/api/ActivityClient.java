package com.jn.park.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.ActivityApplyListParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 活动客户端
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface ActivityClient {

	 /**
     * 获取有效活动总数
     * @return
     */
    @RequestMapping(value = "/api/activity/getActivityNum", method = RequestMethod.POST)
    Result<String> getActivityNum();

    /**
     * 查看用户报名的活动列表
     * @return
     */
    @RequestMapping(value = "/api/activity/findActivitySuccessfulRegistration", method = RequestMethod.POST)
    Result<PaginationData> findActivitySuccessfulRegistration(@RequestBody ActivityApplyListParam activityApplyListParam,@RequestParam("needPage") Boolean needPage);

}
