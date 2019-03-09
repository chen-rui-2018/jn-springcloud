package com.jn.oa.api;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.oa.meeting.service.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 定时十分钟通知会议申请人
     *
     * @return
     */
    @Override
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
    public Result<String> updateMeetingStatusByTime() {
        meetingService.updateMeetingStatusByTime();
        return new Result();
    }


}
