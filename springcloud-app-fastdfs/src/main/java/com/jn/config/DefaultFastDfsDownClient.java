package com.jn.config;

import com.github.tobato.fastdfs.context.TokenContext;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.GenerateStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 文件下载
 *
 * @author： fengxh
 * @date： Created on 2018/12/6 15:35
 * @version： v1.0
 * @modified By:
 */
@Service
public class DefaultFastDfsDownClient implements FastDfsDownClient{

    private static Logger logger = LoggerFactory.getLogger(DefaultFastDfsDownClient.class);
    @Autowired
    @Qualifier("defaultGenerateStorageClient")
    private GenerateStorageClient generateStorageClient;

    @Override
    public byte[] downloadFile(StorePath storePath ,Boolean isToken){
        TokenContext.setContext(isToken);
        DownloadCallback<byte[]> callback = new DownloadByteArray();
        byte[] result = null;
        try{
            result = generateStorageClient.downloadFile(storePath.getGroup(),storePath.getPath(),callback) ;
        }catch (Exception e ){
            logger.error("文件下载",e);
        }
        return result;
    }

}
