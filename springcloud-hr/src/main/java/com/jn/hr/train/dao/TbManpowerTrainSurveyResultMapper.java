package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainSurveyResult;
import com.jn.hr.train.entity.TbManpowerTrainSurveyResultCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainSurveyResultMapper {
    long countByExample(TbManpowerTrainSurveyResultCriteria example);

    int deleteByExample(TbManpowerTrainSurveyResultCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerTrainSurveyResult record);

    int insertSelective(TbManpowerTrainSurveyResult record);

    List<TbManpowerTrainSurveyResult> selectByExample(TbManpowerTrainSurveyResultCriteria example);

    TbManpowerTrainSurveyResult selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerTrainSurveyResult record, @Param("example") TbManpowerTrainSurveyResultCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainSurveyResult record, @Param("example") TbManpowerTrainSurveyResultCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainSurveyResult record);

    int updateByPrimaryKey(TbManpowerTrainSurveyResult record);
}