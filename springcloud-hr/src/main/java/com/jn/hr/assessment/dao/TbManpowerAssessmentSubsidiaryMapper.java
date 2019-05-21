package com.jn.hr.assessment.dao;

import com.jn.hr.assessment.entity.TbManpowerAssessmentSubsidiary;
import com.jn.hr.assessment.entity.TbManpowerAssessmentSubsidiaryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAssessmentSubsidiaryMapper {
    long countByExample(TbManpowerAssessmentSubsidiaryCriteria example);

    int deleteByExample(TbManpowerAssessmentSubsidiaryCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAssessmentSubsidiary record);

    int insertSelective(TbManpowerAssessmentSubsidiary record);

    List<TbManpowerAssessmentSubsidiary> selectByExample(TbManpowerAssessmentSubsidiaryCriteria example);

    TbManpowerAssessmentSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAssessmentSubsidiary record, @Param("example") TbManpowerAssessmentSubsidiaryCriteria example);

    int updateByExample(@Param("record") TbManpowerAssessmentSubsidiary record, @Param("example") TbManpowerAssessmentSubsidiaryCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAssessmentSubsidiary record);

    int updateByPrimaryKey(TbManpowerAssessmentSubsidiary record);
}