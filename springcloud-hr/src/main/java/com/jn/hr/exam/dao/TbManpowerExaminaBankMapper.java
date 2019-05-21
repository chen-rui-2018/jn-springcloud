package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaBank;
import com.jn.hr.exam.entity.TbManpowerExaminaBankCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaBankMapper {
    long countByExample(TbManpowerExaminaBankCriteria example);

    int deleteByExample(TbManpowerExaminaBankCriteria example);

    int deleteByPrimaryKey(String testQuestionId);

    int insert(TbManpowerExaminaBank record);

    int insertSelective(TbManpowerExaminaBank record);

    List<TbManpowerExaminaBank> selectByExample(TbManpowerExaminaBankCriteria example);

    TbManpowerExaminaBank selectByPrimaryKey(String testQuestionId);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaBank record, @Param("example") TbManpowerExaminaBankCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaBank record, @Param("example") TbManpowerExaminaBankCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaBank record);

    int updateByPrimaryKey(TbManpowerExaminaBank record);
}