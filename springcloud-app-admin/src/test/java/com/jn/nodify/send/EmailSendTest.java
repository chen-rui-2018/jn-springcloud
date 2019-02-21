package com.jn.nodify.send;

import com.google.gson.Gson;
import com.jn.common.channel.MessageSource;
import com.jn.news.vo.EmailVo;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {MessageSource.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailSendTest {

    @Autowired
    private MessageSource messageSource;

    private static String filePath;

    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:images");
        filePath = file.getPath() + File.separator + "test.png";
    }

    @Test
    public void sendMessage() {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com");
        emailVo.setEmailSubject("主题：简单邮件");
        emailVo.setEmailContent("测试邮件内容");
        String[] fileList = {filePath} ;
        emailVo.setFiles(fileList);
        messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());


    }
}