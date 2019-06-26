package com.jn.oa.dingTalk.service;



import com.jn.oa.model.AddressBookNotice;

/**
 * @author： yuanyy
 * @date： Created on 2019/4/16 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface DingTalkUserService {

    /**
     * 批量更新钉钉用户表
     * @return
     */
    void batchInsertDingTalkUser();

    /**
     * 更新用户信息
     * @param addressBookNotice
     */
    void updateOrInsertDingTalkUser(AddressBookNotice addressBookNotice);


}
