package com.jn.park.video.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.*;
import com.jn.park.video.dao.TbPmVideoItemMapper;
import com.jn.park.video.dao.TbPmVideoMapper;
import com.jn.park.video.dao.TbVideoInfoMapper;
import com.jn.park.video.dao.VideoInfoMapper;
import com.jn.park.video.enmus.TowerEnums;
import com.jn.park.video.entity.TbPmVideo;
import com.jn.park.video.entity.TbPmVideoItem;
import com.jn.park.video.entity.TbVideoInfo;
import com.jn.park.video.model.PmVideoItem;
import com.jn.park.video.service.PmVideoService;
import com.jn.park.video.vo.PmVideoVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.juli.DateFormatCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： shaobao
 * @date： Created on 2019/5/17 9:47
 * @version： v1.0
 * @modified By:
 **/
@Service
public class PmVideoServiceImpl implements PmVideoService {
    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(PmVideoServiceImpl.class);

    @Autowired
    private SecurityVideoClient securityVideoClient;

    @Autowired
    private TbVideoInfoMapper tbVideoInfoMapper;

    @Autowired
    private VideoInfoMapper videoInfoMapper;

    @Autowired
    private TbPmVideoItemMapper tbPmVideoItemMapper;

    @Autowired
    private TbPmVideoMapper tbPmVideoMapper;

    /**
     * 添加安防录像设备信息
     */
    @Override
    @ServiceLog(doAction = "添加安防录像设备信息")
    @Transactional(rollbackFor = Exception.class)
    public void insertVideoInfos() {
        //调用硬件接口client,获取所有安防监控设备信息
        SecurityMonitoringPointParam securityMonitoringPointParam = new SecurityMonitoringPointParam();
        securityMonitoringPointParam.setPageNo(1);
        securityMonitoringPointParam.setPageSize(500);
        Result<SecurityMonitoringPointShow> securityMonitoringPointList =
                securityVideoClient.findSecurityMonitoringPointList(securityMonitoringPointParam);

        //对监控数据进行分析
        SecurityMonitoringPointShow data = securityMonitoringPointList.getData();
        //获取所有监控信息集合
        List<SecurityMonitoringPoint> securityMonitoringPoints = data.getList();
        if (securityMonitoringPoints != null) {
            //1.逻辑删除监控设备表中所有数据
            //videoInfoMapper.updateStatusBatch();

            //2.分析表单安防数据
            for (SecurityMonitoringPoint securityMonitoringPoint : securityMonitoringPoints) {
                //获取监控唯一标识
                String cameraIndexCode = securityMonitoringPoint.getCameraIndexCode();
                //获取监控名称
                String cameraName = securityMonitoringPoint.getCameraName();
                //为安防设备对象添加信息
                TbVideoInfo tbVideoInfo = new TbVideoInfo();
                tbVideoInfo.setId(cameraIndexCode);
                tbVideoInfo.setCode(cameraIndexCode);
                tbVideoInfo.setName(cameraName);
                tbVideoInfo.setRecordStatus(new Byte(RecordStatusEnum.EFFECTIVE.getCode()));
                tbVideoInfo.setCreateTime(new Date());

                //根据设备名称，判断设备楼宇信息，设施父节点id
                if (cameraName.startsWith("1号楼") || cameraName.startsWith("国际人才")) {
                    tbVideoInfo.setParentId(TowerEnums.FIRST_TOWER.getCode());
                    tbVideoInfo.setAddress(TowerEnums.FIRST_TOWER.getMessage());
                    tbVideoInfo.setTowerName(TowerEnums.FIRST_TOWER.getMessage());
                } else if (cameraName.startsWith("金融中心")) {
                    tbVideoInfo.setParentId(TowerEnums.SECOND_TOWER.getCode());
                    tbVideoInfo.setAddress(TowerEnums.SECOND_TOWER.getMessage());
                    tbVideoInfo.setTowerName(TowerEnums.SECOND_TOWER.getMessage());
                } else if (cameraName.startsWith("3号楼")) {
                    tbVideoInfo.setParentId(TowerEnums.THIRD_TOWER.getCode());
                    tbVideoInfo.setAddress(TowerEnums.THIRD_TOWER.getMessage());
                    tbVideoInfo.setTowerName(TowerEnums.THIRD_TOWER.getMessage());
                } else if (cameraName.startsWith("4号楼")) {
                    tbVideoInfo.setParentId(TowerEnums.FOURTH_TOWER.getCode());
                    tbVideoInfo.setAddress(TowerEnums.FOURTH_TOWER.getMessage());
                    tbVideoInfo.setTowerName(TowerEnums.FOURTH_TOWER.getMessage());
                } else {
                    tbVideoInfo.setParentId(TowerEnums.FIFTH_TOWER.getCode());
                    tbVideoInfo.setAddress(TowerEnums.FIFTH_TOWER.getMessage());
                    tbVideoInfo.setTowerName(TowerEnums.FIFTH_TOWER.getMessage());
                }

                //插入数据
                tbVideoInfoMapper.insertSelective(tbVideoInfo);
            }
        }
        logger.info("[物业] 安防录像设备信息导入成功，导入信息：{}", securityMonitoringPoints);

    }

