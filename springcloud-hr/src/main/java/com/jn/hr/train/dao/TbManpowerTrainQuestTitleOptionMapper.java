package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainQuestTitleOption;
import com.jn.hr.train.entity.TbManpowerTrainQuestTitleOptionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainQuestTitleOptionMapper {
    long countByExample(TbManpowerTrainQuestTitleOptionCriteria example);

    int deleteByExample(TbManpowerTrainQuestTitleOptionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerTrainQuestTitleOption record);

    int insertSelective(TbManpowerTrainQuestTitleOption record);

    List<TbManpowerTrainQuestTitleOption> selectByExample(TbManpowerTrainQuestTitleOptionCriteria example);

    TbManpowerTrainQuestTitleOption selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerTrainQuestTitleOption record, @Param("example") TbManpowerTrainQuestTitleOptionCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainQuestTitleOption record, @Param("example") TbManpowerTrainQuestTitleOptionCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainQuestTitleOption record);

    int updateByPrimaryKey(TbManpowerTrainQuestTitleOption record);
}