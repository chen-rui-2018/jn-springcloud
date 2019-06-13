package com.jn.park.pmpaybill.service;

import com.jn.park.pmpaybill.vo.PmPriceRuleVo;

/**
 * 物业单间管理service
 *
 * @author： shaobao
 * @date： Created on 2019/6/10 15:36
 * @version： v1.0
 * @modified By:
 **/
public interface PmPriceRuleService {

    /**
     * 为企业生成物业费单价规则信息
     *
     * @param pmPriceRuleVo
     */
    void createPmPriceRule(PmPriceRuleVo pmPriceRuleVo);
}
