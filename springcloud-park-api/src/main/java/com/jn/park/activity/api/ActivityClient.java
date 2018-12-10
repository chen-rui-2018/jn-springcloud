package com.jn.park.activity.api;

import com.jn.park.activity.model.Activity;
import com.jn.common.model.Page;
import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * 查询活动列表(支持条件查询)
     *
     * @param activity 查询条件
     * @return
     */
    @RequestMapping(value = "/api/activity/selectActivityList", method = RequestMethod.POST)
    Result selectActivityList(@RequestBody Activity activity);

    /**
     * 根据ID查询活动详情
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/api/activity/getActivityDetailsForManage", method = RequestMethod.POST)
    Result getActivityDetailsForManage(@RequestBody String activityId);

    /**
     * 活动报名管理(开始、结束报名)
     * @param activityId
     * @param state
     * @return
     */
    @RequestMapping(value = "/api/activity/updateActivityApply", method = RequestMethod.POST)
    Result updateActivityApply(@RequestBody String activityId,String state);

    /**
     * 插入或修改活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/api/activity/insterOrUpdateActivity", method = RequestMethod.POST)
    Result insterOrUpdateActivity(@RequestBody Activity activity) ;

    /**
     * 删除草稿活动数据
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/api/activity/deleteDraftActivity", method = RequestMethod.POST)
    Result deleteDraftActivity(@RequestBody String activityId) ;

    /**
     * 删除活动数据(需管理员才能删除)
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/api/activity/deleteActivity", method = RequestMethod.POST)
    Result deleteActivity(@RequestBody String activityId) ;

    /**
     * 取消活动
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/api/activity/cancelActivity", method = RequestMethod.POST)
    Result cancelActivity(@RequestBody String activityId) ;

    /**
     * 导出活动报名列表
     * @param activityId
     * @param page
     * @return
     */
    @RequestMapping(value = "/api/activity/applyActivityList", method = RequestMethod.POST)
    Result applyActivityList(@RequestBody String activityId, Page page);
}
