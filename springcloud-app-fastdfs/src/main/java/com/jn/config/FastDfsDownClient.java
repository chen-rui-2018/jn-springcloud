package com.jn.config;

import com.github.tobato.fastdfs.domain.StorePath;

/**
 * 文件下载
 *
 * @author： fengxh
 * @date： Created on 2018/12/6 14:36
 * @version： v1.0
 * @modified By:
 */
public interface FastDfsDownClient {

    /**
     * 文件下载
     * @param storePath
     * @return
     */
    byte[] downloadFile(StorePath storePath,Boolean isToken);

}
