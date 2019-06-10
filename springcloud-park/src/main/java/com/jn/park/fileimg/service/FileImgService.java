package com.jn.park.fileimg.service;

import com.jn.park.fileimg.model.FileImg;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 19:23
 * @version： v1.0
 * @modified By:
 */
public interface FileImgService {

    /**
     * 保存用户图片信息
     * @param fileImgs
     * @param account
     * @param topicId
     * @return
     */
    int saveFileImgList(List<FileImg> fileImgs, String account, String topicId);
}
