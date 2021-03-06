package com.jn.park.electricmeter.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.common.util.bean.BeanHeader;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.hardware.model.electricmeter.ElectricMeterStatusShow;
import com.jn.hardware.model.electricmeter.ElectricMeterSwitchParam;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.park.electricmeter.dao.*;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.enums.MeterExceptionEnums;
import com.jn.park.electricmeter.model.CompanyModel;
import com.jn.park.electricmeter.model.PriceRuleContentModel;
import com.jn.park.electricmeter.model.SwitchModel;
import com.jn.park.electricmeter.service.MeterRulesService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.electricmeter.vo.PriceRuleVO;
import com.jn.pay.api.PayAccountClient;
import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookEntIdOrUserIdParam;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 16:04
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = MessageSource.class)
public class MeterRulesServiceImpl implements MeterRulesService {
    @Autowired(required = false)
    private MessageSource messageSource;

    @Autowired(required = false)
    private ElectricMeterClient electricMeterClient;
    @Autowired(required = false)
    private TbElectricPriceRulesMapper priceRulesMapper;
    @Autowired(required = false)
    private TbElectricRulesContentMapper priceRulesContentMapper;
    @Autowired(required = false)
    private TbElectricPriceruleCompanyInDayMapper companyInDayMapper;
    @Autowired(required = false)
    private TbElectricPriceruleCompanyMapper priceruleCompanyMapper;
    @Autowired(required = false)
    private MeterDao meterDao;
    @Autowired(required = false)
    private TbElectricMeterInfoMapper tbElectricMeterInfoMapper;
    @Autowired(required = false)
    private PayAccountClient payAccountClient;

    @Autowired(required = false)
    private TbElectricCostMapper tbElectricCostMapper;
    @Autowired(required = false)
    private TbElectricTurnRulesMapper tbElectricTurnRulesMapper;

    @Autowired(required = false)
    private CompanyClient companyClient;
    @Autowired(required = false)
    private TbElectricWarningRulesMapper warningRulesMapper;
    @Autowired(required = false)
    private TbElectricPriceruleCompanyInDayMapper priceruleCompanyInDayMapper;
    Logger logger = LoggerFactory.getLogger(MeterServiceImpl.class);

    @Override
    @ServiceLog(doAction = "作废计价规则")
    public Integer deletePriceRule(User user, String id) {
        Integer result = 0;
        //作废当日企业和计价规则之间的关系
        TbElectricPriceruleCompanyInDay companyInDay = new TbElectricPriceruleCompanyInDay();
        companyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
        companyInDay.setModifierAccount(user.getAccount());
        companyInDay.setModifiedTime(new Date());
        TbElectricPriceruleCompanyInDayCriteria companyInDayCriteria = new TbElectricPriceruleCompanyInDayCriteria();
        companyInDayCriteria.or().andRuleIdEqualTo(id);
        companyInDayMapper.updateByExampleSelective(companyInDay, companyInDayCriteria);
        //作废关系表
        TbElectricPriceruleCompany priceruleCompany = new TbElectricPriceruleCompany();
        priceruleCompany.setRecordStatus(new Byte(MeterConstants.INVALID));
        priceruleCompany.setModifierAccount(user.getAccount());
        priceruleCompany.setModifiedTime(new Date());
        TbElectricPriceruleCompanyCriteria priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
        priceruleCompanyCriteria.or().andRuleIdEqualTo(id);
        priceruleCompanyMapper.updateByExampleSelective(priceruleCompany, priceruleCompanyCriteria);
        deletePrice(user, id);
        return result + 1;
    }

    /**
     * 作废计价规则
     *
     * @param id
     */
    private void deletePrice(User user, String id) {
        //作废计价规则
        TbElectricPriceRules ruleRecord = new TbElectricPriceRules();
        ruleRecord.setRecordStatus(new Byte(MeterConstants.INVALID));
        ruleRecord.setModifierAccount(user.getAccount());
        ruleRecord.setModifiedTime(new Date());
        TbElectricPriceRulesCriteria rulesCriteria = new TbElectricPriceRulesCriteria();
        rulesCriteria.or().andIdEqualTo(id);
        priceRulesMapper.updateByExampleSelective(ruleRecord, rulesCriteria);
        //作废计价规则内容
        TbElectricRulesContent content = new TbElectricRulesContent();
        content.setRecordStatus(new Byte(MeterConstants.INVALID));
        content.setModifierAccount(user.getAccount());
        content.setModifiedTime(new Date());
        TbElectricRulesContentCriteria contentCriteria = new TbElectricRulesContentCriteria();
        contentCriteria.or().andRuleIdEqualTo(id);
        priceRulesContentMapper.updateByExampleSelective(content, contentCriteria);
    }

