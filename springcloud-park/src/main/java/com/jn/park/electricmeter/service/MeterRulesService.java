package com.jn.park.electricmeter.service;

import com.jn.park.electricmeter.vo.PriceRuleVO;
import com.jn.system.model.User;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 16:02
 * @version： v1.0
 * @modified By:
 */

public interface MeterRulesService {
    /**
     * 作废计价规则
     * @param id
     * @return
     */
    Integer deletePriceRule(String id);

    /**
     * 更新计价规则
     * @param  priceRuleVO
     * @return
     */
    Integer updatePriceRule(User user,PriceRuleVO priceRuleVO);
}
