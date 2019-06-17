package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestQuestionnaireQuese;
import com.jn.hr.train.entity.TbManpowerTrainQuestQuestionnaireQueseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestQuestionnaireQueseMapper {
    long countByExample(TbManpowerTrainQuestQuestionnaireQueseCriteria example);

    int deleteByExample(TbManpowerTrainQuestQuestionnaireQueseCriteria example);

    int deleteByPrimaryKey(String titleId);

    int insert(TbManpowerTrainQuestQuestionnaireQuese record);

    int insertSelective(TbManpowerTrainQuestQuestionnaireQuese record);

    List<TbManpowerTrainQuestQuestionnaireQuese> selectByExample(TbManpowerTrainQuestQuestionnaireQueseCriteria example);

    TbManpowerTrainQuestQuestionnaireQuese selectByPrimaryKey(String titleId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestQuestionnaireQuese record, @Param("example") TbManpowerTrainQuestQuestionnaireQueseCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestQuestionnaireQuese record, @Param("example") TbManpowerTrainQuestQuestionnaireQueseCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestQuestionnaireQuese record);

    int updateByPrimaryKey(TbManpowerTrainQuestQuestionnaireQuese record);
}