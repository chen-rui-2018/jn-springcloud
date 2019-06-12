package com.jn.miniprogram.base.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.file.MultipartFileUtil;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import com.jn.upload.api.UploadClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 上传小程序码图片至Fastdfs服务器
 *
 * @Author： cm
 * @Date： Created on 2019/3/20 19:09
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class QrcodeUploadFileToFastdfs {

    @Autowired
    private UploadClient uploadClient;

    /**
     * 上传小程序码图片至Fastdfs服务器
     * @param file
     * @return 返回小程序码完成路径
     */
    public String uploadFileByFastdfs(File file) {
        if(null == file) {
            return null;
        }
        MultipartFile multipartFile = MultipartFileUtil.from(file,null);
        Result<String> result;
        try {
            result = uploadClient.uploadFile(multipartFile,Boolean.FALSE,"");
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.FAST_DFS_UPLOAD_FAIL);
        }
        return result.getData();
    }

}
