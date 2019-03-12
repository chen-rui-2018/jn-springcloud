package com.jn.oa.email.dao;

import com.jn.oa.email.model.Email;
import com.jn.oa.email.model.EmailPage;

import java.util.List;

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
    List<Email> list(EmailPage emailPage);
}
