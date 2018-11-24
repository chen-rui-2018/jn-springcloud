package com.jn.controller;

import com.jn.common.model.Result;
import com.jn.config.FastDfsUploadClient;
import org.springframework.beans.factory.annotation.Autowired;
import com.jn.common.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传controller
 *
 * @author： fengxh
 * @date： Created on 2018/10/25 19:21
 * @version： v1.0
 * @modified By:
 */
@RestController
public class UploadController {

    @Autowired
    private FastDfsUploadClient fastDfsUploadClient;

    /**
     * 不需要登录的上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/guest/upload/fastUpload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws IOException{
        Assert.notNull(file,"文件不能为空");
        Result<String> result = new Result();
        result.setData(fastDfsUploadClient.uploadFile(file));
        return result;
    }
    /**
     * 需要登录的上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload/fastUpload")
    public Result<String> uploadByLogin(@RequestParam("file") MultipartFile file) throws IOException{
        Assert.notNull(file,"文件不能为空");
        Result<String> result = new Result();
        result.setData(fastDfsUploadClient.uploadFile(file));
        return result;
    }
    /**
     * 需要登录的上传（下载需要token）
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload/token/fastUpload")
    public Result<String> uploadByLoginUseToken(@RequestParam("file") MultipartFile file) throws IOException{
        Assert.notNull(file,"文件不能为空");
        Result<String> result = new Result();
        result.setData(fastDfsUploadClient.uploadNeedTokenFile(file));
        return result;
    }
}
