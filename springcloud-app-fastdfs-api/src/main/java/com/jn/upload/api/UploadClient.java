package com.jn.upload.api;

import com.jn.common.util.file.MultipartSupportConfig;
import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传文件接口
 *configuration  是对文件通信的特殊加入，其他普通的FeignClient，不需要加入configuration
 * @author： fengxh
 * @date： Created on 2018/12/06 15:31
 * @version： v1.0
 * @modified By:
 */
@FeignClient(value = "springcloud-app-fastdfs" ,configuration = MultipartSupportConfig.class)
public interface UploadClient {

    /**
     * 文件上传
     * @param file  文件
     * @param token 是否需要token下载
     * @return  返回一个http可访问的路径地址
     */
    @RequestMapping(value = "/api/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    Result<String> uploadFile(@RequestPart("file") MultipartFile file,
                              @RequestParam("token") Boolean token) throws IOException;
}