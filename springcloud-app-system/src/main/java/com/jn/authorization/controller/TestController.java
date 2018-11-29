package com.jn.authorization.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置更新测试，如果需要动态更新的配置文件，需要加入@RefreshScope注解
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@RestController
@RefreshScope
public class TestController extends BaseController {

    @Value("${test}")
    private String test;

    @RequestMapping(value = "/guest/test")
    public Result<String> test() {
        return new Result(test);
    }

}
