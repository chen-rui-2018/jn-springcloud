package com.jn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/schedule")
public class TestController  {
    @RequestMapping(value = "/getTestData")
    public String  test() {
    	return "hello world";
    }
}
