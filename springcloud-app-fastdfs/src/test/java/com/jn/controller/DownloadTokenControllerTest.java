package com.jn.controller;

import com.github.tobato.fastdfs.domain.Token;
import com.github.tobato.fastdfs.token.GetToken;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.model.Result;
import com.jn.system.api.SystemClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author： shenph
 * @date： Created on 2018/12/7 14:16
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DownloadTokenControllerTest {

    private static Logger logger = LoggerFactory.getLogger(DownloadTokenControllerTest.class);

    @Autowired
    private GetToken getToken;

    @Autowired
    private SystemClient client;

    @Test
    public void getToken() {
        String filePath = "/sdf/sdf/fs";
        String userId = "10000";
        Result<Boolean> userFilePermission = client.getUserFilePermission(userId, filePath);
        if (!userFilePermission.getData()) {
            logger.info("Token .. ,{}",CommonExceptionEnum.UN_AUTH.getMessage());
        } else {
            try {
                Token token = getToken.getToken(filePath);
                logger.info("Token .. ,{}",token.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
}