package com.jn.portals.activity.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.portals.activity.dao.ActivityDetailsMapper;
import com.jn.portals.activity.dao.TbActivityLikeMapper;
import com.jn.portals.activity.dao.TbCommentMapper;
import com.jn.portals.activity.entity.TbActivityLike;
import com.jn.portals.activity.entity.TbActivityLikeCriteria;
import com.jn.portals.activity.entity.TbComment;
import com.jn.portals.activity.entity.TbCommentCriteria;
import com.jn.portals.activity.enums.ActivityExceptionEnum;
import com.jn.portals.activity.service.ActivityDetailsService;
import com.jn.portals.activity.vo.ActivityDetailVO;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityDetailsServiceImpl implements ActivityDetailsService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityDetailsServiceImpl.class);

    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;

    @Autowired
    private TbCommentMapper tbCommentMapper;

    @Autowired
    private TbActivityLikeMapper tbActivityLikeMapper;

    /**
     * 根据活动id获取活动详情
     * @param id 活动id
     * @return
     */
    @ServiceLog(doAction = "获取活动详情")
    @Override
    public Result getActivityDetails(String id) {
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        List<ActivityDetailVO> list=activityDetailsMapper.getActivityDetails(id);
        if(list.size()>0){
            ActivityDetailVO activityDetailVO=list.get(0);
            //根据活动id查询点评信息
            Result commentInfo = getCommentInfo(id);
            if (GlobalConstants.SUCCESS_CODE.equals(commentInfo.getCode())) {
                List<TbComment> commentList = (List<TbComment>)commentInfo.getData();
                activityDetailVO.setCommentList(commentList);
            }
            //根据活动id查询点赞信息
            Result activityLikeInfo = getActivityLikeInfo(id);
            if (GlobalConstants.SUCCESS_CODE.equals(activityLikeInfo.getCode())) {
                List<TbActivityLike> activityLikeList = (List<TbActivityLike>)activityLikeInfo.getData();
                activityDetailVO.setActivityLikeList(activityLikeList);
            }
            //把活动详情封装到result中返回前端
            result.setData(activityDetailVO);
        }
        return result;
    }

    /**
     * 根据活动id获取活动点评信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取活动点评信息")
    @Override
    public Result getCommentInfo(String id){
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        TbCommentCriteria example=new TbCommentCriteria();
        example.createCriteria().andPIdEqualTo(id);
        List<TbComment> tbComments = tbCommentMapper.selectByExample(example);
        result.setData(tbComments);
        return result;
    }


    /**
     * 根据活动id获取活动点赞信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取活动点赞信息")
    @Override
    public Result getActivityLikeInfo(String id){
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        TbActivityLikeCriteria example=new TbActivityLikeCriteria();
        example.createCriteria().andActivityIdEqualTo(id);
        List<TbActivityLike> tbActivityLikes = tbActivityLikeMapper.selectByExample(example);
        result.setData(tbActivityLikes);
        return result;
    }
}
