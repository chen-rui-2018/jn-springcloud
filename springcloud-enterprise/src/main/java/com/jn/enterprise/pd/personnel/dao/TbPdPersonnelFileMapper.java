package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelFile;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelFileMapper {
    long countByExample(TbPdPersonnelFileCriteria example);

    int deleteByExample(TbPdPersonnelFileCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelFile record);

    int insertSelective(TbPdPersonnelFile record);

    List<TbPdPersonnelFile> selectByExample(TbPdPersonnelFileCriteria example);

    TbPdPersonnelFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelFile record, @Param("example") TbPdPersonnelFileCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelFile record, @Param("example") TbPdPersonnelFileCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelFile record);

    int updateByPrimaryKey(TbPdPersonnelFile record);
}