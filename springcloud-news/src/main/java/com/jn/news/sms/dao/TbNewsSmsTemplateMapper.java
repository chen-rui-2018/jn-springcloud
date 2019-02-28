package com.jn.news.sms.dao;

import com.jn.news.sms.entity.TbNewsSmsTemplate;
import com.jn.news.sms.entity.TbNewsSmsTemplateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNewsSmsTemplateMapper {
    long countByExample(TbNewsSmsTemplateCriteria example);

    int deleteByExample(TbNewsSmsTemplateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbNewsSmsTemplate record);

    int insertSelective(TbNewsSmsTemplate record);

    List<TbNewsSmsTemplate> selectByExample(TbNewsSmsTemplateCriteria example);

    TbNewsSmsTemplate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbNewsSmsTemplate record, @Param("example") TbNewsSmsTemplateCriteria example);

    int updateByExample(@Param("record") TbNewsSmsTemplate record, @Param("example") TbNewsSmsTemplateCriteria example);

    int updateByPrimaryKeySelective(TbNewsSmsTemplate record);

    int updateByPrimaryKey(TbNewsSmsTemplate record);
}