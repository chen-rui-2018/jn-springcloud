package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelEnterpriseQualification;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelEnterpriseQualificationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelEnterpriseQualificationMapper {
    long countByExample(TbPdPersonnelEnterpriseQualificationCriteria example);

    int deleteByExample(TbPdPersonnelEnterpriseQualificationCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelEnterpriseQualification record);

    int insertSelective(TbPdPersonnelEnterpriseQualification record);

    List<TbPdPersonnelEnterpriseQualification> selectByExample(TbPdPersonnelEnterpriseQualificationCriteria example);

    TbPdPersonnelEnterpriseQualification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelEnterpriseQualification record, @Param("example") TbPdPersonnelEnterpriseQualificationCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelEnterpriseQualification record, @Param("example") TbPdPersonnelEnterpriseQualificationCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelEnterpriseQualification record);

    int updateByPrimaryKey(TbPdPersonnelEnterpriseQualification record);
}