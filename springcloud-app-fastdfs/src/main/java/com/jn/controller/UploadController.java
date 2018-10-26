package com.jn.controller;

import com.jn.common.model.Result;
import com.jn.config.FastDfsClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private FastDfsClientWrapper fastDfsClientWrapper;


    @RequestMapping("fastUpload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws IOException{
        Assert.notNull(file,"文件不能为空");
        Result<String> result = new Result();
        result.setData(fastDfsClientWrapper.uploadFile(file));
        return result;
    }




}
