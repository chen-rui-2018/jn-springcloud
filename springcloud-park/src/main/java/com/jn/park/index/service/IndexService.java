package com.jn.park.index.service;

import com.jn.park.index.model.Achievement;
import com.jn.park.index.model.ImportantNews;

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
     * @return
     */
    List<ImportantNews> getImportantNewsList();

    /**
     * 获取园区成果列表
     * @return
     */
    List<Achievement> getAchievementList();
}
