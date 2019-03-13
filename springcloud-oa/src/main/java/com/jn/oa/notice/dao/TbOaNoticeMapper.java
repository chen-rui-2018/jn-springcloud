package com.jn.oa.notice.dao;

import com.jn.oa.notice.entity.TbOaNotice;
import com.jn.oa.notice.entity.TbOaNoticeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaNoticeMapper {
    long countByExample(TbOaNoticeCriteria example);

    int deleteByExample(TbOaNoticeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaNotice record);

    int insertSelective(TbOaNotice record);

    List<TbOaNotice> selectByExampleWithBLOBs(TbOaNoticeCriteria example);

    List<TbOaNotice> selectByExample(TbOaNoticeCriteria example);

    TbOaNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaNotice record, @Param("example") TbOaNoticeCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbOaNotice record, @Param("example") TbOaNoticeCriteria example);

    int updateByExample(@Param("record") TbOaNotice record, @Param("example") TbOaNoticeCriteria example);

    int updateByPrimaryKeySelective(TbOaNotice record);

    int updateByPrimaryKeyWithBLOBs(TbOaNotice record);

    int updateByPrimaryKey(TbOaNotice record);
}