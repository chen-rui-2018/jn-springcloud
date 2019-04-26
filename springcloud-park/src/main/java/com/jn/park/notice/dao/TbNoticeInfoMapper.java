package com.jn.park.notice.dao;

import com.jn.park.notice.entity.TbNoticeInfo;
import com.jn.park.notice.entity.TbNoticeInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoticeInfoMapper {
    long countByExample(TbNoticeInfoCriteria example);

    int deleteByExample(TbNoticeInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbNoticeInfo record);

    int insertSelective(TbNoticeInfo record);

    List<TbNoticeInfo> selectByExample(TbNoticeInfoCriteria example);

    TbNoticeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbNoticeInfo record, @Param("example") TbNoticeInfoCriteria example);

    int updateByExample(@Param("record") TbNoticeInfo record, @Param("example") TbNoticeInfoCriteria example);

    int updateByPrimaryKeySelective(TbNoticeInfo record);

    int updateByPrimaryKey(TbNoticeInfo record);
}