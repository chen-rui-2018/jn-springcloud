package com.jn.hr.common.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.enums.CommonExcelExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.down.api.DownLoadClient;
import com.jn.down.model.DownLoad;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.model.DownAttachment;
import com.jn.hr.common.service.CommonService;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.vo.SysDictKeyValue;
import com.jn.upload.api.UploadClient;
import org.apache.commons.collections.CollectionUtils;
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
    @Autowired
    private SystemClient systemClient;

    /**
     * 附件批量上传
     *
     * @param files
     */
    @Override
    @ServiceLog(doAction = "附件批量上传")
    public String uploadAttachment(List<MultipartFile> files) {
        SysDictInvoke sysDictInvoke=new SysDictInvoke();
        sysDictInvoke.setGroupCode("hr_file_group");
        sysDictInvoke.setModuleCode("springcloud_hr");
        sysDictInvoke.setParentGroupCode("springcloud_hr");
        sysDictInvoke.setKey("hr_file_group_id");
        Result dictResult=systemClient.getDict(sysDictInvoke);
        String fileGroup="";
        if(dictResult!=null && "0000".equals(dictResult.getCode()) && dictResult.getData()!=null) {
            List<SysDictKeyValue> certificateTypeList = (List<SysDictKeyValue>) dictResult.getData();
            if(!CollectionUtils.isEmpty(certificateTypeList)){
                fileGroup=certificateTypeList.get(0).getLable();
            }
        }else{
            logger.error("上传文件，查询文件组失败");
            throw new JnSpringCloudException(EmployeeExceptionEnums.QUERYDICT_ERROR);
        }
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                logger.warn("[人力资源管理] 附件上传失败");
                throw new JnSpringCloudException(HrExceptionEnums.FILE_IS_NULL);
            } else {
                //获取文件名称
                try {
                    Map<String, String> map = new HashMap<String, String>(16);
                    String title = file.getOriginalFilename();
                    //为了防止下载时名称重复，对文件名称做处理
                    String[] split = title.split("\\.");
                    String str = DateUtils.formatDate(new Date(), "yyyyMMdd");
                    String fileName = split[0] + str + RandomStringUtils.randomNumeric(4) + "." + split[1];

                    Result<String> result = uploadClient.uploadFile(file, true,fileGroup);
                    if(!"0000".equals(result.getCode())){
                        logger.error("附件上传失败,code={},message={}",result.getCode(),result.getResult());
                        throw new JnSpringCloudException(HrExceptionEnums.UPLOAD_FILE_ERRPR);
                    }
                    map.put("title", fileName);
                    map.put("url", result.getData());
                    list.add(map);
                } catch (IOException e) {
                    throw new JnSpringCloudException(HrExceptionEnums.UPLOAD_FILE_ERRPR);
                }
            }
        }

        //将集合转成json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String attachment = objectMapper.writeValueAsString(list);
            logger.info("[人力资源管理] 附件上传成功");
            return attachment;
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException转换异常，附件上传失败失败。", e);
            throw new JnSpringCloudException(HrExceptionEnums.UPLOAD_FILE_ERRPR);
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

    @Override
    public List<SysDictKeyValue> queryDictList(String parentGroupCode, String groupCode) {
        SysDictInvoke sysDictInvoke=new SysDictInvoke();
        sysDictInvoke.setGroupCode(groupCode);
        sysDictInvoke.setModuleCode("springcloud_hr");
        sysDictInvoke.setParentGroupCode(parentGroupCode);
        Result result=systemClient.getDict(sysDictInvoke);
        if(result==null || !"0000".equals(result.getCode()) || result.getData()==null){
            logger.error("查询字典表出错或数据不存在,GroupCode={},ModuleCode=springcloud_hr,ParentGroupCode={}",groupCode,parentGroupCode);
            throw new JnSpringCloudException(EmployeeExceptionEnums.QUERYDICT_ERROR);
        }
        List<SysDictKeyValue> resultList= (List<SysDictKeyValue>) result.getData();
        return resultList;
    }
}
