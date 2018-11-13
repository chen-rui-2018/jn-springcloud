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
@RequestMapping("/guest/schedule")
public class TestController  {
    @RequestMapping(value = "/getTestData")
    public String  test() {

        System.out.println("no hello world");
    	return "no hello world";
    }
}
