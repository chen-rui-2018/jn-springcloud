package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelAppointmentCounsel;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelAppointmentCounselCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelAppointmentCounselMapper {
    long countByExample(TbPdPersonnelAppointmentCounselCriteria example);

    int deleteByExample(TbPdPersonnelAppointmentCounselCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelAppointmentCounsel record);

    int insertSelective(TbPdPersonnelAppointmentCounsel record);

    List<TbPdPersonnelAppointmentCounsel> selectByExample(TbPdPersonnelAppointmentCounselCriteria example);

    TbPdPersonnelAppointmentCounsel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelAppointmentCounsel record, @Param("example") TbPdPersonnelAppointmentCounselCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelAppointmentCounsel record, @Param("example") TbPdPersonnelAppointmentCounselCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelAppointmentCounsel record);

    int updateByPrimaryKey(TbPdPersonnelAppointmentCounsel record);
}