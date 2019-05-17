package com.jn.park.electricmeter.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.hardware.enums.ElectricMeterEnum;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.hardware.model.electricmeter.ElectricMeterWaterOrElectricShow;
import com.jn.hardware.model.electricmeter.ElectricOrWaterConditionShow;
import com.jn.park.electricmeter.dao.MeterDao;
import com.jn.park.electricmeter.dao.TbElectricReadingFailLogMapper;
import com.jn.park.electricmeter.entity.TbElectricReading;
import com.jn.park.electricmeter.entity.TbElectricReadingFailLog;
import com.jn.park.electricmeter.entity.TbElectricReadingFailLogCriteria;
import com.jn.park.electricmeter.entity.TbElectricReadingSource;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.electricmeter.enums.MeterExceptionEnums;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.service.impl.NoticeManageServiceImpl;
import com.jn.system.log.annotation.ServiceLog;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    Logger logger = LoggerFactory.getLogger(MeterServiceImpl.class);

    @Override
    @ServiceLog(doAction = "电表读数定时入库")
    public void getDataFromHardare(){
        Date dealDate=DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        String hour=DateUtils.getDate("yyyy-MM-dd HH:mm:ss").split(" ")[0].split(":")[0];
        //如果是0点
        if(Integer.valueOf(hour) == 0){
            hour="23";
            //日期提前一天
            dealDate=DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        }else{
            if(Integer.valueOf(hour) -1 <10){
                hour="0"+String.valueOf(Integer.valueOf(hour) -1);
            }
        }
        Result isNeedLog = dealData(dealDate,hour,null);
        //需要保存日志，失败了
        if(! isNeedLog.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            saveFailLog(isNeedLog,hour,dealDate);
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
        TbElectricReadingFailLog logRecord = new TbElectricReadingFailLog();
        logRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
        logRecord.setCreateTime(new Date());
        logRecord.setDealHour(new Byte(hour));
        logRecord.setDealDate(dealDate);
        logRecord.setStatus(new Byte(MeterConstants.FAIL));
        logRecord.setParam(isNeedLog.getData().toString());
        logRecord.setRecordStatus(new Byte(MeterConstants.VALID));
        int result = failLogMapper.insert(logRecord);
        if(result !=1){
            logger.info("电表读数定时入库的失败日志写入失败！！！{}",logRecord.toString());
        }
    }


    /**
     * 此段逻辑为同一事务的逻辑
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Result dealData(Date dealDate,String hour,ElectricMeterDataCollectionParam parameter){
        //整个任务成功/失败的标志位：默认失败
        boolean isNotSuccess = true;
        //调用接口，获取任务失败/成功的标志位，默认没有成功
        boolean getDataIsNotSuccess = true;
        //数据已经获取完毕，默认是没有采集完毕的
        boolean isOver =false;
        //是否需要记录日志：默认是不需要的【只有失败才需要记录日志】
        Boolean isNeedLog = false;
        //保存数据没有没有成功
        boolean saveIsFail = true;
        //采集数据的结果
        Result collectionData = null;
        //当前程序最后的处理结果
        Result result  = new Result();
        result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
        //页码
        int pageIndex=1;
        int rows =10;
        //任务批次
        String taskBatch=UUID.randomUUID().toString().replaceAll("-","");
        //初始化参数
        if(parameter == null){
            parameter = getParameter();
            String startTime=DateUtils.formatDate(dealDate,"yyyy-MM-dd")+" "+hour+":00:00";
            parameter.setStartTime(startTime);
        }

        int loopNum=0;
        long sleepTime = MeterConstants.SLEEP_TIME;
        while (isNotSuccess){
            //获取到的数据
            List<ElectricMeterWaterOrElectricShow> dataList =null;
            //待保存的数据
            List<TbElectricReadingSource> readings = new ArrayList<>();
            String paramStr = parameter.toString();
            //循环获取数据
            //循环获取数据的次数
            int loopGetData =0;
            while(getDataIsNotSuccess){
                loopGetData++;
                //获取数据
                collectionData = getDataFromHardwareByPage(parameter);
                //成功
                if(collectionData.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    //取出数据
                    ElectricOrWaterConditionShow page= (ElectricOrWaterConditionShow) collectionData.getData();
                    dataList = page.getData();
                    pageIndex++;
                    if(pageIndex>Integer.parseInt(page.getPages())){
                        //数据采集完成，没有下一页了
                        isOver = true;
                    }else{
                        //设置参数,下一页，
                        parameter.setPage(pageIndex);
                    }
                    break;
                }else{
                    try{
                        //失败后睡眠
                        Thread.sleep(sleepTime*loopGetData);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    //如果达到一定次数后，仍旧没有成功，则返回需要记录日志的标志
                    if(loopGetData == 10){
                        isNeedLog = true;
                        result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
                        paramStr = parameter.toString();
                        result.setData(paramStr);
                        result.setResult("数据采集失败！！！");
                        break;
                    }else{
                        continue;
                    }
                }
            }

            if(isNeedLog){
                break;
            }

            //保存数据
            //保存数据的次数
            int saveDataTimes =0;
            while(saveIsFail){
                saveDataTimes++;
                boolean iSaveSuccess = saveData( dataList,dealDate, hour,readings, paramStr, taskBatch);
                //保存成功
                if(iSaveSuccess){
                    break;
                }else{
                    try{
                        //失败后睡眠
                        Thread.sleep(sleepTime*saveDataTimes);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    if(saveDataTimes == 10){
                        isNeedLog = true;
                        result.setCode("1000999");
                        paramStr = parameter.toString();
                        result.setData(paramStr);
                        result.setResult("采集数据保存失败！！！");
                    }else{
                        continue;
                    }
                }
            }
            if(isNeedLog){
                break;
            }

            //调用接口，采集数据已经完毕，没有下一页数据了，跳出主循环
            if(isOver){
                //将临时表中的数据更新到正式的历史表中
                int updateSize = meterDao.insertData(taskBatch);
                if(updateSize == 0 ){
                    result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
                    paramStr = parameter.toString();
                    result.setData(paramStr);
                    result.setResult("采集数据从源表到正式表的更新失败！！！");
                    break;
                }
                int updateDegreeSize = meterDao.updateDegreeDiff(taskBatch);
                if(updateDegreeSize == 0){
                    result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
                    paramStr = parameter.toString();
                    result.setData(paramStr);
                    result.setResult("正式表的累计用电量度数更新失败！！！");
                    break;
                }
                break;
            }
        }
        return result;
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
     * 保存数据的接口
     * @param dataList
     * @param hour
     * @param readings
     * @param paramStr
     * @param taskBatch
     */
    private boolean saveData(List<ElectricMeterWaterOrElectricShow> dataList,Date dealDate, String hour, List<TbElectricReadingSource> readings, String paramStr, String taskBatch){
        //保存数据的状态
        boolean isSuccess =true;
        TbElectricReadingSource reading =null;
        String dealDateStr = DateUtils.getDate("yyyy-MM-dd");
        BigDecimal readingEnd=null;
        try{
            for(ElectricMeterWaterOrElectricShow data :dataList ){
                reading = new TbElectricReadingSource();
                reading.setBuildingId(data.getBuildingId());
                reading.setCreateTime(new Date());
                reading.setDealDate(dealDate);
                reading.setDealHour(new Byte(hour));
                reading.setId(UUID.randomUUID().toString().replaceAll("-",""));
                reading.setMeterCode(data.getDeviceId());
                reading.setParam(paramStr);
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

                if(readings !=null && readings.size()>0){
                    meterDao.insertReadingData(readings);
                    readings = new ArrayList<>();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
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
    public Result dealSomeOneFailByHandle(Date dealDate,String dealHour){
        //默认没有成功
        Result result= new Result();
        String dealDateStr = DateUtils.formatDate(dealDate,"yyyy-MM-dd");
        String startTime = "";
        if(Integer.valueOf(dealHour) <10){
            startTime=dealDateStr+" "+"0"+dealHour+":00:00";
        }else {
            startTime =dealDateStr+" "+dealHour+":00:00";
        }
        //检测这条数据是失败的数据
        TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
        failLogCriteria.or().andDealDateEqualTo(dealDate).andDealHourEqualTo(new Byte(dealHour))
                .andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricReadingFailLog>  failLogs = failLogMapper.selectByExample(failLogCriteria);
        if(failLogs !=null && failLogs.size()>0){
            //初始化参数
            ElectricMeterDataCollectionParam parameter = new ElectricMeterDataCollectionParam();
            parameter.setStartTime(startTime);
            Result isNeedLog = dealData(dealDate,dealHour,parameter);
            //失败了需要保存日志
            if(! isNeedLog.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                throw new JnSpringCloudException(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL);
            }else{
                //成功了，作废掉失败的日志记录
                TbElectricReadingFailLog readingFailLog = new TbElectricReadingFailLog();
                readingFailLog.setRecordStatus(new Byte(MeterConstants.INVALID));
                failLogMapper.updateByExampleSelective(readingFailLog,failLogCriteria);
            }

        }else{
            throw new JnSpringCloudException(MeterExceptionEnums.FAIL_LOG_ISNOT_EXIST);
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "手动处理所有电表读数定时入库失败的数据")
    public Result dealAllFailByHandle(){
        //检测这条数据是失败的数据
        TbElectricReadingFailLogCriteria failLogCriteria = new TbElectricReadingFailLogCriteria();
        failLogCriteria.or().andRecordStatusEqualTo(new Byte(MeterConstants.VALID));
        List<TbElectricReadingFailLog>  failLogs = failLogMapper.selectByExample(failLogCriteria);
        List<String> resultList = new ArrayList<>();
        Result result = new Result();
        if(failLogs !=null && failLogs.size()>0){
            for(TbElectricReadingFailLog failBean : failLogs){
                //初始化参数
                ElectricMeterDataCollectionParam parameter = new ElectricMeterDataCollectionParam();
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
                Result isNeedLog = dealData(failBean.getDealDate(),dealHour,parameter);
                //失败了需要保存日志
                if(! isNeedLog.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    //记录那些没有成功
                    String turnOut = "日期："+dateStr+"处理时间："+dealHour;
                    resultList.add(turnOut);
                }else{
                    //成功了，作废掉失败的日志记录
                    TbElectricReadingFailLog readingFailLog = new TbElectricReadingFailLog();
                    readingFailLog.setRecordStatus(new Byte(MeterConstants.INVALID));
                    failLogMapper.updateByExampleSelective(readingFailLog,failLogCriteria);
                }
            }
        }

        //返回处理失败的数据
        if(resultList !=null && resultList.size()>0){
            result.setCode(MeterExceptionEnums.COLLECTION_DATA_DEAL_FAIL.getCode());
            result.setResult("存在失败记录");
            result.setData(resultList);
        }
        return result;
    }
}
