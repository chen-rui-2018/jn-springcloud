package com.jn.authorization.service.impl;

import com.jn.authorization.dao.PlatformLoginMapper;
import com.jn.authorization.service.PlatformLoginService;
import com.jn.authorization.model.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 平台登录
 * @Author: yangph
 * @Date: 2018/11/21 16:32
 * @Version v1.0
 * @modified By:
 */
@Service
public class PlatformLoginServiceImpl implements PlatformLoginService {
    @Autowired
    private PlatformLoginMapper platformLoginMapper;

    /**
     * 根据用户id获取用户的个人拓展信息和企业拓展信息
     * @param userId 用户id
     * @return
     */
    @Override
    public PlatformUser platformLoginPost(String userId) {
        //todo:建表，生成逆向工程文件，查询数据
        PlatformUser platformUser=new PlatformUser();
        platformUser.setAccount("wangsong1");
        platformUser.setId("100");
        platformUser.setUserId("10000");
        platformUser.setEmail("123@qq.com");
        platformUser.setPassword("123456");
        platformUser.setName("王松1");
        platformUser.setPhone("18888888888");
        return platformUser;
    }
}