    @Override
    @ServiceLog(doAction = "更新计价规则")
    public Integer updatePriceRule(User user, PriceRuleVO priceRuleVO) {
        Integer result = 0;
        String ruleIdBefore = priceRuleVO.getId();

        //检查计价规则
        List<PriceRuleContentModel> contents = priceRuleVO.getPriceRuleContents();

        //默认计价规则是错的
        boolean wrong = true;
        if (contents != null && contents.size() > 0) {
            wrong = checkRules(contents);
        } else {
            throw new JnSpringCloudException(MeterExceptionEnums.PRICE_RULE_IS_NULL);
        }
        if (wrong) {
            throw new JnSpringCloudException(MeterExceptionEnums.PRICE_RULE_WRONG);
        }
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        //检测默认的计价规则是否存在 // 存在，则需要进行作废；后才可新建 //不存在则新建

        if(priceRuleVO.getIsDefaultUse().equals(MeterConstants.IS_DEFAULT_PRICE_RULE)){
            TbElectricPriceRulesCriteria criteria = new TbElectricPriceRulesCriteria();
            criteria.or().andIsDefaultUseEqualTo(MeterConstants.IS_DEFAULT_PRICE_RULE).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            List<TbElectricPriceRules>  rules = priceRulesMapper.selectByExample(criteria);
            if(rules!=null && rules.size()>0){
                //如果更新的不是默认计价规则
                if( ! rules.get(0).getId().equals(priceRuleVO.getId())){
                    throw new JnSpringCloudException(MeterExceptionEnums.DEFAULT_PRICE_ERROR);
                }
            }

        }


        if(StringUtils.isBlank(ruleIdBefore)){
            //新增
            insertPriceRule(id,priceRuleVO, user,contents);
        }else{
            //修改
            //获取之前的所有关系[企业关系]
            TbElectricPriceruleCompanyCriteria priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
            priceruleCompanyCriteria.or().andRuleIdEqualTo(ruleIdBefore).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            List<TbElectricPriceruleCompany> companyList = priceruleCompanyMapper.selectByExample(priceruleCompanyCriteria);
            //作废
            TbElectricPriceruleCompany priceruleCompany = new TbElectricPriceruleCompany();
            priceruleCompany.setRecordStatus(new Byte(MeterConstants.INVALID));
            priceruleCompany.setModifiedTime(new Date());
            priceruleCompany.setModifierAccount(user.getAccount());
            priceruleCompanyMapper.updateByExampleSelective(priceruleCompany, priceruleCompanyCriteria);

            //获取之前的所有关系[企业日关系]
            Date nowDate = null;
            try{
                nowDate = DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"),"yyyy-MM-dd");
            }catch(ParseException e){
                e.printStackTrace();
                throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
            }

            TbElectricPriceruleCompanyInDayCriteria companyInDayCriteria = new TbElectricPriceruleCompanyInDayCriteria();
            companyInDayCriteria.or().andRuleIdEqualTo(ruleIdBefore).andRecordStatusEqualTo(new Byte(MeterConstants.VALID))
                    .andDayEqualTo(nowDate);
            List<TbElectricPriceruleCompanyInDay> companyInDaysList = companyInDayMapper.selectByExample(companyInDayCriteria);
            //作废今日的关系
            TbElectricPriceruleCompanyInDay companyInDay = new TbElectricPriceruleCompanyInDay();
            companyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
            companyInDay.setModifiedTime(new Date());
            companyInDay.setModifierAccount(user.getAccount());
            companyInDayMapper.updateByExampleSelective(companyInDay, companyInDayCriteria);

            //作废规则
            deletePrice(user, ruleIdBefore);
            //生成新的
            insertPriceRule(id,priceRuleVO, user,contents);

            //并且重新建立关联
            if (companyList != null && companyList.size() > 0) {
                List<TbElectricPriceruleCompany> saveData = new ArrayList<>();
                for (TbElectricPriceruleCompany companyBean : companyList) {
                    companyBean.setRuleId(id);
                    companyBean.setCreatedTime(new Date());
                    companyBean.setCreatorAccount(user.getAccount());
                    //companyBean.setModifiedTime(null);
                    //companyBean.setModifierAccount(null);
                    companyBean.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    saveData.add(companyBean);
                    if (saveData != null && saveData.size() == 50) {
                        //保存数据
                        meterDao.saveCompanyLinks(saveData);
                        saveData = new ArrayList<>();

                    }
                }
                if (saveData != null && saveData.size() > 0) {
                    //保存数据
                    meterDao.saveCompanyLinks(saveData);
                }
            }

            if (companyInDaysList != null && companyInDaysList.size() > 0) {
                List<TbElectricPriceruleCompanyInDay> saveData = new ArrayList<>();
                TbElectricPriceruleCompanyInDay save = null;
                for (TbElectricPriceruleCompanyInDay cidBean : companyInDaysList) {

                    save = new TbElectricPriceruleCompanyInDay();
                    BeanUtils.copyProperties(cidBean,save);
                    save.setRuleId(id);
                    save.setRuleName(priceRuleVO.getRuleName());
                    save.setCompanyName(cidBean.getCompanyName());
                    save.setCreatedTime(new Date());
                    save.setCreatorAccount(user.getAccount());
                    save.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    saveData.add(save);
                    if (saveData != null && saveData.size() == 50) {
                        //保存数据
                        meterDao.saveCompanyLinksInDay(saveData);
                        saveData = new ArrayList<>();

                    }
                }
                if (saveData != null && saveData.size() > 0) {
                    //保存数据
                    meterDao.saveCompanyLinksInDay(saveData);
                }
            }
        }

        return result + 1;
    }

