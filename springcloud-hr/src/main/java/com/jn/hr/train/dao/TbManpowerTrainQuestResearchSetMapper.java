package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestResearchSet;
import com.jn.hr.train.entity.TbManpowerTrainQuestResearchSetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestResearchSetMapper {
    long countByExample(TbManpowerTrainQuestResearchSetCriteria example);

    int deleteByExample(TbManpowerTrainQuestResearchSetCriteria example);

    int deleteByPrimaryKey(String projectId);

    int insert(TbManpowerTrainQuestResearchSet record);

    int insertSelective(TbManpowerTrainQuestResearchSet record);

    List<TbManpowerTrainQuestResearchSet> selectByExample(TbManpowerTrainQuestResearchSetCriteria example);

    TbManpowerTrainQuestResearchSet selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestResearchSet record, @Param("example") TbManpowerTrainQuestResearchSetCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestResearchSet record, @Param("example") TbManpowerTrainQuestResearchSetCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestResearchSet record);

    int updateByPrimaryKey(TbManpowerTrainQuestResearchSet record);
}