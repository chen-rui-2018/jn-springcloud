package com.jn.news.api;

import com.jn.common.model.Result;
import com.jn.news.vo.EmailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 邮件发送客户端
 *
 * @Author： cm
 * @Date： Created on 2018/11/15 15:00
 * @Version： v1.0
 * @Modified By:
 */

@FeignClient("springcloud-news")
public interface EmailClient {

    /**
     * 发送邮件
     * @param emailVo
     * @return
     */
    @RequestMapping(value = "/api/news/email/sendEmail", method = RequestMethod.POST)
    Result sendEmail(@RequestBody EmailVo emailVo);

    /**
     * 发送模板邮件
     * @param emailVo
     * @return
     */
    @RequestMapping(value = "/api/news/email/sendEmailByTemplate", method = RequestMethod.POST)
    Result sendEmailByTemplate(@RequestBody EmailVo emailVo);
}
