package com.jn.hr.attendance.dao;

import com.jn.hr.attendance.entity.TbManpowerVacationManage;
import com.jn.hr.attendance.entity.TbManpowerVacationManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerVacationManageMapper {
    long countByExample(TbManpowerVacationManageCriteria example);

    int deleteByExample(TbManpowerVacationManageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerVacationManage record);

    int insertSelective(TbManpowerVacationManage record);

    List<TbManpowerVacationManage> selectByExample(TbManpowerVacationManageCriteria example);

    TbManpowerVacationManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerVacationManage record, @Param("example") TbManpowerVacationManageCriteria example);

    int updateByExample(@Param("record") TbManpowerVacationManage record, @Param("example") TbManpowerVacationManageCriteria example);

    int updateByPrimaryKeySelective(TbManpowerVacationManage record);

    int updateByPrimaryKey(TbManpowerVacationManage record);
}