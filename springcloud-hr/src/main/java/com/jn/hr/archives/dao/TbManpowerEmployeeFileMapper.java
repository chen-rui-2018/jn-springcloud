package com.jn.hr.archives.dao;

import com.jn.hr.archives.entity.TbManpowerEmployeeFile;
import com.jn.hr.archives.entity.TbManpowerEmployeeFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerEmployeeFileMapper {
    long countByExample(TbManpowerEmployeeFileCriteria example);

    int deleteByExample(TbManpowerEmployeeFileCriteria example);

    int deleteByPrimaryKey(String fileId);

    int insert(TbManpowerEmployeeFile record);

    int insertSelective(TbManpowerEmployeeFile record);

    List<TbManpowerEmployeeFile> selectByExample(TbManpowerEmployeeFileCriteria example);

    TbManpowerEmployeeFile selectByPrimaryKey(String fileId);

    int updateByExampleSelective(@Param("record") TbManpowerEmployeeFile record, @Param("example") TbManpowerEmployeeFileCriteria example);

    int updateByExample(@Param("record") TbManpowerEmployeeFile record, @Param("example") TbManpowerEmployeeFileCriteria example);

    int updateByPrimaryKeySelective(TbManpowerEmployeeFile record);

    int updateByPrimaryKey(TbManpowerEmployeeFile record);
}