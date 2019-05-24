package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestSurveyResult;
import com.jn.hr.train.entity.TbManpowerTrainQuestSurveyResultCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestSurveyResultMapper {
    long countByExample(TbManpowerTrainQuestSurveyResultCriteria example);

    int deleteByExample(TbManpowerTrainQuestSurveyResultCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerTrainQuestSurveyResult record);

    int insertSelective(TbManpowerTrainQuestSurveyResult record);

    List<TbManpowerTrainQuestSurveyResult> selectByExample(TbManpowerTrainQuestSurveyResultCriteria example);

    TbManpowerTrainQuestSurveyResult selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestSurveyResult record, @Param("example") TbManpowerTrainQuestSurveyResultCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestSurveyResult record, @Param("example") TbManpowerTrainQuestSurveyResultCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestSurveyResult record);

    int updateByPrimaryKey(TbManpowerTrainQuestSurveyResult record);
}