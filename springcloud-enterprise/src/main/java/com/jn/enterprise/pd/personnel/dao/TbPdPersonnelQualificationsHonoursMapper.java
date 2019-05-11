package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelQualificationsHonours;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelQualificationsHonoursCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelQualificationsHonoursMapper {
    long countByExample(TbPdPersonnelQualificationsHonoursCriteria example);

    int deleteByExample(TbPdPersonnelQualificationsHonoursCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelQualificationsHonours record);

    int insertSelective(TbPdPersonnelQualificationsHonours record);

    List<TbPdPersonnelQualificationsHonours> selectByExample(TbPdPersonnelQualificationsHonoursCriteria example);

    TbPdPersonnelQualificationsHonours selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelQualificationsHonours record, @Param("example") TbPdPersonnelQualificationsHonoursCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelQualificationsHonours record, @Param("example") TbPdPersonnelQualificationsHonoursCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelQualificationsHonours record);

    int updateByPrimaryKey(TbPdPersonnelQualificationsHonours record);
}