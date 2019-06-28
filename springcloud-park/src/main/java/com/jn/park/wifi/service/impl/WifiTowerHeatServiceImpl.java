package com.jn.park.wifi.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.SdnwareApClient;
import com.jn.hardware.model.sdnware.heat.HeatInfo;
import com.jn.hardware.model.sdnware.heat.HeatMessage;
import com.jn.hardware.model.sdnware.heat.HeatResult;
import com.jn.park.wifi.dao.TbWifiHeatInfoRecordMapper;
import com.jn.park.wifi.dao.TbWifiTowerHeatInfoMapper;
import com.jn.park.wifi.dao.WifiTowerHeatDao;
import com.jn.park.wifi.entity.TbWifiHeatInfoRecord;
import com.jn.park.wifi.entity.TbWifiTowerHeatInfo;
import com.jn.park.wifi.entity.TbWifiTowerHeatInfoCriteria;
import com.jn.park.wifi.service.WifiTowerHeatService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/28
 * </pre>
 */
@Service
public class WifiTowerHeatServiceImpl implements WifiTowerHeatService {
    private static Logger logger = LoggerFactory.getLogger(WifiTowerHeatServiceImpl.class);
    @Autowired
    private TbWifiHeatInfoRecordMapper tbWifiHeatInfoRecordMapper;
    @Autowired
    private TbWifiTowerHeatInfoMapper tbWifiTowerHeatInfoMapper;
    @Autowired
    private WifiTowerHeatDao wifiTowerHeatDao;
    @Autowired
    private SdnwareApClient sdnwareApClient;

    //匹配连续中文开头的中文内容（楼宇名称）
    private String reg = "[1-9]?[\\u4e00-\\u9fa5]+";
    //将规则封装成对象。
    Pattern pattern = Pattern.compile(reg);

    @ServiceLog(doAction = "采集wifi热力图信息")
    @Override
    public Result collectionHeatInfo() {
        Result<HeatResult> heatResultResult=sdnwareApClient.getMapHeat();
        if(!StringUtils.equals(heatResultResult.getCode(), GlobalConstants.SUCCESS_CODE)){
            logger.info("wifi热力图信息采集失败{}",heatResultResult);
            return heatResultResult ;
        }

        //各楼宇最新的wifi热点信息
        TbWifiTowerHeatInfoCriteria heatInfoCriteria =new TbWifiTowerHeatInfoCriteria();
        List<TbWifiTowerHeatInfo> heatInfoList=tbWifiTowerHeatInfoMapper.selectByExample(heatInfoCriteria);

        int recordCount=0;
        int towerCount=0;
        String batchId=DateUtils.getDate("yyyyMMddHHmmssSSS");
        for(HeatMessage heatMessage:heatResultResult.getData().getMessage()){
            recordCount+=this.insertBatchRecord(batchId,heatMessage.getPositions(),heatInfoList);
        }
        towerCount=this.updateTowerHeatInfo(batchId);
        String msg=String.format("成功采集了%s条数据,成功更新%s栋楼宇的热点数量",recordCount,towerCount);
        logger.info(msg);
        return new Result(msg);
    }

    @ServiceLog(doAction = "更新楼宇的热点数量")
    public int updateTowerHeatInfo(String batchId){
        List<TbWifiTowerHeatInfo>recordGroupList= wifiTowerHeatDao.recordGroupByBatchId(batchId);
        int count=0;
        for(TbWifiTowerHeatInfo heatInfo:recordGroupList){
            TbWifiTowerHeatInfo record=new TbWifiTowerHeatInfo();
            record.setCount(heatInfo.getCount());
            record.setDeviceCount(heatInfo.getDeviceCount());
            record.setUpdateTime(new Date());
            TbWifiTowerHeatInfoCriteria criteria=new TbWifiTowerHeatInfoCriteria();
            criteria.createCriteria().andApNameTowerEqualTo(heatInfo.getApNameTower());
            int updateCount=tbWifiTowerHeatInfoMapper.updateByExampleSelective(record,criteria);
            logger.info("更新了楼宇【{}】的wifi热力图信息，热点数量count更新为{}",heatInfo.getApNameTower(),heatInfo.getCount());
            if(updateCount==0){
                logger.info("更新成功数为0时，说明AP热点对应的楼宇名 不存在，需要新增加一条");
                record.setId(UUID.randomUUID().toString());
                record.setCreateBy("system");
                record.setCreateTime(new Date());
                record.setApNameTower(heatInfo.getApNameTower());
                int insertCount=tbWifiTowerHeatInfoMapper.insertSelective(record);
                logger.info("新增了{}个AP热点对应的楼宇",insertCount);
            }
            count+=updateCount;
        }
        logger.info("成功更新了{}个楼宇的热点数量",count);
        return count;
    }

    @ServiceLog(doAction = "wifi热力图信息入库")
    private int insertBatchRecord(String batchId,List<HeatInfo> heatInfoList,List<TbWifiTowerHeatInfo> configList){
        if(heatInfoList.size()==0){
            return 0;
        }
        Date createTime=new Date();
        int count=0;
        List<TbWifiHeatInfoRecord>recordList=new ArrayList<>();
        for(HeatInfo heatInfo:heatInfoList){
            TbWifiHeatInfoRecord record=new TbWifiHeatInfoRecord();
            record.setDevice(heatInfo.getDevice());
            record.setApName(heatInfo.getName());
            record.setCount(Integer.parseInt(heatInfo.getCount()));
            record.setId(UUID.randomUUID().toString());
            record.setCreateTime(createTime);
            record.setBatchId(batchId);
            String apNameTower=this.getApNameTower(heatInfo.getName());
            TbWifiTowerHeatInfo towerConfig=this.towerIdByMatchName(configList,apNameTower);
            record.setApNameTower(apNameTower);
            if(null!=towerConfig){
               record.setTowerId(towerConfig.getTowerId());
            }
            recordList.add(record);
        }
        count= wifiTowerHeatDao.insertBatchRecord(recordList);
        return count;
    }

    @ServiceLog(doAction = "匹配apName对应楼宇名")
    private String getApNameTower(String apName){
        Matcher matcher=pattern.matcher(apName);
        if(matcher.find()){
            return matcher.group();
        }
        return null;
    }

    /**
     * 根据AP名 找到 楼宇信息
     * @param configList
     * @param apNameTower
     * @return
     */
    private TbWifiTowerHeatInfo towerIdByMatchName(List<TbWifiTowerHeatInfo> configList,String apNameTower){
        for(TbWifiTowerHeatInfo config:configList){
            if(StringUtils.equals(config.getApNameTower(),apNameTower)){
                return config;
            }
        }
        return null;
    }



}
