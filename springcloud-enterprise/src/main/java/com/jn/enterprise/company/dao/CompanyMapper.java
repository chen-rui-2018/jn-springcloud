package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceCompanyModify;
import org.apache.ibatis.annotations.Param;

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
}
