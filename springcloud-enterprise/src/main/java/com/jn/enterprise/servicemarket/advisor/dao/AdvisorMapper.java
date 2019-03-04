package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTeam;
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

    /**
     * 批量插入顾问荣誉资质
     * @param list
     * @return
     */
    int insertServiceHonorList(List<ServiceHonor> list);

    /**
     * 批量插入顾问项目经验
     * @param list
     * @return
     */
    int insertServiceProjectList(List<ServiceProjectExperience> list);

    /**
     * 批量插入顾问服务经验
     * @param list
     * @return
     */
    int insertServiceExperienceList(List<ServiceExperience> list);
}
