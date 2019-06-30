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
import com.jn.news.vo.SmsTemplateVo;
import com.jn.park.electricmeter.dao.*;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.enums.MeterExceptionEnums;
import com.jn.park.electricmeter.exception.ErrorLogException;
import com.jn.park.electricmeter.service.MeterCalcCostService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.pay.api.PayAccountClient;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/5/23 10:57
 * @version： v1.0
 * @modified By:
 */

@Service
@EnableBinding(value = MessageSource.class)
public class MeterCalcCostServiceImpl implements MeterCalcCostService {
    @Autowired(required = false)
    private MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(MeterCalcCostServiceImpl.class);
    @Autowired(required = false)
    private MeterDao meterDao;
    @Autowired(required = false)
    private TbElectricRulesContentMapper rulesContentMapper;
    @Autowired(required = false)
    private CompanyClient companyClient;
    @Autowired(required = false)
    private TbElectricMeterDayLogMapper meterDayLogMapper;

    @Autowired(required = false)
    private TbElectricMeterCompanyDayMapper tbElectricMeterCompanyDayMapper;


    @Autowired(required = false)
    private TbElectricEnergyDayLogMapper energyDayLogMapper;
    @Autowired(required = false)
    private TbElectricErrorLogMapper errorLogMapper;

    @Autowired(required = false)
    private TbElectricCostMapper tbElectricCostMapper;

    @Autowired(required = false)
    private PayAccountClient payAccountClient;

    @Autowired(required = false)
    private TbElectricEnergyBillMapper energyBillMapper;
    @Autowired(required = false)
    private TbElectricEnergyBillDetailMapper energyBillDetailMapper;

    @Autowired(required = false)
    private PayClient payClient;

    @Autowired(required = false)
    private TbElectricMeterInfoMapper tbElectricMeterInfoMapper;
    @Autowired(required = false)
    private TbElectricEnergyGroupLogMapper tbElectricEnergyGroupLogMapper;

