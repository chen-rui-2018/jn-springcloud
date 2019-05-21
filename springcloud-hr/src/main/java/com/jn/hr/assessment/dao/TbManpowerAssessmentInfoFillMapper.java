package com.jn.hr.assessment.dao;

import com.jn.hr.assessment.entity.TbManpowerAssessmentInfoFill;
import com.jn.hr.assessment.entity.TbManpowerAssessmentInfoFillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAssessmentInfoFillMapper {
    long countByExample(TbManpowerAssessmentInfoFillCriteria example);

    int deleteByExample(TbManpowerAssessmentInfoFillCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAssessmentInfoFill record);

    int insertSelective(TbManpowerAssessmentInfoFill record);

    List<TbManpowerAssessmentInfoFill> selectByExample(TbManpowerAssessmentInfoFillCriteria example);

    TbManpowerAssessmentInfoFill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAssessmentInfoFill record, @Param("example") TbManpowerAssessmentInfoFillCriteria example);

    int updateByExample(@Param("record") TbManpowerAssessmentInfoFill record, @Param("example") TbManpowerAssessmentInfoFillCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAssessmentInfoFill record);

    int updateByPrimaryKey(TbManpowerAssessmentInfoFill record);
}