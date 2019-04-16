package com.jn.park.gamtopic.dao;

import com.jn.park.gamtopic.model.*;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 11:09
 * @version： v1.0
 * @modified By:
 */
public interface DynamicDao {
    /**
     * 根据条件查找动态列表
     * @param startTime
     * @param endTime
     * @param accountList
     * @return
     */
    List<DynamicManageShow> findDynamicList(@Param("startTime") String startTime, @Param("endTime") String endTime,  @Param("accountList") List<String> accountList);

    /**
     * 根据动态id 查询动态详情
     * @param dynamicId
     * @return
     */
    DynamicManageDetails findDynamicDetails(@Param("dynamicId") String dynamicId);

    /**
     * 查询前台动态列表
     * @param accountList
     * @return
     */
    List<DynamicWebShow> findDynamicWebList( @Param("accountList") List<String> accountList);

    /**
     * 获取动态详情
     * @param dynamicId
     * @return
     */
    DynamicWebShow  findDynamicWebDetails(@Param("dynamicId") String dynamicId);

    /**
     * 获取评论列表
     * @param dynamicId
     * @return
     */
    List<DynamicComments> findDynamicComments(@Param("dynamicId") String dynamicId);

    /**
     * 根据评论id 获取评论信息
     * @param commentId
     * @return
     */
    DynamicComments  findCommentsInfo(@Param("commentId") String  commentId);

    /**
     * 评论的回复列表
     * @param commentId
     * @return
     */
    List<DynamicComments> findCommentReplyList(@Param("commentId")String commentId);

    /**
     * 根据点赞的目标id,返回点赞人列表
     * @param parentId
     * @return
     */
    List<LikedUserInfo> findLikedUserInfoList(@Param("parentId")String parentId);

    /**
     * 目标动态列表
     * @param account
     *  @return
     */
    List<DynamicWebShow> findDynamicByAccount(@Param("account") String account);

}
