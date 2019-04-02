package com.jn.enterprise.pd.talent.dao;

import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNoticeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdTalentServiceNoticeMapper {
    long countByExample(TbPdTalentServiceNoticeCriteria example);

    int deleteByExample(TbPdTalentServiceNoticeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdTalentServiceNotice record);

    int insertSelective(TbPdTalentServiceNotice record);

    List<TbPdTalentServiceNotice> selectByExampleWithBLOBs(TbPdTalentServiceNoticeCriteria example);

    List<TbPdTalentServiceNotice> selectByExample(TbPdTalentServiceNoticeCriteria example);

    TbPdTalentServiceNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdTalentServiceNotice record, @Param("example") TbPdTalentServiceNoticeCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPdTalentServiceNotice record, @Param("example") TbPdTalentServiceNoticeCriteria example);

    int updateByExample(@Param("record") TbPdTalentServiceNotice record, @Param("example") TbPdTalentServiceNoticeCriteria example);

    int updateByPrimaryKeySelective(TbPdTalentServiceNotice record);

    int updateByPrimaryKeyWithBLOBs(TbPdTalentServiceNotice record);

    int updateByPrimaryKey(TbPdTalentServiceNotice record);
}