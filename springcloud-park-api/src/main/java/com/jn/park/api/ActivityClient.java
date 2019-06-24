package com.jn.park.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.ActivityApplyListParam;
import com.jn.park.activity.model.ActivityContent;
import com.jn.park.activity.model.CompanyActivityApplyParam;
import com.jn.park.activity.model.CompanyActivityApplyShow;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 获取企业报报名活动信息
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/activity/getCompanyActivityApplyInfo", method = RequestMethod.POST)
    Result<List<CompanyActivityApplyShow>> getCompanyActivityApplyInfo(@RequestBody CompanyActivityApplyParam param);

    /**
     * 获取举办活动总数
     * @return
     */
    @RequestMapping(value = "/api/activity/getActivityHistoryNum", method = RequestMethod.POST)
    Result<Integer> getActivityHistoryNum();

    /**
     * 活动结束回调方法
     * @return
     */
    @RequestMapping(value = "/api/activity/activityEndByTimedTask", method = RequestMethod.POST)
    Result<Integer> activityEndByTimedTask(@RequestBody ActivityContent activity);

    /**
     * 活动消息自动推送回调方法
     * @return
     */
    @RequestMapping(value = "/api/activity/activitySendMessageByTimedTask", method = RequestMethod.POST)
    Result<Integer> activitySendMessageByTimedTask(@RequestBody ActivityContent activity);
}
