package com.jn.test.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 1,配置更新测试，如果需要动态更新的配置文件，需要加入@RefreshScope注解
 *2,缓存测试
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@RestController
public class TestController extends BaseController {

    

    @Autowired
    private RedisCacheFactory redisCacheFactory;
    
    @Autowired
    private TestDomain testDomain;

    @RequestMapping(value = "/guest/test")
    public Result<String> test() {
        return new Result(testDomain.getTest());
    }

    @RequestMapping(value = "/guest/test1")
    public Result<Integer> test1() {
        Cache<Integer> cache =redisCacheFactory.getCache("yanzhengma");
        if (cache==null) {
            return new Result(testDomain.getMis());
        }
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.put("yanzhengma1",cache.get("yanzhengma1"));
        hashMap.put("size",cache.size());
        return new Result(hashMap);
    }

    @RequestMapping(value = "/guest/test2")
    public Result<Integer> test2() {
        Cache<Integer> cache =redisCacheFactory.initCache("yanzhengma",testDomain.getMis());
        cache.put("yanzhengma1",testDomain.getMis());
        cache.put("yanzhengma2",testDomain.getMis());
        return new Result(GlobalConstants.SUCCESS_CODE);
    }


}
