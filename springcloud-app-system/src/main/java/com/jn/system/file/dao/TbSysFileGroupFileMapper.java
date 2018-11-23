package com.jn.system.file.dao;

import com.jn.system.file.entity.TbSysFileGroupFile;
import com.jn.system.file.entity.TbSysFileGroupFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysFileGroupFileMapper {
    long countByExample(TbSysFileGroupFileCriteria example);

    int deleteByExample(TbSysFileGroupFileCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysFileGroupFile record);

    int insertSelective(TbSysFileGroupFile record);

    List<TbSysFileGroupFile> selectByExample(TbSysFileGroupFileCriteria example);

    TbSysFileGroupFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysFileGroupFile record, @Param("example") TbSysFileGroupFileCriteria example);

    int updateByExample(@Param("record") TbSysFileGroupFile record, @Param("example") TbSysFileGroupFileCriteria example);

    int updateByPrimaryKeySelective(TbSysFileGroupFile record);

    int updateByPrimaryKey(TbSysFileGroupFile record);
}