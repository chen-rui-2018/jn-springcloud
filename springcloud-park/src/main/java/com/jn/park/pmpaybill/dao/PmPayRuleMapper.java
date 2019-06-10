package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayRule;

import java.util.List;

/**
 * 收费规则的dao层
 *
 * @author： shaobao
 * @date： Created on 2019/5/25 19:46
 * @version： v1.0
 * @modified By:
 **/
public interface PmPayRuleMapper {

    /**
     * 根据企业id,获取企业需要交费的所有购物项信息
     *
     * @return
     */
    List<TbPmPayRule> getPmRuleByCompanyId(String companyId);
}
