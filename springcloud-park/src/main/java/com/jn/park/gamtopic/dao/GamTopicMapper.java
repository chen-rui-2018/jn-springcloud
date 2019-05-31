package com.jn.park.gamtopic.dao;


import com.jn.park.feedback.model.FeedbackParam;
import com.jn.park.feedback.model.FeedbackVO;
import com.jn.park.gamtopic.model.GamTopicParam;
import com.jn.park.gamtopic.model.GamTopicVO;

import java.util.List;

/**
 * 话题Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:58
 * @version： v1.0
 * @modified By:
 */
public interface GamTopicMapper {

    /**
     * 获得当前用户话题列表
     * @param gamTopicParam
     * @return
     */
    List<GamTopicVO> getUserFeedbackList(GamTopicParam gamTopicParam);


}
