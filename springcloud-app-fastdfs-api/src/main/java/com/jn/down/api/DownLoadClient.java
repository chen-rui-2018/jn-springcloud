package com.jn.down.api;

import com.jn.down.model.DownLoad;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 下载接口
 *
 * @author： fengxh
 * @date： Created on 2018/12/06 15:31
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-app-fastdfs")
public interface DownLoadClient {

    /**
     * 文件下载
     * @param var
     * @return
     */
    @RequestMapping(value = "/api/getFile", method = RequestMethod.POST)
    ResponseEntity<byte[]> downLoad(@RequestBody DownLoad var);


}