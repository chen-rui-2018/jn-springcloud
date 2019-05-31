package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaAnswerCard;
import com.jn.hr.exam.entity.TbManpowerExaminaAnswerCardCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaAnswerCardMapper {
    long countByExample(TbManpowerExaminaAnswerCardCriteria example);

    int deleteByExample(TbManpowerExaminaAnswerCardCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerExaminaAnswerCard record);

    int insertSelective(TbManpowerExaminaAnswerCard record);

    List<TbManpowerExaminaAnswerCard> selectByExample(TbManpowerExaminaAnswerCardCriteria example);

    TbManpowerExaminaAnswerCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaAnswerCard record, @Param("example") TbManpowerExaminaAnswerCardCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaAnswerCard record, @Param("example") TbManpowerExaminaAnswerCardCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaAnswerCard record);

    int updateByPrimaryKey(TbManpowerExaminaAnswerCard record);
}