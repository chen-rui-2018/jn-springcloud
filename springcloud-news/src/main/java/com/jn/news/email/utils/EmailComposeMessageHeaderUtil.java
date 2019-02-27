package com.jn.news.email.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;

/**
 * 组合邮件消息头
 *
 * @Author： cm
 * @Date： Created on 2019/2/18 17:00
 * @Version： v1.0
 * @Modified By:
 */
public class EmailComposeMessageHeaderUtil {

    /**
     * 邮件头部信息
     * @param sender 发送者邮箱地址
     * @param recipients 接受邮箱地址
     * @param subject 邮件主题
     * @param attachments 附件,附件为绝对路径
     * @param messageHelper
     * @throws MessagingException
     */
    public static void composeMessageHeader(String sender, String[] recipients, String subject, String[] attachments,
                                      MimeMessageHelper messageHelper) throws MessagingException {
        messageHelper.setFrom(sender);
        messageHelper.setTo(recipients);
        messageHelper.setSubject(subject);
        if (attachments != null) {
            for (String filename : attachments) {
                FileSystemResource file = new FileSystemResource(filename);
                messageHelper.addAttachment(file.getFilename(), file);
            }
        }
    }

}