    private void insertPriceRule(String id,PriceRuleVO priceRuleVO,User user,List<PriceRuleContentModel> contents){

        TbElectricPriceRules rules = new TbElectricPriceRules();
        rules.setId(id);
        rules.setRecordStatus(new Byte(MeterConstants.VALID));
        rules.setCreatedTime(new Date());
        rules.setCreatorAccount(user.getAccount());
        rules.setRuleName(priceRuleVO.getRuleName());
        rules.setRuleDesc(priceRuleVO.getRuleDesc());
        rules.setIsDefaultUse(priceRuleVO.getIsDefaultUse());
        priceRulesMapper.insertSelective(rules);

        //保存规则
        //TbElectricRulesContentMapper
        TbElectricRulesContent rulesContent = null;
        List<TbElectricRulesContent> rulesContents = new ArrayList<>();
        for (PriceRuleContentModel content : contents) {
            rulesContent = new TbElectricRulesContent();
            rulesContent.setRecordStatus(new Byte(MeterConstants.VALID));
            rulesContent.setCreatedTime(new Date());
            rulesContent.setCreatorAccount(user.getAccount());
            rulesContent.setEnd(content.getEnd());
            rulesContent.setStart(content.getStart());
            rulesContent.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            rulesContent.setRuleId(id);
            rulesContent.setPrice(content.getPrice());
            rulesContent.setRuleName(priceRuleVO.getRuleName());
            rulesContents.add(rulesContent);
        }
        //保存计价规则内容
        meterDao.saveRulesContent(rulesContents);
    }

    /**
     * 检测规则是否正确
     */
    private boolean checkRules(List<PriceRuleContentModel> contents) {
        //0-7:代表的是[不包含7点以后的]
        // 0：0-1，
        // 1：1-2，
        // 2：2-3，
        // 3：3-4，
        // 4：4-5，
        // 5：5-6，
        // 6：6-7，
        boolean wrong = true;
        List<Integer> hours = new ArrayList<>();
        for (PriceRuleContentModel content : contents) {
            for (int index = content.getStart(); index < content.getEnd(); index++) {
                hours.add(index);
            }
            if (!StringUtils.isNumeric(content.getPrice())) {
                break;
            }
        }
        if (hours != null && hours.size() == 24) {
            wrong = false;
        }
        return wrong;
    }

