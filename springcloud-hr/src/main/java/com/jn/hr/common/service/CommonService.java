package com.jn.hr.common.service;

import com.jn.hr.common.model.DownAttachment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 协同办公公共service
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 10:31
 * @version： v1.0
 * @modified By:
 **/
public interface CommonService {


    /**
     * 附件批量上传
     *
     * @param files
     */
    String uploadAttachment(List<MultipartFile> files);

    /**
     * 附件下载
     *
     * @param downAttachment 附件下载实体
     * @param response
     * @return
     */
    ResponseEntity<byte[]> downLoadAttachment(DownAttachment downAttachment, HttpServletResponse response);

    String queryDictValueByLable(String parentGroupCode, String groupCode, String lable);
}
