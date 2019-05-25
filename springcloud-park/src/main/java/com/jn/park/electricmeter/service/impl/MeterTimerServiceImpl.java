package com.jn.park.electricmeter.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.park.electricmeter.dao.*;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.enums.MeterExceptionEnums;
import com.jn.park.electricmeter.service.MeterTimerService;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayBillDetails;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiModelProperty;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.DateUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/5/23 10:57
 * @version： v1.0
 * @modified By:
 */

@Service
public class MeterTimerServiceImpl implements MeterTimerService {
    private static final Logger logger = LoggerFactory.getLogger(MeterTimerServiceImpl.class);
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private TbElectricRulesContentMapper rulesContentMapper;
    @Autowired(required = false)
    private CompanyClient companyClient;
    @Autowired(required = false)
    private TbElectricMeterDayLogMapper meterDayLogMapper;

    @Autowired(required = false)
    private TbElectricEnergyDayLogMapper energyDayLogMapper;
    @Autowired(required = false)
    private TbElectricErrorLogMapper errorLogMapper;

    @Autowired(required = false)
    private PayClient payClient;




    @Override
    @Transactional(rollbackFor = Exception.class)
    public void calcCostEverdayBySomeOneCompany(String companyId,Date dealDate,String account ) throws Exception{
        logger.info("通过企业id获取企业的基本信息");
        Result<ServiceCompany> companyInfo =companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if(companyInfo.getData() == null){
            logger.info("通过企业id没有找到企业基本信息,入参{}",companyId);
            //TbElectricErrorLog errorLog = saveErrorLog( account,"企业基本信息找不到", null, companyId, dealDate, null);
            String msg =account+",企业基本信息找不到,null,"+companyId+","+ DateUtils.formatDate(dealDate,"yyyy-MM-dd")+"null";
            throw new RuntimeException(msg);
        }
        String companyName =companyInfo.getData().getComName();
        logger.info("结束企业id获取企业的基本信息");

        logger.info("开始通过企业id获取电表设备code集合");
        List<String> eleMeters = meterDao.getElectricMeterByCompanyId(companyId,dealDate);
        logger.info("结束通过企业id获取电表设备code集合");

        if(eleMeters !=null && eleMeters.size()>0){
            //查询出企业的计价规则
            List<String> rules = meterDao.getRuleIdByCompanyId(companyId,dealDate);
            if(rules ==null || rules.size()==0){
                //企业没有计价规则
                logger.info("开始记录错误日志-原因：企业没有维护计价规则");
                String msg =account+",企业没有维护计价规则,null,"+companyId+","+ DateUtils.formatDate(dealDate,"yyyy-MM-dd")+","+companyName;
                throw new RuntimeException(msg);
            }
            if(rules.size() !=1){
                logger.info("开始记录错误日志-原因：企业存在多个计价规则");
                //TbElectricErrorLog errorLog = saveErrorLog( account,"企业存在多个计价规则", null, companyId, dealDate, companyName);
                String msg =account+",企业存在多个计价规则,null,"+companyId+","+ DateUtils.formatDate(dealDate,"yyyy-MM-dd")+","+companyName;
                throw new RuntimeException(msg);
            }

            TbElectricRulesContentCriteria rulesContentCriteria = new TbElectricRulesContentCriteria();
            rulesContentCriteria.or().andRuleIdEqualTo(rules.get(0));
            logger.info("开始通过计价规则id查询企业计价内容");
            List<TbElectricRulesContent> rulesContents = rulesContentMapper.selectByExample(rulesContentCriteria);
            logger.info("结束通过计价规则id查询企业计价内容");
            if(rulesContents ==null || rulesContents.size() ==0){
                logger.info("开始记录错误日志-原因：没有找到计价规则的内容");
                String msg =account+",没有找到计价规则的内容,null,"+companyId+","+ DateUtils.formatDate(dealDate,"yyyy-MM-dd")+","+companyName;
                throw new RuntimeException(msg);
            }

            logger.info("开始处理企业每块电表的用电量及费用");
            List<TbElectricMeterDayLog> meterDayLogs = new ArrayList<>();
            List<TbElectricEnergyGroupLog> groupLogs = new ArrayList<>();
            //数据是否缺失;默认数据都是完整的的。一个公司的所有电表信息都有24条的历史数据时，才是数据完整的状态
            for(String meterCode : eleMeters){
                //查询出每块电表的用电量
                logger.info("开始查询一个企业的一块电表一天的读数历史数据,电表编码:{}",meterCode);
                List<TbElectricReading> readings = meterDao.getDegreeByMeterCode(meterCode,dealDate);
                logger.info("结束查询一个企业的一块电表一天的读数历史数据");
                TbElectricMeterDayLog meterDayLog =null;
                if(readings.size() ==24){
                    logger.info("开始计算一个企业的一块电表一天的电量和电费,企业id:{},电表编码:{}",companyId,meterCode);
                    meterDayLog =calcost(groupLogs,companyName,account,dealDate,companyId, rulesContents,readings );
                    logger.info("结束计算一个企业的一块电表一天的电量和电费");
                    meterDayLogs.add(meterDayLog);
                }else{
                    logger.info("开始记录错误日志-原因：当前企业的电表的读数数据不完整,{}",companyId);
                    String msg =account+",当前企业的电表的读数数据不完整,"+meterCode+","+companyId+","+ DateUtils.formatDate(dealDate,"yyyy-MM-dd")+","+companyName;
                    throw new RuntimeException(msg);
                }
            }

            //保存
            if(groupLogs !=null && groupLogs.size()>0){
                logger.info("开始保存一个企业的电费的分段费用记录");
                meterDao.saveGroupLogs(groupLogs);
                logger.info("结束保存一个企业的电费的分段费用记录");
            }
            logger.info("结束处理企业每块电表的用电量及费用");

            //电表的个数和每日电表的对象数是一样的，才是一个企业完整的一天的用电量
            if(meterDayLogs!=null && meterDayLogs.size()==eleMeters.size()){
                BigDecimal allPrice =new BigDecimal("0");
                BigDecimal allDegree = new BigDecimal("0");
                List<PayBillDetails> payBillDetails = new ArrayList<>();
                PayBillDetails billDetails=null;
                int sort=0;
                for(TbElectricMeterDayLog  meterDayLog : meterDayLogs ){
                    allPrice.add(meterDayLog.getPrice());
                    allDegree.add(meterDayLog.getDegree());
                    String name = "[电表编号]:"+meterDayLog.getMeterId();
                    billDetails.setCostName(name);
                    billDetails.setCostValue(meterDayLog.getPrice().toString());
                    sort++;
                    billDetails.setSort(sort);
                    payBillDetails.add(billDetails);
                }
                // 创建账单和保存
                boolean success = createBill(allPrice,companyId,companyName,account,  payBillDetails);
                if(! success){
                    String msg =account+",创建账单失败,"+"null,"+companyId+","+ DateUtils.formatDate(dealDate,"yyyy-MM-dd")+","+companyName;
                    throw new RuntimeException(msg);
                }
                TbElectricEnergyDayLog energyDayLog = new TbElectricEnergyDayLog();
                energyDayLog.setCompanyId(companyId);
                energyDayLog.setCompanyName(companyName);
                energyDayLog.setCreatedTime(new Date());
                energyDayLog.setPrice(allPrice);
                energyDayLog.setCreatorAccount(account);
                energyDayLog.setDegree(allDegree);
                energyDayLog.setDay(dealDate);
                energyDayLog.setRecordStatus(new Byte(MeterConstants.VALID));
                energyDayLog.setRuleName(rulesContents.get(0).getRuleName());
                energyDayLog.setRuleId(rulesContents.get(0).getRuleId());
                energyDayLog.setId(UUID.randomUUID().toString().replaceAll("-",""));
                logger.info("开始保存一个企业一天的电费和电量");
                energyDayLogMapper.insertSelective(energyDayLog);
                logger.info("结束保存一个企业一天的电费和电量");
            }
        }
    }

