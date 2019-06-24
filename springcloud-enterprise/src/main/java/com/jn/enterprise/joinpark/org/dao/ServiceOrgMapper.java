package com.jn.enterprise.joinpark.org.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: yangph
 * @Date: 2019/6/18 11:28
 * @Version v1.0
 * @modified By:
 */
public interface ServiceOrgMapper {
    /**
     * 判断机构名称在系统中是否存在
     * @param orgId
     * @param orgName
     * @return
     */
    int orgNameIsExist(@Param("orgId")String orgId, @Param("orgName")String orgName);
}
