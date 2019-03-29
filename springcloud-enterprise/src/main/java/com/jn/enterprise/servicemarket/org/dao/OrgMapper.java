package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.model.OrgCount;
import com.jn.enterprise.servicemarket.org.vo.OrgDetailVo;
import com.jn.enterprise.servicemarket.org.model.OrgParameter;
import com.jn.enterprise.model.ServiceOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 服务机构Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:58
 * @version： v1.0
 * @modified By:
 */
public interface OrgMapper {

    /**
     * 查询服务机构列表
     * @param parameter
     * @return
     */
    List<ServiceOrg> selectServiceOrgList(OrgParameter parameter);

    /**
     * 根据机构ID查询机构详情
     * @param orgId
     * @return
     */
    OrgDetailVo getServiceOrgDetail(@Param("orgId")String orgId);

    /**
     * 机构的产品/顾问数统计
     * @param orgId
     * @return
     */
    OrgCount getMyOrgInfo(@Param("orgId") String orgId);

}
