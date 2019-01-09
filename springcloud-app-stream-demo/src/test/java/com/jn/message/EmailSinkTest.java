package com.jn.message;

import com.google.gson.Gson;
import com.jn.SpringCloudAppStreamDemoApplication;
import com.jn.common.channel.MessageSource;
import com.jn.news.vo.EmailVo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 发送测试
 *
 * @author： chenm
 * @date： Created on 2018/11/16 15:38
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableBinding(value = {MessageSource.class})
@SpringBootTest(classes={SpringCloudAppStreamDemoApplication.class})
public class EmailSinkTest {

    @Autowired
    private MessageSource messageSource;

    private static String filePath;

    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:images");
        filePath = file.getPath() + File.separator + "test.png";
    }

    @Test
    public void sinkSenderEmailTester() {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com");
        emailVo.setEmailSubject("主题：简单邮件");
        emailVo.setEmailContent("测试邮件内容");
        String[] fileList = {filePath} ;
        emailVo.setFiles(fileList);
        Gson gson = new Gson();
        System.out.println(gson.toJson(emailVo));
        messageSource.outputEmail().send(MessageBuilder.withPayload(gson.toJson(emailVo)).build());


    }

}