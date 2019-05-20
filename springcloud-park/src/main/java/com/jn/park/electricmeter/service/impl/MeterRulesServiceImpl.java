package com.jn.park.electricmeter.service.impl;

import com.jn.park.electricmeter.dao.TbElectricPriceRulesMapper;
import com.jn.park.electricmeter.dao.TbElectricPriceruleCompanyInDayMapper;
import com.jn.park.electricmeter.dao.TbElectricPriceruleCompanyMapper;
import com.jn.park.electricmeter.dao.TbElectricRulesContentMapper;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.model.PriceRuleContent;
import com.jn.park.electricmeter.service.MeterRulesService;
import com.jn.park.electricmeter.vo.PriceRuleVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        deletePrice(id);
        return result++;
    }

    /**
     * 作废计价规则
     * @param id
     */
    private void deletePrice(String id){
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
    }
    @Override
    @ServiceLog(doAction = "更新计价规则")
    public Integer updatePriceRule(User user , PriceRuleVO priceRuleVO) {
        String ruleIdBefore = priceRuleVO.getId();
        List<PriceRuleContent> contents = priceRuleVO.getPriceRuleContents();
        boolean right = checkRules(contents);
        if(right){
            //获取之前的所有关系[企业关系]
            TbElectricPriceruleCompanyCriteria priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
            priceruleCompanyCriteria.or().andRuleIdEqualTo(ruleIdBefore).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            List<TbElectricPriceruleCompany>  companyList = priceruleCompanyMapper.selectByExample(priceruleCompanyCriteria);
            //作废
            TbElectricPriceruleCompany priceruleCompany = new TbElectricPriceruleCompany();
            priceruleCompany.setRecordStatus(new Byte(MeterConstants.INVALID));
            priceruleCompany.setModifiedTime(new Date());
            priceruleCompany.setModifierAccount(user.getAccount());
            priceruleCompanyMapper.updateByExampleSelective(priceruleCompany,priceruleCompanyCriteria);

            //获取之前的所有关系[企业日关系]
            TbElectricPriceruleCompanyInDayCriteria companyInDayCriteria =new TbElectricPriceruleCompanyInDayCriteria();
            companyInDayCriteria.or().andRuleIdEqualTo(ruleIdBefore).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            List<TbElectricPriceruleCompanyInDay>  companyInDaysList = companyInDayMapper.selectByExample(companyInDayCriteria);
            //作废
            TbElectricPriceruleCompanyInDay companyInDay = new TbElectricPriceruleCompanyInDay();
            companyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
            companyInDay.setModifiedTime(new Date());
            companyInDay.setModifierAccount(user.getAccount());
            companyInDayMapper.updateByExampleSelective(companyInDay,companyInDayCriteria);

            //作废规则
            deletePrice(ruleIdBefore);
            //生成新的
            String id = UUID.randomUUID().toString().replaceAll("-","");
            TbElectricPriceRules rules = new TbElectricPriceRules();
            rules.setId(id);
            rules.setRecordStatus(new Byte(MeterConstants.VALID));
            rules.setCreatedTime(new Date());
            rules.setCreatorAccount(user.getAccount());
            rules.setRuleName(priceRuleVO.getRuleName());
            rules.setRuleDesc(priceRuleVO.getRuleDesc());
            priceRulesMapper.insertSelective(rules);

            //保存规则
//            for(){
//
//            }


            //并且重新建立关联
            if(companyList !=null && companyList.size()>0){
                List<TbElectricPriceruleCompany> saveData = new ArrayList<>();
                for(TbElectricPriceruleCompany companyBean:companyList){
                    companyBean.setRuleId(id);
                    companyBean.setCreatedTime(new Date());
                    companyBean.setCreatorAccount(user.getAccount());
                    companyBean.setModifiedTime(null);
                    companyBean.setModifierAccount(null);
                    companyBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    saveData.add(companyBean);
                    if(saveData !=null && saveData.size()==50){
                        //保存数据
                    }
                }
                if(saveData !=null && saveData.size()>0){
                    //保存数据
                }
            }

            if(companyInDaysList !=null && companyInDaysList .size()>0){
                List<TbElectricPriceruleCompanyInDay> saveData = new ArrayList<>();
                for(TbElectricPriceruleCompanyInDay cidBean : companyInDaysList){
                    cidBean.setRuleId(id);
                    cidBean.setCreatedTime(new Date());
                    cidBean.setCreatorAccount(user.getAccount());
                    cidBean.setModifiedTime(null);
                    cidBean.setModifierAccount(null);
                    cidBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    saveData.add(cidBean);
                    if(saveData !=null && saveData.size()==50){
                        //保存数据
                    }
                }
                if(saveData !=null && saveData.size()>0){
                    //保存数据
                }
            }

        }
        return null;
    }

    /**
     * 检测规则是否正确
     */
    private boolean checkRules(List<PriceRuleContent> contents){
        return false;
    }
}
