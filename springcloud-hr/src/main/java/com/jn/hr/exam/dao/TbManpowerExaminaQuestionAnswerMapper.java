package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaQuestionAnswer;
import com.jn.hr.exam.entity.TbManpowerExaminaQuestionAnswerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaQuestionAnswerMapper {
    long countByExample(TbManpowerExaminaQuestionAnswerCriteria example);

    int deleteByExample(TbManpowerExaminaQuestionAnswerCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerExaminaQuestionAnswer record);

    int insertSelective(TbManpowerExaminaQuestionAnswer record);

    List<TbManpowerExaminaQuestionAnswer> selectByExample(TbManpowerExaminaQuestionAnswerCriteria example);

    TbManpowerExaminaQuestionAnswer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaQuestionAnswer record, @Param("example") TbManpowerExaminaQuestionAnswerCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaQuestionAnswer record, @Param("example") TbManpowerExaminaQuestionAnswerCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaQuestionAnswer record);

    int updateByPrimaryKey(TbManpowerExaminaQuestionAnswer record);
}