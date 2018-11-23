package com.jn.system.file.dao;

import com.jn.system.file.entity.TbSysFile;
import com.jn.system.file.entity.TbSysFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysFileMapper {
    long countByExample(TbSysFileCriteria example);

    int deleteByExample(TbSysFileCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysFile record);

    int insertSelective(TbSysFile record);

    List<TbSysFile> selectByExample(TbSysFileCriteria example);

    TbSysFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysFile record, @Param("example") TbSysFileCriteria example);

    int updateByExample(@Param("record") TbSysFile record, @Param("example") TbSysFileCriteria example);

    int updateByPrimaryKeySelective(TbSysFile record);

    int updateByPrimaryKey(TbSysFile record);
}