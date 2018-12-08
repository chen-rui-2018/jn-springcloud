package com.jn.config;

import com.github.tobato.fastdfs.context.TokenContext;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.jn.common.util.GlobalConstants;
import com.jn.model.FastDfsProperties;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传工具类
 *
 * @author： fengxh
 * @date： Created on 2018/10/25 15:37
 * @version： v1.0
 * @modified By:
 */
@Service
public class DefaultFastDfsUploadClient implements FastDfsUploadClient{

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FastDfsProperties fastDfsProperties;


    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        TokenContext.setContext(Boolean.FALSE);
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath,Boolean.FALSE);
    }

    @Override
    public String uploadNeedTokenFile(MultipartFile file) throws IOException {
        TokenContext.setContext(Boolean.TRUE);
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath,Boolean.TRUE);
    }
    /**
     * 封装文件完整URL地址
     * @param storePath
     * @return
     */
    private String getResAccessUrl(StorePath storePath,Boolean isNeedToken) {
        StringBuffer fileUrl = new StringBuffer();
        String url = isNeedToken?fastDfsProperties.getUrl().getNeedToken():fastDfsProperties.getUrl().getNoNeedToken();
        fileUrl.append(GlobalConstants.HTTP_PRODOCOL)
                .append(url)
                .append("/")
                .append(storePath.getFullPath());
        return fileUrl.toString();
    }

}