    /**
     * 作废企业和计价规则之间的关系
     * @param user
     * @param id
     * @return
     */
    public Integer deleteLinks(User user ,String id){
        Integer result = 0;

        TbElectricPriceruleCompanyCriteria  priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
        priceruleCompanyCriteria.or().andIdEqualTo(id);
        TbElectricPriceruleCompany priceruleCompany = priceruleCompanyMapper.selectByPrimaryKey(id);
        if(priceruleCompany ==null){
            throw new JnSpringCloudException(MeterExceptionEnums.LINK_ID_ERROR);
        }
        TbElectricPriceruleCompany pCompany = new TbElectricPriceruleCompany();
        pCompany.setRecordStatus(new Byte(MeterConstants.INVALID));
        pCompany.setModifiedTime(new Date());
        pCompany.setModifierAccount(user.getAccount());
        priceruleCompanyMapper.updateByExampleSelective(pCompany,priceruleCompanyCriteria);

        //如果今日的关系日志已经写入，也得作废
        TbElectricPriceruleCompanyInDay priceruleCompanyInDay = new TbElectricPriceruleCompanyInDay();
        priceruleCompanyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
        priceruleCompanyInDay.setModifiedTime(new Date());
        priceruleCompanyInDay.setModifierAccount(user.getAccount());
        TbElectricPriceruleCompanyInDayCriteria priceruleCompanyInDayCriteria = new TbElectricPriceruleCompanyInDayCriteria();
        Date nowDate = null;
        try{
            nowDate = DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"),"yyyy-MM-dd");
        }catch(ParseException e){
            e.printStackTrace();
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }

        priceruleCompanyInDayCriteria.or().andDayEqualTo(nowDate).andCompanyIdEqualTo(priceruleCompany.getCompanyId())
                .andRuleIdEqualTo(priceruleCompany.getRuleId());
        priceruleCompanyInDayMapper.updateByExampleSelective(priceruleCompanyInDay,priceruleCompanyInDayCriteria);
        return result+=1;
    }



    @ServiceLog(doAction = "企业设置计价规则")
    @Override
    public Integer setRule(User user, String ruleId, String companyId) {
        Integer result = 0;
        //modifyRules(user, companyId,ruleId);
        //检测企业是否已经关联了计价规则，如果关联了，则直接返回
        TbElectricPriceruleCompanyCriteria priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
        priceruleCompanyCriteria.or().andCompanyIdEqualTo(companyId).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricPriceruleCompany> companyList = priceruleCompanyMapper.selectByExample(priceruleCompanyCriteria);
        if (companyList != null && companyList.size() > 0) {
            throw new JnSpringCloudException(MeterExceptionEnums.CANT_GET_TWO_RULE);
        }

        //保存数据
        saveCompanyPriceRule(user, ruleId, companyId);
        return result + 1;
    }

