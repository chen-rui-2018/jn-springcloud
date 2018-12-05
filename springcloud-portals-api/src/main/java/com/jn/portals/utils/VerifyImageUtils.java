package com.jn.portals.utils;

import com.jn.common.util.StringUtils;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * 滑块验证工具类
 *
 * @Author: yangph
 * @Date: 2018/11/29 17:45
 * @Version v1.0
 * @modified By:
 */
public class VerifyImageUtils {
    /**
     * 源文件宽度
     */
    private static int ORI_WIDTH = 590;
    /**
     * 源文件高度
     */
    private static int ORI_HEIGHT = 360;
    /**
     * 抠图坐标x
     */
    private static int X;
    /**
     * 抠图坐标y
     */
    private static int Y;
    /**
     * 模板图宽度
     */
    private static int WIDTH;
    /**
     * 模板图高度
     */
    private static int HEIGHT;
    /**
     * X位置移动百分比
     */
    private static float xPercent;
    /**
     * Y位置移动百分比
     */
    private static float yPercent;

    public static void setOriWidth(int oriWidth) {
        ORI_WIDTH = oriWidth;
    }

    public static void setOriHeight(int oriHeight) {
        ORI_HEIGHT = oriHeight;
    }

    public static int getOriWidth() {
        return ORI_WIDTH;
    }