    @Autowired(required = false)
    private TbElectricPriceruleCompanyMapper tbElectricPriceruleCompanyMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void calcCostEverdayBySomeOneCompany(String companyId,Date dealDate,String account,String userMeterCode) throws ErrorLogException{
        logger.info("通过企业id获取企业的基本信息");
        Result<ServiceCompany> companyInfo =companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if(companyInfo.getData() == null){
            logger.info("通过企业id没有找到企业基本信息,入参{}",companyId);
            throw new ErrorLogException(getErr(account, "企业基本信息找不到", null, companyId, "未知的企业名称",dealDate));
        }
        String companyName =companyInfo.getData().getComName();
        logger.info("结束企业id获取企业的基本信息");

        List<String> eleMeters = null;

        if(StringUtils.isNotBlank(userMeterCode)){
            eleMeters = new ArrayList<>();
            eleMeters.add(userMeterCode);
        }else{
            logger.info("开始通过企业id获取电表设备code集合");
            eleMeters = meterDao.getElectricMeterByCompanyId(companyId,dealDate);
            logger.info("结束通过企业id获取电表设备code集合");
        }


        if(eleMeters !=null && eleMeters.size()>0){
            //查询出企业的计价规则
            List<String> rules = meterDao.getRuleIdByCompanyId(companyId,dealDate);
            if(rules ==null || rules.size()==0){
                //企业没有计价规则
                logger.info("开始记录错误日志-原因：企业没有维护计价规则");
                throw new ErrorLogException(getErr(account, "企业没有维护计价规则", null, companyId, companyName,dealDate));
            }
            if(rules.size() !=1){
                logger.info("开始记录错误日志-原因：企业存在多个计价规则");
                throw new ErrorLogException(getErr(account, "企业存在多个计价规则", null, companyId, companyName,dealDate));
            }

            TbElectricRulesContentCriteria rulesContentCriteria = new TbElectricRulesContentCriteria();
            rulesContentCriteria.or().andRuleIdEqualTo(rules.get(0));
            logger.info("开始通过计价规则id查询企业计价内容");
            List<TbElectricRulesContent> rulesContents = rulesContentMapper.selectByExample(rulesContentCriteria);
            logger.info("结束通过计价规则id查询企业计价内容");
            if(rulesContents ==null || rulesContents.size() ==0){
                logger.info("开始记录错误日志-原因：没有找到计价规则的内容");
                throw new ErrorLogException(getErr(account, "没有找到计价规则的内容", null, companyId, companyName,dealDate));
            }

            logger.info("开始处理企业每块电表的用电量及费用");
            List<TbElectricMeterDayLog> meterDayLogs = new ArrayList<>();
            List<TbElectricEnergyGroupLog> groupLogs = new ArrayList<>();
            //数据是否缺失;默认数据都是完整的的。一个公司的所有电表信息都有24条的历史数据时，才是数据完整的状态
            for(String meterCode : eleMeters){
                groupLogs = new ArrayList<>();
                meterDayLogs = new ArrayList<>();
                try{
                    //查询出每块电表的用电量
                    logger.info("开始查询一个企业的一块电表一天的读数历史数据,电表编码:{}",meterCode);
                    List<TbElectricReading> readings = meterDao.getDegreeByMeterCode(meterCode,dealDate);
                    logger.info("结束查询一个企业的一块电表一天的读数历史数据");
                    TbElectricMeterDayLog meterDayLog =null;
                    //再次验证是否已经拥有24tiao数据
                    if(readings.size() !=24){
                        //查询电表
                        logger.info("这块表，{}，没有24条数据；开始进行重新采集数据",meterCode);
                        TbElectricMeterInfoCriteria criteria = new TbElectricMeterInfoCriteria();
                        criteria.or().andMeterCodeEqualTo(meterCode).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
                        List<TbElectricMeterInfo>  meters = tbElectricMeterInfoMapper.selectByExample(criteria);
                        if(meters !=null && meters.size()>0){
                            logger.info("这块表，{}，没有24条数据；开始进行重新采集数据;他的原始编码为：",meterCode,meters.get(0).getFactoryMeterCode());
                            //没有24条数据；进行重新采集
                            if(readings !=null){
                                for(int i=0;i<24;i++){
                                    //默认没有采集到
                                    boolean isNotExist = true;
                                    for(TbElectricReading reBean : readings){
                                        if(reBean.getDealHour().equals(String.valueOf(i))){
                                            isNotExist = false;
                                            break;
                                        }
                                    }
                                    //不存在，进行数据重新采集
                                    if(isNotExist){
                                        MeterService meterService = BeanHeader.getBean(MeterService.class);
                                        meterService.dealAllFailByDealHourAndDealDateAndMeterCode(dealDate,String.valueOf(i),meters.get(0).getFactoryMeterCode());
                                    }
                                }
                            }
                        }else{
                            //记录日志，此表的
                            throw new ErrorLogException(getErr(account, "重新采集数据时，发现"+meterCode+"表信息不存在", meterCode, companyId, companyName,dealDate));
                        }

                        readings = meterDao.getDegreeByMeterCode(meterCode,dealDate);
                    }


                    if(readings.size() ==24){
                        logger.info("开始计算一个企业的一块电表一天的电量和电费,企业id:{},电表编码:{}",companyId,meterCode);
                        meterDayLog =calcost(groupLogs,companyName,account,dealDate,companyId, rulesContents,readings );
                        logger.info("结束计算一个企业的一块电表一天的电量和电费");
                        meterDayLogs.add(meterDayLog);
                    }else{
                        logger.info("开始记录错误日志-原因：当前企业的电表的读数数据不完整,{}",companyId);
                        throw new ErrorLogException(getErr(account, "当前企业的电表的读数数据不完整", meterCode, companyId, companyName,dealDate));
                    }

                    logger.info("结束处理企业每块电表的用电量及费用");
                    BigDecimal allPrice =new BigDecimal("0");
                    BigDecimal allDegree = new BigDecimal("0");
                    List<PayBillDetails> payBillDetails = new ArrayList<>();
                    PayBillDetails billDetails=null;
                    int sort=0;
                    String ten ="10";
                    BigDecimal tenDivisor = new BigDecimal(ten);
                    for(TbElectricMeterDayLog  meterDayLogBean : meterDayLogs ){
                        billDetails = new PayBillDetails();
                        allPrice = allPrice.add(meterDayLogBean.getPrice());
                        allDegree = allDegree.add(meterDayLogBean.getDegree());
                        String name = "[电表编号]:"+meterDayLogBean.getMeterId();
                        billDetails.setCostName(name);
                        billDetails.setCostValue(meterDayLogBean.getPrice().divide(tenDivisor,2, RoundingMode.HALF_UP).toString());
                        sort++;
                        billDetails.setSort(sort);
                        payBillDetails.add(billDetails);
                        meterDayLogBean.setPrice(meterDayLogBean.getPrice().divide(tenDivisor,2, RoundingMode.HALF_UP));
                    }
                    // 创建账单和保存
                    //计价规则那边是角，此处要除10，才得出元
                    allPrice = allPrice.divide(tenDivisor,2, RoundingMode.HALF_UP);
                    boolean success = createBill(allPrice,companyId,companyName,account,  payBillDetails,meterCode,dealDate);
                    if(! success){
                        throw new ErrorLogException(getErr(account, "创建账单失败", meterCode, companyId, companyName,dealDate));
                    }

                    //保存通过企业id没有找到企业基本信息
                    if(groupLogs !=null && groupLogs.size()>0){
                        logger.info("开始保存一个企业的电费的分段费用记录");
                        meterDao.saveGroupLogs(groupLogs);
                        logger.info("结束保存一个企业的电费的分段费用记录");
                    }
                    TbElectricErrorLogCriteria criteria = new TbElectricErrorLogCriteria();
                    criteria.or().andCompanyIdEqualTo(companyId).andDayEqualTo(dealDate).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeEqualTo(meterCode);
                    TbElectricErrorLog record = new TbElectricErrorLog();
                    record.setRecordStatus(new Byte(MeterConstants.INVALID));
                    record.setCompanyId(companyId);
                    //作废失败的记录日志
                    errorLogMapper.updateByExampleSelective(record,criteria);
                    criteria.or().andCompanyIdEqualTo(companyId).andDayEqualTo(dealDate).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeIsNull();
                    errorLogMapper.updateByExampleSelective(record,criteria);
                }catch (ErrorLogException e){
                    //记录日志
                    if(StringUtils.isNotBlank(userMeterCode)){
                        TbElectricErrorLog record = e.getErr();
                        record.setModifiedTime(new Date());
                        TbElectricErrorLogCriteria criteria = new TbElectricErrorLogCriteria();
                        criteria.or().andCompanyIdEqualTo(companyId).andDayEqualTo(dealDate).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeEqualTo(meterCode);
                        errorLogMapper.updateByExampleSelective(record,criteria);
                    }else{
                        saveErrorLog(e.getErr());
                    }

                    continue;
                }
            }
            //查询账单的条数和电表的个数，在当日是否一致，一致时才是完整的计算出了一个企业当天的价钱
            //查询出所有的电表
            TbElectricMeterCompanyDayCriteria companyDayCriteria = new TbElectricMeterCompanyDayCriteria();
            companyDayCriteria.or().andDayEqualTo(dealDate).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andCompanyIdEqualTo(companyId);
            List<TbElectricMeterCompanyDay>  companyDays = tbElectricMeterCompanyDayMapper.selectByExample(companyDayCriteria);

            //查询出所有的账单
            TbElectricEnergyBillCriteria dayLogCriteria = new TbElectricEnergyBillCriteria();
            dayLogCriteria.or().andObjIdEqualTo(companyId).andDayEqualTo(dealDate).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            List<TbElectricEnergyBill> dayLogs = energyBillMapper.selectByExample(dayLogCriteria);

            if(companyDays !=null && dayLogs!=null){
                if(companyDays.size()==dayLogs.size()){

                    BigDecimal allPrice = new BigDecimal("0");
                    BigDecimal allDegree = new  BigDecimal("0");
                    if(dayLogs.size()>0){
                        for(TbElectricEnergyBill dayLog : dayLogs){
                            TbElectricEnergyGroupLogCriteria billDetailCriteria = new TbElectricEnergyGroupLogCriteria();
                            billDetailCriteria.or().andDayEqualTo(dealDate).andRecordStatusEqualTo(new Byte(MeterConstants.VALID))
                            .andMeterIdEqualTo(dayLog.getMeterCode()).andCompanyIdEqualTo(companyId);
                                    ;
                            List<TbElectricEnergyGroupLog> groupLogsDetail = tbElectricEnergyGroupLogMapper.selectByExample(billDetailCriteria);
                            if(groupLogsDetail !=null && groupLogsDetail.size()>0){
                                BigDecimal degree = groupLogsDetail.get(0).getDegree();
                                BigDecimal price = groupLogsDetail.get(0).getPrice();
                                allPrice = allPrice.add(price);
                                allDegree = allDegree.add(degree);
                            }

                        }
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
                    logger.info("开始保存一个企业一块表的电费和电量");
                    energyDayLogMapper.insertSelective(energyDayLog);
                    logger.info("结束保存一个企业一块表的电费和电量");
                }
            }
        }
    }

    private TbElectricErrorLog getErr(String account,String msg,String meterCode,String companyId,String companyName,Date dealDate){
        TbElectricErrorLog err = new TbElectricErrorLog();
        if(StringUtils.isNotBlank(msg)){
            err.setErrorMsg(msg);
        }
        if(StringUtils.isNotBlank(meterCode)){
            err.setMeterCode(meterCode);
        }

        if(StringUtils.isNotBlank(companyId)){
            err.setCompanyId(companyId);
        }

        if(StringUtils.isNotBlank(companyName)){
            err.setCompanyName(companyName);
        }
        if(dealDate!=null){
            err.setDay(dealDate);
        }
        err.setCreatedTime(new Date());
        err.setCreatorAccount(account);
        err.setId(UUID.randomUUID().toString().replaceAll("-",""));
        err.setRecordStatus(new Byte(MeterConstants.VALID));
        return err;
    }

    @Override
    @ServiceLog(doAction = "定时计算企业每日的电费")
    public void calcCostEverday() {
        logger.info("开始计算所有企业每日的电费");
        logger.info("所有电表的业主查询处");
        List<String> hosters  =meterDao.getMeterHost(null, null);
        if(hosters ==null || hosters.size()==0){
            logger.info("电表不存在一个业主");
            return;
        }
        Date dealDate =getLastDay();
        String account =MeterConstants.SYSTEM_USER;
        for(String companyId : hosters){
            try{
                calcCostEverdayBySomeOneCompany(companyId,dealDate,account,null);
            }catch(ErrorLogException e){
                //记录日志
                saveErrorLog(e.getErr());
                continue;
            }catch (Exception ex){
                logger.info("企业计算结果发生异常,{}",companyId);
                ex.printStackTrace();
                continue;
            }

        }
    }

    @Override
    @ServiceLog(doAction = "手动计算企业每日的电费")
    public Result calcCostEverdayByHandler(User user, String companyId, Date day ,String meterCode) {
        //所有电表的业主查询处
        Result result = new Result();
        result.setData("0000");
        String date = DateUtils.formatDate(day,"yyyy-MM-dd");
        try{
            day = DateUtils.parseDate(date,"yyyy-MM-dd");
        }catch (Exception e){
            logger.info("日期转换错误");
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }

        List<String> hosters=new ArrayList<>();
        if(StringUtils.isNotBlank(companyId) && day != null){
            hosters =meterDao.getElectricMeterByCompanyId(companyId, day);
        }
        //检查企业是否被定时器调用时产生了错误
        TbElectricErrorLogCriteria criteria = new TbElectricErrorLogCriteria();
        if(StringUtils.isNotBlank(meterCode)){
            criteria.or().andCompanyIdEqualTo(companyId).andDayEqualTo(day).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeEqualTo(meterCode);
        }else{
            criteria.or().andCompanyIdEqualTo(companyId).andDayEqualTo(day).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeIsNull();
        }
        List<TbElectricErrorLog>  logs = errorLogMapper.selectByExample(criteria);
        if(logs==null || logs.size()==0){
            throw new JnSpringCloudException(MeterExceptionEnums.CANT_REPEAT_DEAL);
        }

        if(hosters==null || hosters.size()==0){
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NO_METER);
        }

        try{
            if(StringUtils.isNotBlank(meterCode)){
                calcCostEverdayBySomeOneCompany(companyId,day,user.getAccount(),meterCode);
            }else{
                calcCostEverdayBySomeOneCompany(companyId,day,user.getAccount(),null);
            }
        }catch(ErrorLogException e){
            TbElectricErrorLog record = e.getErr();
            errorLogMapper.updateByExampleSelective(record,criteria);
            result.setData(e.getErr().toString());
            result.setCode("1");
            result.setResult(e.getErr().toString());
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
    private boolean createBill(BigDecimal allPrice,String companyId,String companyName,String account, List<PayBillDetails> payBillDetails,String meterCode,Date dealDate){
        boolean success = true;
        logger.info("开始调用接口创建账单");

        //Result<ServiceCompany> ressult =  companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        //companyId = ressult.getData().getComAdmin();
        PayBillCreateParamVo payBillCreateParamVo = new PayBillCreateParamVo();
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        String time =sdf.format(date);
        String billId =time+new Random().nextInt(1000000);
        payBillCreateParamVo.setBillId(billId);
        //账单名称
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andMeterCodeEqualTo(meterCode).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricMeterInfo>  meterInfos = tbElectricMeterInfoMapper.selectByExample(meterInfoCriteria);
        String meterName = "";
        if(meterInfos !=null && meterInfos.size()>0){
            meterName = meterInfos.get(0).getMeterName();
        }

        String name = DateUtils.formatDate(dealDate,"yyyy-MM-dd").replace("-","")
                +"电费账单["+meterName+"]";
        payBillCreateParamVo.setBillName(name);
        //账单来源d
        payBillCreateParamVo.setBillSource("企业");
        //账单费用
        payBillCreateParamVo.setBillExpense(allPrice);
        //对象类型【1：企业，2：个人】
        payBillCreateParamVo.setObjType(MeterConstants.OBJ_TYPE);
        //对象Id（传企业ID或用户ID）
        payBillCreateParamVo.setObjId(companyId);
        //对象名称（传企业名称或用户名称）
        payBillCreateParamVo.setObjName(companyName);
        //账本类型ID【1：电费，2：物业费】
        payBillCreateParamVo.setAcBookType(MeterConstants.ELEC_BOOK);
        //回调ID
        payBillCreateParamVo.setCallbackId(MeterConstants.PARK_ID);
        //回调URL
        payBillCreateParamVo.setCallbackUrl(MeterConstants.METHOD_ID);
        //创建时间
        payBillCreateParamVo.setCreatedTime(new Date());
        //创建人
        payBillCreateParamVo.setCreatorAccount(account);
        //最迟缴费时间
        payBillCreateParamVo.setLatePayment(new Date());
        payBillCreateParamVo.setMeterCode(meterCode);
        //缴费详情【存list对象集合】
        payBillCreateParamVo.setPayBillDetails(payBillDetails);
        Result billCreateResult = payClient.billCreate(payBillCreateParamVo);
        logger.info("结束调用接口创建账单");
        //保存账单信息
        if(billCreateResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            logger.info("开始保存成功创建的账单");
            saveBill(payBillCreateParamVo,meterCode,dealDate);
            logger.info("结束保存成功创建的账单");
        }else{
            logger.info("调用创建账单接口失败");
            success =false;
        }
        return success;
    }

    private void saveBill(PayBillCreateParamVo payBill,String meterCode,Date dealDate){
        TbElectricEnergyBill bill = new TbElectricEnergyBill();
        BeanUtils.copyProperties(payBill,bill);
        bill.setAcBookType(payBill.getAcBookType());
        bill.setPayStatus(new Byte(MeterConstants.NOT_PAY));
        bill.setRecordStatus(new Byte(MeterConstants.VALID));
        bill.setCallTimes(0);
        bill.setDay(dealDate);
        bill.setId(payBill.getBillId());
        bill.setMeterCode(meterCode);
        bill.setBillName(payBill.getBillName());
        energyBillMapper.insertSelective(bill);
        //保存明细
        List<TbElectricEnergyBillDetail> saveDetails = new ArrayList<>();
        TbElectricEnergyBillDetail saveDetail=null;
        List<PayBillDetails>  details = payBill.getPayBillDetails();
        if(details !=null && details.size()>0){
            for(PayBillDetails detail : details){
                saveDetail = new TbElectricEnergyBillDetail();
                BeanUtils.copyProperties(detail,saveDetail);
                saveDetail.setBillId(payBill.getBillId());
                saveDetail.setId(UUID.randomUUID().toString().replaceAll("-",""));
                saveDetail.setCreatedTime(new Date());
                saveDetail.setCreatorAccount(payBill.getCreatorAccount());
                saveDetail.setRecordStatus(new Byte(MeterConstants.VALID));
                saveDetails.add(saveDetail);
            }
        }
        if(saveDetails !=null && saveDetails.size()>0){
            meterDao.saveBillDetail(saveDetails);
        }
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
            for(TbElectricReading reading :readings){
                if(Integer.parseInt(reading.getDealHour().toString())==rules.getStart()){
                    startDegree = reading.getReadingEnd();
                }
                if(Integer.parseInt(reading.getDealHour().toString())==(rules.getEnd()-1)){
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
            allPrice= allPrice.add(cost);
            allDegree =allDegree.add(result);
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
        meterDayLog.setRuleId(ruleId);
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
        Date lastDay=null;
        try{
            lastDay =DateUtils.parseDate(DateUtils.formatDate( c.getTime(),"yyyy-MM-dd"),"yyyy-MM-dd");
        }catch (ParseException e){
            logger.info("日期转换错误");
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }

        return lastDay;
    }

    private void saveErrorLog(TbElectricErrorLog errorLog){
        logger.info("记录企业计算电费和电量错误的日志,{}",errorLog.toString());
        errorLogMapper.insertSelective(errorLog);
        logger.info("记录企业计算电费和电量错误的日志");
    }


    @Override
    @ServiceLog(doAction = "缴费成功后进行数据的更新")
    public Result updateBillInfo(PayCallBackNotify payCallBackNotify){

        logger.info("进入账单缴费成功后的回掉方法，进行数据的更新");
        String billId=payCallBackNotify.getBillId();
        PayBillParams payBillParams=new PayBillParams();
        payBillParams.setBillId(billId);
        PayBill payBill =payClient.getBillBasicInfo(billId);
        //支付成功
        if(payBill.getPaymentState().equals(MeterConstants.PAYED)){
            logger.info("账单成功支付！！！！");
            TbElectricEnergyBill bill = new TbElectricEnergyBill();
            bill.setPayStatus(new Byte(MeterConstants.PAYED));
            bill.setPayTime(new Date());
            bill.setModifiedTime(new Date());
            TbElectricEnergyBillCriteria billCriteria = new TbElectricEnergyBillCriteria();
            billCriteria.or().andIdEqualTo(billId).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
            energyBillMapper.updateByExampleSelective(bill,billCriteria);
            TbElectricEnergyBill energyBill = energyBillMapper.selectByPrimaryKey(billId);
            String comAdinOrCompanyId = energyBill.getObjId();
            String companyName = energyBill.getObjName();
            //通过企业id,更新其余额

        }

        return new Result<>();
    }


    @Override
    @ServiceLog(doAction = "催缴")
    public Result setUrgeCall(User user ,String id){
        TbElectricEnergyBillCriteria billCriteria = new TbElectricEnergyBillCriteria();
        billCriteria.or().andIdEqualTo(id).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        TbElectricEnergyBill bill = energyBillMapper.selectByPrimaryKey(id);
        bill.setPayStatus(new Byte(MeterConstants.PAYED));
        bill.setPayTime(new Date());
        bill.setCallTimes(bill.getCallTimes()+1);
        bill.setPaier(user.getAccount());
        bill.setModifiedTime(new Date());
        bill.setModifierAccount(user.getAccount());
        energyBillMapper.updateByExampleSelective(bill,billCriteria);
        //发送催缴信息
        Result<ServiceCompany> serviceCompany = companyClient.getCompanyDetailByAccountOrCompanyId(bill.getObjId());
        if (serviceCompany.getData() == null ) {
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NOT_FOUND);
        }
        String phone = serviceCompany.getData().getConPhone();
        if (StringUtils.isBlank(phone)) {
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_NO_CONTACT_TEL);
        }
        String message ="白下高薪物业管理提醒你,账单号："+bill.getId()+",的电费账号还没缴费，请尽快缴费！谢谢合作。";
        sendSMS(phone,message);
        return new Result();
    }

    /**
     * 发送短信逻辑
     * @param phone
     * @param message
     */
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


}
