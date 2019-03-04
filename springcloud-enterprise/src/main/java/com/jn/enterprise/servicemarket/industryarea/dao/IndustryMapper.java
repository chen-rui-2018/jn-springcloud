package com.jn.enterprise.servicemarket.industryarea.dao;

import com.jn.enterprise.servicemarket.industryarea.model.Industry;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/27 12:01
 * @version： v1.0
 * @modified By:
 */
public interface IndustryMapper {

    /**
     * 行业领域列表
     * @param industryParameter
     * @return
     */
    List<Industry> selectIndustryList(IndustryParameter industryParameter);


    /**
     * 行业领域详情
     * @param id
     * @return
     */
    Industry getIndustryDetail(@Param("id") String id);

}
