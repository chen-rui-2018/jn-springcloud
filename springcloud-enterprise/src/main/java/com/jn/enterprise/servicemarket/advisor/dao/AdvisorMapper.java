package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.entity.TbServiceExperience;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceHonor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceProExper;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorListInfo;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorQueryConditions;
import com.jn.enterprise.servicemarket.advisor.model.ServiceEvaluationParam;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
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
     * @param serviceEvaluationParam      评价类型: 好评：praise  中评：average  差评：badReview
     * @return
     */
    List<ServiceRating>getServiceRatingInfo(ServiceEvaluationParam serviceEvaluationParam);

    /**
     * 批量插入顾问荣誉资质
     * @param list
     * @return
     */
    int insertServiceHonorList(List<TbServiceHonor> list);

    /**
     * 批量插入顾问项目经验
     * @param list
     * @return
     */
    int insertServiceProjectList(List<TbServiceProExper> list);

    /**
     * 批量插入顾问服务经验
     * @param list
     * @return
     */
    int insertServiceExperienceList(List<TbServiceExperience> list);
}
