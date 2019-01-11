package com.jn.news.email.controller;

import com.jn.news.email.service.EmailService;
import com.jn.news.vo.EmailInlayImageVo;
import com.jn.news.vo.EmailVo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailTestControllerTest {
    Logger logger = LoggerFactory.getLogger(EmailTestControllerTest.class);

    @Autowired
    private EmailService emailService;

    private static String filePath;

    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:images");
        filePath = file.getPath() + File.separator + "test.png";
    }

    /**
     *
     */
    @Test
    public void emailSenderTester() {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com,shenph@op-mobile.com.cn");
        emailVo.setEmailSubject("主题：简单邮件");
        emailVo.setEmailContent("测试邮件内容");
        String[] fileList = {filePath};
        emailVo.setFiles(fileList);
        emailService.sendEmail(emailVo);
        logger.info("发送成功");
    }

    /**
     * html邮件
     */
    @Test
    public void sendEmail() {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmailSubject("太阳红");
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com,shenph@op-mobile.com.cn");
        String context = "<html><body>你！是我的小星星，挂！在天上放光明。<br><a href='http://www.baidu.com'>百度</a><img src=\"cid:weixin\" ></body></html>";
        emailVo.setEmailContent(context);
        String[] fileList = {filePath};
        emailVo.setFiles(fileList);

        List<EmailInlayImageVo> emailInlayImageVoList = new ArrayList<>();
        EmailInlayImageVo emailInlayImageVo = new EmailInlayImageVo();
        emailInlayImageVo.setImageCid("weixin");
        emailInlayImageVo.setImageUrl(filePath);
        emailInlayImageVoList.add(emailInlayImageVo);
        emailVo.setEmailInlayImageVoList(emailInlayImageVoList);

        emailService.sendEmail(emailVo);

    }

    /**
     * 测试模板邮件
     * @throws IOException
     */
    @Test
    public void sendEmailByTemplate() throws IOException {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmailSubject("太阳红");
        emailVo.setEmail("381981766@qq.com,chenmiao@op-mobile.com.cn,cmddlj2016@163.com,shenph@op-mobile.com.cn");
        emailVo.setTemplatesName("emailTemplateTest");
        Map map = new HashMap();
        map.put("iiiii", "水水水水");
        map.put("jjjjj", "太阳红3333");
        map.put("kkkkk", "哈哈哈哈哈哈哈哈");
        //附件
        String[] fileList = {filePath};
        emailVo.setFiles(fileList);

        map.put("imageResourceName", "imageResourceName");

        emailVo.setTemplatesDataMap(map);
        //内嵌图片List
        List<EmailInlayImageVo> emailInlayImageVoList = new ArrayList<>();
        EmailInlayImageVo emailInlayImageVo = new EmailInlayImageVo();
        emailInlayImageVo.setImageCid("imageResourceName");
        emailInlayImageVo.setImageUrl(filePath);
        emailInlayImageVoList.add(emailInlayImageVo);
        emailVo.setEmailInlayImageVoList(emailInlayImageVoList);

        emailService.sendEmailByTemplate(emailVo);

    }

}