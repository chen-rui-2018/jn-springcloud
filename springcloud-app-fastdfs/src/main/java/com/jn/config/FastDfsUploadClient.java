package com.jn.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传文件
 *
 * @author： fengxh
 * @date： Created on 2018/11/2 16:01
 * @version： v1.0
 * @modified By:
 */
public interface FastDfsUploadClient {


    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    String uploadFile(MultipartFile file) throws IOException;

    /**
     * 上传需要密钥的文件
     * @param file
     * @return
     * @throws IOException
     */
    String uploadNeedTokenFile(MultipartFile file) throws IOException;
}
