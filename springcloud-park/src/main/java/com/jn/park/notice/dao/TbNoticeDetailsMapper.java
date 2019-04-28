package com.jn.park.notice.dao;

import com.jn.park.notice.entity.TbNoticeDetails;
import com.jn.park.notice.entity.TbNoticeDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoticeDetailsMapper {
    long countByExample(TbNoticeDetailsCriteria example);

    int deleteByExample(TbNoticeDetailsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbNoticeDetails record);

    int insertSelective(TbNoticeDetails record);

    List<TbNoticeDetails> selectByExampleWithBLOBs(TbNoticeDetailsCriteria example);

    List<TbNoticeDetails> selectByExample(TbNoticeDetailsCriteria example);

    TbNoticeDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbNoticeDetails record, @Param("example") TbNoticeDetailsCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbNoticeDetails record, @Param("example") TbNoticeDetailsCriteria example);

    int updateByExample(@Param("record") TbNoticeDetails record, @Param("example") TbNoticeDetailsCriteria example);

    int updateByPrimaryKeySelective(TbNoticeDetails record);

    int updateByPrimaryKeyWithBLOBs(TbNoticeDetails record);

    int updateByPrimaryKey(TbNoticeDetails record);
}