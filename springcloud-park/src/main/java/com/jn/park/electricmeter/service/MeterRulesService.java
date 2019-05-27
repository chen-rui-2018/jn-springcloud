package com.jn.park.electricmeter.service;

import com.jn.common.model.Result;
import com.jn.park.electricmeter.vo.PriceRuleVO;
import com.jn.system.model.User;

import java.util.List;

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
    Integer deletePriceRule(User user,String id);

    /**
     * 更新计价规则
     * @param  priceRuleVO
     * @return
     */
    Integer updatePriceRule(User user,PriceRuleVO priceRuleVO);


    /**
     * 企业设置计价规则
     * @param ruleId
     * @param companyId
     * @return
     */
    Integer setRule(User user,String ruleId, String companyId);

    /**
     * 企业更新计价规则
     * @param ruleId
     * @param companyId
     * @return
     */
    Integer updateCompanysRule(User user,String id,String ruleId,String companyId);

    /**
     * 批量企业设置计价规则
     * @param companyIds
     * @param ruleId
     * @return
     */
    List<String> setBatchRule(User user , List<String> companyIds , String ruleId);

    /**
     * 企业每日的计价规则维护
     * @return
     */
    Integer setRulesInDayForCompany();

    /**
     * 拉闸/回复接口
     * @param meterCode
     * @param status
     * @return
     */
    Result SwitchMeter(String meterCode,String status);

    /**
     * 余额不足告警
     * @param companyId
     * @return
     */
    Result warningBalanceShort(String companyId);

    /**
     * 作废企业和计价规则之间的关系
     * @param user
     * @param id
     * @return
     */
    Integer deleteLinks(User user,String id);

}
