package com.jn.api;

import com.github.tobato.fastdfs.context.TokenContext;
import com.github.tobato.fastdfs.domain.StorePath;
import com.jn.common.model.Result;
import com.jn.config.FastDfsDownClient;
import com.jn.domain.DownLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * 提供内部调用的下载接口
 *
 * @author： fengxh
 * @date： Created on 2018/12/6 15:51
 * @version： v1.0
 * @modified By:
 */
@RestController
public class DownloadController {

    @Autowired
    private FastDfsDownClient fastDfsDownClient;


    @RequestMapping("/api/getFile")
    public ResponseEntity<byte[]> getFile(@RequestBody DownLoad downLoad) throws Throwable {
        StorePath storePath ;
        try{
            storePath = StorePath.praseFromUrl(downLoad.getUrl());
        }catch (Exception e){
            throw new Throwable(e.getMessage());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/octet-stream");
        headers.add("Connection", "close");
        headers.add("Accept-Ranges", "bytes");
        headers.add("Content-Disposition", "attachment");
        return new ResponseEntity<>(fastDfsDownClient.downloadFile(storePath,downLoad.getToken()), headers, HttpStatus.OK);

    }



}
