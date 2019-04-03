package com.jn.park.feedback.service;

import com.jn.common.model.PaginationData;
import com.jn.park.feedback.model.Feedback;
import com.jn.park.feedback.model.FeedbackParam;
import com.jn.park.feedback.model.FeedbackVO;

import java.util.List;

/**
 * 用户反馈
 * @author： jiangyl
 * @date： Created on 2019/3/27 14:30
 * @version： v1.0
 * @modified By:
 */
public interface FeedbackService {

    /**
     * 保存用户反馈信息
     * @param feedback
     * @param account
     * @return
     */
    int saveFeedback(Feedback feedback, String account);

    /**
     * 获取反馈问题列表[后台管理接口]
     * @param feedbackParam
     * @return
     */
    PaginationData<List<FeedbackVO>> getUserFeedbackList(FeedbackParam feedbackParam);

}
