package com.jn.enterprise.joinpark.org.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 服务顾问列表信息
 * @Author: yangph
 * @Date: 2019/2/14 11:04
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface ServiceOrgTempMapper {
    /**
     * 判断机构名称在系统中是否存在
     * @param orgId
     * @param orgName
     * @return
     */
    int orgNameIsExist(@Param("orgId")String orgId, @Param("orgName")String orgName);
}
