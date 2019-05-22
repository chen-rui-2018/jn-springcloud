package com.jn.hr.assessment.dao;

import com.jn.hr.assessment.entity.TbManpowerAssessmentTemplate;
import com.jn.hr.assessment.entity.TbManpowerAssessmentTemplateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAssessmentTemplateMapper {
    long countByExample(TbManpowerAssessmentTemplateCriteria example);

    int deleteByExample(TbManpowerAssessmentTemplateCriteria example);

    int deleteByPrimaryKey(String templateId);

    int insert(TbManpowerAssessmentTemplate record);

    int insertSelective(TbManpowerAssessmentTemplate record);

    List<TbManpowerAssessmentTemplate> selectByExample(TbManpowerAssessmentTemplateCriteria example);

    TbManpowerAssessmentTemplate selectByPrimaryKey(String templateId);

    int updateByExampleSelective(@Param("record") TbManpowerAssessmentTemplate record, @Param("example") TbManpowerAssessmentTemplateCriteria example);

    int updateByExample(@Param("record") TbManpowerAssessmentTemplate record, @Param("example") TbManpowerAssessmentTemplateCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAssessmentTemplate record);

    int updateByPrimaryKey(TbManpowerAssessmentTemplate record);
}