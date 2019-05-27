package com.jn.park.electric.service;/**
 * @author： huangbq
 * @date： Created on 2019/5/15 13:06
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.park.electricmeter.service.MeterCalcCostService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.system.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xxpay.common.util.DateUtil;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/15
 *</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectricReadingServiceImplTest {
    @Resource
    private MeterCalcCostService meterCalcCostService;
    @Test
    public void meterDataCollection(){
        User user = new User();
        user.setAccount("sss");
        String companyId="";
        Date date = DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
        meterCalcCostService.calcCostEverdayByHandler(user,companyId,date);
    }

}
