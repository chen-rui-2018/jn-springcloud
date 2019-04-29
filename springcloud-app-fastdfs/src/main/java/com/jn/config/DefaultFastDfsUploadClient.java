package com.jn.config;

import com.github.tobato.fastdfs.context.TokenContext;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.enums.FastDfsExceptionEnum;
import com.jn.enums.FastDfsSysFileEnum;
import com.jn.model.FastDfsProperties;
import com.jn.system.api.SystemClient;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.SysFile;
import com.jn.system.model.User;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(DefaultFastDfsUploadClient.class);

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FastDfsProperties fastDfsProperties;

    @Autowired
    private SystemClient systemClient;


    @Override
    public String uploadFile(MultipartFile file, User user,String fileGroupId) throws IOException {
        if(StringUtils.isEmpty(fileGroupId)){
            SysDictInvoke sysDictInvoke=new SysDictInvoke();
            //数据字典模块编码
            sysDictInvoke.setModuleCode(FastDfsSysFileEnum.VISITOR_UPLOAD_MODULE_CODE.getCode());
            //数据字典父分组编码
            sysDictInvoke.setParentGroupCode(FastDfsSysFileEnum.VISITOR_UPLOAD_PARENT_GROUP_CODE.getCode());
            //数据字典分组编码
            sysDictInvoke.setGroupCode(FastDfsSysFileEnum.VISITOR_UPLOAD_GROUP_CODE.getCode());
            //数据字典key
            sysDictInvoke.setKey(FastDfsSysFileEnum.VISITOR_UPLOAD_KEY.getCode());

            //根据条件查询数据字典的值,查询默认“访客文件组”
            Result result=systemClient.selectDictValueByCondition(sysDictInvoke);
            if (result == null || result.getData() == null) {
                logger.warn("[服务调用] 调用内部服务出现未知错误");
                throw new JnSpringCloudException(FastDfsExceptionEnum.CALL_SERVICE_ERROR);
            }
            fileGroupId=(String) result.getData();

        }
        TokenContext.setContext(Boolean.FALSE);
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath,Boolean.FALSE,user,file.getName(),fileGroupId);
    }

    @Override
    public String uploadNeedTokenFile(MultipartFile file,User user,String fileGroupId) throws IOException {
        TokenContext.setContext(Boolean.TRUE);
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath,Boolean.TRUE,user,file.getName(),fileGroupId);
    }
    /**
     * 封装文件完整URL地址,并保存文件明细到数据库
     * @param storePath
     * @return
     */
    private String getResAccessUrl(StorePath storePath,Boolean isNeedToken,User user,String fileName,String fileGroupId) {
        StringBuffer fileUrl = new StringBuffer();
        String url = isNeedToken?fastDfsProperties.getUrl().getNeedToken():fastDfsProperties.getUrl().getNoNeedToken();
        fileUrl.append(GlobalConstants.HTTP_PRODOCOL)
                .append(url)
                .append("/")
                .append(storePath.getFullPath());
        SysFile sysFile=new SysFile();
        if(user!=null){
            sysFile.setUserId(user.getId());
        }

        sysFile.setFileUrl(fileUrl.toString());
        sysFile.setFileName(fileName);
        sysFile.setFileGroupId(fileGroupId);

        systemClient.insertSysFile(sysFile);
        return fileUrl.toString();
    }

}