    @Override
    @ServiceLog(doAction = "计算企业每日的电费")
    public void calcCostEverday() {
        logger.info("开始计算所有企业每日的电费");
        logger.info("所有电表的业主查询处");
        List<String> hosters  =meterDao.getMeterHost("", null);
        if(hosters ==null && hosters.size()==0){
            logger.info("电表不存在一个业主");
            return;
        }
        Date dealDate =getLastDay();
        String account =MeterConstants.SYSTEM_USER;
        for(String companyId : hosters){
            try{
                calcCostEverdayBySomeOneCompany(companyId,dealDate,account);
            }catch(Exception e){

                String err = e.getMessage();
                //记录日志
                splitString(err);
                continue;
            }

        }
    }

    public Result calcCostEverdayByHandler(User user, String companyId, Date day ) {
        //所有电表的业主查询处
        Result result = new Result();
        List<String> hosters=new ArrayList<>();
        if(StringUtils.isNotBlank(companyId) && day != null){
            hosters =meterDao.getElectricMeterByCompanyId(companyId, day);
        }
        //检查企业是否被定时器调用时产生了错误
        TbElectricErrorLogCriteria criteria = new TbElectricErrorLogCriteria();
        criteria.or().andCompanyIdEqualTo(companyId).andDayEqualTo(day).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricErrorLog>  logs = errorLogMapper.selectByExample(criteria);
        if(logs==null || logs.size()==0){
            throw new JnSpringCloudException(MeterExceptionEnums.CANT_REPEAT_DEAL);
        }

        if(hosters==null || hosters.size()==0){
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NO_METER);
        }

