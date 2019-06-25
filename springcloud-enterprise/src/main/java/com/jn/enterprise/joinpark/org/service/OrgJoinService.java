package com.jn.enterprise.joinpark.org.service;

import com.jn.company.model.IBPSResult;
import com.jn.enterprise.joinpark.org.model.PreferInfoShow;
import com.jn.enterprise.servicemarket.advisor.model.OrgNameIsExistParam;
import com.jn.enterprise.servicemarket.org.model.OrgDetailParameter;
import com.jn.enterprise.servicemarket.org.model.OrgDetailUpdateParameter;

import java.util.List;

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
    IBPSResult saveOrUpdateOrgDetail(OrgDetailParameter orgDetailParameter, String account);

    /**
     * 判断机构名称是否已存在
     * @param orgParam
     * @return
     */
    String orgNameIsExist(OrgNameIsExistParam orgParam);

    /**
     * 获取客户偏好机构字典表所有值
     * @return
     */
    List<PreferInfoShow> getPreferInfoList(List<String> params);
}