    public static int getOriHeight() {
        return ORI_HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public static float getxPercent() {
        return xPercent;
    }

    public static float getyPercent() {
        return yPercent;
    }

    /**
     * 根据模板切图
     *
     * @param templateFile
     * @param targetFile
     * @param templateType
     * @param targetType
     * @return
     * @throws Exception
     */
    public static Map<String, byte[]> pictureTemplatesCut(File templateFile, File targetFile, String templateType, String targetType) throws Exception {
        Map<String, byte[]> pictureMap = new HashMap<>(16);
        // 文件类型
        String templateFiletype = templateType;
        String oriFiletype = targetType;
        if (StringUtils.isEmpty(templateFiletype) || StringUtils.isEmpty(oriFiletype)) {
            throw new RuntimeException("file type is empty");
        }
        // 源文件流
        File orifile = targetFile;
        try (InputStream oriis = new FileInputStream(orifile)) {
            // 模板图
            BufferedImage imageTemplate = ImageIO.read(templateFile);
            WIDTH = imageTemplate.getWidth();
            HEIGHT = imageTemplate.getHeight();
            generateCutoutCoordinates();
            // 最终图像
            BufferedImage newImage = new BufferedImage(WIDTH, HEIGHT, imageTemplate.getType());
            Graphics2D graphics = newImage.createGraphics();
            graphics.setBackground(Color.white);

            int bold = 5;
            // 获取感兴趣的目标区域
            BufferedImage targetImageNoDeal = getTargetArea(X, Y, WIDTH, HEIGHT, oriis, oriFiletype);


            // 根据模板图片抠图
            newImage = dealCutPictureByTemplate(targetImageNoDeal, imageTemplate, newImage);

            // 设置“抗锯齿”的属性
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setStroke(new BasicStroke(bold, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            graphics.drawImage(newImage, 0, 0, null);
            graphics.dispose();

            //新建流。
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            //利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
            ImageIO.write(newImage, "png", os);
            byte[] newImages = os.toByteArray();
            pictureMap.put("newImage", newImages);

            // 源图生成遮罩
            BufferedImage oriImage = ImageIO.read(orifile);
            byte[] oriCopyImages = dealOriPictureByTemplate(oriImage, imageTemplate, X, Y);
            pictureMap.put("oriCopyImage", oriCopyImages);
            return pictureMap;
        } catch (Exception e) {
            LoggerFactory.getLogger(VerifyImageUtils.class).info("根据模板切图失败{}", e.getMessage());
            return null;
        }
    }

    /**
     * 抠图后原图生成
     *
     * @param oriImage
     * @param templateImage
     * @param x
     * @param y
     * @return
     * @throws Exception
     */
    private static byte[] dealOriPictureByTemplate(BufferedImage oriImage, BufferedImage templateImage, int x,
                                                   int y) throws Exception {
        // 源文件备份图像矩阵 支持alpha通道的rgb图像
        BufferedImage oriCopyimage = new BufferedImage(oriImage.getWidth(), oriImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        // 源文件图像矩阵
        int[][] oriImageData = getData(oriImage);
        // 模板图像矩阵
        int[][] templateImageData = getData(templateImage);

        //copy 源图做不透明处理
        for (int i = 0; i < oriImageData.length; i++) {
            for (int j = 0; j < oriImageData[0].length; j++) {
                int rgb = oriImage.getRGB(i, j);
                int r = (0xff & rgb);
                int g = (0xff & (rgb >> 8));
                int b = (0xff & (rgb >> 16));
                //无透明处理
                rgb = r + (g << 8) + (b << 16) + (255 << 24);
                oriCopyimage.setRGB(i, j, rgb);
            }
        }
        //默认图片坐标有增加5px,模板数据长度减去数值
        int px = 5;
        for (int i = 0; i < templateImageData.length; i++) {
            for (int j = 0; j < templateImageData[0].length - px; j++) {
                int rgb = templateImage.getRGB(i, j);
                //对源文件备份图像(x+i,y+j)坐标点进行透明处理
                if (rgb != 16777215 && rgb <= 0) {
                    int rgbOri = oriCopyimage.getRGB(x + i, y + j);
                    int r = (0xff & rgbOri);
                    int g = (0xff & (rgbOri >> 8));
                    int b = (0xff & (rgbOri >> 16));
                    rgbOri = r + (g << 8) + (b << 16) + (150 << 24);
                    oriCopyimage.setRGB(x + i, y + j, rgbOri);
                } else {
                    //do nothing
                }
            }
        }
        //新建流。
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
        ImageIO.write(oriCopyimage, "png", os);
        //从流中获取数据数组。
        byte[] b = os.toByteArray();
        return b;
    }


    /**
     * 根据模板图片抠图
     *
     * @param oriImage
     * @param templateImage
     * @return
     */

    private static BufferedImage dealCutPictureByTemplate(BufferedImage oriImage, BufferedImage templateImage, BufferedImage targetImage) throws Exception {
        // 源文件图像矩阵
        int[][] oriImageData = getData(oriImage);
        // 模板图像矩阵
        int[][] templateImageData = getData(templateImage);
        // 模板图像宽度

        for (int i = 0; i < templateImageData.length; i++) {
            // 模板图片高度
            for (int j = 0; j < templateImageData[0].length; j++) {
                // 如果模板图像当前像素点不是白色 copy源文件信息到目标图片中
                int rgb = templateImageData[i][j];
                if (rgb != 16777215 && rgb <= 0) {
                    targetImage.setRGB(i, j, oriImageData[i][j]);
                }
            }
        }
        return targetImage;
    }


    /**
     * 获取目标区域
     *
     * @param x            随机切图坐标x轴位置
     * @param y            随机切图坐标y轴位置
     * @param targetWidth  切图后目标宽度
     * @param targetHeight 切图后目标高度
     * @param ois          源文件输入流
     * @return
     * @throws Exception
     */
    private static BufferedImage getTargetArea(int x, int y, int targetWidth, int targetHeight, InputStream ois,
                                               String filetype) throws Exception {
        Iterator<ImageReader> imageReaderList = ImageIO.getImageReadersByFormatName(filetype);
        ImageReader imageReader = imageReaderList.next();
        // 获取图片流
        ImageInputStream iis = ImageIO.createImageInputStream(ois);
        // 输入源中的图像将只按顺序读取
        imageReader.setInput(iis, true);

        ImageReadParam param = imageReader.getDefaultReadParam();
        Rectangle rec = new Rectangle(x, y, targetWidth, targetHeight);
        param.setSourceRegion(rec);
        BufferedImage targetImage = imageReader.read(0, param);
        return targetImage;
    }

    /**
     * 生成图像矩阵
     *
     * @param
     * @return
     * @throws Exception
     */
    private static int[][] getData(BufferedImage bimg) throws Exception {
        int[][] data = new int[bimg.getWidth()][bimg.getHeight()];
        for (int i = 0; i < bimg.getWidth(); i++) {
            for (int j = 0; j < bimg.getHeight(); j++) {
                data[i][j] = bimg.getRGB(i, j);
            }
        }
        return data;
    }

    /**
     * 随机生成抠图坐标
     */
    private static void generateCutoutCoordinates() {
        Random random = new Random();
        int widthDifference = ORI_WIDTH - WIDTH;
        int heightDifference = ORI_HEIGHT - HEIGHT;

        if (widthDifference <= 0) {
            X = 5;

        } else {
            X = random.nextInt(ORI_WIDTH - WIDTH) + 5;
        }

        if (heightDifference <= 0) {
            Y = 5;
        } else {
            Y = random.nextInt(ORI_HEIGHT - HEIGHT) + 5;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        xPercent = Float.parseFloat(numberFormat.format((float) X / (float) ORI_WIDTH));
        yPercent = Float.parseFloat(numberFormat.format((float) Y / (float) ORI_HEIGHT));
    }
}
