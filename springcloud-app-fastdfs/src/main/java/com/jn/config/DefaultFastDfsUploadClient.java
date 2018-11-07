package com.jn.config;

import com.github.tobato.fastdfs.context.TokenContext;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.jn.common.util.GlobalConstants;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 上传工具类
 *
 * @author： fengxh
 * @date： Created on 2018/10/25 15:37
 * @version： v1.0
 * @modified By:
 */
@Component
public class DefaultFastDfsUploadClient implements FastDfsUploadClient{

    @Autowired
    private FastFileStorageClient storageClient;

    @Value("${fdfs.ngStoregeIP}")
    private String resHost;

    @Value("${fdfs.ngStoregePort}")
    private String storagePort;


    @Value("${fdfs.storegeIP}")
    private String resNeedHost;

    @Value("${fdfs.storegePort}")
    private String storageNeedPort;


    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        TokenContext.setContext(Boolean.FALSE);
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    @Override
    public String uploadNeedTokenFile(MultipartFile file) throws IOException {
        TokenContext.setContext(Boolean.TRUE);
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getNeedResAccessUrl(storePath);
    }
    /**
     * 封装文件完整URL地址
     * @param storePath
     * @return
     */
    private String getResAccessUrl(StorePath storePath) {
        StringBuffer fileUrl = new StringBuffer();
        fileUrl.append(GlobalConstants.HTTP_PRODOCOL)
                .append(resHost)
                .append(":")
                .append(storagePort)
                .append("/")
                .append(storePath.getFullPath());
        return fileUrl.toString();
    }
    /**
     * 封装文件完整URL地址
     * @param storePath
     * @return
     */
    private String getNeedResAccessUrl(StorePath storePath) {
        StringBuffer fileUrl = new StringBuffer();
        fileUrl.append(GlobalConstants.HTTP_PRODOCOL)
                .append(resNeedHost)
                .append(":")
                .append(storageNeedPort)
                .append("/")
                .append(storePath.getFullPath());
        return fileUrl.toString();
    }


    public String getResHost() {
        return resHost;
    }

    public void setResHost(String resHost) {
        this.resHost = resHost;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }

    public String getResNeedHost() {
        return resNeedHost;
    }

    public void setResNeedHost(String resNeedHost) {
        this.resNeedHost = resNeedHost;
    }

    public String getStorageNeedPort() {
        return storageNeedPort;
    }

    public void setStorageNeedPort(String storageNeedPort) {
        this.storageNeedPort = storageNeedPort;
    }
}