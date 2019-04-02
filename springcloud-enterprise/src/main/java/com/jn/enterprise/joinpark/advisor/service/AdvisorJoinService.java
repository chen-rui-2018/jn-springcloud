package com.jn.enterprise.joinpark.advisor.service;

import com.jn.enterprise.servicemarket.advisor.model.AdvisorDetailParam;

/**
 * 顾问认证
 * @author： jiangyl
 * @date： Created on 2019/3/4 11:06
 * @version： v1.0
 * @modified By:
 */
public interface AdvisorJoinService {

    /**
     * 顾问认证保存/更新
     * @param advisorDetailParam
     * @param account
     * @return
     */
    int saveOrUpdateAdvisorDetail(AdvisorDetailParam advisorDetailParam,String account);

}
