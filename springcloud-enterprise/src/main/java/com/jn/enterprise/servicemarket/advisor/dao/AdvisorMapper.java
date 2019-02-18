package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.model.AdvisorListInfo;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorQueryConditions;
import com.jn.enterprise.servicemarket.advisor.model.ServiceRating;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据查询条件获取服务评价信息
     * @param advisorAccount  顾问账号
     * @param ratingType      评价类型: 好评：praise  中评：average  差评：badReview
     * @return
     */
    List<ServiceRating>getServcieRatingInfo(@Param("advisorAccount") String advisorAccount, @Param("ratingType")String ratingType);
}
