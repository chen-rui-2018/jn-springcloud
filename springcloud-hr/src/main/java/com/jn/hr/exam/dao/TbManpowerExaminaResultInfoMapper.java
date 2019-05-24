package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaResultInfo;
import com.jn.hr.exam.entity.TbManpowerExaminaResultInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaResultInfoMapper {
    long countByExample(TbManpowerExaminaResultInfoCriteria example);

    int deleteByExample(TbManpowerExaminaResultInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerExaminaResultInfo record);

    int insertSelective(TbManpowerExaminaResultInfo record);

    List<TbManpowerExaminaResultInfo> selectByExample(TbManpowerExaminaResultInfoCriteria example);

    TbManpowerExaminaResultInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaResultInfo record, @Param("example") TbManpowerExaminaResultInfoCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaResultInfo record, @Param("example") TbManpowerExaminaResultInfoCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaResultInfo record);

    int updateByPrimaryKey(TbManpowerExaminaResultInfo record);
}