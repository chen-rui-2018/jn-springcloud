package com.jn.server;

import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.config.FastDfsUploadClient;
import com.jn.upload.api.UploadClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 内部rest接口
 *
 * @author： fengxh
 * @date： Created on 2018/10/25 19:21
 * @version： v1.0
 * @modified By:
 */
@RestController
public class UploadClientController implements UploadClient {


    @Autowired
    private FastDfsUploadClient fastDfsUploadClient;

    @Override
    public Result<String> uploadFile(@RequestPart("file") MultipartFile file,
                             @RequestParam("token") Boolean token) throws IOException{
        Assert.notNull(file,"文件不能为空");
        Result<String> result = new Result();
        if (token){
            result.setData(fastDfsUploadClient.uploadNeedTokenFile(file));
        }else{
            result.setData(fastDfsUploadClient.uploadFile(file));
        }
        return result;
    }
}
