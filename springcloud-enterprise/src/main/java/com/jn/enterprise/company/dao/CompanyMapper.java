package com.jn.enterprise.company.dao;

import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceEnterpriseParam;
import com.jn.enterprise.company.entity.TbServiceCompanyModify;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-5-6 16:20:25
 * @version： v1.0
 * @modified By:
 */
public interface CompanyMapper {

    /**
     * 根据企业ID获取最后一条更新数据
     * @param comId
     * @return
     */
    TbServiceCompanyModify getLastModify(@Param("comId") String comId);

    /**
     * 查询企业列表New
     * @param serviceEnterpriseParam
     * @return
     */
    List<ServiceEnterpriseCompany> getCompanyNewList(ServiceEnterpriseParam serviceEnterpriseParam);
}
