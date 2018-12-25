package com.jn.common.util.zxing;

import com.google.zxing.common.BitMatrix;
import com.jn.common.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二维码的生成需要借助MatrixToImageWriter类，
 * 该类是由Google提供的，生产条形码的基类
 *
 * @author： shenph
 * @date： Created on 2018/12/24 21:02
 * @version： v1.0
 * @modified By:
 */
public class MatrixToImageWriter {
    /**
     * 用于设置图案的颜色
     */
    private static final int BLACK = 0xFF000000;
    /**
     * 用于背景色
     */
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, (matrix.get(x, y) ? BLACK : WHITE));
            }
        }
        return image;
    }

    /**
     * 写入二维码到文件
     *
     * @param matrix
     * @param format
     * @param file
     * @param logoFilePath logo图片地址
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix, String format, File file, String logoFilePath)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        //设置logo图标
        if (StringUtils.isNotBlank(logoFilePath)) {
            LogoConfig logoConfig = new LogoConfig();
            image = logoConfig.LogoMatrix(image, logoFilePath);
        }
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream, String logoFilePath)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        //设置logo图标
        if (StringUtils.isNotBlank(logoFilePath)) {
            LogoConfig logoConfig = new LogoConfig();
            image = logoConfig.LogoMatrix(image, logoFilePath);
        }
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }
}