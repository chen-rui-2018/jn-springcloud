package com.jn.oa.email.service;

import com.jn.common.model.PaginationData;
import com.jn.oa.email.model.EmailAdd;
import com.jn.oa.email.model.EmailPage;
import com.jn.oa.email.vo.EmailVO;
import com.jn.oa.model.Email;
import com.jn.system.model.User;

/**
 * 一键EmailService层
 *
 * @author： shaobao
 * @date： Created on 2019/3/9 11:26
 * @version： v1.0
 * @modified By:
 **/
public interface EmailService {

    /**
     * 查看邮件任务详情功能
     *
     * @param emailId 邮件任务id
     * @return
     */
    EmailVO getEmailDetails(String emailId);

    /**
     * 一键Email添加/编辑功能
     *
     * @param emailAdd 一键Email增加实体
     * @param user     当前登录用户
     * @param isAdd    是否是添加操作
     */
    void addOrUpdate(EmailAdd emailAdd, User user, Boolean isAdd);

    /**
     * 一键Email定时发送的回调接口
     *
     * @param email
     */
    Boolean regularSendEmail(Email email);

    /**
     * 用户手动一键发送邮件任务功能
     *
     * @param emailId 邮件任务id
     * @param user    当前登录用户
     */
    void sendEmailManual(String emailId, User user);

    /**
     * 一键Email列表功能
     *
     * @param emailPage 分页条件
     * @return
     */
    PaginationData list(EmailPage emailPage);

    /**
     * (逻辑)批量删除邮件任务
     *
     * @param emailIds 邮件任务Id数组
     * @param user     当前登录用户
     */
    void deleteBatch(String[] emailIds, User user);
}
