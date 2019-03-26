package com.jn.api;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.oa.api.OaClient;
import com.jn.oa.email.service.EmailService;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.oa.model.Email;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供内部使用的API接口
 *
 * @author： yuanyy
 * @date： Created on 2019/3/7 18:09
 * @version： v1.0
 * @modified By:
 */
@RestController
public class OaController extends BaseController implements OaClient {
    private static Logger logger = LoggerFactory.getLogger(OaController.class);

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private WorkPlanService workPlanService;

    /**
     * 定时十分钟通知会议申请人
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "定时十分钟通知会议申请人")
    public Result<String> noticesApplicationMeeting() {
        logger.info("进入定时十分钟通知会议申请人");
        meetingService.noticesApplicationMeeting();
        return new Result();
    }

    /**
     * 更新会议状态运行中
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "更新会议状态运行中")
    public Result<String> updateMeetingStatusByTime() {
        logger.info("更新会议状态");
        meetingService.updateMeetingStatusByTime();
        return new Result();
    }

    /**
     * 一键Email定时发送接口
     *
     * @param email
     * @return
     */
    @Override
    @ControllerLog(doAction = "一键Email定时发送接口")
    public Result<Boolean> regularSendEmail(@RequestBody Email email) {
        Boolean result = emailService.regularSendEmail(email);
        return new Result(result);
    }

    /**
     * 工作计划提醒功能,每天定时提醒用户
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "工作计划提醒功能")
    public Result<Boolean> workPlanRemindEveryDay() {
        Boolean result = workPlanService.workPlanRemindEveryDay();
        return new Result<>(result);
    }

    /**
     * 每天陵城两点自动更新工作计划状态
     *
     * @return
     */
    @Override
    public Result<Boolean> updateWorkPlanStatus() {
        workPlanService.updateWorkPlanIsExpire();
        return new Result<>(true);
    }


}
