package com.jn.park.electricmeter.service.impl;

import com.jn.park.electricmeter.dao.TbElectricPriceRulesMapper;
import com.jn.park.electricmeter.dao.TbElectricPriceruleCompanyInDayMapper;
import com.jn.park.electricmeter.dao.TbElectricPriceruleCompanyMapper;
import com.jn.park.electricmeter.dao.TbElectricRulesContentMapper;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.service.MeterRulesService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 16:04
 * @version： v1.0
 * @modified By:
 */
@Service
public class MeterRulesServiceImpl implements MeterRulesService {

    @Autowired
    private TbElectricPriceRulesMapper priceRulesMapper;
    @Autowired
    private TbElectricRulesContentMapper priceRulesContentMapper;
    @Autowired
    private TbElectricPriceruleCompanyInDayMapper companyInDayMapper;
    @Autowired
    private TbElectricPriceruleCompanyMapper  priceruleCompanyMapper;

    @Override
    @ServiceLog(doAction = "作废计价规则")
    public Integer deletePriceRule(String id) {
        Integer result=0;
        //作废当日企业和计价规则之间的关系
        TbElectricPriceruleCompanyInDay companyInDay = new TbElectricPriceruleCompanyInDay();
        companyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricPriceruleCompanyInDayCriteria companyInDayCriteria = new TbElectricPriceruleCompanyInDayCriteria();
        companyInDayCriteria.or().andRuleIdEqualTo(id);
        companyInDayMapper.updateByExampleSelective(companyInDay,companyInDayCriteria);
        //作废关系表
        TbElectricPriceruleCompany priceruleCompany = new TbElectricPriceruleCompany();
        priceruleCompany.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricPriceruleCompanyCriteria priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
        priceruleCompanyCriteria.or().andRuleIdEqualTo(id);
        priceruleCompanyMapper.updateByExampleSelective(priceruleCompany,priceruleCompanyCriteria);

        //作废计价规则
        TbElectricPriceRules ruleRecord = new TbElectricPriceRules();
        ruleRecord.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricPriceRulesCriteria rulesCriteria = new TbElectricPriceRulesCriteria();
        rulesCriteria.or().andIdEqualTo(id);
        priceRulesMapper.updateByExampleSelective(ruleRecord,rulesCriteria);
        //作废计价规则内容
        TbElectricRulesContent content = new TbElectricRulesContent();
        content.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricRulesContentCriteria contentCriteria = new TbElectricRulesContentCriteria();
        contentCriteria.or().andRuleIdEqualTo(id);
        priceRulesContentMapper.updateByExampleSelective(content,contentCriteria);

        return result++;
    }

    @Override
    @ServiceLog(doAction = "更新计价规则")
    public Integer updatePriceRule(String id) {



        return null;
    }

    /**
     * 检测规则是否正确
     */
    private boolean checkRules(){
        return false;
    }
}
