package com.jn.enterprise.pay.api;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.model.Result;
import com.jn.pay.api.PayAccountClient;
import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookEntIdOrUserIdParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
/**
 *
 *<pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：${DATE}
 *</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class PayAccountClientTest {
    @Autowired
    private PayAccountClient payAccountClient;

    @Test
    public void queryAccountBook(){
        PayAccountBookEntIdOrUserIdParam param=new PayAccountBookEntIdOrUserIdParam();
        param.setObjId("fbb2cf99e5b5487289b1e341d68980fb");
        param.setObjType("1");
        Result<List<PayAccountBook>> queryAccountBookList= payAccountClient.queryAccountBook(param);
        System.out.println(queryAccountBookList);
    }

}