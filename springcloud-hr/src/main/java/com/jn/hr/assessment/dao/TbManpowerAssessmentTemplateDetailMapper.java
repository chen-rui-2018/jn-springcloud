package com.jn.hr.assessment.dao;

import com.jn.hr.assessment.entity.TbManpowerAssessmentTemplateDetail;
import com.jn.hr.assessment.entity.TbManpowerAssessmentTemplateDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAssessmentTemplateDetailMapper {
    long countByExample(TbManpowerAssessmentTemplateDetailCriteria example);

    int deleteByExample(TbManpowerAssessmentTemplateDetailCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAssessmentTemplateDetail record);

    int insertSelective(TbManpowerAssessmentTemplateDetail record);

    List<TbManpowerAssessmentTemplateDetail> selectByExample(TbManpowerAssessmentTemplateDetailCriteria example);

    TbManpowerAssessmentTemplateDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAssessmentTemplateDetail record, @Param("example") TbManpowerAssessmentTemplateDetailCriteria example);

    int updateByExample(@Param("record") TbManpowerAssessmentTemplateDetail record, @Param("example") TbManpowerAssessmentTemplateDetailCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAssessmentTemplateDetail record);

    int updateByPrimaryKey(TbManpowerAssessmentTemplateDetail record);
}