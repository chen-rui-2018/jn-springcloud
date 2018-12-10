package com.jn.activity.service.impl;

import com.jn.activity.dao.TbActivityLikeMapper;
import com.jn.activity.entity.TbActivityLike;
import com.jn.activity.entity.TbActivityLikeCriteria;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.service.ActivityApplyService;
import com.jn.activity.service.ActivityLikeService;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: yangph
 * @Date: 2018/12/7 9:31
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityLikeServiceImpl implements ActivityLikeService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityLikeServiceImpl.class);

    @Autowired
    private TbActivityLikeMapper tbActivityLikeMapper;

    @Autowired
    private ActivityApplyService activityApplyService;

    /**
     * 活动点赞
     * @param id       活动id
     * @param account  用户账号
     * @return
     */
    @ServiceLog(doAction = "活动点赞")
    @Override
    public void activityLike(String id,String account) {
        //根据account和活动id查询活动点赞表（tb_activity_like）是否有该用户的数据
        TbActivityLikeCriteria example=new TbActivityLikeCriteria();
        example.createCriteria().andActivityIdEqualTo(account).andActivityIdEqualTo(id);
        long num = tbActivityLikeMapper.countByExample(example);
        //数据库查询统计没有数据
        int noInfo=0;
        //数据库查询统计有一条数据
        int oneInfo=1;
        //根据查询结果进行新增、修改操作
        if(num==noInfo){
            //当前活动没有当前用户信息，新增
            addActivityLike(id, account);
        }else if(num==oneInfo){
            //当前活动有且只有一条当前用户信息，更新状态 0：取消点赞  1：点赞
            updateActivityLikeState(id, account);
        }else if(num>oneInfo){
            //当前活动有多条当前用户信息，数据重复
            logger.info("当前活动存在多个相同点赞用户[{}]，无法点赞",account);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_LIKE_ACCOUNT_REPEAT);
        }
    }

    /**
     * 更新点赞状态
     * @param id      活动id
     * @param account 用户账号
     */
    private void updateActivityLikeState(String id, String account) {
        TbActivityLikeCriteria example=new TbActivityLikeCriteria();
        example.createCriteria().andActivityIdEqualTo(account).andActivityIdEqualTo(id);
        TbActivityLike activityLike=new TbActivityLike();
        //状态 0：取消点赞  1：点赞
        String likeState="1";
        activityLike.setState(likeState);
        tbActivityLikeMapper.updateByExampleSelective(activityLike, example);
    }

    /**
     * 新增点赞信息
     * @param id       活动id
     * @param account  用户账号
     */
    @ServiceLog(doAction = "新增点赞信息")
    private void addActivityLike(String id, String account) {
        TbActivityLike activityLike=new TbActivityLike();
        //点赞id
        activityLike.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //活动id
        activityLike.setActivityId(id);
        //点赞人
        activityLike.setLikeAccount(account);
        //点赞时间
        activityLike.setLikeTime(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //状态 0：取消点赞  1：点赞
        String likeState="1";
        activityLike.setState(likeState);
        tbActivityLikeMapper.insertSelective(activityLike);
    }

    /**
     * 取消点赞
     * @param id        活动id
     * @param account   用户账号
     * @return
     */
    @ServiceLog(doAction = "取消点赞")
    @Override
    public void  cancelLike(String id, String account) {
        TbActivityLikeCriteria example=new TbActivityLikeCriteria();
        example.createCriteria().andActivityIdEqualTo(account).andActivityIdEqualTo(id);
        //创建Bean
        TbActivityLike activityLike=new TbActivityLike();
        //更新状态 0：取消点赞  1：点赞
        String cancelState="0";
        activityLike.setState(cancelState);
        tbActivityLikeMapper.updateByExampleSelective(activityLike, example);
    }
}
