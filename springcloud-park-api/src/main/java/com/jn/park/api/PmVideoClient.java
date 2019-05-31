package com.jn.park.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 安防录像服务客户端
 *
 * @author： shaobao
 * @date： Created on 2019/5/29 15:46
 * @version： v1.0
 * @modified By:
 **/
@FeignClient("springcloud-park")
public interface PmVideoClient {

    /**
     * 每天凌晨一点检测,清除安防录像赋权超过7天的视屏播放信息
     *
     * @return
     */
    @RequestMapping(value = "/api/pmVideo/updateVideoInfo", method = RequestMethod.POST)
    Result<Boolean> updateVideoInfo();

}
