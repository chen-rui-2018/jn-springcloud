package com.jn.oa;

import com.google.zxing.WriterException;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.zxing.QRCodeUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.meeting.enums.MeetingQRCodeFileEnums;
import com.jn.system.api.SystemClient;
import com.jn.system.model.SysDictInvoke;
import com.jn.upload.api.UploadClient;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

/**
 * @author： shenph
 * @date： Created on 2019/2/27 12:25
 * @version： v1.0
 * @modified By:
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class QRCodeUploadFastdfsTest {

    @Autowired
    private UploadClient uploadClient;

    @Before
    public void setUp() {
    }

    @Test
    public void qrCodeUpdate() throws IOException, WriterException {
        //1、生成二维码
        File file = ResourceUtils.getFile("classpath:zxing");
        String contents = "http://www.baidu.com";
        String outFilePath = file.getPath() + File.separator + "QRCode.png";
        String logoFilePath = file.getPath() + File.separator + "logo.png";
        QRCodeUtils.EncodeHelper(QRCodeUtils.width, QRCodeUtils.height, contents, outFilePath, logoFilePath);

        file = ResourceUtils.getFile("classpath:zxing/QRCode.png");
        FileItem fileItem = new DiskFileItem("file", Files.probeContentType(file.toPath()), false, file.getName(),
                (int) file.length(), file.getParentFile());
        try {
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
            // Or faster..
            // IOUtils.copy(new FileInputStream(file),
            // fileItem.getOutputStream());
        } catch (IOException ex) {
            //TODO
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

        //2、上传至fastdfs
        /*File QRCodeFile = ResourceUtils.getFile("classpath:zxing/QRCode.png");
        FileInputStream fileInputStream = new FileInputStream(QRCodeFile);
        MultipartFile multipartFile = new MockMultipartFile("file",
                QRCodeFile.getName(), "text/plain", IOUtils.toByteArray(fileInputStream));*/

        Result<String> result = uploadClient.uploadFile(multipartFile, false,null);
        System.out.println("success path: " + result.getData());
    }

}
