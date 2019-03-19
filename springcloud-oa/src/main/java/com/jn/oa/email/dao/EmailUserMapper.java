package com.jn.oa.email.dao;

import com.jn.oa.email.entity.TbOaEmailUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 一键Email邮件接收人dao
 *
 * @author： shaobao
 * @date： Created on 2019/3/9 17:16
 * @version： v1.0
 * @modified By:
 **/
public interface EmailUserMapper {

    /**
     * 批量添加邮件接收人
     *
     * @param emailUserList
     */
    void insertBatch(List<TbOaEmailUser> emailUserList);

    /**
     * 根据邮件任务id批量删除对应用户
     *
     * @param emailId     一键emailID
     * @param userAccount 最新更新人账号
     */
    void deleteBatchByEmaiilId(@Param("emailId") String emailId, @Param("userAccount") String userAccount);

    /**
     * 获取邮件任务的所有接收人邮箱
     *
     * @param eamilId
     * @return
     */
    String getUserEmailInfo(String eamilId);

    /**
     * 批量删除一键Email的接受人信息
     *
     * @param map
     */
    void deleteBatch(Map<String, Object> map);
}
