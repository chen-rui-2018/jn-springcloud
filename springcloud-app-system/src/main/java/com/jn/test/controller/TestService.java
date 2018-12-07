package com.jn.test.controller;

import com.jn.common.util.GlobalConstants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * 断路器测试
 *
 * @author： fengxh
 * @date： Created on 2018/12/3 17:36
 * @version： v1.0
 * @modified By:
 */
@Service
public class TestService {


    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService() {
        return  GlobalConstants.SUCCESS_CODE.toString();
    }

    public String hiError() {
        return "hi,sorry,error!";
    }


}
