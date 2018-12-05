package com.jn.news.email.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.news.vo.EmailVo;

/**
 * 发送邮件接口
 *
 * @author： chenm
 * @date： Created on 2018/11/15 15:26
 * @version： v1.0
 * @modified By:
 */
public interface EmailService {

    /**
     * 发送邮件(非模板)
     * @param emailVo
     * @throws JnSpringCloudException
     */
    void sendEmail(EmailVo emailVo) throws JnSpringCloudException;

    /**
     * 发送模板邮件
     * @param emailVo
     * @throws JnSpringCloudException
     */
    void sendEmailByTemplate(EmailVo emailVo) throws JnSpringCloudException;

}
