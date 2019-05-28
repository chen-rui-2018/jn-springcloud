package com.jn.miniprogram.base.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import com.jn.miniprogram.base.model.qrcode.WxMiniCodeLineColor;
import com.jn.miniprogram.base.model.qrcode.WxaCode;
import com.jn.miniprogram.base.model.qrcode.WxaCodeUnlimit;
import com.jn.miniprogram.base.service.QrcodeUploadFileToFastdfs;
import com.jn.miniprogram.base.service.WxMiniHttpClientService;
import com.jn.miniprogram.base.service.WxMiniQrcodeService;
import com.jn.miniprogram.base.utils.fs.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 小程序二维码相关操作接口实现
 *
 * @Author： cm
 * @Date： Created on 2019/3/18 14:28
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxMiniQrcodeServiceImpl implements WxMiniQrcodeService {

    private final Logger logger = LoggerFactory.getLogger(WxMiniQrcodeServiceImpl.class);

    @Autowired
    private WxMiniHttpClientService wxMiniHttpClientService;

    @Autowired
    private QrcodeUploadFileToFastdfs qrcodeUploadFileToFastdfs;

    @Override
    public String createWxaCode(String path, int width, boolean autoColor, WxMiniCodeLineColor lineColor, boolean isHyaline) {
        WxaCode wxaCode = new WxaCode();
        wxaCode.setPath(path);
        wxaCode.setWidth(width);
        wxaCode.setAuto_color(autoColor);
        wxaCode.setLine_color(lineColor);
        wxaCode.setIs_hyaline(isHyaline);
        InputStream inputStream = wxMiniHttpClientService.postRequestReturnInputStream(WxMiniQrcodeService.GET_WXACODE_URL,wxaCode);
        String fileName = UUID.randomUUID().toString();
        File file;
        try {
            file = FileUtils.createTmpFile(inputStream,fileName,"jpg");
        } catch (IOException e) {
            logger.error("上传小程序文件失败",e);
            throw new JnSpringCloudException(WxExceptionEnums.FAST_DFS_UPLOAD_FAIL);
        }
        return qrcodeUploadFileToFastdfs.uploadFileByFastdfs(file);
    }

    @Override
    public String createWxaCode(String path, int width) {
        return this.createWxaCode(path,width,true,null,false);
    }

    @Override
    public String createWxaCode(String path) {
        return this.createWxaCode(path,430);
    }

    @Override
    public String createWxaCodeUnlimit(String scene, String page, int width, boolean autoColor, WxMiniCodeLineColor lineColor, boolean isHyaline) {
        WxaCodeUnlimit wxaCodeUnlimit = new WxaCodeUnlimit();
        wxaCodeUnlimit.setScene(scene);
        wxaCodeUnlimit.setPage(page);
        wxaCodeUnlimit.setWidth(width);
        wxaCodeUnlimit.setAuto_color(autoColor);
        wxaCodeUnlimit.setLine_color(lineColor);
        wxaCodeUnlimit.setIs_hyaline(isHyaline);
        InputStream inputStream = wxMiniHttpClientService.postRequestReturnInputStream(WxMiniQrcodeService.GET_WXACODE_UNLIMIT_URL,wxaCodeUnlimit);
        String fileName = UUID.randomUUID().toString();
        File file;
        try {
            file = FileUtils.createTmpFile(inputStream,fileName,"jpg");
        } catch (IOException e) {
            logger.error("创建小程序码临时文件失败",e);
            throw new JnSpringCloudException(WxExceptionEnums.QR_CODE_CREATE_TEMP_FILE_FAIL);
        }
        return qrcodeUploadFileToFastdfs.uploadFileByFastdfs(file);
    }

    @Override
    public String createWxaCodeUnlimit(String scene, String page) {
        return this.createWxaCodeUnlimit(scene,page,430,true,null,false);
    }

    @Override
    public String createQrcode(String path, int width) {
        WxaCode wxaCode = new WxaCode();
        wxaCode.setPath(path);
        wxaCode.setWidth(width);
        InputStream inputStream = wxMiniHttpClientService.postRequestReturnInputStream(WxMiniQrcodeService.CREATE_QRCODE_URL,wxaCode);
        String fileName = UUID.randomUUID().toString();
        File file;
        try {
            file = FileUtils.createTmpFile(inputStream,fileName,"jpg");
        } catch (IOException e) {
            logger.error("创建小程序码临时文件失败",e);
            throw new JnSpringCloudException(WxExceptionEnums.QR_CODE_CREATE_TEMP_FILE_FAIL);
        }
       return qrcodeUploadFileToFastdfs.uploadFileByFastdfs(file);
    }

    @Override
    public String createQrcode(String path) {
        return this.createQrcode(path,430);
    }

}
