package com.jn.hr.assessment.dao;

import com.jn.hr.assessment.entity.TbManpowerAssessmentManage;
import com.jn.hr.assessment.entity.TbManpowerAssessmentManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAssessmentManageMapper {
    long countByExample(TbManpowerAssessmentManageCriteria example);

    int deleteByExample(TbManpowerAssessmentManageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAssessmentManage record);

    int insertSelective(TbManpowerAssessmentManage record);

    List<TbManpowerAssessmentManage> selectByExample(TbManpowerAssessmentManageCriteria example);

    TbManpowerAssessmentManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAssessmentManage record, @Param("example") TbManpowerAssessmentManageCriteria example);

    int updateByExample(@Param("record") TbManpowerAssessmentManage record, @Param("example") TbManpowerAssessmentManageCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAssessmentManage record);

    int updateByPrimaryKey(TbManpowerAssessmentManage record);
}