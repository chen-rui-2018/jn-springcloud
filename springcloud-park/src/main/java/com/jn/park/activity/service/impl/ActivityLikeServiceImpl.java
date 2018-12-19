package com.jn.park.activity.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;

import com.jn.park.activity.dao.TbActivityMapper;
import com.jn.park.activity.dao.TbParkLikeMapper;
import com.jn.park.activity.entity.TbActivity;
import com.jn.park.activity.entity.TbActivityCriteria;

import com.jn.park.activity.entity.TbParkLike;
import com.jn.park.activity.entity.TbParkLikeCriteria;
import com.jn.park.activity.service.ActivityLikeService;
import com.jn.park.comment.service.CommentService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private TbParkLikeMapper tbParkLikeMapper;

    @Autowired
    private TbActivityMapper tbActivityMapper;

    @Autowired
    private CommentService commentService;

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
        TbParkLikeCriteria example=new TbParkLikeCriteria();
        example.createCriteria().andLikeParentIdEqualTo(id).andLikeAccountEqualTo(account);
        //点赞表存在的用户数  根据活动id和账号查询
        long accountNum = tbParkLikeMapper.countByExample(example);
        //已点赞用户数  根据活动id、账号以及状态为点赞（"1"）查询  防止重复操作，更新园区活动表感兴趣人数
        String likeState="1";
        TbParkLikeCriteria likeExample=new TbParkLikeCriteria();
        likeExample.createCriteria().andLikeParentIdEqualTo(id).andLikeAccountEqualTo(account).andStateEqualTo(likeState);
        long likeAccountNum = tbParkLikeMapper.countByExample(likeExample);
        //数据库没有状态为已点赞的用户
         int noLikeNum=0;
        //活动id和account查询统计没有数据
        int noInfo=0;
        //活动id和account查询统计有一条数据
        int oneInfo=1;
        //根据查询结果进行新增、修改操作
        if(accountNum==noInfo){
            //当前活动没有当前用户信息，新增
            commentService.addActivityLike(id, account);
        }else if(accountNum==oneInfo && likeAccountNum==noLikeNum){
            //当前活动有且只有一条当前用户信息,且状态不是已点赞（"1"），更新状态 0：取消点赞  1：点赞
            String state="1";
            commentService.updateParkLikeState(id, account,state);
        }else if(accountNum>oneInfo){
            //当前活动有多条当前用户信息，数据重复
            logger.info("当前活动存在多个相同点赞用户[{}]，无法点赞",account);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_LIKE_ACCOUNT_REPEAT);
        }
        //若不是已经存在的点赞，更新感兴趣人数    防止重复点赞
        if(likeAccountNum==noLikeNum){
            //修改园区活动的感兴趣人数  多一个点赞加1
            updateParkLikeNum(id,1);
        }
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
        //更新状态 0：取消点赞  1：点赞
        String cancelState="0";
        //根据id和account查询是否有状态为取消点赞（"0"）的数据
        TbParkLikeCriteria cancelExample=new TbParkLikeCriteria();
        cancelExample.createCriteria().andLikeParentIdEqualTo(id).andLikeAccountEqualTo(account)
                .andStateEqualTo(cancelState);
        long cancelLikeNum = tbParkLikeMapper.countByExample(cancelExample);
        //获取完状态信息后再更新点赞状态
        commentService.updateParkLikeState(id,account,cancelState);
        //防止重复操作
        int noCancleLikeNum=0;
        if(cancelLikeNum==noCancleLikeNum){
            //修改园区活动的感兴趣人数  取消一个点赞减1
            updateParkLikeNum(id,-1);
        }
    }

    /**
     * 修改园区活动感兴趣人数
     * @param id      活动id
     * @param change  增加人数为正数，减少人数为负数
     */
    @ServiceLog(doAction = "修改园区活动感兴趣人数")
    private void updateParkLikeNum(String id,int change) {
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(id);
        TbActivityCriteria example =new TbActivityCriteria();
        example.createCriteria().andIdEqualTo(id);
        Integer actiLike = tbActivity.getActiLike();
        //若感兴趣人数为0，更新为1，否则加1
        int actLikeNum=actiLike!=null?tbActivity.getActiLike()+change:change;
        //若是感兴趣人数更新后，为负数，强制转换为0
        actLikeNum=actLikeNum<0?0:actLikeNum;
        tbActivity.setActiLike(actLikeNum);
        tbActivityMapper.updateByExampleSelective(tbActivity, example);
    }

}
