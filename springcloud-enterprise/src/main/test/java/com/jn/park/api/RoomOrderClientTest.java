package com.jn.park.api;/**
 * @author： huangbq
 * @date： Created on 2019/5/17 15:33
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.model.Result;
import com.jn.pay.model.PayOrderNotify;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/17
 *</pre>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomOrderClientTest {
    @Autowired
    private RoomOrderClient roomOrderClient;

    @Test
    public void payCallBack(){
        PayOrderNotify payOrderNotify=new PayOrderNotify();
        payOrderNotify.setPayOrderId("05bd1428-2c8b-437c-b");
        Result result=roomOrderClient.payCallBack(payOrderNotify);
        Assert.assertEquals(result.getCode(),"0000");
    }
}
