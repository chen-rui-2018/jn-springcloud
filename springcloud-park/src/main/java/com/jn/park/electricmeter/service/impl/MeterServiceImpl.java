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
import com.jn.park.electricmeter.entity.TbElectricReading;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.service.impl.NoticeManageServiceImpl;
import com.jn.system.log.annotation.ServiceLog;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    Logger logger = LoggerFactory.getLogger(MeterServiceImpl.class);

    @Override
    @ServiceLog(doAction = "电表读数定时入库")
    public void getDataFromHardare() throws JnSpringCloudException {
        //每隔一小时执行一次，当前这小时，应该获取

        //设备编号
        String code="";
        //类型
        String type= ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getCode();
        //传入日期
        /*
        String timeStr = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
        String[] dateStrAry =timeStr.split(" ");
        String[] timeStrAry = dateStrAry[1].split(":");
        if(timeStrAry[0]=="00"){
            timeStrAry
        }else{

        }


        String startTime =timeStr.split(":")[0]+":"+":00";
        */
        String[] test ={"2019-05-15 07:00:00","2019-05-15 08:00:00","2019-05-15 09:00:00","2019-05-15 10:00:00","2019-05-15 11:00:00","2019-05-15 12:00:00"};
        String[] testHour ={"07","08","09","10","11","12"};


        for(int i=0;i<test.length;i++){


            ElectricMeterDataCollectionParam parameter = getTimerParam("",ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getCode(),test[i]);
            //ElectricMeterDataCollectionParam parameter = getTimerParam(code,type,startTime);
            Result result = null;
            parameter.setRows(110);
            result = electricMeterClient.electricMeterDataCollection(parameter);
            ElectricOrWaterConditionShow page= (ElectricOrWaterConditionShow) result.getData();
            if(! result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                logger.info(test[i]+testHour[i]+"调用失败！！！");
            }

            logger.info(test[i]+testHour[i]+"总条数："+((ElectricOrWaterConditionShow) result.getData()).getTotal());
            for(int pageIndex=1;pageIndex<=Integer.parseInt(page.getPages());pageIndex++){
                parameter.setRows(110);
                parameter.setPage(pageIndex);
                result = electricMeterClient.electricMeterDataCollection(parameter);
                List<TbElectricReading> readings = new ArrayList<>();
                if(result.getData() != null){
                    ElectricOrWaterConditionShow data1= (ElectricOrWaterConditionShow) result.getData();
                    List<ElectricMeterWaterOrElectricShow> dataList = data1.getData();
                    if(dataList !=null && dataList.size() >0){

                        TbElectricReading reading =null;
                        Date date = new Date();
                        String dealDateStr = DateUtils.getDate("yyyy-MM-dd");
                        Date dealDate = null;
                        Date dealDateDrag = null;
                        BigDecimal readingEnd=null;
                        try{
                            dealDate = DateUtils.parseDate(dealDateStr,"yyyy-MM-dd");

                            dealDateDrag = DateUtils.parseDate("2019-05-15","yyyy-MM-dd");
                        }catch (ParseException e){
                            e.printStackTrace();
                            logger.info("日期格式不规范-转换错误");
                            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TIME_PARSE_DEFAULT);
                        }

                        for(ElectricMeterWaterOrElectricShow data :dataList ){
                            reading = new TbElectricReading();
                            reading.setBuildingId(data.getBuildingId());
                            reading.setCreateTime(date);

                            //reading.setDealDate(dealDate);
                            reading.setDealDate(dealDateDrag);
                            reading.setDealHour(new Byte(testHour[i]));
                            reading.setId(UUID.randomUUID().toString().replaceAll("-",""));
                            reading.setMeterCode(data.getDeviceId());
                            reading.setParam(parameter.toString());
                            reading.setRecordStatus(new Byte("1"));
                            readingEnd = new BigDecimal(data.getReadingEnd());
                            reading.setReadingEnd(readingEnd );
                            Date timeEnd=null;
                            try{
                                timeEnd = DateUtils.parseDate(data.getTimeEnd(),"yyyy-MM-dd HH:mm:ss");
                            }catch (ParseException e){
                                e.printStackTrace();
                                logger.info("日期格式不规范-转换错误");
                                throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TIME_PARSE_DEFAULT);
                            }
                            reading.setTimeEnd(timeEnd);
                            reading.setStatus(new Byte("1"));
                            reading.setStatusMsg("成功");
                            readings.add(reading);

                            if(readings !=null && readings.size()==400){
                                meterDao.insertReadingData(readings);
                                readings = new ArrayList<>();
                            }
                        }
                    }
                }

                if(readings !=null && readings.size()>0){
                    meterDao.insertReadingData(readings);
                }
            }


        }

    }

    @Override
    @ServiceLog(doAction = "手动处理电表读数定时入库失败的数据")
    public void getDataFromHardareByHandle(String code,String type,String startTime){
        //查询出失败的数据

        //获取出参数

        //整理参数，

        //开始处理
    }



    /**
     * 整理参数
     * @param code
     * @param type
     * @param startTime
     * @return
     */
    private ElectricMeterDataCollectionParam getTimerParam(String code,String type,String startTime){
        ElectricMeterDataCollectionParam parameter = new ElectricMeterDataCollectionParam();
        if(StringUtils.isNotBlank(code)){
            parameter.setCode(code);
        }else{
            parameter.setDeviceType(type);
        }
        if(StringUtils.isBlank(startTime)){
            //todo throw new JnSpringCloudException("");,时间不能为空
        }
        parameter.setStartTime(startTime);
        return parameter;
    }
}
