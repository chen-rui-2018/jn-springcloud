package com.jn.news.email.service.impl;

import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.news.config.NewsSwitchProperties;
import com.jn.news.email.enums.EmailExceptionEnum;
import com.jn.news.email.service.EmailService;
import com.jn.news.email.utils.EmailComposeMessageHeaderUtil;
import com.jn.news.email.utils.TemplatesUtil;
import com.jn.news.vo.EmailInlayImageVo;
import com.jn.news.vo.EmailVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * 邮件发送实现类
 *
 * @Author： cm
 * @Date： Created on 2018/11/15 15:27
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class EmailServiceImpl implements EmailService {
    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private NewsSwitchProperties newsSwitchProperties;

    /**
     * 模板引擎对象
     */
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 是否HTML邮件
     */
    private boolean IS_HTML = true;
    /**
     * 默认可发送附件
     */
    private static final boolean IS_MULTIPART = true;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * 邮件发送（非模板邮件，支持纯文本、html类型邮件）
     * @param emailVo
     */
    @Override
    public void sendEmail(EmailVo emailVo) {
        //判断是否邮件发送状态，如果是关闭状态则发送至配置的测试邮箱地址
        this.emailSwitchJudge(emailVo);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //消息处理助手对象
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, IS_MULTIPART);
            //设置发件人、收件人、附件信息
            EmailComposeMessageHeaderUtil.composeMessageHeader(sender,emailVo.getEmail().split(","),emailVo.getEmailSubject(),emailVo.getFiles(),helper);
            //设置邮件正文内容
            helper.setText(emailVo.getEmailContent(), IS_HTML);
            //内嵌图片
            List<EmailInlayImageVo> emailInlayImageVoList = emailVo.getEmailInlayImageVoList();
            if(null != emailInlayImageVoList && emailInlayImageVoList.size()>0) {
                emailInlayImageMessage(emailInlayImageVoList,helper);
            }
        } catch (MessagingException e) {
            logger.error("邮件信息构建失败：",e);
            throw new JnSpringCloudException(EmailExceptionEnum.EMAIL_INFO_CREATE_FAIL);
        }
        try {
            mailSender.send(mimeMessage);
            logger.info("\n邮件发送成功,标题:【{}】,收件箱:【{}】",emailVo.getEmailSubject(),emailVo.getEmail());
        } catch (MailException e) {
            logger.error("邮件发送异常：",e);
            throw new JnSpringCloudException(CommonExceptionEnum.EMAIL_ERROR);
        }

    }

    /**
     * 发送普通模板邮件(可带附件)
     * @param emailVo
     */
    @Override
    public void sendEmailByTemplate(EmailVo emailVo) throws JnSpringCloudException{
        //判断是否邮件发送状态，如果是关闭状态则发送至配置的测试邮箱地址
        this.emailSwitchJudge(emailVo);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            //邮件内容
            String emailText = "";
            //是否有内嵌图片
            boolean isInlayImage = false;
            //消息处理助手对象
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, IS_MULTIPART);
            //设置发件人、收件人、附件信息
            EmailComposeMessageHeaderUtil.composeMessageHeader(sender,emailVo.getEmail().split(","),emailVo.getEmailSubject(),emailVo.getFiles(),helper);
            //内嵌图片
            List<EmailInlayImageVo> emailInlayImageVoList = emailVo.getEmailInlayImageVoList();
            if(null != emailInlayImageVoList && emailInlayImageVoList.size()>0) {
                for(EmailInlayImageVo emailInlayImageVo : emailInlayImageVoList) {
                    emailVo.getTemplatesDataMap().put(emailInlayImageVo.getImageCid(),emailInlayImageVo.getImageCid());
                }
                isInlayImage = true;
            }
            //根据模板名称和模板所需的渲染数据得到渲染后的模板内容
            emailText = TemplatesUtil.createTemplates(emailVo.getTemplatesDataMap(),emailVo.getTemplatesName(),templateEngine);
            //设置邮件内容 ，true 表示发送html 格式
            helper.setText(emailText, IS_HTML);
            //判断是否有内嵌图片
            if(isInlayImage) {
                //图片内嵌,必须先setText邮件内容
                emailInlayImageMessage(emailInlayImageVoList,helper);
            }
        } catch (MessagingException e) {
            logger.error("模板邮件信息构建失败",e);
            throw new JnSpringCloudException(EmailExceptionEnum.EMAIL_INFO_CREATE_FAIL);
        }
        //发送邮件
        try {
            mailSender.send(mimeMessage);
            logger.info("\n模板邮件发送成功,标题:【{}】,收件箱:【{}】",emailVo.getEmailSubject(),emailVo.getEmail());
        } catch (MailException e) {
            logger.error("模板邮件发送异常：",e);
            throw new JnSpringCloudException(CommonExceptionEnum.EMAIL_ERROR);
        }
    }

    /**
     * 邮件添加内嵌图片
     * @param emailInlayImageVoList
     */
    private void emailInlayImageMessage(List<EmailInlayImageVo> emailInlayImageVoList,MimeMessageHelper messageHelper) throws MessagingException{
        if(null != emailInlayImageVoList && emailInlayImageVoList.size()>0) {
            for(EmailInlayImageVo emailInlayImageVo : emailInlayImageVoList) {
                if(StringUtils.isNotBlank(emailInlayImageVo.getImageCid())
                        && StringUtils.isNotBlank(emailInlayImageVo.getImageUrl())) {
                    FileSystemResource image = new FileSystemResource(new File(emailInlayImageVo.getImageUrl()));
                    messageHelper.addInline(emailInlayImageVo.getImageCid(), image);
                }
            }
        }
    }

    /**
     * 判断邮件发送状态，如果是关闭状态,则判断邮箱地址是否在配置的测试地址中，没有配置则默认取配置的测试地址的第一个邮箱
     * @param emailVo
     * @return
     */
    public EmailVo emailSwitchJudge(EmailVo emailVo) {
        //防止发送邮件不走mq，故在此判断是否开启邮件发送
        logger.info("\n判断邮件发送开关状态,状态是:【{}】",newsSwitchProperties.getEmail());
        if(!newsSwitchProperties.getEmail()) {
            logger.info("\n邮件发送开关未开启,如有需要请向组长申请开启,测试环境测试可在配置中心springcloud-news文件中配置白名单.");
            //关闭状态，设置邮件接收人
            if(StringUtils.isBlank(newsSwitchProperties.getEmailAddress())) {
                throw new JnSpringCloudException(EmailExceptionEnum.EMAIL_SWITCH_NOTNULL_EMAILADDRESS);
            }
            String[] emails = emailVo.getEmail().split(",");
            StringBuffer newEmailBuffer = new StringBuffer();
            String newEmail;
            for(String email : emails){
                if(newsSwitchProperties.getEmailAddress().indexOf(email)>=0) {
                    newEmailBuffer.append(email);
                    newEmailBuffer.append(",");
                }
            }
            if(newEmailBuffer.length() == 0) {
                newEmail = emails[0];
            }else {
                newEmail = newEmailBuffer.substring(0,newEmailBuffer.length()-1);
            }
            emailVo.setEmail(newEmail);
        }
        return emailVo;
    }

}
