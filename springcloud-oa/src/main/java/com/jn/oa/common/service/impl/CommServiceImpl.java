package com.jn.oa.common.service.impl;

import com.jn.common.util.DateUtils;
import com.jn.oa.common.service.CommService;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 协同办公公共业务层
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 16:33
 * @version： v1.0
 * @modified By:
 **/
@Service
public class CommServiceImpl implements CommService {

    /**
     * 获取工单编码
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取工单编码")
    public String getOrderNum() {
        String time = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        String orderNum = RandomStringUtils.randomNumeric(6) + time;
        return orderNum;
    }
}
