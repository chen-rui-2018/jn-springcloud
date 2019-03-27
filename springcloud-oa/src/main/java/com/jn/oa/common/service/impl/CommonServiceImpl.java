package com.jn.oa.common.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.enums.CommonExcelExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.down.api.DownLoadClient;
import com.jn.down.model.DownLoad;
import com.jn.oa.common.model.DownAttachment;
import com.jn.oa.common.service.CommonService;
import com.jn.oa.email.enums.EmailExceptionEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.upload.api.UploadClient;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author： shaobao
 * @date： Created on 2019/3/19 10:33
 * @version： v1.0
 * @modified By:
 **/
@Service
public class CommonServiceImpl implements CommonService {

    private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private UploadClient uploadClient;

    @Autowired
    private DownLoadClient downLoadClient;

    /**
     * 附件批量上传
     *
     * @param files
     */
    @Override
    @ServiceLog(doAction = "附件批量上传")
    public String uploadAttachment(List<MultipartFile> files) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                logger.warn("[协同办公] 附件上传失败");
                throw new JnSpringCloudException(EmailExceptionEnums.FILE_IS_NULL);
            } else {
                //获取文件名称
                try {
                    Map<String, String> map = new HashMap<String, String>(16);
                    String title = file.getOriginalFilename();
                    //为了防止下载时名称重复，对文件名称做处理
                    String[] split = title.split("\\.");
                    String str = DateUtils.formatDate(new Date(), "yyyyMMdd");
                    String fileName = split[0] + str + RandomStringUtils.randomNumeric(4) + "." + split[1];

                    Result<String> result = uploadClient.uploadFile(file, false);
                    map.put("title", fileName);
                    map.put("url", result.getData());
                    list.add(map);
                } catch (IOException e) {
                    throw new JnSpringCloudException(EmailExceptionEnums.UPLOAD_FILE_ERRPR);
                }
            }
        }

        //将集合转成json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String attachment = objectMapper.writeValueAsString(list);
            logger.info("[协同办公] 附件上传成功");
            return attachment;
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException转换异常，附件上传失败失败。", e);
            throw new JnSpringCloudException(EmailExceptionEnums.UPLOAD_FILE_ERRPR);
        }
    }


    /**
     * 附件下载
     *
     * @param downAttachment 附件下载实体
     * @param response
     * @return
     */
    @Override
    @ServiceLog(doAction = "附件下载")
    public ResponseEntity<byte[]> downLoadAttachment(DownAttachment downAttachment, HttpServletResponse response) {
        DownLoad downLoad = new DownLoad();
        downLoad.setUrl(downAttachment.getUrl());
        downLoad.setToken(false);
        String title = downAttachment.getTitle();
        try {
            String fileName = new String(title.getBytes(), "ISO-8859-1");
            response.setHeader("Content-Disposition", "attchement;filename=" + fileName);
            ResponseEntity<byte[]> responseEntity = downLoadClient.downLoad(downLoad);
            return responseEntity;
        } catch (UnsupportedEncodingException e) {
            throw new JnSpringCloudException(CommonExcelExceptionEnum.EXCEL_FORMAT_ERROR);
        }

    }
}
