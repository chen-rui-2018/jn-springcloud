package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceCompanyProImg;
import com.jn.enterprise.company.entity.TbServiceCompanyProImgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceCompanyProImgMapper {
    long countByExample(TbServiceCompanyProImgCriteria example);

    int deleteByExample(TbServiceCompanyProImgCriteria example);

    int deleteByPrimaryKey(String imgId);

    int insert(TbServiceCompanyProImg record);

    int insertSelective(TbServiceCompanyProImg record);

    List<TbServiceCompanyProImg> selectByExample(TbServiceCompanyProImgCriteria example);

    TbServiceCompanyProImg selectByPrimaryKey(String imgId);

    int updateByExampleSelective(@Param("record") TbServiceCompanyProImg record, @Param("example") TbServiceCompanyProImgCriteria example);

    int updateByExample(@Param("record") TbServiceCompanyProImg record, @Param("example") TbServiceCompanyProImgCriteria example);

    int updateByPrimaryKeySelective(TbServiceCompanyProImg record);

    int updateByPrimaryKey(TbServiceCompanyProImg record);
}