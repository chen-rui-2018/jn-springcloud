package com.jn.user.server;

import com.github.tobato.fastdfs.domain.StorePath;
import com.jn.config.FastDfsDownClient;
import com.jn.down.api.DownLoadClient;
import com.jn.down.model.DownLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供内部调用的下载接口
 *
 * @author： fengxh
 * @date： Created on 2018/12/6 15:51
 * @version： v1.0
 * @modified By:
 */
@RestController
public class DownLoadClientController implements DownLoadClient {

    @Autowired
    private FastDfsDownClient fastDfsDownClient;


    @Override
    public ResponseEntity<byte[]> downLoad(@RequestBody DownLoad downLoad) {
        StorePath storePath ;
        storePath = StorePath.praseFromUrl(downLoad.getUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/octet-stream");
        headers.add("Connection", "close");
        headers.add("Accept-Ranges", "bytes");
        headers.add("Content-Disposition", "attachment");
        return new ResponseEntity<>(fastDfsDownClient.downloadFile(storePath,downLoad.getToken()), headers, HttpStatus.OK);
    }
}
