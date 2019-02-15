package com.jn.common.util.zxing;


import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 二维码工具类
 *
 * @author： shenph
 * @date： Created on 2018/12/24 20:57
 * @version： v1.0
 * @modified By:
 */
public class QRCodeUtils {
    public static int width = 430;
    public static int height = 430;

    /**
     * 生成二维码
     *
     * @param width        二维码宽度 430
     * @param height       二维码高度 430
     * @param contents     二维码内容 二维码test124
     * @param outFilePath  输出二维码路径 C:\\qrcode.png
     * @param logoFilePath 二维码是否有logo C:\\logo.png
     * @throws IOException
     * @throws WriterException
     */
    public static void EncodeHelper(int width, int height, String contents, String outFilePath, String logoFilePath)
            throws IOException, WriterException {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        // 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 内容所使用字符集编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置图片的最大值
        //hints.put(EncodeHintType.MAX_SIZE, 350);
        //设置图片的最小值
        //hints.put(EncodeHintType.MIN_SIZE, 100);
        //设置二维码边的空度，非负数
        hints.put(EncodeHintType.MARGIN, 1);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                //要编码的内容
                //编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,
                //Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,
                //MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E 1D,UPC/EAN extension,UPC_EAN_EXTENSION
                BarcodeFormat.QR_CODE,
                //条形码的宽度
                width,
                //条形码的高度
                height,
                //生成条形码时的一些配置,此项可选
                hints);
        // 生成二维码,指定输出路径
        File outputFile = new File(outFilePath);
        // 二维码的图片格式 gif
        String format = outFilePath.substring(outFilePath.lastIndexOf(".") + 1);
        //生成二维码
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile, logoFilePath);
    }

    /**
     * 二维码解析
     *
     * @param filePath 文件路径
     * @return
     */
    public static Result DecodeHelper(String filePath) {
        Result result = null;
        try {
            MultiFormatReader formatReader = new MultiFormatReader();
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            result = formatReader.decode(binaryBitmap, hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
