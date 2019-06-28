package com.jn.park.electricmeter.service.impl;

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
import com.jn.park.electricmeter.dao.MeterDao;
import com.jn.park.electricmeter.dao.TbElectricMeterCompanyDayMapper;
import com.jn.park.electricmeter.dao.TbElectricMeterInfoMapper;
import com.jn.park.electricmeter.dao.TbElectricReadingFailLogMapper;
import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.enums.MeterExceptionEnums;
import com.jn.park.electricmeter.model.*;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.service.impl.NoticeManageServiceImpl;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiModelProperty;
import javafx.beans.binding.IntegerBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.DateUtil;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 11:27
 * @version： v1.0
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

    @Override
    @ServiceLog(doAction = "电表读数定时入库")
    public void getDataFromHardare(){
        Date dealDate=DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        String hour=DateUtils.getDate("yyyy-MM-dd HH:mm:ss").split(" ")[1].split(":")[0];
        //如果是0点
        if(Integer.valueOf(hour) == 0){
            hour="23";
            //日期提前一天
            dealDate=DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        }else{
            if(Integer.valueOf(hour) -1 <10){
                hour="0"+String.valueOf(Integer.valueOf(hour) -1);
            }else{
                hour=String.valueOf(Integer.valueOf(hour) -1);
            }
        }

        //所有的电表
        //访问参数处理
        ElectricMeterDataCollectionParam parameter = getParameter();
        String startTime=DateUtils.formatDate(dealDate,"yyyy-MM-dd")+" "+hour+":00:00";
        parameter.setStartTime(startTime);
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricMeterInfo>  meters = meterInfoMapper.selectByExample(meterInfoCriteria);
        logger.info("开始采集日志，电表集合，{}",meters.toString());
        if(meters !=null && meters.size()>0){
            int index=0;
            for(TbElectricMeterInfo meterBean : meters){
                //设置每块电表的
                index+=1;
                String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
                parameter.setCode(meterBean.getFactoryMeterCode());
                Result cResult = collectionData(parameter, dealDate, hour);
                if(cResult !=null  && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    //采集成功后，保存数据
                    ElectricOrWaterConditionShow showBeans= (ElectricOrWaterConditionShow)cResult.getData();


                    if(showBeans == null ){
                        saveFailLog(cResult,hour,dealDate);
                        continue;
                    }
                    List<ElectricMeterWaterOrElectricShow> dataList =showBeans.getData();
                    logger.info("采集到的数据：{},批次号为：{},第{}表",dataList.toString(),taskBatch,index);
                    Result saveResult =  saveData(dataList,dealDate,  hour , taskBatch);
                    if(saveResult !=null  && saveResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                        try{
                            updateData(taskBatch);
                        }catch(Exception e){
                            logger.info("{}",e);
                            logger.info("任务批次号为{}更新失败",taskBatch);
                        }

                    }else if(saveResult.getCode().equals("0")){
                        logger.info("主键重复，已经正确入库了,编号为{}",meterBean.toString());
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
     * 保存日志
     * @param isNeedLog
     * @param hour
     * @param dealDate
     */
    private void saveFailLog(Result isNeedLog,String hour,Date dealDate){
        //需要保存日志，失败了
        logger.info("保存错误日志");
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
            logger.info("电表读数定时入库的失败日志写入失败！！！{}",logRecord.toString());
        }
    }

    /**
     * 采集流程
     */
    private Result collectionData(ElectricMeterDataCollectionParam parameter,Date dealDate,String hour){
        boolean isNotOver =true;
        Integer loopGetData=0;
        Result collectionData = null;
        List<ElectricMeterWaterOrElectricShow> dataList =new ArrayList<>();
        int pageIndex=MeterConstants.FIRST_PAGE;
        Result result =new Result();
        while(isNotOver){
            //获取数据
            try{
                collectionData = getDataFromHardwareByPage(parameter);
                //如果采集到的数据，返回的是一次信息，也抛出异常
                if(! collectionData.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_SUCCESS);
                }

                ElectricOrWaterConditionShow page= (ElectricOrWaterConditionShow) collectionData.getData();
                if(page.getData() == null || page.getData().size()==0){
                    throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                }
            }catch(Exception e){
                //没有采集成功就进行下一次循环
                logger.info("采集异常,{}",e);
                //不重试
                //是否已经达到一定次数
//                if(loopGetData == MeterConstants.LOOP_NUM){
//                    result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
//                    result.setData(parameter.toString());
//                    result.setResult("数据采集失败！！！");
//                    break;
//                }

 //               loopGetData+=1;
//                try{
//                    //失败后睡眠
//                    Thread.sleep(MeterConstants.SLEEP_TIME*loopGetData);
//                }catch (InterruptedException ex){
//                    e.printStackTrace();
//                }
//                continue;
                break;
            }

            //采集成功,处理数据到集合
            if(collectionData.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                //取出数据
                ElectricOrWaterConditionShow page= (ElectricOrWaterConditionShow) collectionData.getData();
                if(page.getData() != null && page.getData().size()>0){
                    dataList.addAll(page.getData());
                    pageIndex +=1;
                    if(pageIndex>Integer.parseInt(page.getPages())){
                        //数据采集完成，没有下一页了
                        result.setCode(GlobalConstants.SUCCESS_CODE);
                        ElectricOrWaterConditionShow showBean = new ElectricOrWaterConditionShow();
                        showBean.setData(dataList);
                        result.setData(showBean);
                        result.setResult("数据采集成功！！！");
                        isNotOver = false;
                    }else{
                        //设置参数,下一页，
                        parameter.setPage(pageIndex);
                    }
                }

            }
        }
        return result;
    }

    /**
     * 保存流程
     */
    @Transactional(rollbackFor = Exception.class)
    public Result saveData(List<ElectricMeterWaterOrElectricShow> dataList,Date dealDate, String hour,String taskBatch){
        Result result = new Result();
        boolean isNotOver =true;
        int loopNum= 0;
        if(dataList !=null && dataList.size()>0){
            //保存数据
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
                                //主键重复
                                logger.info("已经正确入库的数据,不能再次入库：{}",saveData.toString());
                                result.setCode("0");
                                result.setData("主键重复！！！");
                                result.setResult("主键重复！！！");
                                break;
                            }
                            saveData = new ArrayList<>();
                        }
                    }
                    if(saveData !=null && saveData.size() >0){
                        boolean isFail = saveData(saveData);
                        if(isFail){
                            //主键重复;数据已经正确入库了
                            logger.info("已经正确入库的数据,不能再次入库：{}",saveData.toString());
                            result.setCode("0");
                            result.setData("主键重复！！！");
                            result.setResult("主键重复！！！");
                            break;
                        }
                    }
                    result.setCode(GlobalConstants.SUCCESS_CODE);
                    result.setData("数据保存成功！！！");
                    result.setResult("数据保存成功！！！");
                    isNotOver = false;
                    break;

                }catch(Exception e){
                    //是否已经达到一定次数
                    if(loopNum == MeterConstants.LOOP_NUM){
                        result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
                        result.setData("保存数据失败！！！");
                        result.setResult("保存数据失败！！！");
                        break;
                    }
                    loopNum = loopNum+1;
                    try{
                        //失败后睡眠
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
            logger.info("主键异常，数据为：{}",saveData.toString());
        }
        return isFail;
    }

    private void updateData(String taskBatch){
        //将临时表中的数据更新到正式的历史表中
        meterDao.insertData(taskBatch);
        meterDao.updateDegreeDiff();
        meterDao.deleteElectricDay();
        meterDao.insertElectricDay();

    }

    /**
     * 采集数据
     * @param parameter
     * @return
     */
    private Result getDataFromHardwareByPage(ElectricMeterDataCollectionParam parameter){
        return electricMeterClient.electricMeterDataCollection(parameter);
    }

    /**
     * 获取保存的数据
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
                logger.info("日期格式不规范-转换错误");
                throw new JnSpringCloudException(MeterExceptionEnums.NOTICE_TIME_PARSE_DEFAULT);
            }
            reading.setTimeEnd(timeEnd);
            reading.setStatus(new Byte(MeterConstants.SUCCESS));
            reading.setStatusMsg("成功");
            reading.setTaskBatch(taskBatch);
            readings.add(reading);
        }
    }

    /**
     * 初始参数，从第一页开始，每页10条
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
    @ServiceLog(doAction = "手动处理指定的电表读数定时入库失败的数据")
    public void dealSomeOneFailByHandle(Date dealDate,String dealHour){
        //检测这条数据是失败的数据
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
                //设置每块电表的
                index+=1;
                parameter.setCode(meterBean.getFactoryMeterCode());
                String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
                Result cResult = collectionData(parameter, dealDate, dealHour);
                if (cResult != null && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                    //采集成功后，保存数据
                    ElectricOrWaterConditionShow showBeans = (ElectricOrWaterConditionShow) cResult.getData();

                    if(showBeans == null){
                        throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                    }
                    List<ElectricMeterWaterOrElectricShow> dataList = showBeans.getData();
                    logger.info("采集到的数据：{},批次号为：{},第{}表",dataList.toString(),taskBatch,index);
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
                            logger.info("任务批次号为{}更新失败",taskBatch);
                        }
                    }else if(saveResult.getCode().equals("0")){
                        logger.info("主键重复，已经正确入库了,编号为{}",meterBean.toString());
                    }else {
                        throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL);
                    }

                } else {
                    //不在记录日志
                    throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_SUCCESS);
                }
            }
        }
    }

    @Override
    @ServiceLog(doAction = "手动处理所有电表读数定时入库失败的数据")
    public Result dealAllFailByHandle(){
        //检测这条数据是失败的数据
        TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
        failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL));
        List<TbElectricReadingFailLog>  failLogs = failLogMapper.selectByExample(failLogCriteria);
        List<String> resultList = new ArrayList<>();
        Result result = new Result();
        if(failLogs !=null && failLogs.size()>0){
            for(TbElectricReadingFailLog failBean : failLogs){
                //初始化参数
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
                        //设置每块电表的
                        index+=1;
                        parameter.setCode(meterBean.getFactoryMeterCode());
                        String taskBatch =UUID.randomUUID().toString().replaceAll("-","");
                        Result cResult = collectionData(parameter, dealDate, dealHour);
                        if (cResult != null && cResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                            //采集成功后，保存数据
                            ElectricOrWaterConditionShow showBeans = (ElectricOrWaterConditionShow) cResult.getData();

                            if(showBeans == null ){
                                throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                            }
                            List<ElectricMeterWaterOrElectricShow> dataList = showBeans.getData();
                            logger.info("采集到的数据：{},批次号为：{},第{}表",dataList.toString(),taskBatch,index);
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
                                    logger.info("任务批次号为{}更新失败",taskBatch);
                                }
                            }else if(saveResult.getCode().equals("0")){
                                logger.info("主键重复，已经正确入库了,编号为{}",meterBean.toString());
                            }else {
                                resultList.add(startTime);
                            }
                        } else {
                            //不在记录日志
                            resultList.add(startTime);
                        }
                    }
                }
            }
        }
        result.setData(resultList);
        return result;
    }


    //电表信息维护接口
    @Override
    @ServiceLog(doAction = "电表业主维护")
    public Result insertMeterInfo(User user, MeterInfoModel model){
        //检查当前的表是否已经被创建过，如果已经添加则只能够更新，并抛出异常
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

        //表的业主设置了,创建关系
        if(StringUtils.isNotBlank(model.getCompanyId())){
            //检查今天的数据是否已经创建
            TbElectricMeterCompanyDayCriteria companyDayCriteria = new TbElectricMeterCompanyDayCriteria();
            companyDayCriteria.or().andDayEqualTo(getNowDate());
            List<TbElectricMeterCompanyDay>  size = companyDayMapper.selectByExample(companyDayCriteria);
            //今日关系定时器已经创建了，则插入
            if(size !=null && size.size() >0 ){
                //插入一条关系数据
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

        return new Result();
    }

    @Override
    @ServiceLog(doAction = "电表信息作废")
    public Result deleteMeterInfo(User user,String id){
        //作废电表信息
        TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
        meterInfo.setModifiedTime(new Date());
        meterInfo.setModifierAccount(user.getAccount());
        meterInfo.setRecordStatus(new Byte(MeterConstants.INVALID));
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andIdEqualTo(id);
        meterInfoMapper.updateByExampleSelective(meterInfo,meterInfoCriteria);
        TbElectricMeterInfo meterInfos = meterInfoMapper.selectByPrimaryKey(id);
        //作废电表信息和企业的每日关系
        if(meterInfos ==null){
            throw new JnSpringCloudException(MeterExceptionEnums.METER_INFO_NOT_FOUND);
        }
        deleteEveryDayLinks(meterInfos);
        return new Result();
    }

    /**
     * 获取当前的日期
     * @return
     */
    private Date getNowDate(){
        Date date =null;
        try{
            date =DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"),"yyyy-MM-dd");
        }catch(ParseException e){
            logger.info("获取当前日期时转换失败");
            throw new JnSpringCloudException(MeterExceptionEnums.DAY_FORMATE_WRONG);
        }
        return date;
    }

    /**
     * 作废电表的每日关系信息
     */
    private void deleteEveryDayLinks(TbElectricMeterInfo meterInfos){
        if(StringUtils.isBlank(meterInfos.getCompanyId())){
            //业主是空的，不用注释关系，因为没有关系数据
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
    @ServiceLog(doAction = "电表信息更新")
    public Result updateMeterInfo(User user, MeterInfoModel model){
        //获取出之前的信息及每日关系信息
        TbElectricMeterInfo meterInfos = meterInfoMapper.selectByPrimaryKey(model.getId());
        //作废电表信息和企业的每日关系
        deleteEveryDayLinks(meterInfos);
        //更新电表信息
        TbElectricMeterInfo meterInfo = new TbElectricMeterInfo();
        BeanUtils.copyProperties(model,meterInfo);
        TbElectricMeterInfoCriteria meterInfoCriteria = new TbElectricMeterInfoCriteria();
        meterInfoCriteria.or().andIdEqualTo(model.getId()).andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        meterInfoMapper.updateByExampleSelective(meterInfo,meterInfoCriteria);
        //每日关系，存在则创建一条，不存在则不插入，等定时器自动插入

        TbElectricMeterCompanyDayCriteria companyDayCriteria = new TbElectricMeterCompanyDayCriteria();
        companyDayCriteria.or().andDayEqualTo(getNowDate());
        List<TbElectricMeterCompanyDay>  size = companyDayMapper.selectByExample(companyDayCriteria);
        //企业id不为空时才创建关系数据
        if(StringUtils.isNotBlank(model.getCompanyId())){
            if(size !=null && size.size() >0 ){
                //插入一条关系数据
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
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "电表每日的业主信息日志")
    public void setHostForMeter() {
        //查询出所有有效的，业主不为空的表数据
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

    //能耗统计

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
            return new Result("-1","企业不存在");
        }
        if(result!=null && result.getData()!=null && StringUtils.isNoneBlank(result.getData().getId())){
            String companyId=result.getData().getId();
            List<ConditionElectro> list = meterDao.todayElectric(companyId);
            newResult.setData(list);
        }else{
            throw new JnSpringCloudException(new Result("-1","企业数据不存在"));
        }
        return newResult;
    }

    @Override
    public Result monthElectric(User user) {
        String account = user.getAccount();
        Result newResult = new Result();
        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(account);
        if(!StringUtils.equals(newResult.getCode(),"0000")){
            return new Result("-1","企业不存在");
        }
        if(result!=null && result.getData()!=null && StringUtils.isNoneBlank(result.getData().getId())){
            String companyId=result.getData().getId();
            List<ConditionElectro> list = meterDao.monthElectric(companyId);
            newResult.setData(list);
        }else{
            throw new JnSpringCloudException(new Result("-1","企业数据不存在"));
        }
        return newResult;
    }

    @Override
    public Result yearElectric(User user) {
        String account = user.getAccount();
        Result newResult = new Result();
        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(account);
        if(!StringUtils.equals(newResult.getCode(),"0000")){
            return new Result("-1","企业不存在");
        }
        if(result!=null && result.getData()!=null && StringUtils.isNoneBlank(result.getData().getId())){
            String companyId=result.getData().getId();
            List<YearElectro> list = meterDao.yearElectric(companyId);
            newResult.setData(list);
        }else{
            throw new JnSpringCloudException(new Result("-1","企业数据不存在"));
        }
        return newResult;
    }

    /**
     * 按照电表号采集数据
     * @param dealDate
     * @param dealHour
     * @param meterCode
     * @return
     */
    public Result dealAllFailByDealHourAndDealDateAndMeterCode(Date dealDate,String dealHour,String meterCode){
        //检测这条数据是失败的数据
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
            //采集成功后，保存数据
            ElectricOrWaterConditionShow showBeans = (ElectricOrWaterConditionShow) cResult.getData();

            if(showBeans == null){
                //throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_ISNOT_EXIST);
                result.setData("采集的数据为空");
                return result;
            }
            List<ElectricMeterWaterOrElectricShow> dataList = showBeans.getData();
            logger.info("采集到的数据：{},批次号为：{},第{}表",dataList.toString(),taskBatch);
            Result saveResult =  saveData(dataList,dealDate,  dealHour , taskBatch);
            if(saveResult !=null  && saveResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                TbElectricReadingFailLog readingFailLog = new TbElectricReadingFailLog();
                readingFailLog.setRecordStatus(new Byte(MeterConstants.INVALID));
                readingFailLog.setStatus(new Byte(MeterConstants.SUCCESS));
                try{
                    updateData(taskBatch);
                }catch(Exception e){
                    logger.info("{}",e);
                    logger.info("任务批次号为{}更新失败",taskBatch);
                    result.setData("更新失败");
                    return result;
                }
                TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
                failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andStatusEqualTo(new Byte(MeterConstants.FAIL))
                        .andDealDateEqualTo(dealDate).andDealHourEqualTo(new Byte(dealHour));
                failLogMapper.updateByExampleSelective(readingFailLog, failLogCriteria);
            }else if(saveResult.getCode().equals("0")){
                logger.info("主键重复，已经正确入库了,编号为{}",meterCode);
            }else {
                result.setData("采集失败");
                return result;
            }

        } else {
            //不在记录日志
            result.setData("采集失败");
            return result;
        }
        result.setData(1);
        return result;
    }


    @ServiceLog(doAction = "通过企业id查询电表信息")
    public Result getMeterInfosByCompanyId(String companyId){
        Result result = new Result();
        TbElectricMeterInfoCriteria criteria = new TbElectricMeterInfoCriteria();
        criteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID)).andCompanyIdEqualTo(companyId);
        logger.info("企业id{}",companyId);
        List<TbElectricMeterInfo> meterInfos =meterInfoMapper.selectByExample(criteria);
        List<ElectricMeterInfoModel> list = new ArrayList<>();
        if(meterInfos.size() > 0){
            for (TbElectricMeterInfo tb: meterInfos) {
                ElectricMeterInfoModel el = new ElectricMeterInfoModel();
                BeanUtils.copyProperties(tb,el);
                list.add(el);
            }
        }
        logger.info("企业id{},数据{}",companyId,meterInfos);
        result.setData(list);
        return result;
    }

}