    /**
     * 企业更新/设置计价规则逻辑
     *
     * @param user
     * @param companyId
     * @param ruleId
     */
    public void saveCompanyPriceRule(User user, String ruleId, String companyId) {
        //保存一条计价规则和企业之间的关系数据
        TbElectricPriceRulesCriteria priceRules = new TbElectricPriceRulesCriteria();
        priceRules.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andIdEqualTo(ruleId);

        List<TbElectricPriceRules> rules = priceRulesMapper.selectByExample(priceRules);
        if (rules == null || rules.size()==0) {
            throw new JnSpringCloudException(MeterExceptionEnums.PRICE_RULE_ISNOT_EXIST);
        }

        Result<ServiceCompany> result1 = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if (result1.getData() == null) {
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NOT_FOUND);
        }
        TbElectricPriceruleCompany record = new TbElectricPriceruleCompany();
        record.setCreatedTime(new Date());
        record.setRuleId(ruleId);
        record.setRuleName(rules.get(0).getRuleName());
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        record.setCompanyId(companyId);
        record.setCompanyName(result1.getData().getComName());
        record.setCreatorAccount(user.getAccount());
        record.setRecordStatus(new Byte(MeterConstants.VALID));
        priceruleCompanyMapper.insertSelective(record);
    }


    @ServiceLog(doAction = "企业更新计价规则")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateCompanysRule(User user, String id, String ruleId, String companyId) {
        Integer result = 0;
        //通过id作废之前的数据，并获取出其关系进行重新关联
        TbElectricPriceruleCompany record = new TbElectricPriceruleCompany();
        record.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricPriceruleCompanyCriteria priceruleCompanyCriteria = new TbElectricPriceruleCompanyCriteria();
        priceruleCompanyCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID))
                .andIdEqualTo(id);
        List<TbElectricPriceruleCompany> records = priceruleCompanyMapper.selectByExample(priceruleCompanyCriteria);
        priceruleCompanyCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID))
                .andIdEqualTo(id);
        priceruleCompanyMapper.updateByExampleSelective(record, priceruleCompanyCriteria);

        if (records == null || records.size() == 0) {
            throw new JnSpringCloudException(MeterExceptionEnums.PRICE_RULE_ISNOT_EXIST);
        }
        //保存数据
        saveCompanyPriceRule(user, ruleId, companyId);


        //作废企业和计价规则之间的每日关系，并重新新建一条数据
        String dayStr = DateUtils.getDate("yyyy-MM-dd");
        Date day = null;
        try {
            day = DateUtils.parseDate(dayStr, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }

        TbElectricPriceruleCompanyInDay companyInDay = new TbElectricPriceruleCompanyInDay();
        companyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
        companyInDay.setModifierAccount(user.getAccount());
        companyInDay.setModifiedTime(new Date());
        TbElectricPriceruleCompanyInDayCriteria companyInDayCriteria = new TbElectricPriceruleCompanyInDayCriteria();
        companyInDayCriteria.or().andRuleIdEqualTo(ruleId).andRecordStatusEqualTo(new Byte(MeterConstants.VALID))
                .andDayEqualTo(day);
        companyInDayMapper.updateByExampleSelective(companyInDay, companyInDayCriteria);

        TbElectricPriceRules rules = priceRulesMapper.selectByPrimaryKey(ruleId);
        if (rules == null) {
            throw new JnSpringCloudException(MeterExceptionEnums.PRICE_RULE_ISNOT_EXIST);
        }
        companyInDay = new TbElectricPriceruleCompanyInDay();
        companyInDay.setRecordStatus(new Byte(MeterConstants.VALID));
        companyInDay.setCompanyId(companyId);
        companyInDay.setCreatorAccount(user.getAccount());
        companyInDay.setCreatedTime(new Date());
        companyInDay.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        companyInDay.setDay(day);
        companyInDay.setRuleId(ruleId);
        companyInDay.setRuleName(rules.getRuleName());
        companyInDayMapper.insertSelective(companyInDay);
        return result + 1;
    }

    @ServiceLog(doAction = "批量企业设置计价规则")
    @Override
    public List<String> setBatchRule(User user, List<String> companyIds, String ruleId) {
        //暂时不开发
        return null;
    }

    @Override
    @ServiceLog(doAction = "定时入库企业的每日计价规则")
    @Transactional(rollbackFor = Exception.class)
    public Integer setRulesInDayForCompany() {
        int result = 0;
        String dayStr = DateUtils.getDate("yyyy-MM-dd");
        Date day = null;
        try {
            day = DateUtils.parseDate(dayStr, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }
        //作废那些在每日定时器调度之前写入的每日规则；后面会根据最新的规则信息进行写入
        TbElectricPriceruleCompanyInDayCriteria companyInDayCriteria = new TbElectricPriceruleCompanyInDayCriteria();
        companyInDayCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andDayEqualTo(day);
        TbElectricPriceruleCompanyInDay companyInDay = new TbElectricPriceruleCompanyInDay();
        companyInDay.setRecordStatus(new Byte(MeterConstants.INVALID));
        companyInDay.setModifiedTime(new Date());
        companyInDay.setModifierAccount("systemTimer");
        companyInDayMapper.updateByExampleSelective(companyInDay, companyInDayCriteria);
        meterDao.saveCompanyLinkInDay(day);

        //没有计价规则的企业默认使用默认的计价规则
        meterDao.getUseDefualtPriceCompany(day);
        return result + 1;
    }

    @Override
    @ServiceLog(doAction = "电表拉闸和回复")
    @Transactional(rollbackFor = Exception.class)
    public Result SwitchMeter(String meterCode, String status) {
        ElectricMeterSwitchParam param = new ElectricMeterSwitchParam();
        param.setCode(meterCode);
        param.setFlag(status);
        Result result = electricMeterClient.electricMeterSwitch(param);
        //不等于空时，开关操作出现了异常，等于空时，成功了，修改本地的开关状态
        if (result.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
            TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
            meterInfo.setSwitchStatus(new Byte(status));
            TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
            meterInfoCriteria.or().andMeterCodeEqualTo(meterCode).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            Integer resultSize = tbElectricMeterInfoMapper.updateByExampleSelective(meterInfo, meterInfoCriteria);
            if (resultSize != 1) {
                result = new Result();
                result.setData(resultSize);
            }
        }
        return result;
    }

    @ServiceLog(doAction = "余额不总告警")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result warningBalanceShort(String companyId) {
        Result result = new Result();

        String phone="";
        Result<ServiceCompany> serviceCompany = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if (serviceCompany.getData() != null ) {
            phone = serviceCompany.getData().getConPhone();
            if (StringUtils.isBlank(phone)) {
                throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NO_CONTACT_TEL);
            }

        }

        PayAccountBookEntIdOrUserIdParam param = new PayAccountBookEntIdOrUserIdParam();
        param.setObjId(companyId);
        param.setObjType("1");
        Result<List<PayAccountBook>> bookResult =  payAccountClient.queryAccountBook(param);
        if(bookResult.getData() ==null || bookResult.getData().size()==0){
            logger.info("查询企业的余额失败，企业id为{}",companyId);
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_BALANCE_NOT_FOUND);
        }

        TbElectricWarningRulesCriteria warningRulesCriteria = new TbElectricWarningRulesCriteria();
        warningRulesCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricWarningRules> warningRules = warningRulesMapper.selectByExample(warningRulesCriteria);

        if(warningRules !=null && warningRules.size()>0){
            logger.info("开始发送短信");
            for(TbElectricWarningRules rules:warningRules){
                //写入预警的记录表中
                List<TbElectricWarningRecord> warningRecords = new ArrayList<>();
                for(PayAccountBook book:bookResult.getData()) {
                    if(rules.getThresholds().compareTo(book.getBalance())==1 || rules.getThresholds().compareTo(book.getBalance())==0){
                        logger.info("开始发送短信");
                        String msg = rules.getWarningContent().replace("{}",rules.getThresholds().toString());
                        TbElectricWarningRecord warningRecord = new TbElectricWarningRecord();
                        warningRecord.setCompanyId(companyId);
                        warningRecord.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                        warningRecord.setRuleId(rules.getId());
                        warningRecord.setThresholds(rules.getThresholds());
                        warningRecord.setWarningContent(msg);
                        warningRecord.setWarningName(rules.getWarningName());
                        warningRecord.setRecordStatus(new Byte(MeterConstants.VALID));
                        warningRecord.setCreatedTime(new Date());
                        warningRecord.setMeterCode(book.getMeterCode());
                        warningRecord.setCompanyName(serviceCompany.getData().getComName());
                        warningRecords.add(warningRecord);
                        msg = msg +",电表号为："+book.getMeterCode();
                        sendSMS(phone, msg);
                        if (warningRecords != null && warningRecords.size() > 0) {
                            meterDao.saveWarningRecord(warningRecords);
                            warningRecords = new ArrayList<>();
                            result.setData("预警成功");
                        }
                    }

                }
            }
        }
        return result;
    }

    private void sendSMS(String phone, String message) {
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("999");
        String[] m = {phone};
        smsTemplateVo.setMobiles(m);
        String[] t = {message};
        smsTemplateVo.setContents(t);
        logger.info("短信发送成功：接收号码：{},验证码：{}", phone, message);
        boolean sendStatus = messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
        if (sendStatus) {
            logger.info("[白下智慧园区]数据填报任务提醒短信送成功,{}", message);
        } else {
            logger.error("[白下智慧园区]数据填报任务提醒短信送失败,{}", message);
        }

    }


    @ServiceLog(doAction = "余额不总告警定时器")
    public void warningBalanceShortTimer() {
        //查询出所有 的业主
        List<String> meterHosts =  meterDao.getHosterFormMeter();
        if(meterHosts !=null && meterHosts.size()>0){
            for (String  companyId : meterHosts) {
                if(StringUtils.isNotBlank(companyId)){
                    warningBalanceShort(companyId);
                }

            }
        }




    }

    @ServiceLog(doAction = "余额不总告警定时器")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setSwitchMeterTimer() {
        //查询出所有 的业主
        List<String> meterHosts =  meterDao.getHosterFormMeter();
        if(meterHosts !=null && meterHosts.size()>0){
            for(String companyId : meterHosts){
                if(StringUtils.isNotBlank(companyId)){
                    PayAccountBookEntIdOrUserIdParam param = new PayAccountBookEntIdOrUserIdParam();
                    param.setObjId(companyId);
                    param.setObjType("1");
                    Result<List<PayAccountBook>> bookResult =  payAccountClient.queryAccountBook(param);
                    if(bookResult.getData() ==null || bookResult.getData().size()==0){
                        logger.info("查询企业的余额失败，企业id为{}",companyId);
                        throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_BALANCE_NOT_FOUND);
                    }
                    TbElectricTurnRulesCriteria turnRulesCriteria = new TbElectricTurnRulesCriteria();
                    turnRulesCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
                    List<TbElectricTurnRules>  turnRulesList = tbElectricTurnRulesMapper.selectByExample(turnRulesCriteria);
                   if(turnRulesList !=null && turnRulesList.size()>0){
                       for(TbElectricTurnRules rules:turnRulesList){
                           for(PayAccountBook book:bookResult.getData()){

                              SwitchModel switchModel = new SwitchModel();
                               switchModel.setCompanyId(companyId);
                               Result<ServiceCompany> result1 = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
                               if (result1.getData() == null) {
                                   throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NOT_FOUND);
                               }
                               switchModel.setCompanyName(result1.getData().getComName());
                               switchModel.setId(rules.getId());
                               switchModel.setMeterCode(book.getMeterCode());
                               switchModel.setTurnName(rules.getTurnName());
                               TbElectricMeterInfoCriteria meterInfo = new TbElectricMeterInfoCriteria();
                               meterInfo.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID))
                                       .andMeterCodeEqualTo(book.getMeterCode());
                               List<TbElectricMeterInfo> meterInfos = tbElectricMeterInfoMapper.selectByExample(meterInfo);
                               if(meterInfos ==null || meterInfos.size()==0){
                                   throw new JnSpringCloudException(MeterExceptionEnums.METER_INFO_EXIST);
                               }
                               switchModel.setFactoryCode(meterInfos.get(0).getFactoryMeterCode());
                               if(rules.getThresholds().compareTo(book.getBalance())==1 || rules.getThresholds().compareTo(book.getBalance())==0){
                                   List<SwitchModel> turn = new ArrayList<>();
                                   turn.add(switchModel);
                                   concretSwitch(turn,MeterConstants.SWITCH_NOT_ELEC);
                               }else{
                                   List<SwitchModel> turn = new ArrayList<>();
                                   turn.add(switchModel);
                                   concretSwitch(turn,MeterConstants.SWITCH_GET_ELEC);
                               }
                           }

                       }
                   }

                }
            }
        }

    }

    private void concretSwitch(List<SwitchModel> meterCodes,String status){
        if(meterCodes!=null && meterCodes.size()>0){
            List<TbElectricMeterSwitchLog>  list = new ArrayList<>();
            for(SwitchModel model : meterCodes){
                try{
                    Result<ElectricMeterStatusShow> state = electricMeterClient.getElectricMeterStatus(model.getFactoryCode());
                    if (state.getData() != null) {
                        ElectricMeterStatusShow show = state.getData();
                        if (status.equals(show.getStatus())) {
                            continue;
                        }
                        SwitchMeter(model.getFactoryCode(), status);
                        //记录日志
                        TbElectricMeterSwitchLog switchLog = new TbElectricMeterSwitchLog();
                        switchLog.setCompanyId(model.getCompanyId());
                        switchLog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                        switchLog.setTurnId(model.getId());
                        switchLog.setTurnName(model.getTurnName());
                        switchLog.setCreatedTime(new Date());
                        switchLog.setCreatorAccount(MeterConstants.SYSTEM_USER);
                        switchLog.setMeterCode(model.getMeterCode());
                        switchLog.setSwitchStatus(new Byte(status));
                        switchLog.setRecordStatus(new Byte(MeterConstants.VALID));
                        switchLog.setCompanyName(model.getCompanyName());
                        list.add(switchLog);
                        if (list != null && list.size() > 0) {
                            meterDao.saveMeterSwitchLog(list);
                            list = new ArrayList<>();
                        }

                        //更新信息表中的状态
                        TbElectricMeterInfoCriteria criteria = new TbElectricMeterInfoCriteria();
                        criteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andFactoryMeterCodeEqualTo(model.getMeterCode());
                        TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
                        meterInfo.setUseStatus(new Byte(status));
                        tbElectricMeterInfoMapper.updateByExampleSelective(meterInfo,criteria);
                    }else{
                        throw new RuntimeException();
                    }

                }catch(Exception e){
                    e.printStackTrace();
                    logger.info("电表编码为{}，的状态{}转换失败！！！", model.getMeterCode(), status);
                    continue;
                }

            }
        }
    }


}
