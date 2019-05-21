package com.jn.park.index.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.park.index.dao.TbAchievementMapper;
import com.jn.park.index.dao.TbImportantNewsMapper;
import com.jn.park.index.entity.TbAchievement;
import com.jn.park.index.entity.TbAchievementCriteria;
import com.jn.park.index.entity.TbImportantNews;
import com.jn.park.index.entity.TbImportantNewsCriteria;
import com.jn.park.index.enums.IndexDataEnum;
import com.jn.park.index.enums.IndexExceptionEnum;
import com.jn.park.index.model.Achievement;
import com.jn.park.index.model.AchievementParam;
import com.jn.park.index.model.ImportantNews;
import com.jn.park.index.model.ImportantNewsParam;
import com.jn.park.index.service.IndexService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-23 14:22:28
 * @Version v1.0
 * @modified By:
 */
@Service
public class IndexServiceImpl implements IndexService {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    TbImportantNewsMapper importantNewsMapper;

    @Autowired
    TbAchievementMapper tbAchievementMapper;

    @Override
    @ServiceLog(doAction = "获取重要消息列表")
    public List<ImportantNews> getImportantNewsList(ImportantNewsParam importantNewsParam) {
        List<ImportantNews> dataList = new ArrayList<>();

        String curDateStr = DateUtils.formatDate(new Date(), "yyyy-MM-dd 00:00:00");
        try {
            Date curDate = DateUtils.parseDate(curDateStr, "yyyy-MM-dd HH:mm:ss");
            TbImportantNewsCriteria criteria = new TbImportantNewsCriteria();
            TbImportantNewsCriteria criteria1 = new TbImportantNewsCriteria();
            TbImportantNewsCriteria.Criteria platFormCriteria = criteria1.createCriteria();
            criteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                    .andStatusEqualTo(IndexDataEnum.IMPORTANT_NEWS_STATUS_VALID.getCode())
                    .andPlatformTypeEqualTo(IndexDataEnum.IMPORTANT_NEWS_PLATFORM_TYPE_ALL.getCode())
                    .andStartTimeLessThanOrEqualTo(curDate).andEndTimeGreaterThanOrEqualTo(curDate);

            platFormCriteria.andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                    .andStatusEqualTo(IndexDataEnum.IMPORTANT_NEWS_STATUS_VALID.getCode())
                    .andStartTimeLessThanOrEqualTo(curDate).andEndTimeGreaterThanOrEqualTo(curDate)
                    .andPlatformTypeEqualTo(importantNewsParam.getPlatFormType());

            criteria.or(platFormCriteria);

            List<TbImportantNews> newsList = importantNewsMapper.selectByExample(criteria);
            if (newsList != null && !newsList.isEmpty()) {
                for (TbImportantNews news : newsList) {
                    ImportantNews importantNews = new ImportantNews();
                    BeanUtils.copyProperties(news, importantNews);
                    dataList.add(importantNews);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    @Override
    @ServiceLog(doAction = "获取园区成果列表")
    public List<Achievement> getAchievementList(AchievementParam achievementParam) {
        List<Achievement> dataList = new ArrayList<>();
        TbAchievementCriteria achievementCriteria = new TbAchievementCriteria();
        TbAchievementCriteria.Criteria criteria = achievementCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andStatusEqualTo(IndexDataEnum.IMPORTANT_NEWS_STATUS_VALID.getCode());

        if (StringUtils.isNotBlank(achievementParam.getType())) {
            criteria.andTypeEqualTo(achievementParam.getType());
        }

        List<TbAchievement> achList = tbAchievementMapper.selectByExample(achievementCriteria);
        if (achList != null && !achList.isEmpty()) {
            for (TbAchievement ach : achList) {
                Achievement achievement = new Achievement();
                BeanUtils.copyProperties(ach, achievement);
                dataList.add(achievement);
            }
        }
        logger.info("[获取园区成果列表] 成果返回条数:{}", dataList.size());
        return dataList;
    }

    @Override
    @ServiceLog(doAction = "增加成果点击量")
    public Integer addAchievementClick(String achievementId) {
        if (StringUtils.isBlank(achievementId)) {
            throw new JnSpringCloudException(IndexExceptionEnum.PARAM_IS_NULL);
        }
        TbAchievementCriteria criteria = new TbAchievementCriteria();
        criteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andIdEqualTo(achievementId);
        List<TbAchievement> tbAchievements = tbAchievementMapper.selectByExample(criteria);
        if (tbAchievements == null || tbAchievements.isEmpty()) {
            throw new JnSpringCloudException(IndexExceptionEnum.ACHIEVEMENT_NOT_EXIST);
        }
        TbAchievement tbAchievement = tbAchievements.get(0);
        tbAchievement.setViewCount(tbAchievement.getViewCount() + 1);
        return tbAchievementMapper.updateByPrimaryKeySelective(tbAchievement);
    }
}
