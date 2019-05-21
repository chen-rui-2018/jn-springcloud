package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaExamQuestion;
import com.jn.hr.exam.entity.TbManpowerExaminaExamQuestionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaExamQuestionMapper {
    long countByExample(TbManpowerExaminaExamQuestionCriteria example);

    int deleteByExample(TbManpowerExaminaExamQuestionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerExaminaExamQuestion record);

    int insertSelective(TbManpowerExaminaExamQuestion record);

    List<TbManpowerExaminaExamQuestion> selectByExample(TbManpowerExaminaExamQuestionCriteria example);

    TbManpowerExaminaExamQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaExamQuestion record, @Param("example") TbManpowerExaminaExamQuestionCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaExamQuestion record, @Param("example") TbManpowerExaminaExamQuestionCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaExamQuestion record);

    int updateByPrimaryKey(TbManpowerExaminaExamQuestion record);
}