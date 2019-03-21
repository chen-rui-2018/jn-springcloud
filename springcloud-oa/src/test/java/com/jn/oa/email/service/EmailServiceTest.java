package com.jn.oa.email.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.file.MultipartFileUtil;
import com.jn.oa.email.vo.EmailVO;
import com.jn.oa.email.enums.EmailIsDelayEnums;
import com.jn.oa.email.enums.EmailSendStatusEnums;
import com.jn.oa.email.model.EmailAdd;
import com.jn.oa.email.model.EmailPage;
import com.jn.oa.model.Email;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 一键Email单元测试
 *
 * @author： shaobao
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    private static User user;

    private static EmailAdd emailAdd;

    private static String emailId;


    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");

        emailId = UUID.randomUUID().toString();

        emailAdd = new EmailAdd();
        emailAdd.setId(emailId);
        emailAdd.setWorkOrderNum("CSWORKORDERNUM123");
        emailAdd.setTitle("测试邮件标题");
        emailAdd.setEmailContent("这是测试一键Email的邮件内容");
        emailAdd.setIsDelay(EmailIsDelayEnums.YES.getCode());
        //设置一分钟后定时发送
        emailAdd.setDelaySendTime(new Date(System.currentTimeMillis() + 600000L));
        String[] userAccount = {"liuxiong"};
        emailAdd.setUserAccounts(userAccount);
    }

    /**
     * 测试添加功能,上传功能
     */
    @Test
    public void t001_addOrUpdate() {
        try {
            //1.上传文件
            File file = ResourceUtils.getFile("classpath:zxing/logo.png");
            MultipartFile file1 = MultipartFileUtil.from(file, null);
            List<MultipartFile> files = new ArrayList<MultipartFile>();
            files.add(file1);
            String attachment = emailService.uploadAttachment(files);
            Assert.assertThat(attachment, Matchers.notNullValue(String.class));

            emailAdd.setAttachment(attachment);
            emailService.addOrUpdate(emailAdd, user, true);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试列表查询
     */
    @Test
    public void t002_list() {
        EmailPage page = new EmailPage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = emailService.list(page);
        Assert.assertThat(data, Matchers.anything());
    }

    /**
     * 测试邮件任务详情
     */
    @Test
    public void t003_getEmailDetails() {
        EmailVO data = emailService.getEmailDetails(emailId);
        Assert.assertThat(data, Matchers.notNullValue(EmailVO.class));
    }

    /**
     * 测试邮件任务更新功能及任务定时发送功能
     * 期望结果:
     * 1.修改发送状态为发送成功,邮件不发送
     * 2.修改定时状态为不定时,发送失败
     * 3.修改定时发送时间,发送失败
     * 4.正常发送
     */
    @Test
    public void t004_regularSendEmail() {
        Email email = new Email();
        //1.修改邮件任务发送状态
        emailAdd.setSendStatus(EmailSendStatusEnums.SEND_SUCCESSFULLY.getCode());
        emailService.addOrUpdate(emailAdd, user, false);

        //发送邮件
        EmailVO emailVO = emailService.getEmailDetails(emailId);
        BeanUtils.copyProperties(emailVO, email);
        Boolean result1 = emailService.regularSendEmail(email);
        Assert.assertThat(result1, Matchers.is(Boolean.FALSE));

        //2.修改邮件定时状态
        emailAdd.setSendStatus(EmailSendStatusEnums.NOT_SEND.getCode());
        emailAdd.setIsDelay(EmailIsDelayEnums.NO.getCode());
        emailService.addOrUpdate(emailAdd, user, false);

        Boolean result2 = emailService.regularSendEmail(email);
        Assert.assertThat(result2, Matchers.is(Boolean.FALSE));

        //3.修改定时时间
        emailAdd.setIsDelay(EmailIsDelayEnums.YES.getCode());
        emailAdd.setDelaySendTime(new Date(System.currentTimeMillis() + 300000L));
        emailService.addOrUpdate(emailAdd, user, false);

        Boolean result3 = emailService.regularSendEmail(email);
        Assert.assertThat(result3, Matchers.is(Boolean.FALSE));

        //4.正常发送
        EmailVO emailVO1 = emailService.getEmailDetails(emailId);
        BeanUtils.copyProperties(emailVO1, email);
        Boolean result4 = emailService.regularSendEmail(email);
        Assert.assertThat(result4, Matchers.is(Boolean.TRUE));
    }

    @Test
    public void t005_sendEmailManual() {
        try {
            emailService.sendEmailManual(emailId, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }


    @Test
    public void t006_deleteBatch() {
        String[] emailIds = {emailId};
        emailService.deleteBatch(emailIds, user);
    }
}