package com.jn.park.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivityParment;
import com.jn.park.activity.model.ActivitySlim;
import com.jn.park.activity.model.ActivitySlimQuery;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
     * 获取活动列表
     * @param activitySlimQuery
     * @return
     */
    @RequestMapping(value = "/api/activity/getActivityList", method = RequestMethod.POST)
    Result<PaginationData<List<ActivitySlim>>> getActivityList(@RequestBody ActivitySlimQuery activitySlimQuery);

	 /**
     * 获取有效活动总数
     * @return
     */
    @RequestMapping(value = "/api/activity/getActivityNum", method = RequestMethod.POST)
    Result<String> getActivityNum();

    
}
