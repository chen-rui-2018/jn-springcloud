package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.entity.TbServiceCertificateType;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceCertificateTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceCertificateTypeMapper {
    long countByExample(TbServiceCertificateTypeCriteria example);

    int deleteByExample(TbServiceCertificateTypeCriteria example);

    int insert(TbServiceCertificateType record);

    int insertSelective(TbServiceCertificateType record);

    List<TbServiceCertificateType> selectByExample(TbServiceCertificateTypeCriteria example);

    int updateByExampleSelective(@Param("record") TbServiceCertificateType record, @Param("example") TbServiceCertificateTypeCriteria example);

    int updateByExample(@Param("record") TbServiceCertificateType record, @Param("example") TbServiceCertificateTypeCriteria example);
}