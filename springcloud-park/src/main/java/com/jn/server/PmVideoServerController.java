package com.jn.server;

import com.jn.common.model.Result;
import com.jn.park.api.PmVideoClient;
import com.jn.park.video.service.PmVideoService;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 安防录像server
 *
 * @author： shaobao
 * @date： Created on 2019/5/29 15:49
 * @version： v1.0
 * @modified By:
 **/
@RestController
public class PmVideoServerController implements PmVideoClient {

    @Autowired
    private PmVideoService pmVideoService;

    @Override
    @ControllerLog(doAction = "对录像赋权超过7天的录像,清除查看权限")
    public Result<Boolean> updateVideoInfo() {
        pmVideoService.updateVideoInfo();
        return new Result<>(true);
    }
}
