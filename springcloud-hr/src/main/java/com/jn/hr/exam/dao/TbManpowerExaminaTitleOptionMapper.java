package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaTitleOption;
import com.jn.hr.exam.entity.TbManpowerExaminaTitleOptionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerExaminaTitleOptionMapper {
    long countByExample(TbManpowerExaminaTitleOptionCriteria example);

    int deleteByExample(TbManpowerExaminaTitleOptionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerExaminaTitleOption record);

    int insertSelective(TbManpowerExaminaTitleOption record);

    List<TbManpowerExaminaTitleOption> selectByExample(TbManpowerExaminaTitleOptionCriteria example);

    TbManpowerExaminaTitleOption selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerExaminaTitleOption record, @Param("example") TbManpowerExaminaTitleOptionCriteria example);

    int updateByExample(@Param("record") TbManpowerExaminaTitleOption record, @Param("example") TbManpowerExaminaTitleOptionCriteria example);

    int updateByPrimaryKeySelective(TbManpowerExaminaTitleOption record);

    int updateByPrimaryKey(TbManpowerExaminaTitleOption record);
}