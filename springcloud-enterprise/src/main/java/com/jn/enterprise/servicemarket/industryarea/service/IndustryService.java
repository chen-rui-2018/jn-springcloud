package com.jn.enterprise.servicemarket.industryarea.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.industryarea.model.*;

import java.util.List;

/**
 * 行业领域管理
 * @author： jiangyl
 * @date： Created on 2019/2/27 11:14
 * @version： v1.0
 * @modified By:
 */
public interface IndustryService {

    /**
     * 行业领域列表
     * @param industryParameter
     * @return
     */
    PaginationData selectIndustryList(IndustryParameter industryParameter);


    /**
     * 保存/更新领域值
     * @param industryData
     * @param account
     * @return
     */
    Boolean saveOrUpdateIndustry(IndustryData industryData,String account);

    /**
     * 获取行业领域详情
     * @param id
     * @return
     */
    Industry getIndustryDetail(String id);

    /**
     * 机构字典列表
     * @param industryDictParameter
     * @return
     */
    List<IndustryDictionary> getIndustryDictionary(IndustryDictParameter industryDictParameter);

}
