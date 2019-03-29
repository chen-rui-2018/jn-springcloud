package com.jn.park.gamtopic.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.gamtopic.model.GamTopic;
import com.jn.park.gamtopic.model.GamTopicParam;
import com.jn.park.gamtopic.model.GamTopicVO;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:37
 * @version： v1.0
 * @modified By:
 */
public interface GamTopicService {

    /**
     * 新增话题
     * @param gamTopic
     * @param account
     * @return
     */
    int saveGamTopic(GamTopic gamTopic,String account);

    /**
     * 前端用户删除话题
     * @param topicId
     * @param account
     * @return
     */
    int deleteGamTopic(String topicId,String account);

    /**
     * 获得当前用户话题列表
     * @param page
     * @param account
     * @return
     */
    PaginationData<List<GamTopicVO>> getMyGamTopicList(Page page, String account);

    /**
     * 根据条件查询用户话题列表[后台管理接口]
     * @param gamTopicParam
     * @return
     */
    PaginationData<List<GamTopicVO>> getGamTopicListByParam(GamTopicParam gamTopicParam);

    /**
     * 删除用户话题[后台管理接口]
     * @param topicId
     * @param account
     * @return
     */
    int deleteGamTopicForAdmin(String topicId,String account);
}