    /**
     * 物业-安防录像申请赋权处理
     *
     * @param pmVideoVo
     * @param user
     * @return
     */
    @Override
    @ServiceLog(doAction = "物业-安防录像申请赋权处理")
    @Transactional(rollbackFor = Exception.class)
    public Integer pmVideoApplyHandler(PmVideoVo pmVideoVo, User user) {
        Integer result = 0;

        //1.获取传入数据的子表数据
        if (pmVideoVo != null) {

            String id = pmVideoVo.getId();
            List<PmVideoItem> tb_pm_video_item = pmVideoVo.getTb_pm_video_item();
            if (tb_pm_video_item != null) {
                //如果子表数据不为空，则分析子表中信息
                for (PmVideoItem pmVideoItem : tb_pm_video_item) {
                    //用于拼接监控点名及监控点播放地址
                    StringBuffer buffer = new StringBuffer();

                    TbPmVideoItem tbPmVideoItem = new TbPmVideoItem();
                    String itemId = pmVideoItem.getId();
                    //获取监控点名称
                    String videoPlayUrl = pmVideoItem.getVideoPlayUrl();
                    //获取监控点唯一标识
                    String operation = pmVideoItem.getOperation();
                    //获取录像开始时间
                    Date videoStartTime = pmVideoItem.getVideoStartTime();
                    //获取录像截止时间
                    Date videoEndTime = pmVideoItem.getVideoEndTime();

                    if (StringUtils.isNotBlank(videoPlayUrl) && StringUtils.isNotBlank(operation)) {
                        String beginTime;
                        String endTime;
                        //对录像时间进行格式化
                        if (videoStartTime != null && videoEndTime != null) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                            beginTime = sdf.format(videoStartTime);
                            endTime = sdf.format(videoEndTime);
                        } else {
                            logger.warn("[安防录像] 录像开始时间或结束时间为空,跳过录像请求,videoId:{},itemId:{}", id, itemId);
                            continue;
                        }
                        String[] videoName = videoPlayUrl.split(",");
                        String[] videoCode = operation.split(",");
                        //获取所有监控点播放路径
                        for (int i = 0; i < videoCode.length; i++) {
                            String videoIndexCode = videoCode[i];

                            //录像地址
                            String PlayBackUrl = "暂无录像";
                            Result<SecurityPlayBackUrlShow> securityPlayBackUrl = getSecurityPlayBackUrlShowResult(beginTime, endTime, videoIndexCode);

                            //获取返回的旅行播放地址
                            if (StringUtils.isNotBlank(securityPlayBackUrl.getData().getUrl())) {
                                PlayBackUrl = securityPlayBackUrl.getData().getUrl();
                            }

                            //由于页面是文本域,使用/n进行换行处理
                            buffer.append(videoName[i]).append(":").append(PlayBackUrl).append("\n");
                        }

                        //将播放路径更新值数据库
                        pmVideoItem.setVideoPlayUrl(buffer.substring(0, buffer.length() - 1));
                        BeanUtils.copyProperties(pmVideoItem, tbPmVideoItem);
                        tbPmVideoItemMapper.updateByPrimaryKeySelective(tbPmVideoItem);
                    } else {
                        logger.info("[安防录像] 当前申请明细中未赋权监控点,videoId:{},itemId:{}", id, itemId);
                        continue;
                    }
                }

            }
            logger.info("[安防录像] 录像赋权成功,videoId:{}", id);
        }

        //更新赋权完成时间
        pmVideoVo.setFlowCompleteTime(new Date());
        TbPmVideo tbPmVideo = new TbPmVideo();
        BeanUtils.copyProperties(pmVideoVo,tbPmVideo);
        tbPmVideo.setFlowStatus(new Byte(RecordStatusEnum.EFFECTIVE.getCode()));
        tbPmVideoMapper.updateByPrimaryKeySelective(tbPmVideo);

        return result += 1;
    }

    /**
     * 调用硬件服务,获取录像播放路径
     *
     * @param beginTime
     * @param endTime
     * @param videoIndexCode
     * @return
     */
    private Result<SecurityPlayBackUrlShow> getSecurityPlayBackUrlShowResult(String beginTime, String endTime, String videoIndexCode) {
        SecurityPlayBackUrlParam securityPlayBackUrlParam = new SecurityPlayBackUrlParam();
        securityPlayBackUrlParam.setCameraIndexCode(videoIndexCode);
        securityPlayBackUrlParam.setBeginTime(beginTime);
        securityPlayBackUrlParam.setEndTime(endTime);
        securityPlayBackUrlParam.setExpand("streamform=rtp");
        return securityVideoClient.findSecurityPlayBackUrlList(securityPlayBackUrlParam);
    }
}
