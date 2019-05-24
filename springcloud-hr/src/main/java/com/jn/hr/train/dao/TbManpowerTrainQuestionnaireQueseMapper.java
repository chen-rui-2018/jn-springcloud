package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestionnaireQuese;
import com.jn.hr.train.entity.TbManpowerTrainQuestionnaireQueseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestionnaireQueseMapper {
    long countByExample(TbManpowerTrainQuestionnaireQueseCriteria example);

    int deleteByExample(TbManpowerTrainQuestionnaireQueseCriteria example);

    int deleteByPrimaryKey(String titleId);

    int insert(TbManpowerTrainQuestionnaireQuese record);

    int insertSelective(TbManpowerTrainQuestionnaireQuese record);

    List<TbManpowerTrainQuestionnaireQuese> selectByExample(TbManpowerTrainQuestionnaireQueseCriteria example);

    TbManpowerTrainQuestionnaireQuese selectByPrimaryKey(String titleId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestionnaireQuese record, @Param("example") TbManpowerTrainQuestionnaireQueseCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestionnaireQuese record, @Param("example") TbManpowerTrainQuestionnaireQueseCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestionnaireQuese record);

    int updateByPrimaryKey(TbManpowerTrainQuestionnaireQuese record);
}