package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.model.AdvisorListInfo;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorQueryConditions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 服务顾问列表信息
 * @Author: yangph
 * @Date: 2019/2/14 11:04
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface AdvisorMapper {
    /**
     * 根据查询条件获取顾问列表信息
     * @param advisorQueryConditions
     * @return
     */
    List<AdvisorListInfo>getServiceConsultantList(AdvisorQueryConditions advisorQueryConditions);
}
