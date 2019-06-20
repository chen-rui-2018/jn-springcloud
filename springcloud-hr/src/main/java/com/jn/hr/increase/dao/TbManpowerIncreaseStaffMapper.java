package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerIncreaseStaff;
import com.jn.hr.increase.entity.TbManpowerIncreaseStaffCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerIncreaseStaffMapper {
    long countByExample(TbManpowerIncreaseStaffCriteria example);

    int deleteByExample(TbManpowerIncreaseStaffCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerIncreaseStaff record);

    int insertSelective(TbManpowerIncreaseStaff record);

    List<TbManpowerIncreaseStaff> selectByExample(TbManpowerIncreaseStaffCriteria example);

    TbManpowerIncreaseStaff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerIncreaseStaff record, @Param("example") TbManpowerIncreaseStaffCriteria example);

    int updateByExample(@Param("record") TbManpowerIncreaseStaff record, @Param("example") TbManpowerIncreaseStaffCriteria example);

    int updateByPrimaryKeySelective(TbManpowerIncreaseStaff record);

    int updateByPrimaryKey(TbManpowerIncreaseStaff record);
}