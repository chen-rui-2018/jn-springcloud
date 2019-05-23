package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestInvestiga;
import com.jn.hr.train.entity.TbManpowerTrainQuestInvestigaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestInvestigaMapper {
    long countByExample(TbManpowerTrainQuestInvestigaCriteria example);

    int deleteByExample(TbManpowerTrainQuestInvestigaCriteria example);

    int deleteByPrimaryKey(String projectId);

    int insert(TbManpowerTrainQuestInvestiga record);

    int insertSelective(TbManpowerTrainQuestInvestiga record);

    List<TbManpowerTrainQuestInvestiga> selectByExampleWithBLOBs(TbManpowerTrainQuestInvestigaCriteria example);

    List<TbManpowerTrainQuestInvestiga> selectByExample(TbManpowerTrainQuestInvestigaCriteria example);

    TbManpowerTrainQuestInvestiga selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestInvestiga record, @Param("example") TbManpowerTrainQuestInvestigaCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbManpowerTrainQuestInvestiga record, @Param("example") TbManpowerTrainQuestInvestigaCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestInvestiga record, @Param("example") TbManpowerTrainQuestInvestigaCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestInvestiga record);

    int updateByPrimaryKeyWithBLOBs(TbManpowerTrainQuestInvestiga record);

    int updateByPrimaryKey(TbManpowerTrainQuestInvestiga record);
}