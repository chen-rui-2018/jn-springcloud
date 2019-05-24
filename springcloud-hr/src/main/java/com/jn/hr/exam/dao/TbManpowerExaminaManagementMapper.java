package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaManagement;
import com.jn.hr.exam.entity.TbManpowerExaminaManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaManagementMapper {
    long countByExample(TbManpowerExaminaManagementCriteria example);

    int deleteByExample(TbManpowerExaminaManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerExaminaManagement record);

    int insertSelective(TbManpowerExaminaManagement record);

    List<TbManpowerExaminaManagement> selectByExample(TbManpowerExaminaManagementCriteria example);

    TbManpowerExaminaManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaManagement record, @Param("example") TbManpowerExaminaManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaManagement record, @Param("example") TbManpowerExaminaManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaManagement record);

    int updateByPrimaryKey(TbManpowerExaminaManagement record);
}