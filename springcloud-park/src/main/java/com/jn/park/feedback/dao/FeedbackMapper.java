package com.jn.park.feedback.dao;


import com.jn.park.feedback.model.FeedbackParam;
import com.jn.park.feedback.model.FeedbackVO;

import java.util.List;

/**
 * 问题反馈Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:58
 * @version： v1.0
 * @modified By:
 */
public interface FeedbackMapper {

    /**
     * 获取反馈问题列表
     * @param feedbackParam
     * @return
     */
    List<FeedbackVO> getUserFeedbackList(FeedbackParam feedbackParam);


}
