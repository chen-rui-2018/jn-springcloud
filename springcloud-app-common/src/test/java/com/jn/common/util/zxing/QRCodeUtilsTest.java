package com.jn.common.util.zxing;

import com.google.zxing.Result;
import com.google.zxing.WriterException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 二维码测试
 *
 * @author： shenph
 * @date： Created on 2018/12/24 23:37
 * @version： v1.0
 * @modified By:
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QRCodeUtilsTest {

    /**
     * 二维码内容
     */
    private static String contents;
    /**
     * 二维码输出路径
     */
    private static String outFilePath;
    /**
     * 二维码中间logo，无就传空
     */
    private static String logoFilePath;

    @Before
    public void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:zxing");
        contents = "http://www.baidu.com";
        outFilePath = file.getPath() + File.separator + "QRCode.png";
        logoFilePath = file.getPath() + File.separator + "logo.png";
    }

    @Test
    public void AencodeHelper() throws IOException, WriterException {
        QRCodeUtils.EncodeHelper(QRCodeUtils.width, QRCodeUtils.height,
                contents, outFilePath, logoFilePath);
    }

    @Test
    public void BecodeHelper() throws FileNotFoundException {
        Result result = QRCodeUtils.DecodeHelper(outFilePath);
        System.out.println("result = " + result.toString());
        System.out.println("resultFormat = " + result.getBarcodeFormat());
        System.out.println("resultText = " + result.getText());
    }

    @Test
    public void CdeleteTempFile() {
        File file = new File(outFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}