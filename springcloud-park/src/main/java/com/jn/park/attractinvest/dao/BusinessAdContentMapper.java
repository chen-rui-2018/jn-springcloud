package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.model.BusinessAdContent;
import com.jn.park.attractinvest.model.BusinessAdPage;

import java.util.List;

/**
 * 招商信息dao
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:38
 * @version： v1.0
 * @modified By:
 **/
public interface BusinessAdContentMapper {

    /**
     * 查询招商信息
     *
     * @param page
     * @return
     */
    List<BusinessAdContent> getBusinessAdContent(BusinessAdPage page);

    /**
     * 定时更新招商信息状态
     */
    void updateBusinessAdStatus();
}