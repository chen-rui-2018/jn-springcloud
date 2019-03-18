package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelNotificationDetails;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelNotificationDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelNotificationDetailsMapper {
    long countByExample(TbPdPersonnelNotificationDetailsCriteria example);

    int deleteByExample(TbPdPersonnelNotificationDetailsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelNotificationDetails record);

    int insertSelective(TbPdPersonnelNotificationDetails record);

    List<TbPdPersonnelNotificationDetails> selectByExample(TbPdPersonnelNotificationDetailsCriteria example);

    TbPdPersonnelNotificationDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelNotificationDetails record, @Param("example") TbPdPersonnelNotificationDetailsCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelNotificationDetails record, @Param("example") TbPdPersonnelNotificationDetailsCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelNotificationDetails record);

    int updateByPrimaryKey(TbPdPersonnelNotificationDetails record);
}