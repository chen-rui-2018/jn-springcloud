package com.jn.park.electricmeter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.hardware.enums.ElectricMeterEnum;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.hardware.model.electricmeter.ElectricMeterWaterOrElectricShow;
import com.jn.hardware.model.electricmeter.ElectricOrWaterConditionShow;
import com.jn.park.electricmeter.dao.*;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.enums.MeterExceptionEnums;
import com.jn.park.electricmeter.model.*;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.service.impl.NoticeManageServiceImpl;
import com.jn.pay.api.PayAccountClient;
import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookCreateParam;
import com.jn.pay.model.PayAccountBookEntIdOrUserIdParam;
import com.jn.pay.model.PayAccountBookMoney;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiModelProperty;
import javafx.beans.binding.IntegerBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.xxpay.common.util.DateUtil;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author??? yangh
 * @date??? Created on 2019/5/15 11:27
 * @version??? v1.0
 * @modified By:
 */
@Service
public class MeterServiceImpl implements MeterService {

    @Autowired
    private ElectricMeterClient electricMeterClient;
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private TbElectricReadingFailLogMapper failLogMapper;
    @Autowired
    private TbElectricMeterInfoMapper meterInfoMapper;
    Logger logger = LoggerFactory.getLogger(MeterServiceImpl.class);
    @Autowired
    private TbElectricMeterCompanyDayMapper companyDayMapper;
    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private DelaySendMessageClient delaySendMessageClient;
    @Autowired
    private TbElectricCostMapper tbElectricCostMapper;
    @Autowired(required = false)
    private PayAccountClient payAccountClient;
    @Override
    @ServiceLog(doAction = "????????????????????????")
    public void getDataFromHardare(){
        Date dealDate=DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        String hour=DateUtils.getDate("yyyy-MM-dd HH:mm:ss").split(" ")[1].split(":")[0];
        //?????????0???
        if(Integer.valueOf(hour) == 0){
            hour="23";
            //??????????????????
            dealDate=DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        }else{
            if(Integer.valueOf(hour) -1 <10){
                hour="0"+String.valueOf(Integer.valueOf(hour) -1);
            }else{
                hour=String.valueOf(Integer.valueOf(hour) -1);
            }
        }

        //???????????????
        //??????????????????
        ElectricMeterDataCollectionParam parameter = getParameter();
        String startTime=DateUtils.formatDate(dealDate,"yyyy-MM-dd")+" "+hour+":00:00";
        parameter.setStartTime(startTime);
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricMeterInfo>  meters = meterInfoMapper.selectByExample(meterInfoCriteria);
        logger.info("????????????????????????????????????{}",meters.toString());
        if(meters !=null && meters.size()>0){
            int index=0;
            for(TbElectricMeterInfo meterBean : meters){
                //?????????????????????
                index+=1;
                String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
                parameter.setCode(meterBean.getFactoryMeterCode());
                Result cResult = collectionData(parameter, dealDate, hour);
                if(cResult !=null  && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    //??????????????????????????????
                    ElectricOrWaterConditionShow showBeans= (ElectricOrWaterConditionShow)cResult.getData();


                    if(showBeans == null ){
                        saveFailLog(cResult,hour,dealDate);
                        continue;
                    }
                    List<ElectricMeterWaterOrElectricShow> dataList =showBeans.getData();
                    logger.info("?????????????????????{},???????????????{},???{}???",dataList.toString(),taskBatch,index);
                    Result saveResult =  saveData(dataList,dealDate,  hour , taskBatch);
                    if(saveResult !=null  && saveResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                        try{
                            updateData(taskBatch);
                        }catch(Exception e){
                            logger.info("{}",e);
                            logger.info("??????????????????{}????????????",taskBatch);
                        }

                    }else if(saveResult.getCode().equals("0")){
                        logger.info("????????????????????????????????????,?????????{}",meterBean.toString());
                    }else{
                        saveFailLog(cResult,hour,dealDate);
                    }
                }else{
                    saveFailLog(cResult,hour,dealDate);
                }
            }
        }



    }

    /**
     * ????????????
     * @param isNeedLog
     * @param hour
     * @param dealDate
     */
    private void saveFailLog(Result isNeedLog,String hour,Date dealDate){
        //??????????????????????????????
        logger.info("??????????????????");
        TbElectricReadingFailLog logRecord = new TbElectricReadingFailLog();
        logRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
        logRecord.setCreateTime(new Date());
        logRecord.setDealHour(new Byte(hour));
        logRecord.setDealDate(dealDate);
        logRecord.setStatus(new Byte(MeterConstants.FAIL));
        //logRecord.setParam(isNeedLog.getData().toString());
        logRecord.setRecordStatus(new Byte(MeterConstants.VALID));
        int result = failLogMapper.insert(logRecord);
        if(result !=1){
            logger.info("????????????????????????????????????????????????????????????{}",logRecord.toString());
        }
    }

