package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.enterprise.servicemarket.advisor.model.AdvisorServiceInfo;
import com.jn.enterprise.servicemarket.advisor.model.InviteAdvisorInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 顾问管理
 * @Author: yangph
 * @Date: 2019/2/19 16:18
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorManagementServiceImpl implements AdvisorManagementService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementServiceImpl.class);

    /**
     * 邀请顾问
     * @param inviteAdvisorInfo  邀请顾问入参（被邀请人和邀请人账号）
     */
    @Override
    @ServiceLog(doAction = "邀请顾问")
    public void inviteAdvisor(InviteAdvisorInfo inviteAdvisorInfo) {
        //1.往顾问信息表添加一条机构和顾问的信息
        AdvisorServiceInfo advisorServiceInfo=new AdvisorServiceInfo();

        advisorServiceInfo.setAdvisorAccount(inviteAdvisorInfo.getRegisterAccount());
        //2.调用消息接口，向被邀顾问发送短信或邮件（顾问可通过信息中的链接直接跳转到接收机构邀请页面）
    }
}
