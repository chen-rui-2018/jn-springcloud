package com.jn.enterprise.joinpark.org.service;

import com.jn.enterprise.servicemarket.org.model.OrgDetailParameter;
import com.jn.enterprise.servicemarket.org.model.OrgDetailUpdateParameter;

/**
 * 加入园区-机构认证
 * @author： jiangyl
 * @date： Created on 2019/3/4 11:03
 * @version： v1.0
 * @modified By:
 */
public interface OrgJoinService {

    /**
     * 机构认证保存/更新
     * @param orgDetailParameter
     * @param account
     * @return
     */
    int saveOrUpdateOrgDetail(OrgDetailParameter orgDetailParameter,String account);


}
