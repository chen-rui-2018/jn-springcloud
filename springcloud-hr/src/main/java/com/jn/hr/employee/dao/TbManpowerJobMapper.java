package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerJob;
import com.jn.hr.employee.entity.TbManpowerJobCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerJobMapper {
    long countByExample(TbManpowerJobCriteria example);

    int deleteByExample(TbManpowerJobCriteria example);

    int deleteByPrimaryKey(String jobId);

    int insert(TbManpowerJob record);

    int insertSelective(TbManpowerJob record);

    List<TbManpowerJob> selectByExample(TbManpowerJobCriteria example);

    TbManpowerJob selectByPrimaryKey(String jobId);

    int updateByExampleSelective(@Param("record") TbManpowerJob record, @Param("example") TbManpowerJobCriteria example);

    int updateByExample(@Param("record") TbManpowerJob record, @Param("example") TbManpowerJobCriteria example);

    int updateByPrimaryKeySelective(TbManpowerJob record);

    int updateByPrimaryKey(TbManpowerJob record);
}