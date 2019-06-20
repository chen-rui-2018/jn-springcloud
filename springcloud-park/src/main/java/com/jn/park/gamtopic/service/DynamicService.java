package com.jn.park.gamtopic.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.vo.DnnamicCommentDetailsVo;
import com.jn.park.gamtopic.vo.DynamicWebDetailsVo;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 11:06
 * @version： v1.0
 * @modified By:
 */
public interface DynamicService {
    /**
     * 发布动态
     * @param dynamicAddParam
     * @param dynamicId
     * @param account
     * @return
     */
    int  addDynamicInfo(DynamicAddParam dynamicAddParam, String dynamicId, String account);

    /**
     * 根据条件查找后台动态列表
     * @param queryParam
     * @return
     */
    PaginationData<List<DynamicManageShow>> findDynamicList(DynamicQueryParam queryParam);

    /**
     * 后台查看动态详情
     * @param dynamicId
     * @return
     */
    DynamicManageDetails findDynamicDetails(String dynamicId);

    /**
     * 删除当前动态
     * @param dynamicId
     * @param account
     * @return
     */
    int deleteDynamicInfo(String dynamicId,String account);

    /**
     * 前台动态列表
     * @param account
     * @param page
     * @return
     */
    PaginationData<List<DynamicWebShow>> findDynamicWebList(Page page, String account);

    /**
     * 获取当前用户的关注用户动态列表
     * @param page
     * @param account
     * @return
     */
    PaginationData<List<DynamicWebShow>> findCareDynamicList(Page page,String account);

    /**
     * 前台动态详情+评论列表
     * @param dynamicId
     * @param account
     * @return
     */
    DynamicWebDetailsVo  findDynamicWebDetails(String dynamicId,String account);

    /**
     * 动态评论列表查询
     * @param param
     * @return
     */
    PaginationData<List<DynamicComments>> findDynamicComments(DynamicCommentsParam param);

    /**
     * 评论详情(评论信息+回复列表+点赞信息)
     * @param commentId
     * @return
     */

    DnnamicCommentDetailsVo findDynamicCommentsDetails(String commentId);

    /**
     * 评论的回复列表
     * @param param
     * @return
     */
    PaginationData<List<DynamicComments>>  findCommentReplyList(DynamicCommentsParam param);

    /**
     * 点赞人信息列表
     * @param param
     * @return
     */
    PaginationData<List<LikedUserInfo>> findLikedUserInfoList(DynamicCommentsParam param);

    /**
     * 根据评用户账号,当前用户动态列表
     * @param param
     * @param currentAccount
     * @return
     */
    PaginationData<List<DynamicWebShow>> findDynamicByAccount(CareDetailsQueryParam param,String currentAccount);

    /**
     * 根据动态id 返回动态评论列表+ 评论回复列表
     * @param param
     * @return
     */
    PaginationData<List<DynamicCommentReplyShow>> findDynamicCommentAndReplyList(DynamicCommentsParam param);

    /**
     * 动态点赞,取消点赞
     * @param dynamicLikeOperate
     * @param account
     * @return
     */
    int   dynamicLikeOperate(DynamicLikeOperate dynamicLikeOperate,String account);

}
