package com.jn.enterprise.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.IBPSRequestUrlEnum;
import com.jn.enterprise.model.IBPSFile;
import com.jn.enterprise.model.IBPSUploadResult;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * IBPS上传文件工具类
 * @author： huxw
 * @date： Created on 2019-5-22 19:49:56
 * @version： v1.0
 * @modified By:
 */
public class IBPSFileUtils {

    private static final Logger logger = LoggerFactory.getLogger(IBPSFileUtils.class);

    // 默认拼接字符，请勿修改 !important
    private static final String DEFAULT_SEPARATOR_CHAR = ",";

    /**
     * 多个文件上传
     * @param account 账号
     * @param fileUrlList 文件url列表
     * @return ibps存储格式路径
     */
    public static String uploadFiles(String account, List<String> fileUrlList) {
        StringBuffer sb = new StringBuffer();
        if (fileUrlList == null || fileUrlList.size() == 0) {
            logger.warn("[IBPS文件上传] 文件列表为空");
            return sb.toString();
        }

        for (String fileUrl : fileUrlList) {
            IBPSUploadResult ibpsUploadResult = uploadFile2Result(account, fileUrl);
            if (ibpsUploadResult != null && ibpsUploadResult.getData() != null) {
                if (StringUtils.isBlank(sb.toString())) {
                    sb.append("[");
                } else {
                    sb.append(DEFAULT_SEPARATOR_CHAR);
                }
                sb.append(ibpsUploadResult.getData().toJsonString());
            }
        }

        if (StringUtils.isNotBlank(sb.toString())) {
            sb.append("]");
        }
        return sb.toString();
    }

    /**
     * 单个文件上传
     * @param account 账号
     * @param fileUrl 文件全路径
     * @return ibps存储格式路径
     */
    public static IBPSUploadResult uploadFile2Result(String account, String fileUrl) {
        if (StringUtils.isBlank(fileUrl)) {
            logger.warn("[IBPS文件上传] 文件路径为空");
            return null;
        }
        if(!StringUtils.startsWith(fileUrl, "http")) {
            logger.warn("[IBPS文件上传] 文件路径格式错误：{}", fileUrl);
            return null;
        }
        if(!isExist(fileUrl)) {
            logger.warn("[IBPS文件上传] 文件不存在：{}", fileUrl);
            return null;
        }

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("fileUrl", fileUrl);
        JSONObject jsonObject = CallOtherSwaggerUtils.request(account, IBPSRequestUrlEnum.UPLOAD_FILE.getRequestUrl(), HttpMethod.POST, map);
        IBPSUploadResult ibpsUploadResult = new Gson().fromJson(jsonObject.toString(), IBPSUploadResult.class);
        if (ibpsUploadResult == null || !ibpsUploadResult.getState().equals("200") || ibpsUploadResult.getData() == null) {
            logger.warn("[IBPS文件上传] 上传文件失败，返回数据：{}", ibpsUploadResult.toString());
            return null;
        }
        logger.info("[IBPS文件上传] 上传文件成功，返回数据：{}", ibpsUploadResult.toString());
        return ibpsUploadResult;
    }

    /**
     * 单个文件上传
     * @param account 账号
     * @param fileUrl 文件全路径
     * @return 成功返回ibps存储格式路径，失败返回原路径
     */
    public static String uploadFile2Json(String account, String fileUrl) {
        IBPSUploadResult ibpsUploadResult = uploadFile2Result(account, fileUrl);
        String ibpsUrl = (ibpsUploadResult == null || ibpsUploadResult.getData() == null) ? fileUrl : ibpsUploadResult.getData().toSingleJsonString();
        return ibpsUrl;
    }

    /**
     * 获取文件全路径
     * @param ibpsUrl ibps格式路径
     * @return 发生错误返回原字符串，成功返回全路径（多个以逗号拼接）
     */
    public static String getFilePath(String ibpsUrl) {
        return getFilePathWithSeparator(ibpsUrl, DEFAULT_SEPARATOR_CHAR);
    }

    /**
     * 获取文件全路径
     * @param ibpsUrl ibps格式路径
     * @param separator 拼接字符，默认为逗号
     * @return 发生错误返回原字符串，成功返回全路径
     */
    public static String getFilePathWithSeparator(String ibpsUrl, String separator) {
        String tempUrl = ibpsUrl;
        if (!StringUtils.startsWith(tempUrl, "[{") || !StringUtils.endsWith(tempUrl, "}]")) {
            logger.warn("[IBPS文件存储] 处理的路径不是IBPS文件存储格式");
            return ibpsUrl;
        }

        List<IBPSFile> ibpsFileList = new Gson().fromJson(tempUrl, new TypeToken<List<IBPSFile>>() {}.getType());
        separator = StringUtils.isBlank(separator) ? DEFAULT_SEPARATOR_CHAR : separator;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ibpsFileList.size(); i++) {
            IBPSFile ibpsFile = ibpsFileList.get(i);
            if (ibpsFile == null || StringUtils.isAnyEmpty(ibpsFile.getId(), ibpsFile.getFileName(), ibpsFile.getFilePath())) {
                logger.warn("[IBPS文件存储] 处理时发生异常，可能原因是字段不全 [id, fileName, filePath]");
                return ibpsUrl;
            }
            if (i != 0) {
                sb.append(separator);
            }
            sb.append(ibpsFile.getFilePath());
        }
        logger.info("[IBPS文件存储] 处理成功");
        return sb.toString();
    }

    /**
     * 获取文件路径列表
     * @param ibpsUrl ibps格式路径
     * @return 发生错误返回null
     */
    public static List<String> getFilePath2List(String ibpsUrl) {
        String tempUrl = ibpsUrl;
        if (!StringUtils.startsWith(tempUrl, "[{") || !StringUtils.endsWith(tempUrl, "}]")) {
            logger.warn("[IBPS文件存储] 处理的路径不是IBPS文件存储格式");
            return null;
        }

        List<IBPSFile> ibpsFileList = new Gson().fromJson(tempUrl, new TypeToken<List<IBPSFile>>() {}.getType());

        List<String> fileUrlList = new ArrayList<>();
        for (IBPSFile ibpsFile : ibpsFileList) {
            if (ibpsFile == null || StringUtils.isAnyEmpty(ibpsFile.getId(), ibpsFile.getFileName(), ibpsFile.getFilePath())) {
                logger.warn("[IBPS文件存储] 处理时发生异常，可能原因是字段不全 [id, fileName, filePath]");
                return null;
            }
            fileUrlList.add(ibpsFile.getFilePath());
        }
        logger.info("[IBPS文件存储] 处理成功");
        return fileUrlList;
    }

    /**
     * 判断图片是否存在
     * @param fileUrl
     * @return
     */
    private static boolean isExist(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            URLConnection uc = url.openConnection();
            InputStream in = uc.getInputStream();
            if (fileUrl.equalsIgnoreCase(uc.getURL().toString())) {
                in.close();
            }
        } catch (Exception e) {
            logger.warn("[判断文件是否存在] Exception：{}", e.getMessage());
            return false;
        }
        return true;
    }
}
