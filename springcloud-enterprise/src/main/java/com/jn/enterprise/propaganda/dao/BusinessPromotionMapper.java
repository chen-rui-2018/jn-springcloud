package com.jn.enterprise.propaganda.dao;

import com.jn.enterprise.propaganda.model.BusinessPromotionDetailsShow;
import com.jn.enterprise.propaganda.model.BusinessPromotionListParam;
import com.jn.enterprise.propaganda.model.BusinessPromotionListShow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户中心--企业宣传
 * @Author: yangph
 * @Date: 2019/4/18 14:23
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface BusinessPromotionMapper {
    /**
     * 企业宣传列表查询
     * @param businessPromotionListParam
     * @param creator
     * @return
     */
    List<BusinessPromotionListShow> getBusinessPromotionList(@Param("bpp") BusinessPromotionListParam businessPromotionListParam,@Param("creator") String creator);

    /**
     * 企业宣传详情
     * @param propagandaId 宣传id
     * @return
     */
    BusinessPromotionDetailsShow getBusinessPromotionDetails(@Param("propagandaId") String propagandaId);

    /**
     * 增加点击量
     * @param id 宣传id
     * @return
     */
    int addClickNumById(@Param("id") String id);
}
