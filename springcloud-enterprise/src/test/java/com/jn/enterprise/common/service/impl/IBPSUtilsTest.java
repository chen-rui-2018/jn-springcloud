package com.jn.enterprise.common.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.enterprise.model.IBPSUploadResult;
import com.jn.enterprise.utils.IBPSFileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-5-24 10:00:40
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class IBPSUtilsTest {

    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(IBPSUtilsTest.class);

    String url = "http://112.94.22.222:2020/group2/M00/00/34/wKgKFFzc0XyAP2zOAAseA8gFRAo729.png";
    String url2 = "http://192.168.10.20:2020/group2/M00/00/24/wKgKFFyUSiSAFJkMAAE_LrzK-gc520.jpg";
    String account = "wangsong";

    private static String manyIbpsUrl = "[{\"id\":\"581420673608450048\",\"fileName\":\"1558663090862\",\"filePath\":\"http://112.94.22.222:2020/group2/M00/00/34/wKgKFFzc0XyAP2zOAAseA8gFRAo729.png\"}" +
            ",{\"id\":\"581420675961454592\",\"fileName\":\"1558663091423\",\"filePath\":\"http://192.168.10.20:2020/group2/M00/00/24/wKgKFFyUSiSAFJkMAAE_LrzK-gc520.jpg\"}]";

    private static String singleIbpsUrl1 = "[{\"id\":\"581420673608450048\",\"fileName\":\"1558663090862\",\"filePath\":\"http://112.94.22.222:2020/group2/M00/00/34/wKgKFFzc0XyAP2zOAAseA8gFRAo729.png\"}]";

    public static void main(String[] args) {
        System.out.println(IBPSFileUtils.getFilePath(manyIbpsUrl));
        System.out.println(IBPSFileUtils.getFilePath2List(manyIbpsUrl));
        System.out.println(IBPSFileUtils.getFilePathWithSeparator(manyIbpsUrl, "##"));
    }

    @Test
    public void uploadFiles() {
        List<String> list = new ArrayList<>(3);
        list.add(url);
        list.add(url2);
        String result = IBPSFileUtils.uploadFiles(account, list);
        System.out.println(result);
    }

    @Test
    public void uploadFile2Result() {
        IBPSUploadResult ibpsUploadResult = IBPSFileUtils.uploadFile2Result(account, url);
        System.out.println(ibpsUploadResult);
    }

    @Test
    public void uploadFile2Json() {
        String result = IBPSFileUtils.uploadFile2Json(account, url2);
        System.out.println(result);
    }
}