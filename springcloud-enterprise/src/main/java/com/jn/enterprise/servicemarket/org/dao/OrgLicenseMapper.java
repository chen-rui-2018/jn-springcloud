package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgLicense;

import java.util.List;

/**
 * 机构资质Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/18 14:20
 * @version： v1.0
 * @modified By:
 */
public interface OrgLicenseMapper {

    /**
     * 批量插入资质数据
     * @param list
     * @return
     */
    int insertLicenseList(List<TbServiceOrgLicense> list);

}
