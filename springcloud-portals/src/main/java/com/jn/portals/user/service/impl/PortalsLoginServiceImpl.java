package com.jn.portals.user.service.impl;

import com.jn.portals.model.PortalsUser;
import com.jn.portals.user.dao.PortalsLoginMapper;
import com.jn.portals.user.service.PortalsLoginService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 平台登录
 * @Author: yangph
 * @Date: 2018/11/28 9:41
 * @Version v1.0
 * @modified By:
 */
@Service
public class PortalsLoginServiceImpl implements PortalsLoginService {
    /**
     * 日志组件
     */
    Logger logger= LoggerFactory.getLogger(PortalsLoginServiceImpl.class);

    @Autowired
    private PortalsLoginMapper portalsLoginMapper;

    /**
     * 根据用户账号获取用户的个人拓展信息和企业拓展信息
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "获取用户扩展信息")
    @Override
    public List<PortalsUser> getUserOutreachInfo(String account) {
        //todo:建表，生成逆向工程文件，查询数据
        PortalsUser portalsUser =new PortalsUser();
        portalsUser.setAccount("wangsong1");
        portalsUser.setId("100");
        portalsUser.setUserId("10000");
        portalsUser.setEmail("123@qq.com");
        portalsUser.setPassword("123456");
        portalsUser.setName("王松1");
        portalsUser.setPhone("18888888888");
        List<PortalsUser> list=new ArrayList<>();
        list.add(portalsUser);
        return list;
    }
}
