package com.jn.news.server;

import com.jn.common.controller.BaseController;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.news.api.EmailClient;
import com.jn.news.email.service.EmailService;
import com.jn.news.vo.EmailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供内部使用的API接口
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@RestController
public class EmailController extends BaseController implements EmailClient {

    private static Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    /**
     * 发送邮件
     *
     * @param emailVo
     * @return
     */
    @Override
    public Result sendEmail(@RequestBody @Validated EmailVo emailVo) {
        logger.info("进入发送邮件的API,用户参数：{}", emailVo);
        Result result = new Result();
        try {
            Assert.notNull(emailVo.getEmail(), "收件箱不能为空");
            Assert.notNull(emailVo.getEmailSubject(), "邮件主题不能空");
            Assert.notNull(emailVo.getEmailContent(), "邮件内容不能空");
            emailService.sendEmail(emailVo);
            logger.info("邮件发送成功,主题{},收件人{}", emailVo.getEmailSubject(), emailVo.getEmail());
        } catch (JnSpringCloudException e) {
            logger.error("邮件发送失败", e);
            result.setCode(e.getCode());
            result.setResult(e.getMsg());
        } catch (Exception e) {
            logger.error("邮件发送异常", e);
            result.setCode(CommonExceptionEnum.EMAIL_ERROR.getCode());
            result.setResult("邮件发送异常");
        }
        return result;
    }

    /**
     * 发送模板邮件
     *
     * @param emailVo
     * @return
     */
    @Override
    public Result sendEmailByTemplate(@RequestBody @Validated EmailVo emailVo) {
        logger.info("进入发送模板邮件的API,用户参数：{}", emailVo);
        Result result = new Result();
        try {
            Assert.notNull(emailVo.getEmail(), "收件箱不能为空");
            Assert.notNull(emailVo.getEmailSubject(), "邮件主题不能空");
            Assert.notNull(emailVo.getTemplatesName(), "邮件模板名称不能空");
            emailService.sendEmailByTemplate(emailVo);
            logger.info("模板邮件发送成功,主题{},收件人{}", emailVo.getEmailSubject(), emailVo.getEmail());
        } catch (JnSpringCloudException e) {
            logger.error("邮件发送失败", e);
            result.setCode(e.getCode());
            result.setResult(e.getMsg());
        } catch (Exception e) {
            logger.error("邮件发送异常", e);
            result.setCode(CommonExceptionEnum.EMAIL_ERROR.getCode());
            result.setResult("邮件发送异常");
        }
        return result;
    }

}
