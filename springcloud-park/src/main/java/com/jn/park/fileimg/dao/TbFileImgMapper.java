package com.jn.park.fileimg.dao;

import com.jn.park.fileimg.entity.TbFileImg;
import com.jn.park.fileimg.entity.TbFileImgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFileImgMapper {
    long countByExample(TbFileImgCriteria example);

    int deleteByExample(TbFileImgCriteria example);

    int deleteByPrimaryKey(String imgId);

    int insert(TbFileImg record);

    int insertSelective(TbFileImg record);

    List<TbFileImg> selectByExample(TbFileImgCriteria example);

    TbFileImg selectByPrimaryKey(String imgId);

    int updateByExampleSelective(@Param("record") TbFileImg record, @Param("example") TbFileImgCriteria example);

    int updateByExample(@Param("record") TbFileImg record, @Param("example") TbFileImgCriteria example);

    int updateByPrimaryKeySelective(TbFileImg record);

    int updateByPrimaryKey(TbFileImg record);
}