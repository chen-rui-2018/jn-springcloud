package com.jn.oa.email.dao;

import com.jn.oa.email.model.EmailPage;
import com.jn.oa.email.vo.EmailVO;

import java.util.List;
import java.util.Map;

/**
 * 一键Emaildao层
 *
 * @author： shaobao
 * @date： Created on 2019/3/11 20:22
 * @version： v1.0
 * @modified By:
 **/
public interface EmailMapper {
    /**
     * 一键Email列表功能
     *
     * @param emailPage 分页条件
     * @return
     */
    List<EmailVO> list(EmailPage emailPage);

    /**
     * 获取邮件任务详情
     *
     * @param emailId
     * @return
     */
    EmailVO getEmailDetails(String emailId);

    /**
     * (逻辑)批量删除邮件任务
     *
     * @param map
     */
    void deleteBatch(Map<String, Object> map);
}
