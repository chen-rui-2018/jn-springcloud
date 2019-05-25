package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainResearchSet;
import com.jn.hr.train.entity.TbManpowerTrainResearchSetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainResearchSetMapper {
    long countByExample(TbManpowerTrainResearchSetCriteria example);

    int deleteByExample(TbManpowerTrainResearchSetCriteria example);

    int deleteByPrimaryKey(String projectId);

    int insert(TbManpowerTrainResearchSet record);

    int insertSelective(TbManpowerTrainResearchSet record);

    List<TbManpowerTrainResearchSet> selectByExample(TbManpowerTrainResearchSetCriteria example);

    TbManpowerTrainResearchSet selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainResearchSet record, @Param("example") TbManpowerTrainResearchSetCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainResearchSet record, @Param("example") TbManpowerTrainResearchSetCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainResearchSet record);

    int updateByPrimaryKey(TbManpowerTrainResearchSet record);
}