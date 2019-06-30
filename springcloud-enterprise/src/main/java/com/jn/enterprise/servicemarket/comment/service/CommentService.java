package com.jn.enterprise.servicemarket.comment.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.comment.model.CommentParameter;
import com.jn.enterprise.servicemarket.comment.model.RatingDetail;
import com.jn.enterprise.servicemarket.comment.model.RatingParameter;
import com.jn.enterprise.servicemarket.comment.model.ReceiveRatingParameter;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/25 15:35
 * @version： v1.0
 * @modified By:
 */
public interface CommentService {
    /**
     * 获取对他人的评价列表(客户对机构的评价)
     * @param ratingParameter
     * @param userAccount
     * @return
     */
    PaginationData getGiveOthersCommentList(RatingParameter ratingParameter,String userAccount);

    /**
     * 获取我收到的评价列表(机构/专员收到的评价)
     * @param receiveRatingParameter
     * @param userAccount
     * @return
     */
    PaginationData getGiveMeCommentList(ReceiveRatingParameter receiveRatingParameter, String userAccount);

    /**
     * 获取评价页详情
     * @param id 需求id
     * @return
     */
    RatingDetail getRatingCommentDetail(String id);

    /**
     * 保存评价信息
     * @param commentParameter
     * @param account
     * @return
     */
    Boolean saveRatingComment(CommentParameter commentParameter, String account);

}
