package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceProductLoanType;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductLoanTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceProductLoanTypeMapper {
    long countByExample(TbServiceProductLoanTypeCriteria example);

    int deleteByExample(TbServiceProductLoanTypeCriteria example);

    int deleteByPrimaryKey(String loanCode);

    int insert(TbServiceProductLoanType record);

    int insertSelective(TbServiceProductLoanType record);

    List<TbServiceProductLoanType> selectByExample(TbServiceProductLoanTypeCriteria example);

    TbServiceProductLoanType selectByPrimaryKey(String loanCode);

    int updateByExampleSelective(@Param("record") TbServiceProductLoanType record, @Param("example") TbServiceProductLoanTypeCriteria example);

    int updateByExample(@Param("record") TbServiceProductLoanType record, @Param("example") TbServiceProductLoanTypeCriteria example);

    int updateByPrimaryKeySelective(TbServiceProductLoanType record);

    int updateByPrimaryKey(TbServiceProductLoanType record);
}