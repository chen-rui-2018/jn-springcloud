package com.jn.hardware.ding.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.util.RestTemplateUtil;
import com.jn.hardware.ding.service.DingTalkAttendanceService;
import com.jn.hardware.ding.service.DingTalkInRedisConfigStorage;
import com.jn.hardware.model.dingtalk.attendance.*;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：钉钉：考勤相关接口实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 14:08
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class DingTalkAttendanceServiceImpl implements DingTalkAttendanceService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DingTalkInRedisConfigStorage dingTalkInRedisConfigStorage;



    /**
     * 获取打卡结果列表
     * @param clockInInfoParam
     * @return
     */
    @Override
    public ClockInListResult getClockInResultList(ClockInListParam clockInInfoParam) {
        logger.info("\n获取打卡结果列表,入参:【{}】",clockInInfoParam);
        //url 加上access_token
        String url = String.format(DingTalkAttendanceService.GET_CLOCK_IN_RESULT_LIST_URL,dingTalkInRedisConfigStorage.getAccessToken());
        String jsonParam = JsonStringToObjectUtil.objectToJson(clockInInfoParam);
        logger.info("\n获取打卡结果列表, 请求地址:【{}】   \n请求接口参数:【{}】    ",url,jsonParam);
        String resultJson =  RestTemplateUtil.post(url,jsonParam);
        logger.info("\n获取打卡结果列表,接口响应:【{}】",resultJson);
        ClockInListResult clockInInfoResult = JsonStringToObjectUtil.jsonToObject(resultJson,new TypeReference<ClockInListResult>(){});
        logger.info("\n获取打卡结果列表,响应结果clockInInfoResult:【{}】",clockInInfoResult);
        return clockInInfoResult;
    }

    /**
     * 获取请假状态列表
     * @param leaveStatusListParam
     * @return
     */
    @Override
    public LeaveStatusListResult getLeaveStatusList(LeaveStatusListParam leaveStatusListParam) {
        logger.info("\n获取请假状态列表,入参:【{}】",leaveStatusListParam);
        //url 加上access_token
        String url = String.format(DingTalkAttendanceService.GET_LEAVE_STATUS_LIST_URL,dingTalkInRedisConfigStorage.getAccessToken());
        String jsonParam = JsonStringToObjectUtil.objectToJson(leaveStatusListParam);
        logger.info("\n获取请假状态列表, 请求地址:【{}】   \n请求接口参数:【{}】    ",url,jsonParam);
        String resultJson =  RestTemplateUtil.post(url,jsonParam);
        logger.info("\n获取请假状态列表,接口响应:【{}】",resultJson);
        LeaveStatusListResult leaveStatusListResult = JsonStringToObjectUtil.jsonToObject(resultJson,new TypeReference<LeaveStatusListResult>(){});
        logger.info("\n获取请假状态列表,响应结果leaveStatusListResult:【{}】",leaveStatusListResult);
        return leaveStatusListResult;
    }

    /**
     * 获取请假时长
     * @param leaveApproveDurationParam
     * @return
     */
    @Override
    public LeaveApproveDurationResult getLeaveApproveDuration(LeaveApproveDurationParam leaveApproveDurationParam) {
        logger.info("\n获取请假时长,入参:【{}】",leaveApproveDurationParam);
        //url 加上access_token
        String url = String.format(DingTalkAttendanceService.GET_LEAVE_APPROVE_DURATION_URL,dingTalkInRedisConfigStorage.getAccessToken());
        String jsonParam = JsonStringToObjectUtil.objectToJson(leaveApproveDurationParam);
        logger.info("\n获取请假时长, 请求地址:【{}】   \n请求接口参数:【{}】    ",url,jsonParam);
        String resultJson =  RestTemplateUtil.post(url,jsonParam);
        logger.info("\n获取请假时长,接口响应:【{}】",resultJson);
        LeaveApproveDurationResult leaveApproveduRationResult = JsonStringToObjectUtil.jsonToObject(resultJson,new TypeReference<LeaveApproveDurationResult>(){});
        logger.info("\n获取请假时长,响应结果leaveStatusListResult:【{}】",leaveApproveduRationResult);
        return leaveApproveduRationResult;

    }

}
