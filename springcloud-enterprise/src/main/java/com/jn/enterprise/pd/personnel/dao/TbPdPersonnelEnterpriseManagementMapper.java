package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelEnterpriseManagement;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelEnterpriseManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelEnterpriseManagementMapper {
    long countByExample(TbPdPersonnelEnterpriseManagementCriteria example);

    int deleteByExample(TbPdPersonnelEnterpriseManagementCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelEnterpriseManagement record);

    int insertSelective(TbPdPersonnelEnterpriseManagement record);

    List<TbPdPersonnelEnterpriseManagement> selectByExample(TbPdPersonnelEnterpriseManagementCriteria example);

    TbPdPersonnelEnterpriseManagement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelEnterpriseManagement record, @Param("example") TbPdPersonnelEnterpriseManagementCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelEnterpriseManagement record, @Param("example") TbPdPersonnelEnterpriseManagementCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelEnterpriseManagement record);

    int updateByPrimaryKey(TbPdPersonnelEnterpriseManagement record);
}