package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestAnswerInfo;
import com.jn.hr.train.entity.TbManpowerTrainQuestAnswerInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestAnswerInfoMapper {
    long countByExample(TbManpowerTrainQuestAnswerInfoCriteria example);

    int deleteByExample(TbManpowerTrainQuestAnswerInfoCriteria example);

    int deleteByPrimaryKey(String answerId);

    int insert(TbManpowerTrainQuestAnswerInfo record);

    int insertSelective(TbManpowerTrainQuestAnswerInfo record);

    List<TbManpowerTrainQuestAnswerInfo> selectByExample(TbManpowerTrainQuestAnswerInfoCriteria example);

    TbManpowerTrainQuestAnswerInfo selectByPrimaryKey(String answerId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestAnswerInfo record, @Param("example") TbManpowerTrainQuestAnswerInfoCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestAnswerInfo record, @Param("example") TbManpowerTrainQuestAnswerInfoCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestAnswerInfo record);

    int updateByPrimaryKey(TbManpowerTrainQuestAnswerInfo record);
}