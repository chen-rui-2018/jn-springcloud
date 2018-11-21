package com.jn.news.email.controller;

import com.jn.news.api.EmailClient;
import com.jn.news.vo.EmailInlayImageVo;
import com.jn.news.vo.EmailVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EamilTestControllerTest {
    Logger logger = LoggerFactory.getLogger(EamilTestControllerTest.class);

    @Autowired
    private EmailClient emailClient;

    @Value("${spring.mail.username}")
    private String Sender;

    /**
     * 测试时请在D盘放一张12.png的图片
     */
    @Test
    public void emailSenderTester() {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com");
        emailVo.setEmailSubject("主题：简单邮件");
        emailVo.setEmailContent("测试邮件内容");
        String[] fileList = {"D:/12.png"} ;
        emailVo.setFiles(fileList);
        emailClient.sendEmail(emailVo);
        logger.info("发送成功");
    }

    /**
     * html邮件
     * 测试时请在D盘放一张12.png的图片
     */
    @Test
    public void sendEmail() {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmailSubject("太阳红");
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com");
        String context = "<html><body>你！是我的小星星，挂！在天上放光明。<br><a href='http://www.baidu.com'>百度</a><img src=\"cid:weixin\" ></body></html>";
        emailVo.setEmailContent(context);
        String[] fileList = {"D:/12.png"} ;
        emailVo.setFiles(fileList);

        List<EmailInlayImageVo> emailInlayImageVoList = new ArrayList<>();
        EmailInlayImageVo emailInlayImageVo = new EmailInlayImageVo();
        emailInlayImageVo.setImageCid("weixin");
        emailInlayImageVo.setImageUrl("D:/12.png");
        emailInlayImageVoList.add(emailInlayImageVo);
        emailVo.setEmailInlayImageVoList(emailInlayImageVoList);

        emailClient.sendEmail(emailVo);

    }

    /**
     * 测试模板邮件
     * 测试时请在D盘放一张12.png的图片
     */
    @Test
    public void sendEmailByTemplate() throws IOException {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmailSubject("太阳红");
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com");
        emailVo.setTemplatesName("emailTemplateTest");
        Map map = new HashMap();
        map.put("iiiii","水水水水");
        map.put("jjjjj","太阳红3333");
        map.put("kkkkk","哈哈哈哈哈哈哈哈");
        //附件
        String[] fileList = {"D:/测试.png"} ;
        emailVo.setFiles(fileList);

        map.put("imageResourceName","imageResourceName");

        emailVo.setTemplatesDataMap(map);
        //内嵌图片List
        List<EmailInlayImageVo> emailInlayImageVoList = new ArrayList<>();
        EmailInlayImageVo emailInlayImageVo = new EmailInlayImageVo();
        emailInlayImageVo.setImageCid("imageResourceName");
        emailInlayImageVo.setImageUrl("D:/12.png");
        emailInlayImageVoList.add(emailInlayImageVo);
        emailVo.setEmailInlayImageVoList(emailInlayImageVoList);
        emailClient.sendEmailByTemplate(emailVo);

    }

}