        try{
            calcCostEverdayBySomeOneCompany(companyId,day,user.getAccount());
            TbElectricErrorLog record = new TbElectricErrorLog();
            record.setRecordStatus(new Byte(MeterConstants.INVALID));
            record.setCompanyId(companyId);
            errorLogMapper.updateByExampleSelective(record,criteria);
        }catch(Exception e){
            result.setData(e.getMessage());
        }
        return result;
    }

    /**
     *
     * @param allPrice
     * @param companyId
     * @param companyName
     * @param account
     * @param payBillDetails
     */
    private boolean createBill(BigDecimal allPrice,String companyId,String companyName,String account, List<PayBillDetails> payBillDetails){
        boolean success = true;
        logger.info("开始调用接口创建账单");
        PayBillCreateParamVo payBillCreateParamVo = new PayBillCreateParamVo();
        payBillCreateParamVo.setBillId(UUID.randomUUID().toString().replaceAll("-",""));
        //账单名称
        payBillCreateParamVo.setBillName("电费账单");
        //账单来源
        payBillCreateParamVo.setBillSource("企业");
        //账单费用
        payBillCreateParamVo.setBillExpense(allPrice);
        //对象类型【1：企业，2：个人】
        payBillCreateParamVo.setObjType("1");
        //对象Id（传企业ID或用户ID）
        payBillCreateParamVo.setObjId(companyId);
        //对象名称（传企业名称或用户名称）
        payBillCreateParamVo.setObjName(companyName);
        //账本类型ID【1：电费，2：物业费】
        payBillCreateParamVo.setAcBookType(MeterConstants.ELEC_BOOK);
        //回调ID
        payBillCreateParamVo.setCallbackId(null);
        //回调URL
        payBillCreateParamVo.setCallbackUrl(null);
        //创建时间
        payBillCreateParamVo.setCreatedTime(new Date());
        //创建人
        payBillCreateParamVo.setCreatorAccount(account);
        //最迟缴费时间
        payBillCreateParamVo.setLatePayment(new Date());
        //缴费详情【存list对象集合】
        payBillCreateParamVo.setPayBillDetails(payBillDetails);
        Result billCreateResult = payClient.billCreate(payBillCreateParamVo);
        logger.info("结束调用接口创建账单");
        //保存账单信息
        if(billCreateResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            logger.info("开始保存成功创建的账单");
            //todo
            logger.info("结束保存成功创建的账单");
        }else{
            logger.info("调用创建账单接口失败");
            success =false;
        }
        return success;
    }


    /**
     * 计算电费
     * @param rulesContents 计价规则
     * @param readings 一块电表一天的读数
     */
    private TbElectricMeterDayLog calcost(List<TbElectricEnergyGroupLog> groupLogs,String companyName,String account,Date dealDate,String companyId,List<TbElectricRulesContent> rulesContents,List<TbElectricReading> readings ){
        TbElectricEnergyGroupLog groupLog = null;
        String meterCode =readings.get(0).getMeterCode();
        String ruleId =rulesContents.get(0).getRuleId();
        String ruleName =rulesContents.get(0).getRuleName();
        //总电量
        BigDecimal allDegree = new BigDecimal("0");
        //总价钱
        BigDecimal allPrice = new BigDecimal("0");
        for(TbElectricRulesContent rules : rulesContents){
            BigDecimal startDegree =null;
            BigDecimal endDegree =null;
            BigDecimal result =null;
            ;
            for(TbElectricReading reading :readings){
                if(Integer.parseInt(reading.getDealHour().toString())==rules.getStart()){
                    startDegree = reading.getReadingEnd();
                }
                if(Integer.parseInt(reading.getDealHour().toString())==rules.getEnd()){
                    endDegree = reading.getReadingEnd();
                }
            }
            result =endDegree.subtract(startDegree);
            BigDecimal price =new BigDecimal(rules.getPrice());
            BigDecimal cost = price.multiply(result);

            //保存日志，每块电表按照计价规则来进行保存
            groupLog = new TbElectricEnergyGroupLog();
            groupLog.setCompanyId(companyId);
            groupLog.setCompanyName(companyName);
            groupLog.setCreatedTime(new Date());
            groupLog.setDegree(result);
            groupLog.setMeterId(meterCode);
            groupLog.setRuleId(ruleId);
            groupLog.setCreatorAccount(account);
            groupLog.setDay(dealDate);
            groupLog.setPrice(cost);
            groupLog.setRuleName(ruleName);
            groupLog.setId(UUID.randomUUID().toString().replaceAll("-",""));
            groupLog.setRecordStatus(new Byte(MeterConstants.VALID));
            groupLogs.add(groupLog);
            allPrice.add(cost);
            allDegree.add(result);
        }

        //保存这块电表一天的用电量和钱
        TbElectricMeterDayLog meterDayLog = new TbElectricMeterDayLog();
        meterDayLog.setCompanyId(companyId);
        meterDayLog.setCompanyName(companyName);
        meterDayLog.setDay(dealDate);
        meterDayLog.setCreatedTime(new Date());
        meterDayLog.setDegree(allDegree);
        meterDayLog.setPrice(allPrice);
        meterDayLog.setMeterId(meterCode);
        meterDayLog.setId(UUID.randomUUID().toString().replaceAll("-",""));
        meterDayLog.setRecordStatus(new Byte(MeterConstants.VALID));
        meterDayLog.setRuleName(ruleName);
        meterDayLog.setId(ruleId);
        meterDayLog.setCreatorAccount(account);
        meterDayLogMapper.insertSelective(meterDayLog);
        //返回这块电表的钱，和用电量
        return meterDayLog;

    }

    /**
     * 获取昨天的日期
     * @return
     */
    private Date getLastDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        Date lastDay = c.getTime();
        return lastDay;
    }

    private void  splitString(String errMsg){
        String[] errAry = errMsg.split(",");
        String account=null;
        if(StringUtils.isNotBlank(errAry[0])){
            account=errAry[0];
        }

        String msg=null;
        if(StringUtils.isNotBlank(errAry[1])){
            msg=errAry[1];
        }

        String meterCode=null;
        if(StringUtils.isNotBlank(errAry[2])){
            msg=errAry[2];
        }

        String companyId=null;
        if(StringUtils.isNotBlank(errAry[3])){
            companyId=errAry[3];
        }

        Date dealDate=null;
        if(StringUtils.isNotBlank(errAry[4])){
            try{
                dealDate=DateUtils.parseDate(errAry[4],"yyyy-MM-dd");
            }catch (Exception e){
                logger.info("日期处理异常");
                e.printStackTrace();
                dealDate=null;
            }
        }
        String companyName=null;
        if(StringUtils.isNotBlank(errAry[5])){
            companyName=errAry[5];
        }

        saveErrorLog( account, msg, meterCode, companyId, dealDate, companyName);
    }

    private TbElectricErrorLog saveErrorLog(String account,String msg,String meterCode,String companyId,Date dealDate,String companyName){
        TbElectricErrorLog errorLog = new TbElectricErrorLog();
        if(StringUtils.isNotBlank(msg)){
            errorLog.setErrorMsg(msg);
        }
        if(StringUtils.isNotBlank(meterCode)){
            errorLog.setMeterCode(meterCode);
        }

        if(StringUtils.isNotBlank(companyId)){
            errorLog.setCompanyId(companyId);
        }

        if(StringUtils.isNotBlank(companyName)){
            errorLog.setCompanyName(companyName);
        }
        if(dealDate==null){
            errorLog.setDay(dealDate);
        }
        errorLog.setCreatedTime(new Date());
        errorLog.setCreatorAccount(account);
        errorLog.setId(UUID.randomUUID().toString().replaceAll("-",""));
        errorLog.setRecordStatus(new Byte(MeterConstants.VALID));
        logger.info("记录企业计算电费和电量错误的日志,{}",errorLog.toString());
        errorLogMapper.insertSelective(errorLog);
        logger.info("记录企业计算电费和电量错误的日志");
        return errorLog;
    }

}
