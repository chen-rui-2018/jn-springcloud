package com.jn.park.index.service;

import com.jn.park.index.model.Achievement;
import com.jn.park.index.model.AchievementParam;
import com.jn.park.index.model.ImportantNews;
import com.jn.park.index.model.ImportantNewsParam;

import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-23 14:21:43
 * @Version v1.0
 * @modified By:
 */
public interface IndexService {

    /**
     * 获取重要消息列表
     * @param importantNewsParam 入参
     * @return
     */
    List<ImportantNews> getImportantNewsList(ImportantNewsParam importantNewsParam);

    /**
     * 获取园区成果列表
     * @param achievementParam 入参
     * @return
     */
    List<Achievement> getAchievementList(AchievementParam achievementParam);

    /**
     * 增加成果点击量
     * @param achievementId 成果id
     * @return
     */
    Integer addAchievementClick(String achievementId);
}