    /**
     * ????????????
     */
    private Result collectionData(ElectricMeterDataCollectionParam parameter,Date dealDate,String hour){
        boolean isNotOver =true;
        Integer loopGetData=0;
        Result collectionData = null;
        List<ElectricMeterWaterOrElectricShow> dataList =new ArrayList<>();
        int pageIndex=MeterConstants.FIRST_PAGE;
        Result result =new Result();
        while(isNotOver){
            //????????????
            try{
                collectionData = getDataFromHardwareByPage(parameter);
                //?????????????????????????????????????????????????????????????????????
                if(! collectionData.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_SUCCESS);
                }

                ElectricOrWaterConditionShow page= (ElectricOrWaterConditionShow) collectionData.getData();
                if(page.getData() == null || page.getData().size()==0){
                    throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                }
            }catch(Exception e){
                //??????????????????????????????????????????
                logger.info("????????????,{}",e);
                //?????????
                //??????????????????????????????
//                if(loopGetData == MeterConstants.LOOP_NUM){
//                    result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
//                    result.setData(parameter.toString());
//                    result.setResult("???????????????????????????");
//                    break;
//                }

 //               loopGetData+=1;
//                try{
//                    //???????????????
//                    Thread.sleep(MeterConstants.SLEEP_TIME*loopGetData);
//                }catch (InterruptedException ex){
//                    e.printStackTrace();
//                }
//                continue;
                break;
            }

            //????????????,?????????????????????
            if(collectionData.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                //????????????
                ElectricOrWaterConditionShow page= (ElectricOrWaterConditionShow) collectionData.getData();
                if(page.getData() != null && page.getData().size()>0){
                    dataList.addAll(page.getData());
                    pageIndex +=1;
                    if(pageIndex>Integer.parseInt(page.getPages())){
                        //???????????????????????????????????????
                        result.setCode(GlobalConstants.SUCCESS_CODE);
                        ElectricOrWaterConditionShow showBean = new ElectricOrWaterConditionShow();
                        showBean.setData(dataList);
                        result.setData(showBean);
                        result.setResult("???????????????????????????");
                        isNotOver = false;
                    }else{
                        //????????????,????????????
                        parameter.setPage(pageIndex);
                    }
                }

            }
        }
        return result;
    }

    /**
     * ????????????
     */
    @Transactional(rollbackFor = Exception.class)
    public Result saveData(List<ElectricMeterWaterOrElectricShow> dataList,Date dealDate, String hour,String taskBatch){
        Result result = new Result();
        boolean isNotOver =true;
        int loopNum= 0;
        if(dataList !=null && dataList.size()>0){
            //????????????
            while(isNotOver){
                try{
                    List<TbElectricReadingSource> readings = new ArrayList<>();
                    getSaveData(dataList, dealDate,  hour, readings, taskBatch);
                    List<TbElectricReadingSource> saveData = new ArrayList<>();
                    for(TbElectricReadingSource rBean : readings){
                        saveData.add(rBean);
                        if(saveData !=null && saveData.size() ==MeterConstants.SAVE_SIZE){
                            boolean isFail = saveData(saveData);
                            if(isFail){
                                //????????????
                                logger.info("???????????????????????????,?????????????????????{}",saveData.toString());
                                result.setCode("0");
                                result.setData("?????????????????????");
                                result.setResult("?????????????????????");
                                break;
                            }
                            saveData = new ArrayList<>();
                        }
                    }
                    if(saveData !=null && saveData.size() >0){
                        boolean isFail = saveData(saveData);
                        if(isFail){
                            //????????????;???????????????????????????
                            logger.info("???????????????????????????,?????????????????????{}",saveData.toString());
                            result.setCode("0");
                            result.setData("?????????????????????");
                            result.setResult("?????????????????????");
                            break;
                        }
                    }
                    result.setCode(GlobalConstants.SUCCESS_CODE);
                    result.setData("???????????????????????????");
                    result.setResult("???????????????????????????");
                    isNotOver = false;
                    break;

                }catch(Exception e){
                    //??????????????????????????????
                    if(loopNum == MeterConstants.LOOP_NUM){
                        result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
                        result.setData("???????????????????????????");
                        result.setResult("???????????????????????????");
                        break;
                    }
                    loopNum = loopNum+1;
                    try{
                        //???????????????
                        Thread.sleep(MeterConstants.SLEEP_TIME*loopNum);
                    }catch (InterruptedException ex){
                        e.printStackTrace();
                    }
                    continue;
                }
            }
        }
        return result;
    }


    private boolean saveData(List<TbElectricReadingSource> saveData){
        boolean isFail = true;
        try{
            meterDao.insertReadingData(saveData);
            isFail = false;
        }catch(DuplicateKeyException  e){
            logger.info("???????????????????????????{}",saveData.toString());
        }
        return isFail;
    }

    private void updateData(String taskBatch){
        //??????????????????????????????????????????????????????
        meterDao.insertData(taskBatch);
        meterDao.updateDegreeDiff();
        meterDao.deleteElectricDay();
        meterDao.insertElectricDay();

    }

    /**
     * ????????????
     * @param parameter
     * @return
     */
    private Result getDataFromHardwareByPage(ElectricMeterDataCollectionParam parameter){
        return electricMeterClient.electricMeterDataCollection(parameter);
    }

    /**
     * ?????????????????????
     * @param dataList
     * @param hour
     * @param readings
     * @param taskBatch
     */
    private void getSaveData(List<ElectricMeterWaterOrElectricShow> dataList,Date dealDate, String hour, List<TbElectricReadingSource> readings, String taskBatch){
        TbElectricReadingSource reading =null;
        String dealDateStr = DateUtils.getDate("yyyy-MM-dd");
        BigDecimal readingEnd=null;
        for(ElectricMeterWaterOrElectricShow data :dataList ){
            reading = new TbElectricReadingSource();
            reading.setBuildingId(data.getBuildingId());
            reading.setCreateTime(new Date());
            reading.setDealDate(dealDate);
            reading.setDealHour(new Byte(hour));
            //reading.setId(UUID.randomUUID().toString().replaceAll("-",""));
            //timeEnd
            String id = data.getDeviceId()+data.getTimeEnd().replaceAll(":","").replaceAll(" ","").replaceAll("-","");
            reading.setId(id);

            reading.setMeterCode(data.getDeviceId());
            //reading.setParam(paramStr);
            reading.setRecordStatus(new Byte(MeterConstants.VALID));
            readingEnd = new BigDecimal(data.getReadingEnd());
            reading.setReadingEnd(readingEnd );
            Date timeEnd=null;
            try{
                timeEnd = DateUtils.parseDate(data.getTimeEnd(),"yyyy-MM-dd HH:mm:ss");
            }catch (ParseException e){
                e.printStackTrace();
                logger.info("?????????????????????-????????????");
                throw new JnSpringCloudException(MeterExceptionEnums.NOTICE_TIME_PARSE_DEFAULT);
            }
            reading.setTimeEnd(timeEnd);
            reading.setStatus(new Byte(MeterConstants.SUCCESS));
            reading.setStatusMsg("??????");
            reading.setTaskBatch(taskBatch);
            readings.add(reading);
        }
    }

    /**
     * ??????????????????????????????????????????10???
     * @return
     */
    private ElectricMeterDataCollectionParam getParameter(){
        ElectricMeterDataCollectionParam parameter = new ElectricMeterDataCollectionParam();
        parameter.setDeviceType(ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getCode());
        parameter.setRows(MeterConstants.ROWS);
        parameter.setPage(MeterConstants.FIRST_PAGE);
        return parameter;
    }

    @Override
    @ServiceLog(doAction = "????????????????????????????????????????????????????????????")
    public void dealSomeOneFailByHandle(Date dealDate,String dealHour){
        //????????????????????????????????????
        TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
        failLogCriteria.or().andDealDateEqualTo(dealDate).andDealHourEqualTo(new Byte(dealHour))
                .andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL));
        List<TbElectricReadingFailLog>  failLogs = failLogMapper.selectByExample(failLogCriteria);
        if(failLogs ==null || failLogs.size()==0){
            throw new JnSpringCloudException(MeterExceptionEnums.FAIL_LOG_ISNOT_EXIST);
        }

        String dealDateStr = DateUtils.formatDate(dealDate,"yyyy-MM-dd");
        String startTime = "";
        if(Integer.valueOf(dealHour) <10){
            startTime=dealDateStr+" "+"0"+dealHour+":00:00";
        }else {
            startTime =dealDateStr+" "+dealHour+":00:00";
        }


        ElectricMeterDataCollectionParam parameter = getParameter();
        parameter.setStartTime(startTime);
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricMeterInfo>  meters = meterInfoMapper.selectByExample(meterInfoCriteria);
        if(meters !=null && meters.size()>0) {
            int index=0;
            for (TbElectricMeterInfo meterBean : meters) {
                //?????????????????????
                index+=1;
                parameter.setCode(meterBean.getFactoryMeterCode());
                String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
                Result cResult = collectionData(parameter, dealDate, dealHour);
                if (cResult != null && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                    //??????????????????????????????
                    ElectricOrWaterConditionShow showBeans = (ElectricOrWaterConditionShow) cResult.getData();

                    if(showBeans == null){
                        throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                    }
                    List<ElectricMeterWaterOrElectricShow> dataList = showBeans.getData();
                    logger.info("?????????????????????{},???????????????{},???{}???",dataList.toString(),taskBatch,index);
                    Result saveResult =  saveData(dataList,dealDate,  dealHour , taskBatch);
                    if(saveResult !=null  && saveResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                        TbElectricReadingFailLog readingFailLog = new TbElectricReadingFailLog();
                        readingFailLog.setRecordStatus(new Byte(MeterConstants.INVALID));
                        readingFailLog.setStatus(new Byte(MeterConstants.SUCCESS));
                        failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL))
                                .andDealDateEqualTo(dealDate).andDealHourEqualTo(new Byte(dealHour));
                        failLogMapper.updateByExampleSelective(readingFailLog, failLogCriteria);
                        try{
                            updateData(taskBatch);
                        }catch(Exception e){
                            logger.info("{}",e);
                            logger.info("??????????????????{}????????????",taskBatch);
                        }
                    }else if(saveResult.getCode().equals("0")){
                        logger.info("????????????????????????????????????,?????????{}",meterBean.toString());
                    }else {
                        throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL);
                    }

                } else {
                    //??????????????????
                    throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_SUCCESS);
                }
            }
        }
    }

    @Override
    @ServiceLog(doAction = "?????????????????????????????????????????????????????????")
    public Result dealAllFailByHandle(){
        //????????????????????????????????????
        TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
        failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL));
        List<TbElectricReadingFailLog>  failLogs = failLogMapper.selectByExample(failLogCriteria);
        List<String> resultList = new ArrayList<>();
        Result result = new Result();
        if(failLogs !=null && failLogs.size()>0){
            for(TbElectricReadingFailLog failBean : failLogs){
                //???????????????
                ElectricMeterDataCollectionParam parameter = getParameter();
                String dateStr = DateUtils.formatDate(failBean.getDealDate(),"yyyy-MM-dd");
                String startTime = "";
                String dealHour= "";
                if(failBean.getDealHour()<10){
                    dealHour="0"+failBean.getDealHour().toString();
                    startTime =dateStr+" 0"+failBean.getDealHour().toString()+":00:00";
                }else{
                    dealHour=failBean.getDealHour().toString();
                    startTime =dateStr+" "+failBean.getDealHour().toString()+":00:00";
                }
                parameter.setStartTime(startTime);
                Date dealDate = failBean.getDealDate();
                TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
                meterInfoCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
                List<TbElectricMeterInfo>  meters = meterInfoMapper.selectByExample(meterInfoCriteria);
                if(meters !=null && meters.size()>0) {
                    int index=0;
                    for (TbElectricMeterInfo meterBean : meters) {
                        //?????????????????????
                        index+=1;
                        parameter.setCode(meterBean.getFactoryMeterCode());
                        String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
                        Result cResult = collectionData(parameter, dealDate, dealHour);
                        if (cResult != null && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                            //??????????????????????????????
                            ElectricOrWaterConditionShow showBeans = (ElectricOrWaterConditionShow) cResult.getData();

                            if(showBeans == null ){
                                throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                            }
                            List<ElectricMeterWaterOrElectricShow> dataList = showBeans.getData();
                            logger.info("?????????????????????{},???????????????{},???{}???",dataList.toString(),taskBatch,index);
                            Result saveResult =  saveData(dataList,dealDate,  dealHour , taskBatch);
                            if(saveResult !=null  && saveResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                                TbElectricReadingFailLog readingFailLog = new TbElectricReadingFailLog();
                                readingFailLog.setRecordStatus(new Byte(MeterConstants.INVALID));
                                readingFailLog.setStatus(new Byte(MeterConstants.SUCCESS));
                                failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL))
                                        .andDealDateEqualTo(failBean.getDealDate()).andDealHourEqualTo(failBean.getDealHour());
                                failLogMapper.updateByExampleSelective(readingFailLog, failLogCriteria);
                                try{
                                    updateData(taskBatch);
                                }catch(Exception e){
                                    logger.info("{}",e);
                                    logger.info("??????????????????{}????????????",taskBatch);
                                }
                            }else if(saveResult.getCode().equals("0")){
                                logger.info("????????????????????????????????????,?????????{}",meterBean.toString());
                            }else {
                                resultList.add(startTime);
                            }
                        } else {
                            //??????????????????
                            resultList.add(startTime);
                        }
                    }
                }
            }
        }
        result.setData(resultList);
        return result;
    }


    //????????????????????????
    @Override
    @ServiceLog(doAction = "??????????????????")
    public Result insertMeterInfo(User user, MeterInfoModel model){
        //???????????????????????????????????????????????????????????????????????????????????????????????????
        if(StringUtils.isBlank(model.getMeterCode())){
            throw new JnSpringCloudException(MeterExceptionEnums.METER_NO_CODE);
        }
        String meterCode = model.getMeterCode();
        TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeEqualTo(meterCode);
        List<TbElectricMeterInfo>  meterInfos =  meterInfoMapper.selectByExample(meterInfoCriteria);
        if(meterInfos !=null && meterInfos.size()>0){
            throw new JnSpringCloudException(MeterExceptionEnums.METER_INFO_EXIST);
        }
        BeanUtils.copyProperties(model,meterInfo);
        meterInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        meterInfo.setRecordStatus(new Byte(MeterConstants.VALID));
        meterInfo.setCreatorAccount(user.getAccount());
        meterInfo.setCreatedTime(new Date());
        meterInfoMapper.insertSelective(meterInfo);

        //?????????????????????,????????????
        if(StringUtils.isNotBlank(model.getCompanyId())){
            //???????????????????????????????????????
            TbElectricMeterCompanyDayCriteria companyDayCriteria = new TbElectricMeterCompanyDayCriteria();
            companyDayCriteria.or().andDayEqualTo(getNowDate());
            List<TbElectricMeterCompanyDay>  size = companyDayMapper.selectByExample(companyDayCriteria);
            //????????????????????????????????????????????????
            if(size !=null && size.size() >0 ){
                //????????????????????????
                TbElectricMeterCompanyDay linkDay = new TbElectricMeterCompanyDay();
                linkDay.setId(UUID.randomUUID().toString().replaceAll("-",""));
                linkDay.setCompanyId(model.getCompanyId());
                linkDay.setCreatedTime(new Date());
                linkDay.setCreatorAccount(user.getAccount());
                linkDay.setMeterCode(model.getMeterCode());
                linkDay.setRecordStatus(new Byte(MeterConstants.VALID));
                linkDay.setDay(getNowDate());
                linkDay.setMeterName(model.getMeterName());
                companyDayMapper.insertSelective(linkDay);
            }
        }
        //??????????????????
        if(StringUtils.isNotBlank(model.getCompanyId())){
            createAccountBook(model.getCompanyId(),meterCode);
        }

        return new Result();
    }

    private void createAccountBook(String companyId,String meterCode){

        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if (result.getData() != null) {
            String comAdmin=result.getData().getComAdmin();
            logger.info("?????????????????????????????????????????????????????????{},??????id{}???????????????{}",comAdmin,companyId,meterCode);
            // 4.???????????????????????????-????????????
            PayAccountBookCreateParam payAccountBookCreateParam = new PayAccountBookCreateParam();
            payAccountBookCreateParam.setComAdmin(comAdmin);
            payAccountBookCreateParam.setEnterId(companyId);
            Delay delay = new Delay();
            delay.setServiceId("springcloud-enterprise");
            delay.setServiceUrl("/api/payment/payAccount/createPayAccountBook");
            delay.setTtl("30");
            delay.setDataString(JSONObject.toJSONString(payAccountBookCreateParam));
            logger.info("????????????");
            Result<Boolean> delayResult = delaySendMessageClient.delaySend(delay);
            logger.info("????????????,??????????????????{}???", delayResult.toString());
        }else{
            logger.info("????????????????????????????????????????????????????????????id???{}",companyId);
        }
    }

    @Override
    @ServiceLog(doAction = "??????????????????")
    public Result deleteMeterInfo(User user,String id){
        //??????????????????
        TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
        meterInfo.setModifiedTime(new Date());
        meterInfo.setModifierAccount(user.getAccount());
        meterInfo.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andIdEqualTo(id);
        meterInfoMapper.updateByExampleSelective(meterInfo,meterInfoCriteria);
        TbElectricMeterInfo meterInfos = meterInfoMapper.selectByPrimaryKey(id);
        //??????????????????????????????????????????
        if(meterInfos ==null){
            throw new JnSpringCloudException(MeterExceptionEnums.METER_INFO_NOT_FOUND);
        }
        deleteEveryDayLinks(meterInfos);
        return new Result();
    }

    /**
     * ?????????????????????
     * @return
     */
    private Date getNowDate(){
        Date date =null;
        try{
            date =DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"),"yyyy-MM-dd");
        }catch(ParseException e){
            logger.info("?????????????????????????????????");
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }
        return date;
    }

    /**
     * ?????????????????????????????????
     */
    private void deleteEveryDayLinks(TbElectricMeterInfo meterInfos){
        if(StringUtils.isBlank(meterInfos.getCompanyId())){
            //???????????????????????????????????????????????????????????????
            return;
        }

        Date date =getNowDate();
        TbElectricMeterCompanyDay companyDay = new TbElectricMeterCompanyDay();
        companyDay.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricMeterCompanyDayCriteria companyDayCriteria = new TbElectricMeterCompanyDayCriteria();
        companyDayCriteria.or().andMeterCodeEqualTo(meterInfos.getCompanyId()).andMeterCodeEqualTo(meterInfos.getMeterCode())
                .andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andDayEqualTo(date);
        companyDayMapper.updateByExampleSelective(companyDay,companyDayCriteria);
    }

    @Override
    @ServiceLog(doAction = "??????????????????")
    public Result updateMeterInfo(User user, MeterInfoModel model){
        //?????????????????????????????????????????????
        TbElectricMeterInfo meterInfos = meterInfoMapper.selectByPrimaryKey(model.getId());
        //??????????????????????????????????????????
        deleteEveryDayLinks(meterInfos);
        //??????????????????
        TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
        BeanUtils.copyProperties(model,meterInfo);
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andIdEqualTo(model.getId()).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        meterInfoMapper.updateByExampleSelective(meterInfo,meterInfoCriteria);
        //???????????????????????????????????????????????????????????????????????????????????????

        TbElectricMeterCompanyDayCriteria companyDayCriteria = new TbElectricMeterCompanyDayCriteria();
        companyDayCriteria.or().andDayEqualTo(getNowDate());
        List<TbElectricMeterCompanyDay>  size = companyDayMapper.selectByExample(companyDayCriteria);
        //??????id?????????????????????????????????
        if(StringUtils.isNotBlank(model.getCompanyId())){
            if(size !=null && size.size() >0 ){
                //????????????????????????
                TbElectricMeterCompanyDay linkDay = new TbElectricMeterCompanyDay();
                linkDay.setId(UUID.randomUUID().toString().replaceAll("-",""));
                linkDay.setCompanyId(model.getCompanyId());
                linkDay.setCreatedTime(new Date());
                linkDay.setCreatorAccount(user.getAccount());
                linkDay.setMeterCode(model.getMeterCode());
                linkDay.setRecordStatus(new Byte(MeterConstants.VALID));
                linkDay.setDay(getNowDate());
                linkDay.setMeterName(model.getMeterName());
                companyDayMapper.insertSelective(linkDay);
            }
        }

        if(StringUtils.isNotBlank(model.getCompanyId())){
            createAccountBook(model.getCompanyId(),model.getMeterCode());
        }
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "?????????????????????????????????")
    public void setHostForMeter() {
        //??????????????????????????????????????????????????????
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andCompanyIdIsNotNull();

        List<TbElectricMeterInfo> meterInfos = meterInfoMapper.selectByExample(meterInfoCriteria);
        if(meterInfos !=null && meterInfos.size()>0){
            TbElectricMeterCompanyDay linkDay = null;
            List<TbElectricMeterCompanyDay>  companyDays =new ArrayList<>();
            for(TbElectricMeterInfo meterInfo : meterInfos){
                linkDay = new TbElectricMeterCompanyDay();
                linkDay.setId(UUID.randomUUID().toString().replaceAll("-",""));
                linkDay.setCompanyId(meterInfo.getCompanyId());
                linkDay.setCreatedTime(new Date());
                linkDay.setCreatorAccount(MeterConstants.SYSTEM_USER);
                linkDay.setMeterCode(meterInfo.getMeterCode());
                linkDay.setRecordStatus(new Byte(MeterConstants.VALID));
                linkDay.setDay(getNowDate());
                linkDay.setMeterName(meterInfo.getMeterName());
                companyDays.add(linkDay);
                if(companyDays !=null && companyDays.size()==40){
                    meterDao.saveMeterLinkInDay(companyDays);
                    companyDays =new ArrayList<>();
                }

            }
            if(companyDays !=null && companyDays.size()>0){
                meterDao.saveMeterLinkInDay(companyDays);
            }
        }
    }

    //????????????

    @Override
    public Result groupChart() {
        Result result = new Result();
        List<GroupChartStatisticsModel> list = meterDao.groupChart();
        result.setData(list);
        return result;
    }

    @Override
    public Result categaryChart() {
        Result result = new Result();
        List<GategaryEnergyStatisticsModel> list = meterDao.categaryChart();
        result.setData(list);
        return result;
    }

    @Override
    public Result<PaginationData<List<TrendChartDetailStatisticsModel>>> trendChartDetail(TrendChartPageParam param) {
        Result result = new Result();
        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        List<TrendChartDetailStatisticsModel> list = meterDao.trendChartDetail(param);
        PaginationData<List<TrendChartDetailStatisticsModel>> data = new PaginationData(list, objects.getTotal());
        result.setData(data);
        return result;
    }

    @Override
    public Result trendChart(TrendChartParam param) {
        Result result = new Result();
        List<TrendChartStatisticsModel> list = meterDao.trendChart(param);
        result.setData(list);
        return result;
    }

    @Override

    public TbElectricMeterInfo getByCode(String code) {
        TbElectricMeterInfoCriteria criteria=new TbElectricMeterInfoCriteria();
        criteria.createCriteria().andRecordStatusEqualTo(new Byte("1")).andMeterCodeEqualTo(code);
        List<TbElectricMeterInfo> list=meterInfoMapper.selectByExample(criteria);
        if(null!=list||list.size()>0){
            return list.get(0);
        }
       return null;
    }

    @Override
    public Result todayElectric(User user){
        String account = user.getAccount();
        Result newResult = new Result();
        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(account);
        if(!StringUtils.equals(newResult.getCode(),"0000")){
            return new Result("-1","???????????????");
        }
        if(result!=null && result.getData()!=null && StringUtils.isNoneBlank(result.getData().getId())){
            String companyId=result.getData().getId();
            List<ConditionElectro> list = meterDao.todayElectric(companyId);
            newResult.setData(list);
        }else{
            throw new JnSpringCloudException(new Result("-1","?????????????????????"));
        }
        return newResult;
    }

    @Override
    public Result monthElectric(User user) {
        String account = user.getAccount();
        Result newResult = new Result();
        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(account);
        if(!StringUtils.equals(newResult.getCode(),"0000")){
            return new Result("-1","???????????????");
        }
        if(result!=null && result.getData()!=null && StringUtils.isNoneBlank(result.getData().getId())){
            String companyId=result.getData().getId();
            List<ConditionElectro> list = meterDao.monthElectric(companyId);
            newResult.setData(list);
        }else{
            throw new JnSpringCloudException(new Result("-1","?????????????????????"));
        }
        return newResult;
    }

    @Override
    public Result yearElectric(User user) {
        String account = user.getAccount();
        Result newResult = new Result();
        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(account);
        if(!StringUtils.equals(newResult.getCode(),"0000")){
            return new Result("-1","???????????????");
        }
        if(result!=null && result.getData()!=null && StringUtils.isNoneBlank(result.getData().getId())){
            String companyId=result.getData().getId();
            List<YearElectro> list = meterDao.yearElectric(companyId);
            newResult.setData(list);
        }else{
            throw new JnSpringCloudException(new Result("-1","?????????????????????"));
        }
        return newResult;
    }

    /**
     * ???????????????????????????
     * @param dealDate
     * @param dealHour
     * @param meterCode
     * @return
     */
    public Result dealAllFailByDealHourAndDealDateAndMeterCode(Date dealDate,String dealHour,String meterCode){
        //????????????????????????????????????
        Result result = new Result();
        String dealDateStr = DateUtils.formatDate(dealDate,"yyyy-MM-dd");
        String startTime = "";
        if(Integer.valueOf(dealHour) <10){
            startTime=dealDateStr+" "+"0"+dealHour+":00:00";
        }else {
            startTime =dealDateStr+" "+dealHour+":00:00";
        }
        ElectricMeterDataCollectionParam parameter = getParameter();
        parameter.setStartTime(startTime);
        parameter.setCode(meterCode);
        String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
        Result cResult = collectionData(parameter, dealDate, dealHour);

        if (cResult != null && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
            //??????????????????????????????
            ElectricOrWaterConditionShow showBeans = (ElectricOrWaterConditionShow) cResult.getData();

            if(showBeans == null){
                //throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                result.setData("?????????????????????");
                return result;
            }
            List<ElectricMeterWaterOrElectricShow> dataList = showBeans.getData();
            logger.info("?????????????????????{},???????????????{},???{}???",dataList.toString(),taskBatch);
            Result saveResult =  saveData(dataList,dealDate,  dealHour , taskBatch);
            if(saveResult !=null  && saveResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                TbElectricReadingFailLog readingFailLog = new TbElectricReadingFailLog();
                readingFailLog.setRecordStatus(new Byte(MeterConstants.INVALID));
                readingFailLog.setStatus(new Byte(MeterConstants.SUCCESS));
                try{
                    updateData(taskBatch);
                }catch(Exception e){
                    logger.info("{}",e);
                    logger.info("??????????????????{}????????????",taskBatch);
                    result.setData("????????????");
                    return result;
                }
                TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
                failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL))
                        .andDealDateEqualTo(dealDate).andDealHourEqualTo(new Byte(dealHour));
                failLogMapper.updateByExampleSelective(readingFailLog, failLogCriteria);
            }else if(saveResult.getCode().equals("0")){
                logger.info("????????????????????????????????????,?????????{}",meterCode);
            }else {
                result.setData("????????????");
                return result;
            }

        } else {
            //??????????????????
            result.setData("????????????");
            return result;
        }
        result.setData(1);
        return result;
    }


    @ServiceLog(doAction = "????????????id??????????????????")
    public Result getMeterInfosByCompanyId(String companyId){
        Result result = new Result();
        TbElectricMeterInfoCriteria criteria = new TbElectricMeterInfoCriteria();
        criteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andCompanyIdEqualTo(companyId);
        logger.info("??????id{}",companyId);
        List<TbElectricMeterInfo> meterInfos =meterInfoMapper.selectByExample(criteria);
        List<ElectricMeterInfoModel> list = new ArrayList<>();
        if(meterInfos.size() > 0){
            for (TbElectricMeterInfo tb: meterInfos) {
                ElectricMeterInfoModel el = new ElectricMeterInfoModel();
                BeanUtils.copyProperties(tb,el);
                list.add(el);
            }
        }
        logger.info("??????id{},??????{}",companyId,meterInfos);
        result.setData(list);
        return result;
    }
    @ServiceLog(doAction = "??????????????????")
    public Result updateBillCost(CostBillModel companyModel){

        PayAccountBookMoney payAccountBookMoney = new PayAccountBookMoney();
        payAccountBookMoney.setAcBookId(companyModel.getAcBookId());
        Result<PayAccountBook>  bookResult =  payAccountClient.queryPayAccountBookMoney(payAccountBookMoney);
        if(bookResult.getData() ==null){
            logger.info("????????????????????????????????????id???{}",companyModel.getAcBookId());
            throw new JnSpringCloudException(MeterExceptionEnums.COMPANY_BALANCE_NOT_FOUND);
        }
        String companyId=bookResult.getData().getEntId();
        String meterCode = bookResult.getData().getMeterCode();
        Result<ServiceCompany> comp = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if (comp.getData() != null) {
            String comAdmin=comp.getData().getComAdmin();
            logger.info("?????????????????????????????????????????????????????????{},??????id{}???????????????{}",comAdmin,companyId,meterCode);
            // 4????????????
            TbElectricCostCriteria costCriteria = new TbElectricCostCriteria();
            costCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andCompanyIdEqualTo(companyId).andMeterCodeEqualTo(meterCode); ;
            List<TbElectricCost> costbeans =tbElectricCostMapper.selectByExample(costCriteria);
            //????????????????????????????????????????????????????????????????????????????????????
            if(costbeans == null || costbeans.size()==0){
                logger.info("??????????????????????????????id???{}",companyId);
                TbElectricCost costbean = new TbElectricCost();
                costbean.setBalance(bookResult.getData().getBalance());
                costbean.setCompanyId(companyId);
                costbean.setCreatedTime(new Date());
                costbean.setCreatorAccount(MeterConstants.SYSTEM_USER);
                costbean.setRecordStatus(new Byte(MeterConstants.VALID));
                costbean.setCompanyName(comp.getData().getComName());
                costbean.setId(UUID.randomUUID().toString().replaceAll("-",""));
                costbean.setAccountType(MeterConstants.ELEC_BOOK);
                costbean.setMeterCode(meterCode);
                tbElectricCostMapper.insertSelective(costbean);
            }else{
                //????????????
                logger.info("??????????????????????????????id???{}",companyId);
                TbElectricCost costbean = new TbElectricCost();
                costbean.setBalance(bookResult.getData().getBalance());
                costCriteria.or().andCompanyIdEqualTo(companyId).andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andMeterCodeEqualTo(meterCode);
                tbElectricCostMapper.updateByExampleSelective(costbean,costCriteria);
            }
        }else{
            logger.info("????????????????????????????????????????????????????????????id???{}",companyId);
        }
        return new Result();
    }

}
