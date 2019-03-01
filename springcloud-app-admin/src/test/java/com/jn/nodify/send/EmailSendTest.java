package com.jn.nodify.send;

import com.jn.common.channel.MessageSource;
import com.jn.news.vo.EmailVo;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {MessageSource.class})
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
    @Ignore
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