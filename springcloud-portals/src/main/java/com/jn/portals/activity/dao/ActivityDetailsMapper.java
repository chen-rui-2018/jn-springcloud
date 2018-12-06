package com.jn.portals.activity.dao;

import com.jn.portals.activity.vo.ActivityDetailVO;
import feign.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 17:35
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface ActivityDetailsMapper {
    //todo:表中需要关联个人用户扩展表和企业用户扩展表关联查询用户头像
    /**
     * 获取活动详情
     * @param id 活动id
     * @return
     */
    List<ActivityDetailVO> getActivityDetails(@Param(value = "id") String id);
}
