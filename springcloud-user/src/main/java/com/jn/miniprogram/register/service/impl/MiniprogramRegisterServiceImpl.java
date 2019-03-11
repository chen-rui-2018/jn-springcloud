package com.jn.miniprogram.register.service.impl;

import com.jn.miniprogram.register.service.MiniprogramRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: yangph
 * @Date: 2019/3/11 20:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class MiniprogramRegisterServiceImpl implements MiniprogramRegisterService {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniprogramRegisterServiceImpl.class);

    /**
     * 判断OpenId是否已绑定
     * @param openId 微信用户openId
     * @return 0:未绑定  1：已绑定
     */
    @Override
    public int isBindingOpenId(String openId) {
        //todo:根据openId从微信表中获取信息，若有数据，表明已绑定，否则未绑定
        return 0;
    }
}
