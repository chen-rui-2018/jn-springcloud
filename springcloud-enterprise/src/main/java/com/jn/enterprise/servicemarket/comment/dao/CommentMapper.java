package com.jn.enterprise.servicemarket.comment.dao;

import com.jn.enterprise.servicemarket.comment.model.Rating;
import com.jn.enterprise.servicemarket.comment.model.RatingDetail;
import com.jn.enterprise.servicemarket.comment.model.ReceiveRatingParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/26 14:17
 * @version： v1.0
 * @modified By:
 */
public interface CommentMapper {
    /**
     * 获取我收到的评价列表(机构/专员收到的评价)
     * @param receiveRatingParameter
     * @return
     */
    List<Rating> getGiveMeCommentList(ReceiveRatingParameter receiveRatingParameter);

    /**
     * 根据需求id查询评论详细信息
     * @param id
     * @return
     */
    RatingDetail getRatingCommentDetail(@Param("id")String id);



}
